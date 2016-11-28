package com.glance.userlogin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.glance.common.tests.BaseTest;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.dashboard.CommonPageLeftPane;
import com.glance.pageobjects.dashboard.DashboardPage;
import com.glance.pageobjects.userlogin.LockScreenPage;
import com.glance.pageobjects.userlogin.LoginPage;

public class VerifyLockScreen extends BaseTest{

	
	
	CommonPageObject commonPage;
	LoginPage login;
	CommonPageLeftPane leftPanel;
	LockScreenPage lockscreen;
	DashboardPage dashboard;
	
	
	//Enter correct password and check
	@Test (priority=0)
	public void verifyLockScreen() throws Exception {
		
		
	// Login to Glance By entering user name and password
			login=new LoginPage(driver);
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			
	// click on LockScreen button in left panal
			leftPanel=new CommonPageLeftPane(driver);
			leftPanel.clickScreenLock();
			
	//click on profile picture
			lockscreen=new LockScreenPage(driver);
			
	//checking whether in lockscreen page		
			Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
			
	//giving password and login		
			lockscreen.clickProfilePicture();
			lockscreen.enterPassword(password);
			lockscreen.clickLogInBtn();
			
	//checking whether in dashboard page
			dashboard =new DashboardPage(driver);
			Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
			
	//Logout
	        leftPanel.clickLogout();
			
			
		}
	
	
	//Enter wrong password and check
	@Test (priority=1)
	public void verifyLockScreenWrongPassword() throws Exception {
		
		
	// Login to Glance By entering user name and password
			login=new LoginPage(driver);
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			
	// click on LockScreen button in left panal
			leftPanel=new CommonPageLeftPane(driver);
			leftPanel.clickScreenLock();
			
	//click on profile picture
			lockscreen=new LockScreenPage(driver);
			
	//checking whether in lockscreen page		
			Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
			
	//giving password and login		
			lockscreen.clickProfilePicture();
			lockscreen.enterPassword(wrongpassword);
			lockscreen.clickLogInBtn();
			
			
			lockscreen.clickLogInOKBtn();
	
	//checking whether in lockscreen page and login with correct password	
			Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
			lockscreen.clickProfilePicture();
			lockscreen.enterPassword(password);
			lockscreen.clickLogInBtn();
			
	//checking whether in dashboard page
			dashboard =new DashboardPage(driver);
			Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
			
	//Logout
	        leftPanel.clickLogout();
			
			
		}
	
	
	//Enter empty password and check
	@Test (priority=2)
	public void verifyLockScreenWrongPassword2() throws Exception {
		
		
	// Login to Glance By entering user name and password
			login=new LoginPage(driver);
			login.enterUsername(userName);
			login.enterPassword(password);
			login.clickLoginBtn();
			
	// click on LockScreen button in left panal
			leftPanel=new CommonPageLeftPane(driver);
			leftPanel.clickScreenLock();
			
	//click on profile picture
			lockscreen=new LockScreenPage(driver);
			
	//checking whether in lockscreen page		
			Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));
			
	//giving password and login		
			lockscreen.clickProfilePicture();
			lockscreen.enterPassword(emptypassword);
			
	//checking whether in lockscreen page and login with correct password	
			Assert.assertTrue(lockscreen.verifyNavigationToLockScreen("Lock Screen"));		
			
			lockscreen.enterPassword(password);
			lockscreen.clickLogInBtn();
			
	//checking whether in dashboard page
			dashboard =new DashboardPage(driver);
			Assert.assertTrue(dashboard.verifyNavigationToDashboardPage("Account Level Dashboard"));
			
	//Logout
	        leftPanel.clickLogout();
			
			
		}
	
	
	
	
		
}