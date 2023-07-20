package repository;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class AppliesDAO extends DAO{
	public static int applicantCnt(String boardId) {
		SqlSession session = factory.openSession();
		try {
			return session.selectOne("applies.applicantCnt", boardId);
		} finally {
			session.close();
		}
	}
	public static int apply(String boardId, String entry) {
		SqlSession session = factory.openSession();
		try {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put("boardId", boardId);
			map.put("entry", entry);
			return session.insert("applies.apply", map);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public static int findByApply (String boardId, String entry) {
		SqlSession session = factory.openSession();
		try {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put("boardId", boardId);
			map.put("entry", entry);
			return session.selectOne("applies.findByApply", map);
		} finally {
			session.close();
		}
		
	}
	
}
