package org.hackathon.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class Book {
    private Long id;
    @NotBlank(message = "Tên sách không được để trống.")
    @Size(min = 3, max = 100, message = "Tên sách phải từ 3 đến 100 ký tự.")
    private String title;
    @NotBlank(message = "Tác giả không được để trống.")
    private String author;

    @NotNull(message = "Số lượng không được để trống.")
    @PositiveOrZero(message = "Số lượng phải lớn hơn hoặc bằng 0.")
    private Double quantity;

    private String coverImage;

    public Book() {}
    public Book(Long id, String title, String author, Double quantity, String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
