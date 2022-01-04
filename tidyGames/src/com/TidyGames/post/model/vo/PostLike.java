package com.TidyGames.post.model.vo;

import java.sql.Date;

public class PostLike {
	
	private int likePost;
	private int likeMem;
	private Date likeDate;
	
	public PostLike() {}
	
	public PostLike(int likePost, int likeMem, Date likeDate) {
		super();
		this.likePost = likePost;
		this.likeMem = likeMem;
		this.likeDate = likeDate;
	}

	public int getLikePost() {
		return likePost;
	}

	public void setLikePost(int likePost) {
		this.likePost = likePost;
	}

	public int getLikeMem() {
		return likeMem;
	}

	public void setLikeMem(int likeMem) {
		this.likeMem = likeMem;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	public String toString() {
		return "PostLike [likePost=" + likePost + ", likeMem=" + likeMem + ", likeDate=" + likeDate + "]";
	}

	
}