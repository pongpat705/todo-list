package com.pongpat.assignment.constant;

public enum TaskStatus {
	PENDING("Pending"),
	DONE("Done")	;
	
	private String status;

	private TaskStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}
