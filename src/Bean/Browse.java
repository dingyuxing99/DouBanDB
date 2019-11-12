package Bean;
import java.sql.*;
import java.text.*;

public class Browse {
	private int browseid;
	private int userid;
	private int movieid;
	private String browsetime;
	
	public int getBrowseid() {
		return browseid;
	}
	public void setBrowseid(int browseid) {
		this.browseid = browseid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getBrowsetime() {
		return browsetime;
	}
	public void setBrowsetime(String browsetime) {
		this.browsetime = browsetime;
	}
}
