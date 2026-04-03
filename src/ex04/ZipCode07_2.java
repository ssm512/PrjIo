package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode07_2 {

	public static void main(String[] args) {
		String			path		=		ZipCode07_2.class.getResource("").getPath();
		// String		path		=		"D:\dev\java\PrjIo\src\ex04";
		String			inFname		=		"zipcode_utf8.csv";
		String			outFname	=		"zipcode_busanjingu.csv";
		FileReader 		fr			=		null;
		FileWriter		fw			=		null;
		BufferedReader	br			=		null;
		BufferedWriter	bw			=		null;
		
		// 7.부산 부산진구의 우편번호를 파일( .csv )로 출력
	
		
		
		try {
			fr						=		new	FileReader(path + inFname);
			fw						=		new FileWriter(path + outFname);
			
			br						=		new BufferedReader(fr);
			bw						=		new	BufferedWriter(fw);
			
			br.readLine();
			String		line			=		"";
			while ((line = br.readLine()) != null) {
				PostVo		postVo		=	new	PostVo(line);
				String		sido		=	postVo.getSido();
				String		gugun		=	postVo.getGugun();
				
				if (sido.equals("부산")) {
					if	(gugun.contains("진구")) {
						String		result		=	postVo.getAddress();
						System.out.println(result);
						bw.write(result+"\n");		//	결과 bin에 저장됨
					} // if end 
				} // if end
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
		} // finally end
		

	} // main end

} // class ZipCode07_2 end
