package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.KhachHang;
import com.datn.dongho5s.Entity.PasswordResetToken;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
  PasswordResetToken findByToken(String paramString);
  
  PasswordResetToken findByKhachHang(KhachHang paramKhachHang);
  
  Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date paramDate);
  
  void deleteByExpiryDateLessThan(Date paramDate);
  
  @Modifying
  @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
  void deleteAllExpiredSince(Date paramDate);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\PasswordResetTokenRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */