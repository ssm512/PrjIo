package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZipCode06_2 {

	public static void main(String[] args){
		String				fn			=	"D:/dev/java/PrjIo/src/ex04/zipcode_utf8.csv";
		FileReader		fr = null; // 중괄호 밖에서 변수를 만들고
		BufferedReader	br = null; // finally에서 close()를 하기 위해 밖에서 변수 선언
		try {
			fr	= 	new FileReader(fn);	//	파일을 여는
			br	=	new	BufferedReader(fr); // 버퍼에
			
			// 파일 열고 할 행동들
			br.readLine(); // 제목줄 skip
			String		line	=	"";
			while ( (line=br.readLine()) !=null ) {
				PostVo	postVo	=	new PostVo(line);
				String	sido	=	postVo.getSido();
				String	dong	=	postVo.getDong();
				
				if (sido.equals("부산") && dong.contains("부전2동") ) {
					System.out.println(postVo);
				} // if end
			} //while end
			
			
			
		} catch (FileNotFoundException e) { // file not found execption 일때 이 행동을 해라
			//e.printStackTrace();
			System.out.println(fn + "파일이 없습니다.");
		} catch (IOException e) { // br.readLine(); 에 대한, 입출력하다가 문제가 발생했음
			//e.printStackTrace();
			System.out.println("데이터 입력에 문제가 있습니다.");
		} catch (Exception e) {
			System.out.println("문제발생:" + e.getMessage());
		} finally { // Exception 발생과 상관없이 무조건 실행
			try { // null이 아닐때 close
				if (br !=null) br.close();	
				if (fr !=null) fr.close();			
			} catch (IOException e) { // io execption 일때 
			}
		}// finally end
		
		System.out.println("작업끝");
		
	}

} // class ZipCode06_2 end
