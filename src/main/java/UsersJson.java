import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersJson {

    public ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Igor\\IdeaProjects\\GoIT\\HW-9\\src\\academy\\learnprogramming\\file2.txt"))) {
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

    File userJson = new File("C:\\Users\\Igor\\IdeaProjects\\GoIT\\HW-9_\\src\\main\\java\\user.json");

    public void jsonObjectCreation() {
        List<User> usersList = usersObjectCreation();
        for (User tempUser : usersList) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(tempUser);
            System.out.println(json);
            try (FileWriter writer = new FileWriter(userJson, true)) {
                writer.write(json);
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    class User {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
