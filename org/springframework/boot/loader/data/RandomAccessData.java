package org.springframework.boot.loader.data;

import java.io.IOException;
import java.io.InputStream;

public interface RandomAccessData {
  InputStream getInputStream() throws IOException;
  
  RandomAccessData getSubsection(long paramLong1, long paramLong2);
  
  byte[] read() throws IOException;
  
  byte[] read(long paramLong1, long paramLong2) throws IOException;
  
  long getSize();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\data\RandomAccessData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */