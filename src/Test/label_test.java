package Test;

import Action.MovieAction;
import DAO.DAOException;

public class label_test {

	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************����ͨ����Ӱ��ǩ������Ӱ**************");
		ma.show_movie_by_label("2019");
		System.out.println();
		ma.show_movie_by_label("����");
		System.out.println();
		ma.show_movie_by_label("���");
		System.out.println("**************����ͨ����Ӱ������Ӱ��ǩ**************");
		ma.show_label_by_movie("�й�����");
		System.out.println();
		ma.show_label_by_movie("�������");
	}
}
