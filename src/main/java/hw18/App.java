package hw18;

public class App {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Yoda", "123-321");
        phoneBook.add("LuKe", "456-456");
        phoneBook.add("Obi", "159-951");
        phoneBook.add("Obi", "159-950");
        System.out.println(phoneBook);

        System.out.println(phoneBook.find("Yods"));
        System.out.println(phoneBook.find("Obi"));


        System.out.println(phoneBook.containsPhoneNumber("456-456"));
        System.out.println(phoneBook.containsPhoneNumber("213-100"));
    }
}