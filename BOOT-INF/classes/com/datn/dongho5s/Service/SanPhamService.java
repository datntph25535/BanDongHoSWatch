package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.SanPham;
import com.datn.dongho5s.Entity.ThuongHieu;
import com.datn.dongho5s.Exception.SanPhamNotFountException;
import com.datn.dongho5s.Request.TimKiemRequest;
import com.datn.dongho5s.Response.ChiTietSanPhamResponse;
import com.datn.dongho5s.Response.SanPhamDetailResponse;
import com.datn.dongho5s.Response.TimKiemResponse;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;

public interface SanPhamService {
  public static final int PRODUCT_PER_PAGE = 5;
  
  Set<TimKiemResponse> getSanPhamByCondition(TimKiemRequest paramTimKiemRequest);
  
  List<SanPhamDetailResponse> getSPnew();
  
  List<SanPhamDetailResponse> getSPFeature();
  
  List<SanPhamDetailResponse> getSPchay();
  
  SanPhamDetailResponse getDetailSanPhamById(Integer paramInteger);
  
  List<ChiTietSanPhamResponse> getSPchayKM(Integer paramInteger);
  
  List<SanPham> listAll();
  
  SanPham save(SanPham paramSanPham);
  
  SanPham get(Integer paramInteger) throws SanPhamNotFountException;
  
  Page<SanPham> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  List<SanPham> getSPCungTH(ThuongHieu paramThuongHieu);
  
  boolean checkUniqueTenAndMa(String paramString1, String paramString2);
  
  boolean checkUniqueTenMaId(String paramString1, String paramString2, Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\SanPhamService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */