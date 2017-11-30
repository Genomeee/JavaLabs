package labs2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REG
{
  public static final String MADE_REGEX = "made: ^[A-Z].{0,100}$;";
  public static final String PRICE_REGEX = "price: (\\d*[\\.,]\\d*)";
  public static final String GEAR_REGEX = "gear: (\\d*[\\.,]\\d*)";
  public static final String SPEED_REGEX = "speed: (\\d*[\\.,]\\d*)";
  public static final String TYPE_REGEX = "type: ([A-Z]+);";
  public static final String BICYCLES_REGEX = "bicycles: (.+)";
  
  public static String getRegexGroup(String input, String regex)
  {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (!m.find()) {
      throw new IllegalArgumentException();
    }
    return m.group(1);
  }
}