
public class Main {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.readFile();
        System.out.println("*****************");
        UsersJson usersJson = new UsersJson();
        usersJson.jsonObjectCreation();
        System.out.println("*****************");
        SortedWords sortedWords = new SortedWords();
        sortedWords.sortedTable();


    }

}
