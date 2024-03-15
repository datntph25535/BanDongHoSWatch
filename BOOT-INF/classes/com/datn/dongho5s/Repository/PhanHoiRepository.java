package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.PhanHoi;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanHoiRepository extends JpaRepository<PhanHoi, Integer> {
  @Query("select ph from PhanHoi ph where ph.chiTietSanPham.idChiTietSanPham = ?1")
  List<PhanHoi> findAll(Integer paramInteger);
  
  @Query("select ph from PhanHoi ph where ph.khachHang.idKhachHang = ?1 and ph.chiTietSanPham.idChiTietSanPham = ?2 ")
  Optional<PhanHoi> findPhanHoi(Integer paramInteger1, Integer paramInteger2);
  
  @Query("select count(ph) from PhanHoi ph where ph.khachHang.idKhachHang = ?1 and ph.chiTietSanPham.idChiTietSanPham = ?2")
  Long countPhanHoi(Integer paramInteger1, Integer paramInteger2);
  
  @Query(value = "SELECT COUNT(hoadonchitiet.id_hoa_don_chi_tiet) FROM hoadonchitiet JOIN donhang on hoadonchitiet.id_don_hang = donhang.id_don_hang\nwhere hoadonchitiet.id_chi_tiet_san_pham = ?2 and donhang.id_khach_hang = ?1 and donhang.trang_thai_don_hang = 3", nativeQuery = true)
  Long countHDCT(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\PhanHoiRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */