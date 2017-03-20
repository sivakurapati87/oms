package com.ofc.mnt.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofc.mnt.json.TaskJson;
import com.ofc.mnt.service.TaskService;

@RestController
@RequestMapping("TaskController")
public class TaskController {
	private Logger LOG = Logger.getLogger(TaskController.class);
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/saveOrUpdateUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateUser(@RequestBody TaskJson taskJson, HttpServletRequest request) {
		try {
			taskService.saveOrUpdate(taskJson);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
