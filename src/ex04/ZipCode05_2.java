package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class ZipCode05_2 {

	public static void main(String[] args) throws IOException { // void type : return이 없는거
		// 4. 한국의 시도명 출력 - 17건
		//		   서울   8080  // 8080 어떻게 찍는지 생각해보기, linecount, arraylist 2개 가 힌트
		//		   부산   3605
		//		   ... 
		//		   충북
		String			path		=	ZipCode05_2.class.getResource("").getPath(); // "" resource(파일)가 있는 위치를 찾는거임
		String			fname		=	"zipcode_utf8.csv";
		File			inFile		=	new	File(path + fname);
		if (!inFile.exists()) {
			System.out.println(fname + "파일이 없습니다.");
			System.exit(-1);
		}
		
		FileReader		fr			=	new	FileReader(inFile);
		BufferedReader	br			=	new	BufferedReader(fr);
		br.readLine();  // 제목줄 건너뛰기 skip
		String		line			=	"";
		int 		totcnt			=	0;
		String		prevSido		=	"";
		
		long		startTime		=	System.nanoTime(); // 현재 컴퓨터 시간을 읽어옴
		
		int			cnt				=	0;
		while( ( line=br.readLine() ) != null) {
			PostVo		vo		=	new	PostVo( line );
			String		sido	=	vo.getSido();
			if (!sido.equals(prevSido)) {
				prevSido		=	sido;
				System.out.println(sido);
				cnt++;
			} // if end
			//System.out.println(vo);
			
			totcnt++;
		}// while end
		long		endTime		=	System.nanoTime(); // 현재 컴퓨터 시간을 읽어옴
		double		execTime	=	(endTime		-	startTime)/1000.0/1000.0/1000.0;
		br.close();		
		fr.close();
		System.out.println("도시수 : " + cnt);
		System.out.println("전체자료수 : " + totcnt);
		System.out.println("실행시간 : " + execTime + "s");
		
	}	// main end

} // class ZipCode05 end
