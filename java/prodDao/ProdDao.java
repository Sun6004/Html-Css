package prodDao;

import java.util.List;

import prodVo.ProdVO;

public interface ProdDao {
	public List<ProdVO> selectProdList(String lprod_gu);

	public ProdVO prodByDetail(String prod_id);
	
}
