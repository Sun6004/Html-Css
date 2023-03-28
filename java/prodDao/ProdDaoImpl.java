package prodDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;
import prodVo.ProdVO;

public class ProdDaoImpl implements ProdDao{

	private static ProdDao dao;

	private ProdDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static ProdDao getDao() {
		if (dao == null)
			dao = new ProdDaoImpl();
		return dao;
	}

	public List<ProdVO> selectProdList(String prod_gu) {
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		List<ProdVO> list = null;

		try {
			list = session.selectList("prod.selectProdList",prod_gu);
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public ProdVO prodByDetail(String prod_id) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		ProdVO vo = null;
		
		try {
			vo = session.selectOne("prod.prodBByDetail",prod_id);
		} finally {
			session.close();
		}
		return vo;
	}


}
