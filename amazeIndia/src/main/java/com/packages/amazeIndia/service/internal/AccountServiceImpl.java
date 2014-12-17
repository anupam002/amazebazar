package com.packages.amazeIndia.service.internal;

import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packages.amazeIndia.document.Users;
import com.packages.amazeIndia.document.Users.Gender;
import com.packages.amazeIndia.document.Users.Role;
import com.packages.amazeIndia.document.Users.SecurityQuestion;
import com.packages.amazeIndia.document.Users.UserTitle;
import com.packages.amazeIndia.repository.UsersRepository;
import com.packages.amazeIndia.service.AccountService;

/**
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
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	 UsersRepository usersRepository;

	@Override
	public Users findByUserId(String userId) {
		return usersRepository.findOne(userId);
	}

	@Override
	public Users findUserByEmailId(String emailId) {
		return usersRepository.findUserByEmailId(emailId);
	}
 
	@Override
	public Users saveUser(Role userRole,UserTitle userTitle,Gender gender,SecurityQuestion securityQuestion1,SecurityQuestion securityQuestion2,String userId,
			String emailId,String password,Boolean active,Boolean expirable,Long registrationTime,Long lastLoginTime,
			Long passwordSetTime,Long passwordExpireTime,Locale defaultLocale,String firstName,String middleName,
			String lastName,String answer1,String answer2,LinkedList<ObjectId> shippingAddresses,LinkedList<ObjectId> contactAddresses) {
		Users savedUser = new Users();
		savedUser.setActive(active);
		savedUser.setAnswer1(answer1);
		savedUser.setAnswer2(answer2);
		savedUser.setContactAddresses(contactAddresses);
		savedUser.setDefaultLocale(defaultLocale);
		savedUser.setEmailId(emailId);
		savedUser.setExpirable(expirable);
		savedUser.setFirstName(firstName);
		savedUser.setGender(gender);
		savedUser.setLastLoginTime(lastLoginTime);
		savedUser.setLastName(lastName);
		savedUser.setMiddleName(middleName);
		savedUser.setPassword(password);
		savedUser.setPasswordExpireTime(passwordExpireTime);
		savedUser.setPasswordSetTime(passwordSetTime);
		savedUser.setRegistrationTime(registrationTime);
		savedUser.setSecurityQuestion1(securityQuestion1);
		savedUser.setSecurityQuestion2(securityQuestion2);
		savedUser.setShippingAddresses(shippingAddresses);
		savedUser.setTitle(userTitle);
		savedUser.setUserId(userId);
		savedUser.setUserRole(userRole);
		return usersRepository.save(savedUser);
	}

}
