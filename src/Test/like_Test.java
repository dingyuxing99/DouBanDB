package Test;

import Action.UserAction;
import DAO.DAOException;

public class like_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		UserAction ua = new UserAction();
		// ��¼����
		int id;
		System.out.println("1. �û���¼��");
		id = ua.login(1, "2019");
		//���Ե���
		System.out.println("2. ���Ե��ޣ�");
		System.out.println("\n�������ۣ�");
		ua.like_comment(id, 111);
		System.out.println("\n�����ѵ��޹������ۣ�");
		ua.like_comment(id, 111);
	}

}
