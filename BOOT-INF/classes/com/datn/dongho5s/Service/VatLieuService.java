package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.VatLieu;
import com.datn.dongho5s.Exception.VatLieuNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface VatLieuService {
  public static final int MATERIALS_PER_PAGE = 4;
  
  List<VatLieu> getAllVatLieu();
  
  List<VatLieu> getAllPaginationVatLieu();
  
  Page<VatLieu> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  VatLieu save(VatLieu paramVatLieu);
  
  VatLieu get(Integer paramInteger) throws VatLieuNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString);
  
  void updateVatLieuEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\VatLieuService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */