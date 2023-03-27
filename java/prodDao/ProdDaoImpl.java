package prodDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;
import prodVo.ProdVO;

public class ProdDaoImpl implements ProdDao{

	private SqlSessionFactory sessionFactory;
	private static ProdDao dao;
	
	//생성자
	private ProdDaoImpl() {
		sessionFactory = MybatisSqlsessionFactory.getSessionFactory();
	}
	
	public static ProdDao getDao() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	@Override
	public List<ProdVO> getAllProd() {
		SqlSession session = null;
		List<ProdVO> list = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("prod.getAllProd");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			session.commit();
		}
		return null;
	}

}
