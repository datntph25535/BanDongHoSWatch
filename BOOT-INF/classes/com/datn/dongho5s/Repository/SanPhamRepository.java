package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import com.datn.dongho5s.Entity.SanPham;
import com.datn.dongho5s.Entity.ThuongHieu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
  @Query(value = "SELECT  * FROM sanpham where sanpham.trang_thai = 1 ORDER BY sanpham.id_san_pham DESC LIMIT 8", nativeQuery = true)
  List<SanPham> getSPnew();
  
  @Query("SELECT h.chiTietSanPham.sanPham  FROM HoaDonChiTiet h where h.donHang.trangThaiDonHang = 3 group by h.chiTietSanPham.sanPham   ORDER BY  SUM(h.soLuong) DESC")
  List<SanPham> getSPchay();
  
  @Query("SELECT s.listChiTietSanPham  FROM SanPham s where s.idSanPham = ?1 and s.trangThai = 1 ")
  List<ChiTietSanPham> getCTSP(Integer paramInteger);
  
  @Query("SELECT sp FROM SanPham  sp WHERE UPPER(CONCAT(sp.idSanPham,' ', sp.tenSanPham, ' ',sp.thuongHieu,' ', sp.danhMuc, ' ',sp.moTaSanPham)) LIKE %?1%")
  Page<SanPham> findAll(String paramString, Pageable paramPageable);
  
  SanPham findByTenSanPham(String paramString);
  
  SanPham findByMaSanPham(String paramString);
  
  List<SanPham> findByThuongHieu(ThuongHieu paramThuongHieu);
  
  SanPham findByIdSanPham(Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\SanPhamRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */