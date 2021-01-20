package test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//문제 1
		int[] arr ={10,20,30,40,50};
		int sum = 0;
		
		for(int i =0; i<arr.length; i++){
			sum += arr[i];
		}
		System.out.println("합계 : "+sum);
		
		
		//문제 2
		Scanner s = new Scanner(System.in);
		
		String [] names = new String[5];
		int size = names.length;
		
		for(int i =0; i<size; i++){
			System.out.print("이름 입력 >");
			names[i] = s.nextLine();
		}
		
		for(int i =0; i<size; i++){
			System.out.print("이름 : " + names[i] + " ");
		}
		
		
		//문제 3
		int[] score = { 79, 88, 91,33,100,55,95};
		
		int max = score[0];
		int min = score[0];
		
		for(int i = 1; i<score.length; i++){
			if(score[i] > max){
				max = score[i];
			}else if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println();
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
		
		//문제 4
		int[][] arr2 = { {5,5,5,5,5}, {10,10,10,10,10}, {20,20,20,20,20}, {30,30,30,30,30}};
		
		int sumNum = 0;
		int avg = 0;
		
		for(int i=0; i<arr2.length; i++){
			for(int j=0; j<arr2.length; j++){
				sumNum += arr2[i][j];
			}
		}
		avg = sumNum / (arr2.length*arr2.length);
		
		System.out.println("합계 :"+sumNum);
		System.out.println("평균 :"+avg);
		
		//문제 5
		int[] answer= {4,4,1,2,2,3,3,3,2,2,1,1};
		int[] counter = new int[4];
		
		for(int i=0; i<answer.length; i++){
			counter[answer[i]-1]++;
		}
		
		for(int i=0; i<counter.length; i++){
			System.out.printf("%d는",i+1);
			for(int j=0; j<counter[i]; j++){
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		//문제 6
		String menu[] ={ "아메리카노 3000원", "카푸치노 4000원", "카페라떼 3500원"};
		
		for(int i=0; i<menu.length; i++){
			System.out.println("메뉴이름 : " + menu[i].substring(0, 5));
		}
		
		//문제 7
		String str="i Love Java";
		
		System.out.println(str.indexOf("Java"));
		
		//문제 8
		String  ss ="java.lang.Object";
		
		System.out.println( ss.substring(ss.indexOf("lang"),ss.indexOf("lang")+"lang".length()));
		
		//문제 9
		String animals = "dog,cat,bear";

		String[] animalArray = animals.split(",");
		for(int i =0; i< animalArray.length; i++){			
			System.out.println(animalArray[i]);
		}
		
		//문제 10	
		str ="java,lang,Object";
		System.out.println(str.replace(',','.'));
	
				
		
		
		
	}

}
