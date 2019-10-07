package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllThePerson() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonBYId(UUID id) {
        return DB.stream()
                .filter(person -> person.getUuid().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID uuid) {
        Optional<Person> person_data = getPersonBYId(uuid);
        if(person_data.isEmpty())
            return 0;
        DB.remove(person_data.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID uuid,Person _person) {
        return getPersonBYId(uuid)
                .map(p -> {
                        int indexOfPerson = DB.indexOf(p);
                        if(indexOfPerson >= 0)
                        {
                            DB.set(indexOfPerson,new Person(uuid,_person.getName()));
                            return 1;
                        }
                        return 11;
                        }
                ).orElse(0);
    }
}
