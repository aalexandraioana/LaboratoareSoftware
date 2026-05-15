package ro.ulbs.proiectaresoftware.students;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy
{
    public static void main()
    {
        List<Student> studenti = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1", 10),
                new Student(1029,"Maria","Pana","TI131/2", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );

        //a
        IStudentiExport strategyConsole = new StudentiInConsola();
        Exporter exporter = new Exporter();
        exporter.startExport(strategyConsole, studenti);

        //b
        String fileName1 = "studenti.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileName1);
        exporter.startExport(strategyFisierText, studenti);

        //c
        String fileName2 = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(fileName2);
        exporter.startExport(strategyFisierExcel, studenti);

        //d
        List<Student> studentiImportatiTxt = new ArrayList<>();
        StudentiDinFisierText strategyImportTxt = new StudentiDinFisierText("studenti.txt");
        studentiImportatiTxt = strategyImportTxt.doImport();

        //e
        List<Student> studentiImportatiXlsx = new ArrayList<>();
        StudentiDinFisierXlsx strategyImportXlsx = new StudentiDinFisierXlsx("studentiStrategyExcel.xlsx");
        studentiImportatiXlsx = strategyImportXlsx.doImport();



    }
}
