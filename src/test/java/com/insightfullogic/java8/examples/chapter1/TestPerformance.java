package com.insightfullogic.java8.examples.chapter1;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.insightfullogic.java8.examples.chapter1.SampleData.theBeatles;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.Assert.assertEquals;

public class TestPerformance {

    @Test
    public void allMembers() {
        com.insightfullogic.java8.examples.chapter1.Album album = new com.insightfullogic.java8.examples.chapter1.Album("foo", Collections.<Track>emptyList(), singletonList(theBeatles));
        Set<com.insightfullogic.java8.examples.chapter1.Artist> musicians = album.getAllMusicians().collect(toSet());
        Set<com.insightfullogic.java8.examples.chapter1.Artist> expectedMusicians = new HashSet<>(com.insightfullogic.java8.examples.chapter1.SampleData.membersOfTheBeatles);
        expectedMusicians.add(theBeatles);
        assertEquals(expectedMusicians, musicians);
    }

}
