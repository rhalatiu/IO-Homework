package school.siit;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF8");
        Path file = Paths.get("test.txt");
        ArrayList<Athlete> athletes = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                athletes.add(new Athlete(line));
            }
        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }

        for (int i=0; i<athletes.size(); i++)
            System.out.println(athletes.get(i));
        System.out.println();
        Collections.sort(athletes, new TimeComparator());
        for (int i=0; i<athletes.size(); i++)
            System.out.println(athletes.get(i));
    }
}