import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* This Token class contains the token values of the broken down strings from the text file.
*
*
*/
public enum Token {
	TOKEN4 ("\\d+(\\.\\d+)?"),
	TOKEN3 ("\\d\\d"),
	TOKEN5  ("\"[^\"]+\""),
	TOKEN6  (","),
	TOKEN7  (";"),
	TOKEN10 ("prog"),
	TOKEN11 ("main"),
	TOKEN12 ("fcn"),
	TOKEN13 ("class"),
	
	TOKEN15 ("float"),
	TOKEN16 ("int"),
    TOKEN17 ("string"),
    TOKEN18 ("if"),
    TOKEN19 ("elseif"),
    TOKEN20 ("else"),
    TOKEN21 ("while"),
    TOKEN22 ("input"),
    TOKEN23 ("print"),
    TOKEN24 ("new"),
    TOKEN25 ("return"),
    TOKEN26 ("var"),
    
    TOKEN31 ("<"),
    TOKEN32 (">"),
    TOKEN33 ("\\{"),
    TOKEN34 ("\\}"),
    TOKEN35 ("\\["),
    TOKEN36 ("\\]"),
    TOKEN37 ("\\("),
	TOKEN38 ("\\)"),
	
	TOKEN41 ("\\*"),
	TOKEN42 ("\\^"),
	TOKEN43 ("\\:"),
	TOKEN44 ("\\."),
	TOKEN45 ("="),
	TOKEN46 ("-"),
	TOKEN47 ("\\+"),
	TOKEN48 ("/"),

	TOKEN51 ("->"),
	TOKEN52 ("=="),
	TOKEN53 ("!="),
	TOKEN54 ("<="),
	TOKEN55 (">="),
	TOKEN56 ("<<"),
	TOKEN57 (">>"),
	TOKEN2 ("\\w+");
	
    
    private final Pattern pattern;
 
    Token(String regex) { //regex pattern finder
        pattern = Pattern.compile("^" + regex);
    }
	
    /**        
    * 
    *This endOfMatch function finds the end of the token and stops the search for the token once it reaches the end of a pattern
    *@param s the chars in the token
    */
    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}
