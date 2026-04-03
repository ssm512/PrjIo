package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode07 {

	public static void main(String[] args) throws IOException {
		// 7.부산 부산진구의 우편번호를 파일( .csv )로 출력
		// zipcode,sido,gugun,dong,bunji,seq
		String				path		=	ZipCode07.class.getResource("").getPath();
		String				fname		=	"zipcode_utf8.csv";
		File				inFile		=	new	File( path + fname );
		if ( !(inFile.exists()) ) {
			System.out.println(inFile + "파일이 없어요");
			System.exit(-1);
		}
		FileReader			fr			=	new	FileReader(inFile);
		BufferedReader		br			=	new	BufferedReader(fr);
		String				rfname		=	"result_zipcode_utf8.csv";
		File				outFile		=	new	File(path + rfname);
		FileWriter			fw			=	new	FileWriter(outFile);
		BufferedWriter		bw			=	new	BufferedWriter(fw);
		
		
		br.readLine(); // 첫번째 줄 skip
		String				line		=	"";
		String				title		=	"부산 부산진구의 우편번호\n";
		bw.write(title);
		
		while ((line=br.readLine()) != null) {
			PostVo 			vo			=	new PostVo(line);
			String			gugun		=	vo.getGugun();
			String			zipcode		=	vo.getZipcode();
			if (gugun.contains("부산진구")) {
				System.out.println(zipcode);
				String			fmt			=	"%s\n";
				String			result		=	String.format(fmt, zipcode);
				bw.write(result);				
			}// if end
		} // while end
		br.close();
		fr.close();
		bw.close();
		fw.close();
	} // main end

} // class ZipCode06 end
