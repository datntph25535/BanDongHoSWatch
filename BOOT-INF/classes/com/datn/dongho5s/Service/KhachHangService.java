package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.KhachHang;
import com.datn.dongho5s.Exception.KhachHangNotFoundException;
import com.datn.dongho5s.Response.ThongTinCaNhanResponse;
import com.datn.dongho5s.Response.ThongTinToCheckoutResponse;
import java.util.List;
import org.springframework.data.domain.Page;

public interface KhachHangService {
  public static final int CUSTOMERS_PER_PAGE = 4;
  
  KhachHang findKhachHangById(Integer paramInteger);
  
  KhachHang get(Integer paramInteger) throws KhachHangNotFoundException, Exception;
  
  KhachHang updateThongTinCaNhan(Integer paramInteger, ThongTinCaNhanResponse paramThongTinCaNhanResponse);
  
  ThongTinCaNhanResponse getThongTinCaNhanById(Integer paramInteger);
  
  ThongTinToCheckoutResponse getThongTinToCheckout(Integer paramInteger);
  
  void saveKhachHang(KhachHang paramKhachHang);
  
  List<KhachHang> getAllKhachHang();
  
  List<KhachHang> getAllPaginationVatLieu();
  
  Page<KhachHang> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  boolean checkUnique(Integer paramInteger, String paramString1, String paramString2);
  
  KhachHang findByPhoneNumber(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\KhachHangService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */