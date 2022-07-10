package pages;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitKeysAndValues {
    final static String filePath = "./Files/TestData.txt";
    public static void getKeysAndValues() throws IOException {
        BufferedReader br = null;
        File fis = new File(filePath);
        br = new BufferedReader(new FileReader(fis));
       
    }

    public static void main(String args[]) throws IOException {
        SplitKeysAndValues.getKeysAndValues();
    }

}
