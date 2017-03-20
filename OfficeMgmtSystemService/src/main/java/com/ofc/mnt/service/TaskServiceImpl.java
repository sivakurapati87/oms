package com.ofc.mnt.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofc.mnt.dao.TaskDao;
import com.ofc.mnt.entity.Task;
import com.ofc.mnt.json.TaskJson;
import com.ofc.mnt.util.TransformJsonToEntity;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	private Logger LOG = Logger.getLogger(TaskServiceImpl.class);
	@Autowired
	private TaskDao taskDao;

	public void saveOrUpdate(TaskJson taskJson) {
		try {
			Task task = null;
			if (taskJson.getId() != null) {
				task = (Task) taskDao.getById(Task.class, taskJson.getId());
			} else {
				task = new Task();
			}
			TransformJsonToEntity.getTask(taskJson, task);
			taskDao.saveOrUpdate(task);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}

	}
}
