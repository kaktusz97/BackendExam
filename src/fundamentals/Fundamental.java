package fundamentals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author G
 */
public class Fundamental {

    public static void testMySolutions() {
        String invertedText = invertCase("AsewQzE"); // result: aSEWqZe
        System.out.println(invertedText);
        String ordered = orderChars("tewoiprvqcaaaporvwaourefal"); // aaaaaceefiloooppqrrrtuvvww
        System.out.println(ordered);
        int differentCharCount = countDifferentChars(ordered); // 14
        System.out.println("number of different chars:" + differentCharCount);
        boolean contains = containsCertainDigit(4567, 6); // true
        System.out.println("4567 contains 6: " + contains);
        String changed = replaceUnderscores(
                "Szer_tem___kihivasokat_es_a_vizsgakat.", "e", " ", "a", " ");// Szeretem a kihívásokat és a vizsgákat.
        System.out.println("A nap mondasa: " + changed);

    }

    public static String invertCase(String original) {
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            br.append(switchCases(c));
        }
        return br.toString();
    }

    private static char switchCases(char c) {
        c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.
                toLowerCase(c);
        return c;
    }

    public static String orderChars(String unorderedText) {
        char[] chars = unorderedText.toCharArray();
//        Arrays.sort(chars);
        sortCharsInAlphabeticOrder(chars);
        return new String(chars);
    }

    private static void sortCharsInAlphabeticOrder(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (chars[j] < chars[j - 1]) {
                    char temp = chars[j - 1];
                    chars[j - 1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
    }

    public static int countDifferentChars(String ordered) {
        String found = "";
        for (char c : ordered.toCharArray()) {
            if (!found.contains(String.valueOf(c))) {
                found += c;
            }
        }
        return found.length();
    }

    public static boolean containsCertainDigit(int number, int digit) {
        List<Integer> digits = intToList(number);
        return digits.contains(Math.abs(digit));
    }

    private static List<Integer> intToList(int number) {
        int numCopy = number, size = countDigits(numCopy);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = number % 10;
            result.add(Math.abs(num));
            number = number / 10;
        }
        return result;
    }

    private static int countDigits(int number) {
        return number == 0 ? 1 : 1 + ((int) (Math.log10((Math.abs(number)))));
    }

    public static String replaceUnderscores(String original, String... swapChars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char temp = original.charAt(i);
            if (isUnderline(temp)) {
                temp = swapChars[0].charAt(0);
                swapChars = removeUsedChar(swapChars);
            }
            result.append(temp);
        }
        return result.toString();
    }

    private static boolean isUnderline(char charAt) {
        return charAt == '_';
    }

    private static String[] removeUsedChar(String[] swapChars) {
        return swapChars.length > 1 ? reduceArray(swapChars) : swapChars;
    }

    private static String[] reduceArray(String[] swapChars) {
        String result[] = new String[swapChars.length - 1];
        for (int i = 1; i < swapChars.length; i++) {
            result[i - 1] = swapChars[i];
        }
        return result;
    }
}
