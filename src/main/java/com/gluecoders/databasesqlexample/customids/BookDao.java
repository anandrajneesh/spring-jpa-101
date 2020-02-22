package com.gluecoders.databasesqlexample.customids;

import com.gluecoders.databasesqlexample.customids.Book;
import com.gluecoders.databasesqlexample.customids.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, BookId> {
}
