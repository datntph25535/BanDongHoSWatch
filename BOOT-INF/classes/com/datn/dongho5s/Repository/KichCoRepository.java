package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Integer> {
  @Query("UPDATE KichCo kc SET kc.enabled = ?2 WHERE kc.idKichCo = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  @Query("SELECT kc FROM KichCo kc WHERE UPPER(CONCAT(kc.idKichCo, ' ', kc.tenKichCo, ' ', kc.ngayTaoKichCo,' ', kc.moTaKichCo)) LIKE %?1%")
  Page<KichCo> findAll(String paramString, Pageable paramPageable);
  
  KichCo findByTenKichCo(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\KichCoRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */