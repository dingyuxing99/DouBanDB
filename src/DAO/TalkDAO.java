package DAO;

import java.util.List;

import Bean.Talk;

public interface TalkDAO {

	public List<Talk> Search_byTalk(String talkname) throws DAOException;
}
