package Action;
import Bean.*;
import DAO.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class UserAction {
	
	public void register(User u) throws DAOException {
		UserDAOMSImpl uImpl = new UserDAOMSImpl();
		int id = uImpl.addUser(u);
		if(id == -1)
			System.out.println("�û����Ѿ�����");
		else
			System.out.println("ע��ɹ����û�ID: " + id);
	}
	
	public int login(int id, String password) throws DAOException {
		UserDAOMSImpl uImpl = new UserDAOMSImpl();
		if(password.equals(uImpl.getUser(id).getPassword())) {
			System.out.println("��¼�ɹ�");
			return id;
		}
		else
			System.out.println("������󣬵�¼ʧ��");
		return -1;
	}
	
	public void like_comment(int userid, int commentid) throws DAOException {
		UserDAOMSImpl uImpl = new UserDAOMSImpl();
		if(uImpl.likeComment(userid, commentid) == true)
			System.out.println("���޳ɹ�");
		else
			System.out.println("�ѵ��޹�");
	}
	
	// �����Ӱ��Ϣ
	public void Browse(int userid, int movieid) throws DAOException {
		
		MovieDAOMSImpl movieimpl = new MovieDAOMSImpl();
		DirectorDAOMSImpl directorimpl = new DirectorDAOMSImpl();
		BrowseDAOMSImpl browseimpl = new BrowseDAOMSImpl();
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		
		// ��ȡ��Ӱ��Ϣ�����ݺ�������
		Movie movie = movieimpl.getMovie(movieid);
		List<Director> director = directorimpl.getDirector_byMovie(movieid);
		
		// ��ʾ��Ӱ��Ϣ	
		System.out.println("��Ӱ����" + movie.getMoviename());
		System.out.print("���ݣ�");
		for(int i = 0 ; i < director.size() ; i++) {
			if(i != 0) System.out.print("��");
		    System.out.print(director.get(i).getName());
		}
		System.out.println();
		System.out.println("��磺" + movie.getScreenwriter());
		System.out.println("���ݣ�" + movie.getActor());
		System.out.println("���ͣ�" + movie.getType());
		System.out.println("��Ƭ����/������" + movie.getCountry());
		System.out.println("���ԣ�" + movie.getLanguage());		
		System.out.println("��ӳ���ڣ�" + movie.getReleasetime());
		System.out.println("Ƭ����" + movie.getDuration() + "����");
		System.out.println("��������" + commentimpl.Search(movieid).size());
		System.out.println("�����飺\n       " + movie.getIntroduction());
		System.out.println();
		
		// ��������¼
		Browse browse = new Browse();
		browse.setMovieid(movieid);
		browse.setUserid(userid);
		
		browseimpl.addbrowse(browse);
		
	}
	
	// �����ʷ
	public void BrowseList(int userid) throws DAOException {
		
		BrowseDAOMSImpl browseimpl = new BrowseDAOMSImpl();
		MovieDAOMSImpl movieimpl = new MovieDAOMSImpl();
		UserDAOMSImpl userimpl = new UserDAOMSImpl();
		
		// ��ʾ
		System.out.println(userimpl.getUser(userid).getUsername() + " �������¼��");
		List<Browse> browse = browseimpl.Search(userid);
		
		for(int i = browse.size() - 1; i >= 0; i--) {
			System.out.println("�����Ӱ��" + movieimpl.getMovie(browse.get(i).getMovieid()).getMoviename() + "\t���ʱ�䣺" + browse.get(i).getBrowsetime());
		}
		System.out.println();
	}
	
}
