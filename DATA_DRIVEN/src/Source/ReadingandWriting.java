package Source;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.List;
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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
public class ReadingandWriting {

	public static final String SAMPLE_XLSX_FILE_PATH = "F:\\kajolworkspace\\DATA_DRIVEN\\DATA_DRIVEN\\src\\Data\\Book1.xlsx";
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		System.out.println("execution started");
		 // Array List to store the excel sheet data
		// Array List to store the excel sheet data
		ArrayList<Object[]> sheetData=new ArrayList<Object[]>();
		System.out.println("))))))00000000)))))");
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
	                   // System.out.print(cell.getStringCellValue());
	                    sheetData.add(new Object[]{cell.getStringCellValue()});
	                   
	                } 
	                System.out.println(sheetData+"*********"); 
	            } 
	            file.close(); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
		// Blank workbook 
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			// Create a blank sheet 
			XSSFSheet sheet = workbook.createSheet("student_Details"); 
			// Iterate over data and write to sheet 
			//Set<String> keyset = ((Object) sheetData).keySet(); 
			int rownum = 0; 
			for (Object[] countries : sheetData) { 
				{
					   Row row = sheet.createRow(rownum++);
					 
					   int cellnum = 0;
					   for (Object obj : countries)
					   {
					    Cell cell = row.createCell(cellnum++);
					    if(obj instanceof String)
					     cell.setCellValue((String)obj);
					    else if(obj instanceof Double)
					     cell.setCellValue((Double)obj);
					    else if(obj instanceof Integer)
					     cell.setCellValue((Integer)obj);
					   }
					  }
			}
				try
				  {
				   //Write the workbook in file system
				   FileOutputStream out = new FileOutputStream(new File("F:\\kajolworkspace\\DATA_DRIVEN\\DATA_DRIVEN\\src\\Data\\CountriesDetails1.xlsx"));
				   workbook.write(out);
				   out.close();
				   System.out.println("CountriesDetails.xlsx has been created successfully");
				  } 
				  catch (Exception e) 
				  {
				   e.printStackTrace();
				  }
				  
        
	}
	}


