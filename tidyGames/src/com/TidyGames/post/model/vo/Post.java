package com.TidyGames.post.model.vo;

public class Post {
	
	private int postNo;
	private String postWriter;
	private String postName;
	private String postContent;
	private String postEnroll;
	private int postView;
	private int postLike;
	private String postModify;
	private String postStatus;
	private String postNotice;
	private int memNo;
	private int firstPost;
	private int lastPost;
	private int prevNo;
	private int nextNo;

	public Post() {}
	
	public Post(int postNo, String postWriter, String postName, int postView, int postLike,
			String postEnroll, String postNotice) {
		super();
		this.postNo = postNo;
		this.postWriter = postWriter;
		this.postName = postName;
		this.postView = postView;
		this.postLike = postLike;
		this.postEnroll = postEnroll;
		this.postNotice = postNotice;
	}

	public Post(int postNo, String postWriter, String postName, String postContent, String postEnroll, int postView,
			int postLike, String postModify, String postStatus, String postNotice, int memNo, int firstPost,
			int lastPost, int prevNo, int nextNo) {
		super();
		this.postNo = postNo;
		this.postWriter = postWriter;
		this.postName = postName;
		this.postContent = postContent;
		this.postEnroll = postEnroll;
		this.postView = postView;
		this.postLike = postLike;
		this.postModify = postModify;
		this.postStatus = postStatus;
		this.postNotice = postNotice;
		this.memNo = memNo;
		this.firstPost = firstPost;
		this.lastPost = lastPost;
		this.prevNo = prevNo;
		this.nextNo = nextNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostEnroll() {
		return postEnroll;
	}

	public void setPostEnroll(String postEnroll) {
		this.postEnroll = postEnroll;
	}

	public int getPostView() {
		return postView;
	}

	public void setPostView(int postView) {
		this.postView = postView;
	}

	public int getPostLike() {
		return postLike;
	}

	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}

	public String getPostModify() {
		return postModify;
	}

	public void setPostModify(String postModify) {
		this.postModify = postModify;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	public String getPostNotice() {
		return postNotice;
	}

	public void setPostNotice(String postNotice) {
		this.postNotice = postNotice;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getFirstPost() {
		return firstPost;
	}

	public void setFirstPost(int firstPost) {
		this.firstPost = firstPost;
	}

	public int getLastPost() {
		return lastPost;
	}

	public void setLastPost(int lastPost) {
		this.lastPost = lastPost;
	}

	public int getPrevNo() {
		return prevNo;
	}

	public void setPrevNo(int prevNo) {
		this.prevNo = prevNo;
	}

	public int getNextNo() {
		return nextNo;
	}

	public void setNextNo(int nextNo) {
		this.nextNo = nextNo;
	}

	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", postWriter=" + postWriter + ", postName=" + postName + ", postContent="
				+ postContent + ", postEnroll=" + postEnroll + ", postView=" + postView + ", postLike=" + postLike
				+ ", postModify=" + postModify + ", postStatus=" + postStatus + ", postNotice=" + postNotice
				+ ", memNo=" + memNo + ", firstPost=" + firstPost + ", lastPost=" + lastPost + ", prevNo=" + prevNo
				+ ", nextNo=" + nextNo + "]";
	}

	
}
