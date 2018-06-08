
package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatronInfo {

@SerializedName("name")
@Expose
private String name;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("email")
@Expose
private String email;
@SerializedName("billing_address")
@Expose
private String billingAddress;
@SerializedName("cc_number")
@Expose
private String ccNumber;
@SerializedName("cc_expiration_date")
@Expose
private String ccExpirationDate;

/**
* No args constructor for use in serialization
* 
*/

public PatronInfo() {
}

/**
* 
* @param phone
* @param ccExpirationDate
* @param email
* @param ccNumber
* @param name
* @param billingAddress
*/
public PatronInfo(String name, String phone, String email, String billingAddress, String ccNumber, String ccExpirationDate) {
super();

this.name = name;
this.phone = phone;
this.email = email;
this.billingAddress = billingAddress;
this.ccNumber = ccNumber;
this.ccExpirationDate = ccExpirationDate;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getBillingAddress() {
return billingAddress;
}

public void setBillingAddress(String billingAddress) {
this.billingAddress = billingAddress;
}

public String getCcNumber() {
	
	//debug hwere and try that// be back in 10 minutes pkWhat happenefn ??
return ccNumber;
}

public void setCcNumber(String ccNumber) {
	String ccNumberLast4igits = ccNumber.substring(ccNumber.length()-4);
	String ccNumberFirst = ccNumber.substring(0,ccNumber.length()-4).replaceAll(".", "x");
this.ccNumber = ccNumberFirst+ccNumberLast4igits;
}
 
public String getCcExpirationDate() {
return ccExpirationDate;
}

public void setCcExpirationDate(String ccExpirationDate) {
this.ccExpirationDate = ccExpirationDate;
}

}