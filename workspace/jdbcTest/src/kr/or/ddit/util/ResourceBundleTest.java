package kr.or.ddit.util;

import java.util.ResourceBundle;

/*
 * ResouceBundle객체 ==> 파일의 확장자가 properties인 파일의 내용을 
 * 읽어와 key값과 value값을 분리하여 분리된 정보를 갖고 있는 객체
 * 
 * ==> 읽어올 파일의 확장자는 반드시 properties이여야하고
 * 		파일 내용은  'key값=value값' 형태로 되어있어야 한다.
 * 
 * 
 */

public class ResourceBundleTest {

	public static void main(String[] args) {
		// ResourceBundle 객체를 이용하여 파일 내용 읽어오기
		
		// ResourceBundle 객체 생성하기
		//	==> 읽어올 파일을 지정할때 '파일명'만 지정하고 확장자는 지정하지 않는다.
		//	    (이유 : 확장자는 항상 properties이기 때문에...)
		//  ==> 
		
		ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
		
		System.out.println("driver : "+ bundle.getString("driver"));
		System.out.println("url : "+ bundle.getString("url"));
		System.out.println("user : "+ bundle.getString("user"));
		System.out.println("pass : "+ bundle.getString("pass"));
		
	}

}
