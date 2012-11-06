/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.Date;

/**
 *
 * @author meherzad
 */
public class Downloadreview {

    private int reviewId;
    private int projId;
    private int userId;
    private String review;
    private String username;
    private int rate;
    private Date time;
    private float rating;
    private int reviewd;
    private int downloads;
    private String projName;

    public int getDownloads() {
        return downloads;
    }

    public String getProjName() {
        return projName;
    }

    public float getRating() {
        return rating;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setReviewd(int reviewd) {
        this.reviewd = reviewd;
    }

    public int getReviewd() {
        return reviewd;
    }

    public int getProjId() {
        return projId;
    }

    public String getUsername() {
        return username;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getRate() {
        return rate;
    }

    public String getReview() {
        return review;
    }

    public Date getTime() {
        return time;
    }

    public int getUserId() {
        return userId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Downloadreview{" + "reviewId=" + reviewId + ", projId=" + projId + ", userId=" + userId + ", review=" + review + ", username=" + username + ", rate=" + rate + ", time=" + time + ", rating=" + rating + ", reviewd=" + reviewd + ", downloads=" + downloads + ", projName=" + projName + '}';
    }
}
