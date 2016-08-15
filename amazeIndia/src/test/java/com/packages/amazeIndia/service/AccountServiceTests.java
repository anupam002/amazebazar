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
package com.packages.amazeIndia.service;

import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.packages.amazeIndia.document.Users.Gender;
import com.packages.amazeIndia.document.Users.Role;
import com.packages.amazeIndia.document.Users.SecurityQuestion;
import com.packages.amazeIndia.document.Users.UserTitle;
import com.packages.amazeIndia.util.AbstractAmazePathTests;

/**
 * 
 * @author anupamsrivastava
 *
 */
@ContextConfiguration(locations = {"classpath:META-INF/spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class AccountServiceTests extends AbstractAmazePathTests {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	@Transactional
	public void findUser() {
		LinkedList<ObjectId> shippingAddress = new LinkedList<ObjectId>();
		LinkedList<ObjectId> contactAddresses = new LinkedList<ObjectId>();
		accountService.saveUser(Role.FULL_ADMIN, UserTitle.MR, Gender.MALE_GENDER, SecurityQuestion.Q1, 
				SecurityQuestion.Q2, "anupam007", "anupam.srivastava@gmail.com", "welcome", true,
				false, System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), 
				System.currentTimeMillis(), Locale.getDefault(), "Anupam",
				"", "Srivastava", "MVN", "Blue", shippingAddress, contactAddresses);
		// Test commit for review test
		Assert.assertEquals("Jayant", accountService.findByUserId("anupam007").getFirstName());
		Assert.assertEquals("panther", accountService.findUserByEmailId("anupam.srivastava@gmail.com").getUserId());
	}

}
