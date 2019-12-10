package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Award;
import Bean.Movie;

public  class AwardDAOImpl extends DAOBase implements AwardDAO{

	private static final String GET_MOVIE_BYAWARD_SQL =
			"SELECT * FROM movie, award WHERE movie.movieid = award.movieid AND awardname = (?)";
	private static final String GET_AWARD_BYMOVIE_SQL =
			"SELECT * FROM movie, award WHERE movie.movieid = award.movieid AND moviename = (?)";
	@Override
	public List<Movie> Search_byAward(String award) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> movielist = new ArrayList<Movie>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MOVIE_BYAWARD_SQL);
			pstmt.setString(1, award);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setMovieid(rs.getInt("movieid"));
				movie.setMoviename(rs.getString("moviename"));
				movie.setScreenwriter(rs.getString("screenwriter"));
				movie.setActor(rs.getString("actor"));
				movie.setType(rs.getString("type"));
				movie.setCountry(rs.getString("country"));
				movie.setLanguage(rs.getString("language"));
				movie.setReleasetime(rs.getDate("releasetime"));
				movie.setDuration(rs.getInt("duration"));
				movie.setIntroduction(rs.getString("introduction"));
				movielist.add(movie);
			}
			return movielist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Award> Search_Award_byMovie(String moviename) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Award> awardlist = new ArrayList<Award>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_AWARD_BYMOVIE_SQL);
			pstmt.setString(1, moviename);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Award award = new Award();
				award.setMovieid(rs.getInt("movieid"));
				award.setAwardname(rs.getString("awardname"));
				awardlist.add(award);
			}
			return awardlist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}

}
