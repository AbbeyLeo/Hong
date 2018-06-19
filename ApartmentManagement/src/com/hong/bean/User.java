/**
 * 
 */
package com.hong.bean;

/**
 * @author Abbey
 *
 */
public class User {
	private int id;
	private String username;
	private String password;
	private int limit;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getId() {
		return id;
	}
	
}
