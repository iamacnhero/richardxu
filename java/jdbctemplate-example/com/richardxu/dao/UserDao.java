package com.richardxu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.richardxu.domain.User;


public interface UserDao {
	public void insert(User user);
	public void update(User user);
	public void delete(User user);
	public void delete(int id);
	public User findById(int id);
	public User findByName(String name);
	public List<User> findAll();
	public int count();
	public void batchInsert(List<User> users);
}
