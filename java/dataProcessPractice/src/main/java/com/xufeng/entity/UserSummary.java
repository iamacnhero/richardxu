package com.xufeng.entity;

import java.util.Date;

public class UserSummary {
	private int id;
	private int userId;
	private int fansCount;	// 粉丝数
	private int followsCount;	// 关注数
	private int postCount;	// 讨论数
	private int feedsCount;	// 动态数
	private int myFavorProducts;	//喜欢的宝贝数
	private int myShareProducts; 	// 分享的宝贝数
	private int myFavorTopics;	// 关注的主题数
	private int myCreateTopics;	// 创建的主题数
	private int productLikes;	// 我发的宝贝被喜欢数
	private int topicCount;	// 主题总数（包含关注和创建)
	private int topicLikes;	// 我创建的主题被关注数
	private Date createTime;
	
	public UserSummary() {
		super();
	}
	
	public UserSummary(int userId, int fansCount, int followsCount,
			int postCount, int feedsCount, int myFavorProducts,
			int myShareProducts, int myFavorTopics, int myCreateTopics,
			int productLikes, int topicCount, int topicLikes, Date createTime) {
		super();
		this.userId = userId;
		this.fansCount = fansCount;
		this.followsCount = followsCount;
		this.postCount = postCount;
		this.feedsCount = feedsCount;
		this.myFavorProducts = myFavorProducts;
		this.myShareProducts = myShareProducts;
		this.myFavorTopics = myFavorTopics;
		this.myCreateTopics = myCreateTopics;
		this.productLikes = productLikes;
		this.topicCount = topicCount;
		this.topicLikes = topicLikes;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserSummary [userId=" + userId + ", fansCount=" + fansCount
				+ ", followsCount=" + followsCount + ", postCount=" + postCount
				+ ", feedsCount=" + feedsCount + ", myFavorProducts="
				+ myFavorProducts + ", myShareProducts=" + myShareProducts
				+ ", myFavorTopics=" + myFavorTopics + ", myCreateTopics="
				+ myCreateTopics + ", productLikes=" + productLikes
				+ ", topicCount=" + topicCount + ", topicLikes=" + topicLikes
				+ ", createTime=" + createTime + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	public int getFollowsCount() {
		return followsCount;
	}
	public void setFollowsCount(int followsCount) {
		this.followsCount = followsCount;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public int getFeedsCount() {
		return feedsCount;
	}
	public void setFeedsCount(int feedsCount) {
		this.feedsCount = feedsCount;
	}
	public int getMyFavorProducts() {
		return myFavorProducts;
	}
	public void setMyFavorProducts(int myFavorProducts) {
		this.myFavorProducts = myFavorProducts;
	}
	public int getMyShareProducts() {
		return myShareProducts;
	}
	public void setMyShareProducts(int myShareProducts) {
		this.myShareProducts = myShareProducts;
	}
	public int getMyFavorTopics() {
		return myFavorTopics;
	}
	public void setMyFavorTopics(int myFavorTopics) {
		this.myFavorTopics = myFavorTopics;
	}
	public int getMyCreateTopics() {
		return myCreateTopics;
	}
	public void setMyCreateTopics(int myCreateTopics) {
		this.myCreateTopics = myCreateTopics;
	}
	public int getProductLikes() {
		return productLikes;
	}
	public void setProductLikes(int productLikes) {
		this.productLikes = productLikes;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public int getTopicLikes() {
		return topicLikes;
	}
	public void setTopic_likes(int topicLikes) {
		this.topicLikes = topicLikes;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
