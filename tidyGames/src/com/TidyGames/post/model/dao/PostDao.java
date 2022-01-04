package com.TidyGames.post.model.dao;

import static com.TidyGames.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.post.model.vo.Post;
import com.TidyGames.post.model.vo.PostFile;
import com.TidyGames.post.model.vo.PostLike;
import com.TidyGames.post.model.vo.Reply;

public class PostDao {

	private Properties prop = new Properties();

	public PostDao() {

		String filePath = PostDao.class.getResource("/db/sql/post-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public int selectPostListCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPostListCount");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}


	public ArrayList<Post> selectPostList(Connection conn, PageInfo pi) {

		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPostList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Post(rset.getInt("post_no"), rset.getString("mem_nick"), rset.getString("post_name"),
						rset.getInt("post_view"), rset.getInt("post_like"), rset.getString("post_enroll"),
						rset.getString("post_notice")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int increaseCount(Connection conn, int postNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public Post selectPostDetail(Connection conn, int postNo) {
		Post p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPostDetail");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			pstmt.setInt(2, postNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				p = new Post();
				p.setPostNo(rset.getInt("post_no"));
				p.setMemNo(rset.getInt("post_writer"));
				p.setPostName(rset.getString("post_name"));
				p.setPostWriter(rset.getString("mem_nick"));
				p.setPostEnroll(rset.getString("post_enroll"));
				p.setPostView(rset.getInt("post_view"));
				p.setPostLike(rset.getInt("post_like"));
				p.setPostContent(rset.getString("post_content"));
				p.setPrevNo(rset.getInt("prev_no"));
				p.setNextNo(rset.getInt("next_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}


	public ArrayList<PostFile> selectPostFile(Connection conn, int postNo) {
		ArrayList<PostFile> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPostFile");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				PostFile pf = new PostFile();
				pf.setFileNo(rset.getInt("file_no"));
				pf.setFileOrigin(rset.getString("file_origin"));
				pf.setFileChange(rset.getString("file_change"));
				pf.setFilePath(rset.getString("file_path"));

				list.add(pf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Post firstPostNo(Connection conn) {
		Post result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("firstPostNo");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new Post();
				result.setFirstPost(rset.getInt("firstpost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}


	public Post lastPostNo(Connection conn) {
		Post result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("lastPostNo");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new Post();
				result.setLastPost(rset.getInt("lastpost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertPost(Connection conn, Post p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPost");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(p.getPostWriter()));
			pstmt.setString(2, p.getPostName());
			pstmt.setString(3, p.getPostContent());
			pstmt.setString(4, p.getPostNotice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertFile(Connection conn, ArrayList<PostFile> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFile");

		try {

			for (PostFile f : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, f.getFileOrigin());
				pstmt.setString(2, f.getFileChange());
				pstmt.setString(3, f.getFilePath());
				result = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deletePost(Connection conn, int postNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deletePost");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updatePost(Connection conn, Post p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePost");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPostName());
			pstmt.setString(2, p.getPostContent());
			pstmt.setInt(3, p.getPostNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int nicknamePostCount(Connection conn, String word) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nicknamePostCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int searchPostCount(Connection conn, String word) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchPostCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			pstmt.setString(2, word);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}


	public ArrayList<Post> selectNicknamePost(Connection conn, PageInfo pi, String word) {

		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNicknamePost");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setString(1, word);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Post(rset.getInt("post_no"), rset.getString("mem_nick"), rset.getString("post_name"),
						rset.getInt("post_view"), rset.getInt("post_like"), rset.getString("post_enroll"),
						rset.getString("post_notice")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Post> searchRecentPost(Connection conn, PageInfo pi, String word) {

		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchRecentPost");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setString(1, word);
			pstmt.setString(2, word);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Post(rset.getInt("post_no"), rset.getString("mem_nick"), rset.getString("post_name"),
						rset.getInt("post_view"), rset.getInt("post_like"), rset.getString("post_enroll"),
						rset.getString("post_notice")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Post> searchViewPost(Connection conn, PageInfo pi, String word) {

		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchViewPost");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setString(1, word);
			pstmt.setString(2, word);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Post(rset.getInt("post_no"), rset.getString("mem_nick"), rset.getString("post_name"),
						rset.getInt("post_view"), rset.getInt("post_like"), rset.getString("post_enroll"),
						rset.getString("post_notice")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Post> searchLikePost(Connection conn, PageInfo pi, String word) {

		ArrayList<Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchLikePost");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setString(1, word);
			pstmt.setString(2, word);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Post(rset.getInt("post_no"), rset.getString("mem_nick"), rset.getString("post_name"),
						rset.getInt("post_view"), rset.getInt("post_like"), rset.getString("post_enroll"),
						rset.getString("post_notice")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// ====================== Ajax ===========================

	public ArrayList<Reply> selectReplyList(Connection conn, int postNo) {
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				list.add(new Reply(rset.getInt("reply_no"), rset.getString("mem_nick"), rset.getString("reply_content"),
						rset.getString("reply_enroll"), rset.getInt("mem_no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertReply(Connection conn, Reply r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(r.getReplyWriter()));
			pstmt.setInt(2, r.getRefPostNo());
			pstmt.setString(3, r.getReplyContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteReply(Connection conn, int replyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int statusLike(Connection conn, PostLike pl) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statusLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pl.getLikePost());
			pstmt.setInt(2, pl.getLikeMem());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int likeCount(Connection conn, int postNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("likeCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertLike(Connection conn, PostLike pl) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pl.getLikePost());
			pstmt.setInt(2, pl.getLikeMem());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int increaseLike(Connection conn, int postNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteLike(Connection conn, PostLike pl) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pl.getLikePost());
			pstmt.setInt(2, pl.getLikeMem());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int decreaseLike(Connection conn, int postNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("decreaseLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int blockMember(Connection conn, String memNick) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("blockMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNick);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}
	

}
