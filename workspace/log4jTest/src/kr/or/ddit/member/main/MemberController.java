package kr.or.ddit.member.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/*
 * - 회원을 관리하는 프로그램을 작성하시오.
 *   (오라클 DB의 mymember 테이블 이용)
 *   
 * - 아래 메뉴의 기능을 모두 구현하시오 (CRUD 구현하기 연습)
 * 메뉴 예시 )
 * 	-- 작업 선택 --
 *  1. 자료 추가
 *  2. 자료 삭제
 *  3. 자료 수정
 *  4. 전체 자료 출력
 *  0. 작업 끝
 *  -----------
 *  작업 선택>> 
 * 
 * 
 */


public class MemberController {
	private Scanner scan = new Scanner(System.in);

	// Controller는 Service객체를 사용하기 때문에 Service객체가 저장될 변수가 필요하다.
	private IMemberService service;

	public MemberController(){
		service = MemberServiceImpl.getInstance();
	}

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public static void main(String[] args) {
		new MemberController().myMember();



	}

	private void myMember(){

		while(true){
			int choice = menu();
			switch(choice){
			case 1:      // 자료 추가
				insert();
				break;
			case 2:      // 자료 삭제
				delete();
				break;
			case 3:  
				update(); // 자료 수정
				break;
			case 4:
				update2();
				break;
			case 5:
				selectAll();// 전체 자료 출력
				break;
			case 0:
				System.out.println("작업 끝");
				System.exit(0);
				break;
			default :  System.out.println("번호 다시 입력"); 
			}
		}

	}



	private int menu(){
		System.out.println("--- 작업 선택 ---");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 자료 일부 수정");
		System.out.println("5. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("------------");
		System.out.print("작업 선택>> ");
		int num = scan.nextInt();

		return num;
	}




	private void selectAll(){

		List<MemberVO> memList = service.getAllMember();

		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("ID	이름	전화번호		주소");
		System.out.println("---------------------------------------");

		if(memList==null || memList.size()==0){
			System.out.println("등록된 회원이 하나도 없습니다");
		}else{
			for(MemberVO memVo : memList){
				System.out.print(memVo.getMem_id()+"\t");
				System.out.print(memVo.getMem_name()+"\t");
				System.out.print(memVo.getMem_tel()+"\t");
				System.out.println(memVo.getMem_addr()+"\t");
			}
		}

		System.out.println("---------------------------------------");
		System.out.println("출력끝");
		System.out.println();


	}



	//원하는 컬럼만 수정
	private void update2(){


		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println();
		System.out.print("수정할 회원 아이디 입력> ");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if(count == 0){ //없는회원이면
			System.out.println("입력한 아이디  " +  memId + "는 없는 회원아이디입니다.");
			System.out.println("수정 작업 끝");
			return;
		}

		int num;
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updatestr = null; // 수정할 컬럼의 한글명이 저장될 변수

		do{
			System.out.println();
			System.out.println("수정할 항목을 선택");
			System.out.println("1.회원이름	2.전화번호	3.회원주소");
			System.out.println("---------------------------------------");
			System.out.println("수정 항목 입력>>");
			num = scan.nextInt();

			switch(num){
			case 1:
				updateField = "mem_name";
				updatestr = "회원이름";
				break;
			case 2:
				updateField = "mem_tel";
				updatestr = "전화번호";
				break;
			case 3:
				updateField = "mem_addr";
				updatestr = "회원주소";
				break;
			default :
				System.out.println("수정 항목을 잘못 입력했습니다");
				System.out.println("다시 입력해주세요");
			}

		}while(num<1 || num>3);

		scan.nextLine();
		System.out.print("새로운 " + updatestr + ">>");
		String updateData = scan.nextLine();

		// 수정할 정보를 Map에 추가한다.
		// key값 => 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("memId", memId);
		paramMap.put("field", updateField);
		paramMap.put("data", updateData);

		int cnt = service.updateMember2(paramMap);

		if(cnt>0){
			System.out.println("자료 수정 성공");
		}else{
			System.out.println("자료 수정 실패");
		}



	}


	private void update(){


		System.out.println();
		System.out.print("수정할 회원 아이디 입력> ");
		String memId = scan.next();

		int count = service.getMemberCount(memId);

		if(count == 0){ //없는회원이면
			System.out.println("입력한 아이디  " +  memId + "는 없는 회원아이디입니다.");
			System.out.println("수정 작업 끝");
			return;
		}

		System.out.println("새로운 이름 : ");
		String memName = scan.next();

		System.out.println("새로운 전화번호 : ");
		String memTel = scan.next();

		scan.nextLine();
		System.out.println("새로운 주소 : ");
		String memAddr = scan.nextLine();

		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);

		int cnt = service.updateMember(memVo);

		if(cnt>0){
			System.out.println("자료 수정 성공");
		}else{
			System.out.println("자료 수정 실패");
		}

	}



	private void delete() {

		System.out.println();
		System.out.print("삭제할 회원 아이디 입력> ");
		String memId = scan.next();

		int cnt = service.deleteMember(memId);


		if(cnt>0){
			System.out.println("아이디 : " + memId + " 자료 삭제 성공");
		}else{
			System.out.println("아이디 : " + memId+" 자료 삭제 실패");
		}

	}



	private void insert() {

		System.out.println();
		System.out.println("멤버 정보 추가하기");

		int count =0;
		String memId;
		do{
			System.out.print("아 이 디 >> ");
			memId = scan.next();

			count = service.getMemberCount(memId);

			if(count > 0){
				System.out.println("입력한 아이디  " +  memId + "는 이미 등록된 아이디입니다.");
				System.out.println("다시 입력하세요");
			}
		}while(count>0);


		System.out.print("이   름 : ");
		String memName = scan.next();

		System.out.print("전화번호 : ");
		String memTel = scan.next();

		scan.nextLine(); //입력한 버퍼 비우기
		System.out.print("주소 : ");
		String memAddr = scan.nextLine();


		// Service로 보낼 MemberVO객체를 생성하고 입력한 자료를 셋팅한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);

		//service의 insert하는 메서드 호출하기
		int cnt = service.insertMember(memVo);

		if(cnt>0){
			System.out.println();
			System.out.println("insert 성공!");
		}else{
			System.out.println("insert 실패!");

		}
	}



}

















