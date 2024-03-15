package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.ThuongHieu;
import com.datn.dongho5s.Exception.ThuongHieuNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ThuongHieuService {
  public static final int BRANDS_PER_PAGE = 4;
  
  List<ThuongHieu> getAllThuongHieu();
  
  Page<ThuongHieu> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  ThuongHieu save(ThuongHieu paramThuongHieu);
  
  ThuongHieu get(Integer paramInteger) throws ThuongHieuNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString);
  
  void updateThuongHieuEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  List<ThuongHieu> layDanhSachTenThuongHieu();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\ThuongHieuService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */