package com.paka.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="list")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="content")
	@Pattern(regexp="^[a-zA-Z0-9]{1,}")
	@NotNull(message="is required")
	private String content;
	
	@Column(name="data")
	private int data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
	public Task() {
		
	}
	public Task(String content, int data) {
		
		this.content = content;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", content=" + content + ", data=" + data + "]";
	}
	
	
}
