package Test;

import Action.MovieAction;
import DAO.DAOException;

public class comment_Test {

	public static void main(String[] args) throws DAOException {
		// TODO Auto-generated method stub
		MovieAction ma = new MovieAction();
		System.out.println("测试评论呀:");
		System.out.println("\n查看评论: ");
		ma.comment_show(3);
		System.out.println("\n添加评论：");
		System.out.println("如果对已评论过的电影进行评论：");
		ma.comment(1, 3, "看得我都不敢坐飞机了呢,欧豪真帅!", 5);
		System.out.println("如果对未评论过的电影进行评论：");
		ma.comment(1, 5, "四字弟弟太棒惹!!!!我爱他!!!!", 5);
		ma.comment(1, 1, "我命由我不由天!!!!", 4);
		
		
		
		System.out.println("\n删除评论：");
		System.out.println("删除别人的评论：");
		ma.comment_delete(1, 89);
		System.out.println("删除自己的评论：");
		ma.comment_delete(1, 79);
		System.out.println("\n修改评论：");
		System.out.println("修改别人的评论：");
		ma.comment_update(1, 90, "啊啊啊啊啊啊啊啊啊啊啊啊", 5);
		System.out.println("修改自己的评论：");
		ma.comment_update(1, 96, "奇奇怪怪看不懂", 2);
		System.out.println("测试评论按点赞排序");
		ma.comment_sort(3);

	}

}
