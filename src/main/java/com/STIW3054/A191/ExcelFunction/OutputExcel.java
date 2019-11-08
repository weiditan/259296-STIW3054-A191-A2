package com.STIW3054.A191.ExcelFunction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class OutputExcel extends Data{

    static void output() {
        //Auto resize
        for (int i = 0; i < title.length; i++) {
            sheet.autoSizeColumn(i);
        }

        while (true) {
            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
                // Close fileOut and workbook
                fileOut.close();
                workbook.close();
                break;

            } catch (Exception e) {
                System.out.println("Failed to create/save the Excel file !");
                System.out.println("Press Enter to retry...");
                try {
                    System.in.read();
                } catch (IOException ignored) { }

            }
        }
    }
}
