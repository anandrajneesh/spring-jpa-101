package com.gluecoders.databasesqlexample.customids;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Book {

    @EmbeddedId
    private BookId bookId;
    private String isbn;
    private int rating;

    public BookId getBookId() {
        return bookId;
    }

    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
