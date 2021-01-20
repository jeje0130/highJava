package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LottoSam {

	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new LottoSam().lottoStart();

	}
	
	public void lottoStart(){
		while(true){
			int choice = displayMenu();
			switch(choice){
			case 1 : 
				lottoBuy();
				break;
			case 2 :
				System.out.println("감사합니다");
				System.exit(0);
				break;
			default :  System.out.println("번호 다시 입력"); 
			}
		}
	}
	
	private void lottoBuy(){
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("1000원에 로또번호 하나입니다.");
		System.out.println("금액 입력 :");
		int money = scan.nextInt();
		
		if(money<1000){
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		}else if(money/1000 > 100){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		}else{
			lottoNum(money); // 로또번호 메서드 호출
		}
	}
	
	// 금액에맞는 로또 번호를 생성하고 출력하는 메서드
	private void lottoNum(int money){
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i=0; i<money/1000; i++){
			
			HashSet<Integer> lottoSet = new HashSet<>();
			while(lottoSet.size()<6){
				lottoSet.add((int)(Math.random()*45+1));
			}
			List<Integer> lottoList = new ArrayList<>(lottoSet);
			System.out.print("로또번호 "+(i+1)+": ");
			for(int j=0; j<lottoList.size(); j++){
				if(j>0) System.out.print(", ");
				System.out.print(lottoList.get(j));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("받은 금액 " + money + "원이고 거스름돈은 " + (money%1000) + "원 입니다.");
	}
	
	//메뉴를 출력하고 선택한 메뉴번호를 반환하는 메서드
	private int displayMenu(){
		System.out.println();
		System.out.println("==========================");
		System.out.println(" 		Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println(" 1. Lotto 구입");
		System.out.println(" 2. 프로그램 종료");
		System.out.println("==========================");
		System.out.println("메뉴선택 : ");
		
		int num = scan.nextInt();
		return num;
	}

}
