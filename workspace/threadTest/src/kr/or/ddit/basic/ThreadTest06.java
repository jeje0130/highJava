package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new MyCountDown();
		
		th1.start();
		th2.start();

	}

}

// 데이터를 입력받는 쓰레드
class DataInput extends Thread{
	// 입력 여부를 확인하기 위한 변수 선언 = 쓰레드에서 공통으로 사용할 변수
	public static boolean inputCheck = false;
	
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("입력하세요");
		
		//입력이 완료되면 inputCheck변수를 true로 변경한다.
		inputCheck = true; 
		
		System.out.println("입력한 값 : " + str);
	}
}


//카운트다운을 처리하는 쓰레드
class MyCountDown extends Thread{
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면
			// 쓰레드를 종료시킨다.
			if(DataInput.inputCheck==true){
				return; //메서드를 끝내는 건 return , 반복문에서는 break
						// run()메서드가 종료되면 쓰레드가 끝나는 것
			}
			
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000); // 1초동안 잠시멈춤 (카운트다운)
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("10초 끝, 프로그램 종료");
		System.exit(0);
	}
}














