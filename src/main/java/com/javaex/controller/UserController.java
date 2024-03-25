package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.UserService;
import com.javaex.util.JwtUtil;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// 로그인
	@PostMapping("/api/users/login")
	public UserVo login(@RequestBody UserVo userVo, HttpServletResponse response) {
		System.out.println("UserController.login()");

		System.out.println(userVo);

		// no name id pw
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);

		if (authUser != null) { // 로그인에 성공하면
			// 토큰발급 헤더에 실어보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getNo());
		}
		return authUser;
	}

}
