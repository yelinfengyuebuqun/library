package com.cjdx.library.entity;

public class Borrowing {
    private int borrowId;

    private int borrowUid;
    private String userName;
    private int borrowBid;
    private String bookName;

    private String borrowStart;
    private String borrowEnd;

    public Borrowing(int borrowId, int borrowUid, String userName, int borrowBid, String bookName, String borrowStart, String borrowEnd) {
        this.borrowId = borrowId;
        this.borrowUid = borrowUid;
        this.userName = userName;
        this.borrowBid = borrowBid;
        this.bookName = bookName;
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
    }

    public Borrowing() {
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getBorrowUid() {
        return borrowUid;
    }

    public void setBorrowUid(int borrowUid) {
        this.borrowUid = borrowUid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBorrowBid() {
        return borrowBid;
    }

    public void setBorrowBid(int borrowBid) {
        this.borrowBid = borrowBid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBorrowStart() {
        return borrowStart;
    }

    public void setBorrowStart(String borrowStart) {
        this.borrowStart = borrowStart;
    }

    public String getBorrowEnd() {
        return borrowEnd;
    }

    public void setBorrowEnd(String borrowEnd) {
        this.borrowEnd = borrowEnd;
    }

    public Borrowing(int borrowUid, int borrowBid, String borrowStart, String borrowEnd) {
        this.borrowUid = borrowUid;
        this.borrowBid = borrowBid;
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
    }
}
