package labs2;

import java.io.IOException;

public abstract interface Serializer<T>
{
  public abstract void serialize(T paramT, String paramString)
    throws IOException;
  
  public abstract T deserialize(String paramString)
    throws IOException;
}