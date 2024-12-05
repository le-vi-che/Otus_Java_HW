package otus.java.hw15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(getMinMaxList(9, 18));
        System.out.println(getSumOfListElements(new ArrayList<>(Arrays.asList(14, 0, 5, 2, 6))));
        System.out.println(rewriteElement(new ArrayList<>(Arrays.asList(1, 5, 7, 16, 9)), 99));
        System.out.println(increaseElement(new ArrayList<>(Arrays.asList(1, 3, 5, 7)), 5));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mike", 18));
        employees.add(new Employee("Bob", 25));
        employees.add(new Employee("Alan", 38));

        System.out.println(allEmployeeNames(employees));
        System.out.println(minAgeEmployee(employees, 25));
        System.out.println(minAverAgeEmployee(employees, 400));
        System.out.println(youngestEmployee(employees));
    }

    public static List<Integer> getMinMaxList(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i < max; i++) {
            result.add(i);
        }
        return result;
    }

    public static int getSumOfListElements(List<Integer> list) {
        int sum = 0;

        for (int valueElement : list) {
            if (valueElement > 5) {
                sum += valueElement;
            }
        }
        return sum;
    }

    public static List<Integer> rewriteElement(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
        return list;
    }

    public static List<Integer> increaseElement(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + value);
        }
        return list;
    }

    public static List<Employee> allEmployeeNames(List<Employee> employees) {
        List<Employee> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee);
            //names.add(employee.getName());
        }
        return names;
    }

    public static List<Employee> minAgeEmployee(List<Employee> employees, int minAge) {
        List<Employee> newEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                newEmployee.add(employee);
            }
        }
        return newEmployee;
    }


    public static boolean minAverAgeEmployee(List<Employee> employees, double minAverAge) {
        int totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        double averageAge = (double) totalAge / employees.size();
        return averageAge > minAverAge;
    }

    public static Employee youngestEmployee(List<Employee> employees) {
        Employee yongestEmp = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getAge() < yongestEmp.getAge()) {
                yongestEmp = employee;
            }
        }
        return yongestEmp;
    }
}
