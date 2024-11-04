package org.example.ru.otus.lesson10.user;

public class MainAppUser {
    public static void main(String[] args) {
        User users[] = {new User("Ivan", "Ivanovich", "Ivanov", 1985, "iii@ii.ru"),
                new User("Anna", "Ivanovna", "Vannova", 1990, "aiv@ii.ru"),
                new User("Semen", "Semenovich", "Semenov", 2000, "sss@ii.ru"),
                new User("Elena", "Evgenyevna", "Ennotova", 1999, "eee@ii.ru"),
                new User("Artem", "Artemovich", "Artemov", 2004, "aaa@ii.ru"),
                new User("Olga", "Olegovna", "Yannova", 1995, "ooy@ii.ru"),
                new User("Oleg", "Olegivich", "Slonov", 2001, "oos@ii.ru"),
                new User("Inga", "Ivanovna", "Mishkina", 1983, "iim@ii.ru"),
                new User("Damir", "Damirovch", "Damirov", 1979, "dadada@ii.ru"),
                new User("Anton", "Antonovich", "Repkin", 1980, "aar@ii.ru")
        };


        for (int i = 0; i < users.length; i++) {
            if ((2024 - users[i].getYearOfBirth()) > 40) {
                users[i].info();
            }
        }
    }
}


