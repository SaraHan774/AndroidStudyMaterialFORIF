package dbms;

import java.io.*;
import java.util.*;

public class Sample {

    public static void main(String[] args) {

        //provide file path
        File randomStringFile = new File("./random_strings.txt");
        String string;
        int key = 0;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("sample_key_values3.txt", false));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(randomStringFile));
            while((string = bufferedReader.readLine()) != null){
                // write to file
                Random random = new Random();
                long randomLong = random.nextLong();
                if(randomLong < 0){
                    randomLong *= (-1);
                }

                writer.append(Long.toString(randomLong)).append(" ");
                writer.append(string).append("\n");
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
