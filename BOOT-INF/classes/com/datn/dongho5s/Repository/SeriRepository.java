package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.ChiTietSanPham;
import com.datn.dongho5s.Entity.Seri;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SeriRepository extends JpaRepository<Seri, Integer> {
  @Query("SELECT s FROM Seri s WHERE s.idImei LIKE %:keyword%")
  Page<Seri> findByIdImeiLike(@Param("keyword") String paramString, Pageable paramPageable);
  
  @Query("select count(s) from Seri s where s.trangThai = 1 and s.chiTietSanPham.idChiTietSanPham = ?1")
  Integer countSeri(Integer paramInteger);
  
  @Query(" SELECT COUNT(sr.idSeri)  FROM Seri sr  WHERE   sr.chiTietSanPham.idChiTietSanPham = ?1 AND sr.trangThai = 1 AND sr.hoaDonChiTiet is null")
  int countByIdCTSPEnabled(int paramInt);
  
  List<Seri> findByChiTietSanPhamAndTrangThai(ChiTietSanPham paramChiTietSanPham, Integer paramInteger, Pageable paramPageable);
  
  @Query(nativeQuery = true, value = "UPDATE seri s1 SET s1.trang_thai = 3, s1.id_hoa_don_chi_tiet = :idHoaDonChiTiet,s1.ngay_ban = CURRENT_TIMESTAMP() WHERE s1.id_seri IN :listSeri")
  @Modifying
  @Transactional
  void themSoLuongAdmin(@Param("idHoaDonChiTiet") int paramInt, @Param("listSeri") List<Integer> paramList);
  
  @Query(nativeQuery = true, value = " SELECT s.id_seri s FROM seri s  WHERE s.trang_thai = 1  AND   s.id_chi_tiet_san_pham = :idChiTietSanPham  LIMIT :soLuong")
  @Modifying
  @Transactional
  List<Integer> getListSeri(@Param("soLuong") int paramInt1, @Param("idChiTietSanPham") int paramInt2);
  
  @Query(nativeQuery = true, value = " WITH soLuongDaMua AS (SELECT COUNT(*) AS count  FROM seri s  WHERE s.id_hoa_don_chi_tiet = :idHDCT ), soLuongTon AS ( SELECT COUNT(*) AS count   FROM seri s  WHERE s.id_chi_tiet_san_pham = :idHDCT  AND   s.id_hoa_don_chi_tiet IS NULL )  SELECT (SELECT count FROM soLuongDaMua) + (SELECT count FROM soLuongTon) AS total_count;")
  int soLuongImeiCoTheCapNhat(@Param("idHDCT") int paramInt);
  
  @Modifying
  @Transactional
  @Query(" UPDATE Seri s SET s.hoaDonChiTiet = null, s.ngayBan = null,  s.trangThai = 1 WHERE s.hoaDonChiTiet.idHoaDonChiTiet = ?1")
  void xoaSoLuongSanPham(int paramInt);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\SeriRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */