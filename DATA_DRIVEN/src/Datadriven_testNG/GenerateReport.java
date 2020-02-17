package Datadriven_testNG;

import org.automationtesting.excelreport.Xl;

import com.common.excelreport.ExcelReportGenerator;

public class GenerateReport {
 
    public static void main(String[] args) throws Exception
    {
    	ExcelReportGenerator.generateExcelReport("free.xlsx", "C:\\Selenium\\DATA_DRIVEN\\src\\Data");
     //Xl.generateReport("excel_report.xlsx");
     
    }
}