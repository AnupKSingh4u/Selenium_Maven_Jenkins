package test.automation.uiAutomation.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {

	  public void readExcel(String filePath,String fileName,String sheetName) throws IOException {
	
		    File file =    new File(filePath+"\\"+fileName);
		 
		    FileInputStream inps = new FileInputStream(file);
		    Workbook w = null;
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    //if(fileExtensionName.equals(".xlsx")){
		    if(fileName.contains(".xlsx")) {
		    	w = new XSSFWorkbook(inps);
		    }
		    //else if(fileExtensionName.equals(".xls")){
		    else if(fileName.contains(".xls")) {

		    	w  = new HSSFWorkbook(inps);
		    	}
		    Sheet s = w.getSheet(sheetName);
		    //--------------------------------------------------------------------------------------------
		    int rowCount = s.getLastRowNum()-s.getFirstRowNum();
		    for (int i = 0; i < rowCount; i++) {	
		        Row row = s.getRow(i);
		      System.out.println();
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        
		        }
		    }    
}
		    
		    public static void main(String[] Args) throws IOException{
		    ReadExcel objExcelFile = new  ReadExcel();
		    objExcelFile.readExcel("D:","Input.xls","Login");

		    }

		}

