package inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TextProcessor {
  public static void main(String[] args) throws IOException {
    Path p = Paths.get(args[0]);
    File f = p.toFile();

    Map<String, Integer> wordFrequency = new HashMap<>();

    InputStream is = new FileInputStream(f);
    FileReader fr = new FileReader(f);
    BufferedReader bfr = new BufferedReader(fr);

    String line;

    int wordCount = 0;

    while ((line = bfr.readLine()) != null) {
      System.out.printf("%s \n", line.toUpperCase());
      String[] words = line.split(" ");
      wordCount += words.length;
      for (String s : words) {
        String w = s.toLowerCase();
        if (!wordFrequency.containsKey(w)) {
          // if word is not in the map, put a new key-value pair
          wordFrequency.put(w, 1);
        } else {
          // get the value from using word as the key and increment it
          int c = wordFrequency.get(w) + 1;
          // put it back in the hashmap
          wordFrequency.put(w, c);
        }
      }
    }

    Set<String> words = wordFrequency.keySet();
    for (String w : words) {
      int c = wordFrequency.get(w);
      System.out.printf("%s: %d \n", w, c);
    }

    System.out.printf("Word Count: %d \n", wordCount);

    bfr.close();
    fr.close();
    is.close();
   }
}
