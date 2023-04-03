package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import borad.vo.BoardVO;
import borad.vo.PageVO;
import borad.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	//dao 객체
	private IBoardDao dao;
	
	//자신의 객체
	private static IBoardService service;
	
	//생성자 - dao객체 얻기
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	// 자신의 객체를 생성하고 리턴하는 메서드
	public static IBoardService getService() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(num);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public int updateHit(int num) {
		// TODO Auto-generated method stub
		return dao.updateBoard(null);
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectByPage(map);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(null);
	}

	@Override
	public int deleteReply(int renum) {
		// TODO Auto-generated method stub
		return dao.deleteReply(renum);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.updateReply(vo);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.totalCount(map);
	}

	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		//전체 글 개수 구하기
		Map<String, Object> map = new HashMap<>();
		map.put("sword", sword);
		map.put("stype", stype);
		
		int count = this.totalCount(map);
		
		// 전체 페이지 수 구하기
		int totalPage = count / PageVO.getPerList();
		
		
		return null;
	}
	
}
