package org.medal.data;

import org.medal.entity.MedalShelf;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MedalTableParser {

    public List<MedalShelf> parseData(String fileName) throws IOException, URISyntaxException {
        return Files.lines(getFilePath(fileName)).map(shelf -> convertToMedalShelf(shelf)).collect(Collectors.toList());
    }

    public Path getFilePath(String fileName) throws URISyntaxException {
        return Paths.get(ClassLoader.getSystemResource(fileName).toURI());
    }

    private MedalShelf convertToMedalShelf(String record) {
        String[] fields = record.split(",");

        return new MedalShelf(
                fields[0],
                Integer.valueOf(fields[1]),
                Integer.valueOf(fields[2]),
                Integer.valueOf(fields[3]));
    }

}
