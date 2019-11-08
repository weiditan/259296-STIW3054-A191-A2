package IdentifyFollowers;

import java.util.ArrayList;

public class identifyFollowers {

    public static ArrayList<String> followersUrl(String url){
        return GetFollowersUrl.followersUrl(url);
    }

    public static String[] GetData(String url){
        return GetUserData.GetData(url);
    }
}
