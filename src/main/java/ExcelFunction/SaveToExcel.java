package ExcelFunction;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

class SaveToExcel extends Data{

    static void addData(String[] data){

        try {
            FileInputStream file = new FileInputStream(fileName);

            workbook = new XSSFWorkbook(file);

            //ReadSheets
            sheet = workbook.getSheet(sheetName);

            Row row = sheet.createRow(Integer.parseInt(data[0]));

            for(int i=0; i < data.length; i++){
                row.createCell(i).setCellValue(data[i]);
            }

            //Save the Excel file
            OutputExcel.output();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

