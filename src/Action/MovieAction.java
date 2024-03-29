package Action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Formatter;

import Bean.*;
import DAO.*;

class CommentGrade implements Comparable {
	
	Comment c;
	Integer cnt;
	
	public CommentGrade(Comment c, Integer cnt)
	{
		this.c = c;
		this.cnt = cnt;
	}
	
	public Comment getC() {
		return c;
	}
	public Integer getCnt() {
		return cnt;
	}

	@Override
	public int compareTo(Object b) {
		
		CommentGrade  cg = (CommentGrade)b;
		if(cg.cnt >= this.cnt) return 1;
		return cg.getCnt().compareTo(this.cnt);
	}
	
}
class Composite implements Comparable {
	Movie m;
	double b;
	public Composite(Movie m,Double b)
	{
		
		if(Double.isNaN(b))
			this.b = -1;
		else
			this.b = b;
		this.m = m;
	}
	public Movie getM() {
		return m;
	}
	public void setM(Movie m) {
		this.m = m;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	public int compareTo(Object b)
	{ 
	     Composite com=(Composite)b;
	     if(com.getB()-this.getB()>=0)
	    	 return 1;
	     else 
	    	 return -1;
	     
	 }
	
}

public class MovieAction {
	
	public void showMovieByScore() throws DAOException{
		MovieDAOMSImpl mImpl = new MovieDAOMSImpl();
		List<Movie> mList = mImpl.allMovies();
		Iterator<Movie> it = mList.iterator();
		TreeSet<Composite> col=new TreeSet<Composite>();
		while(it.hasNext())
		{
			Movie m = (Movie)it.next();
			col.add(new Composite(m,mImpl.getScore(m.getMovieid())));
		}
		Formatter formatter = new Formatter(System.out);
		
		
	     Iterator<Composite> iter=col.iterator();
    	 System.out.println("电影名称"+"\t\t\t"+"评分");
	     while(iter.hasNext())
	     { 
	    	 Composite com = (Composite)iter.next();

	    	 if(com.getB()==-1)
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+"暂无评分");
//	    		 formatter.format("%-100s %5s\n", com.getM().getMoviename(),"暂无评分");
	    	 }    		 
	    	 else
	    	 {
	    		 System.out.println(com.getM().getMoviename()+"\t\t\t"+com.getB());
//	    		 Double db = new Double(com.getB());
//	    		 formatter.format("%-100s %5d\n", com.getM().getMoviename(),com.getB());
	    	 }
	    		 
	     }
	}
	
	public void show_movie_by_director(int directorid) throws DAOException {
		MovieDAOMSImpl mImpl = new MovieDAOMSImpl();
		List<Movie> mlist;
		mlist = mImpl.getMovie_byDirector(directorid);
		if(mlist.size() == 0)
			System.out.println("无该导演指导的电影");
		else {
			System.out.println("指导过的电影包括: ");
			Iterator<Movie> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getMoviename());
			}
		}
	}
	
	public void show_movie_by_label(String Label) throws DAOException {
		LabelDAOImpl mImpl = new LabelDAOImpl();
		List<Movie> mlist;
		mlist = mImpl.Search_byLabel(Label);
		if(mlist.size() == 0)
			System.out.println("无该标签标记的电影");
		else {
			System.out.println(Label+"标签标记的电影包括: ");
			Iterator<Movie> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getMoviename());
			}
		}
	}
	
	public void show_label_by_movie(String moviename) throws DAOException {
		LabelDAOImpl mImpl = new LabelDAOImpl();
		List<Label> mlist;
		mlist = mImpl.Search_Label_byMovie(moviename);
		if(mlist.size() == 0)
			System.out.println("无该电影的标签");
		else {
			System.out.println(moviename+"的标签包括: ");
			Iterator<Label> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.print(it.next().getMovielabel()+"/");
			}
			System.out.println();
		}
	}
	
	public void show_movie_by_award(String award) throws DAOException {
		AwardDAOImpl mImpl = new AwardDAOImpl();
		List<Movie> mlist;
		mlist = mImpl.Search_byAward(award);
		if(mlist.size() == 0)
			System.out.println("无获得该奖项的电影");
		else {
			System.out.println("获得"+award+"的电影包括: ");
			Iterator<Movie> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getMoviename());
			}
		}
	}
	
	public void show_award_by_movie(String moviename) throws DAOException {
		AwardDAOImpl mImpl = new AwardDAOImpl();
		List<Award> mlist;
		mlist = mImpl.Search_Award_byMovie(moviename);
		if(mlist.size() == 0)
			System.out.println(moviename+"电影没有获奖");
		else {
			System.out.println(moviename+"的奖项包括: ");
			Iterator<Award> it = mlist.iterator();
			while(it.hasNext()) {
				System.out.print(it.next().getAwardname()+"/");
			}
			System.out.println();
		}
	}
	
	public void show_answer_by_talk(String talkname) throws DAOException {
		TalkDAOImpl mImpl = new TalkDAOImpl();
		List<Talk> mlist;
		int sum=0;
		mlist = mImpl.Search_byTalk(talkname);
		if(mlist.size() == 0)
			System.out.println("没有对“"+talkname+"”讨论的回复");
		else {
			System.out.println("“"+talkname+"”的回复包括: ");
			Iterator<Talk> it = mlist.iterator();
			while(it.hasNext()) {
				sum++;
				Talk temp=it.next();
				System.out.println(temp.getUserid()+"——"+temp.getTalkanswer());
			}
			System.out.println("			共有"+sum+"人参加讨论。");
			System.out.println();
		}
	}
	
	public void search_movie_by_type(String type) throws DAOException {
		MovieDAOMSImpl mImpl = new MovieDAOMSImpl();
		List<Movie> mlist;
		mlist = mImpl.Search_byType(type);
		if(mlist.size() == 0)
			System.out.println("无该类型的电影");
		else {
			System.out.println(type + "类电影包括: ");
			for(int i = 0; i < mlist.size(); i++) {
				System.out.print("电影名: " + mlist.get(i).getMoviename() + " ");
				System.out.println("类别: " + mlist.get(i).getType());
			}
		}
	}
	
	
	// 查看评论
	public void comment_show(int movieid) throws DAOException {
		
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		MovieDAOMSImpl movieimpl = new MovieDAOMSImpl();
		UserDAOMSImpl userimpl = new UserDAOMSImpl();
		List<Comment> cList = commentimpl.Search(movieid);
		
		System.out.println("电影名：\t" + movieimpl.getMovie(movieid).getMoviename());
		System.out.println("所有评论：");
		for(int i = cList.size() - 1; i >= 0; i--) {
			//System.out.println("评论人：" + userimpl.getUser(cList.get(i).getUserid()).getUsername());
			System.out.println("评论时间：" + cList.get(i).getTime());
			System.out.println("打分：" + cList.get(i).getScore());
			//System.out.println("点赞数：" + commentimpl.likeComment(cList.get(i).getCommentid()));
			System.out.println("评论内容：");
			System.out.println(cList.get(i).getText());
		}
		System.out.println();
	}
	
	// 添加评论
	public void comment(int userid, int movieid, String text, int score) throws DAOException {
		
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		
		Comment c = new Comment();
		c.setUserid(userid);
		c.setMovieid(movieid);
		c.setText(text);
		c.setScore(score);
		
		commentimpl.addComment(c);
	}
	
	// 删除评论
	public void comment_delete(int userid, int commentid) throws DAOException {
		
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		
		Comment c = commentimpl.getComment(commentid);
		if(c.getUserid() != userid) {
			System.out.println("删除失败，您没有权限删除别人的评论");
			return;
		}
		
		commentimpl.deleteComment(commentid);
		System.out.println("删除成功");
	}
	
	// 修改评论
	public void comment_update(int userid, int commentid, String text, int score) throws DAOException {
		
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		
		Comment c = commentimpl.getComment(commentid);
		if(c.getUserid() != userid) {
			System.out.println("修改失败，您没有权限修改别人的评论");
			return;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		c.setTime(date);
		c.setText(text);
		c.setScore(score);
		
		commentimpl.updateComment(c);
		System.out.println("修改成功");
	}
		
	// 评论按点赞排序
	public void comment_sort(int movieid) throws DAOException {
		
		CommentDAOMSImpl commentimpl = new CommentDAOMSImpl();
		MovieDAOMSImpl movieimpl = new MovieDAOMSImpl();
		UserDAOMSImpl userimpl = new UserDAOMSImpl();
		
		// 排序
		TreeSet<CommentGrade> col=new TreeSet<CommentGrade>();
		List<Comment> cList = commentimpl.Search(movieid);
		Iterator<Comment> it = cList.iterator();
		while(it.hasNext())
		{
			Comment comment = (Comment)it.next();
			col.add(new CommentGrade( comment,commentimpl.likeComment(comment.getCommentid())));
		}
		
		// 输出
		System.out.println("电影名：\t" + movieimpl.getMovie(movieid).getMoviename());
		System.out.println("所有评论（按点赞数）：");
		Iterator<CommentGrade> itr = col.iterator();
		
		while(itr.hasNext()) {
			CommentGrade comment = (CommentGrade)itr.next();
			
			//System.out.println("评论人：" + userimpl.getUser(comment.getC().getUserid()).getUsername());
			System.out.println("评论时间：" + comment.getC().getTime());
			System.out.println("打分：" + comment.getC().getScore());
			System.out.println("点赞数：" + commentimpl.likeComment(comment.getC().getCommentid()));
			System.out.println("评论内容：");
			System.out.println(comment.getC().getText());
		}
		System.out.println();
		
	}
	
}
