package lab2;

import java.util.*;

public class Application
{
    public static void main()
    {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        for (int i = 0; i < 5; i++) {
            x.add((int) (Math.random() * 10));
        }

        IO.println("The elements of list x (unsorted)...");
        for (int i = 0; i < x.size(); i++) {
            Object element = x.get(i);
            IO.print(element + " ");
        }
        IO.println();

        for (int i = 0; i < 7; i++) {
            y.add((int) (Math.random() * 10));
        }

        IO.println("The elements of list y (unsorted)...");
        for (int i = 0; i < y.size(); i++) {
            Object element = y.get(i);
            IO.print(element + " ");
        }
        IO.println();

        Collections.sort(x);
        Collections.sort(y);

        IO.println("The elements of list x (sorted)...");
        for (int i = 0; i < x.size(); i++) {
            Object element = x.get(i);
            IO.print(element + " ");
        }
        IO.println();

        IO.println("The elements of list y (sorted)...");
        for (int i = 0; i < y.size(); i++) {
            Object element = y.get(i);
            IO.print(element + " ");
        }

        IO.println();

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        IO.println("The elements of list xPlusY (sorted)...");
        for (int i = 0; i < xPlusY.size(); i++) {
            Object element = xPlusY.get(i);
            IO.print(element + " ");
        }
        IO.println();

        zSet.addAll(x);
        zSet.retainAll(y);

        IO.println("The elements of set zSet (sorted)...");
        Iterator<Integer> iterator = zSet.iterator();
        while (iterator.hasNext())
        {
            IO.print(iterator.next() + " ");
        }
        IO.println();

        xMinusY.addAll(x);
        xMinusY.removeAll(zSet);

        IO.println("The elements of list xMinusY (sorted)...");
        for (int i = 0; i < xMinusY.size(); i++) {
            Object element = xMinusY.get(i);
            IO.print(element + " ");
        }
        IO.println();

        for (Integer element : xPlusY)
        {
            if (element <= p)
                xPlusYLimitedByP.add(element);
        }

        IO.println("The elements of list xPlusYLimitedByP (sorted)...");
        for (int i = 0; i < xPlusYLimitedByP.size(); i++) {
            Object element = xPlusYLimitedByP.get(i);
            IO.print(element + " ");
        }
        IO.println();
    }

}
