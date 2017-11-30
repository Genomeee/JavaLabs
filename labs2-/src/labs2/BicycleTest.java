package labs2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BicycleTest
{
  @Test(dataProvider="cursProvider")
  public void cursTest(Bicycle p1, int p2)
  {
    Assert.assertEquals(p1.In_Dollars(), p2);
  }
  
  @DataProvider
  public Object[][] cursProvider()
  {
    Bicycle a = new Bicycle();
    a.setPrice(5000);
    return new Object[][] { { a, Integer.valueOf(185) } };
  }
}