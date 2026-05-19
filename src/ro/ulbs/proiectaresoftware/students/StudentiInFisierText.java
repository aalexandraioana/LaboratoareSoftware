package ro.ulbs.proiectaresoftware.students;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport
{
    private final String numeFisier;

    public StudentiInFisierText(String numeFisier)
    {
        this.numeFisier = numeFisier;
    }
   @Override
        public void doExport(List<Student> studenti)
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier)))
            {
                writer.write(String.format("%-15s %-20s %-20s %-20s %-15s", "Numar matricol", "Prenume","Nume", "Formatie de studiu", "Nota"));
                writer.newLine();

                for(Student s : studenti)
                {

                    writer.write(String.format("%-15d %-20s %-20s %-20s %-15.2f%n", s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), s.getNota()));

                }
                //Varianta cu stream-uri
                /*studenti.stream().
                        forEach(s -> {try {writer.write(String.format("%-15d %-20s %-20s %-20s %-15.2f%n", s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), s.getNota()));}
                        catch(IOException e) {e.printStackTrace();}
                        }
);*/
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

