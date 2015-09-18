package markprojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.tuple.MutablePair;

public class TimeSeriesAnalysis {

    public static List<MutablePair<Long,Double>> getDailyChange(List<Record> records) {
        Collections.sort(records, SortingFunctions.timestampComparator);

        List<MutablePair<Long,Double>> ret = new ArrayList<MutablePair<Long,Double>>();
        for(Record r : records) {
            ret.add(MutablePair.of(r.getTimestamp(), r.getChangePercentage()));
        }
        return ret;
    }

    public static double getMeanOfSeries(List<MutablePair<Long,Double>> series) {
        double sum = 0.0;
        for(MutablePair<Long,Double> p : series) {
            sum += p.getRight();
        }
        return sum / series.size();
    }

    public static double getMeanOfValues(List<Double> values) {
        double sum = 0.0;
        for(Double d : values) {
            sum += d;
        }
        return sum / values.size();
    }

    public static void removeMeanFromSeries(List<MutablePair<Long,Double>> series) {
        double mean = getMeanOfSeries(series);

        for(MutablePair<Long,Double> p : series) {
            p.setRight(p.getRight()-mean);
        }
    }

    public static void removeMeanFromValues(List<Double> values) {
        double mean = getMeanOfValues(values);

        for(int idx = 0; idx < values.size(); idx++) {
            values.set(idx, values.get(idx) - mean);
        }
    }


    public static void plotHistogram(List<Double> values, double binSize, int maxLineWidth) {
        int maxBin = Integer.MIN_VALUE;
        int minBin = Integer.MAX_VALUE;
        int maxBinCount = -1;
        Map<Integer,AtomicInteger> histogram = new HashMap<Integer, AtomicInteger>();

        for(double v : values) {
            int bin = (int)(v/binSize);
            minBin = Math.min(minBin, bin);
            maxBin = Math.max(maxBin, bin);

            AtomicInteger binCount = histogram.get(bin);
            if(binCount == null) {
                binCount = new AtomicInteger(0);
                histogram.put(bin, binCount);
            }
            maxBinCount = Math.max(maxBinCount, binCount.incrementAndGet());
        }

        for(int bin = minBin; bin <= maxBin; bin++) {
            int binCount = 0;
            if(histogram.get(bin) != null) {
                binCount = histogram.get(bin).get();
            }
            int starCount = (int)(maxLineWidth * ((double)binCount / maxBinCount));
            //System.out.println(bin + " " + binCount + " " + starCount);
            for(int i = 0; i < starCount; i++)
                System.out.print("*");
            System.out.println();
       }
    }

    //assumes in time order, and time between samples is always 1
    public static double sampleAutoCovariance(List<Double> values, int h) {
        h = Math.abs(h);
        double mean = getMeanOfValues(values);
        double sum = 0.0;
        for(int i = 0; i < values.size()-h; i++) {
            int idx = i-1;
            sum += (values.get(i+h)-mean)*(values.get(i)-mean);
        }
        return sum / values.size();
    }

    public static double sampleAutoCorrelation(List<Double> values, int h) {
        if(h==0)
            return 1.0;

        double gammaH = sampleAutoCovariance(values,h);
        double gamma0 = sampleAutoCovariance(values,0);

        return gammaH / gamma0;
    }
}




