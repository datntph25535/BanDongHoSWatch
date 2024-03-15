package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.DiaChi;
import com.datn.dongho5s.Entity.KhachHang;
import com.datn.dongho5s.Request.DiaChiRequest;
import com.datn.dongho5s.Response.DiaChiResponse;
import java.util.List;

public interface DiaChiService {
  DiaChiResponse createDiaChi(Integer paramInteger, DiaChiRequest paramDiaChiRequest) throws Exception;
  
  List<DiaChi> getAllDiaChi();
  
  List<DiaChi> getAllDiaChiByKhachHang(KhachHang paramKhachHang);
  
  List<DiaChiResponse> getDiaChiByKhachHang(Integer paramInteger) throws Exception;
  
  DiaChiResponse updateDC(Integer paramInteger, DiaChiRequest paramDiaChiRequest) throws Exception;
  
  DiaChiResponse updateDCDefault(Integer paramInteger1, Integer paramInteger2) throws Exception;
  
  void delete(Integer paramInteger);
  
  String getDiaChiCuThe(DiaChiRequest paramDiaChiRequest) throws Exception;
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\DiaChiService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */