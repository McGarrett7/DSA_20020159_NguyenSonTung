package Week8;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Table {

    public void count(String input) {
        input = input.replaceAll(Pattern.quote(",") , "");
        input = input.replaceAll(Pattern.quote("."), "");
        String[] words = input.split(Pattern.quote(" "));
        useTreeMap(words);
    }

    public void useTreeMap(String[] words){
        Map<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word,1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("F:\\CodeUET\\Java\\DSA\\Exercise\\src\\Week8\\Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String input = br.readLine();
        Table countWord = new Table();
        countWord.count(input);
    }
}