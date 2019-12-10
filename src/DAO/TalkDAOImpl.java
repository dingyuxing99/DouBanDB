package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Award;
import Bean.Talk;

public  class TalkDAOImpl extends DAOBase implements TalkDAO{

	private static final String GET_ANSWER_BYTALK_SQL =
			"SELECT * FROM talk,talkInfo WHERE talk.talkid = talkInfo.talkid AND talk = (?)";

	@Override
	public List<Talk> Search_byTalk(String talkname) throws DAOException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Talk> talklist = new ArrayList<Talk>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_ANSWER_BYTALK_SQL);
			pstmt.setString(1, talkname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Talk talk = new Talk();
				talk.setTalkid(rs.getInt("talkid"));
				talk.setTalkanswer(rs.getString("talkanswer"));
				talk.setUserid(rs.getInt("userid"));
				talklist.add(talk);
			}
			return talklist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}
}
