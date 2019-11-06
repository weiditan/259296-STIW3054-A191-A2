package IdentifyFollowers;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;

public class ExcelFunction{

    FileInputStream file;
    XSSFWorkbook wb;
    XSSFSheet sheetFollowersData;

    // Set Excel File Name
    String fileName = "FollowersData.xlsx";



    public void createExcel(){

        wb = new XSSFWorkbook();

        // Creating Sheets using sheet object
        wb.createSheet("FollowersData");
        sheetFollowersData = wb.getSheet("FollowersData");
        Row row = sheetFollowersData.createRow(0);
        row.createCell(0).setCellValue("No");
        row.createCell(1).setCellValue("Login ID");
        row.createCell(2).setCellValue("Number Of Repositories");
        row.createCell(3).setCellValue("Number Of Followers");
        row.createCell(4).setCellValue("Number Of Following");
        row.createCell(5).setCellValue("Date Created");

        CellStyle style = wb.createCellStyle();//Create style
        XSSFFont font = wb.createFont();//Create font
        font.setBold(true);//Make font bold
        style.setFont(font);//set it to bold

        for(int i = 0; i < row.getLastCellNum(); i++){//For each cell in the row
            row.getCell(i).setCellStyle(style);//Set the style
        }

        //Save the Excel file
        saveExcel();
    }

    public void readExcel() {
        try {
            file = new FileInputStream(fileName);
            wb = new XSSFWorkbook(file);
            sheetFollowersData = wb.getSheet("FollowersData");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveExcel(){

        for(int i=0; i<=5; i++) {
            sheetFollowersData.autoSizeColumn(i);
        }

        // An output stream accepts output bytes and sends them to sink.
        try (OutputStream fileOut = new FileOutputStream(fileName)) {
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addData(int count, String[] urlData){
        readExcel();

        Row row = sheetFollowersData.createRow(count);

        row.createCell(0).setCellValue(count);


        for(int i=0;i<=4;i++){
            row.createCell(i+1).setCellValue(urlData[i]);
        }

        saveExcel();
    }

    public void open(){
        File excelFile = new File(fileName);
        Desktop desktop = Desktop.getDesktop();

        // Ensure if file exist or not
        try{
            desktop.open(excelFile);
        } catch (Exception e) {
            System.out.println(file+" either not exist or can't open");
        }
    }
}
