package com.gluecoders.databasesqlexample.customids;

import com.gluecoders.databasesqlexample.customids.BookDao;
import com.gluecoders.databasesqlexample.customids.Book;
import com.gluecoders.databasesqlexample.customids.BookId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmbeddedIdExampleRunner implements CommandLineRunner {

    @Autowired
    private BookDao bookDao;

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        book.setIsbn("isbn-401-231");
        book.setRating(4);
        book.setBookId(new BookId("running", "chetan bhagat"));

        bookDao.save(book);
        System.out.println("Book with title "+ book.getBookId().getTitle() + " saved");

        bookDao.findById(new BookId("running", "chetan bhagat"))
        .ifPresent(b -> System.out.println("Book fetched "+ b.getBookId().getAuthor() + " isbn "+ b.getIsbn()));

        bookDao.delete(book);
        Optional<Book> dbResult =  bookDao.findById(new BookId("running", "chetan bhagat"));
        if(dbResult.isPresent()){
            System.out.println("This is an error here");
            throw new IllegalStateException();
        }else{
            System.out.println("Book deleted");
        }
    }
}
