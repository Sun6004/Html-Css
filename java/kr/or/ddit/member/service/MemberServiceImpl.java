package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.dao.MemverDao;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVo;
/*
 * dao 객체의 메소드를 호출 실행 -dao객체 필요
 * 자기 자신의 객체를 생성하여 리턴
 */
public class MemberServiceImpl implements MemverService{

	private MemverDao dao;
	private static MemverService service;
	
	//생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	public static MemverService getService() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
 		return dao.getAllMember();
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idCheck(id);
	}

	@Override
	public List<ZipVo> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}
}
