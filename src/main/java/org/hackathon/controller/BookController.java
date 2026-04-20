package org.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.hackathon.model.dto.BookDTO;
import org.hackathon.service.BookService;

@Controller
@RequestMapping({"/","/books"})
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("listBook", bookService.getBook());
        return "list-books";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("BookDTO",new BookDTO());
        return "addBook";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("empId")Long id, Model model){
        boolean bl = bookService.deleteBook(id);
        if(bl){
            model.addAttribute("message","Xóa thành công có mã "+id);
        }else{
            model.addAttribute("message","Không xóa được nhân viên có mã "+id);
        }
        model.addAttribute("listEmployee", bookService.getBook());
        return "list-books";
    }

    @GetMapping("/search-by-name")
    public String searchByName(@RequestParam("title")String title, Model model){
        if(title==null){
            title = "";
        }
        model.addAttribute("listEmployee", bookService.searchByTitle(title));
        return "list-books";
    }
}
