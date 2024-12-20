package generic.service.impl;

import generic.dao.PersonDao;
import generic.model.Person;
import generic.service.GenericService;

import java.util.List;
import java.util.Set;

public class PersonService implements GenericService<Person, Long> {
    PersonDao personDao = new PersonDao();

    @Override
    public String add(List<Person> t) {
        personDao.add(t);
        return "Successfully added";
    }

    @Override
    public Person getById(Long aLong) {
        return personDao.getById(aLong);
    }

    @Override
    public Set<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(int n) {
        try {
            if (n < 0 || n > 2) {
                throw new RuntimeException("tuura son berildi!");
            }
            return personDao.sortByName(n);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<Person> filterByGender(int n) {
        try {
            if (n < 0 || n > 2) {
                throw new RuntimeException("tuura son berildi!");
            }
            return personDao.filterByGender(n);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<Person> clear() {
        return personDao.clear();
    }
}
