package learn.cat.domain;

import learn.cat.data.AliasRepository;
import learn.cat.models.Alias;
import org.springframework.stereotype.Service;

@Service
public class AliasService   {

    private final AliasRepository repository;

    public AliasService(AliasRepository repository) {
        this.repository = repository;
    }

    public Alias findById(int aliasId)  {
        return repository.findById(aliasId);
    }

    public Result<Alias> add(Alias alias)   {
        Result<Alias> result = new Result<>();
        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAliasId() != 0)    {
            result.addMessage("aliasId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        alias = repository.add(alias);
        result.setPayload(alias);
        return result;
    }

    public Result<Alias> update(Alias alias)    {
        Result<Alias> result = new Result<>();
        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAliasId() <= 0)    {
            result.addMessage("aliasId cannot be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(alias)) {
            String msg = String.format("aliasId: %s, not found", alias.getAliasId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int aliasId)  {
        return repository.deleteById(aliasId);
    }
}
