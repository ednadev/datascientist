/*
 * Source --- 파일
 * Sink   --- 파일...src\\result.txt
 * ::
 * 파일에 있는 내용을 읽어서
 * 또다른 파일로 출력하는 로직을 작성
 * ::
 * 
 */
package io.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\result.txt"));

		try {
			String line = "";
			while((line = br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
			}
			//bw.flush();
		} finally {
			br.close();
			bw.close();
		}
		
	}

}
