package Test;

import Action.MovieAction;
import DAO.DAOException;

public class talk_Test {

	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************测试通过讨论话题检索回复内容**************");
		ma.show_answer_by_talk("2019年你最喜欢的电影？");
		System.out.println();
		ma.show_answer_by_talk("如何评价易烊千玺的演技？");
		System.out.println();
		ma.show_answer_by_talk("你怎么看待国产动画的崛起？");
	}
}
