package com.tiansui.service;

import com.tiansui.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    //增加一本图书
    int addBook(Books books);
    //删除一本图书
    int deleteBook(int id);
    //更新一本图书
    int updateBook(Books books);
    //查询一本图书
    Books queryBookByID(int id);
    //查询所有图书
    List<Books> queryAllBooks();
    //根据书籍名称查询书籍信息---模糊查询
    List<Books> queryBookByName(String bookName);

}
