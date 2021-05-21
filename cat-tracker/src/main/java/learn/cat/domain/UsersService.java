package learn.cat.domain;

import learn.cat.data.UsersRepository;
import learn.cat.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<Users> findAll() {
        return repository.findAll();
    }

    public Users findById(int userId) {
        return repository.findById(userId);
    }

    //TODO add

    //TODO update

    public boolean deleteById(int usersId) {
        return repository.deleteById(usersId);
    }
}
