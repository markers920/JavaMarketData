package markprojects;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedInputStream;


// borrowed heavily from :
//    http://www.wikijava.org/wiki/Downloading_stock_market_quotes_from_Yahoo!_finance#Java_can_do_it

public class App {
    public static void main( String[] args ) throws Exception {
        String symbol = "C";

        String uri = buildURI(symbol, 
            new TradingDay(2015, 0, 1),		//January 1
            new TradingDay(2015, 7, 31));	//August 31


        String response = doCall(uri);

        int lineIndex = 0;
        for(String line : response.split("\n")) {
           if(lineIndex > 0) {
               Record r = new Record(symbol, line);
           }
           lineIndex++;
        }
    }


    //NOTE: months are 0 indexed, so January:0, December:11
    private static String buildURI(String symbol, TradingDay start, TradingDay end) {
        StringBuilder uri = new StringBuilder();
        uri.append("http://ichart.finance.yahoo.com/table.csv");
        uri.append("?s=").append(symbol);
        uri.append("&a=").append(start.getMonth());
        uri.append("&b=").append(start.getDay());
        uri.append("&c=").append(start.getYear());
        uri.append("&d=").append(end.getMonth());
        uri.append("&e=").append(end.getDay());
        uri.append("&f=").append(end.getYear());
        uri.append("&g=d");

        return uri.toString();
    }

    private static String doCall(String uri) throws Exception {
        HttpClient httpClient = new HttpClient();
       	HttpMethod getMethod = new GetMethod(uri);
 
        int response = httpClient.executeMethod(getMethod);
 
        if (response != 200) {
            throw new Exception("HTTP problem, httpcode: " + response);
        }
 
        InputStream stream = getMethod.getResponseBodyAsStream();
        String responseText = responseToString(stream);

        return responseText;
    }

    private static String responseToString(InputStream stream) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(stream);
 
        StringBuilder sb = new StringBuilder();
 
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = bi.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, bytesRead));
        }

        return sb.toString();
    }
}
