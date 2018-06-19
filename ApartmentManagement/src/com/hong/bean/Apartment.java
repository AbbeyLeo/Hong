/**
 * 
 */
package com.hong.bean;

/**
 * @author Abbey
 *
 */
public class Apartment {
	private int apart_id;
	private String apart_code;
	private String apart_category;
	private String apart_build_name;
	private int apart_max_person;
	private int apart_now_person;
	
	public String getApart_code() {
		return apart_code;
	}
	public void setApart_code(String apart_code) {
		this.apart_code = apart_code;
	}
	public String getApart_category() {
		return apart_category;
	}
	public void setApart_category(String apart_category) {
		this.apart_category = apart_category;
	}
	public String getApart_build_name() {
		return apart_build_name;
	}
	public void setApart_build_name(String apart_build_name) {
		this.apart_build_name = apart_build_name;
	}
	public int getApart_id() {
		return apart_id;
	}
	public void setApart_id(int apart_id) {
		this.apart_id = apart_id;
	}
	public int getApart_max_person() {
		return apart_max_person;
	}
	public void setApart_max_person(int apart_max_person) {
		this.apart_max_person = apart_max_person;
	}
	public int getApart_now_person() {
		return apart_now_person;
	}
	public void setApart_now_person(int apart_now_person) {
		this.apart_now_person = apart_now_person;
	}
	
}
