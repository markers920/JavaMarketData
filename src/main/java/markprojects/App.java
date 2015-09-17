package markprojects;

import java.util.List;
import org.apache.commons.lang3.tuple.MutablePair;
import java.util.Collections;

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


        List<Record> records_C = FilterFunctions.filterBySymbol(records, "C");
        //System.out.println("records.size = " + records_C.size());
        //
        //Pair<List<Record>, List<Record>> beforeAndAfter = FilterFunctions.splitAtTimestamp(records, 1435708800000l);
        //System.out.println("records.size = " + beforeAndAfter.getLeft().size());
        //System.out.println("records.size = " + beforeAndAfter.getRight().size());

        List<MutablePair<Long,Double>> dailyChanges = TimeSeriesAnalysis.getDailyChange(records);
        List<Double> values = FilterFunctions.getSeriesValues(dailyChanges, true);

        TimeSeriesAnalysis.plotHistogram(values, 0.002, 100);
        System.out.println("values mean = " + TimeSeriesAnalysis.getMeanOfValues(values));
        System.out.println("min: " + Collections.min(values));
        System.out.println("max: " + Collections.max(values));
        
        /*TimeSeriesAnalysis.removeMeanFromValues(values);

        TimeSeriesAnalysis.plotHistogram(values, 0.001, 50);
        System.out.println("values mean = " + TimeSeriesAnalysis.getMeanOfValues(values));
        System.out.println("min: " + Collections.min(values));
        System.out.println("max: " + Collections.max(values));*/

    }

}
