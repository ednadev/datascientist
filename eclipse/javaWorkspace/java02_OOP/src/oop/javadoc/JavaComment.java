package oop.javadoc;
/**
 * 
 * @author ednadev [소스코드 작성자 정보]
 * @since JDK 1.8.5
 * @version [소스코드 버전정보] Start Version level 1.
 *
 */
public class JavaComment {
	/**
	 * 해당 점수를 받은 수강자의 이름이 입력되는 변수
	 */
	public String name;
	public int age;
	
	// 메소드 이름 : scoreSum
	// 인자값(파라미터) : int java, int algo
	// 콜은 main에서 담당
	// 객체 생성 = 메모리 접근 = 주소값 할당
	/**
	 * 
	 * @param java Program Score
	 * @param algo Program Score
	 * @return 자바 성적과 알고리즘 성적의 합산으로 학생의 최종 점수를 반환
	 */
	public int scoreSum(int java, int algo) {
		return java + algo;
	}
}
