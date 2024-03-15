package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.ChucVu;
import com.datn.dongho5s.Entity.NhanVien;
import com.datn.dongho5s.Exception.NhanVienNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;

public interface NhanVienService {
  public static final int USERS_PER_PAGE = 4;
  
  NhanVien findByEmail(String paramString);
  
  NhanVien findByUserName(String paramString);
  
  boolean existsByUserName(String paramString);
  
  boolean existSByEmail(String paramString);
  
  NhanVien getByEmail(String paramString);
  
  List<NhanVien> listAll();
  
  Page<NhanVien> listByPage(int paramInt, String paramString1, String paramString2, String paramString3);
  
  List<ChucVu> listChucVu();
  
  NhanVien save(NhanVien paramNhanVien);
  
  NhanVien nhanVienUpdateAccount(NhanVien paramNhanVien);
  
  void encodePassword(NhanVien paramNhanVien);
  
  boolean isEmailUnique(Integer paramInteger, String paramString);
  
  NhanVien get(Integer paramInteger) throws NhanVienNotFoundException;
  
  void delete(Integer paramInteger) throws NhanVienNotFoundException;
  
  void updateNhanVienEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\NhanVienService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */