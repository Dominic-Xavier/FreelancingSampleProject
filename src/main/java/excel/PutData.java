package excel;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PutData {
	
	private File file;
	private FileOutputStream fos;
	private Workbook wb;
	private Sheet sheet;
	
	public void writeData(int row, int column, String data) throws IOException, InvalidFormatException {
		
		file = new File("./testData.xlsx");
		
		wb = new XSSFWorkbook(file);
		sheet = wb.createSheet("Demo");
		sheet.createRow(row++).createCell(column).setCellValue(data);
		fos = new FileOutputStream(file);
		
		
		//System.out.println("Cell Created Successfully...!");
	}
	
	public void writeData() throws IOException {
		wb.write(fos);
	}
}