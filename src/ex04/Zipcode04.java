package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode04 {

	public static void main(String[] args) throws IOException {
		//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 3. 부산, 울산, 대구 우편번호
		// 키보드 입력
		Scanner 				in			=	new	Scanner(System.in);
		System.out.println("검색할 시도를 입력하세요:ex)부산, 대구, 경남");
		String					sidos		=	in.nextLine(); //부산, 대구, 경남
		String		[]			sis			=	sidos.trim().split(",");
		String		[]			sidoList	=	new	String[sis.length];
		int			[]			cnt			=	new int[sis.length];
		for (int i = 0; i < sidoList.length; i++) { // sidoList에 sis[i].trim() 한걸 넣어줌
			//sis[i]			=	sis[i].trim();
			sidoList[i]		=	sis[i].trim();
			cnt[i]			=	0;
		} 
		
		// 파일 조작하면 path부터
		String					path		=	Zipcode04.class.getResource("").getPath();
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
		
		
		while( (line = br.readLine()) != null ) {	//	버퍼 한줄 읽은게 line인데, line이 null이 아닐동안 반복한다 // null은 stack memory에서 빈 주소 임
			//zipcode,sido,gugun,dong,bunji,seq
			String	[]	li					=	line.trim().split(",");
			String		zipcode				=	li[0].trim();
			String		sido				=	li[1].trim();
			String		gugun				=	li[2].trim();
			String		dong				=	li[3].trim();
			String		bunji				=	li[4].trim();
			int			seq					=	Integer.parseInt(li[5].trim());
			// 3. 부산, 울산, 경남 우편번호
			//			sis			cnt
			//			부산		cnt[0]
			//			울산		cnt[1]
			//			경남		cnt[2]
			for (int i = 0; i < sis.length; i++) {
				if (sido.equals(sidoList[i])) {
					cnt[i]++;
				}
			}
			
		} //while 문 end
		for (int i = 0; i < sis.length; i++) {
			System.out.println(sis[i]+": " + cnt[i] + "건");
		}
		br.close();
		fr.close();

	} // main end

} // class Zipcode01 end
