package Test;

import Action.MovieAction;
import DAO.DAOException;

public class talk_Test {

	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************����ͨ�����ۻ�������ظ�����**************");
		ma.show_answer_by_talk("2019������ϲ���ĵ�Ӱ��");
		System.out.println();
		ma.show_answer_by_talk("�����������ǧ�����ݼ���");
		System.out.println();
		ma.show_answer_by_talk("����ô������������������");
	}
}
