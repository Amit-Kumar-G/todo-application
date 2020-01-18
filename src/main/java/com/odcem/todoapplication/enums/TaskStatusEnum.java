package com.odcem.todoapplication.enums;

public enum TaskStatusEnum {

	DONE((byte) 0, "done"),
	IN_PROGRESS((byte) 1, "in_progress"),
	PENDING((byte) 2, "pending");

	private byte id;
	private String value;
	
	TaskStatusEnum(byte id, String value) {
		this.id = id;
		this.value = value;
	}

	public byte getId() {
		return id;
	}

	public String getValue() {
		return value;
	}
	
	public static TaskStatusEnum getEnumByValue(byte id) {
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (e.getId() == id) {
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
	
}
