package com.ofc.mnt.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofc.mnt.dao.UserDao;
import com.ofc.mnt.entity.User;
import com.ofc.mnt.json.UserJson;
import com.ofc.mnt.util.TransformJsonToEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private Logger LOG = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	public void saveOrUpdateUser(UserJson userJson) {
		try {
			User user = null;
			if (userJson.getId() != null) {
				user = (User) userDao.getById(User.class, userJson.getId());
			} else {
				user = new User();
			}
			TransformJsonToEntity.getUser(userJson, user);
			userDao.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
}
