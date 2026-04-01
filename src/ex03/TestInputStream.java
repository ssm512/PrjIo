package ex03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInputStream {

	public static void main(String[] args) throws IOException {
		// 형내 경로
		String		path	=	
				TestInputStream.class.getResource("").getPath();
		System.out.println(path); // /D:/dev/java/PrjIo/bin/ex03/ // 실행되는 .class의 위치 
		String		inFile	=	path + "data2.dat";
		
		FileInputStream		fis		=	new	FileInputStream( inFile );
		
		int			ch;
		while	((ch	=	fis.read()	)!= -1) { // EOF : End of File ( -1)이 아닌동안 반복
			System.out.print((char) ch);
		}
		
		fis.close();
	} // main end

} // class TestInputStream end
