import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PhoneNumber {

    public static final int PHONE_SIZE = 14;

    public void readFile() {
        try (FileReader reader = new FileReader("src/main/java/resources/file1.txt")) {
            char[] buf = new char[PHONE_SIZE];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < PHONE_SIZE) {
                    buf = Arrays.copyOf(buf, c);
                }
                phoneNumbers(buf);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void phoneNumbers(char[] buf) {
        String stringNumber = String.valueOf(buf).trim();
        if (stringNumber.matches("\\(\\d{3}\\)\\s\\d{3}(-)\\d{4}")){
            System.out.println(buf);
        } else if (stringNumber.matches("\\d{3}\\s\\d{3}\\s\\d{4}")) {
            System.out.println(buf);
        }
    }
}
