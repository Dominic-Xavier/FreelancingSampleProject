package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.WebTestBase;
import excel.PutData;
import pageObject.SamplePageObjectClass;

public class SampleTestcase extends WebTestBase{
	
	static SamplePageObjectClass page;
	static WebDriver driver;
	PutData data;
	Workbook wb;
	
	@BeforeClass
	public void launchBrowser() {
		driver = getWebDriver("Chrome");
		passURL("https://www.bbc.com/");
	}
	
	@Test
	public void writeLinks() throws IOException, InvalidFormatException {
		page = new SamplePageObjectClass(driver);
		List<String> allLinks = page.getAllLinks();
		List<String> allLinkTexts = page.getAllLinkTexts();
		data = new PutData();
		//int i=0, j=0;
		File file = new File("./testData.xlsx");
		
		wb = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(file);
		Sheet sheet = wb.createSheet("Demo");
		for(int k=0;k<allLinks.size();k++) {
			Row createRow = sheet.createRow(k);
			createRow.createCell(0).setCellValue(allLinks.get(k));
			createRow.createCell(1).setCellValue(allLinkTexts.get(k));
		}
		
		wb.write(fos);
		/*for (String text : allLinks) {
			System.out.println(text);
			sheet.createRow(i++).createCell(j).setCellValue(text);
		}
		i=0; j=1;
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		
		for (String text : allLinkTexts) {
			System.out.println(text);
			
			sheet.createRow(i++).createCell(j).setCellValue(text);
		}
		wb.write(fos);*/
		wb.close();
	}
}
