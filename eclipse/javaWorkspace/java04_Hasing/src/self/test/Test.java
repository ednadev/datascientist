package self.test;

import self.MyDate;
import self.NoteBook;
import self.Programmer;

public class Test {

	public static void main(String[] args) {
		/*
		 * 1. 개발자 생성 : James
		 * 2. James가 NoteBook을 구매
		 * 3. James가 구매한 NoteBook의 정보를 확인
		 * 4. James의 정보도 출력
		 */
		
		//개발자 생성 : James
		Programmer james = new Programmer("James", 300000, "Python", new MyDate(1987, 4, 8));
		
		//James의 정보도 출력
		System.out.println("========Programmer Information========");
		System.out.println(james.getProgrammer());
		
		System.out.println(" ");
		System.out.println(james.getName() + "님이 구매한 NoteBook Information========");
		
		//James가 NoteBook을 구매
		james.buyNoteBook(new NoteBook("Gram", 1700000));
		
		//James가 구매한 NoteBook의 정보를 확인
		System.out.println(james.getNoteBook().getNoteBook());
		
		
	}

}
