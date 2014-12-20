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

import java.util.ArrayList;

import com.packages.amazeIndia.exceptions.MailExceptionHandler;

public interface MailSendingService {
	
	/**
	 * 
	 * @param to
	 * @param subject
	 * @param body
	 * @param CC
	 * @param BCC
	 * @param from
	 * @param replyTo
	 */
	void sendMail(ArrayList<String> to,String subject,String body,ArrayList<String> CC,
			ArrayList<String> BCC,String from,String replyTo) throws MailExceptionHandler;
	
	/**
	 * 
	 * @param body
	 * @param to
	 * @param cc
	 */
	void sendPreConfiguredMail(String body,String to,String cc)throws MailExceptionHandler;
}
