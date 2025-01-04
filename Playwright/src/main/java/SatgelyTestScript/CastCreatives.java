package SatgelyTestScript;

import java.nio.file.Paths;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
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
		
		//Upload Image:
		
		FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("#AddUpdatecastForm > div > div > div.col-lg-auto > div > label").click());
		fileChooser.setFiles(Paths.get("C:\\\\Users\\\\Admin\\\\Downloads\\\\05c85bf3-b047-400e-81ff-d2f80a93a198_rw_1200.jpg"));
		
		// Enter the details:
		Faker faker = new Faker();

		String name = faker.name().fullName();
		String phonenumber = faker.phoneNumber().cellPhone();
		String streetAddress = faker.address().streetAddress();
		
		page.fill("#Name", name);
		page.locator("#AddUpdatecastForm > div > div > div.col-lg > div:nth-child(2) > div:nth-child(2) > div > div > div > div > div").click();
		Locator dropDownList = page.locator("#iti-0__item-in");
		dropDownList.selectOption("+91");
		
	}

}
