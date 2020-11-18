package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {
    private int postId;
    private String title;
    private String body;
    private int clubId;
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date postDate;

    public News() {
    }

    public News(int postId, String title, String body, int clubId, Date postDate) {
        this.postId = postId;
        this.title = title;
        this.body = body;
        this.clubId = clubId;
        this.postDate = postDate;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
