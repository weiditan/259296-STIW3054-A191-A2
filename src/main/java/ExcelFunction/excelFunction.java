package ExcelFunction;

public class excelFunction {
    public static void createExcel(){
        CreateExcel.createExcel();
    }

    public static void addData(String[] data){
        SaveToExcel.addData(data);
    }

    public static void readData(){
        ReadExcelData.readData();
    }

    public static void open(){
        OpenExcel.open();
    }

}
