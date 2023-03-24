package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;

public class BuyerDaoImpl implements BuyerDao{
	
	private static BuyerDao dao;
	
	private static BuyerDao getDao() {
		if(dao == null) dao = new BuyerDaoImpl();
		return dao;
	}
	@Override
	public List<BuyerVO> selectIdName() {
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		List<BuyerVO> list = null;
		try {
			list = session.selectList("buyer.selectIdName");
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public BuyerVO selectById(String id) {
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		BuyerVO vo = null;
		try {
			vo = session.selectOne("buyer.selectById");
			
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}
	
}
