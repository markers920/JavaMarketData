package markprojects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

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
        this.symbol = sym;

        String[] splitLine = line.split(",");

        this.timestamp = DATE_FORMAT.parse(splitLine[0].trim()).getTime();
        this.open     = Double.parseDouble(splitLine[1].trim());
        this.high     = Double.parseDouble(splitLine[2].trim());
        this.low      = Double.parseDouble(splitLine[3].trim());
        this.close    = Double.parseDouble(splitLine[4].trim());
        this.volume   = Double.parseDouble(splitLine[5].trim());
        this.adjClose = Double.parseDouble(splitLine[6].trim());

        System.out.println(line + "\n" + this.toString());
    }

    public String humanDateTime() {
        return DATE_FORMAT.format(new Date(this.timestamp));
    }

    //TODO: use string builder, or string formatter
    public String toString() {
        //return symbol + " " + timestamp + " " + this.humanDateTime() + "\n" + open + "/" + high + "/" + low + "/" close + "/" + volume + "/" + adjClose;

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



