package com.odcem.todoapplication.builder;

import com.odcem.todoapplication.dtos.UserDto;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.json.UserJson;

/**
 * 
 * @author amitkumargupta
 *
 */

public interface UserBuilder {
	
	public User buildNewUserFromJson(UserJson userJson);

	public UserDto buildUserDtoFromUser(User user);

	public UserJson buildJsonFromUser(User user);
}
