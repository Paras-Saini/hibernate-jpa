package com.in28minutes.database.databasedemo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date birth_date;

	public Person() {

	}

	public Person(int id, String name, String location, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public Person(String name, String location, Date birth_date) {
		super();
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Date getBrithDate() {
		return birth_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setBrithDate(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "\n Person [id=" + id + ", name=" + name + ", location=" + location + ", birth_date=" + birth_date + "]";
	}

}
