package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제 ) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를
 * 		멤버로 갖는 Student클래스를 작성한다.
 * 		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 
 * 		매개변수로 받아서 초기화 처리한다.
 * 
 * 		이 Student 객체는 List에 저장하여 관리한다.
 * 
 * 		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 
 * 		내부 정렬기준을 구현하고,
 * 
 * 		총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
 * 		외부 정렬기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 * 
 * 		(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 * 
 */

public class StudentTest {

	//등수는 여기에 만듬
	public void setRanking(List<Student> scoreList){
		
//		for(int i=0; i<scoreList.size(); i++){	// 기준 데이터를 구하기위한 반복문
//			int rank = 1; // 처음에는 1등으로 설정해 놓고 시작한다
//			for(int j=0; j<scoreList.size(); j++){	// 비교 대상을 나타내는 반복문
//				// 기준보다 큰 값을 만나면 rank값을 증가시킨다.
//				if(scoreList.get(i).getSum() < scoreList.get(j).getSum()){
//					rank++;
//				}
//			} //for - j
//			  //구해진 등수를 Student객체의 rank 변수에 저장한다.
//			scoreList.get(i).setRank(rank);
//		}// for - i
		
		
		//향상된 for문
		for(Student std1 : scoreList){
			int rank = 1;
		
			for(Student std2 : scoreList){
				if(std1.getSum() < std2.getSum()){
					rank++;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		StudentTest t = new StudentTest();
		
		List<Student> scoreList = new ArrayList<>();

		scoreList.add(new Student(10, "홍길동", 99, 80, 73)); 
		scoreList.add(new Student(20, "이순신", 85, 94, 65));
		scoreList.add(new Student(30, "성춘향", 73, 54, 95));
		scoreList.add(new Student(40, "강감찬", 87, 77, 67));
		scoreList.add(new Student(50, "일지매", 73, 54, 95));

		//등수를 
		t.setRanking(scoreList);

		System.out.println("=====================================================================");
		System.out.println("학번 오름차순");
		for(Student o : scoreList){
			System.out.println(o);
		}
		System.out.println("=====================================================================");
		System.out.println();

		Collections.sort(scoreList, new DescSum());

		System.out.println("총점 역순 정렬");
		for(Student o : scoreList){
			System.out.println(o.toString());
		}

		System.out.println("=====================================================================");
		System.out.println();
		
	

	}
}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private int rank;

	public Student(int num, String name, int korean, int english, int math) {
		super();
		this.num = num;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = korean + english + math;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getKorean() {
		return korean;
	}



	public void setKorean(int korean) {
		this.korean = korean;
	}



	public int getEnglish() {
		return english;
	}



	public void setEnglish(int english) {
		this.english = english;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	public int getSum() {
		return sum;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	@Override
	public String toString() {
		return "학번 : " + num + " | 이름 : " + name + " | 국어 : " + korean
				+ " | 영어 : " + english + " | 수학 : " + math + " | 총점 : " + sum + " | 등수 : " + rank ;
	}

	@Override
	public int compareTo(Student o) {
		return (this.num-o.num);
	}

}

//총점의 역순, 이름의 오름차순 외부정렬

class DescSum implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(Integer.compare(o1.getSum(), o2.getSum())==0){
			return o1.getName().compareTo(o2.getName());
		}
		else return Integer.compare(o1.getSum(), o2.getSum()) * -1;				
	}
}












