package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest {

	 /*
	 * 문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오
	 * 	    컴퓨터의 숫자는 난수를 이용하여 구한다. 
	 * 	  (스트라이크는 S, 볼은 B로 나타낸다.)
	 * 
	 */
	
	int[] num = new int[3]; 
	int[] input;				
	
	int S;	
	int B;	
	
	Scanner scan = new Scanner(System.in);
	
	
	public void randomNum(){
		
		Set<Integer> numSet = new HashSet<Integer>();
		while(numSet.size()<3){
			numSet.add( (int)(Math.random() * 9 + 1) );
		}
		
		Iterator<Integer> it = numSet.iterator();
		
		int i = 0; 
		while(it.hasNext()){
			num[i++] = it.next().intValue();
		}
		
		List<Integer> numList = new ArrayList<>(numSet);
		Collections.shuffle(numList); 
		int j = 0; 
		for(int test : numList) {
			num[j++] = test;
		}
		
		
	}

	
	public void input(){
		int num1;
		int num2;
		int num3; 

		do{
			System.out.print("숫자 3개 입력 > ");
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			num3 = scan.nextInt();
			if(num1==num2 || num1==num3 || num2==num3){
				System.out.println("중복, 다시입력하세요");
			}
		}while(num1==num2 || num1==num3 || num2==num3);
		
		input = new int[]{num1, num2, num3};  
	}
	
	
	public void count(){
		S = 0;
		B = 0;   
		
		for(int i=0; i<num.length; i++){
			for(int j=0; j<input.length; j++){
				if(num[i] == input[j]){  
					if(i==j){  
						S++;
					}else{		
						B++;
					}
				}
			}
		}
		
		System.out.println(input[0] + " " + input[1] + " " + input[2] +
				" ==> "  + S + "S " + B + "B");
		
	}
	
	

	public void game(){

		randomNum();
		System.out.println("랜덤값 => " + num[0] + " " + num[1] + " " + num[2]);
		
		int cnt = 0; 
		
		do{
			cnt++; 
			input(); 
			count();  
		}while(S!=3); 
		
		System.out.println(cnt + "번째만에 맞췄습니다.");
	}
	
	public static void main(String[] args) {
		BaseBallTest baseBall = new BaseBallTest();
		baseBall.game();
	}

}
	
	

