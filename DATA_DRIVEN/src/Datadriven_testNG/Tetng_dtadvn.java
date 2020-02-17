package Datadriven_testNG;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class Tetng_dtadvn {
 
    public static WebDriver driver;
    String chrome_path;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = "C:\\Selenium\\DATA_DRIVEN\\src\\Data\\Book3.xlsx";
    static String SheetName= "Sheet1";
    public  String Res;
    public int DataSet=-1;
 
 
    @BeforeSuite
    public void OpenBrowser() throws InterruptedException
 
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("chrome launched successfully");
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

            
 
   
    @Test //Test method
    (dataProvider="ReadVariant") //It get values from ReadVariant function method

    //Here my all parameters from excel sheet are mentioned.
    public void AddVariants(String BOOKNAME) throws Exception
    {
    	System.out.println("inside test");
    	 driver.get("http://www.crossword.in/");
  
    System.out.println("NAme of product available are:" +BOOKNAME);
    WebDriverWait wait =  new WebDriverWait(driver, 90);
     
    // User get Login
   
    driver.findElement(By.id("search-input")).sendKeys(BOOKNAME);
    System.out.println(driver.getTitle());
    driver.findElement(By.xpath("//*[@id='search']/span[3]/input")).click();
	System.out.println("Clicked");
	driver.findElement(By.id("search-input")).clear();
     
    Thread.sleep(4000);
     
    }
}