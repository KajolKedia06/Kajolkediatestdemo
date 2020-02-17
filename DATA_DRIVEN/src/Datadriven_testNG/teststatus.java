package Datadriven_testNG;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class teststatus {
	 WebDriver driver;
		int i=1;
	  public static XSSFWorkbook workbook;
	    public static XSSFSheet worksheet;
	    public static DataFormatter formatter= new DataFormatter();
	    public static String file_location = "C:\\Selenium\\DATA_DRIVEN\\src\\Data\\crosswrd.xlsx";
	    static String SheetName= "Sheet1";
	    static ArrayList<String> status=new ArrayList<String>();
	    int rownum = 0;
	    int cellnum = 0;
	    String title = null;
	    Map<Integer, Object[]> TestNGResults;
	@BeforeTest
	public void bfre(){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		TestNGResults = new LinkedHashMap<Integer, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put(0, new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
		System.out.println("*********** "+TestNGResults);

	}
	
	@DataProvider
	 public static Object[][] ReadVariant() throws IOException
    {
    	FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                XSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
 
        return Data;
    }
	
	@Test
	(dataProvider="ReadVariant") //It get values from ReadVariant function method
	  //Here my all parameters from excel sheet are mentioned.
    public void AddVariants(String USERNAME, String PASSWORD) throws Exception{
		System.out.println("inside test method");
		
		driver.manage().window().fullscreen();
		
		try{
			driver.get("https://www.crossword.in/login");
			TestNGResults.put(i, new Object[] { 1d, "Navigate to crossword website", "Site gets opened", "Pass" });
		}
		catch(Exception e){
			TestNGResults.put(i, new Object[] { 1d, "Navigate to crossword website", "Site gets opened", "fail" });
		}
		i++;
		
		try{
			driver.findElement(By.id("user_session_email")).sendKeys(USERNAME);
			TestNGResults.put(i, new Object[] { 2d, USERNAME, "enter username", "Pass" });
		}
		catch(Exception e){
			TestNGResults.put(i, new Object[] { 2d, USERNAME, "enter username", "fail" });
		}
		
		i++;
	
	
		try {
			driver.findElement(By.id("user_session_password")).sendKeys(PASSWORD);
		//driver.manage().window().fullscreen();
			TestNGResults.put(i, new Object[] { 3d, PASSWORD, "entered password", "Pass" });
		} catch (Exception e) {
			TestNGResults.put(i, new Object[] { 3d, PASSWORD, "entered password", "Fail" });
		
		}
		i++;
	
		try {
			driver.findElement(By.id("user_session_submit")).click();
		//	driver.manage().window().fullscreen();
			TestNGResults.put(i, new Object[] { 4d, "login sucessfull", "login sucessfull", "Pass" });
		} catch (Exception e) {
			TestNGResults.put(i, new Object[] { 4d, "login sucessfull", "login sucessfull", "Fail" });
		
		}
	i++;
	
//		Thread.sleep(5000);
	
	
	
		 
	}
	/*
	public void test(){
		 if(title.equals("Crossword")){
				status.add("PASSED"); 
			 }
			 else{
				 status.add("FAILED");
			 }
			 for(int p=0;p<status.size();p++){
			    	System.out.println(">>>>> "+status.get(p)+" <<<<<<");
			    }
			 
	}*/
	
	@AfterTest
	public void aftrtest() throws IOException{

		
		System.out.println("After ----------test");
		System.out.println("inside test method"+TestNGResults.toString());
		
//		// Declare An Excel Work Book
//		XSSFWorkbook workbook;
//		// Declare An Excel Work Sheet
//		XSSFSheet worksheet;
//		// Declare A Map Object To Hold TestNG Results
		
		Set<Integer> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (Integer key : keyset) {
			Row row = worksheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj1 : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj1 instanceof Date)
					cell.setCellValue((Date) obj1);
				else if (obj1 instanceof Boolean)
					cell.setCellValue((Boolean) obj1);
				else if (obj1 instanceof String)
					cell.setCellValue((String) obj1);
				else if (obj1 instanceof Double)
					cell.setCellValue((Double) obj1);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("plsewrk.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// close the browser
		driver.close();
		driver.quit();
	}
		
		
		
	}
	
	
