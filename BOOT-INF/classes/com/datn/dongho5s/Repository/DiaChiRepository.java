package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.DiaChi;
import com.datn.dongho5s.Entity.KhachHang;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, Integer> {
  DiaChi findByDiaChi(String paramString);
  
  List<DiaChi> findByKhachHang(KhachHang paramKhachHang);
  
  @Query("SELECT dc FROM DiaChi dc WHERE dc.khachHang.idKhachHang = ?1 and dc.trangThaiMacDinh = 1")
  DiaChi getDiaChiDefault(Integer paramInteger);
  
  @Query("SELECT dc FROM DiaChi dc WHERE dc.khachHang.idKhachHang = ?1")
  List<DiaChi> findByIdKH(Integer paramInteger);
  
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM `diachi` WHERE id_dia_chi = ?1", nativeQuery = true)
  void deleteDC(Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\DiaChiRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */