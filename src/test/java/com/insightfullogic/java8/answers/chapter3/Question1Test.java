package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import com.insightfullogic.java8.answers.chapter3.Question1;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.insightfullogic.java8.examples.chapter1.SampleData.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Question1Test {

    /**
     * 1. 常用流操作。实现如下函数：
     * a. 编 写 一 个 求 和 函 数， 计 算 流 中 所 有 数 之 和。 例 如，int addUp(Stream<Integer> numbers)；
     * b. 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的 姓名和国籍；
     * c. 编写一个函数，接受专辑列表作为参数，返回一个由最多包含 3 首歌曲的专辑组成的 列表。
     */
    @Test
    public void addsIntSum(){
        Integer reduce = Stream.of(1, 2, 3).reduce(3, (csc, x) -> csc + x);
        System.out.println( reduce);
//        System.out.println( reduce.get());

    }
    @Test
    public void findsShortAlbumsTest(){
        new ArrayList<Album>().stream()
                .filter(album -> album.getTrackList().size()>3)
                .collect(Collectors.toList());


    }


    @Test
    public void artist(){
        List<Artist> artistList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            artistList.add(new Artist("name"+i,new ArrayList<Artist>(),"origins"+i));
        }

         artistList.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList()).forEach(s-> System.out.println(s));

    }

    @Test
    public void addsEmptyList() {
        int result = com.insightfullogic.java8.answers.chapter3.Question1.addUp(Stream.empty());
        assertEquals(0, result);
    }

    @Test
    public void addsListWithValues() {
        int result = com.insightfullogic.java8.answers.chapter3.Question1.addUp(Stream.of(1, 3, -2));
        assertEquals(2, result);
    }

    @Test
    public void extractsNamesAndOriginsOfArtists() {
        List<String> namesAndOrigins = com.insightfullogic.java8.answers.chapter3.Question1.getNamesAndOrigins(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
    }

    @Test
    public void findsShortAlbums() {
        List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
        List<Album> result = Question1.getAlbumsWithAtMostThreeTracks(input);
        assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
    }

}
