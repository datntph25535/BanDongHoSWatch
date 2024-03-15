package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.MauSac;
import java.util.List;
import org.springframework.data.domain.Page;

public interface MauSacService {
  List<MauSac> getAllMauSac();
  
  Page<MauSac> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  void updateMauSacEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  MauSac save(MauSac paramMauSac);
  
  MauSac get(Integer paramInteger) throws Exception;
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\MauSacService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */