package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport
{
    private final String numeFisier;

    public StudentiDinFisierXlsx(String numeFisier)
    {
        this.numeFisier = numeFisier;
    }

    @Override
    public List<Student> doImport()
    {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fisier = new FileInputStream(numeFisier);
             XSSFWorkbook workbook = new XSSFWorkbook(fisier)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                int numarMatricolCurent = (int) row.getCell(0).getNumericCellValue();
                String prenumeCurent = row.getCell(1).getStringCellValue();
                String numeCurent = row.getCell(2).getStringCellValue();
                String formatieDeStudiuCurenta = row.getCell(3).getStringCellValue();
                double notaCurenta = row.getCell(4).getNumericCellValue();

                studenti.add(new Student(numarMatricolCurent, prenumeCurent, numeCurent, formatieDeStudiuCurenta, notaCurenta));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }

}
