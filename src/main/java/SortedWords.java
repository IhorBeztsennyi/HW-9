import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SortedWords {
    public static final int CHAR_SIZE = 1024;
    public String readFile() {
        String text = null;
        try (FileReader reader = new FileReader("src/main/java/resources/words.txt")) {
            char[] buf = new char[CHAR_SIZE];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < CHAR_SIZE) {
                    buf = Arrays.copyOf(buf, c);
                }
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < buf.length; i++) {
                    result.append(buf[i]);
                }
                text = result.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public void sortedTable() {
        HashMap<String, Integer> map = new HashMap<>();
        String text = readFile();
        String[] wordArray = text.replaceAll("\n", " ").replaceAll("\\s{2,}", " ").trim().split(" ");
        for (String word : wordArray) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        printMap(map);
    }

    public void printMap(HashMap<String, Integer> map) {
        for (String temp : map.keySet()) {
            System.out.println(temp + " " + map.get(temp));
        }
    }
}
