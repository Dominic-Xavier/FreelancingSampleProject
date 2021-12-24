package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.WebTestBase;

public class SamplePageObjectClass extends PageObject{
	WebTestBase base = new WebTestBase();
	static List<WebElement> allelements;
	//Declaring the objects here
	public SamplePageObjectClass(WebDriver driver) {
		super(driver);
		element("allLinks", By.tagName("a"));
	}
	
	//All the operations here
	
	public List<String> getAllLinks() {
		allelements = elements("allLinks");
		System.out.println("Count is"+allelements.size());
		List<String> allData = new ArrayList<>();
		
		for (WebElement webElement : allelements) {
			String attribute = webElement.getAttribute("href");
			System.out.println(attribute);
			allData.add(attribute);
		}
		return allData;
	}
	
	public List<String> getAllLinkTexts(){
		allelements = elements("allLinks");
		System.out.println("Count is"+allelements.size());
		List<String> allData = new ArrayList<>();
		
		for (WebElement webElement : allelements) {
			String attribute = webElement.getText();
			System.out.println(attribute);
			allData.add(attribute);
		}
		return allData;
	}
}
