/*import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {

	public static void main(String[] args) {
		
		//To Start the Playwright Server:
		Playwright playwright= Playwright.create();
		
		//To Open browser in Headless Mode:
		//Browser browser= playwright.chromium().launch();
		
		//To Open Browser without Headless Mode:
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//To Open the URL:
		Page page= browser.newPage();
		page.navigate("https://www.amazon.in/");
		
		//To get the title:
		String title= page.title();
		System.out.println("Title is :" +title);
		
		//To get URL:
		String url= page.url();
		System.out.println("URL is :" + url);
		
		//To close the browser:
		//browser.close();
		
		//To close the Playwright:
		//playwright.close();
		
	}

}*/





import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class PlaywrightBasic {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      //To start the tracing:
      context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
      
      Page page = context.newPage();
      page.navigate("https://www.amazon.in/");
      
      page.getByPlaceholder("Search Amazon.in").click();
      
      page.getByPlaceholder("Search Amazon.in").fill("Jeans");
      
      page.getByLabel("jeans for man").click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create your Amazon account")).click();
      
      page.getByPlaceholder("First and last name").click();
      page.getByPlaceholder("First and last name").fill("Mayank");
      
      page.locator("span").filter(new Locator.FilterOptions().setHasText("IN +")).nth(3).click();
     
      
      page.getByPlaceholder("Mobile number").click();
      page.getByPlaceholder("Mobile number").fill("9865329863");
      
      page.getByPlaceholder("At least 6 characters").click();
      page.getByPlaceholder("At least 6 characters").fill("Test@123");
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon").setExact(true)).click();
      
      //To Stop the tracing and export it into ZIP archive:
      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
  }
}
