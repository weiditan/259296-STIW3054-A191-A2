import IdentifyFollowers.identifyFollowers;
import ExcelFunction.excelFunction;

import java.util.ArrayList;

public class Main {

    private static int totalFollowers = 0, done = 0;

    public static void main(String[] args){

        // Create Excel
        System.out.println("Creating Excel file...");
        excelFunction.createExcel();
        System.out.println("Excel File has been created successfully !");

        System.out.println("\nChecking total followers...");

        // Get followers url for the link
        String[] userData = identifyFollowers.GetData("https://api.github.com/users/weiditan");
        ArrayList<String> arrayUrl = identifyFollowers.followersUrl(userData[5]);

        System.out.println("Total followers is "+arrayUrl.size()+".");

        System.out.println("\nDownloading followers data ...");

        totalFollowers = arrayUrl.size();

        int count = 1;
        for (String url : arrayUrl) {

            int finalCount = count;
            Thread thread = new Thread(() -> {

                    //Get url data
                    String[] urlData = identifyFollowers.GetData(url);

                    //Save to new array
                    String[] data = {String.valueOf(finalCount), urlData[0], urlData[1], urlData[2], urlData[3], urlData[4]};

                synchronized (Main.class) {
                    //Save to excel
                    excelFunction.addData(data);

                    done++;

                    System.out.format("%-10s %-15s %-20s\n",
                            done + "/" + totalFollowers,
                            Thread.currentThread().getName(),
                            "Download Completed !");
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
                excelFunction.readData();
                excelFunction.open();
                excelFunction.open();
                break;
            }
        }
    }
}
