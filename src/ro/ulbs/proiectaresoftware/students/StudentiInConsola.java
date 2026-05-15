package ro.ulbs.proiectaresoftware.students;
import java.util.List;

public class StudentiInConsola implements IStudentiExport
{
    public void doExport(List<Student> studenti)
    {
        System.out.println("Studenti exportati in consola...");


        System.out.println(String.format("%-15s %-20s %-20s %-20s %-15s", "Numar matricol", "Prenume","Nume", "Formatie de studiu", "Nota"));
        for(Student s : studenti)
        {

            //System.out.println("%-15s %-20s %-20s %-15s %-10s", "Numar matricol", "Prenume","Nume", "Formatie de studiu", "Nota");
            System.out.printf("%-15d %-20s %-20s %-20s %-15.2f%n", s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), s.getNota());

        }
    }
}
