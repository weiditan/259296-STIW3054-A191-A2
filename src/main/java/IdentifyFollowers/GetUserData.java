package IdentifyFollowers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetUserData extends Data{

    static String[] GetData(String url){

        String[] userData = new String[6];

        while (true) {
            try {
                final Document document = Jsoup.connect(url + token).ignoreContentType(true).get();

                //Get login id
                Pattern loginId = Pattern.compile("(\"login\": \")(.*)(\", \"id\":)");
                Matcher matchLoginId = loginId.matcher(document.text());
                if (matchLoginId.find()) {
                    userData[0] = matchLoginId.group(2);
                }

                //Get number of repositories
                Pattern repo = Pattern.compile("(\"public_repos\": )(\\d+)");
                Matcher matchRepo = repo.matcher(document.text());
                if (matchRepo.find()) {
                    userData[1] = matchRepo.group(2);
                }

                //Get number of followers
                Pattern followers = Pattern.compile("(\"followers\": )(\\d+)");
                Matcher matchFollowers = followers.matcher(document.text());
                if (matchFollowers.find()) {
                    userData[2] = matchFollowers.group(2);
                }

                //Get number of following
                Pattern following = Pattern.compile("(\"following\": )(\\d+)");
                Matcher matchFollowing = following.matcher(document.text());
                if (matchFollowing.find()) {
                    userData[3] = matchFollowing.group(2);
                }

                //Get date created
                Pattern createdAt = Pattern.compile("(\"created_at\": \")(.*)(\", \"updated_at\":)");
                Matcher matchCreatedAt = createdAt.matcher(document.text());
                if (matchCreatedAt.find()) {
                    userData[4] = matchCreatedAt.group(2).replaceAll("T", " ").replaceAll("Z", "");
                }

                //Get followers url
                Pattern followers_url = Pattern.compile("(\"followers_url\": \")(.*)(\", \"following_url\":)");
                Matcher matchFollowers_url = followers_url.matcher(document.text());
                if (matchFollowers_url.find()) {
                    userData[5] = matchFollowers_url.group(2);
                }

                break;

            } catch (Exception ignored) { }
        }

        return userData;
    }
}
