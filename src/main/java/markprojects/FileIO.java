package markprojects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<Record> pullFromFile(String recordsFilename) throws Exception {
        List<Record> records = new ArrayList<Record>();
        
        BufferedReader in = new BufferedReader(new FileReader(recordsFilename));
        String text;
        while (in.ready()) {
            text = in.readLine();
            records.add(new Record(text));
            //System.out.println(text);
        }
        in.close();
        
        return records;
    }
    
    public static void writeRecords(List<Record> records, String recordsFilename) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter(recordsFilename)); 
        for(Record r : records) {
            r.writeToFile(out);
        }
        out.close();
    }
    
}
