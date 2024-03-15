package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.ChiTietGioHang;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, Integer> {
  @Query("select ctgh from ChiTietGioHang ctgh where ctgh.gioHang.khachHang.idKhachHang = ?1")
  List<ChiTietGioHang> giohangChiTiet(Integer paramInteger);
  
  @Query("select ctgh from ChiTietGioHang ctgh where ctgh.chiTietSanPham.idChiTietSanPham = ?1 and ctgh.gioHang.khachHang.idKhachHang = ?2")
  ChiTietGioHang findChiTietGioHangByCTSP(Integer paramInteger1, Integer paramInteger2);
  
  @Query("select ctgh from ChiTietGioHang ctgh where ctgh.chiTietSanPham.idChiTietSanPham = ?1 and ctgh.gioHang.khachHang.idKhachHang = ?2")
  ChiTietGioHang findChiTietGioHangByCTSPVaKhachHang(Integer paramInteger1, Integer paramInteger2);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\ChiTietGioHangRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */