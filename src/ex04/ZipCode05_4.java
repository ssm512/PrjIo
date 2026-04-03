package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

// 4. 한국의 시도명 출력 - 17건
//		   서울   8080  // 8080 어떻게 찍는지 생각해보기, linecount, arraylist 2개 가 힌트
//		   부산   3605
//		   ... 
//		   충북

interface Ipo {
	void		input(String fname) throws FileNotFoundException, IOException;
	void		process();
	void		output();
} // interface Ipo end

class	ZipcodeMap implements Ipo {
	
	FileReader					fr;
	BufferedReader				 br;
	Map<String, Integer> 		sidoMap	=	new	TreeMap<>();
	int							totCnt	=	0;
	
	@Override
	public void input(String fname) throws IOException {
		fr								=	new	FileReader(fname);
		br								=	new	BufferedReader(fr);
		br.readLine();
		String		line				=	"";
		while ( (line=br.readLine()) != null ) {
			PostVo		vo				=	new	PostVo(line);
			String		sido			=	vo.getSido();
			sidoMap.put(sido, sidoMap.getOrDefault(sido, 0) + 1 );
			totCnt++;
		} //while end
		
		br.close();
		fr.close();
		
	} // input() end

	
	@Override
	public void process() {
		
		
	} // process() end

	@Override
	public void output() {
		for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
			String key = sidoList.getKey();
			Integer val = sidoList.getValue();
			
			System.out.println(key + "=" + val);
		}
		System.out.println("총 주소수 : " + totCnt);
	} // output() end
} // class	ZipcodeMap end

public class ZipCode05_4  {
	// Map 사용
	public static void main(String[] args) throws IOException { // void type : return이 없는거
		ZipcodeMap zMap	=	new	ZipcodeMap();
		String		path		=	ZipcodeMap.class.getResource("").getPath();
		String		fname		=	"zipcode_utf8.csv";
		
		zMap.input(path + fname);
		zMap.process();
		zMap.output();
		
		}	// main end

} // class ZipCode05 end
