package generic.dao;

import generic.enums.Gender;
import generic.model.DB;
import generic.model.Person;
import generic.service.GenericService;

import java.util.*;

public class PersonDao implements GenericService<Person,Long> {


    @Override
    public String add(List<Person> t) {
        DB.people.addAll(t);
        return "";
    }

    @Override
    public Person getById(Long aLong) {
        for (Person p : DB.people) {
            if (p.getId().equals(aLong)){
                return p;
            }
        }
        return null;
    }

    @Override
    public Set<Person> getAll() {
        return DB.people;
    }

    @Override
    public List<Person> sortByName(int n) {
        List<Person> people = new ArrayList<>(DB.people) ;
        people.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if (n == 1){
                        return o1.getName().compareTo(o2.getName());
                    }
                    else{
                        return o2.getName().compareTo(o1.getName());
                    }
                }
            });


        return people;
    }

    @Override
    public Set<Person> filterByGender(int n) {
        Gender gen = n ==1 ? Gender.FEMALE : Gender.MALE;
        Set<Person> people = new LinkedHashSet<>();

        for (Person person : DB.people) {
            if (person.getGender().equals(gen)){
                people.add(person);
            }
        }

        return people;
    }

    @Override
    public Set<Person> clear() {
        DB.people.clear();
        return DB.people;
    }
}
