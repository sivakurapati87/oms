package com.ofc.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofc.mnt.service.TaskService;

@RestController
@RequestMapping("TaskController")
public class TaskController {
	@Autowired
	private TaskService taskService;
}
