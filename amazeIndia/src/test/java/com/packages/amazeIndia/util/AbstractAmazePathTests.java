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
package com.packages.amazeIndia.util;

import java.io.File;

/**
 * 
 * @author anupamsrivastava
 *
 */
public abstract class AbstractAmazePathTests {

	static {
		if(null == System.getProperty("AMAZEINDIA")) {
			System.err.println("This must be a junit manual run");
			System.err.println("AMAZEINDIA should be always set by the enviornment");
			System.err.println("Setting dummy amazeIndia to run tests");
			System.err.println("AMAZEINDIA="+System.getProperty("user.home") + File.separator + ".amazeindiatest");
			System.setProperty("AMAZEINDIA", System.getProperty("user.home") + File.separator + ".amazeindiatest");
		} else {
			System.out.println("Found efstore path: "+System.getProperty("AMAZEINDIA"));
		}
	}
	
}
