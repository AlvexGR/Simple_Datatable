package nhan.util;

public class CommonUtil {
    public static boolean isNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.trim().length() == 0;
    }
}
