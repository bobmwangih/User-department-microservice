package com.bob.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bob.user.VO.Department;
import com.bob.user.VO.ResponseTemplateVO;
import com.bob.user.entity.User;
import com.bob.user.exceptions.UserNotFoundException;
import com.bob.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("inside the saveUser method in the userService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside the getUserWithDepartment method in the userService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with ID :" + userId + " doesnt exist"));
		Department department = restTemplate
				.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
	
}
