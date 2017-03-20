package com.ofc.mnt.util;

import java.util.Date;

import com.ofc.mnt.entity.Task;
import com.ofc.mnt.entity.User;
import com.ofc.mnt.json.TaskJson;
import com.ofc.mnt.json.UserJson;

public class TransformJsonToEntity {
	public static void getUser(UserJson userJson, User user) {
		user.setAssignedTo(userJson.getAssignedTo());
		user.setFirstName(userJson.getFirstName());
		user.setIsAdmin(userJson.getIsAdmin());
		user.setLastName(userJson.getLastName());
		user.setPassword(Util.passwordEncryption(userJson.getPassword()));
		user.setUserName(userJson.getUserName());
		user.setEffectiveFrom(Util.convertDiffferentFormatString(userJson.getEffectiveFrom()));
		if (user.getId() != null) {
			user.setUpdatedBy(userJson.getUpdatedBy());
			user.setUpdatedOn(new Date());
		} else {
			user.setCreatedBy(userJson.getCreatedBy());
			user.setCreatedOn(new Date());
		}
	}

	public static void getTask(TaskJson taskJson, Task task) {
		task.setAssignedToId(taskJson.getAssignedToId());
		task.setDueDate(Util.convertDiffferentFormatString(taskJson.getDueDate()));
		task.setStatus(taskJson.getStatus());
		task.setTaskName(taskJson.getTaskName());
		if (task.getId() != null) {
			task.setUpdatedBy(taskJson.getUpdatedBy());
			task.setUpdatedOn(new Date());
		} else {
			task.setCreatedBy(taskJson.getCreatedBy());
			task.setCreatedOn(new Date());
		}
	}
}
