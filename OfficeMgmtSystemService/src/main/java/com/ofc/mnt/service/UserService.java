package com.ofc.mnt.service;

import java.util.List;

import com.ofc.mnt.json.UserJson;

public interface UserService {
	public void saveOrUpdateUser(UserJson userJson);
	
	public List<UserJson> getAllUsers();
}
