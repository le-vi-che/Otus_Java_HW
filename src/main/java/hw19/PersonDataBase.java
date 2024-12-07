package hw19;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personDataBase;

    public PersonDataBase() {
        personDataBase = new HashMap<>();
    }

    public Person findById(Long id) {
        return personDataBase.get(id);
    }

    public void add(Person person) {
        personDataBase.put(person.getId(), person);
    }

    public boolean isManager(Person person) {

        return person.getPosition() == Position.MANAGER ||
                person.getPosition() == Position.DIRECTOR ||
                person.getPosition() == Position.BRANCH_DIRECTOR ||
                person.getPosition() == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }

    @Override
    public String toString() {
        return personDataBase.toString();
    }
}
