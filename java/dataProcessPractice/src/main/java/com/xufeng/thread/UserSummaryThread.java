package com.xufeng.thread;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.entity.UserSummary;
import com.xufeng.service.UserSummaryService;

public class UserSummaryThread implements Runnable {
	private int startUserId;
	private int endUserId;
	private JdbcTemplate jdbcTemplate;
	private UserSummaryService userSummaryService;

	public UserSummaryThread(JdbcTemplate jdbcTemplate, int startUserId, int endUserId) {
		this.startUserId = startUserId;
		this.endUserId = endUserId;
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 得到要处理的用户ID范围
	 */
	public final List<Map<String, Object>> getUserIdList(int startId, int endId) {
		String sql = "SELECT id FROM user WHERE id BETWEEN ? AND ? ";
		Object[] args = {startId, endId};
		return jdbcTemplate.queryForList(sql, args);
	}
	
	/**
	 * 去重 (去除product_favor表中，用户分享过的宝贝)
	 */
	public final void removeDuplicateFavorProduct(int userId) {
		String sql = "DELETE product_favor "
				+ "FROM product_favor JOIN user_share ON product_favor.user_id=user_share.user_id "
				+ "WHERE product_favor.user_id = ? AND product_favor.product_id=user_share.product_id";
		
		jdbcTemplate.update(sql, new Object[]{userId});
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		
		String name = Thread.currentThread().getName();
		userSummaryService = new UserSummaryService(jdbcTemplate);
		List<Map<String, Object>> getUserIdList = getUserIdList(startUserId, endUserId);
		for (Map<String, Object> user : getUserIdList) {
			Integer userId = ((BigInteger) user.get("id")).intValue();
			
			removeDuplicateFavorProduct(userId);
			
			
			int fansCount = userSummaryService.getFansNum(userId);	// 粉丝数
			int followsCount = userSummaryService.getFollowerNum(userId);	// 关注数
			int postCount = userSummaryService.getPostNum(userId);	// 计算帖子数
			int feedsCount = userSummaryService.getFeedNum(userId);	// 计算动态数
			int myFavorProducts = userSummaryService.getMyFavorProductNum(userId);	// 计算我喜欢的宝贝数
			int myShareProducts = userSummaryService.getMyShareProductNum(userId);	// 计算我分享的宝贝数
			int myFavorTopics = userSummaryService.getMyFollowTopicNum(userId);	// 计算我关注的主题数
			int myCreateTopics = userSummaryService.getMyCreateTopicNum(userId);	// 计算我发布的主题数
			int productLikes = userSummaryService.getProductLikeNum(userId);	// 计算我的宝贝被喜欢数
			int topicCount = userSummaryService.getTopicCount(userId);	// 计算我的主题总数（包含我关注与我发布的）
			int topicLikes = userSummaryService.getTopicLikesCount(userId);	// 计算我的主题被关注数
			
			UserSummary userSummary = new UserSummary(userId, fansCount, followsCount, postCount, feedsCount, myFavorProducts, myShareProducts, myFavorTopics, myCreateTopics, productLikes, topicCount, topicLikes, new Date());

			System.out.println(name + " " + userSummary.toString());
			userSummaryService.save(userSummary);
		}
		long endTime =System.currentTimeMillis();
		System.out.println(name + " Cost time: " + ((endTime - startTime)/1000) + " seconds!");
		
	}

}
