import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        String word = "";

        try (FileReader reader = new FileReader("Lab1.txt"))
        {
            int c;
            while ((c = reader.read()) != -1)
            {
                if (Character.isUpperCase((char) c))
                {
                    c = Character.toLowerCase((char) c);
                }
                if ((char) c >= 'а' && (char) c <= 'я')
                {
                    word += (char) c;
                }
                else
                {
                    if (!word.isEmpty())
                    {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                        word = "";
                    }
                }
            }
            if (!word.isEmpty())
            {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        for (String key : wordCounts.keySet())
        {
            System.out.println(key + " - " + wordCounts.get(key));
        }
    }
}