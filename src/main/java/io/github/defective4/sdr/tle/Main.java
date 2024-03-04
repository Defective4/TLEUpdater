package io.github.defective4.sdr.tle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: " + Main.class.getProtectionDomain()
                                                     .getCodeSource()
                                                     .getLocation()
                                                     .getFile() + " <NORAD IDs...>");
            System.exit(1);
        }

        List<String> tle = new ArrayList<>();

        for (String id : args) {
            try {
                System.err.println("Parsing " + id + "...");
                Document doc = Jsoup.parse(new URL("https://isstracker.pl/en/satelity/" + id), 10000);
                Element textArea = doc.getElementById("tle-details");
                tle.add(textArea.html());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tle.forEach(System.out::println);
        System.err.println();
        System.err.printf("Parsed %s/%s IDs%n", tle.size(), args.length);
    }
}
