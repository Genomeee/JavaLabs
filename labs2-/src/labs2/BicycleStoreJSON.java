package labs2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class BicycleStoreJSON
  implements Serializer<BicycleStore>
{
  public void serialize(BicycleStore obj, String title)
    throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    mapper.writeValue(new File("output/" + title), obj);
  }
  
  public BicycleStore deserialize(String title)
    throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    BicycleStore c = (BicycleStore)mapper.readValue(new File("output/" + title), BicycleStore.class);
    System.out.println(c.toString());
    return c;
  }
}
