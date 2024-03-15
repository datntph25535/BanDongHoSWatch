package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.DayDeo;
import com.datn.dongho5s.Exception.DayDeoNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface DayDeoService {
  public static final int STRAPS_PER_PAGE = 4;
  
  List<DayDeo> getAllDayDeo();
  
  Page<DayDeo> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  DayDeo save(DayDeo paramDayDeo);
  
  DayDeo get(Integer paramInteger) throws DayDeoNotFoundException, Exception;
  
  boolean checkUnique(Integer paramInteger, String paramString);
  
  void updateDayDeoEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\DayDeoService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */