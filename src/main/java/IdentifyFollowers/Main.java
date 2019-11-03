package IdentifyFollowers;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        String[] userData = GetUserData.GetData("https://api.github.com/users/weiditan");
        for (String data : userData) {
            System.out.println(data);
        }

        int count = 1;
        ArrayList<String> arrayUrl = GetFollowersUrl.followersUrl(userData[5]);
        for (String url : arrayUrl) {

            Thread thread = new Thread(new ThreadToSave(url,count));
            thread.setName("t"+count);
            thread.start();

            count++;

        }

    }

}
