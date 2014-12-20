/**
 * 
 */
package com.packages.amazeIndia.service.internal;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.packages.amazeIndia.exceptions.MailExceptionHandler;
import com.packages.amazeIndia.service.MailSendingService;

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
public class MailSendingServiceImpl implements MailSendingService{

	@Autowired
	public MailSender mailSender;
	
	@Autowired
	public SimpleMailMessage preconfiguredMessage;
	
	@Override
	public void sendMail(ArrayList<String> to,String subject,String body,ArrayList<String> CC,
			ArrayList<String> BCC,String from,String replyTo)throws MailExceptionHandler{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		if(to == null || from ==null){
			throw new MailExceptionHandler("Exception Ocurred ! Email to addresses are :"+to+" and from are :"+from+"");
		}
		String[] toStringArr = to.toArray(new String[to.size()]);
		mailMessage.setSubject(subject!=null?subject:"");
		mailMessage.setText(body!=null?body:"");
		mailMessage.setFrom(from);
		mailMessage.setTo(toStringArr);
		if(BCC!=null){
			String[] bccStringArr = BCC.toArray(new String[BCC.size()]);
			mailMessage.setBcc(bccStringArr);
		}
		if(CC!=null){
			String[] ccStringArr = CC.toArray(new String[CC.size()]);
			mailMessage.setCc(ccStringArr);
		}
		if(replyTo!=null){
			mailMessage.setReplyTo(replyTo);
		}
		mailSender.send(mailMessage);
	}
	
	@Override
	public void sendPreConfiguredMail(String body,String to,String cc) throws MailExceptionHandler{
        SimpleMailMessage mailMessage = new SimpleMailMessage(preconfiguredMessage);
        if(to == null){
        	throw new MailExceptionHandler("Exception Ocurred ! Send email to not found");
        }
        mailMessage.setText(body);
        mailMessage.setTo(to);
        if(cc!=null){
        	mailMessage.setCc(cc);
        }
        mailSender.send(mailMessage);
    }
}
