package test;
import org.junit.jupiter.api.*;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.StudentiBursieri;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicatieCuBursaTest
{
    AplicatieCuBursa apb = new AplicatieCuBursa();

    @Test
    public void testSorteaza()
    {
        List<StudentiBursieri> lista = apb.genereaza();
        apb.sorteaza(lista);
        assertEquals("Ioan", lista.get(0).getPrenume());
        assertEquals("Andrei", lista.get(1).getPrenume());
        assertEquals("Bianca", lista.get(2).getPrenume());
        assertEquals(100.00, lista.get(2).getCuantumBursa());
        assertEquals("Bianca", lista.get(3).getPrenume());
        assertEquals(780.80, lista.get(3).getCuantumBursa());
        assertEquals("Prodan", lista.getLast().getNume());
    }
}
