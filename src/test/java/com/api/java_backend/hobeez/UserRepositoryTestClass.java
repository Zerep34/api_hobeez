package com.api.java_backend.hobeez;

import com.api.java_backend.hobeez.repository.UserRepository;
import com.api.java_backend.hobeez.repository.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@TestPropertySource
class UserRepositoryTestClass {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;


}
