package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.Book;
import com.gluecoders.databasesqlexample.models.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, BookId> {
}
