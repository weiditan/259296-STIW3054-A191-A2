package ExcelFunction;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

class SaveToExcel{

    static void addData(String[] data){

        //Read excel data
        Data excelData = new Data();

        try {
            FileInputStream file = new FileInputStream(excelData.fileName);

            XSSFWorkbook wb = new XSSFWorkbook(file);

            //ReadSheets
            XSSFSheet sheet = wb.getSheet(excelData.sheetName);

            Row row = sheet.createRow(Integer.parseInt(data[0]));

            for(int i=0; i < data.length; i++){
                row.createCell(i).setCellValue(data[i]);
            }

            //Save the Excel file
            //Auto resize
            for(int i=0; i < data.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(excelData.fileName)) {
                wb.write(fileOut);
                // Close fileOut and workbook
                fileOut.close();
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

