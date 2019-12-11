package Test;

import Action.UserAction;
import Bean.User;
import DAO.DAOException;

public class regist_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		// 注册测试
		System.out.println("********************测试用户注册*********************");		
		System.out.println("\n若用户名重复：");
		User u = new User();
		u.setUsername("zy2019");
		u.setPassword("2019");
		u.setEmail("zhangying@163.com");
		ua.register(u);
		System.out.println("\n若用户名不重复：");
		u.setUsername("zy");
		ua.register(u);
	}

}
