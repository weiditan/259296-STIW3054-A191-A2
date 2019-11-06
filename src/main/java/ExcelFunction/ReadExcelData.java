package ExcelFunction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;

class ReadExcelData{
    static void readData() {

        //Read excel data
        Data excelData = new Data();

        try {
            FileInputStream file = new FileInputStream(excelData.fileName);

            XSSFWorkbook wb = new XSSFWorkbook(file);

            //ReadSheets
            XSSFSheet sheet = wb.getSheet(excelData.sheetName);

            System.out.println("\n\nList Of Followers");

            printLine();

            String format = "| %-5s| %-30s| %-22s| %-22s| %-22s| %-22s|\n";

            System.out.format(format,
                    sheet.getRow(0).getCell(0),
                    sheet.getRow(0).getCell(1),
                    sheet.getRow(0).getCell(2),
                    sheet.getRow(0).getCell(3),
                    sheet.getRow(0).getCell(4),
                    sheet.getRow(0).getCell(5));

            printLine();


            for (int i=1; i <= sheet.getLastRowNum(); i++ ) {

                 Row row = sheet.getRow(i);

                 ArrayList<String> rowData = new ArrayList<>();

                for (int j=0; j < row.getLastCellNum(); j++ ) {

                   Cell cell = row.getCell(j);

                    if (cell!=null) {

                        // Alternatively, get the value and format it yourself
                        switch (cell.getCellType()) {
                            case STRING:
                                rowData.add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    rowData.add(cell.getDateCellValue().toString());
                                } else {
                                    rowData.add(String.valueOf((int) cell.getNumericCellValue()));
                                }
                                break;
                            case BOOLEAN:
                                rowData.add(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case FORMULA:
                                rowData.add(cell.getCellFormula());
                                break;
                            default:
                                System.out.println();
                        }
                    }else {
                        rowData.add("");
                    }
                }

               System.out.format(format,rowData.toArray());
            }

            printLine();

        } catch (Exception ignored) { }
    }

    private static void printLine() {

        System.out.format("+%-5s+%-30s+%-22s+%-22s+%-22s+%-22s+\n",
                "------",
                "-------------------------------",
                "-----------------------",
                "-----------------------",
                "-----------------------",
                "-----------------------");

    }


}
