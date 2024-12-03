public class Parser {
    private String input;
    private int position;

    public Parser(String input) {
        this.input = input;
        this.position = 0;
    }

    public void parse() throws ParseException {
        S();
        if (position != input.length()) {
            throw new ParseException("Unexpected characters at end");
        }
    }

    private void S() throws ParseException {
        if (position >= input.length()) {
            throw new ParseException("Unexpected end of input");
        }

        char current = input.charAt(position);
        if (current == 'b') {
            position++;
            S();
            match('b');
        } else if (current == 'c') {
            position++;
            A();
            match('c');
        } else {
            throw new ParseException("Expected 'b' or 'c'");
        }
    }

    private void A() throws ParseException {
        if (position >= input.length()) {
            throw new ParseException("Unexpected end of input");
        }

        char current = input.charAt(position);
        if (current == 'b') {
            position++;
            A();
            A();
        } else if (current == 'c') {
            position++;
            A();
            S();
            A();
            match('b');
        } else if (current == 'd') {
            position++;
            match('c');
            match('b');
        } else {
            throw new ParseException("Expected 'b', 'c', or 'd'");
        }
    }

    private void match(char expected) throws ParseException {
        if (position >= input.length()) {
            throw new ParseException("Unexpected end of input, expected '" + expected + "'");
        }

        char current = input.charAt(position);
        if (current != expected) {
            throw new ParseException("Expected '" + expected + "', found '" + current + "'");
        }
        position++;
    }
}