package com.example.task11;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class App {
    private String inputFile;
    private String outputFile;
    public App(@Value("${inputFile}") String inputFile, @Value("${outputFile}") String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @PostConstruct
    public void init() throws IOException, NoSuchAlgorithmException {
        File input = new File(outputFile);
        if (!input.exists()) {
            FileWriter writer = new FileWriter(inputFile);
            writer.write("null");
            writer.close();
        }
        else {
            String data = readFile(input);
            String hash = hash(data);
            writeFile(inputFile, hash);
            input.delete();
        }
    }

    @PreDestroy
    public void destroy() throws IOException, NoSuchAlgorithmException {
        String data = readFile(new File(outputFile));
        writeFile(inputFile, data);
        new File(outputFile).delete();
    }

    private String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    private void writeFile(String file, String data) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.close();
    }

    private String hash(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}