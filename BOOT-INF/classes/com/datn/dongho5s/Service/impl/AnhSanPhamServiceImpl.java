/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.AnhSanPham;
/*    */ import com.datn.dongho5s.Repository.AnhSanPhamRepository;
/*    */ import com.datn.dongho5s.Service.AnhSanPhamService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class AnhSanPhamServiceImpl
/*    */   implements AnhSanPhamService {
/*    */   @Autowired
/*    */   AnhSanPhamRepository anhSanPhamRepository;
/*    */   
/*    */   public AnhSanPham save(AnhSanPham anhSanPham) {
/* 16 */     return (AnhSanPham)this.anhSanPhamRepository.save(anhSanPham);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\AnhSanPhamServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */