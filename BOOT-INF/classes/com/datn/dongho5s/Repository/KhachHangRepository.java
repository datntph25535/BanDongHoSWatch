package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
  @Query("SELECT kh FROM KhachHang kh WHERE kh.email = :email")
  KhachHang getKhachHangByEmail(@Param("email") String paramString);
  
  @Query("SELECT kh FROM KhachHang kh WHERE kh.soDienThoai = :soDienThoai")
  KhachHang getKhachHangBySdt(@Param("soDienThoai") String paramString);
  
  @Query("SELECT kh FROM KhachHang kh WHERE UPPER(CONCAT(kh.idKhachHang, ' ', kh.tenKhachHang, ' ', kh.email, '', kh.soDienThoai, '', kh.ngaySua)) LIKE %?1%")
  Page<KhachHang> findAll(String paramString, Pageable paramPageable);
  
  KhachHang findByEmailAndSoDienThoai(String paramString1, String paramString2);
  
  KhachHang findBySoDienThoai(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\KhachHangRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */