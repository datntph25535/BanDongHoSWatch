/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Entity.Seri;
/*    */ import com.datn.dongho5s.Repository.SeriRepository;
/*    */ import com.datn.dongho5s.Service.SeriService;
/*    */ import com.datn.dongho5s.Utils.TrangThaiImei;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class SeriServiceImpl
/*    */   implements SeriService
/*    */ {
/*    */   @Autowired
/*    */   SeriRepository repo;
/*    */   
/*    */   public Seri save(Seri seri) {
/* 23 */     return (Seri)this.repo.save(seri);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Seri> saveMany(List<Seri> seri) {
/* 28 */     return this.repo.saveAll(seri);
/*    */   }
/*    */ 
/*    */   
/*    */   public Seri get(Integer id) {
/* 33 */     if (this.repo.findById(id) != null) {
/* 34 */       return this.repo.findById(id).get();
/*    */     }
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Page<Seri> searchSeri(int pageNumber, int pageSize, String keyword) {
/* 41 */     PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
/* 42 */     this.repo.findByIdImeiLike(keyword, (Pageable)pageRequest).getContent().forEach(item -> {
/*    */         
/* 44 */         }); return this.repo.findByIdImeiLike(keyword, (Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer countSeri(Integer idChiTietSanPham) {
/* 49 */     return this.repo.countSeri(idChiTietSanPham);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Seri> findByChiTietSanPham(ChiTietSanPham chiTietSanPham, Integer soLuong) {
/* 54 */     PageRequest pageRequest = PageRequest.of(0, soLuong.intValue());
/* 55 */     return this.repo.findByChiTietSanPhamAndTrangThai(chiTietSanPham, TrangThaiImei.CHUA_BAN, (Pageable)pageRequest);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\SeriServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */