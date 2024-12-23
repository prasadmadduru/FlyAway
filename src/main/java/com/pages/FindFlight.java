package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindFlight
{
	WebDriver driver;
	public FindFlight(WebDriver driver) {
		this.driver=driver;
	}
	 
	  By sourceDropdown = By.name("source");
	  By destinationDropdown = By.name("destination");
	  By submitButton = By.xpath("//button[text()='Submit']");
	  
	  public void FindFligth(String source,String dest) {
		  WebElement websource = driver.findElement(sourceDropdown);
		  Select sou = new Select(websource);
		  sou.selectByVisibleText(source);
		  WebElement webdestination = driver.findElement(destinationDropdown);
		  Select desti = new Select(webdestination);
		  desti.selectByVisibleText(dest);
		  WebElement btn = driver.findElement(submitButton);
		  btn.click();
		  
	  }
	  

}
