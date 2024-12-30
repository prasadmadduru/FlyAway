package com.tests;
import com.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;

public class FlightSearchTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    FindFlight findFlight;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8081/FlyAway/home"); // Replace with your URL
        homePage = new HomePage(driver);
        loginPage =new LoginPage(driver);
        findFlight=new FindFlight(driver);
    }
    @Test
    public void testLogin() {
        // Navigate to login page
        homePage.clickLogin();

        // Perform login
        loginPage.enterEmail("admin@gmail.com");
        loginPage.enterPassword("Admin123");
        loginPage.clickLogin();

        // Add assertions to verify successful login
        WebElement logout = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logout.isDisplayed(), "Logout link text does not displayes");
    }
    
    @Test
    public void FlightTest() {
    	homePage.clickHome();
    	
    	findFlight.FindFligth("Bangalore", "Chennai");
    	WebElement btn = driver.findElement(By.linkText("Book Flight"));
    	Assert.assertTrue(btn.isDisplayed(), "Book flight is not visible");
    }


   
    @AfterClass
    public void tearDown() {
    	System.out.println("tear down");
       
    }
}