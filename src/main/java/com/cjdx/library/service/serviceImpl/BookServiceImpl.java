package com.cjdx.library.service.serviceImpl;

import com.cjdx.library.entity.Book;
import com.cjdx.library.entity.BookType;
import com.cjdx.library.entity.Borrowing;
import com.cjdx.library.entity.User;
import com.cjdx.library.mapper.BookMapper;
import com.cjdx.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookType> getBookType() {
        return bookMapper.getBookType();
    }

    @Override
    public List<BookType> getBookTypePage(int began) {
        return bookMapper.getBookTypePage(began);
    }

    @Override
    public BookType getBookTypeByName(String typeName) {
        return bookMapper.getBookTypeByName(typeName);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int getTypeCount() {
        return bookMapper.getTypeCount();
    }

    @Override
    public int deleteType(int typeId) {
        return bookMapper.deleteType(typeId);
    }

    @Override
    public int addBookType(String typeName) {
        return bookMapper.addBookType(typeName);
    }

    @Override
    public List<Book> getBook(int began) {
        return bookMapper.getBook(began);
    }

    @Override
    public List<Book> getBookByTypeId(int began, int typeId) {
        return bookMapper.getBookByTypeId(began,typeId);
    }

    @Override
    public int getBookCount() {
        return bookMapper.getBookCount();
    }

    @Override
    public int getBookCountByTypeId(int bookTypeid) {
        return bookMapper.getBookCountByTypeId(bookTypeid);
    }
    @Override
    public List<User> getUser(int began) {
        return bookMapper.getUser(began);
    }

    @Override
    public int getUserCount() {
        return bookMapper.getUserCount();
    }

    @Override
    public int deleteUserById(int userId) {
        return bookMapper.deleteUserById(userId);
    }

    @Override
    public int addUser(User user) {
        return bookMapper.addUser(user);
    }

    @Override
    public List<Borrowing> getBorrowingList(int began) {
        return bookMapper.getBorrowingList(began);
    }

    @Override
    public int getBorrowingCount() {
        return bookMapper.getBorrowingCount();
    }

    @Override
    public User getUserById(int userId) {
        return bookMapper.getUserById(userId);
    }

    @Override
    public Book getBookByID(int bookId) {
        return bookMapper.getBookByID(bookId);
    }

    @Override
    public List<Borrowing> getBorrowingListById(int began, int borrowUid) {
        return bookMapper.getBorrowingListById(began,borrowUid);
    }

    @Override
    public int getBorrowingCountById(int borrowUid) {
        return bookMapper.getBorrowingCountById(borrowUid);
    }

    @Override
    public int borrowBook(Borrowing borrowing) {
        return bookMapper.borrowBook(borrowing);
    }

    @Override
    public int updateBookTypeFalse(int bookId) {
        return bookMapper.updateBookTypeFalse(bookId);
    }

    @Override
    public int updateBookTypeTrue(int bookId) {
        return bookMapper.updateBookTypeTrue(bookId);
    }

    @Override
    public int returnBook(int borrowUid, int borrowBid, String borrowEnd) {
        return bookMapper.returnBook(borrowUid,borrowBid,borrowEnd);
    }

    @Override
    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

    @Override
    public List<Book> getAllBookByName(String bookName) {
        return bookMapper.getAllBookByName(bookName);
    }

    @Override
    public int updateUser(User user) {
        return bookMapper.updateUser(user);
    }
}
