package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode08_2 {

	public static void main(String[] args) {
		String			path		=		ZipCode08_2.class.getResource("").getPath();
		// String		path		=		"D:\dev\java\PrjIo\src\ex04";
		String			inFname		=		"zipcode_utf8.csv";
		String			outFname	=		"";
		FileReader 		fr			=		null;
		FileWriter		fw			=		null;
		BufferedReader	br			=		null;
		BufferedWriter	bw			=		null;
		int				cnt			=		0;
		try {
			fr						=		new	FileReader(path + inFname);
			br						=		new BufferedReader(fr);
			br.readLine();
			String		line			=		"";
			String		prevSido		=		"";
			while ((line = br.readLine()) != null) {
				PostVo		postVo		=	new	PostVo(line);
				String		sido		=	postVo.getSido();
				
				if	( !sido.equals(prevSido) ) {
					if ( bw != null) { bw.close(); }
					if ( fw != null) { fw.close(); }
					
					outFname				=	path + sido + ".csv";
					File		oFile		=	new	File( outFname );
					if (oFile.exists()) { oFile.delete(); }
					fw						=	new FileWriter(oFile, true);	//	true : append
					bw						=	new	BufferedWriter(fw);
					prevSido				=	sido;
					cnt++;
				}
				bw.write(postVo.getAddress() + "\n");
			} // while end
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (bw != null) bw.close();
				if (fr != null) fr.close();
				if (fw != null) fw.close();
				
			} catch (IOException e) {				
			}
		} // finally end, try/catch end
		System.out.println(cnt + "개 파일 생성");

	} // main end

} // class ZipCode07_2 end
