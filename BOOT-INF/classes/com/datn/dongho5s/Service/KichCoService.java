package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.KichCo;
import com.datn.dongho5s.Exception.KichCoNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface KichCoService {
  public static final int SIZES_PER_PAGE = 4;
  
  List<KichCo> getAllKichCo();
  
  List<KichCo> getAllPaginationKichCo();
  
  Page<KichCo> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  KichCo save(KichCo paramKichCo);
  
  KichCo get(Integer paramInteger) throws KichCoNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString);
  
  void updateKichCoEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\KichCoService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */