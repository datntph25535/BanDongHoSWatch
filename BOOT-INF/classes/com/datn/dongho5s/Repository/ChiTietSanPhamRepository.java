package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, Integer> {
  @Query(nativeQuery = true, value = "SELECT * FROM chitietsanpham c JOIN sanpham sp ON c.id_san_pham = sp.id_san_pham WHERE sp.ma_san_pham = ?1 ")
  Page<ChiTietSanPham> findByMaSP(String paramString, Pageable paramPageable);
  
  @Query(" SELECT ctsp FROM ChiTietSanPham ctsp")
  Page<ChiTietSanPham> findAllHung(Pageable paramPageable);
  
  @Query("SELECT ctsp FROM ChiTietSanPham  ctsp WHERE UPPER(CONCAT(ctsp.idChiTietSanPham,' ', ctsp.maChiTietSanPham, ' ',ctsp.dayDeo,' ', ctsp.khuyenMai,' ', ctsp.mauSac,' ',ctsp.sanPham)) LIKE %?1%")
  Page<ChiTietSanPham> findAll(String paramString, Pageable paramPageable);
  
  @Query("UPDATE ChiTietSanPham c SET c.soLuong = c.soLuong - ?1 WHERE c.idChiTietSanPham = ?2 ")
  @Modifying
  void updateSoLuongCTSPById(int paramInt1, int paramInt2);
  
  @Query(" UPDATE ChiTietSanPham c SET c.soLuong = c.soLuong + ?1   WHERE c.idChiTietSanPham = ?2")
  @Modifying
  void updateSoLuongFromHDCT(int paramInt1, int paramInt2);
  
  ChiTietSanPham findByMaChiTietSanPham(String paramString);
  
  ChiTietSanPham findBySanPham_TenSanPhamAndDayDeo_TenDayDeoAndMauSac_TenMauSacAndKichCo_TenKichCoAndVatLieu_TenVatLieu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  ChiTietSanPham findByIdChiTietSanPham(Integer paramInteger);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\ChiTietSanPhamRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */