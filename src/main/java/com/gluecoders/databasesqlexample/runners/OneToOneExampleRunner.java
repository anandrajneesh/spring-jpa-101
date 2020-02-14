package com.gluecoders.databasesqlexample.runners;

import com.gluecoders.databasesqlexample.dao.AddressDao;
import com.gluecoders.databasesqlexample.dao.UserDao;
import com.gluecoders.databasesqlexample.models.Address;
import com.gluecoders.databasesqlexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OneToOneExampleRunner implements CommandLineRunner {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;
    @Override
    public void run(String... args) throws Exception {
        Address address = new Address();
        address.setCity("xx");
        address.setStreet("1231");
        User user = new User();
        user.setAddress(address);
        user.setFirstName("Anand");
        user.setLastName("Rajneesh");

        userDao.save(user);
        System.out.println("User saved with id  "+ user.getId());
        System.out.println("Address saved with id " + address.getId());

        Optional<User> result = userDao.findById(user.getId());
        if(result.isPresent()){
            user = result.get();
            System.out.println("User fetched with id  "+ user.getId());
            System.out.println("Address fetch with id " + user.getAddress().getId());
        }else{
            System.out.println("Could not fetch error here:");
            throw new IllegalStateException();
        }

        userDao.deleteById(user.getId());
        result = userDao.findById(user.getId());
        if(result.isPresent()){
            System.out.println("Could not delete error here:");
            throw new IllegalStateException();
        }else{
            System.out.println("User deleted");
            Optional<Address> address1 = addressDao.findById(address.getId());
            if(address1.isPresent()){
                System.out.println("Could not delete error here:");
                throw new IllegalStateException();
            }else{
                System.out.println("Address deleted");
            }
        }
    }
}
