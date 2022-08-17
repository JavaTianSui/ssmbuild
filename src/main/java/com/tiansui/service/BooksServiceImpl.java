package com.tiansui.service;

import com.tiansui.dao.BooksMapper;
import com.tiansui.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService{

    //service调dao层
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return booksMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books queryBookByID(int id) {
        return booksMapper.queryBookByID(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        return booksMapper.queryBookByName(bookName);
    }
}
