package com.ofc.mnt.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<UserJson> getAllUsers() {
		List<UserJson> userJsonList = null;
		try {
			StringBuilder sb = new StringBuilder("select u.id,u.userName from User u order by u.userName ASC");
			List<?> userList = userDao.findByQuery(sb.toString(), null, null, null);
			if (userList != null && userList.size() > 0) {
				userJsonList = new ArrayList<UserJson>();
				for (Object object : userList) {
					Object[] obj = (Object[]) object;
					UserJson json = new UserJson();
					json.setId((Integer) obj[0]);
					json.setUserName((String) obj[1]);
					userJsonList.add(json);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return userJsonList;
	}
}
