package update.platform.sports.com.updata;

import java.io.Serializable;
import java.util.List;

public class StarEnity implements Serializable {
    public String code;
    public String msg;
    public DataEnity data;
    public class DataEnity implements Serializable{
        public List<VersionEnity> version_info;
        public List<AdInfoEnity> Ad_info;
        public class VersionEnity implements Serializable {
            public  int id;
            public String device;
            public String url;
            public String oldversion;
            public String newversion;
            public String size;
            public String content;
            public String enforce;
            public  long createtime;
            public  long updatetime;
            public String status;
            public String ios_status;
            public String appstores;//0开，1关(马甲包是否关闭)

        }
        public class AdInfoEnity implements Serializable {
            public int id;
            public String image;
            public String status;
            public  long createtime;
            public  long updatetime;
        }
    }


}
