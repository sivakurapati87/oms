package com.ofc.mnt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {
	private Integer assignedToId;
	@ManyToOne
	@JoinColumn(name = "assignedToId", insertable = false, updatable = false)
	private User assignedTo;
	private Date dueDate;
	private String status;

	public Integer getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(Integer assignedToId) {
		this.assignedToId = assignedToId;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
