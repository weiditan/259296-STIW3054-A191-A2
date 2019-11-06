package ExcelFunction;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SaveToExcel {

    public static void addData(int count, String[] urlData){

        //Read excel data
        ExcelData excelData = new ExcelData();

        try {
            FileInputStream file = new FileInputStream(excelData.fileName);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet("FollowersData");


            Row row = sheet.createRow(count);

            row.createCell(0).setCellValue(count);


            for (int i = 0; i <= 4; i++) {
                row.createCell(i + 1).setCellValue(urlData[i]);
            }

            for (int i = 0; i <= 5; i++) {
                sheet.autoSizeColumn(i);
            }

            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(excelData.fileName)) {
                wb.write(fileOut);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
