package com.cjdx.library.entity;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublish;
    private String bookState;

    private int bookTypeid;
    private String bookTypeName;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookAuthor, String bookPublish, String bookState, int bookTypeid, String bookTypeName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookState = bookState;
        this.bookTypeid = bookTypeid;
        this.bookTypeName = bookTypeName;
    }

    public Book(String bookName, String bookAuthor, String bookPublish, String bookState, int bookTypeid) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookState = bookState;
        this.bookTypeid = bookTypeid;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState;
    }

    public int getBookTypeid() {
        return bookTypeid;
    }

    public void setBookTypeid(int bookTypeid) {
        this.bookTypeid = bookTypeid;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }
}
