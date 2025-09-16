import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/*
    Category = Strings
    Difficulty = Medium

    Write a function that takes in an array of strings and groups anagrams together.
    Anagrams are strings made up of exactly the same letters, where order doesn't matter. For example, "cinema" and
    "iceman" are anagrams; similarly, "foo" and "ofo" are anagrams.

    Your function should return a list of anagram groups in no particular order.

    Sample Input
    words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]

    Sample Output
    [l"yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]

    Optimal Space & Time Complexity
    O(w* n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word
*/

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        System.out.println(groupAnagrams(inputList));
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.

        int idx1 = 0, idx2;

        List<List<String>> anagramGroups = new ArrayList<>();

        BiPredicate<String, String> isAnagram = (str1, str2) -> {
            String combinedStr = str1 + str2;
            return str1.length() == str2.length()
                    && combinedStr.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .values()
                    .stream()
                    .allMatch(v -> v % 2 == 0);
        };

        while (idx1 < words.size()) {
            var subList = new ArrayList<String>();
            String str1 = words.get(idx1);
            subList.add(str1);
            idx2 = idx1 + 1;
            while (idx2 < words.size()) {
                String str2 = words.get(idx2);
                if (isAnagram.test(str1, str2)) {
                    subList.add(str2);
                    words.remove(idx2);
                } else
                    idx2++;
            }
            anagramGroups.add(subList);
            words.remove(idx1);
        }

        return anagramGroups;
    }
}
