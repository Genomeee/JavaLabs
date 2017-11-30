package labs2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BicycleStoreBuilder
{
  private List<Bicycle> bicycles;
  private String name;
  private int id;
  private final String MADE_PATTERN = "^[A-Z].{0,100}";
  
  public BicycleStoreBuilder()
  {
    this.bicycles = new ArrayList();
    this.name = "Store";
    this.id = 0;
  }
  
  public BicycleStoreBuilder setId(int id)
  {
    this.id = id;
    return this;
  }
  
  public BicycleStoreBuilder setBicycles(List<Bicycle> bicycles)
  {
    this.bicycles = bicycles;
    return this;
  }
  
  public BicycleStoreBuilder addBicycle(Bicycle bicycle)
  {
    this.bicycles.add(bicycle);
    return this;
  }
  
  public BicycleStoreBuilder setName(String name)
  {
    if (!Pattern.matches("^[A-Z].{0,100}", name)) {
      throw new IllegalArgumentException("Too long name");
    }
    this.name = name;
    return this;
  }
  
  public BicycleStoreBuilder fromString(String input)
  {
    this.name = REG.getRegexGroup(input, "made: ^[A-Z].{0,100}$;");
    this.bicycles = new ArrayList();
    String[] bicyclesArray = REG.getRegexGroup(input, "bicycles: (.+)").split("/");
    String[] arrayOfString1;
    int j = (arrayOfString1 = bicyclesArray).length;
    for (int i = 0; i < j; i++)
    {
      String bicycle = arrayOfString1[i];
      if (!bicycle.isEmpty()) {
        this.bicycles.add(new BicycleBuilder().fromString(bicycle).build());
      }
    }
    return this;
  }
  
  public BicycleStore build()
  {
    return new BicycleStore(this.name, this.bicycles, this.id);
  }
}

