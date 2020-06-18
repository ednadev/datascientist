package algo.test;

import java.util.Scanner;

public class GunManTest {

	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tcn=1; tcn<=T; tcn++){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
		char[ ][ ] map = new char[X][Y];
		
		for(int i=0; i<X; i++){			
			for(int j=0; j<Y ;j++){
				map[i][j] = sc.next().charAt(0);				
			}	
			
		}//fill map
		
		int count = 0;
		for(int i=0; i<X; i++){			
			for(int j=0; j<Y; j++){
				if(map[i][j]=='G'){
					//오른쪽으로 탐색
					
					if(j!=Y-1){
						for(int ic =j+1; ic<Y; ic++){
							if(map[i][ic]==('0')){
								continue;
							}else if(map[i][ic]==('W') | map[i][ic]==('G')){
								break;
							}else if(map[i][ic]==('T')){
								count++;
								map[i][ic] = 'W';
								break;
							}
						}
					}//
					
					//왼쪽으로 탐색
					if(j!=0){
						for(int ic =j-1; ic>=0; ic--){
							if(map[i][ic]==('0')){
								continue;
							}else if(map[i][ic]==('W')| map[i][ic]==('G')){
								break;
							}else if(map[i][ic]==('T')){
								count++;
								map[i][ic] = 'W';
								break;
							}
						}
					}//
					
					//위로 탐색
					if(i!=0){
						for(int ir=i-1; ir>=0; ir--){
							if(map[ir][j]==('0')){
								continue;
							}else if(map[ir][j]==('W') | map[ir][j]==('G')){
								break;
							}else if(map[ir][j]==('T')){
								count++;
								map[ir][j] = 'W';
								break;
							}
						}
						
					}//
					
					//아래로 탐색
					if(i!=X-1){
						for(int ir=i+1; ir<X; ir++){
							if(map[ir][j]==('0')){
								continue;
							}else if(map[ir][j]==('W') | map[ir][j]==('G')){
								break;
							}else if(map[ir][j]==('T')){
								count++;
								map[ir][j] = 'W';
								break;
							}
						}
					}//					
				
				}//if
			}
		}
		System.out.println("#"+tcn+" "+count);
		
		}//tcn for

	}//main	
}//class




/*
 
 
 12
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
7 7
W W W W W W W
W T G W G T W
W T T T T T W
W T T T T T W
W T G G G T W
W T T T T T W
W W W W W W W
9 9
T 0 T 0 T 0 T 0 T
0 0 W W W W W 0 T
T W T T T T T W 0
0 W T G G G T W T
T W T G T G T W 0
0 W T G G G T W T
T W T T T T T W 0
0 0 W W W W W 0 T
T 0 T 0 T 0 T 0 T
7 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
T W 0 T 0 W 0 G 0 W
T W 0 G 0 W 0 T 0 W
G 0 T W T 0 T W T 0
T W 0 G 0 W T G T W
0 G T W T 0 T W T 0
10 11
T W 0 G 0 W 0 G 0 W 0
G 0 T W T 0 T W T 0 0
T W 0 T 0 W 0 G 0 W G
T W 0 G 0 W 0 T 0 W 0
G 0 T W T 0 T W T 0 T
T W 0 G 0 W T G T W G
T G T W T 0 T W T T T
G W T W G 0 G W G T G
T G T W T 0 T W T T W
W T T 0 W 0 T T T W T
10 14
T 0 T 0 G 0 G T 0 T 0 G 0 G
0 W T W W W 0 0 W T W W W 0
T W G 0 T W T T W G 0 T W T
0 0 0 T G W 0 0 0 0 T G W 0
0 0 0 T G W 0 0 0 0 T G W 0
T 0 T 0 G 0 G T 0 T 0 G 0 G
0 W T W W W 0 0 W T W W W 0
T W G 0 T W T T W G 0 T W T
0 0 0 T G W 0 0 0 0 T G W 0
0 0 T 0 0 W 0 0 0 T G T W 0
15 10
G 0 G 0 G 0 G 0 G 0
0 G 0 W 0 W 0 W 0 G
G 0 W 0 G 0 G W W 0
0 G 0 W 0 W 0 T W G
G 0 W 0 G 0 G W W 0
0 G 0 W 0 0 0 W 0 G
G 0 W 0 G W G W W 0
0 G 0 W 0 W 0 T W G
G 0 W 0 G W G W W 0
0 G 0 W 0 0 0 W 0 G
G 0 W 0 G W G W W 0
0 G 0 W W T W W 0 G
G 0 W 0 W W W 0 W 0
0 G G G 0 G 0 G 0 G
G W G W G W G W G W
1 20
G W G T T G G T W T T G T 0 T 0 G 0 T W
15 1
T
G
G
T
W
T
W
G
G
T
T
G
G
T
T
20 20
G 0 0 T 0 0 T 0 0 T 0 0 T 0 0 T 0 0 0 T
0 G 0 0 G 0 G 0 G W G 0 G 0 G 0 G 0 T 0
0 0 G 0 W 0 0 T 0 0 T 0 0 0 0 W 0 T 0 0
0 0 0 G W 0 0 0 0 W 0 0 0 0 T W T 0 0 0
0 G W W W 0 0 0 0 0 0 0 0 0 0 W W W G 0
0 0 0 0 0 G 0 0 T W 0 T 0 0 T 0 0 0 0 0
0 G T 0 0 0 0 0 T 0 0 T 0 0 0 0 T G T 0
0 0 0 G 0 G 0 0 T W 0 0 0 0 G 0 0 T 0 0
0 T 0 0 0 0 0 0 T 0 T 0 0 0 T 0 G W 0 0
0 0 0 0 T T T T T W T T T T T T 0 0 G 0
0 W 0 W 0 W 0 W G W G W 0 W 0 W T W 0 W
0 G T 0 T 0 0 0 0 W T T T T 0 T G T 0 0
0 0 0 0 0 0 G G G G G G G G 0 0 T 0 G 0
0 0 G 0 W W W 0 W W W 0 W W W 0 0 0 0 0
0 G 0 0 T T 0 T 0 0 T 0 G 0 G T 0 0 T G
0 0 W W W 0 0 0 0 W 0 0 0 0 0 W W W 0 0
0 0 0 T W 0 T 0 T 0 0 T 0 0 G W T 0 0 0
0 0 T 0 W 0 G 0 0 W 0 0 0 0 0 W 0 0 T 0
0 T 0 0 0 G 0 G 0 G 0 0 G 0 0 0 0 0 0 0
T 0 0 0 G 0 0 T 0 W G 0 T 0 G 0 G 0 T G 
20 20
G 0 W T 0 0 0 0 0 T 0 0 W 0 0 T 0 0 0 T
0 G 0 0 G 0 G 0 G W G 0 G 0 G 0 G 0 W 0
0 0 G W W 0 0 T 0 0 W 0 0 0 W W W T 0 0
0 0 0 G W 0 0 0 0 W 0 0 0 0 T W T 0 0 0
0 G W W W 0 0 0 W 0 0 0 0 0 0 W W W G 0
0 0 0 0 0 G 0 W T W 0 T 0 0 T 0 0 0 0 0
0 G W 0 0 0 0 0 T 0 0 T 0 0 W 0 W G W 0
0 W 0 G 0 G G W T W 0 0 0 0 G 0 0 0 0 0
0 T 0 0 0 0 0 0 T 0 T 0 W 0 W 0 G W 0 0
0 0 0 0 T W G W W W W T T T T W G 0 G 0
0 W 0 W 0 W 0 W G W G W W W 0 W 0 W 0 W
0 G W 0 T 0 0 0 0 W W 0 0 W 0 0 G 0 0 0
0 0 0 0 0 0 G G G G G G G G 0 0 0 0 G 0
0 0 G 0 W W W 0 W W W 0 W W W 0 0 0 0 0
0 G W 0 T T G 0 0 G T W G 0 W T 0 0 W G
0 0 W W W 0 0 0 0 W 0 0 0 0 0 W W W 0 0
0 0 0 T W 0 W 0 T 0 0 T W 0 G W T 0 0 0
0 W T 0 W 0 G 0 0 W 0 0 0 0 0 W 0 0 T 0
W T W 0 0 G 0 G 0 G 0 0 G 0 0 0 W 0 0 0
T 0 0 0 G 0 0 W 0 W G 0 W 0 G 0 G 0 W G 


*/

/*
#1 6
#2 2
#3 12
#4 13
#5 11
#6 24
#7 27
#8 0
#9 7
#10 5
#11 45
#12 3



 
 */






