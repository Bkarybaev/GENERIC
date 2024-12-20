package generic.service;

import java.util.List;
import java.util.Set;

public interface GenericService<T, ID extends Number> {
    String add(List<T> t);

    T getById(ID id);

    Set<T> getAll();

    List<T> sortByName(int n);

    Set<T> filterByGender(int n);

    Set<T> clear();
}
