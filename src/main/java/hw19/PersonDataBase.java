package hw19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    private final Map<Long, Person> personDataBase = new HashMap<>();
    private final Set<Position> position = new HashSet<>();

    public PersonDataBase() {
        position.add(Position.MANAGER);
        position.add(Position.DIRECTOR);
        position.add(Position.SENIOR_MANAGER);
        position.add(Position.BRANCH_DIRECTOR);
    }

    public Person findById(Long id) {
        return personDataBase.get(id);
    }

    public void add(Person person) {
        personDataBase.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        return position.contains(personDataBase.get(person.getId()).getPosition());
    }

    public boolean isEmployee(Long id) {
        return !isManager(findById(id));
    }

    @Override
    public String toString() {
        return personDataBase.toString();
    }
}
