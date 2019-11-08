package com.STIW3054.A191.ExcelFunction;

import java.awt.*;
import java.io.File;

class OpenExcel extends Data{

    static void open(){

        File excelFile = new File(fileName);
        Desktop desktop = Desktop.getDesktop();

        // Ensure if file exist or not
        try{
            desktop.open(excelFile);
        } catch (Exception e) {
            System.out.println(fileName +" either not exist or can't open");
        }
    }
}
