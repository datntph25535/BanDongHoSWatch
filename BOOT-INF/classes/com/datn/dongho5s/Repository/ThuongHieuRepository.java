package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.ThuongHieu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
  @Query("UPDATE ThuongHieu th SET th.enabled = ?2 WHERE th.idThuongHieu = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
  
  @Query("SELECT th FROM ThuongHieu th WHERE UPPER(CONCAT(th.idThuongHieu, ' ', th.tenThuongHieu, ' ', th.moTaThuongHieu)) LIKE %?1%")
  Page<ThuongHieu> findAll(String paramString, Pageable paramPageable);
  
  ThuongHieu findByTenThuongHieu(String paramString);
  
  @Query("SELECT NEW ThuongHieu (th.idThuongHieu,th.tenThuongHieu) FROM ThuongHieu th ORDER BY th.tenThuongHieu")
  List<ThuongHieu> findUserForm();
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\ThuongHieuRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */