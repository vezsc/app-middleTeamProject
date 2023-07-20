package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import data.Board;

public class BoardsDAO extends DAO {
	public static int createBoard(Map<String, Object> board) {
		SqlSession session = factory.openSession();
		try {
			return session.insert("boards.createBoard", board);
		} finally {
			session.commit();
			session.close();
		}
	}

	public static List<Board> findByBoard(String continent) {
		SqlSession session = factory.openSession();
		try {
			return session.selectList("boards.findByBoard", continent);
		} finally {
			session.close();
		}
	}

	public static Board findByTargetBoard(int boardId) {
		SqlSession session = factory.openSession();
		try {
			return session.selectOne("boards.findByTargetBoard", boardId);
		} finally {
			session.close();
		}
	}
	
	public static List<Board> findByBoardsAtoB(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		try {
			return session.selectList("boards.findByBoardsAtoB", map);
		} finally {
			session.close();
		}
	}
	public static int deleteTargetBoard(String boardId) {
		SqlSession session = factory.openSession();
		try {
			return session.delete("boards.deleteTargetBoard", boardId);
		} finally {
			session.commit();
			session.close();
		}
		
		
		
	}
}