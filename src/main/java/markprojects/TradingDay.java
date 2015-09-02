package markprojects;


public class TradingDay {

    private int year, month, day;

    public TradingDay(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

}
