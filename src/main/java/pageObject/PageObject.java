package pageObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
	private static WebDriver driver;
	private static final Map<String, By> elementDatas = new HashMap<String, By>();
	public PageObject(WebDriver drivers) {
		driver = drivers;
	}
	
	public static void element(String key, By by) {
		elementDatas.put(key, by);
	}
	
	public static WebElement element(String key) {
		By by = elementDatas.get(key);
		if(by==null) 
			throw new NoSuchElementException("Element "+key+" is not prenent");
		return driver.findElement(by);
	}
	
	public static List<WebElement> elements(String key){
		By by = elementDatas.get(key);
		if(by==null) 
			throw new NoSuchElementException("Element "+key+" is not prenent");
		return driver.findElements(by);
	}
}
