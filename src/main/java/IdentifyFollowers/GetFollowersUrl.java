package IdentifyFollowers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFollowersUrl {
    public static ArrayList<String> followersUrl(String url){

        ArrayList<String> arrayUrl = new ArrayList<>();

        int page = 1;

        while (true){
            try {
                final Document document = Jsoup.connect(url + "?page="+page).ignoreContentType(true).get();

                //Check next page
                if(document.text().equals("[ ]")){
                   break;
                }

                //Get split followers
                String[] arrOfStr = document.text().split(" }");
                for (String arrData : arrOfStr) {
                    //Get url
                    Pattern ApiUrl = Pattern.compile("(\"url\": \")(.*)(\", \"html_url\":)");
                    Matcher matchApiUrl = ApiUrl.matcher(arrData);
                    if (matchApiUrl.find()) {
                        arrayUrl.add(matchApiUrl.group(2));
                    }
                }

                page++;

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return arrayUrl;
    }
}
