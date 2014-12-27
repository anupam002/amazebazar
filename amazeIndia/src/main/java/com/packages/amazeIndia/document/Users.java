/**
 * @author asrivastava
 * Copyright 2014 import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
T WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.packages.amazeIndia.document;

import java.util.LinkedList;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * 
 * @author asrivastava
 *
 */

@Document(collection="users")
@TypeAlias("users")
public class Users {
	/**
	 * Roles available accross the application. Actual text will be taken from messages.
	 */
	public enum Role {
		FULL_ADMIN, CUSTOMER, SUPPLIER
	}
	/**
	 * The user title for the users. Actual text will be taken from messages.
	 */
	public enum UserTitle {
		MR, MRS, MISS
	}
	/**
	 * Actual text will be taken from messages.
	 */
	public enum Gender {
		MALE_GENDER, FEMALE_GENDER, OTHER_GENDER
	}
	/**
	 * Security questions defined in messages.
	 */
	public enum SecurityQuestion {
		Q1, Q2, Q3, Q4, Q5
	}
	
	@Id
	private String userId;
	
	@Indexed(unique=true)
	private String emailId;
	@Field
	private String password;
	@Field
	private Role userRole;
	@Field
	private Boolean active;
	@Field
	private Boolean expirable;
	@Field
	private Long registrationTime;
	@Field
	private Long lastLoginTime;
	@Field
	private Long passwordSetTime;
	@Field
	private Long passwordExpireTime;
	@Field
	private Locale defaultLocale;
	@Field
	private UserTitle title;
	@Field
	private String firstName;
	@Field
	private String middleName;
	@Field
	private String lastName;
	@Field
	private Gender gender;
	@Field
	private SecurityQuestion securityQuestion1;
	
	/**
	 * Persisted with bcrypt
	 */
	@Field
	private String answer1;
	@Field
	private SecurityQuestion securityQuestion2;
	
	/**
	 * Persisted with bcrypt
	 */
	@Field
	private String answer2;
	
	/**
	 * Sorted by order of last used
	 */
	@Field
	private LinkedList<ObjectId> shippingAddresses;
	
	/**
	 * Sorted by order of last used
	 */
	@Field
	private LinkedList<ObjectId> contactAddresses;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getExpirable() {
		return expirable;
	}

	public void setExpirable(Boolean expirable) {
		this.expirable = expirable;
	}

	public Long getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Long registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getPasswordSetTime() {
		return passwordSetTime;
	}

	public void setPasswordSetTime(Long passwordSetTime) {
		this.passwordSetTime = passwordSetTime;
	}

	public Long getPasswordExpireTime() {
		return passwordExpireTime;
	}

	public void setPasswordExpireTime(Long passwordExpireTime) {
		this.passwordExpireTime = passwordExpireTime;
	}

	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public UserTitle getTitle() {
		return title;
	}

	public void setTitle(UserTitle title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public SecurityQuestion getSecurityQuestion1() {
		return securityQuestion1;
	}

	public void setSecurityQuestion1(SecurityQuestion securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public SecurityQuestion getSecurityQuestion2() {
		return securityQuestion2;
	}

	public void setSecurityQuestion2(SecurityQuestion securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public LinkedList<ObjectId> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(LinkedList<ObjectId> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	public LinkedList<ObjectId> getContactAddresses() {
		return contactAddresses;
	}

	public void setContactAddresses(LinkedList<ObjectId> contactAddresses) {
		this.contactAddresses = contactAddresses;
	}


	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("userId", this.getUserId())
	            .append("password", this.getPassword())
	            .append("emailId", this.getEmailId())
	            .append("userRole", this.getUserRole())
	            .append("active", this.getActive())
	            .append("expirable", this.getExpirable())
	            .append("registrationTime", this.getRegistrationTime())
	            .append("lastLoginTime", this.getLastLoginTime())
	            .append("passwordSetTime", this.getPasswordSetTime())
	            .append("passwordExpireTime", this.getPasswordExpireTime())
	            .append("defaultLocale", this.getDefaultLocale())
	            .append("title", this.getTitle())
	            .append("firstName", this.getFirstName())
	            .append("middleName", this.getMiddleName())
	            .append("lastName", this.getLastName())
	            .append("gender", this.getGender())
	            .append("securityQuestion1", this.getSecurityQuestion1())
	            .append("answer1", this.getAnswer1())
	            .append("securityQuestion2", this.getSecurityQuestion2())
	            .append("answer2", this.getAnswer2())
	            .append("shippingAddresses", this.getShippingAddresses())
	            .append("contactAddresses", this.getContactAddresses())
	            .toString();
	}
	
	
	
}
