package Datadriven_testNG;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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

public class reading_writing_excel {
	 WebDriver driver;
	  public static XSSFWorkbook workbook;
	    public static XSSFSheet worksheet;
	    public static DataFormatter formatter= new DataFormatter();
	    public static String file_location = "C:\\Selenium\\DATA_DRIVEN\\src\\Data\\crosswrd.xlsx";
	    static String SheetName= "Sheet1";
	    static ArrayList<String> status=new ArrayList<String>();
	    int rownum = 0;
	    int cellnum = 0;
	    String title = null;
	@BeforeTest
	public void bfre(){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
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
    	
		driver.get("https://www.crossword.in/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.id("user_session_email")).sendKeys(USERNAME);
		driver.findElement(By.id("user_session_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("user_session_submit")).click();
		driver.findElement(By.id("user_session_email")).clear();
		driver.findElement(By.id("user_session_password")).clear();
		System.out.println("reading done");
		title=driver.getTitle();
		Assert.assertEquals(title, "Crossword");
//		Thread.sleep(5000);
	
		Writing_Report obj=new Writing_Report();
		obj.create(USERNAME, PASSWORD);
		if(title.equals("Crossword")){
			status.add("PASSED"); 
		 }
		 else{
			 status.add("FAILED");
		 }
		 for(int p=0;p<status.size();p++){
		    	System.out.println(">>>>> "+status.get(p)+" <<<<<<");
		    }
		 
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
		Writing_Report obj=new Writing_Report();
		obj.write();
		driver.quit();
		
		
	}
	
	/*@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
	System.out.println("AFTER METHOD");
	    try
	 {
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {
	    	status.add("PASS");

	        //Do something here
	        System.out.println(status.toString());
	    }

	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	         //Do something here
	    	status.add("FAIL");
	        System.out.println(status.toString());

	    }

	     else if(result.getStatus() == ITestResult.SKIP ){
	    	 status.add("SKIP");
	        System.out.println(status.toString());

	    }
	}
	   
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   } 
	    for(int p=0;p<status.size();p++){
	    	System.out.println("{{{{{{{{{{{{{{{{{"+status.get(p));
	    }
	    Writing_Report obj=new Writing_Report();
		obj.write();

	}*/
	}
	
	


		
	



