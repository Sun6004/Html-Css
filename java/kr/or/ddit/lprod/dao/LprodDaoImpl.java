package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;

/*
 * SqlSession 필요 - 
 * 자기 자신의 객체를 생성하여 리턴하는 메서드
 */
public class LprodDaoImpl implements IlprodDao{

	private static IlprodDao dao;
	
	//생성자
	
	//자기 자신 객체를 리턴
	public static IlprodDao getDao() {
		if(dao == null)dao = new LprodDaoImpl();
		return dao;
	}
	
	@Override
	public List<LprodVO> selectAll() {
		
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		List<LprodVO> list = null;
		
		try {		
			list = session.selectList("lprod.selectAll");
			
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}
	
}
