package learn.cat.data;

import learn.cat.models.Alias;
import learn.cat.models.Cat;

import java.util.List;

public interface AliasRepository {
    Alias findById(int aliasId);

    Alias add(Alias alias);

    boolean update(Alias alias);

    boolean deleteById(int aliasId);
}
