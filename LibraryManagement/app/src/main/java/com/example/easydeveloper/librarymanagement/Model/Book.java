package com.example.easydeveloper.librarymanagement.Model;

/**
 * Created by BITM Trainer - 401 on 7/18/2016.
 */
public class Book {
    private int id,userId;
    private String bookName;
    private String writerName;
    private String publishDate;
    private String description;

    public Book(int id, int userId, String bookName, String writerName, String publishDate, String description) {
        this.id = id;
        this.userId = userId;
        this.bookName = bookName;
        this.writerName = writerName;
        this.publishDate = publishDate;
        this.description = description;
    }

    public Book(int userId, String bookName, String writerName, String publishDate, String description) {
        this.userId = userId;
        this.bookName = bookName;
        this.writerName = writerName;
        this.publishDate = publishDate;
        this.description = description;
    }

    public Book() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return bookName;
    }
}
