package com.sp.pojo;

import java.util.List;

public class Person {
	
	private Integer id;
	private String name;
	private Integer age;
	private Idcard card;
	private List<Idcard> list;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Idcard getCard() {
		return card;
	}
	public void setCard(Idcard card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", card=" + card + "]";
	}
	
	

}
