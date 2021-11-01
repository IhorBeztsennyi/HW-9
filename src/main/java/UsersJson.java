import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersJson {

    public ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resources/file2.txt"))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<User> usersObjectCreation() {
        List<User> usersList = new ArrayList<>();
        ArrayList<String> lines = readFile();
        for (int i = 1; i < lines.size(); i++) {
            String tempLine = lines.get(i);
            String[] subString = tempLine.split(" ");
            User user = new User(subString[0], subString[1]);
            usersList.add(user);
        }
        return usersList;
    }

    File userJson = new File("src/main/java/resources/user.json");

    public void jsonObjectCreation() {
        List<User> usersList = usersObjectCreation();
        try (FileWriter writer = new FileWriter(userJson, true)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(usersList, writer);
            System.out.println(gson.toJson(usersList));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    class User {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
