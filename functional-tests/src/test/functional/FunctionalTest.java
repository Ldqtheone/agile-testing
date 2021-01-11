package test.functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
		assertEquals(driver.getTitle(), "Partagez vos passions | Meetup");
		assertEquals(driver.findElement(By.className("exploreHome-hero-mainTitle")).getText(), "Le monde vous tend les bras");
		assertEquals(driver.findElement(By.className("exploreHome-hero-subTitle")).getText(), "Rejoignez un groupe local pour rencontrer du monde, tester une nouvelle activité ou partager vos passions.");
		assertEquals(driver.findElement(By.id("joinMeetupButton")).getCssValue("background"), "rgb(241, 58, 89) none repeat scroll 0% 0% / auto padding-box border-box");
		assertEquals(driver.findElement(By.id("joinMeetupButton")).getText(), "Rejoindre Meetup");
		assertEquals(driver.findElement(By.id("joinMeetupButton")).getAttribute("href"), "https://www.meetup.com/fr-FR/register/");
    }

    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
