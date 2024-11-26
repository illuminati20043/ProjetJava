package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final String LOG_FILE = "game_log.txt";

    public static void logEvent(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}