package self.test;

public class FirstOne {

	public static void main(String[] args) {
		/*
		 * 1 2 3  4  5
		 *   6 7  8  9
		 *     10 11 12
		 *        13 14
		 *           15
		 * */
		for(int i=5; i>=1; i--) {
			for(int j=5; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=5; j>=1; j--) {
				System.out.print("*"); //첫번째 줄은 1*1.. 이런식이니까,, 두번째는 
			}
			System.out.println();
		}
	}

}
