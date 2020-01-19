package com.odcem.todoapplication.enums;

import lombok.Getter;

public enum TaskStatusEnum {

	DONE((byte) 0, "done"),
	IN_PROGRESS((byte) 1, "in_progress"),
	PENDING((byte) 2, "pending");

	@Getter
	private byte id;
	@Getter
	private String value;
	
	TaskStatusEnum(byte id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public static TaskStatusEnum getEnumByValueInt(int i) {
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (e.getId() == i) {
				return e;
			}
		}
		return null;
	}
	
	public static TaskStatusEnum getEnumByValueByte(byte i) {
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (e.getId() == i) {
				return e;
			}
		}
		return null;
	}

	public static TaskStatusEnum getEnumByDesc(String val) {
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (e.getValue().equals(val)) {
				return e;
			}
		}
		return null;
	}
	
	public static String getEnumAsString(TaskStatusEnum e) {
		return e.getValue();
	}
	
	public static Byte getTaskStatusByteFromString(String value) {
		
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (e.getValue().equals(value)) {
				return e.getId();
			}
		}
		return null;
	}
	
}
