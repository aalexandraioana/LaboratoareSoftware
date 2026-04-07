package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Objects;

public class StudentiBursieri extends Student
{
    double cuantumBursa;

    public StudentiBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuatumBursa)
    {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuatumBursa;
    }

    public String toString()
    {
        return super.toString() + String.format("%15.2f", this.cuantumBursa);
    }

    public boolean equals(Object o)
    {
        StudentiBursieri b = (StudentiBursieri) o;
        return super.equals(b) && this.cuantumBursa == b.cuantumBursa;
    }

    public int hashCode()
    {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    public static void writeToFile(String filename, Collection<? extends Student> mapBursieri)
    {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename))))
        {
            for (Student s : mapBursieri)
            {
                writer.println(s.toString());
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }


}
