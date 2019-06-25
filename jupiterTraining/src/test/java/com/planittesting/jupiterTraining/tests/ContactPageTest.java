package com.planittesting.jupiterTraining.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.planittesting.jupiterTraining.model.pages.ContactPage;
import com.planittesting.jupiterTraining.model.pages.HomePage;

public class ContactPageTest extends BaseTest {

	ContactPage contactPage;
	HomePage homePage;

	@Test
	public void InvalidEmailMessage() {
		homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);
		homePage.clickContactLink();
		contactPage.setEmailAddress("Invalid");

		assertEquals("Please enter a valid email", contactPage.getInvalidEmailErr());
	}

	@Test
	public void ValidateErrorMessage() {
		homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);

		homePage.clickContactLink();
		contactPage.clickSubmit();

		var forename = "Ryan";
		var email = "test@gmail.com";
		var message = "test message";

		assertEquals("Forename is required", contactPage.getInvalidForeNameErr());
		assertEquals("Email is required", contactPage.getInvalidEmailErr());
		assertEquals("Message is required", contactPage.getInvalidMessageErr());

		contactPage.setForename(forename);
		contactPage.setEmailAddress(email);
		contactPage.setMessage(message);

	}

	@Test
	public void VerifySuccessMessage() {
		homePage = new HomePage(driver);
		contactPage =  new ContactPage(driver);
		
		var forename = "Ryan";
		var surname = "Yusi";
		var email = "test@gmail.com";
		var phone = "12345678";
		var message = "test message";
		
		homePage.clickContactLink();
		
		contactPage.setForename(forename);
		contactPage.setSurname(surname);
		contactPage.setEmailAddress(email);
		contactPage.setPhone(phone);
		contactPage.setMessage(message);

		contactPage.clickSubmit();
		
		assertEquals("Thanks Ryan, we appreciate your feedback.", contactPage.verifySuccessMessage());
	}

}
