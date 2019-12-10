package Test;

import Action.MovieAction;
import DAO.DAOException;

public class award_Test {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************测试通过电影奖项检索电影**************");
		ma.show_movie_by_award("最佳动画配音奖");
		System.out.println();
		ma.show_movie_by_award("柏林电影节新生代单元");
		System.out.println("**************测试通过电影检索电影奖项**************");
		ma.show_award_by_movie("少年的你");
		System.out.println();
		ma.show_award_by_movie("罗小黑战记");
		System.out.println();
		ma.show_award_by_movie("中国机长");
	}
}
