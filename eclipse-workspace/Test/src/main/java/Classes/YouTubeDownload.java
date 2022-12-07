package Classes;
import java.io.File;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.HashMap;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Abstraction.MagicSite;

public class YouTubeDownload extends MagicSite{
	
	
	public YouTubeDownload() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	}

	//new features to implement = delete downloaded videos, have option to download either video or audio only, if high quality is not available then go to lower quality link
	public void readTextDocument(String filepath) {
		Scanner scanner = null;
		PrintWriter writer = null;
		try {
			File textfile = new File(filepath);
			scanner = new Scanner(textfile);
			while(scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println("Preparing to download " + data);
				try {
					downloadYouTubeVideos(data);
					writer = new PrintWriter(textfile);
					writer.append("");
					writer.flush();
				}
				catch (Exception e) {
					System.out.println(e);
					System.out.println(data + " failed to download");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		} finally {
			scanner.close();
			writer.close();
			driver.quit();
		}
	}
	
	public void downloadYouTubeVideos(String videoName) throws InterruptedException {		
		if (videoName.equals(null) || videoName.equals("")) {
			return;
		}
		searchVid(videoName);
		navigateToMagicSite();
		downloadVid();
	}
	
	public void searchVid(String videoName) {
		driver.navigate().to("https://www.youtube.com");
		driver.findElement(By.xpath("//input[@id = 'search']")).sendKeys(videoName);
		//sometimes button click isn't registered
		do {
			driver.findElement(By.xpath("//ytd-searchbox[@id = 'search']/button[@id = 'search-icon-legacy']")).click();
		}
		while(!(driver.findElement(By.xpath("//a[@id = 'video-title']")).isDisplayed()));
		
		driver.findElement(By.xpath("//a[@id = 'video-title']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id = 'cinematics']"))));
	}
	

}
