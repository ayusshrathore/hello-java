import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        // Key: Employee Number (Integer)
        // Value: Employee Name (String)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alex");
        map.put(2, "John");
        map.put(3, "May");
        map.put(3, "Marianne"); // Overwrites previous value since Hash Map doesn't store duplicate values, also
        map.put(null, null); // Hash Map allows null key & values.
        map.remove(null);
        System.out.println(map.get(2)); // return the value (of <String> type)
        System.out.println(map);
        System.out.println(map.containsKey(3)); // O(1) since Hash Map takes the key and checks if the there is a
        // corresponding value for that particular memory address & if presents returns
        // true

        System.out.println(map.containsValue("John")); // O(n) as there is no refrence for the key Hash Map can't rely
        // on Hash Table & will iterate over the entire array for the value

        for (var item : map.keySet()) {
            System.out.println(item);
        }

        for (var value : map.entrySet()) {
            System.out.println(value);
        }

        // First Non repeated character
        // var string = "A Green Apple";
        var string = "The quick brown fox jumps over the lazy dog";
        System.out.println(findFirstNonRepeatedChar(string));

        // First repeated character
        System.out.println(findFirstRepeatedChar(string));
        System.out.println(getFirstRepeatedChar(string));

        // Sets inbuilt implementation (HashSet)
        Set<Integer> set = new HashSet<>();
        int[] numbers = { 2, 2, 3, 4, 5, 4 };
        for (var number : numbers)
            set.add(number);
        set.remove(2);
        System.out.println(set.contains(4));
        System.out.println(set);

        // Hash functions
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put(0, "VSCODE");
        map2.put("4342342-A", "VSCODE");
        System.out.println(hash(1456646));
        System.out.println(hashWithString("4342342-A"));

        // Custom implementation of Hash Tables
        HashTables hashTables = new HashTables(100);
        hashTables.put(200, "Aarav");
        System.out.println(hashTables.get(200));
        hashTables.put(300, "Mishra");
        System.out.println(hashTables.get(300));
        hashTables.remove(300);
        System.out.println(hashTables.size());
        // System.out.println(hashTables.get(300));

        // Find the most repeated element in an array of integers. What is the
        // time complexity of this method? (A variation of this exercise is finding
        // the most repeated word in a sentence. The algorithm is the same.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial size for the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Enter array elemets: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(findMostFrequentElement(array));

        // Given an array of integers, count the number of unique pairs of integers
        // that have difference k.
        System.out.println(countWithDiff(array, 2));

        // Given an array of integers, return indices of the two numbers such
        // that they add up to a specific target.
        var result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(result));
        scanner.close();

        // Build a hash table from scratch. Use linear probing strategy for
        // handling collisions. Implement the following operations:
        // - put(int, String)
        // - get(int)
        // - remove(int)
        // - size()
        HashMaps hashMaps = new HashMaps(100);
        hashMaps.put(100, "LOKI");
        System.out.println(hashMaps.get(100));
        hashMaps.remove(100);
        System.out.println(hashMaps.size());
        // System.out.println(hashMaps.get(100));
        hashMaps.put(200, "THOR");
        hashMaps.put(300, "IRON MAN");
        System.out.println(hashMaps.get(200));
        System.out.println(hashMaps.get(300));
        System.out.println(hashMaps.toString());
    }

    static int hash(int number) {
        return number % 100;
    }

    static int hashWithString(String string) {
        int hash = 0;
        for (var ch : string.toCharArray())
            hash += ch; // implicit typecasting since hash is defined as int, so ch is internally
        // converted first into integer (+= -> augmented assignment 4operator)

        return hash % 100;
    }

    static char findFirstNonRepeatedChar(String string) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = string.toCharArray();
        for (var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    static char findFirstRepeatedChar(String string) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = string.toCharArray();
        for (var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : chars)
            if (map.get(ch) == 2)
                return ch;

        return Character.MIN_VALUE;
    }

    // alternative way for finding first repeadted char
    static char getFirstRepeatedChar(String string) {
        Set<Character> charSet = new HashSet<>();

        var chars = string.toCharArray();
        for (var ch : chars) {
            if (charSet.contains(ch))
                return ch;

            charSet.add(ch);

        }
        return Character.MIN_VALUE;
    }

    // Runtime complexity: O(n)
    static int findMostFrequentElement(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var key : array) {
            var count = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, count + 1);
        }

        int occurence = 1;
        var mostOccured = -1;
        for (var key : map.keySet())
            if (occurence < map.get(key)) {
                occurence = map.get(key);
                mostOccured = key;
            }

        return mostOccured;
    }

    // Runtime complexity: O(n)
    // b = a + k (diff)
    // b = a - k (diff)
    static int countWithDiff(int[] numbers, int k) {
        Set<Integer> set = new HashSet<>();
        var count = 0;

        for (var number : numbers)
            set.add(number);

        for (var number : numbers) {
            if (set.contains(number + k))
                count++;
            if (set.contains(number - k))
                count++;
            set.remove(number);
        }
        return count;
    }

    // Runtime complexity: O(n)
    static int[] twoSum(int[] numbers, int target) {
        Set<Integer> set = new HashSet<>();

        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(target - numbers[i]) && i < indices.length)
                indices[i] = i;

            set.add(numbers[i]);
        }

        return indices;
    }

    // Runtime complexity: O(n)
    static int[] getTwoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            var complement = target - numbers[i];
            if (map.containsKey(complement))
                return new int[] { map.get(complement), i };

            map.put(numbers[i], i);
        }

        return null;
    }
}