package DAO;

import java.util.List;

import Bean.Label;
import Bean.Movie;

public interface LabelDAO {

	public List<Movie> Search_byLabel(String Label) throws DAOException;
	public List<Label> Search_Label_byMovie(String moviename) throws DAOException;
}
