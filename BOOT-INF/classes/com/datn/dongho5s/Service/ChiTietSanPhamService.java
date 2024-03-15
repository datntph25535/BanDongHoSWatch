package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import com.datn.dongho5s.Exception.ChiTietSanPhamNotFountException;
import com.datn.dongho5s.Response.SanPhamAdminResponse;
import com.datn.dongho5s.Response.TimKiemSettingResponse;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ChiTietSanPhamService {
  public static final int PRODUCT_DETAIL_PER_PAGE = 5;
  
  TimKiemSettingResponse getTimKiemSetting();
  
  ChiTietSanPham getChiTietSanPhamById(Integer paramInteger);
  
  ChiTietSanPham update(ChiTietSanPham paramChiTietSanPham);
  
  Page<ChiTietSanPham> findByMaSP(String paramString, int paramInt);
  
  Page<ChiTietSanPham> getALlChiTietSanPhamPage(int paramInt);
  
  List<SanPhamAdminResponse> getAllSanPhamAminResponse(int paramInt);
  
  ChiTietSanPham findByMaChiTietSanPham(String paramString);
  
  ChiTietSanPham getChiTietSanPhamByMa(String paramString);
  
  List<ChiTietSanPham> listAll();
  
  Page<ChiTietSanPham> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  ChiTietSanPham save(ChiTietSanPham paramChiTietSanPham);
  
  ChiTietSanPham get(Integer paramInteger) throws ChiTietSanPhamNotFountException;
  
  boolean isUniqueChiTietSanPham(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  boolean isUniqueChiTietSanPhamUpdate(Integer paramInteger, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\ChiTietSanPhamService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */