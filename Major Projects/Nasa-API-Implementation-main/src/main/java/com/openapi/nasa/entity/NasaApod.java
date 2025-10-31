package com.openapi.nasa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Entity
@Table(name = "apod")
@Builder
public class NasaApod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "copyright")
    @Size(min = 1, message = "is required")
    private String copyright;

    @Column(name = "date")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String date;

    @Column(columnDefinition = "TEXT")
    @Lob
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String explanation;

    @Column(name = "hdurl")
    @Size(min = 1, message = "is required")
    private String hdurl;

    @Column(name = "title")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String title;

    @Column(name = "url")
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String url;

    public NasaApod(){}

    public NasaApod(int id, String copyright, String date, String explanation, String hdurl, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getDate() {
        return date;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getId() {
        return id;
    }

    public void setCopyRight(String copyRight) {
        this.copyright = copyright;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NasaApod{" +
                "id=" + id +
                ", copyRight='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
