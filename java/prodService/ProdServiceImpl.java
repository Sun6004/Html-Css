package prodService;

import java.util.List;

import prodDao.ProdDao;
import prodDao.ProdDaoImpl;
import prodVo.ProdVO;

public class ProdServiceImpl implements ProdService{
	
	private ProdDao dao;
	private static ProdService service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	
	public static ProdService getService() {
		if(service == null) service = new ProdServiceImpl();
		return service;
	}

	@Override
	public List<ProdVO> getAllProd() {		
		return dao.getAllProd();
	}
	
	
}
