package com.cjdx.library.service;

import com.cjdx.library.entity.Book;
import com.cjdx.library.entity.BookType;
import com.cjdx.library.entity.Borrowing;
import com.cjdx.library.entity.User;

import java.util.List;

public interface BookService {
    //获取书的种类
    public List<BookType> getBookType();
    //获取书的种类(分页)
    public List<BookType> getBookTypePage(int began);

    //根据种类名获取书的信息
    public BookType getBookTypeByName(String typeName);

    //增加书籍
    public int addBook(Book book);

    //查询类别的总行数
    public int getTypeCount();

    //根据ID删除类别
    public int deleteType(int typeId);

    //增加类别
    public int addBookType(String typeName);

    //获取书籍列表（分页）
    public List<Book> getBook(int began);

    //获取指定类别书籍列表（分页）
    public List<Book> getBookByTypeId(int began,int typeId);

    //查询书籍的总行数
    public int getBookCount();

    //查询指定类型书籍的总行数
    public int getBookCountByTypeId(int bookTypeid);

    //获取用户列表(分页)
    public List<User> getUser(int began);
    //获取用户表的行数
    public int getUserCount();

    //根据ID删除用户
    public int deleteUserById(int userId);

    //添加用户
    public int addUser(User user);

    //获取借阅列表(分页)
    public List<Borrowing> getBorrowingList(int began);

    //获取借阅表的总行数
    public int getBorrowingCount();

    //根据ID获取用户
    public User getUserById(int userId);

    //根据ID获取书籍
    public Book getBookByID(int bookId);

    //根据ID获取借阅列表(分页)
    public List<Borrowing> getBorrowingListById(int began,int borrowUid);

    //根据ID获取借阅表的总行数
    public int getBorrowingCountById(int borrowUid);

    //借阅书籍
    public int borrowBook(Borrowing borrowing);

    //修改书籍借阅状态(不可借)
    public int updateBookTypeFalse(int bookId);

    //修改书籍借阅状态(可借)
    public int updateBookTypeTrue(int bookId);

    //根据UserID归还书籍
    public int returnBook(int borrowUid,int borrowBid,String borrowEnd);

    //获取书籍列表（不分页）
    public List<Book> getAllBook();

    //根据书名获取书籍列表（不分页）
    public List<Book> getAllBookByName(String bookName);

    //修改用户信息
    public int updateUser(User user);
}
