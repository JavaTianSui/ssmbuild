package com.tiansui.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tiansui.pojo.Books;
import com.tiansui.service.BooksService;
import com.tiansui.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier(value = "BookServiceImpl")
    private BooksService booksService;

    @RequestMapping("/allbook")
    public String queryBook(Model model){

        List<Books> books = booksService.queryAllBooks();

        model.addAttribute("list",books);

        return "allbook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/AddBook")
    public String addBook(Books books){

        System.out.println(books);
        booksService.addBook(books);
        return "redirect:/book/allbook";
    }

    @RequestMapping("/del/{bookId}")
    public String delBook(@PathVariable("bookId") int id){
        booksService.deleteBook(id);
        return "redirect:/book/allbook";
    }
    @RequestMapping("/toUpdateBook")
    public String update(int id,Model model){
        Books books = booksService.queryBookByID(id);
        model.addAttribute("book",books);
        return "update";
    }
    @RequestMapping("/UpdateBook")
    public String updateBook(Books books,Model model){
        System.out.println(books);
        booksService.updateBook(books);
        Books list = booksService.queryBookByID(books.getBookID());
        model.addAttribute("list",list);

        return "redirect:/book/allbook";
    }

    @RequestMapping("/query")
    public String query(String bookName,Model model){
        System.out.println(bookName);
        List<Books> list = booksService.queryBookByName(bookName);
        System.out.println(list+"=================");
        for (Books books : list) {
            System.out.println(books);
        }
        model.addAttribute("list",list);
        return "allbook";
    }
}
