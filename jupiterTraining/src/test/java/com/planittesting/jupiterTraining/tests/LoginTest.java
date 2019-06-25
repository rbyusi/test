package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.jupiterTraining.model.pages.HomePage;

public class LoginTest extends BaseTest {
	
	@Test
	public void ValidateLoginLogout() {
		var homePage = new HomePage(driver);
		var loginDialog =  homePage.clickLogin();
		
		var username = "Ryan";
		var password = "letmein";
//		loginDialog.setUserName(username);
//		loginDialog.setPassword("letmein");
		loginDialog.logIn(username,password);
		loginDialog.clickLogin();
		
		
		var logoutDialog = homePage.clickLogout();
		logoutDialog.clickLogout();
		
		assertEquals("Login", homePage.checkLoginLinkIfPresent());
		
	}

}
