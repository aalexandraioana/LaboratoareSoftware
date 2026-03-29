package lab4;
import java.util.*;

public class AppLab4 {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria",
                "Bucuresti", "Victor", "Cluj","Simina", "Alba-Iulia","Marius", "Medias",
                "Mihai", "Cisnadie","Daniela", "Sibiu");
        HashMap<String, Tanar> tineri = new HashMap<>();

        System.out.println("Continutul hash map-ului varste: ");
        Iterator<String>iterator = varste.keySet().iterator();
        while(iterator.hasNext())
        {
            String name = iterator.next();
            int age = varste.get(name);
            String address = adrese.get(name);
            System.out.println("Nume: " + name + " |" + " Varsta: " + age + " |" + " Adresa: " + address);
            tineri.put(name, new Tanar(name, age, address));
        }

        System.out.println("Continutul hash map-ului tineri: ");
        for (Tanar t : tineri.values())
        {
            System.out.println(t);
        }


    }
}
