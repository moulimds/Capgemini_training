package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Students;

public class FileUtility {

    private static final String FILE_NAME = "data/students.txt";

    // Write students to text file using NIO
    public static void writeText(ArrayList<Students> students) {

        Path path = Paths.get(FILE_NAME);

        try {

            // Create data folder if it doesn't exist
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            List<String> lines = new ArrayList<>();

            for (Students student : students) {
                lines.add(student.toFileString());
            }

            Files.write(path, lines);

            System.out.println("Students saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving file.");
            e.printStackTrace();

        }

    }

    // Read students from text file using NIO
    public static ArrayList<Students> readText() {

        ArrayList<Students> students = new ArrayList<>();

        Path path = Paths.get(FILE_NAME);

        try {

            if (!Files.exists(path)) {
                return students;
            }

            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                String[] data = line.split(",");

                Students student = new Students(

                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        Double.parseDouble(data[8])

                );

                students.add(student);

            }

        } catch (IOException e) {

            System.out.println("Error while reading file.");
            e.printStackTrace();

        }

        return students;

    }

}