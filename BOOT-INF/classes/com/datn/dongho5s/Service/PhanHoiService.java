package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Request.PhanHoiRequest;
import com.datn.dongho5s.Response.PhanHoiResponse;
import java.util.List;

public interface PhanHoiService {
  List<PhanHoiResponse> findAll(Integer paramInteger);
  
  boolean checkPhanHoi(Integer paramInteger1, Integer paramInteger2);
  
  PhanHoiResponse addPhanHoi(PhanHoiRequest paramPhanHoiRequest);
  
  Long countPH(Integer paramInteger1, Integer paramInteger2);
  
  Long countHDCT(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\PhanHoiService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */