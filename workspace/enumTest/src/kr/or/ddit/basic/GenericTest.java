package kr.or.ddit.basic;

class NonGenericClass{
	private Object value;
	
	public void setValue(Object value){
		this.value = value;
	}
	
	public Object getValue(){
		return value;
	}
}
/*
 * 제네릭 클래스를 만드는 방법
 * 	-형식)
 * 		class 클래스명 <제네릭타입글자(대문자)>{
 * 			제네릭타입글자 변수명;    //변수 선언에 제네릭을 사용할 경우
 * 			...
 * 
 * 			제네릭타입글자 메서드명(){ // 메서드의 반환값에 제네릭을 사용할 경우 
 *			...	 
 * 			return 값;
 * 		}
 * 
 * 		void 메서드명(제네릭타입글자 변수명){  //메서드의 매개변수에 제네릭을 사용할 경우
 * 			...
 * 		}
 *
 * 제네릭 타입 글자로 많이 사용되는 것
 * T ==> Type
 * K ==> Key
 * V ==> Value
 * E ==> Element
 *
 */






class MyGeneric<T>{       //변수 선언에 제네릭을 사용할 경우
	private T value;     
	
	public void setvalue(T value){     //메서드의 매개변수에 제네릭을 사용할 경우
		this.value = value;
	}
	
	public T getValue(){     // 메서드의 반환값에 제네릭을 사용할 경우 
		return value;
	}
}





public class GenericTest {

	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setValue("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		
		String rtnNg1 = (String) ng1.getValue();
		System.out.println("문자열 반환값 : "+ rtnNg1);
		int rtnNg2 = (int) ng2.getValue();
		System.out.println("정수 반환값 : "+ rtnNg2);
		
		//String rtnNg3 = (String) ng2.getValue();   //형변환을 했지만 실제 들어있는 데이터가 정수이다 -> 코드상으로는 에러가 안보임
		//System.out.println("rtnNg3 : "+ rtnNg2);
		
		
		MyGeneric<String> mg1 = new MyGeneric<>();   // ==> 사용할 때 형식을 정하고 싶을 경우 제네릭을 사용
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setvalue("우리나라");    
		mg2.setvalue(500);
		
		String rntmg1 = mg1.getValue();
		int rntmg2 = mg2.getValue();
		
		//mg1.setvalue(400);      // 정해진 형식으로 넣지않으면 오류가 떠서 걸러낼수있다.
		//mg2.setvalue("한글");
		
		System.out.println("문자열 반환값 : "+ rntmg1);
		System.out.println("정수 반환값 : "+ rntmg2);
		
		
	}

}
