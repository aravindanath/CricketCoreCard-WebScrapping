package TestDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CricketScoreBoard {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
		//driver.get(args[0]);
		driver.get("http://www.espncricinfo.com/series/8048/scorecard/1178425/chennai-super-kings-vs-delhi-capitals-50th-match-indian-premier-league-2019");

		
		if(!driver.findElement(By.xpath("(//div[@class='cell batsmen' and text()='BATSMEN'])[1]")).isDisplayed()){
			driver.findElement(By.xpath("(//article[@class='sub-module scorecard'])[1]"
					+ "//a[@role='button' and @class='collapsed']")).click();
		}
		
		List<WebElement> batsMenList = driver
				.findElements(By.xpath("//div[@class='cell batsmen']//a[@name='&lpos=cricket:game:scorecard:player']"));

		System.out.println(batsMenList.size());

		for (int i = 0; i < batsMenList.size(); i++) {
			System.out.println();
			getPlayerScroreCard(driver, batsMenList.get(i).getText());
		}
	}

	public static void getPlayerScroreCard(WebDriver driver, String playerName) {

		List<WebElement> playerScoreInfoList = driver.findElements(By.xpath(
				"//a[contains(text(),'" + playerName + "')]//parent::div//following-sibling::div[@class='cell runs']"));

		if (playerName.length() <= 8) {
			System.out.print(playerName + "\t" + "\t");
		} else {
			System.out.print(playerName + "\t");
		}

		for (int i = 0; i < playerScoreInfoList.size(); i++) {
			System.out.print(playerScoreInfoList.get(i).getText() + "\t");

		}

	}

}
