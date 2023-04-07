import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Read the CSV file
        File csvFile = new File("out/production/CSV2XML/pokemon.csv");
        Scanner scanner = new Scanner(new FileReader(csvFile));

        // Create an XML document
        PrintWriter writer = new PrintWriter("data.xml");
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<data>");

        // Iterate over the CSV file
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");

            // Write the data to the XML document
            writer.println("<row>");
            writer.println("<Name>" + line[0] + "</Name>");
            writer.println("<Type 1>" + line[1] + "</Type 1>");
            writer.println("<Type 2>" + line[2] + "</Type 2>");
            writer.println("<Total>" + line[3] + "</Total>");
            writer.println("<HP>" + line[4] + "</HP>");
            writer.println("<Attack>" + line[5] + "</Attack>");
            writer.println("<Defense>" + line[6] + "</Defense>");
            writer.println("<Sp. Atk>" + line[7] + "</Sp. Atk>");
            writer.println("<Sp. Def>" + line[8] + "</Sp. Def>");
            writer.println("<Speed>" + line[9] + "</Speed>");
            writer.println("<Generation>" + line[10] + "</Generation>");
            writer.println("<Legendary>" + line[11] + "</Legendary>");
            writer.println("</row>");
        }



        // Close the XML document
        writer.println("</data>");
        writer.close();

        // Display all of the columns of the XML document back to the user
        System.out.println("The columns of the XML document are:");

        // Iterate over the XML document
        try (Scanner scanner2 = new Scanner(new FileReader("data.xml"))) {
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();

                // Split the line into columns
                String[] columns = line.split(",");

                // Print all of the columns
                for (String column : columns) {
                    System.out.print(column + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}