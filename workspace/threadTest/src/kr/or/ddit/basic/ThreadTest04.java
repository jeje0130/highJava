package kr.or.ddit.basic;

public class ThreadTest04 {

	/*
	 * 1~20억까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로
	 * 처리할 때와 여러개의 쓰레드가 협력해서 처리할때의 경과시간을 비교해 보자.
	 */
	
	public static void main(String[] args) {
		//단독으로 처리하는 쓰레드
		SumThread sm = new SumThread(1L, 2000000000L);
		
		//여럿이 협력해서 처리하는 쓰레드
		SumThread[] sumArr = new SumThread[]{
				new SumThread(1L, 500000000L),
				new SumThread(500000001L, 1000000000L),
				new SumThread(1000000001L, 1500000000L),
				new SumThread(1500000001L, 2000000000L)
		};
		
		//단독으로 처리하기 
		long startTime = System.currentTimeMillis();
		
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독처리 경과시간 : " + (endTime-startTime));
		System.out.println();
		
		
		//여러 쓰레드가 협력하는 경우
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<sumArr.length; i++){
			sumArr[i].start();
		}
		
		for(SumThread smt : sumArr){
			try {
				smt.join();
			} catch (InterruptedException e) {

			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("협력처리 경과시간 : " + (endTime-startTime));
		
	}

}


//주어진 구간의 합계를 구하는 쓰레드
class SumThread extends Thread{
	//합계를 구할 영역의 시작값과 끝값을 저장할 변수 선언
	private long start, end;
	
	public SumThread(long start, long end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=start; i<=end; i++){
			sum += i;
		}
		
		System.out.println("합계 : " + sum);
	}
}










