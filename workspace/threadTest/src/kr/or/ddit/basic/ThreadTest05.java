package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		//사용자로부터 데이터 입력받기
		String str = JOptionPane.showInputDialog("입력하세요"); //입력하면 콘솔창에 입력한 답변이 뜨고, 취소하면 null값이 뜬다.
		System.out.println("입력값 : " + str);
		
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초동안 잠시멈춤 (카운트다운)
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

	}

}
