package ExcelFunction;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Data {

    // Excel workbook and sheet
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    // Excel File Name
    static String fileName = "FollowersData.xlsx";

    // Excel SheetName
    static String sheetName = "FollowersData";

    // Excel Header
    static String[] title = {"No", "Login ID", "Number Of Repositories", "Number Of Followers", "Number Of Following", "Date Created"};

}
