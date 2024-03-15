package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.KhuyenMai;
import com.datn.dongho5s.Exception.KhuyenMaiNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface KhuyenMaiService {
  public static final int DISCOUNT_PER_PAGE = 4;
  
  List<KhuyenMai> listAll();
  
  Page<KhuyenMai> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  KhuyenMai save(KhuyenMai paramKhuyenMai);
  
  KhuyenMai get(Integer paramInteger) throws KhuyenMaiNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString1, String paramString2);
  
  List<KhuyenMai> getExpiredKhuyenMai();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\KhuyenMaiService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */