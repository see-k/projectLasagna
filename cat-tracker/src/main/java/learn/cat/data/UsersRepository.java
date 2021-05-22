package learn.cat.data;

import learn.cat.models.Users;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

public interface UsersRepository {

    List<Users> findAll();

    Users findById(int usersId);

    Users add(Users users);

    boolean update(Users users);

    @Transactional
    boolean deleteById(int usersId);
}
