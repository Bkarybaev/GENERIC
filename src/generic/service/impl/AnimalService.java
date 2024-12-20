package generic.service.impl;

import generic.dao.AnimalDao;
import generic.model.Animal;
import generic.service.GenericService;

import java.util.List;
import java.util.Set;

public class AnimalService implements GenericService<Animal, Long> {
    AnimalDao animalDao = new AnimalDao();

    @Override
    public String add(List<Animal> t) {
        animalDao.add(t);
        return "Successfully added";
    }

    @Override
    public Animal getById(Long aLong) {
        return animalDao.getById(aLong);
    }

    @Override
    public Set<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(int n) {
        try {
            if (n < 0 || n > 2) {
                throw new RuntimeException("tuura son berildi!");
            }
            return animalDao.sortByName(n);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<Animal> filterByGender(int n) {
        try {
            if (n < 0 || n > 2) {
                throw new RuntimeException("tuura son berildi!");
            }
            return animalDao.filterByGender(n);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Set<Animal> clear() {
        return animalDao.clear();
    }
}
