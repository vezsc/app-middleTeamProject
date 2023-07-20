package repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import data.User;

public class UsersDAO extends DAO{
	
	public static int create(Map map) {
		SqlSession session = factory.openSession(true);
		try {
			return session.insert("users.createUser", map);
		} finally {
			session.close();
		}
		
	}
	public static User findUser(String id) {
		SqlSession session = factory.openSession(true);
		try {
			return session.selectOne("users.findByUser",id) ;
		} finally {
			session.close();
		}
	}
}
