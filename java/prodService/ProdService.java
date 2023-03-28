package prodService;

import java.util.List;

import prodVo.ProdVO;

public interface ProdService {

	public List<ProdVO> selectProdList(String lprod_gu);

	public ProdVO prodByDetail(String prod_id);

	public List<ProdVO> getClass(String lgu);
}
