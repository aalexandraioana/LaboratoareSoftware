/*package test;
import org.junit.jupiter.api.*;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.StudentiBursieri;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicatieCuBursaTest
{
    AplicatieCuBursa apb = new AplicatieCuBursa();

    @Test
    public void testSorteaza()
    {
        List<StudentiBursieri> lista = new ArrayList<>();
        lista.add( new StudentiBursieri(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        lista.add( new StudentiBursieri(1024,"Ioan","Mihalcea","ISM141/1", 9.80, 801.10));
        lista.add( new StudentiBursieri(1029,"Bianca","Popescu","TI131/1", 9.10, 780.80));
        lista.add( new StudentiBursieri(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        lista.add( new StudentiBursieri(1029,"Bianca","Popescu","TI131/1", 9.10, 100.00));
        
        apb.sorteaza(lista);

        assertEquals("Ioan", lista.get(0).getPrenume());
        assertEquals("Andrei", lista.get(1).getPrenume());
        assertEquals("Bianca", lista.get(2).getPrenume());
        assertEquals(100.00, lista.get(2).getCuantumBursa());
        assertEquals("Bianca", lista.get(3).getPrenume());
        assertEquals(780.80, lista.get(3).getCuantumBursa());
        assertEquals("Prodan", lista.getLast().getNume());
    }
}*/
