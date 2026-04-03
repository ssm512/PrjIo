package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ZipCode06 {

	public static void main(String[] args) throws IOException {
		// 6.부산의 부전2동 우편번호만 출력
		String				path		=	ZipCode06.class.getResource("").getPath();
		String				fname		=	"zipcode_utf8.csv";
		File				inFile		=	new	File( path + fname );
		if ( !(inFile.exists()) ) {
			System.out.println(inFile + "파일이 없어요");
			System.exit(-1);
		}
		FileReader			fr			=	new	FileReader(inFile);
		BufferedReader		br			=	new	BufferedReader(fr);
		br.readLine(); // 첫번째 줄 skip
		String				line		=	"";
		
		while ((line=br.readLine()) != null) {
			PostVo 			vo			=	new PostVo(line);
			String			dong		=	vo.getDong();
			String			zipcode		=	vo.getZipcode();
			
			if (dong.contains("부전2동")) {
				System.out.println(zipcode);
			}// if end
		} // while end
		br.close();
		fr.close();

	} // main end

} // class ZipCode06 end
