package com.joe.util;

public class MainTest {

	public static void main(String[] args) {
		String token = JwtUtil.sign("xlj222", "10");
		System.out.println(token);
		System.out.println("name:" + JwtUtil.getUsername(token));
		System.out.println("id:" + JwtUtil.getUserId(token));
	}
}
