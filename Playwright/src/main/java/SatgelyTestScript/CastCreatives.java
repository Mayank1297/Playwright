package SatgelyTestScript;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CastCreatives {

	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext br=browser.newContext();
		Page page= br.newPage();
		page.navigate("https://stagelyuat.24livehost.com/");
		page.fill("#Email", "stagelyadmin@yopmail.com"); 
		page.fill("#Password", "Admin@123"); 
		Locator loginbtn= page.locator("#loginFrm > div.col-md-12.pt-2 > button");
		loginbtn.click();
		
		//Click on the Cast/Creative:
		
		Locator castcreative= page.locator("#ManageCast > a > span");
		castcreative.click();
		
		// Click on the New Cast/Creative Button:
		
		Locator addcastcreative= page.locator("body > div.container-fluid.mt-3 > div > div.page-title-row > a");
		addcastcreative.click();
		
		
		
	}

}
