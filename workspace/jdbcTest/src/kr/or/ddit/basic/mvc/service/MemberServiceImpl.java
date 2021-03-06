package kr.or.ddit.basic.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//service객체는 Dao객체를 사용하기 때문에 Dao객체가 저장될 변수가 필요하다
	private IMemberDao memDao;
	
	
	//singleton만들기
	private static MemberServiceImpl memService;

	private MemberServiceImpl() {
		this.memDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		if(memService==null) memService = new MemberServiceImpl();
		return memService;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		return memDao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return memDao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paraMap) {
		return memDao.updateMember2(paraMap);
	}

}
