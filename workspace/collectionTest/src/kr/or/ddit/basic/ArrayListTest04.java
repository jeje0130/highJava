package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 	문제1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
 * 		 (단, 각 별명의 길이가 같게 입력할 수 있다.)
 * 
 *  문제2) 문제 1에서 별명의 길이가 같은 것을 입력할 수 있는 경우를 처리하시오
 *  	  (ArrayListTest04.java파일에 작성한다.)
 */

public class ArrayListTest04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList <String> nickname = new ArrayList<>();
		
		
		for(int i=1; i<=5; i++){
			System.out.print(i + " 번째 별명 입력> ");
			String nick = sc.nextLine();
			nickname.add(nick);
		}
		
		//제일 긴 별명의 길이가 저장될 변수를 선언하고, 이 변수는 List의 첫번재 데이터의 길이로 초기화한다.
		int maxLength = nickname.get(0).length();
		
		for(int i=1; i<nickname.size(); i++){
			if(maxLength < nickname.get(i).length()){
				maxLength = nickname.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들 > ");
		for(int i=0; i<nickname.size(); i++){
			if(nickname.get(i).length() == maxLength){
				System.out.println(nickname.get(i));
			}
		}
	}

}















