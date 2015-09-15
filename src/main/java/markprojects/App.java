package markprojects;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class App {

    private static List<Record> records = new ArrayList<Record>();

    public static void main( String[] args ) throws Exception {
        boolean readFromFile = Boolean.parseBoolean(args[0]);
        boolean doWrite = Boolean.parseBoolean(args[1]);

        String recordsFilename = null;
        if(readFromFile || doWrite) {
            recordsFilename = args[2];
        }

        if(readFromFile) {
            System.out.println("read from file");
            pullFromFile(recordsFilename); 
        }

        else { //read from internet
            System.out.println("read from yahoo");
            pullFromYahoo();
        }


        System.out.println("records.size()" + records.size());


        if(doWrite) {
            writeRecords(recordsFilename);
        }

        
        getRecords(true, "C");
    }



    public static void pullFromFile(String recordsFilename) throws Exception {
        records.clear();
        BufferedReader in = new BufferedReader(new FileReader(recordsFilename));
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

    public static void writeRecords(String recordsFilename) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter(recordsFilename)); 
        for(Record r : records) {
            r.writeToFile(out);
        }
        out.close();
    }



    //TODO: prob want to move these somwhere else
    private static List<Record> getRecords(boolean filterSymbol, String symbol) {
        List<Record> filteredRecords = new ArrayList<Record>();

        for(Record r : records) {
            if(filterSymbol && !r.getSymbol().equalsIgnoreCase(symbol)) {
                continue;
            }

            filteredRecords.add(r);
        }

        return filteredRecords;
    }


}
