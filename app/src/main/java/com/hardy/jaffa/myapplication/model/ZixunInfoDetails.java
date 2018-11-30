package com.hardy.jaffa.myapplication.model;

import java.util.List;

public class ZixunInfoDetails {


    private String newsId;
    private long publishDate;
    private String status;
    private Object createDate;
    private Object lastModifyDate;
    private String rate;
    private String headlineChi;
    private Object headlineEng;
    private Object contentChi;
    private Object contentEng;
    private String summaryChi;
    private Object summaryEng;
    private String newsType;
    private String newsSubType;
    private String matchId;
    private String dateDiffString;
    private String sportType;
    private String sportTypeId;
    private String teamId;
    private String playerId;
    private Object viewCount;
    private Object vodUrl;
    private Object webUrl;
    private boolean focus;
    private boolean deleted;
    private List<SportTypesBean> sportTypes;
    private List<NewsPhotosBean> newsPhotos;
    private List<?> newsVideos;
    private List<TeamsBean> teams;
    private List<PlayersBean> players;
    private List<?> keyword;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Object createDate) {
        this.createDate = createDate;
    }

    public Object getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Object lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getHeadlineChi() {
        return headlineChi;
    }

    public void setHeadlineChi(String headlineChi) {
        this.headlineChi = headlineChi;
    }

    public Object getHeadlineEng() {
        return headlineEng;
    }

    public void setHeadlineEng(Object headlineEng) {
        this.headlineEng = headlineEng;
    }

    public Object getContentChi() {
        return contentChi;
    }

    public void setContentChi(Object contentChi) {
        this.contentChi = contentChi;
    }

    public Object getContentEng() {
        return contentEng;
    }

    public void setContentEng(Object contentEng) {
        this.contentEng = contentEng;
    }

    public String getSummaryChi() {
        return summaryChi;
    }

    public void setSummaryChi(String summaryChi) {
        this.summaryChi = summaryChi;
    }

    public Object getSummaryEng() {
        return summaryEng;
    }

    public void setSummaryEng(Object summaryEng) {
        this.summaryEng = summaryEng;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsSubType() {
        return newsSubType;
    }

    public void setNewsSubType(String newsSubType) {
        this.newsSubType = newsSubType;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getDateDiffString() {
        return dateDiffString;
    }

    public void setDateDiffString(String dateDiffString) {
        this.dateDiffString = dateDiffString;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getSportTypeId() {
        return sportTypeId;
    }

    public void setSportTypeId(String sportTypeId) {
        this.sportTypeId = sportTypeId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Object getViewCount() {
        return viewCount;
    }

    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    public Object getVodUrl() {
        return vodUrl;
    }

    public void setVodUrl(Object vodUrl) {
        this.vodUrl = vodUrl;
    }

    public Object getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(Object webUrl) {
        this.webUrl = webUrl;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<SportTypesBean> getSportTypes() {
        return sportTypes;
    }

    public void setSportTypes(List<SportTypesBean> sportTypes) {
        this.sportTypes = sportTypes;
    }

    public List<NewsPhotosBean> getNewsPhotos() {
        return newsPhotos;
    }

    public void setNewsPhotos(List<NewsPhotosBean> newsPhotos) {
        this.newsPhotos = newsPhotos;
    }

    public List<?> getNewsVideos() {
        return newsVideos;
    }

    public void setNewsVideos(List<?> newsVideos) {
        this.newsVideos = newsVideos;
    }

    public List<TeamsBean> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsBean> teams) {
        this.teams = teams;
    }

    public List<PlayersBean> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersBean> players) {
        this.players = players;
    }

    public List<?> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<?> keyword) {
        this.keyword = keyword;
    }

    public static class SportTypesBean {
        /**
         * sportTypeId : 112
         * sportTypeNameChi : 足球
         * sportTypeNameEng : Soccer
         */

        private String sportTypeId;
        private String sportTypeNameChi;
        private String sportTypeNameEng;

        public String getSportTypeId() {
            return sportTypeId;
        }

        public void setSportTypeId(String sportTypeId) {
            this.sportTypeId = sportTypeId;
        }

        public String getSportTypeNameChi() {
            return sportTypeNameChi;
        }

        public void setSportTypeNameChi(String sportTypeNameChi) {
            this.sportTypeNameChi = sportTypeNameChi;
        }

        public String getSportTypeNameEng() {
            return sportTypeNameEng;
        }

        public void setSportTypeNameEng(String sportTypeNameEng) {
            this.sportTypeNameEng = sportTypeNameEng;
        }
    }

    public static class NewsPhotosBean {
        /**
         * newsId : 23754440078
         * photoId : null
         * providerId : null
         * providerName : null
         * offAirDate : null
         * photoDescChi : null
         * photoDescEng : null
         * imageFile : /sport/news/8/078/23754440078/23762019259_600x399.jpg
         * imageFileUrl : https://images-sports.now.com/sport/news/8/078/23754440078/23762019259_600x399.jpg
         * createDate : null
         * lastModifyDate : null
         * sizeType : 3
         * deleted : false
         */

        private String newsId;
        private Object photoId;
        private Object providerId;
        private Object providerName;
        private Object offAirDate;
        private Object photoDescChi;
        private Object photoDescEng;
        private String imageFile;
        private String imageFileUrl;
        private Object createDate;
        private Object lastModifyDate;
        private String sizeType;
        private boolean deleted;

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public Object getPhotoId() {
            return photoId;
        }

        public void setPhotoId(Object photoId) {
            this.photoId = photoId;
        }

        public Object getProviderId() {
            return providerId;
        }

        public void setProviderId(Object providerId) {
            this.providerId = providerId;
        }

        public Object getProviderName() {
            return providerName;
        }

        public void setProviderName(Object providerName) {
            this.providerName = providerName;
        }

        public Object getOffAirDate() {
            return offAirDate;
        }

        public void setOffAirDate(Object offAirDate) {
            this.offAirDate = offAirDate;
        }

        public Object getPhotoDescChi() {
            return photoDescChi;
        }

        public void setPhotoDescChi(Object photoDescChi) {
            this.photoDescChi = photoDescChi;
        }

        public Object getPhotoDescEng() {
            return photoDescEng;
        }

        public void setPhotoDescEng(Object photoDescEng) {
            this.photoDescEng = photoDescEng;
        }

        public String getImageFile() {
            return imageFile;
        }

        public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
        }

        public String getImageFileUrl() {
            return imageFileUrl;
        }

        public void setImageFileUrl(String imageFileUrl) {
            this.imageFileUrl = imageFileUrl;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public Object getLastModifyDate() {
            return lastModifyDate;
        }

        public void setLastModifyDate(Object lastModifyDate) {
            this.lastModifyDate = lastModifyDate;
        }

        public String getSizeType() {
            return sizeType;
        }

        public void setSizeType(String sizeType) {
            this.sizeType = sizeType;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }
    }

    public static class TeamsBean {
        /**
         * teamId : 3343
         * teamFullNameChi : 巴塞隆拿
         */

        private String teamId;
        private String teamFullNameChi;

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
        }

        public String getTeamFullNameChi() {
            return teamFullNameChi;
        }

        public void setTeamFullNameChi(String teamFullNameChi) {
            this.teamFullNameChi = teamFullNameChi;
        }
    }

    public static class PlayersBean {
        /**
         * playerId : 36185
         * playerFullNameChi : 美斯
         */

        private String playerId;
        private String playerFullNameChi;

        public String getPlayerId() {
            return playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        public String getPlayerFullNameChi() {
            return playerFullNameChi;
        }

        public void setPlayerFullNameChi(String playerFullNameChi) {
            this.playerFullNameChi = playerFullNameChi;
        }
    }
}
