package labs2;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BicycleStoreTest
{
  @Test(dataProvider="inPriceCategoryProvider")
  public void inPriceCategoryTest(BicycleStore storage, int left, int right, BicycleStore expected)
  {
    AssertJUnit.assertEquals(storage.inPriceCategory(left, right), expected.getBicycles());
  }
  
  @DataProvider
  public Object[][] inPriceCategoryProvider()
  {
    BicycleStore storage = new BicycleStoreBuilder().build();
    for (int i = 10; i <= 50; i += 10) {
      storage.addBicycles(new BicycleBuilder().buildPrice(i).build());
    }
    return new Object[][] {
      { storage, Integer.valueOf(5), Integer.valueOf(15), new BicycleStoreBuilder().addBicycle(storage.getBicycles(0)).build() }, 
      { storage, Integer.valueOf(15), Integer.valueOf(35), new BicycleStoreBuilder().addBicycle(storage.getBicycles(1)).addBicycle(storage.getBicycles(2)).build() }, 
      { storage, Integer.valueOf(5), Integer.valueOf(100), storage }, 
      { storage, Integer.valueOf(1), Integer.valueOf(5), new BicycleStoreBuilder().build() } };
  }
  
  @Test(dataProvider="inTypeProvider")
  public void inTypeTest(BicycleStore storage, Bicycle.Type type, BicycleStore expected)
  {
    AssertJUnit.assertEquals(storage.inType(type), expected.getBicycles());
  }
  
  @DataProvider
  public Object[][] inTypeProvider()
  {
    Bicycle p1 = new BicycleBuilder().buildType(Bicycle.Type.ROAD).build();
    Bicycle p2 = new BicycleBuilder().buildType(Bicycle.Type.MOUNTAIN).build();
    BicycleStore storage = new BicycleStoreBuilder().addBicycle(p1).addBicycle(p2).addBicycle(p2).build();
    return new Object[][] {
      { storage, Bicycle.Type.ROAD, new BicycleStoreBuilder().addBicycle(p1).build() }, 
      { storage, Bicycle.Type.MOUNTAIN, new BicycleStoreBuilder().addBicycle(p2).addBicycle(p2).build() } };
  }
  
  @Test(dataProvider="inPriceProvider")
  public void inPriceTest(BicycleStore storage, int price, BicycleStore expected)
  {
    AssertJUnit.assertEquals(storage.inPrice(price), expected.getBicycles());
  }
  
  @DataProvider
  public Object[][] inPriceProvider()
  {
    Bicycle p1 = new BicycleBuilder().buildPrice(5000).build();
    Bicycle p2 = new BicycleBuilder().buildPrice(7000).build();
    BicycleStore storage = new BicycleStoreBuilder().addBicycle(p1).addBicycle(p2).addBicycle(p2).build();
    return new Object[][] {
      { storage, Integer.valueOf(5000), new BicycleStoreBuilder().addBicycle(p1).build() }, 
      { storage, Integer.valueOf(7000), new BicycleStoreBuilder().addBicycle(p2).addBicycle(p2).build() } };
  }
}

