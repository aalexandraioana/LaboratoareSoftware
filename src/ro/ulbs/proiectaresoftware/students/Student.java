package ro.ulbs.proiectaresoftware.students;
import java.util.*;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
    double nota;

    public Student (int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota)
    {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

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

    public void setNota (double nota)
    {
        this.nota = nota;
    }

    public double getNota()
    {
        return this.nota;
    }

    public String toString()
    {
        return String.format("%15d %20s %s %17.2f", this.numarMatricol, this.prenume + " " + this.nume, this.formatieDeStudiu, this.nota);
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
        return (s.numarMatricol == this.numarMatricol) && s.nume.equals(this.nume) && s.prenume.equals(this.prenume) && s.formatieDeStudiu.equals(this.formatieDeStudiu) && (s.nota == this.nota);
    }

    public int hashCode()
    {
        return Objects.hash(numarMatricol, nume, prenume, formatieDeStudiu, nota);
    }

    public boolean verifPrezenta2 (Set<Student> set)
    {
        return set.contains(this);
    }

    public boolean verifPrezenta3 (List<Student> lista)
    {
        return lista.contains(this);
    }

    public static double gasesteNota(String prenume, String nume, Map<String, Student>mapStudenti)
    {
        HashMap<String, Student>mapStudentiIntern = new HashMap<>();

        for (Student s : mapStudenti.values())
        {
            mapStudentiIntern.put(s.getPrenume() + s.getNume(), s);
        }

        Student cautaStudent = mapStudentiIntern.get(prenume + nume);

        if (cautaStudent != null)
        {
            return cautaStudent.getNota();
        }
        else
            return 0.0;
    }


}
