package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class File {

    private Path path;
    private Charset charset = StandardCharsets.UTF_8; 

    public File(String filePath) {
        this.path = Paths.get(filePath);
    }

    Path getPath() {
        return this.path;
    }

    void create() throws IOException {
        if (checkForFile())
            return;

        Files.createFile(this.path);
    }

    private boolean checkForFile() {
        if (Files.exists(this.path))
            return true;
        else
            return false;
    }



    void write(String stringToWrite) throws IOException {
        if (!checkForFile())
            create();

        String fileContents = Files.readString(this.path, charset);
        fileContents = fileContents.concat(stringToWrite);
        Files.write(this.path, fileContents.getBytes(charset));
    }

    String read() throws IOException {
        if (!checkForFile())
            return null;

        String fileContents = Files.readString(this.path, charset);
        return fileContents;
    }

    void remove(String stringToRemove) throws IOException{
        if (!checkForFile())
            return;

        String fileContents = Files.readString(this.path, charset);
        fileContents = fileContents.replace(stringToRemove, "");
        Files.write(this.path, fileContents.getBytes(charset));
    }

    void erase() throws IOException{
        if (!checkForFile())
            return;

        Files.delete(this.path);
        Files.createFile(this.path);
    }

    void delete() throws IOException {
        if (!checkForFile())
            return;

        Files.delete(this.path);
    }


    
}
