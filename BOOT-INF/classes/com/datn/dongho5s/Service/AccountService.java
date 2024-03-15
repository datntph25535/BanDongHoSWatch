package BOOT-INF.classes.com.datn.dongho5s.Service;

import com.datn.dongho5s.Entity.KhachHang;
import com.datn.dongho5s.Request.ChangePassRequest;
import com.datn.dongho5s.Request.RegisterRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface AccountService {
  ResponseEntity<?> register(RegisterRequest paramRegisterRequest) throws Exception;
  
  HashMap<Integer, String> getListTP();
  
  HashMap<Integer, String> getListQuan(Integer paramInteger) throws Exception;
  
  HashMap<String, String> getListPhuong(Integer paramInteger) throws Exception;
  
  ResponseEntity<?> changePass(Principal paramPrincipal, ChangePassRequest paramChangePassRequest) throws Exception;
  
  void createPasswordResetTokenForUser(KhachHang paramKhachHang, String paramString);
  
  String validatePasswordResetToken(String paramString);
  
  Optional<KhachHang> getUserByPasswordResetToken(String paramString);
  
  void changeforgotPass(KhachHang paramKhachHang, String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\AccountService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */