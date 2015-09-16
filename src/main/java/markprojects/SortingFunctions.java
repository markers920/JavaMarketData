package markprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import org.apache.commons.lang3.tuple.Pair;
import static markprojects.Constants.*;


public class SortingFunctions {

    public static final Comparator timestampComparator = new RecordComparator(FILTER_TIMESTAMP);
    
    static class RecordComparator implements Comparator<Record> {
        private int type;
        public RecordComparator(int type) {
            this.type = type;	//TODO: add type check, maybe a set of the possible types?
        }

        public int compare(Record r1, Record r2) {
            if(this.type == FILTER_TIMESTAMP)
                return Long.compare(r1.getTimestamp(), r2.getTimestamp());
            if(this.type == FILTER_OPEN)
                return Double.compare(r1.getOpen(), r2.getOpen());
            if(this.type == FILTER_HIGH)
                return Double.compare(r1.getHigh(), r2.getHigh());
            if(this.type == FILTER_LOW)
                return Double.compare(r1.getLow(), r2.getLow());
            if(this.type == FILTER_CLOSE)
                return Double.compare(r1.getClose(), r2.getClose());
            if(this.type == FILTER_VOLUME)
                return Double.compare(r1.getVolume(), r2.getVolume());
            if(this.type == FILTER_ADJCLOSE)
                return Double.compare(r1.getAdjClose(), r2.getAdjClose());

            return 0;
        }
    }

}

