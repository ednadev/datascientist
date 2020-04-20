package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest5 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = "C:\\kmg\\poem.txt";
		
		FileReader fr = null;
		try{
			System.out.println("1. FileReader 클래스 생성");
			fr = new FileReader(path); //수도꼭지를 연다.
			
			System.out.println("2. 파일의 내용을 읽어들입니다...read()...");
			fr.read();
		} finally {
			//수도꼭지를 잠근다...close()
			fr.close();	//try~finally를 한 이유는 중간에 예외가 발생하면 close까지 도달 안함.. finally는 예외가 발생해도 무조건 실행하므로
		}
	}

}
