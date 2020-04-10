package array.test2;

import java.util.Scanner;

public class ArrayPersonTypeTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int peopleNum = sc.nextInt(); //배열의 사이즈
		int[] people = new int[peopleNum]; //사이즈 6

		//1. 배열 초기화 끝
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt();
		}
		
		int[] types = new int[5];
		
		for(int i=0; i<people.length; i++) {
			switch(people[i]) {
				case 1: //1타입
					types[0]++;
					break;
				case 2: //2타입
					types[1]++;
					break;
				case 3: //3타입
					types[2]++;
					break;
				case 4: //4타입
					types[3]++;
					break;
				case 5: //5타입
					types[4]++;
					break;
			}
		} //switch
		
		int max = 0; //3
		for(int i=0; i<types.length; i++) {
			if(max<types[i]) max = types[i];
			
		}
		
		int answer = 0;
		for(int i=0; i<types.length; i++) {
			if(max == types[i]) answer = i+1;
		}
		
		System.out.println("정답:: " + answer);
	}

}
/*
6
1 4 4 4 5 3
 */
