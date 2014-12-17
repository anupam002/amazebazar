package com.packages.amazeIndia.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packages.amazeIndia.document.Users;
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
	private UsersRepository usersRepository;

	@Override
	public Users findByUserId(String userId) {
		return usersRepository.findOne(userId);
	}

	@Override
	public Users findUserByEmailId(String emailId) {
		return usersRepository.findUserByEmailId(emailId);
	}

	@Override
	public Users saveUser(Users user) {
		return usersRepository.save(user);
	}

}
