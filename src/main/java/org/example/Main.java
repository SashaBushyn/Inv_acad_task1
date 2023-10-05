package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    String input1 = "aa aa odg dog gdo";
    String input2 = "a c b c run urn urn";

    System.out.println("Input: \"" + input1 + "\"");
    System.out.println("Output: " + arrayChallenge(input1));

    System.out.println();

    System.out.println("Input: \"" + input2 + "\"");
    System.out.println("Output: " + arrayChallenge(input2));
  }

  public static int arrayChallenge(String str) {
    Set<String> uniqWords = Arrays.stream(str.split(" "))
        .filter(word -> word.length() > 1)
        .collect(Collectors.toSet());

    Map<String, Integer> wordsMap = new HashMap<>();

    for (String word : uniqWords) {
      char[] charArray = word.toCharArray();
      Arrays.sort(charArray);
      String sortedWord = new String(charArray);
      wordsMap.merge(sortedWord,0,(v1,v2)->v1+1);
    }
    return wordsMap.values().stream().mapToInt(Integer::intValue).sum();
  }
}
