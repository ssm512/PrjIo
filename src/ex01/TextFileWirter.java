package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileWirter {

	public static void main(String[] args) throws IOException {
		String	[]	names		=	{"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
		
		// String		filename	=	"bts.txt"; // D:\dev\java\PrjIo\bts.txt 저장
		String		filename	=	"D:\\dev\\java\\PrjIo\\src\\ex01\\bts.txt"; 
		FileWriter	fw	=	new	FileWriter(filename);
		for (int i = 0; i < names.length; i++) {
			int j = i + 1;
			fw.write(j + "." + names[i] + "\n");
		
		}
		
		fw.close();
		
		System.out.println(filename + " 이 저장되었습니다.");
		System.out.println(names.length + " 줄 저장되었습니다.");
	} // main end

} // class TextFileWirter end
