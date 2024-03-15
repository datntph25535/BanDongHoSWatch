/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChucVu;
/*    */ import com.datn.dongho5s.Repository.ChucVuRepository;
/*    */ import com.datn.dongho5s.Service.ChucVuService;
/*    */ import java.util.Optional;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class ChucVuServiceImpl
/*    */   implements ChucVuService {
/*    */   @Autowired
/*    */   private ChucVuRepository chucVuRepository;
/*    */   
/*    */   public Optional<ChucVu> findByTenChucVu(String roleName) {
/* 17 */     return this.chucVuRepository.findByTenChucVu(roleName);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\ChucVuServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */