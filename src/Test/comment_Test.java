package Test;

import Action.MovieAction;
import DAO.DAOException;

public class comment_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		MovieAction ma = new MovieAction();
		System.out.println("��������ѽ:");
		System.out.println("\n�鿴����: ");
		ma.comment_show(3);
		System.out.println("\n������ۣ�");
		System.out.println("����������۹��ĵ�Ӱ�������ۣ�");
		ma.comment(1, 3, "�����Ҷ��������ɻ�����,ŷ����˧!", 5);
		System.out.println("�����δ���۹��ĵ�Ӱ�������ۣ�");
		ma.comment(1, 5, "���ֵܵ�̫����!!!!�Ұ���!!!!", 5);
		ma.comment(1, 1, "�������Ҳ�����!!!!", 4);
		
		
		
		System.out.println("\nɾ�����ۣ�");
		System.out.println("ɾ�����˵����ۣ�");
		ma.comment_delete(1, 89);
		System.out.println("ɾ���Լ������ۣ�");
		ma.comment_delete(1, 79);
		System.out.println("\n�޸����ۣ�");
		System.out.println("�޸ı��˵����ۣ�");
		ma.comment_update(1, 90, "������������������������", 5);
		System.out.println("�޸��Լ������ۣ�");
		ma.comment_update(1, 96, "����ֹֿ�����", 2);
		System.out.println("�������۰���������");
		ma.comment_sort(3);

	}

}
