package kr.or.ddit.basic.mvc.dao;

import java.util.List;

import kr.or.ddit.basic.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 
 * Service에 전달하는 interface
 * 
 * 각각의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author PC-02
 *
 */

public interface IMemberDao {
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo   insert할 데이터가 저장된 MemberVO객체
	 * 
	 * @return  insert 성공 : 1 , 실패 : 0  반환
	 */
	public int insertMember(MemberVO memVo);

	/**
	 * 회원ID를 인수로 받아서 해당회원 정보를 삭제하는 메서드
	 * @param memId  삭제할 회원ID
	 * @return  삭제성공 : 1 , 실패 : 0  반환
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO 자료를 이용하여 회원정보를 Update하는 메서드
	 * @param memVo  Update할 회원 정보가 저장된 MemberVO객체
	 * @return  작업성공 : 1 , 실패 : 0  반환
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체를 담고있는 List객체
	 */
	public List<MemberVO >getAllMember();
	
	/**
	 * 회원ID를 인수로 받아서 해당 회원의 개수를 반환하는 메서드
	 * @param memId  검색할 회원ID
	 * @return  검색된 회원ID 개수
	 */
	public int getMemberCount(String memId);
	
	public int updateMem (MemberVO memvo);
}














