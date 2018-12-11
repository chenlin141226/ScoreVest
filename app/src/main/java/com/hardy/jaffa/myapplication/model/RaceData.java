package com.hardy.jaffa.myapplication.model;

import java.util.List;

public class RaceData {

    /**
     * code : 1
     * msg : 操作成功
     * data : {"list":[{"id":139,"datetime":1212,"rounds":6,"gametime":"01:55","status":"未开赛","hometeam":"沙尔克","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2530.png_20x20x1.jpg","score":"VS","awayteam":"莫斯科火车头足球俱乐部","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2320.png_20x20x1.jpg"},{"id":140,"datetime":1212,"rounds":6,"gametime":"01:55","status":"未开赛","hometeam":"加拉塔萨雷","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/3061.png_20x20x1.jpg","score":"VS","awayteam":"波尔图","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/3002.png_20x20x1.jpg"},{"id":141,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"利物浦","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/44.png_20x20x1.jpg","score":"VS","awayteam":"那不勒斯","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2714.png_20x20x1.jpg"},{"id":142,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"巴塞罗那","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2817.png_20x20x1.jpg","score":"VS","awayteam":"热刺","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/33.png_20x20x1.jpg"},{"id":143,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"布鲁日","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2888.png_20x20x1.jpg","score":"VS","awayteam":"马德里竞技","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2836.png_20x20x1.jpg"},{"id":144,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"贝尔格莱德红星","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/5149.png_20x20x1.jpg","score":"VS","awayteam":"巴黎圣日耳曼","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/1644.png_20x20x1.jpg"},{"id":145,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"国际米兰","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2697.png_20x20x1.jpg","score":"VS","awayteam":"埃因霍温","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2952.png_20x20x1.jpg"},{"id":146,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"摩纳哥","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/1653.png_20x20x1.jpg","score":"VS","awayteam":"多特蒙德","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2673.png_20x20x1.jpg"}],"count":8}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":139,"datetime":1212,"rounds":6,"gametime":"01:55","status":"未开赛","hometeam":"沙尔克","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2530.png_20x20x1.jpg","score":"VS","awayteam":"莫斯科火车头足球俱乐部","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2320.png_20x20x1.jpg"},{"id":140,"datetime":1212,"rounds":6,"gametime":"01:55","status":"未开赛","hometeam":"加拉塔萨雷","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/3061.png_20x20x1.jpg","score":"VS","awayteam":"波尔图","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/3002.png_20x20x1.jpg"},{"id":141,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"利物浦","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/44.png_20x20x1.jpg","score":"VS","awayteam":"那不勒斯","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2714.png_20x20x1.jpg"},{"id":142,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"巴塞罗那","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2817.png_20x20x1.jpg","score":"VS","awayteam":"热刺","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/33.png_20x20x1.jpg"},{"id":143,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"布鲁日","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2888.png_20x20x1.jpg","score":"VS","awayteam":"马德里竞技","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2836.png_20x20x1.jpg"},{"id":144,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"贝尔格莱德红星","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/5149.png_20x20x1.jpg","score":"VS","awayteam":"巴黎圣日耳曼","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/1644.png_20x20x1.jpg"},{"id":145,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"国际米兰","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2697.png_20x20x1.jpg","score":"VS","awayteam":"埃因霍温","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2952.png_20x20x1.jpg"},{"id":146,"datetime":1212,"rounds":6,"gametime":"04:00","status":"未开赛","hometeam":"摩纳哥","hometeamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/1653.png_20x20x1.jpg","score":"VS","awayteam":"多特蒙德","awayteamlogo":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2673.png_20x20x1.jpg"}]
         * count : 8
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 139
             * datetime : 1212
             * rounds : 6
             * gametime : 01:55
             * status : 未开赛
             * hometeam : 沙尔克
             * hometeamlogo : http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2530.png_20x20x1.jpg
             * score : VS
             * awayteam : 莫斯科火车头足球俱乐部
             * awayteamlogo : http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/sports/football/ifb/team/2320.png_20x20x1.jpg
             */

            private int id;
            private int datetime;
            private int rounds;
            private String gametime;
            private String status;
            private String hometeam;
            private String hometeamlogo;
            private String score;
            private String awayteam;
            private String awayteamlogo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDatetime() {
                return datetime;
            }

            public void setDatetime(int datetime) {
                this.datetime = datetime;
            }

            public int getRounds() {
                return rounds;
            }

            public void setRounds(int rounds) {
                this.rounds = rounds;
            }

            public String getGametime() {
                return gametime;
            }

            public void setGametime(String gametime) {
                this.gametime = gametime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getHometeam() {
                return hometeam;
            }

            public void setHometeam(String hometeam) {
                this.hometeam = hometeam;
            }

            public String getHometeamlogo() {
                return hometeamlogo;
            }

            public void setHometeamlogo(String hometeamlogo) {
                this.hometeamlogo = hometeamlogo;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getAwayteam() {
                return awayteam;
            }

            public void setAwayteam(String awayteam) {
                this.awayteam = awayteam;
            }

            public String getAwayteamlogo() {
                return awayteamlogo;
            }

            public void setAwayteamlogo(String awayteamlogo) {
                this.awayteamlogo = awayteamlogo;
            }
        }
    }
}
