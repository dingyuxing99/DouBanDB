package Test;

import Action.MovieAction;
import DAO.DAOException;

public class award_Test {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		System.out.println("**************����ͨ����Ӱ���������Ӱ**************");
		ma.show_movie_by_award("��Ѷ���������");
		System.out.println();
		ma.show_movie_by_award("���ֵ�Ӱ����������Ԫ");
		System.out.println("**************����ͨ����Ӱ������Ӱ����**************");
		ma.show_award_by_movie("�������");
		System.out.println();
		ma.show_award_by_movie("��С��ս��");
		System.out.println();
		ma.show_award_by_movie("�й�����");
	}
}
