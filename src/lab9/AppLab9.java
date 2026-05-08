package lab9;

import java.util.*;
import java.util.stream.Collectors;

public class AppLab9
{
    public static void main(String[] args)
    {
        //9.3.1.
        Random rand = new Random();

        List<Integer> nrIntregiAleatoare = rand.ints(10, 5, 26)
                                                .boxed()
                                                .collect(Collectors.toList());

        System.out.println("Lista de numere intregi: " + nrIntregiAleatoare);

        int suma = nrIntregiAleatoare.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Suma numerelor intregi introduse este " + suma);

        int valMax = nrIntregiAleatoare.stream()
                     .max(Comparator.naturalOrder())
                     .get();

        System.out.println("Maximul din lista este " + valMax);


        int valMin = nrIntregiAleatoare.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Minimul din lista este " + valMin);

        List<Integer> listaFiltrata = nrIntregiAleatoare.stream()
                .filter(nr -> nr >= 10 && nr <=20)
                .collect(Collectors.toList());;

        System.out.println("Lista de numere intregi filtrata: " + listaFiltrata);

        List<Double> listaDouble = nrIntregiAleatoare.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());

        boolean exista12InLista = nrIntregiAleatoare.stream()
                .anyMatch(nr -> nr == 12);
        System.out.println("Valoarea 12 eixsta in lista..." + exista12InLista);

        // 9.3.2.
        String text = "Acesta este un program scris in java pentru expresii lambda";

        List<String> cuvinteString = Arrays.asList(text.split(" "));
        System.out.println("String-ul initial: " + text);
        System.out.println("Cuvintele din string: " + cuvinteString);

        List<String> cuvinteMinim5CharString = cuvinteString.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Lista filtrata a cuvintelor din string dupa marime: " + cuvinteMinim5CharString);
        long nrCuvinteMinim5CharString = cuvinteMinim5CharString.stream()
                .count();
        System.out.println(nrCuvinteMinim5CharString + " cuvinte din string au minim 5 caractere");
        List<String> cuvinteMinim5CharStringSortat = cuvinteMinim5CharString.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Lista filtrata anterioara, sortata: " + cuvinteMinim5CharStringSortat);

        Optional<String> cuvantIncepeCuP = cuvinteString.stream()
                .filter(c -> c.startsWith("p"))
                .findAny();

        if (cuvantIncepeCuP.isPresent())
        {
            System.out.println("'" + cuvantIncepeCuP.get() + "'" + " este un cuvant identificat in string care incepe cu litera p.");
        }
        else
        {
            System.out.println("Nu exista niciun cuvant care incepe cu litera p.");
        }








    }
}
