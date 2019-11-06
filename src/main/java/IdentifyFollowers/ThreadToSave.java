package IdentifyFollowers;
import ExcelFunction.SaveToExcel;

public class ThreadToSave implements Runnable{

    private String url;
    private int count;

    ThreadToSave(String get_url, int get_count){
        url = get_url;
        count = get_count;
    }

    @Override
    public void run() {

        synchronized (ThreadToSave.class) {
            String[] urlData = GetUserData.GetData(url);

            System.out.println(Thread.currentThread().getName() + " " + count);

            SaveToExcel.addData(count, urlData);

            System.out.println(Thread.currentThread().getName() + " login id : " + urlData[0]);
        }
    }
}
