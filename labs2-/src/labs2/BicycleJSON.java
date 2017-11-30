package labs2;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class BicycleJSON
  implements Serializer<Bicycle>
{
  public void serialize(Bicycle obj, String title)
    throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    mapper.writeValue(new File("output/" + title), obj);
  }
  
  public Bicycle deserialize(String title)
    throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    Bicycle c = (Bicycle)mapper.readValue(new File("output/" + title), Bicycle.class);
    System.out.println(c.toString());
    return c;
  }
}

