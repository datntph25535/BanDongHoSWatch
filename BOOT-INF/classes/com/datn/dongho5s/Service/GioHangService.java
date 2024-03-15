package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Request.GioHangRequest;
import com.datn.dongho5s.Response.GiohangResponse;

public interface GioHangService {
  GiohangResponse addGioHang(GioHangRequest paramGioHangRequest);
  
  GiohangResponse findGioHang(Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\GioHangService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */