package Assignment_3.SetA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SetA_4 {

    public static void main(String[] args) {
        String filename = "C:\\Users\\user\\IdeaProjects\\Java Practical Assignments\\src\\Assignment_3\\SetA\\vivek";

        int charCount = 0;
        int lineCount = 0;
        int wordCount =0;

        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while((line = reader.readLine())!=null){
                charCount += line.length();

                lineCount++;

                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount+= tokenizer.countTokens();
            }
        }
        catch(IOException e){
            System.err.println("An error occured while reading the file");
            e.printStackTrace();
        }

        System.out.println("Character count: "+charCount);
        System.out.println("Line count:"+lineCount);
        System.out.println("Word count:"+wordCount);
    }
}
