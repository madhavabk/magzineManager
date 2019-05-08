package com.satkarta.pmsudha.formbean;

public class AppUserForm {

	private String userId;
	private String address;
	private String firstName;
	private String lastName;
	//private boolean enabled;
	private String subscriptionPeriod;
	private String stateCode;
	private String cityCode;
	private String mobileNo;
	private String inputZip;
	private String cityName;

	public AppUserForm() {

	}

	public AppUserForm(String userId, //
			String firstName, String lastName, String mobileNo, //
			String address, //
			String cityCode, String cityName, String stateCode, String subscriptionPeriod) {

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		//this.enabled = enabled;
		this.subscriptionPeriod = subscriptionPeriod;
		this.stateCode = stateCode;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public boolean isEnabled() { return enabled; }
	 * 
	 * public void setEnabled(boolean enabled) { this.enabled = enabled; }
	 */

	public String getSubscriptionPeriod() {
		return subscriptionPeriod;
	}

	public void setSubscriptionPeriod(String subscriptionPeriod) {
		this.subscriptionPeriod = subscriptionPeriod;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getMobileNo() {
		// TODO Auto-generated method stub
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getInputZip() {
		return inputZip;
	}

	public void setInputZip(String inputZip) {
		this.inputZip = inputZip;
	}

}