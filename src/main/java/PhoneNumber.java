import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PhoneNumber {

    public void readFile() {
        try (FileReader reader = new FileReader("C:\\Users\\Igor\\IdeaProjects\\GoIT\\HW-9_\\src\\main\\java\\file1.txt")) {
            char[] buf = new char[14];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 14) {
                    buf = Arrays.copyOf(buf, c);
                }
                phoneNumbers(buf);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void phoneNumbers(char[] buf) {
        if (buf[0] == '(' && isDigit(buf[1]) && isDigit(buf[2]) && isDigit(buf[3]) && buf[4] == ')' &&
                buf[5] == ' ' && isDigit(buf[6]) && isDigit(buf[7]) && isDigit(buf[8]) && buf[9] == '-' &&
                isDigit(buf[10]) && isDigit(buf[11]) && isDigit(buf[12]) && isDigit(buf[13])) {
            System.out.println(buf);
        } else if (isDigit(buf[0]) && isDigit(buf[1]) && isDigit(buf[2]) && buf[3] == '-' && isDigit(buf[4]) &&
                isDigit(buf[5]) && isDigit(buf[6]) && buf[7] == '-' && isDigit(buf[8]) && isDigit(buf[9]) &&
                isDigit(buf[10]) && isDigit(buf[11])) {
            System.out.println(buf);
        }
    }

    private boolean isDigit(char digit) {
        boolean flag = false;
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char tempDigit : digits) {
            if (tempDigit == digit) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
