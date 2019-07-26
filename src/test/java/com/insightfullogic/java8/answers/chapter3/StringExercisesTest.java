package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.answers.chapter3.StringExercises;
import org.junit.Test;

import javax.crypto.Mac;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StringExercisesTest {
    /**
     * . 计算一个字符串中小写字母的个数（提示：参阅 String 对象的 chars 方法）
     */
    @Test
    public  void lowercaseLetter(){
        long count = "asdasdGJHGKUG".chars()
                .filter(Character::isLowerCase)
                .count();
        System.out.println(count);


    }
public static  long lowercaseLetter1(String s){
        long count = s.chars()
                .filter(Character::isLowerCase)
                .count();
        System.out.println(count);
      return count ;

    }

    /**
     * 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回 Optional <String> 对象。
     */
    @Test
    public void findMoreLowerCase(){
        Optional<String> max = Arrays.asList("a", "abc", "ABCde").stream()
                .max(Comparator.comparing(StringExercisesTest::lowercaseLetter1));
        System.out.println("res:"+ max.get());
    }

    @Test
    public void noLowercaseLettersInAnEmptyString() {
        assertEquals(0, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void countsLowercaseLetterExample() {
        assertEquals(3, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void suppoertsNoLowercaseLetters() {
        assertEquals(0, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() {
        assertFalse(com.insightfullogic.java8.answers.chapter3.StringExercises.mostLowercaseString(Collections.<String>emptyList()).isPresent());
    }

    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }

}
