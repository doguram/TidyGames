package com.TidyGames.game.model.vo;

public class Category {

	private int categoryNo;
	private String categoryName;
	private String categoryStatus;
	private String checkCategoryName;


	public Category() {}


	public Category(int categoryNo, String categoryName, String categoryStatus) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
	}
	

	public Category(String categoryName, String checkCategoryName) {
		super();
		this.categoryName = categoryName;
		this.checkCategoryName = checkCategoryName;
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryStatus() {
		return categoryStatus;
	}


	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	
	


	public String getCheckCategoryName() {
		return checkCategoryName;
	}


	public void setCheckCategoryName(String checkCategoryName) {
		this.checkCategoryName = checkCategoryName;
	}


	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categoryStatus="
				+ categoryStatus + "]";
	}
	
	
}
