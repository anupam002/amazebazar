# Amaze India

## What's this?
Application core for Amaze India.

Download wildfly 8.1.0 [here](http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.zip).

#### Sample wildfly setting system property on wildfly/standalone/configuration/standalone.xml
	<system-properties>
        <property name="AMAZEINDIA" value="E:\home\amazeindia"/>
	</system-properties>
	
#### EFSTORE Directory Structure
	.
	+-- bin
	|   +-- start.sh
	|   +-- stop.sh
	+-- conf
	|   +-- amazeindia.conf
	+-- nfs
	|   +-- PRIVATE
	|   +-- RESTRICTED
	|   +-- PUBLIC
	+-- log
	|   +-- amazeindia.log
	+-- farm
	|   +-- amazeindia.war
	+-- wildfly
	|   +-- <The wildfly 8.1.0 directory contents>
	
#### Sample	[amazeindia.conf](src/main/resources/spring/amazeindia.conf)

Once downloaded, the application can be locally deployed onto wildfly 8.1.0

Which will start a Tomcat server you can access at: http://localhost:8080/amazeIndia/


