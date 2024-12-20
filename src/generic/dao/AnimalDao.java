package generic.dao;

import generic.enums.Gender;
import generic.model.Animal;
import generic.model.DB;
import generic.service.GenericService;

import java.util.*;

public class AnimalDao implements GenericService<Animal,Long> {


    @Override
    public String add(List<Animal> t) {
        DB.animals.addAll(t);
        return "";
    }

    @Override
    public Animal getById(Long aLong) {
        for (Animal a : DB.animals) {
            if (a.getId().equals(aLong)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Animal> getAll() {
        return DB.animals;
    }

    @Override
    public List<Animal> sortByName(int n) {
        List<Animal> animals = new ArrayList<>(DB.animals);
        animals.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (n == 1)return o1.getName().compareTo(o2.getName());
                else return o2.getName().compareTo(o1.getName());
            }
        });
        return animals;
    }

    @Override
    public Set<Animal> filterByGender(int n) {
        Gender gen = n == 1? Gender.FEMALE : Gender.MALE;
        Set<Animal> animals = new LinkedHashSet<>();

        for (Animal a : DB.animals) {
            if (a.getGender().equals(gen)){
                animals.add(a);
            }
        }

        return animals;
    }

    @Override
    public Set<Animal> clear() {
        DB.animals.clear();
        return DB.animals;
    }
}
