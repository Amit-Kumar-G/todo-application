package com.odcem.todoapplication.controller;

public class DeletedSuccessfullyJson {
	
	private String msg;
	
	public DeletedSuccessfullyJson(String string) {
		this.msg = string;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
