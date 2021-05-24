package learn.cat.domain;

import learn.cat.data.CatRepository;
import learn.cat.models.Cat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public List<Cat> findAll() {
        return repository.findAll();
    }

    public Cat findById(int catId) {
        return repository.findById(catId);
    }

    public Result<Cat> add(Cat cat) {
        Result<Cat> result = new Result<>();
        if (!result.isSuccess()) {
            return result;
        }

        if (cat.getCatId() != 0) {
            result.addMessage("catId must be set for `add` operation", ResultType.INVALID);
            return result;
        }

        cat = repository.add(cat);
        result.setPayload(cat);
        return result;
    }

    public Result<Cat> update(Cat cat) {
        Result<Cat> result = new Result<>();
        if (!result.isSuccess()) {
            return result;
        }

        if (cat.getCatId() <= 0) {
            result.addMessage("catId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(cat)) {
            String msg = String.format("catId: %s, not found", cat.getCatId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int catId) {
        return repository.deleteById(catId);
    }


}
