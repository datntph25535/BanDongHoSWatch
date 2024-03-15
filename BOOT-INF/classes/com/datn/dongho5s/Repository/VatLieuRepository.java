package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.VatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VatLieuRepository extends JpaRepository<VatLieu, Integer> {
  @Query("UPDATE VatLieu vl SET vl.enabled = ?2 WHERE vl.idVatLieu = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  @Query("SELECT vl FROM VatLieu vl WHERE UPPER(CONCAT(vl.idVatLieu, ' ', vl.tenVatLieu, ' ', vl.moTaVatLieu)) LIKE %?1%")
  Page<VatLieu> findAll(String paramString, Pageable paramPageable);
  
  VatLieu findByTenVatLieu(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\VatLieuRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */