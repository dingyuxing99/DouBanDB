package Test;

import Action.UserAction;
import DAO.DAOException;

public class like_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		// 登录测试
		int id;
		System.out.println("1. 用户登录：");
		id = ua.login(1, "2019");
		//测试点赞
		System.out.println("2. 测试点赞：");
		System.out.println("\n点赞评论：");
		ua.like_comment(id, 111);
		System.out.println("\n点赞已点赞过的评论：");
		ua.like_comment(id, 111);
	}

}
