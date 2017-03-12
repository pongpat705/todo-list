package com.pongpat.assignment.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pongpat.assignment.constant.TaskStatus;

@Entity
@Table(name = "TODO_TASK")
public class Task {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long 		id;
	private String 		subject;
	private String 		detail;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus 	status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
}
