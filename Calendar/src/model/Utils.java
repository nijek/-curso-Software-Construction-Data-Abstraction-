package model;

public class Utils {
    public static String toString(Integer num) {
        if (num < 10) {
            return '0' + num.toString();
        }
        return num.toString();
    }
}
