package labs2;

import java.io.IOException;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestOut
{
  @Test
  public void TestBicycleJson()
    throws IOException
  {
    Bicycle e1 = new BicycleBuilder()
      .buildID(1)
      .buildMake("USA")
      .buildPrice(5000)
      .buildGear(18)
      .buildSpeed(50)
      .buildType(Bicycle.Type.BMX)
      .build();
    new BicycleJSON().serialize(e1, "BicycleJson.json");
    
    Bicycle res = new BicycleJSON().deserialize("BicycleJson.json");
    
    AssertJUnit.assertEquals(res.toString(), res.toString());
  }
  
  @Test
  public void TestBicycleXML()
    throws IOException
  {
    Bicycle e1 = new BicycleBuilder()
      .buildID(1)
      .buildMake("USA")
      .buildPrice(5000)
      .buildGear(18)
      .buildSpeed(50)
      .buildType(Bicycle.Type.BMX)
      .build();
    new BicycleXML().serialize(e1, "BicycleXml.xml");
    
    Bicycle res = new BicycleXML().deserialize("BicycleXML.xml");
    
    AssertJUnit.assertEquals(e1.toString(), res.toString());
  }
  
  @Test
  public void TestBicycleStoreXML()
    throws IOException
  {
    Bicycle e1 = new BicycleBuilder()
      .buildID(1)
      .buildMake("USA")
      .buildPrice(5000)
      .buildGear(18)
      .buildSpeed(50)
      .buildType(Bicycle.Type.BMX)
      .build();
    Bicycle e11 = new BicycleBuilder()
      .buildID(2)
      .buildMake("China")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.MOUNTAIN)
      .build();
    Bicycle e2 = new BicycleBuilder()
      .buildID(3)
      .buildMake("USA")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.HYBRID)
      .build();
    Bicycle e3 = new BicycleBuilder()
      .buildID(14)
      .buildMake("RUSSIA")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.ROAD)
      .build();
    BicycleStore m = new BicycleStore();
    m.addBicycles(e1);
    m.addBicycles(e3);
    m.addBicycles(e2);
    m.addBicycles(e11);
    
    new BicycleStoreXml().serialize(m, "BicycleStoreXML.xml");
    
    BicycleStore c3 = new BicycleStoreXml().deserialize("BicycleStoreXML.xml");
    
    AssertJUnit.assertEquals(c3.getName(), m.getName());
  }
  
  @Test
  public void TestBicycleStoreJson()
    throws IOException
  {
    Bicycle e1 = new BicycleBuilder()
      .buildID(1)
      .buildMake("USA")
      .buildPrice(5000)
      .buildGear(18)
      .buildSpeed(50)
      .buildType(Bicycle.Type.BMX)
      .build();
    Bicycle e11 = new BicycleBuilder()
      .buildID(2)
      .buildMake("China")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.MOUNTAIN)
      .build();
    Bicycle e2 = new BicycleBuilder()
      .buildID(3)
      .buildMake("USA")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.HYBRID)
      .build();
    Bicycle e3 = new BicycleBuilder()
      .buildID(14)
      .buildMake("RUSSIA")
      .buildPrice(2000)
      .buildGear(16)
      .buildSpeed(35)
      .buildType(Bicycle.Type.ROAD)
      .build();
    
    BicycleStore m = new BicycleStore();
    m.addBicycles(e1);
    m.addBicycles(e3);
    m.addBicycles(e2);
    m.addBicycles(e11);
    
    BicycleStore m1 = new BicycleStore();
    m1.addBicycles(e2);
    m1.addBicycles(e3);
    
    new BicycleStoreJSON().serialize(m, "BicycleStoreJSON.json");
    
    BicycleStore c3 = new BicycleStoreJSON().deserialize("BicycleStoreJson.json");
    
    AssertJUnit.assertEquals(c3.getName(), m.getName());
  }
}

