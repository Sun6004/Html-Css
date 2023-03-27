package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDao;
import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements BuyerService{
	
	private BuyerDao dao;
	private static BuyerService service;
	private BuyerServiceImpl () {
		dao = BuyerDaoImpl.getDao();
	}
	
	public static BuyerService getService() {
		if(service ==null) service = new BuyerServiceImpl();
		return service;
	}
	
	@Override
	public List<BuyerVO> selectIdName() {
		// TODO Auto-generated method stub
		
		return dao.selectIdName();
	}

	@Override
	public BuyerVO selectById(String id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}
	
}
