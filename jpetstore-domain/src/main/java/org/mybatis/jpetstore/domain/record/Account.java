package org.mybatis.jpetstore.domain.record;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 8751282105532159742L;

	protected String username;
	protected String password;
	protected String email;
	protected String firstName;
	protected String lastName;
	protected String status;
	protected String address1;
	protected String address2;
	protected String city;
	protected String state;
	protected String zip;
	protected String country;
	protected String phone;
	protected String favouriteCategoryId;
	protected String languagePreference;
	protected boolean listOption;
	protected boolean bannerOption;
	protected String bannerName;

}
