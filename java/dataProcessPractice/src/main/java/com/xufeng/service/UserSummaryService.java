package com.xufeng.service;

import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.entity.UserSummary;

public class UserSummaryService {
	JdbcTemplate jdbcTemplate;

	public UserSummaryService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 去重 (去除product_favor表中，用户分享过的宝贝)
	 */
	public final void removeDuplicateFavorProduct(int userId) {
		String sql = "DELETE product_favor "
				+ "FROM product_favor JOIN user_share ON product_favor.user_id=user_share.user_id"
				+ "WHERE product_favor.user_id = ?";
		jdbcTemplate.update(sql, new Object[]{userId});
	}
	
	/**
	 * 计算粉丝数
	 */
	public int getFansNum(int userId) {
		String sql = "SELECT COUNT(1) FROM friend a WHERE a.status='enable' AND a.friend_id = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算关注数
	 */
	public int getFollowerNum(int userId) {
		String sql = "SELECT COUNT(*) FROM friend a WHERE a.status='enable'  AND a.user_id = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算帖子数
	 */
	public int getPostNum(int userId) {
		String sql = "SELECT COUNT(DISTINCT t.id) " +
				"FROM post t JOIN forum f ON (t.forum_id = f.id) LEFT JOIN `user` u ON (t.user_id = u.id) " +
				"LEFT JOIN post_reply pr ON (t.id = pr.post_id) " +
				"WHERE t.status !='del' AND f.status='pub' AND pr.`status` != 'del' AND t.forum_id IN (131395,131351,131350,131352,131348) " +
				"AND (t.user_id = ?  OR pr.user_id = ?)";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId, userId});
	}
	
	/**
	 * 计算动态数
	 */
	public int getFeedNum(int userId) {
		String sql = "SELECT COUNT(*) FROM feeds WHERE user_id = ? AND main_feed_type NOT IN('topicadd','brandadd','addedbytopic','addedbybrand')";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我喜欢的宝贝数
	 */
	public int getMyFavorProductNum(int userId) {
		String sql = "SELECT COUNT(DISTINCT A.id) FROM product A JOIN product_favor B ON (A.id = B.product_id) WHERE B.user_id = ? AND B.visible = '1' AND B.favor = '1'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我分享的宝贝数
	 */
	public int getMyShareProductNum(int userId) {
		String sql = "SELECT COUNT(DISTINCT a.product_id) FROM user_share a LEFT JOIN product b ON a.product_id = b.id" +
				" WHERE  b.pro_visible = '1' AND a.user_id = ? AND a.share_type != 'plugin'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我关注的主题数
	 */
	public int getMyFollowTopicNum(int userId) {
		String sql = "SELECT COUNT(DISTINCT t.id) FROM topic t,topic_favor tf WHERE t.id=tf.topic_id AND tf.user_id=? AND t.status = 'pub'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我发布的主题数
	 */
	public int getMyCreateTopicNum(int userId) {
		String sql = "SELECT COUNT(*) FROM topic WHERE creator_id = ? AND status = 'pub'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我的宝贝被喜欢数
	 */
	public int getProductLikeNum(int userId) {
		String sql = "SELECT COUNT(pf.id) AS t " +
				"FROM user_share us LEFT JOIN product_favor pf ON us.product_id = pf.product_id JOIN product p ON pf.product_id = p.id " +
				"WHERE pf.create_time > us.create_time AND us.user_id = ? AND pf.favor = '1' AND pf.visible = '1'  AND p.status2 != 'deleted'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	/**
	 * 计算我的主题总数（包含我关注与我发布的）
	 */
	public int getTopicCount(int userId) {
		String sql = "SELECT COUNT(*) FROM " +
					"(SELECT topic_id FROM topic_favor WHERE user_id = ? AND STATUS='ok' UNION " +
					"SELECT id AS topic_id FROM topic WHERE creator_id = ?) t JOIN topic tp ON tp.id=t.topic_id AND tp.status = 'pub' ";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId, userId});
	}
	
	/**
	 * 计算我的主题被关注数
	 */
	public int getTopicLikesCount(int userId) {
		String sql = "SELECT COUNT(tf.id) FROM topic_favor tf JOIN topic t ON tf.topic_id = t.id WHERE t.creator_id=? AND t.status = 'pub'";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
	
	public void save(UserSummary userSummary) {
		String sql = "REPLACE INTO user_summary (user_id, fans_count, follows_count, post_count, feeds_count, my_favor_products, " + 
					"my_share_products, my_favor_topics, my_create_topics, product_likes, topic_count, topic_likes, create_time) " + 
					"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = {userSummary.getUserId(), userSummary.getFansCount(), userSummary.getFollowsCount(), userSummary.getPostCount(),
				userSummary.getFeedsCount(), userSummary.getMyFavorProducts(), userSummary.getMyShareProducts(), userSummary.getMyFavorTopics(), 
				userSummary.getMyCreateTopics(), userSummary.getProductLikes(), userSummary.getTopicCount(), userSummary.getTopicLikes(), new Date()};
		jdbcTemplate.update(sql, args);
	}
}

