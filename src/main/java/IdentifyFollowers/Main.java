package IdentifyFollowers;
import ExcelFunction.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        System.out.println("Creating Excel file...");
        ExcelFunction excelFunction = new ExcelFunction();
        excelFunction.createExcel();
        System.out.println("Excel File has been created successfully !");

        int count = 1;
        String[] userData = GetUserData.GetData("https://api.github.com/users/zhamri");
        ArrayList<String> arrayUrl = GetFollowersUrl.followersUrl(userData[5]);

        System.out.println(arrayUrl.size());

        for (String url : arrayUrl) {

            Thread thread = new Thread(new ThreadToSave(url,count));
            thread.setName("threat"+count);
            thread.start();

            count++;
        }

        //OpenExcel.open();


    }
}
