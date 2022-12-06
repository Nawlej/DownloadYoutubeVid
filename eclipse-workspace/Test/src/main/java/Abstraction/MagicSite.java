package Abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MagicSite {
	public WebDriver driver;
	protected WebDriverWait wait;
	protected String downloadFilepath;
	
	public void navigateToMagicSite() {
		String urlPart1 = driver.getCurrentUrl().substring(0, 15);
		String urlPart2 = driver.getCurrentUrl().substring(15, driver.getCurrentUrl().length());
		String url = urlPart1 + "magic" + urlPart2;
		driver.navigate().to(url);
	}
	
	public void downloadVid() throws InterruptedException {
		String window = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text() = 'Load Options']")).click();
		driver.findElement(By.xpath("//a[text() = 'Listen ']")).click();
		driver.findElement(By.xpath("//a[text() = ' > Click here to continue < ']")).click();
		
		driver.switchTo().window(window);
		driver.findElement(By.xpath("//a[text() = 'Click here to start ']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@style = 'min-width: 20px; width: 100%;']"))));
		String filename = driver.getTitle().substring(16);
		Thread.sleep(5000);
		System.out.println(filename + " was successfully downloaded");
	}
}
