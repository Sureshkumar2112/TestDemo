package com.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelRead {
	private static XSSFWorkbook w;
	private static XSSFSheet s;
	private static XSSFRow rr;
	private static XSSFCell c;

	public static String Fullname =null;
	public static String Mobilenumber=null;
	public static String Pincode=null;
	public static String Streetaddress1=null;
	public static String Streetaddress2=null;
	public static String Landmark=null;

	public static void readExcel(String Sheetname) throws IOException{
	File file = new File("C:\\Users\\pc\\eclipse-workspace\\demoAmazon\\demoAmazon\\readexcel.xlsx");
	FileInputStream f = new FileInputStream(file);
	 w = new XSSFWorkbook(f);
	 s = w.getSheet(Sheetname);
	int rowcount  = s.getLastRowNum();
	System.out.println(rowcount);
	System.out.println("Rowcount "+ rowcount);
	for(int i=1; i<=rowcount; i++){
	 rr = s.getRow(i);
	 
	 for(int j=0; j<1; j++)
	 {
	  
		 Fullname = rr.getCell(j).getStringCellValue();
		 System.out.println("name" + Fullname);
		 Mobilenumber = rr.getCell(j+1).getStringCellValue();
		 Pincode = rr.getCell(j+2).getStringCellValue();
		 Streetaddress1 = rr.getCell(j+3).getStringCellValue();
		 Streetaddress2 = rr.getCell(j+4).getStringCellValue();
		 Landmark = rr.getCell(j+5).getStringCellValue();
	   
	 }
	}
}
}
