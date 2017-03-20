package com.ofc.mnt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofc.mnt.json.UserJson;
import com.ofc.mnt.service.UserService;

@RestController
@RequestMapping("UserController")
public class UserController {
	private Logger LOG = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveOrUpdateUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserJson userJson, HttpServletRequest request) {
		try {
			userService.saveOrUpdateUser(userJson);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping("getAllUsers")
	public ResponseEntity<List<UserJson>> getAllUsers(HttpServletRequest request) {
		List<UserJson> userJsonList = null;
		try {
			userJsonList = userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<List<UserJson>>(userJsonList, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<UserJson>>(userJsonList, HttpStatus.OK);
	}
}
