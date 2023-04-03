package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import borad.vo.BoardVO;
import borad.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MybatisSqlsessionFactory;

public class BoardDaoImpl implements IBoardDao{

	//자신의 객체
	private static IBoardDao dao;
	private BoardDaoImpl() {
		
	}
	
	//자신의 객체를 생성하고 리턴하는 메서드
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.insert("board.insertBoard",vo);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.delete("board.deleteBoard", num);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.update("board.updateBoard", vo);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int updateHit(int num) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.update("board.updateHit", num);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		List<BoardVO> list = null;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();

		try {
			list = session.selectList("board.selectByPage", map);
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.insert("board.insertReply", vo);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int deleteReply(int renum) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.delete("board.deleteReply", renum);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int res = 0;
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		try {
			res = session.update("board.updateReply", vo);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = MybatisSqlsessionFactory.getSqlSession();
		int res = 0;
		try {
			res = session.selectOne("board.totalCount", map);
		} finally {
			session.commit();
			session.close();
		}
		return 0;
	}
	
}
