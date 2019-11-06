import IdentifyFollowers.*;
import ExcelFunction.excelFunction;

import java.util.ArrayList;

public class Main {

    static int totalFollowers = 0, done = 0;

    public static void main(String[] args){


        // Create Excel
        System.out.println("Creating Excel file...");
        excelFunction.createExcel();
        System.out.println("Excel File has been created successfully !");

        System.out.println("\nChecking total followers...");

        // Get followers url for the link
        String[] userData = GetUserData.GetData("https://api.github.com/users/zhamri");
        ArrayList<String> arrayUrl = GetFollowersUrl.followersUrl(userData[5]);

        System.out.println("Total followers is "+arrayUrl.size()+" !");

        System.out.println("Downloading followers data ...");

        totalFollowers = arrayUrl.size();

        int count = 1;
        for (String url : arrayUrl) {

            //Thread thread = new Thread(new ThreadToSave(url,count));

            int finalCount = count;
            Thread thread = new Thread(() -> {
                synchronized (Main.class) {
                    //Get url data
                    String[] urlData = GetUserData.GetData(url);

                    //Save to new array
                    String[] data = {String.valueOf(finalCount), urlData[0], urlData[1], urlData[2], urlData[3], urlData[4]};
                    //Save to excel
                    excelFunction.addData(data);

                    done++;
                    System.out.println(done + "/" + totalFollowers+" "+Thread.currentThread().getName()+" Download Completed !");
                }
            });

            thread.setName("threat-"+count);
            thread.start();

            count++;
        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(done==totalFollowers){

                excelFunction.open();
                excelFunction.open();
                break;
            }

        }



    }
}
