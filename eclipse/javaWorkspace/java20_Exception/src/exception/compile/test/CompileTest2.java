package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2 {
	FileReading2() {}
	public void readFile(String fileName) throws FileNotFoundException{
		FileReader fileReader = new FileReader(fileName);
		System.out.println("1. FileReader Creating....");
	}
}
public class CompileTest2 {

	public static void main(String[] args) {
		FileReading2 fr = new FileReading2();
		//readFile 호출....
		String path = "C:\\kmg\\poem.txt";
		try {
			fr.readFile(path); //throws..폭탄을 던져버리면 호출하는 곳으로 간다.
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("2. readFile Calling....");
	}

}
