package hw18;

import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> data;

    PhoneBook() {
        data = new HashMap<>();
    }

    public void add(String name, String phone) {
        data.putIfAbsent(name, new ArrayList<>());
        data.get(name).add(phone);
    }

    public List<String> find(String name) {
    //    return data.getOrDefault(name, new ArrayList<>());
        return data.getOrDefault(name, Collections.emptyList());
    }

    public String containsPhoneNumber(String phone) {
        for (List<String> phones : data.values()) {
            if (phones.contains(phone)) {
                return "Номер " + phone + " содержится в справочнике";
            }
        }
        return "Номера " + phone + " нет в справочнике";
    }

    @Override
    public String toString() {
        return "PhoneBook: " + data;
    }
}
