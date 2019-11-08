package ExcelFunction;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcel extends Data{

    static void createExcel(){

        workbook = new XSSFWorkbook();

        // Creating Sheets using sheet object
        workbook.createSheet(sheetName);

        //ReadSheets
        sheet = workbook.getSheet(sheetName);

        Row row = sheet.createRow(0);


        for(int i=0; i < title.length; i++){
            row.createCell(i).setCellValue(title[i]);
        }

        CellStyle style = workbook.createCellStyle();//Create style
        XSSFFont font = workbook.createFont();//Create font
        font.setBold(true);//Make font bold
        style.setFont(font);//set it to bold

        for(int i = 0; i < title.length; i++){//For each cell in the row
            row.getCell(i).setCellStyle(style);//Set the style
        }

        //Save the Excel file
        OutputExcel.output();

    }
}
