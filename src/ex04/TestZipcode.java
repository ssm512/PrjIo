package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
1. zipcode.txt  파일을 준비한다
2. 파일읽기기능을 호출한다
3. 버퍼읽기기능도 호출한다
4. 키보드로 검색할 자료(동,건물명) 입력
5. 한줄을 저장할 변수를 준비
6. 첫줄을 읽어서 버린다
   ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
7. 파일끝까지 반복해서 읽어온다
   135-806,서울,강남구,개포1동 경남아파트,,1
   각 변수에 짤라서 담는다
   입력받은자료로 검색  
   검색한 주소 출력한다 
   반복끝
   검색된 자료수 : 
   전체 자료수
10.파일을 닫는다
 */

public class TestZipcode {

	public static void main(String[] args) throws IOException {
		// 입력 파일
		String		path			=
				TestZipcode.class.getResource("").getPath();
		System.out.println(path);
		String			inFile		=	path + "zipcode_utf8.csv";
		FileReader		fr			=	new	FileReader (inFile);
		BufferedReader	br			=	new BufferedReader(fr);

		// 출력 파일
		String			outFile		=	path + "zipResult.txt";
		FileWriter		fw			=	new	FileWriter(outFile);
		BufferedWriter	bw			=	new	BufferedWriter(fw);
		String			outFile2		=	path + "zipResult2.txt";
		FileWriter		fw2			=	new	FileWriter(outFile2);
		BufferedWriter	bw2			=	new	BufferedWriter(fw2);
		
		// 사용자 키보드로 부터 동, 건물명 입력
		Scanner 		in			= new	Scanner(System.in);
		System.out.println("검색할 동, 건물명");
		String			line		=	in.nextLine();
		String	[]		li			=	line.trim().split(",");
		String			fDong		=	li[0].trim();
		String			fBuilding	=	li[1].trim();

		
		// 한줄을 저장할 변수 준비
		String			zipLine		=	"";
		br.readLine(); // 한줄은 읽어서 버림
		String			title		=	"ZIPCODE SIDO GUGUN DONG BUNJI SEQ\n";
		System.out.println(title);
		bw.write(title);
		bw2.write(title);
		int		i	=	1;
		int		j	=	0;
		String		result	=	"";
		while ((zipLine=br.readLine())!= null) {
			String		[]	zLi		=	zipLine.trim().split(",");
			//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
			//135-806,서울,강남구,개포1동 경남아파트,,1
			String		zipCode		=	zLi[0].trim();
			String		city		=	zLi[1].trim();
			String		gugun		=	zLi[2].trim();
			String		dong		=	zLi[3].trim();
			String		bunji		=	zLi[4].trim();
			int			seq			=	Integer.parseInt(zLi[5].trim());
							
			String		fmt			=	"%s %s %s %s %s %d\n";
			String		msg			=	String.format(fmt, zipCode, city, gugun, dong, bunji, seq);
			if	(dong.contains(fDong)&& dong.contains(fBuilding)) { 
				result	= 	msg;	
				bw2.write(result);
				j++;}
			//System.out.println(msg);
			bw.write(msg);
			i++;			
		}
		
		
		System.out.println(result);
		System.out.println("검색된 자료수 : " + j);
		System.out.println("전체자료수 : " + i);
		//
		
		br.close();
		bw.close();
		bw2.close();
		
		fr.close();
		fw.close();
		fw2.close();
		
		/*
		 4. 키보드로 검색할 자료(동,건물명) 입력
	5. 한줄을 저장할 변수를 준비
	6. 첫줄을 읽어서 버린다
   ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
	7. 파일끝까지 반복해서 읽어온다
   135-806,서울,강남구,개포1동 경남아파트,,1
   각 변수에 짤라서 담는다
   입력받은자료로 검색  
   검색한 주소 출력한다 
   반복끝
   검색된 자료수 : 
   전체 자료수
	10.파일을 닫는다
		 */
		
	} // main end

} // class TestZipcode
