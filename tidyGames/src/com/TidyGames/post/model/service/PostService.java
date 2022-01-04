package com.TidyGames.post.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.post.model.dao.PostDao;
import com.TidyGames.post.model.vo.Post;
import com.TidyGames.post.model.vo.PostFile;
import com.TidyGames.post.model.vo.PostLike;
import com.TidyGames.post.model.vo.Reply;

public class PostService {

	PostDao pd = new PostDao();

	public int selectPostListCount() {
		Connection conn = getConnection();
		int listCount = pd.selectPostListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Post> selectPostList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Post> list = pd.selectPostList(conn, pi);
		close(conn);
		return list;
	}

	public int increaseCount(int postNo) {
		Connection conn = getConnection();
		int result = pd.increaseCount(conn, postNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Post selectPostDetail(int postNo) {
		Connection conn = getConnection();
		Post pf = pd.selectPostDetail(conn, postNo);
		close(conn);
		return pf;
	}

	public ArrayList<PostFile> selectPostFile(int postNo) {
		Connection conn = getConnection();
		ArrayList<PostFile> list = pd.selectPostFile(conn, postNo);
		close(conn);
		return list;
	}

	public Post firstPostNo() {
		Connection conn = getConnection();
		Post fpn = pd.firstPostNo(conn);
		close(conn);
		return fpn;
	}

	public Post lastPostNo() {
		Connection conn = getConnection();
		Post lpn = pd.lastPostNo(conn);
		close(conn);
		return lpn;
	}

	public int insertPost(Post p, ArrayList<PostFile> list) {
		Connection conn = getConnection();

		int result1 = pd.insertPost(conn, p);
		int result2 = 1;

		if (list != null) {
			result2 = pd.insertFile(conn, list);
		}

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result1 * result2;
	}

	public int deletePost(int postNo) {
		Connection conn = getConnection();
		int result = pd.deletePost(conn, postNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int updatePost(Post p) {
		Connection conn = getConnection();
		int result = pd.updatePost(conn, p);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// ==============================================================================

	public int nicknamePostCount(String word) {
		Connection conn = getConnection();
		int result = pd.nicknamePostCount(conn, word);
		close(conn);
		return result;
	}

	public int searchPostCount(String word) {
		Connection conn = getConnection();
		int result = pd.searchPostCount(conn, word);
		close(conn);
		return result;
	}

	public ArrayList<Post> selectSearchList(String search, PageInfo pi, String word) {
		Connection conn = getConnection();
		ArrayList<Post> list = new ArrayList<>();

		switch (search) {
		case "r":
			list = pd.searchRecentPost(conn, pi, word);
			break;
		case "v":
			list = pd.searchViewPost(conn, pi, word);
			break;
		case "l":
			list = pd.searchLikePost(conn, pi, word);
			break;
		case "n":
			list = pd.selectNicknamePost(conn, pi, word);
			break;
		}

		close(conn);
		return list;
	}

	// ==================== Ajax =========================

	public ArrayList<Reply> selectReplyList(int postNo) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new PostDao().selectReplyList(conn, postNo);
		close(conn);
		return list;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();
		int result = new PostDao().insertReply(conn, r);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteReply(int replyNo) {
		Connection conn = getConnection();
		int result = new PostDao().deleteReply(conn, replyNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int statusLike(PostLike pl) {
		Connection conn = getConnection();
		int result = new PostDao().statusLike(conn, pl);
		close(conn);
		return result;
	}

	public int likeCount(int postNo) {
		Connection conn = getConnection();
		int result = new PostDao().likeCount(conn, postNo);
		close(conn);
		return result;
	}

	public int insertLike(PostLike pl) {
		Connection conn = getConnection();
		int result = new PostDao().insertLike(conn, pl);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int increaseLike(int postNo) {
		Connection conn = getConnection();
		int result = new PostDao().increaseLike(conn, postNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteLike(PostLike pl) {
		Connection conn = getConnection();
		int result = new PostDao().deleteLike(conn, pl);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int decreaseLike(int postNo) {
		Connection conn = getConnection();
		int result = new PostDao().decreaseLike(conn, postNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int blockMember(String memNick) {
		Connection conn = getConnection();
		int result = new PostDao().blockMember(conn, memNick);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
