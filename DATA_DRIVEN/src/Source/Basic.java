package Source;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
public class Basic {
	 public static final String SAMPLE_XLSX_FILE_PATH = "F:\\kajolworkspace\\DATA_DRIVEN\\DATA_DRIVEN\\src\\Data\\Book1.xlsx";
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.crossword.in/");
		System.out.println(driver.getTitle());
		
		try { 
            FileInputStream file = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH)); 
            // Create Workbook instance holding reference to .xlsx file 
            XSSFWorkbook workbook = new XSSFWorkbook(file); 
                        // Get first/desired sheet from the workbook 
            XSSFSheet sheet = workbook.getSheetAt(0); 
            
            // Iterate through each rows one by one 
            Iterator<Row> rowIterator = sheet.iterator(); 
            while (rowIterator.hasNext()) { 
                Row row = rowIterator.next(); 
                // For each row, iterate through all the columns 
              //  System.out.println ("Row No.: " + row.getRowNum ());
                if(row.getRowNum()==0){
                	  continue; //just skip the rows if row number is 0 or 1
                	  }
                Iterator<Cell> cellIterator = row.cellIterator(); 
  
                while (cellIterator.hasNext()) { 
                    Cell cell = cellIterator.next(); 
                    System.out.print(cell.getStringCellValue());
                    driver.findElement(By.id("search-input")).sendKeys(cell.getStringCellValue());
                    System.out.println(driver.getTitle());
                    driver.findElement(By.xpath("//*[@id='search']/span[3]/input")).click();
                	System.out.println("Clicked");
                	driver.findElement(By.id("search-input")).clear();
                } 
            } 
            file.close(); 
            
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	
	
	
	
}
}

