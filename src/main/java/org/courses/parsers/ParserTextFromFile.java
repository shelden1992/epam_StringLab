package org.courses.parsers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserTextFromFile {
    private static Logger LOG = Logger.getLogger(ParserTextFromFile.class);
    private static Path pathRead = Paths.get("/Users/macuser/Desktop/projects/epamEducation/epam_StringLaboratory/src/main/resources/BookForProgramming");

    public String parseTextFromFile() {

        String text = "";
        try {
            text = new String(Files.readAllBytes(pathRead), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOG.error(e);

        }
        return text;
    }

}
