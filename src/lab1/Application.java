package lab1;

public class Application
{
    public static void main()
    {
        String alphabet = new String("");
        for(char i = 'a'; i <= 'z'; i++)
            alphabet = alphabet + i;
        IO.println("Alfabetul cu caractere mici: " + alphabet.toLowerCase());
        IO.println("Alfabetul cu majuscule: " + alphabet.toUpperCase());

        String []array = new String[5];
        int k = 0;

        for (int i = 0; i < alphabet.length(); i++) {
            char tempChar = alphabet.charAt(i);

            if (tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u') {
                if (array[k] != null)
                    k++;
                array[k] = "";
            }
                    array[k] += tempChar;
            }
        for (int i = 0; i < array.length; i++) {
            IO.println("array[" + i + "] = \"" + array[i] + "\"");
        }

    }
}
