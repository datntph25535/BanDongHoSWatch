package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import com.datn.dongho5s.Entity.Seri;
import java.util.List;
import org.springframework.data.domain.Page;

public interface SeriService {
  Seri save(Seri paramSeri);
  
  List<Seri> saveMany(List<Seri> paramList);
  
  Seri get(Integer paramInteger);
  
  Page<Seri> searchSeri(int paramInt1, int paramInt2, String paramString);
  
  Integer countSeri(Integer paramInteger);
  
  List<Seri> findByChiTietSanPham(ChiTietSanPham paramChiTietSanPham, Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\SeriService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */