package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode03 {

	public static void main(String[] args) throws IOException {
		//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 3. 부산, 울산, 대구 우편번호
		
		// 파일 조작하면 path부터
		String					path		=	Zipcode03.class.getResource("").getPath();
		String					fname		=	"zipcode_utf8.csv";
		File					file		=	new	File(path + fname); // file instance로 File객체를 만들어라
		if (!file.exists()) {
			System.out.println(file + "이 없습니다.");
			System.exit(-1); //프로그램 강제종료 , return은 해당 함수만 끝내는거지만
		} // File class안에 file이 있는 확인하는거,
		
		FileReader				fr			=	new	FileReader(file);	//	file instance를 읽는 FileReader객체를 fr instance로
		BufferedReader			br			=	new	BufferedReader(fr);	// BufferedReader 꼭 넣어줘야 됨 안그러면 한줄한줄 읽어와야됨. 부담됨
		
		br.readLine();			// 제목줄 skip // readLine이 enter를 뜻함 // enter앞까지 읽음 그리고 한줄 다 읽으면 다음줄로 point 옮김 // 
		String					title		=	br.readLine();
		String					line		=	"";
		int						cnt1		=	0;	//	부산
		int						cnt2		=	0;	//	대구
		int						cnt3		=	0;	//  울산
		
		
		while( (line = br.readLine()) != null ) {	//	버퍼 한줄 읽은게 line인데, line이 null이 아닐동안 반복한다 // null은 stack memory에서 빈 주소 임
			//zipcode,sido,gugun,dong,bunji,seq
			String	[]	li					=	line.trim().split(",");
			String		zipcode				=	li[0].trim();
			String		sido				=	li[1].trim();
			String		gugun				=	li[2].trim();
			String		dong				=	li[3].trim();
			String		bunji				=	li[4].trim();
			int			seq					=	Integer.parseInt(li[5].trim());
			// 3. 부산, 울산, 대구 우편번호
			switch (sido) {
			case "부산": cnt1++; break;
			case "대구": cnt2++; break;
			case "울산": cnt3++; break;
			} // switch (sido) end
		} //while 문 end
		System.out.println("부산: " + cnt1 + "건");
		System.out.println("대구: " + cnt2 + "건");
		System.out.println("울산: " + cnt3 + "건");
		
		br.close();
		fr.close();

	} // main end

} // class Zipcode01 end
