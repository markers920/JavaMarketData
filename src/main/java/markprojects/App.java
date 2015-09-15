package markprojects;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class App {

    //TODO: pull out of args[]
    private static final boolean doWrite = false;
    private static final boolean readFromFile = true;
    private static final String RECORDS_FILE = "records.txt";

    private static List<Record> records = new ArrayList<Record>();

    public static void main( String[] args ) throws Exception {
        if(readFromFile) {
           pullFromFile(); 
        }

        else { //read from internet
            pullFromYahoo();
        }


        if(doWrite) {
            PrintWriter out = new PrintWriter(new FileWriter(RECORDS_FILE)); 
            for(Record r : records) {
                r.writeToFile(out);
            }
            out.close();
        }
    }

    public static void pullFromFile() throws Exception {
        records.clear();
        BufferedReader in = new BufferedReader(new FileReader(RECORDS_FILE));
        String text;
        while (in.ready()) {
            text = in.readLine();
            records.add(new Record(text));
            //System.out.println(text);
        }
        in.close();
    }

    public static void pullFromYahoo() throws Exception {
        records.clear();
        for(String symbol : Constants.SYMBOLS) {
            symbol = symbol.trim();	//TODO: drop the trim when the list is cleaned up

            String uri = YahooPuller.buildURI(symbol, Constants.START_DAY, Constants.END_DAY);

            String response = YahooPuller.doCall(uri);

            int lineIndex = 0;
            for(String line : response.split("\n")) {
               if(lineIndex > 0) {
                   records.add(new Record(symbol, line));
               }
               lineIndex++;
            }
        }//END for symbol
    }

}
