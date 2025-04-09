package com.ysh.test.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysh.test.HomeController;
import com.ysh.test.dao.UserDao;
import com.ysh.test.entity.User;
import com.ysh.test.repository.TestRepository;
import com.ysh.test.service.TestService;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private TestService testService;
	
	@Autowired
	public TestController(TestService testService) {
		this.testService = testService;
	}

	
	//Entity Manager 방식의 JPA
	@RequestMapping(value = "/InsertUser1", method = RequestMethod.GET)
	@ResponseBody
	public String InsertUser1(Locale locale, Model model) {
		  //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("root-context.xml");
		  ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\springFramework_sts3\\workspace\\spring_jpa_test\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");


	        UserDao userDao = ctx.getBean(UserDao.class);
	        User user = new User("홍길동", "hong@domain.com");
	        userDao.save(user);

	        User result = userDao.findById(user.getId());
	        System.out.println("DB에서 불러온 이름: " + result.getName());

	        //ctx.close();
		
		return "/InsertUser";
	}
	
	
	//Jpa Repository방식의 JPA
	@RequestMapping(value = "/InsertUser2", method = RequestMethod.GET)
	@ResponseBody
	public String InsertUser2() {
		testService.registerUser("testName1", "testEmail1");
		return "/InsertUser2";
	}
	
}
