package update.platform.sports.com.updata;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

public class StrUtils {
    public static String getFileName(String url){
        String str="";
        try {
            int index = url.lastIndexOf("/");
            String after = url.substring(index + 1);
            str=after;
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
    public static String getUrl(String url) throws MalformedURLException {
        String host="";
        try {
            java.net.URL  url1 = new  java.net.URL(url);
            host=url1.getHost();
        }catch (Exception e){
            e.printStackTrace();
        }


        return host;
    }
    public static String getDotString(Set set){
        String str="";
        if(set!=null && set.size()>0){
            StringBuffer buf = new StringBuffer();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                buf.append(it.next()).append(",");

            }
            str=buf.substring(0,buf.length()-1);
        }
        return str;
    }
}
