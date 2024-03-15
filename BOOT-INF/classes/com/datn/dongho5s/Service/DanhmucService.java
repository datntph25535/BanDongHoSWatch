package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.DanhMuc;
import com.datn.dongho5s.Exception.DanhMucNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface DanhmucService {
  List<DanhMuc> listAll();
  
  Page<DanhMuc> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  void updateDanhMucEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  DanhMuc save(DanhMuc paramDanhMuc);
  
  DanhMuc get(Integer paramInteger) throws DanhMucNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\DanhmucService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */