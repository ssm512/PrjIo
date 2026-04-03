package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ZipCode05 {

	public static void main(String[] args) throws IOException { // void type : return이 없는거
		// 4. 한국의 시도명 출력 - 17건
		//		   서울
		//		   부산
		//		   ... 
		//		   충북
		String			path		=	ZipCode05.class.getResource("").getPath(); // "" resource(파일)가 있는 위치를 찾는거임
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
		
		long		startTime		=	System.nanoTime(); // 현재 컴퓨터 시간을 읽어옴
		
		HashSet<String>	set			=	new	HashSet<> ();	//	무정렬
		// TreeSet<String>	set			=	new	TreeSet<> (); // 가나다라 순으로 sorting됨
		
		while( ( line=br.readLine() ) != null) {
			PostVo		vo		=	new	PostVo( line );
			String		sido	=	vo.getSido();
			set.add(sido);
			//System.out.println(vo);
			totcnt++;
		}// while end
		long		endTime		=	System.nanoTime(); // 현재 컴퓨터 시간을 읽어옴
		double		execTime	=	(endTime		-	startTime)/1000.0/1000.0/1000.0;
		br.close();		
		fr.close();
		for (String sido : set) {
			System.out.println(sido);
		}
		System.out.println("시도가지수: " + set.size());
		System.out.println("전체자료수 : " + totcnt);
		System.out.println("실행시간 : " + execTime + "s");
		
	}	// main end

} // class ZipCode05 end
