package learn.cat.domain;

import learn.cat.data.UsersRepository;
import learn.cat.models.Users;
import learn.cat.models.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

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

    public Result<Users> add(Users users){
        Result<Users> result = validate(users);
        if(!result.isSuccess()){
            return  result;
        }

        if(users.getUsersId() != 0){
            result.addMessage("UsersId cannot be set for add operation", ResultType.INVALID);
            return result;
        }

        users = repository.add(users);
        result.setPayload(users);
        return result;
    }

    public Result<Users> update(Users users){
        Result<Users> result = validate(users);
        if(!result.isSuccess()){
            return  result;
        }

        if(users.getUsersId() <= 0){
            result.addMessage("UsersId must be set for update operation", ResultType.INVALID);
            return result;
        }

        if(!repository.update(users)) {
            String msg = String.format("usersId: %s, not found", users.getUsersId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }
        return result;
    }

    public boolean deleteById(int usersId) {
        return repository.deleteById(usersId);
    }

    public Result<Users> validate(Users users) {
        Result<Users> result = new Result<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Users>> violations = validator.validate(users);

        for(ConstraintViolation violation : violations ){
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }
        return result;
    }
}
