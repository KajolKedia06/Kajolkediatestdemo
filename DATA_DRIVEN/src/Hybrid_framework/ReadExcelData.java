package Hybrid_framework;
 
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
public class ReadExcelData
{
 public static XSSFSheet sheet;
 public static XSSFWorkbook workbook;
 public static XSSFCell cell; 

 //This method is to set the File path and to open the Excel file
 //Pass Excel Path and SheetName as Arguments to this method
 public static void setExcelFile(String path,String SheetName) throws Exception 
 {
	 //System.out.println("*****Path**********"+path);
	// System.out.println("******SheetName*********"+SheetName);
	 System.out.println("setExcelFile called");
	 FileInputStream file = new FileInputStream(new File(path));
	 workbook = new XSSFWorkbook(file); 
	 sheet = workbook.getSheet(SheetName); 
	 System.out.println("*****Workbook**********"+workbook);
	 System.out.println("+++++++sheet+++++++"+sheet);
 }
  
 //This method is to read the test data from the Excel cell
 //In this we are passing parameters/arguments as Row Num and Col Num
 public static String getCellData(int RowNum, int ColNum) throws Exception
 {

	 System.out.println("*****Workbook**********"+workbook);
	 System.out.println("+++++++sheet+++++++"+sheet);
	 System.out.println("getCellData called"+RowNum+" "+ColNum);
	 cell=sheet.getRow(RowNum).getCell(ColNum);
	System.out.println("cell data ..........."+ cell.toString());
	// System.out.println("*********"+CellD);
//	Row row = sheet.getRow(RowNum);
//	 Cell cell = row.getCell(ColNum);
 //Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
 String CellData = cell.getStringCellValue();
 System.out.println("getCellData value is"+CellData);
 return CellData;
 }

}