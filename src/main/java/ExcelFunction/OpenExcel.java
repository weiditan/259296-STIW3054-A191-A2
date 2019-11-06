package ExcelFunction;

import java.awt.*;
import java.io.File;

class OpenExcel {

    static void open(){

        //Read excel data
        ExcelData excelData = new ExcelData();

        File excelFile = new File(excelData.fileName);
        Desktop desktop = Desktop.getDesktop();

        // Ensure if file exist or not
        try{
            desktop.open(excelFile);
        } catch (Exception e) {
            System.out.println(excelData.fileName+" either not exist or can't open");
        }
    }
}
