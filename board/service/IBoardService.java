package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import board.vo.PageVO;
import board.vo.ReplyVO;

public interface IBoardService {
	
	//글쓰기 -실행된 행의 개수리턴 - 시퀀스값을 리턴
	public int insertBoard(BoardVO vo);
	
	//글삭제
	public int deleteBoard(int num);
	
	//글수정
	public int updateBoard(BoardVO vo);
	
	//조회수증가
	public int updateHit(int num);
	
	//리스트(검색)
	public List<BoardVO> selectByPage(Map<String, Object> map);
	
	//댓글쓰기
	public int insertReply(ReplyVO vo);
	
	//댓글삭제
	public int deleteReply(int renum);
	
	//댓글수정
	public int updateReply(ReplyVO vo);
	
	//페이지별 정보구하기(페이지 처리)
	public PageVO pageInfo(int page, String stype, String sword);
	
	//전체 글 개수 구하기
	public int totalCount(Map<String, Object> map);
	
	
}
