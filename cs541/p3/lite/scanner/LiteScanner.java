package lite.scanner;

import java_cup.runtime.Scanner;
import java.io.InputStream;
import lite.scanner.tokens.*;

public class LiteScanner implements Scanner
{
    protected Yylex scanner;

    public LiteScanner(InputStream inputStream)
    {
        this.scanner = new Yylex(inputStream);
    }

    public java_cup.runtime.Symbol next_token() throws java.lang.Exception
    {
        Symbol symbol = this.scanner.yylex();
        int symbolCode = symbol.sym;
        Token token = symbol.value;

        return new java_cup.runtime.Symbol(symbolCode, token);
    }
}
