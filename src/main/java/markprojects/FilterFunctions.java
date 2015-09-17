package markprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import static markprojects.Constants.*;

public class FilterFunctions {
    
    public static List<Record> filterBySymbol(List<Record> records, String symbol) {
        List<Record> filteredRecords = new ArrayList<Record>();
        for(Record r : records) {
            if(r.getSymbol().equalsIgnoreCase(symbol))
                filteredRecords.add(r);
        }
        return filteredRecords;
    }
    
    
    public static List<Record> filterByRange(List<Record> records, int filterType, double lowBound, double highBound) throws Exception {
        List<Record> filteredRecords = new ArrayList<Record>();
        for(Record r : records) {
            double value = getValue(r, filterType);
            if(lowBound <= value && value <= highBound)
                filteredRecords.add(r);
        }
        return filteredRecords;
    }
    
    
    public static List<Double> get(List<Record> records, int filterType) throws Exception {
        List<Double> values = new ArrayList<Double>();
        for(Record r : records) {
            values.add(getValue(r, filterType));
        }
        return values;
    }
    
    
    private static double getValue(Record r, int filterType) throws Exception {
        if(filterType == FILTER_TIMESTAMP)      
            return r.getTimestamp();
        else if(filterType == FILTER_OPEN)      
            return r.getOpen();
        else if(filterType == FILTER_HIGH)      
            return r.getHigh();
        else if(filterType == FILTER_LOW)       
            return r.getLow();
        else if(filterType == FILTER_CLOSE)     
            return r.getClose();
        else if(filterType == FILTER_VOLUME)    
            return r.getVolume();
        else if(filterType == FILTER_ADJCLOSE)  
            return r.getAdjClose();
        
        else {
            throw new Exception("Bad Filter Type");
        }
    }

    public static Pair<List<Record>, List<Record>> splitAtTimestamp(List<Record> records, long timestamp) {
        List<Record> lessThan = new ArrayList<Record>();
        List<Record> greaterThan = new ArrayList<Record>();

        for(Record r : records) {
            if(r.getTimestamp() < timestamp)
                lessThan.add(r);
            else
                greaterThan.add(r);
        }

        Collections.sort(lessThan, SortingFunctions.timestampComparator);
        Collections.sort(greaterThan, SortingFunctions.timestampComparator);

        return Pair.of(lessThan, greaterThan);
    }

    public static List<Double> getSeriesValues(List<MutablePair<Long,Double>> series, boolean sort) {
        List<Double> ret = new ArrayList<Double>();

        for(MutablePair<Long,Double> p : series) {
            ret.add(p.getRight());
        }

        if(sort)
            Collections.sort(ret);

        return ret;
    }

    public static List<Long> getSeriesTimes(List<MutablePair<Long,Double>> series, boolean sort) {
        List<Long> ret = new ArrayList<Long>();

        for(MutablePair<Long,Double> p : series) {
            ret.add(p.getLeft());
        }

        if(sort)
            Collections.sort(ret);

        return ret;
    }


}

