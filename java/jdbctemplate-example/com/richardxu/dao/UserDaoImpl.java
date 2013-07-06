package com.richardxu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import com.richardxu.domain.User;


@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 使用 RowMapper, 然后传到 queryForObject() 方法，返回的结果可以使用这里定义的mapRow()方法来匹配属性,
	 * 如：jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper())
	 * @author xufeng
	 *
	 */
	protected class UserMapper implements RowMapper {  
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
			User user = new User();  
			user.setId(rs.getInt("id"));    
			user.setName(rs.getString("name"));  
			user.setPassword(rs.getString("password"));
		   return user;
		}
	}
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO user(id, name, password) VALUE(?, ?, ?) ";
		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getId());
	}

	@Override
	public void delete(User user) {
		String sql = "DELETE FROM user WHERE id = ?";
		jdbcTemplate.update(sql, user.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		// 方法1. 使用 RowMapper
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
		// 方法2. 使用 RowCallbackHandler()
//		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
//				user.setPassword(rs.getString("password"));
//			}
//		});
	}
	

	@Override
	public User findByName(String name) {
		String sql = "SELECT * FROM user WHERE name = ? LIMIT 1";
		return jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserMapper());
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		// 使用 BeanPropertyRowMapper 返回多个值
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
	}

	@Override
	public int count() {
		String sql = "SELECT COUNT(*) FROM user";
		return jdbcTemplate.queryForInt(sql);
	}

	@Override
	public void batchInsert(List<User> users) {
		String sql = "INSERT INTO user(id, name) VALUES(?, ?)";
		List<Object[]> parameters = new ArrayList<Object[]>();
		for (User u : users) {
			parameters.add(new Object[]{u.getId(), u.getName(), u.getPassword()});
		}
		jdbcTemplate.batchUpdate(sql, parameters);
	}
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.md5DigestAsHex("test".getBytes()));
	}
}
