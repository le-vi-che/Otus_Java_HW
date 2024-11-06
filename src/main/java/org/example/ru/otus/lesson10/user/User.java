package org.example.ru.otus.lesson10.user;

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private int yearOfBirth;
    private String email;

    public User(String name, String patronymic, String surname, int yearOfBirth, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic() {
        this.patronymic = patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth() {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String toString(){
        return "ФИО: " + this.surname + " " + this.name + " " + this.patronymic + "\n" + "Год рождения: " + this.yearOfBirth + "\n" + "e-mail: " + this.email;
    }

}

