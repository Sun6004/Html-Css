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
		if (service == null)
			service = ProdServiceImpl.getService();

		return service;
	}

	@Override
	public List<ProdVO> selectProdList(String lprod_gu) {
		// TODO Auto-generated method stub
		return dao.selectProdList(lprod_gu);
	}

	@Override
	public ProdVO prodByDetail(String prod_id) {
		// TODO Auto-generated method stub
		return dao.prodByDetail(prod_id);
	}

	@Override
	public List<ProdVO> getClass(String lgu) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
