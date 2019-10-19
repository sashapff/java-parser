class StringTokenizer<T> {
    private Token token;
    private String name;
    private T value;
    private int index;
    private String expression;
    private int balance;
    private Operation<T> operation;

    StringTokenizer(String expression, Operation<T> operation) {
        token = Token.BEGIN;
        name = "";
        index = 0;
        balance = 0;
        this.expression = expression;
        this.operation = operation;
    }

    Token getToken() {
        return token;
    }

    T getValue() {
        return value;
    }

    String getName() {
        return name;
    }

    String getExpression() {
        return expression;
    }

    int getIndex() {
        return index;
    }

    void next() throws ParsingException, IllegalOperationException {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
        if (index >= expression.length()) {
            if (balance > 0) {
                throw new ExtraOpenBracketException(index);
            }
            if (index != expression.length()) {
                token = Token.END;
            }
            if (token != Token.CLOSEBRACKET && token != Token.NUMBER && token != Token.VARIABLE) {
                throw new MissingOperandException(index);
            }
            index++;
            return;
        }
        char symbol = expression.charAt(index);
        if (symbol == '+') {
            checkForOperand();
            token = Token.ADD;
        } else if (symbol == '-') {
            if (token == Token.NUMBER || token == Token.VARIABLE || token == Token.CLOSEBRACKET) {
                token = Token.SUBTRACT;
            } else {
                index++;
                if (index >= expression.length()) {
                    throw new MissingOperandException(index);
                }
                while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
                    index++;
                }
                if ((Character.isDigit(expression.charAt(index)) || isPartOfNumber(expression.charAt(index)))) {
                    int l = index;
                    while (index < expression.length() && (Character.isDigit(expression.charAt(index))
                            || isPartOfNumber(expression.charAt(index)))) {
                        index++;
                    }
                    int r = index;
                    String s = expression.substring(l, r);
                    try {
                        value = operation.parseNumber(("-" + s));
                    } catch (NumberFormatException e) {
                        throw new IllegalConstantException("-" + s);
                    }
                    token = Token.NUMBER;
                } else {
                    token = Token.SUBTRACT;
                }
                index--;
            }
        } else if (symbol == '*') {
            checkForOperand();
            token = Token.MULTIPLY;
        } else if (symbol == '/') {
            checkForOperand();
            token = Token.DIVIDE;
        } else if (Character.isDigit(symbol) || isPartOfNumber(symbol)) {
            checkForOperation();
            int left = index;
            while (index < expression.length() && (Character.isDigit(expression.charAt(index))
                    || isPartOfNumber(expression.charAt(index)))) {
                index++;
            }
            int right = index;
            try {
                value = operation.parseNumber(expression.substring(left, right));
            } catch (NumberFormatException e) {
                throw new IllegalConstantException(expression.substring(left, right));
            }
            token = Token.NUMBER;
            index--;
        } else if (symbol == 'x' || symbol == 'y' || symbol == 'z') {
            name = "";
            name += symbol;
            token = Token.VARIABLE;
        } else if (symbol == '(') {
            checkForOperation();
            balance++;
            token = Token.OPENBRACKET;
        } else if (symbol == ')') {
            checkForOperand();
            balance--;
            token = Token.CLOSEBRACKET;
            if (balance < 0) {
                throw new ExtraCloseBracketException(index);
            }
        } else if (index + 3 <= expression.length() && expression.substring(index, index + 3).equals("max")) {
            checkForOperand();
            token = Token.MAX;
            checkNextPosition(index + 3);
            index += 2;
        } else if (index + 3 <= expression.length() && expression.substring(index, index + 3).equals("min")) {
            checkForOperand();
            token = Token.MIN;
            checkNextPosition(index + 3);
            index += 2;
        } else if (index + 3 <= expression.length() && expression.substring(index, index + 3).equals("abs")) {
            token = Token.ABS;
            checkForOperation();
            checkNextPosition(index + 3);
            index += 2;
        } else if (index + 3 <= expression.length() && expression.substring(index, index + 3).equals("mod")) {
            token = Token.MOD;
            checkForOperation();
            checkNextPosition(index + 3);
            index += 2;
        } else if (index + 6 <= expression.length() && expression.substring(index, index + 6).equals("square")) {
            token = Token.SQUARE;
            checkForOperation();
            checkNextPosition(index + 6);
            index += 5;
        } else {
            if (Character.isLetter(expression.charAt(index))) {
                throw new UnknownNameException(index);
            } else {
                throw new UnknownCharacterException(index);
            }
        }
        index++;
    }

    private boolean isPartOfNumber(final char x) {
        return Character.isDigit(x) || x == '.' || x == 'e';
    }

    private void checkForOperand() throws MissingOperandException {
        if (token != Token.CLOSEBRACKET && token != Token.NUMBER && token != Token.VARIABLE) {
            throw new MissingOperandException(index);
        }
    }

    private void checkForOperation() throws MissingOperationException {
        if (token == Token.CLOSEBRACKET || token == Token.VARIABLE || token == Token.NUMBER) {
            throw new MissingOperationException();
        }
    }

    private void checkNextPosition(int position) throws IllegalOperationException {
        if (position >= expression.length() || (expression.charAt(position) != '-'
                && expression.charAt(position) != ' ' && expression.charAt(position) != '(')) {
            throw new IllegalOperationException("Number or variable after operation without space");
        }
    }

}
