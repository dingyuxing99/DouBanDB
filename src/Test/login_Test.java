package Test;

import Action.UserAction;
import DAO.DAOException;

public class login_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		int id;
		System.out.println("**************�����û���¼***************");
		System.out.println("\n�������");
		id = ua.login(53,"001");
		System.out.println("\n������ȷ��");
		id = ua.login(53, "2019");
	}

}
