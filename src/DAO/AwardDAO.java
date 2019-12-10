package DAO;

import java.util.List;

import Bean.Award;
import Bean.Movie;

public interface AwardDAO {
	public List<Movie> Search_byAward(String award) throws DAOException;
	public List<Award> Search_Award_byMovie(String moviename) throws DAOException;
}
