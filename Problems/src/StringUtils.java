import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {
  public static void main(String[] args) throws Exception {

    // 1- Find the number of vowels in a string. Vowels in English are A, E, O, I, U
    // Input: “hello”
    // Output: 2
    System.out.println(findVowels("hello"));
    System.out.println(countVowels("hello"));

    // 2- Reverse a string.
    // Input: “hello”
    // Output: “olleh”
    System.out.println(reverse("hello"));

    // 3- Reverse the order of words in a sentence.
    // Input: “Trees are beautiful”
    // Output: “beautiful are Trees”
    System.out.println("'" + reverseWords("Trees are beautiful") + "'");

    // 4- Check if a string is a rotation of another string.
    // Input: “ABCD”, “DABC” (rotate one char to the right)

    // Input: “ABCD”, “CDAB” (rotate two chars to the right)
    // Output: true

    // Input: “ABCD”, “ADBC”
    // Output: false
    System.out.println(isRotation("ABCD", "DABC"));
    System.out.println(isRotation("ABCD", "CDAB"));
    System.out.println(isRotation("ABCD", "ADBC"));

    // 5- Remove duplicate characters in a string.
    // Input: “Hellooo!!”
    // Output: “Helo!”
    System.out.println("\"" + removeDuplicates("Helooo!!") + "\"");

    // 6- Find the most repeated character in a string.
    // Input: “Hellooo!!”
    // Output: ‘o’
    System.out.println("'" + mostRepeatedCharacter("Helooo!!") + "'");

    // 7- Capitalize the first letter of each word in a sentence. Also, remove any
    // extra spaces between words.
    // Input: “trees are beautiful”
    // Output: “Trees Are Beautiful”
    System.out.println("\"" + capitalizeString("trees are beautiful") + "\"");

    // 8- Detect if two strings are anagram of each other. A string is an
    // anagram of another string if it has the exact same characters in any
    // order.
    // Input: “abcd”, “adbc”
    // Output: true

    // Input: “abcd”, “cadb”
    // Output: true

    // Input: “abcd”, “abcd”
    // Output: true

    // Input: “abcd”, “abce”
    // Output: false
    System.out.println(areAnagrams("ABCD", "ACBD"));
    System.out.println(areAnagrams2("ABCD", "ACBD"));

    // 9- Check if a string is palindrome. If we read a palindrome string from
    // left or right, we get the exact same characters.
    // Input: “abba”
    // Output: true

    // Input: “abcba”
    // Output: true

    // Input: “abca”
    // Output: false
    System.out.println(isPalindrome("abba"));
    System.out.println(isPalindrome("abcba"));
    System.out.println(isPalindrome("abca"));
    System.out.println(isStringPalindrome("abba"));
    System.out.println(isStringPalindrome("abcba"));
    System.out.println(isStringPalindrome("abca"));
  }

  public static int findVowels(String str) {
    if (str == null)
      return 0;

    int totalVowels = 0;
    Map<Character, Integer> vowels = new HashMap<>() {
      {
        put('a', 0);
        put('e', 0);
        put('i', 0);
        put('o', 0);
        put('u', 0);
      }
    };

    var array = str.toLowerCase().toCharArray();
    for (int i = 0; i < array.length; i++) {
      if (vowels.containsKey(array[i]))
        vowels.put(array[i], vowels.get(array[i]) + 1);
    }

    for (var vowel : vowels.entrySet())
      totalVowels += vowel.getValue();

    return totalVowels;
  }

  public static int countVowels(String str) {
    if (str == null)
      return 0;

    int count = 0;
    Set<Character> set = new HashSet<>();
    set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    for (var ch : str.toLowerCase().toCharArray())
      if (set.contains(ch))
        count += 1;

    return count;
  }

  public static String reverse(String str) {
    // this reduce the memory overhead which is caused due to copying the elements
    // of non mutable string to a new string instance each time we modify the
    // original string, also it reduces the time complexity significantly as copying
    // elements takes O(n) as length of string increases to O(1)
    StringBuilder newString = new StringBuilder();

    for (int i = str.length() - 1; i >= 0; i--) // O(n)
      newString.append(str.charAt(i)); // O(1)

    return newString.toString();
  }

  public static String reverseWords(String str) {
    if (str == null)
      return "";
    // cleaner approach
    var array = str.trim().split(" ");
    Collections.reverse(Arrays.asList(array));
    return String.join(" ", array);
    // StringBuilder modified = new StringBuilder();

    // for (int i = array.length - 1; i >= 0; i--)
    // modified.append(array[i] + " ");

    // return modified.toString().trim();
  }

  public static boolean isRotation(
      String original, String rotated) {

    if (original == null || rotated == null)
      return false;

    return (original.length() == rotated.length() &&
        (original + original).contains(rotated));
  }

  public static String removeDuplicates(String str) {
    if (str == null)
      return "";
    Set<String> set = new LinkedHashSet<>();
    for (Character ch : str.toCharArray())
      set.add(ch.toString());

    return String.join("", set);
  }

  public static Character mostRepeatedCharacter(String str) {
    if (str.isEmpty() || str == null)
      throw new IllegalArgumentException();

    Map<Character, Integer> map = new LinkedHashMap<>();
    Character charac = ' ';

    var array = str.trim().toCharArray();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i]))
        map.put(array[i], map.get(array[i]) + 1);
      else
        map.put(array[i], 1);
    }
    int max = Integer.MIN_VALUE;
    for (var ch : map.entrySet())
      if (ch.getValue() > max) {
        max = ch.getValue();
        charac = ch.getKey();
      }

    return charac;
  }

  public static Character getMostOccuringCharacter(String str) {
    if (str.isEmpty() || str == null)
      throw new IllegalArgumentException();

    final int ASCII_SIZE = 256;
    var frequencies = new int[ASCII_SIZE];

    for (char ch : str.toCharArray())
      frequencies[ch]++;

    var max = Integer.MIN_VALUE;
    Character result = ' ';

    for (int i = 0; i < frequencies.length; i++)
      if (max > frequencies[i]) {
        max = frequencies[i];
        result = (char) i;
      }

    return result;
  }

  public static String capitalizeString(String str) {
    if (str == null || str.isEmpty())
      throw new IllegalArgumentException();

    if (str.trim().isEmpty())
      return "";

    var array = str.trim().replaceAll(" +", " ").split(" ");
    StringBuilder string = new StringBuilder();

    for (int words = 0; words < array.length; words++) {
      var upperCase = Character.toUpperCase(array[words].charAt(0));
      string.append(array[words].toLowerCase().replace(array[words].charAt(0), upperCase) + " ");
    }

    return string.substring(0, string.length() - 1).toString();
  }

  // O(n log n)
  public static boolean areAnagrams(String first, String second) {
    if (first == null || second == null || first.length() != second.length())
      return false;

    var array1 = first.toLowerCase().toCharArray(); // O(n)
    var array2 = second.toLowerCase().toCharArray(); // O(n)

    Arrays.sort(array1); // O(n log n)
    Arrays.sort(array2); // O(n log n)

    return Arrays.equals(array1, array2);
  }

  // O(n)
  public static boolean areAnagrams2(String first, String second) {
    if (first == null || second == null || first.length() != second.length())
      return false;

    final int ENGLISH_ALPHABETS = 26;
    var frequencies = new int[ENGLISH_ALPHABETS];

    first = first.toLowerCase(); // O(n)
    for (int i = 0; i < first.length(); i++) // O(n)
      frequencies[first.charAt(i) - 'a']++; // 97

    second = second.toLowerCase(); // O(n)
    for (int i = 0; i < second.length(); i++) // O(n)
      if (frequencies[second.charAt(i) - 'a']-- == 0)
        return false;

    return true;
  }

  public static boolean isPalindrome(String str) {
    if (str == null)
      return false;
    StringBuilder string = new StringBuilder();

    string.append(str);

    return str.equals(string.reverse().toString());
  }

  // optimized solution
  public static boolean isStringPalindrome(String str) {
    if (str == null)
      return false;

    int left = 0, right = str.length() - 1;
    var array = str.toCharArray();

    while (true) {
      if (left > right)
        return true;
      if (array[left++] != array[right--])
        return false;
    }
  }
}