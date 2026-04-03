package ro.ulbs.proiectaresoftware.students;
import lab4.Tanar;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static ro.ulbs.proiectaresoftware.students.Student.gasesteNota;
import static ro.ulbs.proiectaresoftware.students.StudentiBursieri.writeToFile;

public class Application {
    public static void main()
    {

        Path inStudenti = Paths.get("studenti_in.txt"); // sau src/lab3/studenti_in.txt, cu cale relativa
        Path outStudenti1 = Paths.get("studenti_out.txt");
        Path outStudenti2 = Paths.get("studenti_out_sorted.txt");

        try
        {
            List<Student> inListaStudenti = new ArrayList<Student>();
            List<String> outListaStudenti = new ArrayList<String>();
            Map<String, Student> mapStudenti = new HashMap<>();

            String studentiCititiFisier = "";

            try(Scanner scanner = new Scanner(inStudenti))
            {
                while(scanner.hasNextLine())
                {
                    studentiCititiFisier = scanner.nextLine();

                    String[] separaStudentiFisier = studentiCititiFisier.split(",");

                    int numarMatricolCurent = Integer.parseInt(separaStudentiFisier[0]);
                    String  prenumeCurent = separaStudentiFisier[1];
                    String numeCurent = separaStudentiFisier[2];
                    String formatieDeStudiuCurenta = separaStudentiFisier[3];

                    Student s = new Student(numarMatricolCurent, prenumeCurent, numeCurent, formatieDeStudiuCurenta);

                    inListaStudenti.add(s);
                    mapStudenti.put(String.valueOf(numarMatricolCurent), s);
                }
            }

            Path inNoteStudenti = Paths.get("note_anon.txt");

            try(Scanner scanner = new Scanner(inNoteStudenti))
            {
                String noteCititeFisier = "";

                while(scanner.hasNextLine())
                {
                    noteCititeFisier = scanner.nextLine();
                    String[] separaNoteFisier = noteCititeFisier.split(",");
                    String numarMatricolCurent = separaNoteFisier[0];
                    double notaCurenta = Double.parseDouble(separaNoteFisier[1]);

                    Student s = mapStudenti.get(numarMatricolCurent);
                    if (s != null)
                        s.setNota(notaCurenta);
                }
            }

            inListaStudenti.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume));
            //inListaStudenti.sort(Comparator.comparing(Student::getNume));

            for (Student s : inListaStudenti)
            {
                System.out.println(s.toString());
                outListaStudenti.add(s.toString());
            }

            Files.write(outStudenti2, outListaStudenti);

            System.out.println("Continutul Map-ului cu studenti: ");
            IO.println(String.format("%15s %20s %s %s", "numar matricol", "prenume nume", "formatie de studiu", "nota"));
            for (Student s : mapStudenti.values())
            {
                System.out.println(s.toString());
            }

            double notaM = gasesteNota("Paul", "Mohanu", mapStudenti);
            double notaN = gasesteNota("Ioan", "Popa", mapStudenti);

            System.out.println("Paul Mohanu are nota " + notaM);
            System.out.println("Ioan Popa are nota " + notaN);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI21/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI21/2");

        IO.println(String.format("%15s %20s %s %s", "numar matricol", "prenume nume", "formatie de studiu", "nota"));
        /*IO.println(s1.toString());
        IO.println(s2.toString());
        IO.println(s3.toString());
        IO.println(s4.toString());
        IO.println(s5.toString());*/

        List<Student> listStudenti = new ArrayList<Student>();

        listStudenti.add(s1);
        listStudenti.add(s2);
        listStudenti.add(s3);
        listStudenti.add(s4);
        listStudenti.add(s5);

        for(Student s : listStudenti)
        {
            IO.println(s + " ");
        }

        Student cautaStudent1 = new Student(120, "Alis", "Popa", "TI21/2");
        Student cautaStudent2 = new Student(112, "Maria", "Popa", "TI21/1");

        IO.println("Cautare pt liste varianta 1: ");
        if(cautaStudent1.verifPrezenta(listStudenti)) //listaStudenti.contains(cautaStudent1))
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta(listStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " nu este in lista.");
        }

        IO.println("Cautare pt liste varianta 2: ");
        if(listStudenti.contains(cautaStudent1))
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta3(listStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " nu este in lista.");
        }

        Set<Student> setStudenti = new HashSet<>();

        setStudenti.add(s1);
        setStudenti.add(s2);
        setStudenti.add(s3);
        setStudenti.add(s4);
        setStudenti.add(s5);

        IO.println("Cautare pt seturi: ");
        if(cautaStudent1.verifPrezenta2(setStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.nume + " " + cautaStudent1.prenume + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta2(setStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.nume + " " + cautaStudent2.prenume + " nu este in lista.");
        }


        Set<StudentiBursieri> bursieri = new HashSet<>();

        bursieri.add( new StudentiBursieri(1025,"Andrei","Popa","ISM141/2", 725.50));
        bursieri.add( new StudentiBursieri(1024,"Ioan","Mihalcea","ISM141/1", 801.10));
        bursieri.add( new StudentiBursieri(1026,"Anamaria","Prodan","TI131/1", 745.50));
        bursieri.add( new StudentiBursieri(1029,"Bianca","Popescu","TI131/1",  780.80));

        writeToFile("bursieri_out.txt", bursieri);


    }
}