package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.KhuyenMai;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
  @Query("SELECT km FROM KhuyenMai km WHERE UPPER(CONCAT(km.idKhuyenMai,' ', km.maKhuyenMai,' ', km.tenKhuyenMai,' ',km.moTaKhuyenMai,' ', km.ngayBatDau,' ', km.ngayKetThuc,' ',km.enabled,' ',km.chietKhau))LIKE %?1%")
  Page<KhuyenMai> findAll(String paramString, Pageable paramPageable);
  
  KhuyenMai findByTenKhuyenMai(String paramString);
  
  KhuyenMai findByMaKhuyenMai(String paramString);
  
  List<KhuyenMai> findByNgayKetThucLessThanAndEnabled(Date paramDate, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\KhuyenMaiRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */