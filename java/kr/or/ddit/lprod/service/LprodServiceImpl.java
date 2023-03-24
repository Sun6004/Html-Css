package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/*
 *  dao의 메서드를 호출하여 실행 - dao객체가 필요
 *  자신의 객체를 생성하여 리턴하는 메서드 필요
 */
public class LprodServiceImpl implements IlprodService{
	
	private IlprodDao dao;
	private static IlprodService service;
	
	//생성자
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getDao();
	}
	//메서드
	public static IlprodService getService() {
		if(service == null) service = new LprodServiceImpl();
		
		return service;
	}
	
	@Override
	public List<LprodVO> selectAll() {
//		List<LprodVO> list = null;
//		list = dao.selectAll();
//		return list;
		return dao.selectAll();
	}
	
}
