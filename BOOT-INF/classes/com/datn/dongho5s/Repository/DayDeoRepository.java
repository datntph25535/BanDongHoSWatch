package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.DayDeo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DayDeoRepository extends JpaRepository<DayDeo, Integer> {
  @Query("UPDATE DayDeo  dd SET dd.enabled = ?2 WHERE dd.idDayDeo = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  @Query("SELECT dd FROM DayDeo dd WHERE UPPER(CONCAT(dd.idDayDeo,' ', dd.tenDayDeo,' ', dd.moTaDayDeo, ' ', dd.chatLieu, ' ', dd.chieuDai))LIKE %?1% ")
  Page<DayDeo> findAll(String paramString, Pageable paramPageable);
  
  DayDeo findByTenDayDeo(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\DayDeoRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */