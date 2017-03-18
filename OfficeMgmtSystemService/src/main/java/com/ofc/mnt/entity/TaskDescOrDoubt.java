package com.ofc.mnt.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task_desc_doubt")
public class TaskDescOrDoubt extends BaseEntity {
	private Integer taskId;
	@ManyToOne
	@JoinColumn(name = "taskId", insertable = false, updatable = false)
	private Task task;
	private Boolean isDoubt = false;
	private byte[] description;
	private byte[] doubt;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Boolean getIsDoubt() {
		return isDoubt;
	}

	public void setIsDoubt(Boolean isDoubt) {
		this.isDoubt = isDoubt;
	}

	public byte[] getDescription() {
		return description;
	}

	public void setDescription(byte[] description) {
		this.description = description;
	}

	public byte[] getDoubt() {
		return doubt;
	}

	public void setDoubt(byte[] doubt) {
		this.doubt = doubt;
	}

}
