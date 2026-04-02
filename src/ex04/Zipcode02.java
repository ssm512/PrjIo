package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode02 {

	public static void main(String[] args) throws IOException {
		//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 2.(읍면동 건물명:) 입력받아 출력
		// 키보드 입력
		Scanner					in			=	new	Scanner(System.in);
				
		// 파일 조작하면 path부터
		String					path		=	Zipcode02.class.getResource("").getPath();
		String					fname		=	"zipcode_utf8.csv";
		File					file		=	new	File(path + fname); // file instance로 File객체를 만들어라
		
		FileReader				fr			=	new	FileReader(file);	//	file instance를 읽는 FileReader객체를 fr instance로
		BufferedReader			br			=	new	BufferedReader(fr);	// BufferedReader 꼭 넣어줘야 됨 안그러면 한줄한줄 읽어와야됨. 부담됨
		
		br.readLine();			// 제목줄 skip // readLine이 enter를 뜻함 // enter앞까지 읽음 그리고 한줄 다 읽으면 다음줄로 point 옮김 // 
		String					title		=	br.readLine();
		String					line		=	"";
		int						cnt			=	0;
		System.out.println("읍면동 건물명:");
		String					inAddr		=	in.nextLine();
		
		while( (line = br.readLine()) != null ) {	//	버퍼 한줄 읽은게 line인데, line이 null이 아닐동안 반복한다 // null은 stack memory에서 빈 주소 임
			//zipcode,sido,gugun,dong,bunji,seq
			String	[]	li					=	line.trim().split(",");
			String		zipcode				=	li[0].trim();
			String		sido				=	li[1].trim();
			String		gugun				=	li[2].trim();
			String		dong				=	li[3].trim();
			String		bunji				=	li[4].trim();
			int			seq					=	Integer.parseInt(li[5].trim());
			// 2.(읍면동 건물명:) 입력받아 출력

			if (dong.indexOf(inAddr) > -1) { // indexOf 사용 // 정규식표현방법으로 찾아도 되고
				String	fmt					=	"%s %s %s %s %s %d\n";
				String	addr				=	String.format(fmt, zipcode, sido, gugun, dong, bunji, seq);
				System.out.println(addr);
				cnt++;
			} // if문 end
		} //while 문 end
		System.out.println(cnt + "건");
		
		br.close();
		fr.close();

	} // main end

} // class Zipcode01 end
