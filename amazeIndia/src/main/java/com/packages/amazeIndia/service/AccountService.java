package com.packages.amazeIndia.service;

import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;

import com.packages.amazeIndia.document.Users;
import com.packages.amazeIndia.document.Users.Gender;
import com.packages.amazeIndia.document.Users.Role;
import com.packages.amazeIndia.document.Users.SecurityQuestion;
import com.packages.amazeIndia.document.Users.UserTitle;


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

public interface AccountService {
	
	/**
	 * @param userId
	 * @return
	 */
	public Users findByUserId(String userId);
	/**
	 * @param emailId
	 * @return
	 */
	public Users findUserByEmailId(String emailId);
	/**
	 * @param userRole
	 * @param userTitle
	 * @param gender
	 * @param securityQuestion1
	 * @param securityQuestion2
	 * @param userId
	 * @param emailId
	 * @param password
	 * @param active
	 * @param expirable
	 * @param registrationTime
	 * @param lastLoginTime
	 * @param passwordSetTime
	 * @param passwordExpireTime
	 * @param defaultLocale
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param answer1
	 * @param answer2
	 * @param shippingAddresses
	 * @param contactAddresses
	 * @return
	 */
	public Users saveUser(Role userRole,UserTitle userTitle,Gender gender,SecurityQuestion securityQuestion1,SecurityQuestion securityQuestion2,String userId,
			String emailId,String password,Boolean active,Boolean expirable,Long registrationTime,Long lastLoginTime,
			Long passwordSetTime,Long passwordExpireTime,Locale defaultLocale,String firstName,String middleName,
			String lastName,String answer1,String answer2,LinkedList<ObjectId> shippingAddresses,LinkedList<ObjectId> contactAddresses);
	
	
}
