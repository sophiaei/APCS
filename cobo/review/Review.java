import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  public static double totalSentiment(String fileName) {
    String[] words = textToString(fileName).split(SPACE);
    double totalSentiment = 0;
    for (String word : words) {
        word = removePunctuation(word);
        totalSentiment += sentimentVal(word);
    }
    return totalSentiment;
  }

  public static int starRating(String fileName) {
      double sentiment = totalSentiment(fileName);
      for (int i = -1; i < 4; i++) {
          if (sentiment / 4 <= i) {
              return i + 2;
          }
      }
      return 3;
  }

  public static String fakeReview(String fileName) {
    String fake = textToString(fileName);
    while (fake.indexOf("*") != -1) {
        String finished = fake.substring(0, fake.indexOf("*"));
        String unfinished = fake.substring(fake.indexOf(SPACE, fake.indexOf("*")));
        String word = removePunctuation(fake.substring(fake.indexOf("*") + 1, fake.indexOf(SPACE, fake.indexOf("*"))));
        if (posAdjectives.contains(word)) {
            fake = finished + randomPositiveAdj(word) + unfinished;
        }
        else if (negAdjectives.contains(word)) {
            fake = finished + randomNegativeAdj(word) + unfinished;
        }
        else {
            return "Unable to generate fake review because certain starred adjectives are not found in either file";
        }
    }
    return fake;
  }

  public static String randomPositiveAdj(String excluded) {
    int index = (int) (Math.random() * posAdjectives.size());
    int excludedIndex = posAdjectives.indexOf(excluded);
    while (index == excludedIndex) {
        index = (int) (Math.random() * posAdjectives.size());
    }
    return posAdjectives.get(index);
  }

  public static String randomNegativeAdj(String excluded) {
    int index = (int) (Math.random() * negAdjectives.size());
    int excludedIndex = negAdjectives.indexOf(excluded);
    while (index == excludedIndex) {
        index = (int) (Math.random() * negAdjectives.size());
    }
    return negAdjectives.get(index);
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  public static void main(String[] args) {
      System.out.println(sentimentVal("ability"));
      System.out.println(sentimentVal("academic"));
      System.out.println(sentimentVal("absolute"));

      System.out.println(totalSentiment("SimpleReview.txt"));

      System.out.println(starRating("SimpleReview.txt"));
      System.out.println(starRating("YelpReview1(5S).txt"));
      System.out.println(starRating("YelpReview2(1S).txt"));

      System.out.println(fakeReview("SimpleReview.txt"));
  }
}