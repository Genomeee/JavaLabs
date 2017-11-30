package labs2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BicycleXML  implements Serializer<Bicycle>
{
  public void serialize(Bicycle obj, String title)
    throws IOException
  {
    File file = new File("output/" + title);
    String xmlString = "";
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { Bicycle.class });
      Marshaller m = context.createMarshaller();
      
      m.setProperty("jaxb.formatted.output", Boolean.TRUE);
      
      StringWriter sw = new StringWriter();
      m.marshal(obj, sw);
      xmlString = sw.toString();
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
    FileWriter fw = new FileWriter(file);
    fw.write(xmlString);
    fw.close();
  }
  
  public Bicycle deserialize(String title)
    throws IOException
  {
    Bicycle e = null;
    try
    {
      File file = new File("output/" + title);
      JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { Bicycle.class });
      
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      e = (Bicycle)jaxbUnmarshaller.unmarshal(file);
    }
    catch (JAXBException err)
    {
      err.printStackTrace();
    }
    return e;
  }
}

