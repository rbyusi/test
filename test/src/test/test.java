package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {

	public static void main(String[] args) {
		
		//configure webdriver 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Auto\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://twitter.com/";
		String expectedTitle = "Twitter. It's what's happening.";
		String actualTitle = "";
		
		
		//open browser and direct to base URL
		driver.get(baseUrl);
		
		//get the actual title of the webpage
		actualTitle = driver.getTitle();
		
		//check page title
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Title Passed!");
		}else {
			System.out.println("Test Title Failed!");
			
		}
		
		
		
		//close browser
		driver.close();
	}

}
