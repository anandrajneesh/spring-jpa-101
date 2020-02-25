package com.gluecoders.databasesqlexample.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionsExampleRunner implements CommandLineRunner {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private PublicationDao publicationDao;
    @Autowired
    private TransactionsFacade facade;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private BankUserDao bankUserDao;

    @Override
    public void run(String... args) throws Exception {
        wrapperErrorWhileSavingRollbacks();
        fetchesLazyPropertiesToo();
        fetchLazyOneToOne();
    }


    public void fetchLazyOneToOne(){
        Account account = new Account();
        account.setAmount(100000L);
        BankUser user = new BankUser();
        user.setName("Xx");
        bankUserDao.save(user);
        account.setBankUser(user);
        accountDao.save(account);
        facade.lazyOneToOne();
    }

    public void wrapperErrorWhileSavingRollbacks() {
        try {
            facade.errorWhileSavingRollbacks();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Author> authors = authorDao.findAll();
        if (authors.size() > 0) {
            System.out.println("Rollback didn't work");
        }
        List<Publication> publications = publicationDao.findAll();
        if (publications.size() > 0) {
            System.out.println("Rollback didn't work");
        }
    }

    public void fetchesLazyPropertiesToo(){
        Author author = new Author();
        author.setName("xx");
        authorDao.save(author);
        System.out.println(author.getId() + " notfindingnemo");
        Publication publication = new Publication();
        publication.setTitle("xx writes something");
        publication.setAuthor(author);
        publicationDao.save(publication);
        facade.lazyFetchShouldWork();
    }


}
