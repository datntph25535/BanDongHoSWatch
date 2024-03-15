package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
  @Query("UPDATE DanhMuc dm SET dm.enabled = ?2 WHERE dm.id = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  @Query("SELECT dm FROM DanhMuc dm WHERE UPPER(CONCAT(dm.id, ' ', dm.ten)) LIKE %?1%")
  Page<DanhMuc> findAll(String paramString, Pageable paramPageable);
  
  DanhMuc findByTen(String paramString);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\DanhMucRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */