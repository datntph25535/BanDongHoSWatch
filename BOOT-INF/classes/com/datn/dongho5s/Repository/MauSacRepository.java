package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
  @Query("SELECT ms FROM MauSac ms WHERE UPPER(CONCAT(ms.idMauSac, ' ', ms.tenMauSac)) LIKE %?1%")
  Page<MauSac> findAll(String paramString, Pageable paramPageable);
  
  @Query(nativeQuery = true, value = "UPDATE mausac ms SET ms.enabled = ?2 WHERE ms.id_mau_sac = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\MauSacRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */