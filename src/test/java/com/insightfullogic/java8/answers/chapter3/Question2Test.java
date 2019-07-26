package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.insightfullogic.java8.answers.chapter3.Question2.countBandMembersInternal;
import static org.junit.Assert.assertEquals;

public class Question2Test {

    /**
     * 2. 迭代。修改如下代码，将外部迭代转换成内部迭代：
     * int totalMembers = 0;
     * for (Artist artist : artists) {
     * Stream<Artist> members = artist.getMembers();
     * totalMembers += members.count();
     * }
     */
    @Test
    public void iternal2(){
        Long aLong = Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)
                .stream()
                .map(artist -> artist.getMembers().count())
                .reduce((css, c) -> css + c).get();
        System.out.println(aLong);

    }

    @Test
    public void internal() {
        assertEquals(4, countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

}
