package com.acme.books.controller.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ReviewDTO {

    @NotEmpty(message="Please enter the review's title")
    private String title;

    @NotEmpty(message="Please enter the review")
    private String review;

    @DecimalMin(value="0.5", message = "Please give a rating of at least, 0.5")
    @DecimalMax(value="5.0", message = "Please give a rating of at most, 5")
    private BigDecimal rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
