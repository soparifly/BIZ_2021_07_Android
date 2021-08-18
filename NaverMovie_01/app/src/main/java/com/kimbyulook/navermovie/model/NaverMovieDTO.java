package com.kimbyulook.navermovie.model;


public class NaverMovieDTO {

    private String link;       //	string	검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
    private String image;      //	string	검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
    private String subtitle;   //	string	검색 결과 영화의 영문 제목이다.
    private String pubDate;    //	date	검색 결과 영화의 제작년도이다.
    private String director;   //	string	검색 결과 영화의 감독이다.
    private String actor;      //	string	검색 결과 영화의 출연 배우이다.
    private String userRating; //	integer	검색 결과 영화에 대한 유저들의 평점이다.

    public NaverMovieDTO(String link, String image, String subtitle, String pubDate, String director, String actor, String userRating, String title) {
        this.link = link;
        this.image = image;
        this.subtitle = subtitle;
        this.pubDate = pubDate;
        this.director = director;
        this.actor = actor;
        this.userRating = userRating;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    private String title;      //	string	검색 결과 영화의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.

    @Override
    public String toString() {
        return "NaverMovieDTO{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", userRating='" + userRating + '\'' +
                '}';
    }


}
