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

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

/**
 * Sets up a in memory mongo server for running integration tests
 * @author asrivastava
 *
 */
public class InMemoryMongoServerForTest implements InitializingBean, DisposableBean, FactoryBean<MongoClient> {

	/**
     * please store Starter or RuntimeConfig in a static final field
     * if you want to use artifact store caching (or else disable caching)
     */
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();
    private MongodExecutable _mongodExe;
    private MongodProcess _mongod;
    private static volatile MongoClient _mongo;
    
    private int port;
    private boolean randomPort;
    
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isRandomPort() {
		return randomPort;
	}

	public void setRandomPort(boolean randomPort) {
		this.randomPort = randomPort;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(randomPort) {
			this.port = Network.getFreeServerPort();
		}
		_mongodExe = starter.prepare(new MongodConfigBuilder()
        .version(Version.Main.PRODUCTION)
        .net(new Net(this.port, Network.localhostIsIPv6()))
        .build());
		_mongod = _mongodExe.start();
	}

	@Override
	public void destroy() throws Exception {
		_mongod.stop();
        _mongodExe.stop();
	}

	@Override
	public MongoClient getObject() throws Exception {
		if(_mongo == null) {
			synchronized (InMemoryMongoServerForTest.class) {
				if(_mongo == null) {
					_mongo = new MongoClient("localhost", this.port);
				}
			}
			
		}
		return _mongo;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
