package Test;

import Action.UserAction;
import DAO.DAOException;

public class login_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		int id;
		System.out.println("**************²âÊÔÓÃ»§µÇÂ¼***************");
		System.out.println("\nÃÜÂë´íÎó£º");
		id = ua.login(53,"001");
		System.out.println("\nÃÜÂëÕıÈ·£º");
		id = ua.login(53, "2019");
	}

}
