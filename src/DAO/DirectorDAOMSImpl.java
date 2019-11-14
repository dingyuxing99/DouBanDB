package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.C3P0ProxyConnection;

import Bean.Director;

public class DirectorDAOMSImpl extends DAOBase implements DirectorDAO{
	
	public static final String ADD_DIRECTOR_SQL = "INSERT INTO director VALUES (?, ?, ?, ?, ?, ?)";
	@Override
	public void addDirector(Director dir) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ADD_DIRECTOR_SQL);
			pstmt.setInt(1, dir.getDirectorid());
			pstmt.setString(2, dir.getName());
			pstmt.setString(3, dir.getSex());
			pstmt.setString(4, dir.getBirthplace());
			pstmt.setString(5, dir.getBirthplace());
			pstmt.setString(6, dir.getProfile());
			pstmt.executeUpdate();//
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	public static final String DELETE_DIRECTOR_SQL = "DELETE FROM director WHERE directorid = ?";
	@Override
	public void deleteDirector(int id) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_DIRECTOR_SQL);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();//
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}

	public static final String UPDATE_DIRECTOR_SQL = "UPDATE director SET name = ?, sex = ?,"
			+ "birthday = ?, birthplace = ?, profile = ?"+"WHERE directorid = ?";
	@Override
	public void updateDirector(Director dir) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_DIRECTOR_SQL);
			pstmt.setInt(6,dir.getDirectorid());
			pstmt.setString(1, dir.getName());
			pstmt.setString(2, dir.getSex());
			pstmt.setDate(3, dir.getBirthday());
			pstmt.setString(4, dir.getBirthplace());
			pstmt.setString(5, dir.getProfile());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0JdbcUtil.release(conn, pstmt, null);
		}
	}
	
	public static final String GET_USER_SQL = "SELECT name, sex,"
			+ "birthday, birthplace, profile FROM director WHERE directorid = ?";
			
	@Override
	public Director getDirector_byId(int id) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_USER_SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.next()) {
					Director d = new Director();
					d.setDirectorid(id);
					d.setName(rs.getString("name"));
					d.setSex(rs.getString("sex"));
					d.setBirthday(rs.getDate("birthday"));
					d.setBirthplace(rs.getString("birthplace"));
					d.setProfile(rs.getString("profile"));
					return d;	
				}
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		
		
		return null;
	}
	
	public static final String GET_DIRECTOR_BYMOVIE_SQL = "SELECT director.directorid, name, sex,"
			+ "birthday, birthplace, profile FROM director, direct "
			+ "WHERE movieid=(?) AND director.directorid = direct.directorid ";
	@Override
	public List<Director> getDirector_byMovie(int movieid) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Director> directorlist = new ArrayList<Director>();
		try {
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(GET_DIRECTOR_BYMOVIE_SQL);
			pstmt.setInt(1, movieid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Director d = new Director();
				d.setDirectorid(rs.getInt("directorid"));
				d.setName(rs.getString("name"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getDate("birthday"));
				d.setBirthplace(rs.getString("birthplace"));
				d.setProfile(rs.getString("profile"));
				directorlist.add(d);
			}
			return directorlist;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}

	public static final String SEARCH_DIRECTOR_SQL = "SELECT name, sex, birthday,"
			+ " birthplace, profile FROM director, WHERE name = %?%;";
	@Override
	public List<Director> searchDirector(String name) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Director> directorlist = new ArrayList<Director>();
		try {
			conn = C3P0JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SEARCH_DIRECTOR_SQL);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Director d = new Director();
				d.setDirectorid(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getDate("birthday"));
				d.setBirthplace(rs.getString("birthplace"));
				d.setProfile(rs.getString("profile"));
				directorlist.add(d);
			}
			return directorlist;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0JdbcUtil.release(conn, pstmt, rs);
		}
		return null;
	}
}
