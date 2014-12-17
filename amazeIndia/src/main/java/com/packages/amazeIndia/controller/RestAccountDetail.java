package com.packages.amazeIndia.controller;

import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.packages.amazeIndia.document.Users;
import com.packages.amazeIndia.document.Users.Gender;
import com.packages.amazeIndia.document.Users.Role;
import com.packages.amazeIndia.document.Users.SecurityQuestion;
import com.packages.amazeIndia.document.Users.UserTitle;
import com.packages.amazeIndia.service.AccountService;

/**
 * 
 * @author asrivastava
 * Copyright 2014 Amaze India Pvt. Ltd. All Rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


@Controller
public class RestAccountDetail {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/accDetail",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Users getAccountDetails(@RequestParam("userId") String userId){
		Users dataUser = accountService.findByUserId(userId);
		return dataUser;
	}
	
	@RequestMapping(value="/saveUser",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Users saveUser(@RequestParam("userId") String userId){
		LinkedList<ObjectId> shippingAddress = new LinkedList<ObjectId>();
		LinkedList<ObjectId> contactAddresses = new LinkedList<ObjectId>();
		Users userData = accountService.saveUser(Role.FULL_ADMIN, UserTitle.MR, Gender.MALE_GENDER, SecurityQuestion.Q1, SecurityQuestion.Q2, userId, "anupam005@gmail.com", "welcome", true,
				false, System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), Locale.getDefault(), "Anupam",
				"", "Srivastava", "MVN", "Blue", shippingAddress, contactAddresses);
		return userData;
	}
}
