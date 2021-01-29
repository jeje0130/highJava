package kr.or.ddit.basic.mvc.vo;

/*
 	DB테이브에 있는 컬럼을 기준으로 데이터를 객체화 할 클래스이다.
 	DB테이블의 '컬럼명'이 이 클래스의 '멤버변수'가 된다.
 	
 	DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 
 */

public class MemberVO {  //테이블 하나당 VO 한개
	private String mem_id;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	
	
	// 만약에 생성자를 만들었을 때는 반드시 기본 생성자도 같이 만들어준다.
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	
	
	
}
