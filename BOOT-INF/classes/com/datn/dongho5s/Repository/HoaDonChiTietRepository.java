package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.DonHang;
import com.datn.dongho5s.Entity.HoaDonChiTiet;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
  @Query("  SELECT h   FROM HoaDonChiTiet h JOIN DonHang dh ON h.donHang.idDonHang = dh.idDonHang   WHERE h.donHang.idDonHang = ?1  ORDER BY h.idHoaDonChiTiet ASC")
  List<HoaDonChiTiet> findHDCTBYIdDonHang(int paramInt);
  
  List<HoaDonChiTiet> findByDonHang(DonHang paramDonHang);
  
  @Query("  SELECT h   FROM HoaDonChiTiet h JOIN DonHang d ON h.donHang.idDonHang = d.idDonHang WHERE d.maDonHang = ?1")
  List<HoaDonChiTiet> findByMaDonHang(String paramString);
  
  @Query("   UPDATE HoaDonChiTiet h SET h.soLuong = h.soLuong + ?1 WHERE h.idHoaDonChiTiet = ?2")
  @Modifying
  void updateSoLuongSanPham(int paramInt1, int paramInt2);
  
  @Query(" DELETE   FROM HoaDonChiTiet h  WHERE h.idHoaDonChiTiet = ?1")
  @Modifying
  void xoaHDCT(int paramInt);
  
  HoaDonChiTiet findByIdHoaDonChiTiet(int paramInt);
  
  @Query(" UPDATE HoaDonChiTiet h  SET h.soLuong = ?1 WHERE h.idHoaDonChiTiet = ?2")
  @Modifying
  void updateSoLuongSanPhamWithEdit(int paramInt1, int paramInt2);
  
  @Query("SELECT NEW  com.datn.dongho5s.Entity.HoaDonChiTiet(d.chiTietSanPham.sanPham.danhMuc.ten, d.soLuong,d.giaBan, d.donHang.phiVanChuyen)  FROM HoaDonChiTiet d WHERE d.donHang.ngayTao BETWEEN ?1 AND ?2 AND d.donHang.trangThaiDonHang = 3")
  List<HoaDonChiTiet> findWithCategoryAndTimeBetween(Date paramDate1, Date paramDate2);
  
  @Query("SELECT NEW  com.datn.dongho5s.Entity.HoaDonChiTiet(d.soLuong, d.chiTietSanPham.sanPham.tenSanPham,d.giaBan, d.donHang.phiVanChuyen)  FROM HoaDonChiTiet d WHERE d.donHang.ngayTao BETWEEN ?1 AND ?2 AND d.donHang.trangThaiDonHang = 3")
  List<HoaDonChiTiet> findWithProductAndTimeBetween(Date paramDate1, Date paramDate2);
  
  @Query("SELECT NEW  com.datn.dongho5s.Entity.HoaDonChiTiet(d.chiTietSanPham.idChiTietSanPham, d.soLuong, d.giaBan, d.donHang.phiVanChuyen)  FROM HoaDonChiTiet d WHERE d.donHang.ngayTao BETWEEN ?1 AND ?2 AND d.donHang.trangThaiDonHang = 3")
  List<HoaDonChiTiet> findWithOrderDetailAndTimeBetween(Date paramDate1, Date paramDate2);
  
  @Modifying
  @Transactional
  void deleteByDonHang(DonHang paramDonHang);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\HoaDonChiTietRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */