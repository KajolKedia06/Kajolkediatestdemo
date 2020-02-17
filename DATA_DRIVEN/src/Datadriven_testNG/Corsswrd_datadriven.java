package Datadriven_testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Corsswrd_datadriven {
	 WebDriver driver;
	  public static XSSFWorkbook workbook;
	    public static XSSFSheet worksheet;
	    public static DataFormatter formatter= new DataFormatter();
	    public static String file_location = "D:\\DATA_DRIVEN\\DATA_DRIVEN\\src\\Data\\crosswrd.xlsx";
	    static String SheetName= "Sheet1";
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
		//int c=driver.findElements(By.tagName("a")).size();
	
		
		driver.manage().window().fullscreen();
		driver.findElement(By.id("user_session_email")).sendKeys(USERNAME);
		driver.findElement(By.id("user_session_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("user_session_submit")).click();
		driver.findElement(By.id("user_session_email")).clear();
		driver.findElement(By.id("user_session_password")).clear();
		Thread.sleep(5000);
	}
	@AfterTest
	public void aftr(){
		driver.quit();
	}
	
}
