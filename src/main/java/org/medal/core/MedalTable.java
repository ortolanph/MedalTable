package org.medal.core;

import org.medal.data.MedalTableParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MedalTable {

    public static void main(String[] args) throws IOException, URISyntaxException {
        MedalTableParser parser = new MedalTableParser();

        parser
                .parseData("rio2016-09-Aug-2016.csv")
                .stream()
                .sorted((s1, s2) -> s1.getCountry().compareTo(s2.getCountry()))
                .sorted((s1, s2) -> s2.getBronze() - s1.getBronze())
                .sorted((s1, s2) -> s2.getSilver() - s1.getSilver())
                .sorted((s1, s2) -> s2.getGold() - s1.getGold())
                .forEach(s -> System.out.println(s.toString()));
    }

}
