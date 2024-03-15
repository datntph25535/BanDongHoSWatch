package BOOT-INF.classes.com.datn.dongho5s.Repository;

import com.datn.dongho5s.Entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends PagingAndSortingRepository<NhanVien, Integer> {
  NhanVien findByEmail(String paramString);
  
  NhanVien findByTen(String paramString);
  
  boolean existsByEmail(String paramString);
  
  boolean existsByTen(String paramString);
  
  @Query("SELECT nv FROM NhanVien nv WHERE nv.email = :email")
  NhanVien getNhanVienByEmail(@Param("email") String paramString);
  
  Long countById(Integer paramInteger);
  
  @Query("SELECT nv FROM NhanVien nv WHERE UPPER(CONCAT(nv.id, ' ', nv.email, ' ', nv.diaChi, ' ', nv.soDienThoai, ' ', nv.ho, ' ', nv.ten)) LIKE %?1%")
  Page<NhanVien> findAll(String paramString, Pageable paramPageable);
  
  @Query("UPDATE NhanVien nv SET nv.enabled = ?2 WHERE nv.id = ?1")
  @Modifying
  void updateEnabledStatus(Integer paramInteger, boolean paramBoolean);
}


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Repository\NhanVienRepository.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */