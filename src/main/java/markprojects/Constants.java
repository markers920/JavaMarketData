package markprojects;

public class Constants {

    //TODO: rename these
    public static final int FILTER_SYMBOL = 0;
    public static final int FILTER_TIMESTAMP = 1;
    public static final int FILTER_OPEN = 2;
    public static final int FILTER_HIGH = 3;
    public static final int FILTER_LOW = 4;
    public static final int FILTER_CLOSE = 5;
    public static final int FILTER_VOLUME = 6;
    public static final int FILTER_ADJCLOSE = 7;


    public static final TradingDay START_DAY = new TradingDay(2015, 0, 1);     //January 1                            
    public static final TradingDay END_DAY = new TradingDay(2015, 7, 31);      //August 31

    //TODO: clean these up
    public static final String[] SYMBOLS = {
        "	AAPL	", //	Apple Inc.
        "	ABBV	", //	AbbVie Inc.
        "	ABT	", //	Abbott Laboratories
        "	ACN	", //	Accenture plc
        "	AIG	", //	American International Group Inc.
        "	ALL	", //	Allstate Corp.
        "	AMGN	", //	Amgen Inc.
        "	AMZN	", //	Amazon.com
        "	APA	", //	Apache Corp.
        "	APC	", //	Anadarko Petroleum Corporation
        "	AXP	", //	American Express Inc.
        "	BA	", //	Boeing Co.
        "	BAC	", //	Bank of America Corp
        "	BAX	", //	Baxter International Inc
        "	BIIB	", //	Biogen Idec
        "	BK	", //	Bank of New York
        "	BMY	", //	Bristol-Myers Squibb
        //"	BRK.B	", //	Berkshire Hathaway
        "	C	", //	Citigroup Inc
        "	CAT	", //	Caterpillar Inc
        "	CL	", //	Colgate-Palmolive Co.
        "	CMCSA	", //	Comcast Corporation
        "	COF	", //	Capital One Financial Corp.
        "	COP	", //	ConocoPhillips
        "	COST	", //	Costco
        "	CSCO	", //	Cisco Systems
        "	CVS	", //	CVS Caremark
        "	CVX	", //	Chevron
        "	DD	", //	DuPont
        "	DIS	", //	The Walt Disney Company
        "	DOW	", //	Dow Chemical
        "	DVN	", //	Devon Energy
        "	EBAY	", //	eBay Inc.
        "	EMC	", //	EMC Corporation
        "	EMR	", //	Emerson Electric Co.
        "	EXC	", //	Exelon
        "	F	", //	Ford Motor
        "	FB	", //	Facebook
        "	FCX	", //	Freeport-McMoran
        "	FDX	", //	FedEx
        "	FOXA	", //	Twenty-First Century Fox, Inc
        "	GD	", //	General Dynamics
        "	GE	", //	General Electric Co.
        "	GILD	", //	Gilead Sciences
        "	GM	", //	General Motors
        "	GOOG	", //	Google Inc.
        "	GS	", //	Goldman Sachs
        "	HAL	", //	Halliburton
        "	HD	", //	Home Depot
        "	HON	", //	Honeywell
        "	HPQ	", //	Hewlett Packard Co
        "	IBM	", //	International Business Machines
        "	INTC	", //	Intel Corporation
        "	JNJ	", //	Johnson & Johnson Inc
        "	JPM	", //	JP Morgan Chase & Co
        "	KO	", //	The Coca-Cola Company
        "	LLY	", //	Eli Lilly and Company
        "	LMT	", //	Lockheed-Martin
        "	LOW	", //	Lowe's
        "	MA	", //	Mastercard Inc
        "	MCD	", //	McDonald's Corp
        "	MDLZ	", //	Mondel Sz International
        "	MDT	", //	Medtronic Inc.
        "	MET	", //	Metlife Inc.
        "	MMM	", //	3M Company
        "	MO	", //	Altria Group
        "	MON	", //	Monsanto
        "	MRK	", //	Merck & Co.
        "	MS	", //	Morgan Stanley
        "	MSFT	", //	Microsoft
        "	NKE	", //	Nike
        "	NOV	", //	National Oilwell Varco
        "	NSC	", //	Norfolk Southern Corp
        "	ORCL	", //	Oracle Corporation
        "	OXY	", //	Occidental Petroleum Corp.
        "	PEP	", //	Pepsico Inc.
        "	PFE	", //	Pfizer Inc
        "	PG	", //	Procter & Gamble Co
        "	PM	", //	Phillip Morris International
        "	QCOM	", //	Qualcomm Inc.
        "	RTN	", //	Raytheon Co (NEW)
        "	SBUX	", //	Starbucks Corporation
        "	SLB	", //	Schlumberger
        "	SO	", //	Southern Company
        "	SPG	", //	Simon Property Group, Inc.
        "	T	", //	AT&T Inc
        "	TGT	", //	Target Corp.
        "	TWX	", //	Time Warner Inc.
        "	TXN	", //	Texas Instruments
        "	UNH	", //	UnitedHealth Group Inc.
        "	UNP	", //	Union Pacific Corp.
        "	UPS	", //	United Parcel Service Inc
        "	USB	", //	US Bancorp
        "	UTX	", //	United Technologies Corp
        "	V	", //	Visa Inc.
        "	VZ	", //	Verizon Communications Inc
        "	WBA	", //	Walgreens Boots Alliance
        "	WFC	", //	Wells Fargo
        "	WMT	", //	Wal-Mart
        "	XOM	" //	Exxon Mobil Corp
    };

}
