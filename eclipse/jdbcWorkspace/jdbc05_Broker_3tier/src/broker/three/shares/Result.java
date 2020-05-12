package broker.three.shares;

import java.util.ArrayList;
/*
 * Result는 한칸짜리 ArrayList
 * 성공/실패 여부를 확인할 수 있는 status값을 가지고 있다
 */
public class Result extends ArrayList{
	private int status = -1; //실패(-1) 성공(0) 여부

	public Result() {
		super(1); //ArrayList를 만드는데 1칸으로 만들어라..
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
