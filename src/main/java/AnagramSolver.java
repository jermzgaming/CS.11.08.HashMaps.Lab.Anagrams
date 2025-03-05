import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename)  {
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    char[] chars = word.toCharArray();
                    java.util.Arrays.sort(chars);
                    String key = new String(chars);
                    anagrams.putIfAbsent(key, new ArrayList<>());
                    anagrams.get(key).add(word);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            return null;
        }

        return anagrams;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> list = new ArrayList<>();

        for (ArrayList<String> anagramList : anagrams.values()) {
            if (anagramList.size() > list.size()) {
                list = anagramList;
            }
        }

        return list;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        String[] keys = new String[anagrams.size()];
        anagrams.keySet().toArray(keys);

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            ArrayList<String> words = anagrams.get(key);
            System.out.println("Key: " + key + " Anagrams: " + words);
        }
    }

}
