package Datadriven_testNG;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Writing_Report {
	
	
	int setcell=0;
	int setrow=0;
	static ArrayList<String> data = new ArrayList<String>();
	static ArrayList<String> status=new ArrayList<String>();
	int i=0;
	
	public void create(String a, String b) throws IOException{
		System.out.println(a+""+b);
		System.out.println(">>>>>>>> "+i);
	//create and store in array list
	data.add(i,a);
	System.out.println("*********"+data.get(i)+"\t");
	i++;
	data.add(i,b);
	System.out.println("*********"+data.get(i)+"\t");

	i++;
	
	System.out.println("*********"+data.size()+"\t");
	
	
	
		
	}
	
	

	public void write() throws IOException
	{
		
		 for(int p=0;p<status.size();p++){
	    	System.out.println(">>Write()>>> "+status.get(p)+" <<<<<<");
	    }
		System.out.println("inside write");
		
		
			System.out.println("****+++++++++***** >>> "  +status.size());
			System.out.println("Excel <<<");		
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Sample.xlsx");

	Row row1 = sheet.createRow(0);
	Cell cell1 = row1.createCell(0);
	cell1.setCellValue("USERNAME");
	cell1 = row1.createCell(1);
	cell1.setCellValue("PASSWORD");
	cell1 = row1.createCell(2);
	cell1.setCellValue("STATUS");
			int rownum = 0;
	int z=0;
		for (int d = 1; d <4; d++) {

			Row row = sheet.createRow(d);

			int cellnum = 0;
			for (int n = cellnum; n < 2; n++) {
				Cell cell = row.createCell(n);
				cell.setCellValue(data.get(z));
				
				z++;
				
			}
			
			
			rownum++;
		}

	//finally write data to excel file
  FileOutputStream out = new FileOutputStream(new File("C:\\Selenium\\DATA_DRIVEN\\src\\Data\\jaihanuman.xlsx"));
		workbook.write(out);
	out.close();
	
}

}
