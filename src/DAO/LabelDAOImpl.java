package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Label;
import Bean.Movie;

public  class LabelDAOImpl extends DAOBase implements LabelDAO{

	private static final String GET_MOVIE_BYLABEL_SQL =
			"SELECT * FROM movie, label WHERE movie.movieid = label.movieid AND movielabel = (?)";
	private static final String GET_LABEL_BYMOVIE_SQL =
			"SELECT * FROM movie, label WHERE movie.movieid = label.movieid AND moviename = (?)";
	@Override
	public List<Movie> Search_byLabel(String Label) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Movie> movielist = new ArrayList<Movie>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MOVIE_BYLABEL_SQL);
			pstmt.setString(1, Label);
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
	
	public List<Label> Search_Label_byMovie(String moviename) throws DAOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Label> labellist = new ArrayList<Label>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_LABEL_BYMOVIE_SQL);
			pstmt.setString(1, moviename);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Label label=new Label();
				label.setMovieid(rs.getInt("movieid"));
				label.setMovielabel(rs.getString("movielabel"));
				labellist.add(label);
			}
			return labellist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}

}
