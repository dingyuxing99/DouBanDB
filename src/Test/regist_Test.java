package Test;

import Action.UserAction;
import Bean.User;
import DAO.DAOException;

public class regist_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		// ע�����
		System.out.println("********************�����û�ע��*********************");		
		System.out.println("\n���û����ظ���");
		User u = new User();
		u.setUsername("zy2019");
		u.setPassword("2019");
		u.setEmail("zhangying@163.com");
		ua.register(u);
		System.out.println("\n���û������ظ���");
		u.setUsername("zy");
		ua.register(u);
	}

}
