import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {
		
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext br1= browser.newContext();
		Page p1= br1.newPage();
		p1.navigate("https://stagelyuat.24livehost.com/");
		p1.fill("#Email", "stagelyadmin@yopmail.com");
		p1.fill("#Password", "Admin@123");
		Locator loginbtn= p1.locator("#loginFrm > div.col-md-12.pt-2 > button");
		loginbtn.click();
		System.out.println(p1.title());
		
		
		/*
		 * BrowserContext br2= browser.newContext(); 
		 * Page p2= br2.newPage();
		 * p2.navigate("https://admin.snprivilege.co.uk/"); p2.fill("#Email",
		 * "emp.admin@yopmail.com"); p2.fill("#Password", "Admin@123");
		 * System.out.println(p2.title());
		 * 
		 * p1.close(); br1.close();
		 * 
		 * p2.close(); br2.close();
		 */
		 
		
	}

}
