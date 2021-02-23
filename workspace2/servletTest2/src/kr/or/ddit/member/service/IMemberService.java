package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

/**
 * Dao에 작성된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고
 * 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * 보통 Dao의 메서드 구조와 같게 만든다.
 * 
 * @author PC-10
 *
 */


public interface IMemberService {

      /**
       * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
       * 
       * @param memvo insert할 데이터가 저장된 memberVO객체
       * @return insert 성공 : 1, 실패 : 0
       */
      
      
      public int insertMember(MemberVO memVo);
      /**
       * 회원 ID를 인수로 받아서 해당 회원 정보를 삭헤하는 메서드
       * @param memId 삭제할 회원ID
       * @return 삭제성공 : 1, 삭제실패: 0
       */
      
      
      public int deleteMember(String memId);
      /**
       * MemberVO자료를 이용하여 회원 정보를 update하는 메서드
       * @param memVO update할 회원 정보가 저장된 MemberVO객체
       * @return 작업성공 : 1, 작업실패 : 0
       */
      
      
      public int updateMember(MemberVO memVo);
      
      
      /**
       * DB의 전체 회원 정보를 가져와서 List에 담아서 변환하는 메서드
       * @return MemberVO객체를 담고있는 List객체
       */
      
      
      public List<MemberVO> getAllMember();
      
      
      /**
       * 회원ID를 인수로 받아서 해당 회원의 개수를 반환하는 메서드
       * @param memId 검색할 회원ID
       * @return 검색된 회원ID 개수
       */
      
      
      public int getMemberCount(String memId);
      
      /**
  	 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메서드
  	 * 	key값 정보 => 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
  	 * @param paraMap  수정할 컬럼, 수정할 데이터, 회원id가 저장된 Map객체
  	 * @return  작업성공 : 1 , 실패 : 0  
  	 */
      public int updateMember2 (Map<String, String> paraMap);
      
      /**
  	 * 회원 ID를 인자값으로 받아서 해당 회원 정보를 반환하는 메서드
  	 * @param memId 검색할 회원 ID
  	 * @return 검색된 회원 정보가 저장된 MemberVO객체
  	 */
  	public MemberVO getMember(String memId);
   
}