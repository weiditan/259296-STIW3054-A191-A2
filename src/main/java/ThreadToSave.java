import ExcelFunction.excelFunction;
import IdentifyFollowers.GetUserData;

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
            //Get url data
            String[] urlData = GetUserData.GetData(url);

            //Save to new array
            String[] data ={String.valueOf(count), urlData[0], urlData[1], urlData[2], urlData[3], urlData[4]};
            //Save to excel
            excelFunction.addData(data);

            Main.done++;
            System.out.println(Main.done+"/"+Main.totalFollowers);
        }
    }
}
