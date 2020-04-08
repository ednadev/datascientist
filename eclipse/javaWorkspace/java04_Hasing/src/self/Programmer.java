package self;
// 색깔이 칠해지면 생성자, 아니면 setter 느슨하니까~~
public class Programmer {
	private String name;
	private int salary;
	private String tech;
	private MyDate birthDate; //생성자
	
	//주입 : noteBook으로 지정한 이유가 setNoteBook() | getNoteBook() 만들기 위해서
	private NoteBook noteBook; //setter
	
	public Programmer(String name, int salary, String tech, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.tech = tech;
		this.birthDate = birthDate;
	}

	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	} 
	
	public NoteBook getNoteBook() {
		return noteBook;
	}

	public String getProgrammer() {
		return name + ", " + salary + ", " + tech + ", " + birthDate.getBirthDay();
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public String getTech() {
		return tech;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
	
	
	
	
}
