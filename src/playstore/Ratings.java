package playstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Ratings {
  public static void main(String[] args) throws IOException {
    Path p = Paths.get(args[0]);
    File f = p.toFile();

    Map<String, Integer> categoryCount = new HashMap<>();
    Map<String, Double> categoryRatings = new HashMap<>();
    Map<String, Double> categoryAverage = new HashMap<>();

    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);

    // stolen from stackoverflow:
    String otherThanQuote = " [^\"] ";
    String quotedString = String.format(" \" %s* \" ", otherThanQuote);
    String regex = String.format("(?x)" + // enable comments, ignore white spaces
        "," + // match a comma
        "(?=" + // start positive look ahead
        "(?:" + // start non-capturing group 1
        "%s*" + // match 'otherThanQuote' zero or more times
        "%s" + // match 'quotedString'
        ")*" + // end group 1 and repeat it zero or more times
        "%s*" + // match 'otherThanQuote'
        "$" + // match the end of the string
        ")", // stop positive look ahead
        otherThanQuote, quotedString, otherThanQuote);

    br.readLine(); // to skip the first line of headings
    String line;

    // needs to look out for quotes, and ignore text in quotes.
    while ((line = br.readLine()) != null) {
      String[] columnData = line.split(regex);
      String category = columnData[1];
      boolean isInvalidRating = columnData[2].equalsIgnoreCase("NaN");
      double rating = isInvalidRating ? 0.0 : Double.parseDouble(columnData[2]);

      // System.out.println(isInvalidRating);
      if (!isInvalidRating) {
        if (!categoryCount.containsKey(category)) {
          categoryCount.put(category, 1);
        } else {
          int c = categoryCount.get(category) + 1;
          categoryCount.put(category, c);
        }

        if (!categoryRatings.containsKey(category)) {
          categoryRatings.put(category, rating);
          // System.out.println(rating);
        } else {
          double c = categoryRatings.get(category) + rating;
          categoryRatings.put(category, c);
          // System.out.println(c);
        }

        if (!categoryAverage.containsKey(category)) {
          categoryAverage.put(category, 0.0);
        }
      }
    }
    // System.out.println(categoryCount);
    // System.out.println(categoryRatings);
    // System.out.println(categoryAverage);

    for (String name : categoryAverage.keySet()) {
      // System.out.println("TOTAL STARS: " + categoryRatings.get(name));
      // System.out.println("TOTAL APPS: " + categoryCount.get(name));
      double average = (double) (categoryRatings.get(name) / categoryCount.get(name));
      // System.out.println(average);
      categoryAverage.put(name, average);
      System.out.printf("The average rating for %s is %f. \n", name, categoryAverage.get(name));
    }

    br.close();
    fr.close();
  }
}
