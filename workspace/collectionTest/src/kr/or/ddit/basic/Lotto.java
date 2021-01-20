package kr.or.ddit.basic;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	
	int select(){
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		return a;
	}
	
	void lottoMain(){
		System.out.println("=========================");
		System.out.println("\tLotto 프로그램");
		System.out.println("-------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("=========================");
		System.out.println("메뉴선택 : ");
	}
	
	void buy(){
		while(true){
			System.out.println("Lotto 구입 시작");
			System.out.println("1000원에 로또 한장");
			System.out.println("금액 입력 : ");
			int money = select();
	
		if(money/1000 <= 0){
			System.out.println("입력 금액이 너무 적습니다. 로또 구입 실패");
			return;
		}else if(money/1000 > 100){
			System.out.println("입력 금액이 너무 많습니다. 로또 구입 실패");
			return;
		}else{
			System.out.println("행운의 로또 번호");
			for(int i=0; i<money/1000; i++){
				System.out.println("로또 번호 " + i);
				randomLotto();
				System.out.println();
			}
			System.out.println("\t 받은 금액은 " + money + "이고  거스름돈은 " + (money%1000) + "원입니다.");
			return;
			}
		}
	}
		
	void randomLotto(){
		
		Set<Integer> lottoNum = new TreeSet<>(); 
			while(lottoNum.size() < 6){
				int random = (int)(Math.random()*45 + 1);
				lottoNum.add(random);
			}			
			System.out.print(lottoNum);
		}
	
	public static void main(String[] args) {
		
		Lotto game = new Lotto();
		
		while(true) {
//			new Lotto().lottoMain();
			game.lottoMain();
			int num = game.select();
			
			switch(num){
			case 1 : game.buy(); continue;
			case 2 : 
				System.out.println("감사합니다");
				System.exit(0);
			default :
				System.out.println("숫자를 다시 입력해주세요."); continue;
			}
			
		}
		
	}
	

}
