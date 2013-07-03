package com.xufeng.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.utils.DateUtils;

public class ProductWeightService {
	JdbcTemplate jdbcTemplate;

	public ProductWeightService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 单个商品的喜欢数
	 * @param productId
	 * @return
	 */
	public final int getLikeNum(int productId) {
		String sql = "SELECT COUNT(*) FROM product_favor WHERE product_id=? AND visible='1' AND favor='1' ";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	/**
	 * 单个商品一周的喜欢数
	 * @param productId
	 * @return
	 */
	public final int getLikeNumWeek(int productId) {
		Date oneWeekAgo = DateUtils.getDayBeforeOrAfter2(new Date(), -7);	// 得到一周之前的日期
		String sql = "SELECT COUNT(*) FROM product_favor WHERE product_id=? AND visible='1' AND favor='1' AND create_time>=?";
		return jdbcTemplate.queryForInt(sql, productId, oneWeekAgo);
	}
	
	/**
	 * 得到商品价格
	 * @param productId
	 * @return
	 */
	public final int getPrice(int productId) {
		String sql = " SELECT MIN(shop_price) FROM product_merchant WHERE pro_id = ? ";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	/**
	 * 得到商品评论数
	 * @param productId
	 * @return
	 */
	public final int getCommentNum(int productId) {
		String sql = "SELECT COUNT(*) FROM product_comment WHERE source_type=10 AND comment_visible='1' AND pro_id = ?";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	/**
	 * 得到商品一周的评论数
	 * @param productId
	 * @return
	 */
	public final int getCommentNumWeek(int productId) {
		Date oneWeekAgo = DateUtils.getDayBeforeOrAfter2(new Date(), -7);	// 得到一周之前的日期
		String sql = "SELECT COUNT(*) FROM product_comment WHERE source_type=10 AND comment_visible='1' AND pro_id = ? AND create_time > ?";
		return jdbcTemplate.queryForInt(sql, productId, oneWeekAgo);
	}
	
	/**
	 * 商品是否是精品
	 * @param productId
	 * @return
	 */
	public final int isHighquality(int productId) {
		String sql = "SELECT COUNT(*) FROM product_tag WHERE tag_id = 4233 AND product_id = ?";	// tag_id为4233，表示"精品"
		if (jdbcTemplate.queryForInt(sql, productId) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 检测商品是否包含大图
	 * @param photos
	 * @return
	 */
	public static final int hasBigImg(String photos) {
		String s = "_470X470.jpg";
		if (StringUtils.isBlank(photos)) {
			return 0;
		}
		if (photos.toLowerCase().contains(s)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 被优质主题收录数
	 * @param productId
	 * @return
	 */
	public final int getHighqualityTopicNum(int productId) {
		String sql = "SELECT COUNT(DISTINCT topic_id) FROM topic t JOIN topic_product tp ON t.id=tp.topic_id "
				+ "WHERE t.if_highquality = 'yes' AND product_id = ?";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	/**
	 * 被普通主题收录数
	 * @param productId
	 * @return
	 */
	public final int getTopicNum(int productId) {
		String sql = "SELECT COUNT(DISTINCT topic_id) FROM topic t JOIN topic_product tp ON t.id=tp.topic_id "
				+ "WHERE t.if_highquality = 'no' AND product_id = ?";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	
	/**
	 * 得到折扣力度
	 * @param productId
	 * @return
	 */
	public final String getDiscountRate(int productId) {
		String sql = " SELECT discount_number FROM product_merchant " +
						" WHERE discount_number !='' AND discount_number IS NOT NULL AND pro_id = ? LIMIT 1 ";
		try {
			String discountNumber = jdbcTemplate.queryForObject(sql, String.class, productId);
			return discountNumber;
		} catch (Exception e) {
			return "1.0";
		}
	}
	
	/**
	 * 淘宝跳转次数
	 * @param productId
	 * @return
	 */
	public final int getTo2taobaokeNum(int productId) {
		String sql = "SELECT COUNT(*) FROM product_click_buy WHERE product_id = ?";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
	/**
	 * 近一周淘宝跳转次数
	 * @param productId
	 * @return
	 */
	public final int getTo2taobaokeNumWeek(int productId) {
		Date oneWeekAgo = DateUtils.getDayBeforeOrAfter2(new Date(), -7);	// 得到一周之前的日期
		String sql = "SELECT COUNT(*) FROM product_click_buy WHERE create_time > ? AND product_id = ?";
		return jdbcTemplate.queryForInt(sql, oneWeekAgo, productId);
	}
	
	/**
	 * 是否是VIP商家
	 * @param productId
	 * @return
	 */
	public final int isVipShop(int productId) {
		String sql = "SELECT COUNT(*) FROM product_merchant pm JOIN merchant m ON pm.merchant_id=m.id " +
				" WHERE pm.visible='1' AND pm.pro_id = ? AND m.vip_plan='yes' ";
		return jdbcTemplate.queryForInt(sql, productId);
	}
	
}
