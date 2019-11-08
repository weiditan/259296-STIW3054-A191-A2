package ExcelFunction;

import java.io.FileOutputStream;
import java.io.OutputStream;

class OutputExcel extends Data{

    static void output() {
        //Auto resize
        for (int i = 0; i < title.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // An output stream accepts output bytes and sends them to sink.
        try (OutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            // Close fileOut and workbook
            fileOut.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
