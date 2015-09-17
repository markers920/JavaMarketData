package markprojects;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String symbol;
    private long timestamp;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double adjClose;


    public Record(String sym, String line) throws ParseException {
        String[] splitLine = line.split(",");
        for(int index = 0; index < splitLine.length; index++) {
            splitLine[index] = splitLine[index].trim();
        }

        setSymbol(sym);
        setTimestamp(splitLine[0]);
        setOpen(splitLine[1]);
        setHigh(splitLine[2]);
        setLow(splitLine[3]);
        setClose(splitLine[4]);
        setVolume(splitLine[5]);
        setAdjClose(splitLine[6]);
    }

    public Record(String line) throws ParseException {
        String[] splitLine = line.split(",");
        for(int index = 0; index < splitLine.length; index++) {
            splitLine[index] = splitLine[index].trim();
        }

        setSymbol(splitLine[0]);
        setTimestamp(splitLine[1]);
        setOpen(splitLine[2]);
        setHigh(splitLine[3]);
        setLow(splitLine[4]);
        setClose(splitLine[5]);
        setVolume(splitLine[6]);
        setAdjClose(splitLine[7]);
    }

    // get functions
    public String getSymbol() {
        return this.symbol;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public double getOpen() {
        return this.open;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public double getClose() {
        return this.close;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getAdjClose() {
        return this.adjClose;
    }

    
    // set functions
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setTimestamp(String timestamp) throws ParseException {
        setTimestamp(DATE_FORMAT.parse(timestamp).getTime());
    }

    public void setOpen(double open) {
        this.open = open;
    }
    
    public void setOpen(String open) {
        setOpen(Double.parseDouble(open));
    }

    public void setHigh(double high) {
        this.high = high;
    }
    
    public void setHigh(String high) {
        setHigh(Double.parseDouble(high));
    }

    public void setLow(double low) {
        this.low = low;
    }
    
    public void setLow(String low) {
        setLow(Double.parseDouble(low));
    }

    public void setClose(double close) {
        this.close = close;
    }
    
    public void setClose(String close) {
        setClose(Double.parseDouble(close));
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public void setVolume(String volume) {
        setVolume(Double.parseDouble(volume));
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }
    
    public void setAdjClose(String adjClose) {
        setAdjClose(Double.parseDouble(adjClose));
    }
    

    

    public void writeToFile(PrintWriter out) {
        out.print(symbol + ",");
        out.print(humanDateTime() + ",");    //human readable
        out.print(open + ",");
        out.print(high + ",");
        out.print(low + ",");
        out.print(close + ",");
        out.print(volume + ",");
        out.print(adjClose + ",");
        out.print("\n");
    }

    
    // to string fucntions
    public String humanDateTime() {
        return DATE_FORMAT.format(new Date(this.timestamp));
    }

    public double getChangeValue() {
        return this.close - this.open;
    }

    public double getChangePercentage() {
        return getChangeValue() / this.open;
    }

    //TODO: use string builder, or string formatter
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(symbol + " " + timestamp + " " + this.humanDateTime() + "\n");
        b.append(open + "/");
        b.append(high + "/");
        b.append(low + "/");
        b.append(close + "/");
        b.append(volume + "/");
        b.append(adjClose + "/");
        return b.toString();
    }
    
}



