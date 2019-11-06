package ExcelFunction;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;

class CreateExcel{

    static void createExcel(){

        //Read excel data
        Data excelData = new Data();

        XSSFWorkbook wb = new XSSFWorkbook();

        // Creating Sheets using sheet object
        wb.createSheet(excelData.sheetName);

        //ReadSheets
        XSSFSheet sheet = wb.getSheet(excelData.sheetName);

        Row row = sheet.createRow(0);


        for(int i=0; i < excelData.title.length; i++){
            row.createCell(i).setCellValue(excelData.title[i]);
        }

        CellStyle style = wb.createCellStyle();//Create style
        XSSFFont font = wb.createFont();//Create font
        font.setBold(true);//Make font bold
        style.setFont(font);//set it to bold

        for(int i = 0; i < excelData.title.length; i++){//For each cell in the row
            row.getCell(i).setCellStyle(style);//Set the style
        }

        //Save the Excel file
        //Auto resize
        for(int i=0; i < excelData.title.length; i++) {
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
    }
}
