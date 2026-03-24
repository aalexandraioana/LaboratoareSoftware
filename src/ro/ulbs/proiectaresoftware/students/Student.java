package ro.ulbs.proiectaresoftware.students;
import java.util.*;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    public Student (int numarMatricol, String prenume, String nume, String formatieDeStudiu)
    {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol ()
    {
        return this.numarMatricol;
    }

    public String getPrenume()
    {
        return this.prenume;
    }

    public String getNume()
    {
        return this.nume;
    }

    public String getFormatieDeStudiu()
    {
        return this.formatieDeStudiu;
    }

    public String toString()
    {
        return String.format("%15d %20s %s", this.numarMatricol, this.prenume + " " + this.nume, this.formatieDeStudiu);
    }

    public boolean verifPrezenta(List<Student> lista)
    {
        for (Student s : lista)
        {
            if((s.numarMatricol == this.numarMatricol) && s.nume.equals(this.nume) && s.prenume.equals(this.prenume) && s.formatieDeStudiu.equals(this.formatieDeStudiu))
                return true;
        }

        return false;
    }

    public boolean equals(Object o)
    {
        Student s = (Student) o;
        return (s.numarMatricol == this.numarMatricol) && s.nume.equals(this.nume) && s.prenume.equals(this.prenume) && s.formatieDeStudiu.equals(this.formatieDeStudiu);
    }

    public int hashCode()
    {
        return Objects.hash(numarMatricol, nume, prenume, formatieDeStudiu);
    }

    public boolean verifPrezenta2 (Set<Student> set)
    {
        return set.contains(this);
    }

    public boolean verifPrezenta3 (List<Student> lista)
    {
        return lista.contains(this);
    }


}
