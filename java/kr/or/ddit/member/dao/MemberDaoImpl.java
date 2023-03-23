package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;

/*
 *  자신의 객체를 생성해서 리턴하는 메소드
 *  mapper에 접근하여 sql문을 실행 - SqlSession객체가 필요 -SqlSessionFactory가 생성함
 */
public class MemberDaoImpl implements MemverDao{
	
	private SqlSessionFactory sessionFactory;
	private static MemverDao dao;
	
	//생성자
	private MemberDaoImpl() {
		sessionFactory = MybatisSqlsessionFactory.getSessionFactory();
	}
	
	//자기 자신 객체를 리턴
	public static MemverDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	public List<MemberVO> getAllMember(){
		//sqlsession  객체 필요
		//SqlSession session = sessionFactory.openSession(true);
		SqlSession session = null;
		List<MemberVO> list = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}	
		return list;
	}
//	public int insertMember(MemberVO vo) {
//		int a = 0;
//		SqlSession session =  sessionFactory.openSession(true);
//		try {
//			a = session.insert("member.insertMember", vo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {	
//			session.close();
//		}
//		return a;
//	}
	
}
