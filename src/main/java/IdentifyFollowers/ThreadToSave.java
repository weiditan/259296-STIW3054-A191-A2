package IdentifyFollowers;

public class ThreadToSave implements Runnable{

    private String url;
    private int count;

    ThreadToSave(String get_url, int get_count){
        url = get_url;
        count = get_count;
    }

    @Override
    public void run() {
        String[] urlData = GetUserData.GetData(url);
        System.out.println(Thread.currentThread().getName()+" "+count);
        System.out.println(Thread.currentThread().getName()+" login id : "+urlData[0]);
        System.out.println(Thread.currentThread().getName()+" number of repositories : "+urlData[1]);
        System.out.println(Thread.currentThread().getName()+" number of followers : "+urlData[2]);
        System.out.println(Thread.currentThread().getName()+" number of following : "+urlData[3]);
        System.out.println(Thread.currentThread().getName()+" date created : "+urlData[4]);
    }
}
