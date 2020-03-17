package com.cjdx.library.controller;

import com.cjdx.library.entity.Book;
import com.cjdx.library.entity.BookType;
import com.cjdx.library.entity.Borrowing;
import com.cjdx.library.entity.User;
import com.cjdx.library.service.BookService;
import com.cjdx.library.service.UserAdminService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserAdminService userAdminService;



    //------------------------------------------管理员部分--------------------------------------------------------------
   //录入新书
    @RequestMapping("/addBookPage")
    public String addBookPage(Model model){
        return "admin/addBook";
    }

    //将书添加进库
    @RequestMapping("/addABook")
    public String addABook(String bookName,String bookAuthor,String bookPublish,String bookCategory){
        int typeId=bookService.getBookTypeByName(bookCategory).getTypeId();
        Book book=new Book(bookName,bookAuthor,bookPublish,"可借",typeId);
        return "admin/addBook";
    }
    @RequestMapping("/addBBook")
    public String addBBook(String bookName,String bookAuthor,String bookPublish,String bookCategory){
        int typeId=bookService.getBookTypeByName(bookCategory).getTypeId();
        Book book=new Book(bookName,bookAuthor,bookPublish,"可借",typeId);
        bookService.addBook(book);
        return "admin/addBook";
    }
    //异步查询书的中类
    @RequestMapping("/findAllBookCategory")
    @ResponseBody
    public String[] findAllBookCategory(){
        String[] data=new String[100];
        List<BookType> list= bookService.getBookType();
        for (int i=0;i<list.size();i++){
            data[i]=list.get(i).getTypeName();
        }
        return data;
    }

    //新建类别
    @RequestMapping("/addCategoryPage")
    public String addCategoryPage(Model model,int pageNum){
        List<BookType> bookTypeList=bookService.getBookTypePage((pageNum-1)*5);
        model.addAttribute("list",bookTypeList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getTypeCount()%5)==0){
            model.addAttribute("getPageCount",(bookService.getTypeCount()/5));
        }else{
            model.addAttribute("getPageCount",(bookService.getTypeCount()/5)+1);
        }

        return "admin/addCategory";
    }

    //删除类别（异步）.
    @RequestMapping("/deleteCategory")
    @ResponseBody
    public String deleteCategory(int bookCategoryId){
          if(bookService.deleteType(bookCategoryId)>0){
              return "true";
          }else{
              return "false";
          }
    }

    /*//增加类别（异步）
    @RequestMapping("/addBookACategory")
    @ResponseBody
    public String addBookCategory(String categoryName){
        System.out.println(categoryName+"categoryName");
        return "true";
    }*/

    @RequestMapping("/addBookBCategory")
    @ResponseBody
    public String addBookBCategory(String categoryName){
        if (bookService.addBookType(categoryName)>0){
            System.out.println(categoryName+"categoryName true");
            return "true";
        }else{
            System.out.println(categoryName+"categoryName false");
            return "false";
        }
    }

    //查询书籍
    @RequestMapping("/showBooksPage")
    public String showBooksPage(Model model,int pageNum){
        List<Book> bookList=bookService.getBook((pageNum-1)*5);
        model.addAttribute("list",bookList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getBookCount()%5)==0){
            model.addAttribute("getPageCount",(bookService.getBookCount()/5));
        }else{
            model.addAttribute("getPageCount",(bookService.getBookCount()/5)+1);
        }
        return "admin/showBooks";
    }

    //根据类别查询书籍
    @RequestMapping("/showBooksResultPageByCategoryId")
    public String showBooksResultPageByCategoryId(Model model,int pageNum,String bookCategory){
        List<Book> bookList=bookService.getBookByTypeId((pageNum-1)*5,bookService.getBookTypeByName(bookCategory).getTypeId());
        int bookTypeid=bookService.getBookTypeByName(bookCategory).getTypeId();
        model.addAttribute("list",bookList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getBookCountByTypeId(bookTypeid)%5)==0){
            model.addAttribute("getPageCount",(bookService.getBookCountByTypeId(bookTypeid)%5));
        }else if (bookService.getBookCountByTypeId(bookTypeid)<5){
            model.addAttribute("getPageCount",1);
        }
        else{
            model.addAttribute("getPageCount",(bookService.getBookCountByTypeId(bookTypeid)%5)+1);
        }
        model.addAttribute("type","type");
        return "admin/showBooks";
    }

    //查询用户
    @RequestMapping("/showUsersPage")
    public String showUsersPage(Model model,int pageNum){
        List<User> userList=bookService.getUser((pageNum-1)*5);
        model.addAttribute("list",userList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getUserCount()%5)==0){
            model.addAttribute("getPageCount",(bookService.getUserCount()/5));
        }else{
            model.addAttribute("getPageCount",(bookService.getUserCount()/5)+1);
        }
        return "admin/showUsers";
    }

    //删除用户（异步）.
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(int userId){
        if(bookService.deleteUserById(userId)>0){
            return "true";
        }else{
            return "false";
        }
    }
    //新增用户
    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "admin/addUser";
    }

    //新增用户(异步)
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(String userName,String password,String userEmail){
        User user=new User(userName,password,userEmail);
        if(bookService.addUser(user)>0){
            return "true";
        }else{
            return "false";
        }
    }
    //新增用户
    @RequestMapping("/allBorrowBooksRecordPage")
    public String allBorrowBooksRecordPage(Model model,int pageNum){
        List<Borrowing> borrowingList=bookService.getBorrowingList((pageNum-1)*5);
        for (int i=0;i<borrowingList.size();i++){
            int borrowUid=borrowingList.get(i).getBorrowUid();
            int borrowBid=borrowingList.get(i).getBorrowBid();
            String userName=bookService.getUserById(borrowUid).getUserName();
            String bookName=bookService.getBookByID(borrowBid).getBookName();
            borrowingList.get(i).setUserName(userName);
            borrowingList.get(i).setBookName(bookName);
        }
        model.addAttribute("list",borrowingList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getBorrowingCount()%5)==0){
            model.addAttribute("getPageCount",(bookService.getBorrowingCount()/5));
        }else{
            model.addAttribute("getPageCount",(bookService.getBorrowingCount()/5)+1);
        }
        return "admin/allBorrowingBooksRecord";
    }






    //--------------------------------------用户部分--------------------------------------------------------
    //借书记录
    @RequestMapping("/userBorrowingBooksPage")
    public String userBorrowingBooksPage(Model model,int pageNum,int borrowUid){
        List<Borrowing> borrowingList=bookService.getBorrowingListById((pageNum-1)*5,borrowUid);
        for (int i=0;i<borrowingList.size();i++){
            int borrowBid=borrowingList.get(i).getBorrowBid();
            String bookName=bookService.getBookByID(borrowBid).getBookName();
            borrowingList.get(i).setBookName(bookName);
        }
        model.addAttribute("list",borrowingList);
        model.addAttribute("getPageNum",pageNum);
        if ((bookService.getBorrowingCountById(borrowUid)%5)==0){
            model.addAttribute("getPageCount",(bookService.getBorrowingCountById(borrowUid)/5));
        }else{
            model.addAttribute("getPageCount",(bookService.getBorrowingCountById(borrowUid)/5)+1);
        }
        return "user/borrowingBooksRecord";
    }

    //借阅书籍
    @RequestMapping("/borrowingPage")
    public String borrowingPage(){
        return "user/borrowingBooks";
    }

    //借阅书籍（异步）
    @RequestMapping("/userBorrowingBook")
    @ResponseBody
    public String userBorrowingBook(int bookId,HttpServletRequest request ){
    User user=(User) request.getSession().getAttribute("user");
    int borrowUid=user.getUserId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String borrowStart=df.format(new Date());// new Date()为获取当前系统时间
        Borrowing borrowing=new Borrowing(borrowUid,bookId,borrowStart,"未还");
        if (bookService.getBookByID(bookId)==null){
            return "false";
        }else if (bookService.getBookByID(bookId).getBookState().equals("不可借")){
            return "false";
        } else if (bookService.borrowBook(borrowing)>0){
            bookService.updateBookTypeFalse(bookId);
            return "true";
        }else{
            return "false";
        }
    }

    //归还书籍
    @RequestMapping("/userReturnBooksPage")
    public String userReturnBooksPage(){
        return "user/returnBooks";
    }

    //归还书籍（异步）
    @RequestMapping("/userReturnBook")
    @ResponseBody
    public String userReturnBook(int bookId,HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        int borrowUid=user.getUserId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String borrowEnd=df.format(new Date());// new Date()为获取当前系统时间
        if (bookService.returnBook(borrowUid,bookId,borrowEnd)>0){
            bookService.updateBookTypeTrue(bookId);
            return "true";
        }else{
            return "false";
        }
    }


    //查询书籍
    @RequestMapping("/findBookPage")
    public String findBookPage(Model model){
        List<Book> bookList=bookService.getAllBook();
        model.addAttribute("bookList",bookList);
        return "user/findBook";
    }

    //根据书籍名查询书籍
    @RequestMapping("/findBookByName")
    public String findBookByName(Model model,String bookName){
        List<Book> bookList=bookService.getAllBookByName(bookName);
        model.addAttribute("bookList",bookList);
        return "user/findBook";
    }

    //我的信息
    @RequestMapping("userMessagePage")
    public String userMessagePage(){
        return "user/userMessage";
    }

    //修改用户信息（异步）
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(String userName, String UserEmail, String userPwd, HttpServletRequest request, HttpSession session){
        User user=(User) request.getSession().getAttribute("user");
        int borrowUid=user.getUserId();
    User user2=new User(borrowUid,userName,userPwd,UserEmail);
    if (bookService.updateUser(user2)>0){
        session.setAttribute("user",user2);
        return "true";
    }else{
        return "false";
    }
    }
}
