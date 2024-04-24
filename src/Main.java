import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        String[] str = {"cd", "ac", "dc", "ca", "zz"};

        int count = 0;
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (Objects.equals(str[i], reverse(str[j]))) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }
    public static String reverse(String str) {

        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i > -1; i--) {
            newStr.append(str.charAt(i));
        }
        return new String(newStr);
    }





}