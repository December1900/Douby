package net.december1900.douby.common.model;

import java.util.List;

/**
 * Created by december on 2017/9/4.
 */

public class Actor {




    public String mobile_url;
    public String name;
    public String gender;
    public AvatarsEntity avatars;
    public String id;
    public String name_en;
    public String born_place;
    public String alt;
    public List<String> aka_en;
    public List<WorksEntity> works;
    public List<?> aka;

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AvatarsEntity getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsEntity avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public List<WorksEntity> getWorks() {
        return works;
    }

    public void setWorks(List<WorksEntity> works) {
        this.works = works;
    }

    public List<?> getAka() {
        return aka;
    }

    public void setAka(List<?> aka) {
        this.aka = aka;
    }

    public static class AvatarsEntity {
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
         */

        public String small;
        public String large;
        public String medium;
    }

    public static class WorksEntity {
        /**
         * roles : ["演员"]
         * subject : {"rating":{"max":10,"average":9.6,"stars":"50","min":0},"genres":["犯罪","剧情"],"title":"肖申克的救赎","casts":[{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg"},"name":"鲍勃·冈顿","id":"1041179"}],"collect_count":1115348,"original_title":"The Shawshank Redemption","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"},"name":"弗兰克·德拉邦特","id":"1047973"}],"year":"1994","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg"},"alt":"https://movie.douban.com/subject/1292052/","id":"1292052"}
         */

        public SubjectEntity subject;
        public List<String> roles;



        public static class SubjectEntity {
            /**
             * rating : {"max":10,"average":9.6,"stars":"50","min":0}
             * genres : ["犯罪","剧情"]
             * title : 肖申克的救赎
             * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg"},"name":"鲍勃·冈顿","id":"1041179"}]
             * collect_count : 1115348
             * original_title : The Shawshank Redemption
             * subtype : movie
             * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"},"name":"弗兰克·德拉邦特","id":"1047973"}]
             * year : 1994
             * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg"}
             * alt : https://movie.douban.com/subject/1292052/
             * id : 1292052
             */

            public RatingEntity rating;
            public String title;
            public int collect_count;
            public String original_title;
            public String subtype;
            public String year;
            public ImagesEntity images;
            public String alt;
            public String id;
            public List<String> genres;
            public List<CastsEntity> casts;
            public List<DirectorsEntity> directors;

            public RatingEntity getRating() {
                return rating;
            }

            public void setRating(RatingEntity rating) {
                this.rating = rating;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCollect_count() {
                return collect_count;
            }

            public void setCollect_count(int collect_count) {
                this.collect_count = collect_count;
            }

            public String getOriginal_title() {
                return original_title;
            }

            public void setOriginal_title(String original_title) {
                this.original_title = original_title;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public ImagesEntity getImages() {
                return images;
            }

            public void setImages(ImagesEntity images) {
                this.images = images;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<String> getGenres() {
                return genres;
            }

            public void setGenres(List<String> genres) {
                this.genres = genres;
            }

            public List<CastsEntity> getCasts() {
                return casts;
            }

            public void setCasts(List<CastsEntity> casts) {
                this.casts = casts;
            }

            public List<DirectorsEntity> getDirectors() {
                return directors;
            }

            public void setDirectors(List<DirectorsEntity> directors) {
                this.directors = directors;
            }

            public static class RatingEntity {
                /**
                 * max : 10
                 * average : 9.6
                 * stars : 50
                 * min : 0
                 */

                public int max;
                public double average;
                public String stars;
                public int min;
            }

            public static class ImagesEntity {
                /**
                 * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg
                 * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg
                 * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg
                 */

                public String small;
                public String large;
                public String medium;
            }

            public static class CastsEntity {
                /**
                 * alt : https://movie.douban.com/celebrity/1054521/
                 * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"}
                 * name : 蒂姆·罗宾斯
                 * id : 1054521
                 */

                public String alt;
                public AvatarsEntityX avatars;
                public String name;
                public String id;

                public static class AvatarsEntityX {
                    /**
                     * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
                     * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
                     * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
                     */

                    public String small;
                    public String large;
                    public String medium;

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }

                    public String getLarge() {
                        return large;
                    }

                    public void setLarge(String large) {
                        this.large = large;
                    }

                    public String getMedium() {
                        return medium;
                    }

                    public void setMedium(String medium) {
                        this.medium = medium;
                    }
                }
            }

            public static class DirectorsEntity {
                /**
                 * alt : https://movie.douban.com/celebrity/1047973/
                 * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"}
                 * name : 弗兰克·德拉邦特
                 * id : 1047973
                 */

                public String alt;
                public AvatarsEntityXX avatars;
                public String name;
                public String id;

                public static class AvatarsEntityXX {
                    /**
                     * small : https://img3.doubanio.com/img/celebrity/small/230.jpg
                     * large : https://img3.doubanio.com/img/celebrity/large/230.jpg
                     * medium : https://img3.doubanio.com/img/celebrity/medium/230.jpg
                     */

                    public String small;
                    public String large;
                    public String medium;
                }
            }
        }
    }
}
