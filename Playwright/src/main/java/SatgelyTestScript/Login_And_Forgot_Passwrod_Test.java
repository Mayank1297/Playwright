package SatgelyTestScript;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login_And_Forgot_Passwrod_Test {

	public static void main(String[] args) {
		
		//Login Test
	
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext br1=browser.newContext();
		Page p1= br1.newPage();
		p1.navigate("https://stagelyuat.24livehost.com/");
		p1.fill("#Email", "stagelyadmin@yopmail.com"); 
		p1.fill("#Password", "Admin@123"); 
		Locator loginbtn= p1.locator("#loginFrm > div.col-md-12.pt-2 > button");
		loginbtn.click();
		System.out.println(p1.title());
		 
		
		//Forgot Password Test
		
		 BrowserContext br2= browser.newContext(); 
		 Page p2= br2.newPage();
		 p2.navigate("https://stagelyuat.24livehost.com/");
		 p2.locator("text= Forgot Password?").click(); 
		 p2.fill("#Email", "stagelyadmin1@yopmail.com");
		 p2.locator("#ForgotPasswordFrm > button").click(); 
		 String toastmessage= p2.locator("div.toast-message").textContent();
		 System.out.println(toastmessage);
		 

	}

}
