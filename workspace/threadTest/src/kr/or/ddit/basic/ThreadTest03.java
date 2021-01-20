package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간을 체크해보자.
		Thread th = new Thread(new MyRunner());
		
		// 1970년 1월 1일 0시 0분 0초(표준시간)로 부터 경과한 시간을
		// 밀리세컨드(1/1000초) 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join(); // 현재 실행중인 쓰레드에서 대상이되는 쓰레드(여기에서는 th)가 
					   // 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime-startTime));
		
		

	}

}

// 1~10억까지의 합계를 구하는 쓰레드
class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++){
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}
