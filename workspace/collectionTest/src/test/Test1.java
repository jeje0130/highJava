package test;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//문제 1
		int num = 10;
		
		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : "0"));
		
		
		//문제 2
		char ch = 'z';
		boolean a = (ch >= 'A' && ch <= 'z') || (ch >= 'a' && ch <= 'z')
						|| (ch >= '0' && ch <= '9');			
		System.out.println(a);
		
		
		//문제 3
		char ch1 = 'A';
		
		for(int i=0; i<ch1; i++){
			if(65 <= ch1 && ch1 <= 90){
				ch1= (char)(ch1+32);
			}
		}
		System.out.println(ch1);

		
		//문제 4
		int value = (int) (Math.random()*6)+1;
		System.out.println(value);
		
		
		//문제 5
		int sum = 0;
		
		for(int i=1; i<=100; i++){
			sum += i;
		}
		System.out.println(sum);
		
		//문제 6
		int random = (int)(Math.random()*100)+1;
		int input = 0;
		
		Scanner s = new Scanner(System.in);
		
		do{ 
			System.out.println("1~100 사이의 수를 입력해주세요>");
			input = Integer.parseInt(s.nextLine());
		
			if(random < input){
			System.out.println(input + " 보다 작습니다.");
			}else if(input < random){
			System.out.println(input + " 보다 큽니다.");
			}else{
			System.out.println("정답입니다!!");
			}
		}while(input != random); 
		
		
		
		
		
		
		
	}

}
