package Test;

import Action.UserAction;
import DAO.DAOException;

public class browse_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		System.out.println("****************≤‚ ‘‰Ø¿¿****************");
		ua.Browse(1,1);
		ua.Browse(1,2);
		ua.Browse(1,3);
		ua.Browse(1,4);
		ua.Browse(1,5);
		ua.Browse(1,6);
		System.out.println("‰Ø¿¿º«¬º»Áœ¬: "
				+ "\n");
		ua.BrowseList(5);
	}
}
