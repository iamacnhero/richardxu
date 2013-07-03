package com.xufeng.entity;

import java.util.Date;

public class ProductWeight {
	private int productId;	// 商品ID
	private Date createDate;	// 数据生成日期
	private int price;	// 商品最低价
	private int merchantId;
	private int likeNum;	// 喜欢数
	private int likeNumWeek;	// 近7天喜欢数
	private int commentNum;		// 评论数
	private int commentNumWeek;	// 近7天评论数
	private int isHighquality;	// 是否精品,from tag where name=精品'
	private int hasBigImg;	// 是否有封面大图, bigPic has 470x470.jpg'
	private int hasRecommend;	// 是否有小编推荐语
	private int highquality_topic_num;	// 优质主题收录数
	private int topicNum;	// 普通主题收录数
	private int discountRate;	// 折扣力度:商品在售价格/商品标牌价,0.2~0.4=0.4,(<=0.2)=1
	private int to2taobaokeNum;	// 淘宝跳转次数
	private int to2taobaokeNumWeek;	// 近7天淘宝跳转次数
	private int isVipShop;	// 是否VIP商家
	private int afterPublishTime;	// 距离发布时间多少小时
	private int yesterdayPv;	// 商品昨日访问量
	private int weight;	// 结果: 综合权重值
	private String tags;	// 商品标签,取10条
	
	public ProductWeight() {
		super();
	}
	
	public ProductWeight(int productId, Date createDate, int price,
			int merchantId, int likeNum, int likeNumWeek, int commentNum,
			int commentNumWeek, int isHighquality, int hasBigImg,
			int hasRecommend, int highquality_topic_num, int topicNum,
			int discountRate, int to2taobaokeNum, int to2taobaokeNumWeek,
			int isVipShop, int afterPublishTime, int yesterdayPv, int weight,
			String tags) {
		super();
		this.productId = productId;
		this.createDate = createDate;
		this.price = price;
		this.merchantId = merchantId;
		this.likeNum = likeNum;
		this.likeNumWeek = likeNumWeek;
		this.commentNum = commentNum;
		this.commentNumWeek = commentNumWeek;
		this.isHighquality = isHighquality;
		this.hasBigImg = hasBigImg;
		this.hasRecommend = hasRecommend;
		this.highquality_topic_num = highquality_topic_num;
		this.topicNum = topicNum;
		this.discountRate = discountRate;
		this.to2taobaokeNum = to2taobaokeNum;
		this.to2taobaokeNumWeek = to2taobaokeNumWeek;
		this.isVipShop = isVipShop;
		this.afterPublishTime = afterPublishTime;
		this.yesterdayPv = yesterdayPv;
		this.weight = weight;
		this.tags = tags;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getLikeNumWeek() {
		return likeNumWeek;
	}
	public void setLikeNumWeek(int likeNumWeek) {
		this.likeNumWeek = likeNumWeek;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getCommentNumWeek() {
		return commentNumWeek;
	}
	public void setCommentNumWeek(int commentNumWeek) {
		this.commentNumWeek = commentNumWeek;
	}
	public int getIsHighquality() {
		return isHighquality;
	}
	public void setIsHighquality(int isHighquality) {
		this.isHighquality = isHighquality;
	}
	public int getHasBigImg() {
		return hasBigImg;
	}
	public void setHasBigImg(int hasBigImg) {
		this.hasBigImg = hasBigImg;
	}
	public int getHasRecommend() {
		return hasRecommend;
	}
	public void setHasRecommend(int hasRecommend) {
		this.hasRecommend = hasRecommend;
	}
	public int getHighquality_topic_num() {
		return highquality_topic_num;
	}
	public void setHighquality_topic_num(int highquality_topic_num) {
		this.highquality_topic_num = highquality_topic_num;
	}
	public int getTopicNum() {
		return topicNum;
	}
	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public int getTo2taobaokeNum() {
		return to2taobaokeNum;
	}
	public void setTo2taobaokeNum(int to2taobaokeNum) {
		this.to2taobaokeNum = to2taobaokeNum;
	}
	public int getTo2taobaokeNumWeek() {
		return to2taobaokeNumWeek;
	}
	public void setTo2taobaokeNumWeek(int to2taobaokeNumWeek) {
		this.to2taobaokeNumWeek = to2taobaokeNumWeek;
	}
	public int getIsVipShop() {
		return isVipShop;
	}
	public void setIsVipShop(int isVipShop) {
		this.isVipShop = isVipShop;
	}
	public int getAfterPublishTime() {
		return afterPublishTime;
	}
	public void setAfterPublishTime(int afterPublishTime) {
		this.afterPublishTime = afterPublishTime;
	}
	public int getYesterdayPv() {
		return yesterdayPv;
	}
	public void setYesterdayPv(int yesterdayPv) {
		this.yesterdayPv = yesterdayPv;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}
