package com.xufeng.thread;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.entity.UserSummary;
import com.xufeng.service.ProductWeightService;
import com.xufeng.service.UserSummaryService;

public class ProductWeightThread implements Runnable {
	private int startProductId;
	private int endProductId;
	private JdbcTemplate jdbcTemplate;
	private ProductWeightService productWeightService;

	public ProductWeightThread(JdbcTemplate jdbcTemplate, int startProductId, int endProductId) {
		this.startProductId = startProductId;
		this.endProductId = endProductId;
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 得到要处理的商品ID范围
	 */
	public final List<Map<String, Object>> getProductIdList(int startProductId, int endProductId) {
		String sql = "SELECT id, photos, pro_recommend, publish_time FROM product WHERE id BETWEEN ? AND ? ";
		Object[] args = {startProductId, endProductId};
		return jdbcTemplate.queryForList(sql, args);
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		
		String name = Thread.currentThread().getName();
		productWeightService = new ProductWeightService(jdbcTemplate);
		List<Map<String, Object>> productIdList = getProductIdList(startProductId, endProductId);
		for (Map<String, Object> product : productIdList) {
			Integer productId = ((BigInteger) product.get("id")).intValue();
			String photos = (String) product.get("photos");
			
			int hasRecommend = 0;	// 是否有小编推荐语, 推荐语长度在5个字以上
			if (null != product.get("pro_recommend")) {
				if (((String) product.get("pro_recommend")).length()>=5) {	
					hasRecommend = 1;
				}
			}
			
			int likeNum = productWeightService.getLikeNum(productId);	// 喜欢数
			int likeNumWeek = productWeightService.getLikeNumWeek(productId);	// 得到一周的喜欢数
			int price = productWeightService.getPrice(productId);	// 得到价格
			int hasBigImg = ProductWeightService.hasBigImg(photos);	// 是否有大图
			String discountRate = productWeightService.getDiscountRate(productId);	// 商品折扣
			
			Date publishTime = (Date) product.get("publish_time");
			
			System.out.println(productId + "\t" + price + "\t" + likeNum + "\t" + likeNumWeek + "\t" + discountRate);

		}
		long endTime =System.currentTimeMillis();
		System.out.println(name + " Cost time: " + ((endTime - startTime)/1000) + " seconds!");
		
	}

}
