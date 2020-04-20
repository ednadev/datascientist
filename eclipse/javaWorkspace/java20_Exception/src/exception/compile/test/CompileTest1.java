package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	FileReading() {}
	public void readFile(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName); //FileReader 객체 생성하는 부분! 
										// FileNotFoundException 터짐 : 찾고자 하는 파일이 없을때, 파일은 있는데 path 또는 fileName을 잘 못 넣어서
			System.out.println("1. FileReader Creating....");
		} catch(FileNotFoundException e) {
			//e.printStackTrace();
		}
	}
}
public class CompileTest1 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		//readFile 호출....
		String path = "C:\\kmg\\poem.txt";
		fr.readFile(path);
		System.out.println("2. readFile Calling....");
	}

}
