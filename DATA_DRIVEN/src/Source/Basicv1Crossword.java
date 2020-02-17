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
public class Basicv1Crossword {
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
            
            Row row = sheet.getRow(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
    			row = sheet.getRow(i);
    			String value=row.getCell(0).toString();
    			driver.findElement(By.id("search-input")).sendKeys(value);
                System.out.println(driver.getTitle());
                driver.findElement(By.xpath("//*[@id='search']/span[3]/input")).click();
            	System.out.println("Clicked");
            	driver.findElement(By.id("search-input")).clear();
            	
            }
            file.close(); 
            } 
           
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	
	}
}


