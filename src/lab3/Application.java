package lab3;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application
{
    public static void main()
    {
        Path inPath = Paths.get("in.txt");
        Path outPath = Paths.get("out.txt");
        try
        {
            List<String> lista1 = new ArrayList<String>();
            List<String> lista2 = new ArrayList<String>();

            String inputText = "";
            try (Scanner scanner = new Scanner(inPath)) {
                while (scanner.hasNextLine()) {
                    //System.out.println(scanner.nextLine());
                    inputText += scanner.nextLine() + "\n";

                }
                String[] inputLine = inputText.split("\\\\n");
                String[] sentences = inputText.split("\\.");

                for (String i : inputLine)
                {
                    lista1.add(i);
                    System.out.println(i);
                }
                for (String i : sentences)
                {
                    String p = i + ".";
                    lista2.add(p);
                    System.out.println(p);
                }
                Files.write(outPath, lista1);
                Files.write(outPath, lista2, StandardOpenOption.APPEND);
            }
        }
            catch (IOException e)
            {
                e.printStackTrace();
            }



    }


}
