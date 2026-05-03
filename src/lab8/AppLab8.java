package lab8;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.Cell.*;

public class AppLab8 {

    private static final String fisierOutputExcel2 = "laborator8_output2.xlsx";
    private static final String fisierInputExcel = "laborator8_input.xlsx";
    private static final String fisierOutputExcel3 = "laborator8_output3.xlsx";

    public static void copiazaFisierCuMedie(String fisierInputExcel, String fisierOutputExcel) {
        try (FileInputStream fisierIn = new FileInputStream(fisierInputExcel);
             XSSFWorkbook workbookIn = new XSSFWorkbook(fisierIn))
        {
            XSSFSheet sheetIn = workbookIn.getSheetAt(0);

            XSSFWorkbook workbookOut = new XSSFWorkbook();
            XSSFSheet sheetOut = workbookOut.createSheet("SheetOut");


            for (Row rowIn : sheetIn)
            {
                Row rowOut = sheetOut.createRow(rowIn.getRowNum());
                int lastColumn = rowIn.getLastCellNum();

                for (Cell cellIn : rowIn)
                {
                    Cell cellOut = rowOut.createCell(cellIn.getColumnIndex());
                    copiazaContinutCelula(cellIn, cellOut);
                }

                Cell cellAvg = rowOut.createCell(lastColumn);

                if (rowIn.getRowNum() == 0)
                {
                    cellAvg.setCellValue("Medie");
                }
                else
                {
                    double suma = 0;
                    int contor = 0;
                    int totalColoane = rowIn.getLastCellNum();
                    int coloanaDeStart = Math.max(0, totalColoane - 3);
                    for (int i = coloanaDeStart; i < totalColoane; i++)
                    {
                        Cell cell = rowIn.getCell(i);
                        if (cell != null && cell.getCellType() == CellType.NUMERIC)
                        {
                            suma += cell.getNumericCellValue();
                            contor++;
                        }
                    }
                    double medie = contor > 0 ? suma/contor : 0;
                    cellAvg.setCellValue(Math.round(medie * 100.0) / 100.0);
                }
            }
            try (FileOutputStream fisierOut = new FileOutputStream(fisierOutputExcel))
            {
                workbookOut.write(fisierOut);
                System.out.println("Fisierul generat + media: " + fisierOut);
            }
            workbookOut.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void copiazaFisierMedieCuAverage(String fisierInputExcel, String fisierOutputExcel) {
        try (FileInputStream fisierIn = new FileInputStream(fisierInputExcel);
             XSSFWorkbook workbookIn = new XSSFWorkbook(fisierIn))
        {
            XSSFSheet sheetIn = workbookIn.getSheetAt(0);

            XSSFWorkbook workbookOut = new XSSFWorkbook();
            XSSFSheet sheetOut = workbookOut.createSheet("SheetOut");


            for (Row rowIn : sheetIn)
            {
                Row rowOut = sheetOut.createRow(rowIn.getRowNum());
                int lastColumn = rowIn.getLastCellNum();

                for (Cell cellIn : rowIn)
                {
                    Cell cellOut = rowOut.createCell(cellIn.getColumnIndex());
                    copiazaContinutCelula(cellIn, cellOut);
                }

                Cell cellAvg = rowOut.createCell(lastColumn);

                if (rowIn.getRowNum() == 0)
                {
                    cellAvg.setCellValue("Medie");
                }
                else
                {
                   int row = rowIn.getRowNum() + 1;
                   String formula = "AVERAGE(D" + row + ":F" + row + ")";
                   cellAvg.setCellFormula(formula);
                }
            }
            try (FileOutputStream fisierOut = new FileOutputStream(fisierOutputExcel))
            {
                workbookOut.write(fisierOut);
                System.out.println("Fisierul generat + media: " + fisierOut);
            }
            workbookOut.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void copiazaContinutCelula(Cell cellIn, Cell cellOut)
    {
        switch(cellIn.getCellType())
        {
            case NUMERIC -> cellOut.setCellValue(cellIn.getNumericCellValue());
            case STRING -> cellOut.setCellValue(cellIn.getStringCellValue());
            case BOOLEAN -> cellOut.setCellValue(cellIn.getBooleanCellValue());
            case FORMULA -> cellOut.setCellValue(cellIn.getCellFormula());
            case BLANK -> cellOut.setBlank();
            default -> cellOut.setCellValue(getCellValueAsString(cellIn));
        }
    }

    private static String getCellValueAsString(Cell cell)
    {
        if (cell == null)
            return "";
        return switch (cell.getCellType())
        {
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case STRING -> cell.getStringCellValue();
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK -> "";
            default -> "UNKNOWN";

        };
    }

    public static void main()
    {
        //Aplicatia 1
        try (FileInputStream fisierIn = new FileInputStream(fisierInputExcel);

             XSSFWorkbook workbook = new XSSFWorkbook(fisierIn))
        {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet)
            {
                for (Cell cell : row) {
                    int columnIndex = cell.getColumnIndex();

                    switch (cell.getCellType()) {
                        case STRING -> System.out.printf("%-20s", cell.getStringCellValue());
                        case NUMERIC -> {
                            if (columnIndex == 0)
                                System.out.printf("%-20d", (long) cell.getNumericCellValue());
                            else
                                System.out.printf("%-20.2f", cell.getNumericCellValue());
                        }
                        default -> System.out.print("-\t");
                    }
                }
                System.out.println("");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Aplicatia 2
        copiazaFisierCuMedie(fisierInputExcel, fisierOutputExcel2);

        //Aplicatia 3
        copiazaFisierMedieCuAverage(fisierInputExcel, fisierOutputExcel3);


    }
}




