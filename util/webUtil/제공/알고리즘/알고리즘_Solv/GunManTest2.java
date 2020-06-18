import java.io.*;
import java.util.*;

//응용 : 남은 타켓수
public class Solution4_Sol {
	static int N, M;
	static int Count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/testCase.txt")); //System.in으로 받아쓰세요..
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			N=sc.nextInt();  // 세로 칸 수 (행수)
			M=sc.nextInt();  // 가로 칸 수 (열수)
			
			char[][] room=new char[N][M];  // 방을 나타내는 배열
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					String s=sc.next();
					room[i][j]=s.charAt(0);
				}				
			}
			
			Count=0;
			
			//( 이 부분에 알고리즘 구현을 한다. )
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(room[i][j]=='G'){
						int cnt=0;
						// 상 
						for(int k=1; i-k>=0; k++) { //한 칸식 위로 세어 나감
							if(room[i-k][j]=='G' || room[i-k][j]=='W'){
								break; // 벽에 막히거나 다른 총잡이가 있으면 멈춤
							}else if(room[i-k][j]=='T'){
								cnt++; // 카운트한  목표물을 중복 카운트하지 않도록 벽으로 바꿈.
								room[i-k][j]='W';
								break; // 목표물을 카운트하고 멈춤
							}
						}
						// 하
						for(int k=1; i+k<N; k++){
							if(room[i+k][j]=='G' || room[i+k][j]=='W'){
								break;
							}else if(room[i+k][j]=='T'){ 
								cnt++;
								room[i+k][j]='W';
								break;
							}
						}
						// 좌
						for(int k=1; j-k>=0; k++) {
							if(room[i][j-k]=='G' || room[i][j-k]=='W'){
								break;
							}else if(room[i][j-k]=='T'){
								cnt++;
								room[i][j-k]='W';
								break;
							}
						}
						// 우
						for(int k=1; j+k<M; k++){
							if(room[i][j+k]=='G' || room[i][j+k]=='W'){
								break;
							}else if(room[i][j+k]=='T'){
								cnt++; 
								room[i][j+k]='W';
								break;
							}
						}
						Count+=cnt;
					}
				}
			}
			
			System.out.println("#"+tc+" "+Count);
		}
	}
}