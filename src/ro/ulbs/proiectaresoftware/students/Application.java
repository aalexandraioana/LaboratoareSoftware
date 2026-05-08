package ro.ulbs.proiectaresoftware.students;
import lab4.Tanar;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static ro.ulbs.proiectaresoftware.students.Student.*;
//import static ro.ulbs.proiectaresoftware.students.StudentiBursieri.writeToFile;

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
                    {
                        Student s_new = schimbaNota(s, notaCurenta);
                        mapStudenti.put(numarMatricolCurent, s_new);
                    }

                }
            }

            inListaStudenti.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume));
            inListaStudenti.sort(Comparator.comparing(Student::getNume));

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
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta(listStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " nu este in lista.");
        }

        IO.println("Cautare pt liste varianta 2: ");
        if(listStudenti.contains(cautaStudent1))
        {
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta3(listStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " nu este in lista.");
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
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent1.getNume() + " " + cautaStudent1.getPrenume() + " nu este in lista.");
        }
        if(cautaStudent2.verifPrezenta2(setStudenti))
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " este in lista.");
        }
        else
        {
            IO.println("Studentul(a) " + cautaStudent2.getNume() + " " + cautaStudent2.getPrenume() + " nu este in lista.");
        }


        /*Set<StudentiBursieri> bursieri = new HashSet<>();

        bursieri.add( new StudentiBursieri(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        bursieri.add( new StudentiBursieri(1024,"Ioan","Mihalcea","ISM141/1", 9.80,801.10));
        bursieri.add( new StudentiBursieri(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        bursieri.add( new StudentiBursieri(1029,"Bianca","Popescu","TI131/1",  9.10,780.80));

        writeToFile("bursieri_out.txt", bursieri);*/

        Set<Student> setStudentiLab7 = new HashSet<>();
        setStudentiLab7.add(new Student(2050, "Ioana", "Popa", "ISM21/2", 6.90));
        setStudentiLab7.add(new Student(2041, "Denis", "Moldovan", "ISM21/1", 9.20));
        setStudentiLab7.add(new Student(2017, "Elena", "Ionescu", "TI22/1", 9.50));
        setStudentiLab7.add(new Student(2048, "Maria", "Blaga", "ISM21/2", 8.70));
        setStudentiLab7.add(new Student(2066, "David", "Gheorghe", "TI21/2", 7.70));

        setStudentiLab7 = imparteInDouaFormatii(setStudentiLab7, "TI21/1", "TI21/2");

        IO.println("Studentii impartiti in doua formatii de studiu: ");

        IO.println(String.format("%15s %20s %s %s", "numar matricol", "prenume nume", "formatie de studiu", "nota"));

        for (Student s : setStudentiLab7)
        {
            IO.println((s.toString()));
        }

        //Laborator 8
        writeToXls(setStudentiLab7, "laborator8_students.xlsx");

        List<Student> studentiCititiXls = readFromXls("laborator8_students.xlsx");
        System.out.printf("%20s %20s %20s %20s %20s%n", "Numar matricol", "Prenume", "Nume", "Formatie de studiu", "Nota");

        for (Student st : studentiCititiXls)
        {
            System.out.printf("%20d %20s %20s %20s %20.2f%n", st.getNumarMatricol(), st.getPrenume(),
                    st.getNume(), st.getFormatieDeStudiu(), st.getNota());
        }

        //Laborator 9

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",     "ISM141/2", 8.70),
                new Student(1024, "Ioan",     "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan",   "TI131/1",  8.90),
                new Student(1029, "Bianca",   "Popescu",  "TI131/1",  10),
                new Student(1029, "Maria",    "Pana",     "TI131/2",  4.10),
                new Student(1029, "Gabriela", "Mohanu",   "TI131/2",  7.33),
                new Student(1029, "Marius",   "Nasta",    "TI131/2",  3.20),
                new Student(1029, "Marius",   "Nasta",    "TI131/1",  5.12),
                new Student(1029, "Andrei",   "Dobrescu", "TI131/2",  2.22)
        );

        System.out.println("Studentii cu nota 10 ");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(System.out::println);
        System.out.println("Studentii cu note sub 5 ");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(System.out::println);

        List<Student> listaStudentiCorectata = studentiCuNote.stream()
                .map(s -> s.getNota() < 4 ? new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4.0) : s)
                .collect(Collectors.toList());
        System.out.println("Lista studentilor cu corectia studentilor care au obtinut note sub 4 ");
        listaStudentiCorectata.forEach(System.out::println);

        double sumaNote = studentiCuNote.stream()
                .reduce(0.0, (acumulator, s) -> acumulator + s.getNota(), Double::sum);

        double medieNote = sumaNote / studentiCuNote.size();
        System.out.println("Media notelor studentilor: " + medieNote);



    }
    public static void writeToXls(Set<Student> studenti, String filename)
    {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream out = new FileOutputStream(filename))
        {
            XSSFSheet sheet = workbook.createSheet("Studenti");
            int rowNumber = 0;
            Row headerRow = sheet.createRow(rowNumber++);
            headerRow.createCell(0).setCellValue("Numar matricol");
            headerRow.createCell(1).setCellValue("Prenume");
            headerRow.createCell(2).setCellValue("Nume");
            headerRow.createCell(3).setCellValue("Formatie de studiu");
            headerRow.createCell(4).setCellValue("Nota");

            for (Student st : studenti)
            {
                Row row = sheet.createRow(rowNumber++);
                row.createCell(0).setCellValue((long) st.getNumarMatricol());
                row.createCell(1).setCellValue(st.getPrenume());
                row.createCell(2).setCellValue(st.getNume());
                row.createCell(3).setCellValue(st.getFormatieDeStudiu());
                row.createCell(4).setCellValue(st.getNota());
            }
            workbook.write(out);
            System.out.println("Exportul in Excel a fost finalizat cu succes.");
            System.out.println("Iata continutul fisierului citit...");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Student> readFromXls(String filename)
    {
        List<Student> studentList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fileIn))
        {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext())
                rowIterator.next();

            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                int numarMatricolCurent = (int) row.getCell(0).getNumericCellValue();
                String prenumeCurent = row.getCell(1).getStringCellValue();
                String numeCurent = row.getCell(2).getStringCellValue();
                String formatieDeStudiuCurenta = row.getCell(3).getStringCellValue();
                double notaCurenta = row.getCell(4).getNumericCellValue();

                studentList.add(new Student(numarMatricolCurent, prenumeCurent, numeCurent, formatieDeStudiuCurenta, notaCurenta));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return studentList;
    }

}