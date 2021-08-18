package com.kimbyulook.navermovie.model;

import java.util.List;

public class NaverParentDTO {

    public String rss;      //	-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
    public String channel;  //	-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
    public String lastBuildDate;//	datetime	검색 결과를 생성한 시간이다.
    //item/
    public List<com.kimbyulook.navermovie.model.NaverMovieDTO> items;//	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, image, subtitle, pubDate, director, actor, userRating을 포함한다.

    public String query;    //	string (필수)	Y	-	검색을 원하는 질의. UTF-8 인코딩이다.
    public String display;  //	integer	N	기본값 10, 최대 100	검색 결과 출력 건수를 지정한다. 최대 100까지 가능하다.
    public String start;    //	integer	N	기본값 1, 최대 1000	검색의 시작 위치를 지정할 수 있다. 최대 1000까지 가능하다.
    public String genre;    //	string	N	-	검색을 원하는 장르 코드를 의미한다. 영화 코드는 다음과 같다.
                                        //                1: 드라마 2: 판타지
                                        //                3: 서부 4: 공포
                                        //                5: 로맨스 6: 모험
                                        //                7: 스릴러 8: 느와르
                                        //                9: 컬트 10: 다큐멘터리
                                        //                11: 코미디 12: 가족
                                        //                13: 미스터리 14: 전쟁
                                        //                15: 애니메이션 16: 범죄
                                        //                17: 뮤지컬 18: SF
                                        //                19: 액션20: 무협
                                        //                21: 에로 22: 서스펜스
                                        //                23: 서사 24: 블랙코미디
                                        //                25: 실험 26: 영화카툰
                                        //                27: 영화음악 28: 영화패러디포스터

    public String country;  //	string	N	-	검색을 원하는 국가 코드를 의미한다. 국가코드는 대문자만 사용 가능하며,분류는 다음과 같다.
//                                   한국 (KR), 일본 (JP), 미국 (US), 홍콩 (HK),
//                                     영국 (GB), 프랑스 (FR), 기타 (ETC)


    public String yearfrom; //	integer(ex : 2000)	N	-	검색을 원하는 영화의 제작년도(최소)를 의미한다.
                            //   yearfrom은 yearto와 함께 사용되어야 한다.
    public String yearto;   //	integer(ex : 2008)	N	-	검색을 원하는 영화의 제작년도(최대)를 의미한다

    @Override
    public String toString() {
        return "NaverParentDTO{" +
                "rss='" + rss + '\'' +
                ", channel='" + channel + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", items=" + items +
                ", query='" + query + '\'' +
                ", display='" + display + '\'' +
                ", start='" + start + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", yearfrom='" + yearfrom + '\'' +
                ", yearto='" + yearto + '\'' +
                '}';
    }
}


