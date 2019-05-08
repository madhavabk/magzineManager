package com.satkarta.pmsudha.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppUser {
     
 
    private String userId;
    private String firstName;
    private String lastName;
    //private Boolean enabled;
    private String stateCode;
    private String cityCode;
	private String address;
	private String inputZip;
	
	private String subscriptionPeriod;
	private String mobileNo;
	private String cityName;
	private String stateName;
 
    public AppUser() {
 
    }
 
    public AppUser(String userId, String firstName, String lastName, //
            String mobileNo, //
            String address, String cityCode, String cityName,
            String stateCode, String stateName, String inputZip, String subscriptionPeriod //
            ) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.address= address;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.stateCode = stateCode;
        this.setStateName(stateName);
        this.subscriptionPeriod = subscriptionPeriod;
        //this.enabled = enabled;
        this.inputZip = inputZip;
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
    public String getInputZip() {
        return inputZip;
    }
 
    public void setInputZip(String inputZip) {
        this.inputZip = inputZip;
    }
 
	/*
	 * @JsonFormat(shape = JsonFormat.Shape.BOOLEAN) public Boolean isEnabled() {
	 * return enabled; }
	 * 
	 * 
	 * public void setEnabled(Boolean enabled) { this.enabled = enabled; }
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
 
}