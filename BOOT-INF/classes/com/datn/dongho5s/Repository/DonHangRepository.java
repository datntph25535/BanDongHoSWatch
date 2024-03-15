package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.DonHang;
import com.datn.dongho5s.Entity.HoaDonChiTiet;
import java.util.Date;
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
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
  @Query("select hdct from HoaDonChiTiet hdct where hdct.donHang.khachHang.idKhachHang = ?1 and hdct.chiTietSanPham.idChiTietSanPham = ?2 and hdct.donHang.trangThaiDonHang = 3")
  List<HoaDonChiTiet> findHDDonHang(Integer paramInteger1, Integer paramInteger2);
  
  @Query(" SELECT d FROM DonHang d")
  Page<DonHang> findAll(Pageable paramPageable);
  
  @Query(" SELECT d    FROM DonHang d ORDER BY d.ngayTao DESC ")
  Page<DonHang> findAllSort(Pageable paramPageable);
  
  @Query(" SELECT d FROM DonHang d  WHERE ( d.ngayTao  BETWEEN :dateStart AND :dateEnd ) AND ( :status is null or d.trangThaiDonHang = :status )")
  List<DonHang> findByNgayTao(@Param("dateStart") Date paramDate1, @Param("dateEnd") Date paramDate2, @Param("status") Integer paramInteger);
  
  @Query(" SELECT d.tongTien FROM DonHang d  WHERE d.idDonHang = ?1")
  Double findTongTienByIdDonHang(int paramInt);
  
  DonHang findByIdDonHang(int paramInt);
  
  @Transactional
  @Modifying
  @Query("  UPDATE DonHang d SET d.trangThaiDonHang = :#{#donHang.trangThaiDonHang}  WHERE d.idDonHang = :#{#donHang.idDonHang}")
  void updateTrangThaiDonHang(@Param("donHang") DonHang paramDonHang);
  
  List<DonHang> findByTrangThaiDonHang(int paramInt);
  
  @Query("select hdct from HoaDonChiTiet hdct where hdct.donHang =?1 ")
  List<HoaDonChiTiet> findHDCTbyDH(Integer paramInteger);
  
  @Query("select dh from DonHang dh where dh.khachHang.idKhachHang = ?1 ")
  List<DonHang> findAllHD(Integer paramInteger);
  
  @Query("select dh from DonHang dh where dh.khachHang.idKhachHang = ?1 and dh.trangThaiDonHang = ?2")
  List<DonHang> findHDByStatus(Integer paramInteger1, Integer paramInteger2);
  
  @Query("SELECT NEW com.datn.dongho5s.Entity.DonHang(o.idDonHang, o.ngayTao, o.tongTien, o.phiVanChuyen, o.trangThaiDonHang) FROM DonHang o WHERE o.ngayTao BETWEEN ?1 AND ?2 AND o.trangThaiDonHang = ?3 ORDER BY o.ngayTao ASC")
  List<DonHang> findByOrderByStatusBetween(Date paramDate1, Date paramDate2, Integer paramInteger);
  
  DonHang findByMaDonHang(String paramString);
  
  @Transactional
  @Modifying
  void deleteByMaDonHang(String paramString);
  
  @Query("SELECT dh FROM DonHang dh WHERE UPPER(CONCAT( dh.maDonHang, ' ', dh.khachHang.tenKhachHang, '', dh.diaChi)) LIKE %?1% ")
  Page<DonHang> findAllPagination(String paramString, Pageable paramPageable);
  
  @Query("SELECT dh FROM DonHang dh WHERE UPPER(CONCAT( dh.maDonHang, ' ', dh.khachHang.tenKhachHang, '', dh.diaChi)) LIKE %?1% AND dh.trangThaiDonHang = ?2")
  Page<DonHang> findAllPaginationStatus(String paramString, Pageable paramPageable, Integer paramInteger);
  
  @Query("SELECT count(dh) FROM DonHang dh WHERE dh.trangThaiDonHang = ?1")
  Integer countDHbyStatus(Integer paramInteger);
  
  @Query("SELECT count(dh) FROM DonHang dh ")
  Integer countDHAll();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\DonHangRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */