






import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagram {
    public static void main(String args[]) {
        // Tests the isAnagram function.
        System.out.println(isAnagram("silent", "listen")); // true
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
        System.out.println(isAnagram("Madam Curie", "Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

        // Tests the preProcess function.
        System.out.println(preProcess("What? No way!!!"));

        // Tests the randomAnagram function.
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

        // Performs a stress test of randomAnagram
        String str = "1234567";
        Boolean pass = true;
        //// 10 can be changed to much larger values, like 1000
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass)
                break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }
    public static boolean isAnagram(String str1, String str2) {
        // Preprocess both strings
        String processedStr1 = preProcess(str1);
        String processedStr2 = preProcess(str2);

        // Check lengths
        if (processedStr1.length() != processedStr2.length()) {
            return false;
        }

        //  charakter count  for comparison
        int[] charCount = new int[26];
        for (char c : processedStr1.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : processedStr2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    public static String preProcess(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isLetter(c) || Character.isWhitespace(c)) {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}

    public static String randomAnagram(String str) {
        List<Character> chars = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
