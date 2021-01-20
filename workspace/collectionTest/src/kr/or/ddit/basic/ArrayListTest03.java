package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 	문제1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
 * 		 (단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 
 *  문제2) 문제 1에서 별명의 길이가 같은 것을 입력할 수 있는 경우를 처리하시오
 *  	  (ArrayListTest04.java파일에 작성한다.)
 */

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList <String> nickname = new ArrayList<>();
		
		
		for(int i=1; i<=5; i++){
			System.out.print(i + " 번째 별명 입력> ");
			String nick = sc.nextLine();
			nickname.add(nick);
		}
		
		// 제일 긴 별명이 저장될 변수를 선언하고 이 변수에는 List의 첫번째 데이터로 초기화한다.
		//String longNickName = nickname.get(0); 
		
		// 제일 긴 별명이 저장된 index값이 저장될 변수를 선언하고,
		// 0으로 초기화한다
		int maxIndex = 0;
		
		System.out.println();
		for(int i=1; i<nickname.size(); i++){
//			if(nickname.get(i).length() > longNickName.length())
//				longNickName = nickname.get(i);
//		}
			if(nickname.get(maxIndex).length() < nickname.get(i).length()){
				maxIndex = i;
			}
//		System.out.println("길이가 가장 긴 별명> " + longNickName);
			System.out.println("길이가 가장 긴 별명> " + nickname.get(maxIndex));
		}
	}
}

