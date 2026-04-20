package org.hackathon.controller;

import jakarta.validation.Valid;
import org.hackathon.model.Book;
import org.hackathon.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    private final String uploadDir = "C:/uploads/";
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String list(@RequestParam(value = "keyword", required = false) String keyword,
                       Model model) {
        model.addAttribute("list", service.search(keyword));
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("book") Book book,
                       BindingResult result,
                       @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            return "form";
        }

        if (file != null && !file.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File destination = new File(uploadDir + fileName);
            file.transferTo(destination);
            book.setCoverImage(fileName);
        }
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book b = service.findById(id);
        if (b == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", b);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/books";
    }
}
