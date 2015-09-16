package markprojects;

import java.util.List;


public class App {

    private static List<Record> records;

    public static void main( String[] args ) throws Exception {
        boolean readFromFile = Boolean.parseBoolean(args[0]);
        boolean doWrite = Boolean.parseBoolean(args[1]);

        String recordsFilename = null;
        if(readFromFile || doWrite) {
            recordsFilename = args[2];
        }

        if(readFromFile) {
            System.out.println("read from file");
            records = FileIO.pullFromFile(recordsFilename); 
        }

        else { //read from internet
            System.out.println("read from yahoo");
            records = YahooPuller.pullFromYahoo();
        }

        System.out.println("records.size = " + records.size());

        if(doWrite) {
            FileIO.writeRecords(records, recordsFilename);
        }

        
        System.out.println("records.size = " + FilterFunctions.filterBySymbol(records, "C").size());
    }

}
