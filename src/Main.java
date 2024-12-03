public class Main {
    public static void main(String[] args) {
        String[] tests = {
                "cdcbc", "bcdcbcb", "cbdcbdcbc",
                "ccdcbcdcbcdcbbcr", "cdcbbb", "cdcb", ""
        };

        for (String test : tests) {
            Parser parser = new Parser(test);
            System.out.println("Testing: \"" + test + "\"");
            try {
                parser.parse();
                System.out.println("Valid");
            } catch (ParseException e) {
                System.out.println("Invalid: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
