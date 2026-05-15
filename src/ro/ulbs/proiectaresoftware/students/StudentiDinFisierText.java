package ro.ulbs.proiectaresoftware.students;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentiDinFisierText implements IStudentiImport
{
    private final String numeFisier;

    public StudentiDinFisierText(String numeFisier)
    {
        this.numeFisier = numeFisier;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(numeFisier))) {

            if (scanner.hasNextLine())
            {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                int numarMatricolCurent = Integer.parseInt(line.substring(0, 16).trim());
                String prenumeCurent = line.substring(16, 37).trim();
                String numeCurent = line.substring(37, 58).trim();
                String formatieDeStudiuCurenta = line.substring(58, 79).trim();
                double notaCurenta = Double.parseDouble(line.substring(79).trim());

                studenti.add(new Student(numarMatricolCurent, prenumeCurent, numeCurent, formatieDeStudiuCurenta, notaCurenta));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studenti;

    }
}
