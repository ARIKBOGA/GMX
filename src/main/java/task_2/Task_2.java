package task_2;

public class Task_2 {

    /*
    2. Java function:
    Write a function that takes a string as a parameter and outputs the same string in reverse order.
    Only letters from the ascii character set should be accepted. The maximum length of the passed string is 30 characters.
    In case of an error, a meaningful message should be output.
    */


    private static String reverse(String str) {
        String reverse = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse = reverse.concat(String.valueOf(chars[i]));
        }
        return reverse;
    }

    private static boolean containsDifferentFromLetter(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c))
                return true;
        }
        return false;
    }

    public static String getReverseOrder(String str) {
        String errorMessage = "";
        if (containsDifferentFromLetter(str)) {
            errorMessage += "Given string \"" + str + "\" shouldn't contain any character different from letters!";
        }
        if (str.length() == 0 || str.length() > 30) {
            errorMessage += !errorMessage.isEmpty() ? "\n" : "";
            errorMessage += "Given string \"" + str + "\"'s length must be in 1-30 length!";
        }
        return !errorMessage.isEmpty() ? errorMessage : reverse(str);
    }

}