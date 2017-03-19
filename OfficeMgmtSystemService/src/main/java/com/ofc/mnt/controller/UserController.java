package com.ofc.mnt.controller;

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
	public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserJson userJson) {
		try {
			userService.saveOrUpdateUser(userJson);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
