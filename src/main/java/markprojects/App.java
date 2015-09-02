package markprojects;



public class App {


    public static void main( String[] args ) throws Exception {
        for(String symbol : Constants.SYMBOLS) {
            symbol = symbol.trim();	//TODO: drop the trim when the list is cleaned up

            String uri = YahooPuller.buildURI(symbol, Constants.START_DAY, Constants.END_DAY);

            String response = YahooPuller.doCall(uri);

            int lineIndex = 0;
            for(String line : response.split("\n")) {
               if(lineIndex > 0) {
                   Record r = new Record(symbol, line);
               }
               lineIndex++;
            }
        }//END for symbol
    }

}
