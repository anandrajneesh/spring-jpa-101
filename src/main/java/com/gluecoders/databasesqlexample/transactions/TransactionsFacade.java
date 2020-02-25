package com.gluecoders.databasesqlexample.transactions;

import com.gluecoders.databasesqlexample.transactions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionsFacade {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private PublicationDao publicationDao;
    @Autowired
    private BankUserDao bankUserDao;
    @Autowired
    private AccountDao accountDao;

    public void errorWhileSavingRollbacks() throws DaoException {
        System.out.println("Saving Author and Publication");
        Author author = new Author();
        author.setName("xx");
        authorDao.save(author);
        System.out.println(author.getId() + " findingnemo");
        Publication publication = new Publication();
        publication.setAuthor(author);
        publicationDao.save(publication);
    }

    public void lazyFetchShouldWork() {
        List<Author> authors = authorDao.findAll();
        for(Author author : authors){
            for(Publication publication : author.getPublications()){
                System.out.println("Author "+ author.getName()+" wrote publication "+ publication.getTitle());
            }
        }
       /* List<Publication> publications = publicationDao.findAll();
        for(Publication p : publications){
            System.out.println(p.getTitle() + " written by "+p.getAuthor().getName());
        }*/
    }

    public void lazyOneToOne(){
        List<BankUser> users = bankUserDao.findAll();
        for(BankUser user: users){
            System.out.println(user.getName() + " has amount "+ user.getAccount().getAmount());
        }
    }


}
