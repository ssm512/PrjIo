package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//8.	 zipcode_utf8.csv
//-> 서울.csv
//   부산.csv
//   
//   ...
//   충북.csv      

public class ZipCode08 {

	public static void main(String[] args) throws IOException {
		String		path			=	ZipCode08.class.getResource("").getPath();
		String		fname			=	"zipcode_utf8.csv";	
		File		inFile			=	new	File(path + fname);
		FileReader		fr			=	new	FileReader(inFile);
		BufferedReader	br			=	new	BufferedReader(fr);
		String			line		=	"";
		String			prevSido	=	"";	
		br.readLine(); // 첫줄 skip
		
		while (( line = br.readLine() ) != null ) {
			PostVo 		vo 			=	 new	PostVo(line);
			String		sido		=		vo.getSido();
			String		rname		=	sido+".csv";
			
			if (!sido.equals(prevSido)) { // prevSido 가 다르면 그때부터 다른 파일에 저장하여라
				prevSido		=	sido;
				System.out.println(sido);				
				File	outFile		=	new	File(path+rname);
				FileWriter	fw		=	new FileWriter(outFile);
				BufferedWriter bw	=	new	BufferedWriter(fw);
				bw.write(line);
				bw.close();
				fw.close();
			} // if end

		} // while end
		
		br.close();
		fr.close();
		
		
		//while () {}

	} // main end

} // class ZipCode08 end
