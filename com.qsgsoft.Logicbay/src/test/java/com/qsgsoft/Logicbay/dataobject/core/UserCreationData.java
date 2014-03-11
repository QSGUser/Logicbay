package com.qsgsoft.Logicbay.dataobject.core;

public class UserCreationData {
	// Data for creating a User
	public String UserName = "User1" + System.currentTimeMillis(),
			EmailAddress = "User"+System.currentTimeMillis()+"@logicbay.com",
			Salutation = "Ms.",
			FirstName = "test" + System.currentTimeMillis(), 
			MiddleName = "MN"+ System.currentTimeMillis(), 
			LastName = "user"+ System.currentTimeMillis(), 
			Password = "Qsg@2014",
			Locale = "English", 
			TimeZone = "Hawaii", 
			Gender = "Male",
			MemberStatus = "Approval Granted", 
			SystemRole = "Default Role",
			JobRole = "Administrator", 
			CenterSubtype = "None",
			CenterSrc = "Performance Center", 
			NewPassword = "Logic@2025",
			AssociatedAccount = "None";
			
}