package Proper.tools;

import java.io.*;

/**
 * Created by Simerron on 31/03/2017.
 */
public class fileReader {

    public String readInput(String file) {
        StringBuffer buffer = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            Reader in = new BufferedReader(isr);
            int ch;
            while ((ch = in.read()) > -1) {
                buffer.append((char) ch);
            }
            in.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readLine(String file, int lineNb) {
        String line = "Error finding file";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (int i = 0; i < lineNb; i++){
                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public int nbLine(String file){
        int i=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                i++;
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return i;

    }


}
