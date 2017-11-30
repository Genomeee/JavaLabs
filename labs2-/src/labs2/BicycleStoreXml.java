package labs2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BicycleStoreXml
  implements Serializer<BicycleStore>
{
  public void serialize(BicycleStore obj, String title)
    throws IOException
  {
    File file = new File("output/" + title);
    String xmlString = "";
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { BicycleStore.class });
      Marshaller m = context.createMarshaller();
      m.setProperty("jaxb.formatted.output", Boolean.TRUE);
      
      StringWriter sw = new StringWriter();
      m.marshal(obj, sw);
      xmlString = sw.toString();
      System.out.println(xmlString);
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
    FileWriter fw = new FileWriter(file);
    fw.write(xmlString);
    fw.close();
  }
  
  public BicycleStore deserialize(String title)
    throws IOException
  {
    BicycleStore c = null;
    try
    {
      File file = new File("output/" + title);
      JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { BicycleStore.class });
      
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      c = (BicycleStore)jaxbUnmarshaller.unmarshal(file);
      System.out.println(c.toString());
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
    return c;
  }
}

