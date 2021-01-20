package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램
		
		// Thread를 사용하는 방법
		
		
		
		// 방법1
		// Thread클래스를 상속한 class를 작성한 후
		// 이 class의 인스턴스를 생성한 후, 
		// 이 인스턴스의 start()메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		
		
		
		// 방법2
		// Runnable인터페이스를 구현한 class를 작성한 후
		// 이 class의 인스턴스를 생성한 후,
		// 이 인스턴스를 Thread객체의 인스턴스를 생성할 때
		// 생성자에 '인자값'으로 넣어서 생성한다.
		// 이 때 생성된 Thread의 인스턴스의 start()메서드를 호출한다.
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();     // start()메서드는 Thread에 만들어져있다.
		
		
		
		// 방법 3 ==> 익명구현체를 이용하는 방법
		Runnable r3 = new Runnable(){
	         public void run() {
	            for(int i = 1; i<=200; i++){
	                System.out.print("@");
	                try {
	                   Thread.sleep(100);
	            } catch (Exception e) {
	                 e.printStackTrace();
	            }
	         }
	      }
	  };
	  Thread th3 = new Thread(r3);
	  th3.start();
	
	  System.out.println("main()메서드 끝");
	}
}

//방법 1  ==> Thread클래스 상속하기
class MyThread1 extends Thread{
	@Override
	public void run() {
		// 이 run() 메서드 안에 이 Thread가 처리할 내용을 기술한다.
		for(int i = 1; i<=200; i++){
			System.out.print("*");
			
			try {
				// Thread.sleep(시간) ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//	'시간'의 단위는 밀리세컨드이다.(1/1000초)
				// 	1초 == 1000
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	} // 이 run()메서드의 실행이 끝나면 해당 Thread도 끝난다.
}




//방법2 ==> Runnable인터페이스 구현하기
class MyThread2 implements Runnable{    // 자바가 상속을 1개만 할 수 있어서 Runnable을 만듬
	@Override
	public void run() {
		for(int i = 1; i<=200; i++){
			System.out.print("$");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

















