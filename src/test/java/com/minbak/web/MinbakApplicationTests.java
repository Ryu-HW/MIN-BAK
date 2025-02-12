package com.minbak.web;

import com.minbak.web.users.UserDto;
import com.minbak.web.users.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MinbakApplicationTests {

	@Autowired
	UsersService usersService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUserdatas() {
		for (int i=1;i<10;i++){
			for (int j=1;j<10;j++){
				UserDto userDto = new UserDto();
				userDto.setName("user"+i+j);
				userDto.setPassword("1234");
				userDto.setEmail("user"+i+j+"@minbak.com");
				userDto.setPhoneNumber("010-"+i+j+"12-"+j+i+"34");

				usersService.createUser(userDto);
			}
		}
	}

	@Test
	void createHosts() {
		usersService.createHostBy3rdUsers();
	}
}
