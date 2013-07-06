package com.richardxu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import com.richardxu.dao.UserDao;
import com.richardxu.domain.User;


public class UserDaoTest extends TestBase {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test() {
		System.out.println(userDao.toString());
	}
	
	@Test
	public void testInsert() {	         
		User user = new User(3, "xf", DigestUtils.md5DigestAsHex("123456".getBytes()));
		userDao.insert(user);
	}
	
	@Test
	public void testUpdate() {
		User user = userDao.findById(1);
		
	}
	
	@Test
	public void testFindById() {
		User user = userDao.findById(1);
		System.out.println(user.toString());
	}
	
	@Test
	public void testFindByName() {
		User user = userDao.findByName("xf");
		System.out.println(user.toString());
	}

	@Test
	public void testFindAll() {
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
}
