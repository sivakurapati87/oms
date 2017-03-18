package com.ofc.mnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofc.mnt.dao.TaskDao;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao taskDao;
}
