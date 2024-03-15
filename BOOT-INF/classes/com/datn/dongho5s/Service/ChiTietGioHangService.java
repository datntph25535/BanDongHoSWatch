package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Request.CartRequest;
import com.datn.dongho5s.Response.ChiTietGioHangResponse;
import java.util.List;

public interface ChiTietGioHangService {
  List<ChiTietGioHangResponse> getChiTietGioHang(Integer paramInteger);
  
  ChiTietGioHangResponse update(Integer paramInteger1, Integer paramInteger2) throws Exception;
  
  void delete(Integer paramInteger);
  
  void deleteAll();
  
  ChiTietGioHangResponse add(CartRequest paramCartRequest);
  
  ChiTietGioHangResponse addToCart(CartRequest paramCartRequest);
  
  void removeByCTSPAndKhachHang(Integer paramInteger, List<Integer> paramList);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\ChiTietGioHangService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */