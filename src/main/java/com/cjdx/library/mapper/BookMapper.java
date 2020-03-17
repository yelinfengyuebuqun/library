package com.cjdx.library.mapper;

import com.cjdx.library.entity.Book;
import com.cjdx.library.entity.BookType;
import com.cjdx.library.entity.Borrowing;
import com.cjdx.library.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    //获取书的种类
    @Select("SELECT*FROM bookType")
    public List<BookType> getBookType();

    //根据种类名获取书的信息
    @Select("SELECT*FROM bookType where typeName=#{typeName}")
    public BookType getBookTypeByName(String typeName);

    //增加书籍
    @Insert("INSERT INTO book(bookName,bookAuthor,bookPublish,bookState,bookTypeid) VALUES (#{bookName},#{bookAuthor},#{bookPublish},#{bookState},#{bookTypeid})")
    public int addBook(Book book);
    //查询类别的总行数
    @Select("SELECT COUNT(*) FROM bookType")
    public int getTypeCount();

    //获取书的种类(分页)
    @Select("SELECT*FROM bookType LIMIT #{began},5")
    public List<BookType> getBookTypePage(int began);

    //根据ID删除类别
    @Delete("DELETE FROM bookType WHERE typeId=#{typeId}")
    public int deleteType(int typeId);

    //增加类别
    @Insert("INSERT INTO bookType(typeName) VALUES(#{typeName})")
    public int addBookType(String typeName);

    //获取书籍列表（分页）
    @Select("SELECT*FROM book LIMIT #{began},5")
    public List<Book> getBook(int began);

    //获取指定类别书籍列表（分页）
    @Select("SELECT*FROM book where bookTypeid=#{param2} LIMIT #{param1},5")
    public List<Book> getBookByTypeId(int began,int typeId);

    //查询书籍的总行数
    @Select("SELECT COUNT(*) FROM book")
    public int getBookCount();

    //查询指定类型书籍的总行数
    @Select("SELECT COUNT(*) FROM book where bookTypeid=#{bookTypeid}")
    public int getBookCountByTypeId(int bookTypeid);

    //获取用户列表
    @Select("SELECT * FROM `user` LIMIT #{began},5")
    public List<User> getUser(int began);

    //获取用户表的行数
    @Select("SELECT COUNT(*) FROM `user`")
    public int getUserCount();

    //根据ID删除用户
    @Delete("DELETE FROM `user` WHERE userId=#{userId}")
    public int deleteUserById(int userId);

    //添加用户
    @Insert("INSERT INTO `user`(userName,userPwd,userEmail) VALUES (#{userName},#{userPwd},#{userEmail})")
    public int addUser(User user);

    //获取借阅列表(分页)
    @Select("SELECT*FROM borrowing LIMIT #{began},5")
    public List<Borrowing> getBorrowingList(int began);

    //获取借阅表的总行数
    @Select("SELECT COUNT(*) FROM borrowing")
    public int getBorrowingCount();

    //根据ID获取用户
    @Select("SELECT * FROM `user` where userId=#{userId}")
    public User getUserById(int userId);

    //根据ID获取书籍
    @Select("SELECT*FROM book where bookId=#{bookId}")
    public Book getBookByID(int bookId);

    //根据ID获取借阅列表(分页)
    @Select("SELECT*FROM borrowing where borrowUid=#{param2} LIMIT #{param1},5")
    public List<Borrowing> getBorrowingListById(int began,int borrowUid);

    //根据ID获取借阅表的总行数
    @Select("SELECT COUNT(*) FROM borrowing where borrowUid=#{borrowUid}")
    public int getBorrowingCountById(int borrowUid);

    //借阅书籍
    @Insert("INSERT INTO borrowing(borrowUid,borrowBid,borrowStart,borrowEnd) VALUES (#{borrowUid},#{borrowBid},#{borrowStart},#{borrowEnd})")
    public int borrowBook(Borrowing borrowing);

    //修改书籍借阅状态(不可借)
    @Update("UPDATE book SET bookState='不可借' WHERE bookId=#{bookId}")
    public int updateBookTypeFalse(int bookId);

    //修改书籍借阅状态(可借)
    @Update("UPDATE book SET bookState='可借' WHERE bookId=#{bookId}")
    public int updateBookTypeTrue(int bookId);

    //根据UserID归还书籍
    @Update("UPDATE borrowing SET borrowEnd=#{param3} WHERE borrowUid=#{param1} and borrowBid=#{param2} and borrowEnd='未还'")
    public int returnBook(int borrowUid,int borrowBid,String borrowEnd);

    //获取书籍列表（不分页）
    @Select("SELECT*FROM book")
    public List<Book> getAllBook();
    //根据书名获取书籍列表（不分页）
    @Select("SELECT*FROM book where bookName=#{bookName}")
    public List<Book> getAllBookByName(String bookName);
    //修改用户信息
    @Update("UPDATE `user` SET userName=#{userName},userPwd=#{userPwd},userEmail=#{userEmail} where userId=#{userId}")
    public int updateUser(User user);
}
