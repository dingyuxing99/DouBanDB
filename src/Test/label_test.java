package Test;

import Action.MovieAction;
import DAO.DAOException;

public class label_test {

	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************测试通过电影标签检索电影**************");
		ma.show_movie_by_label("2019");
		System.out.println();
		ma.show_movie_by_label("犯罪");
		System.out.println();
		ma.show_movie_by_label("奇幻");
		System.out.println("**************测试通过电影检索电影标签**************");
		ma.show_label_by_movie("中国机长");
		System.out.println();
		ma.show_label_by_movie("少年的你");
	}
}
