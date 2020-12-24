package sample.services;

import javafx.collections.ObservableList;
import sample.Main;
import sample.models.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileWorker {
    public static void write(Note note) {
        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter("data.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter1);
            String text = getCurrentText(note.getText());
            String resultLine = note.getId() + " " + note.getName() + " " + text + " " + note.getCategory() + " " + note.isDeleted() + "\n";
            Main.lengths.add(resultLine.length());
            bufferWriter.write(resultLine);
            bufferWriter.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String getCurrentText(String text) {
        String a = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                a += "\t";
            } else if (text.charAt(i) == ' ') {
                a += "\f";
            } else {
                a += text.charAt(i);
            }
        }
        return a;
    }

    public static void writeAll(ObservableList<Note> notes, ArrayList<Note> deletedNotes) {
        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(new File("data.txt"), false);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter1);
            for (Note note : notes) {
                String text = getCurrentText(note.getText());
                String resultLine = note.getId() + " " + note.getName() + " " + text + " " + note.getCategory() + " " + note.isDeleted() + "\n";
                Main.lengths.add(resultLine.length());
                bufferWriter.write(resultLine);
            }
            bufferWriter.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
