package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3 {
	FileReading3() {}
	public void readFile(String fileName) throws FileNotFoundException {
		FileReader fileReader = new FileReader(fileName); //
		System.out.println("1. FileReader Creating....");
	}
}
public class CompileTest3 {

	public static void main(String[] args) throws FileNotFoundException { //JVM에서 호출..JVM이 예외처리 / JVM이 객체를 만든 것
		FileReading3 fr = new FileReading3();
		//readFile 호출....
		String path = "C:\\kmg\\poem.txt";
		fr.readFile(path);
		
		System.out.println("2. readFile Calling....");
	}

}
