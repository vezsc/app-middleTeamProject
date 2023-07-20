package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import data.Comment;

public class CommentsDAO extends DAO {
	public static List<Comment> findCountryComments(String country) {
		SqlSession session = factory.openSession();
		try {
			return session.selectList("comments.findCountryComments", country);
		} finally {
			session.close();
		}

	}

	public static int createComment(Map<String, Object> map) {
		SqlSession session = factory.openSession(true);
		try {
			return session.insert("comments.createComment", map);
		} finally {
			session.close();
		}
	}
	
	public static List<Comment> findByCommentsAtoB(Map<String,Object>map){
		SqlSession session = factory.openSession(true);
		try {
			return session.selectList("comments.findByCommentsAtoB", map) ;
		} finally {
			session.close();
		}
	}
}
