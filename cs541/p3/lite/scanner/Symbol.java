package lite.scanner;

import java.util.Locale;
import lite.scanner.tokens.*;

// Symbol represents a parsed token, along with it's symbol type.
// The class contains a number of static factory methods to
// create instances wrapping specific token types.
//
// This class uses the Pos class (essentially a singleton) to 
// get parser line and column information. This is too tightly
// coupled for my taste, but oh well.
class Symbol
{ 
    public int sym;
    public Token value;

    // Use default Locale for normalizing identifiers/reserved words.
    private static Locale locale = Locale.getDefault();

    public Symbol(Token theToken)
    {
        sym = theToken.getTokenType();
        value = theToken;
    }

    // The following static methods return Symbol instances containing
    // instances of the appropriate Token subclass.
    public static Symbol createCharLiteral(String charVal)
    {
        return new Symbol(new CharLit(charVal, Pos.linenum, Pos.colnum));
    }

    public static Symbol createError(String message)
    {
        return new Symbol(new ErrorToken(message, Pos.linenum, Pos.colnum));
    }

    public static Symbol createIdentifier(String idText)
    {
        String normalized = idText.toLowerCase(locale);
        return new Symbol(new Identifier(normalized, Pos.linenum, Pos.colnum));
    }

    public static Symbol createIntegerLiteral(int intVal)
    {
        return new Symbol(new IntLit(intVal, Pos.linenum, Pos.colnum));
    }

    public static Symbol createStringLiteral(String stringVal)
    {
        return new Symbol(new StringLit(stringVal, Pos.linenum, Pos.colnum));
    }

    public static Symbol createAssignment()
    {
        return new Symbol(new Assignment(Pos.linenum, Pos.colnum));
    }

    public static Symbol createColon()
    {
        return new Symbol(new Colon(Pos.linenum, Pos.colnum));
    }

    public static Symbol createComma()
    {
        return new Symbol(new Comma(Pos.linenum, Pos.colnum));
    }

    public static Symbol createDivide()
    {
        return new Symbol(new Divide(Pos.linenum, Pos.colnum));
    }

    public static Symbol createEquals()
    {
        return new Symbol(new Equals(Pos.linenum, Pos.colnum));
    }

    public static Symbol createGreaterEqual()
    {
        return new Symbol(new GreaterEqual(Pos.linenum, Pos.colnum));
    }

    public static Symbol createGreaterThan()
    {
        return new Symbol(new GreaterThan(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordBool()
    {
        return new Symbol(new KeywordBool(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordBreak()
    {
        return new Symbol(new KeywordBreak(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordChar()
    {
        return new Symbol(new KeywordChar(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordClass()
    {
        return new Symbol(new KeywordClass(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordConst()
    {
        return new Symbol(new KeywordConst(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordContinue()
    {
        return new Symbol(new KeywordContinue(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordElse()
    {
        return new Symbol(new KeywordElse(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordFalse()
    {
        return new Symbol(new KeywordFalse(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordIf()
    {
        return new Symbol(new KeywordIf(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordInt()
    {
        return new Symbol(new KeywordInt(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordPrint()
    {
        return new Symbol(new KeywordPrint(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordRead()
    {
        return new Symbol(new KeywordRead(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordReturn()
    {
        return new Symbol(new KeywordReturn(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordTrue()
    {
        return new Symbol(new KeywordTrue(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordVoid()
    {
        return new Symbol(new KeywordVoid(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordWhile()
    {
        return new Symbol(new KeywordWhile(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLeftBrace()
    {
        return new Symbol(new LeftBrace(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLeftBracket()
    {
        return new Symbol(new LeftBracket(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLeftParen()
    {
        return new Symbol(new LeftParen(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLessEqual()
    {
        return new Symbol(new LessEqual(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLessThan()
    {
        return new Symbol(new LessThan(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLogicalAnd()
    {
        return new Symbol(new LogicalAnd(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLogicalNegation()
    {
        return new Symbol(new LogicalNegation(Pos.linenum, Pos.colnum));
    }

    public static Symbol createLogicalOr()
    {
        return new Symbol(new LogicalOr(Pos.linenum, Pos.colnum));
    }

    public static Symbol createMinus()
    {
        return new Symbol(new Minus(Pos.linenum, Pos.colnum));
    }

    public static Symbol createNotEquals()
    {
        return new Symbol(new NotEquals(Pos.linenum, Pos.colnum));
    }

    public static Symbol createPlus()
    {
        return new Symbol(new Plus(Pos.linenum, Pos.colnum));
    }

    public static Symbol createRightBrace()
    {
        return new Symbol(new RightBrace(Pos.linenum, Pos.colnum));
    }

    public static Symbol createRightBracket()
    {
        return new Symbol(new RightBracket(Pos.linenum, Pos.colnum));
    }

    public static Symbol createRightParen()
    {
        return new Symbol(new RightParen(Pos.linenum, Pos.colnum));
    }

    public static Symbol createSemicolon()
    {
        return new Symbol(new Semicolon(Pos.linenum, Pos.colnum));
    }

    public static Symbol createTimes()
    {
        return new Symbol(new Times(Pos.linenum, Pos.colnum));
    }

    public static Symbol createEOF()
    {
        return new Symbol(new EOF(Pos.linenum, Pos.colnum));
    }

    public static Symbol createKeywordFromString(String input)
    {
        String lc = input.toLowerCase(locale);

        if ( "bool".equals(lc) )
        {
            return createKeywordBool();
        }
        else if ( "break".equals(lc) )
        {
            return createKeywordBreak();
        }
        else if ( "char".equals(lc) )
        {
            return createKeywordChar();
        }
        else if ( "class".equals(lc) )
        {
            return createKeywordClass();
        }
        else if ( "const".equals(lc) )
        {
            return createKeywordConst();
        }
        else if ( "continue".equals(lc) )
        {
            return createKeywordContinue();
        }
        else if ( "else".equals(lc) )
        {
            return createKeywordElse();
        }
        else if ( "false".equals(lc) )
        {
            return createKeywordFalse();
        }
        else if ( "if".equals(lc) )
        {
            return createKeywordIf();
        }
        else if ( "int".equals(lc) )
        {
            return createKeywordInt();
        }
        else if ( "print".equals(lc) )
        {
            return createKeywordPrint();
        }
        else if ( "read".equals(lc) )
        {
            return createKeywordRead();
        }
        else if ( "return".equals(lc) )
        {
            return createKeywordReturn();
        }
        else if ( "true".equals(lc) )
        {
            return createKeywordTrue();
        }
        else if ( "void".equals(lc) )
        {
            return createKeywordVoid();
        }
        else if ( "while".equals(lc) )
        {
            return createKeywordWhile();
        }
        else
        {
            String message = new StringBuffer("Cannot create keyword token for `")
                                      .append(lc)
                                      .append("`")
                                      .toString();

            throw new IllegalArgumentException(message);
        }
    }
}
