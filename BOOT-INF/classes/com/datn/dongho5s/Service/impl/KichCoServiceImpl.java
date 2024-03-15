/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Exception.KichCoNotFoundException;
/*    */ import com.datn.dongho5s.Repository.KichCoRepository;
/*    */ import com.datn.dongho5s.Service.KichCoService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.data.domain.Sort;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class KichCoServiceImpl
/*    */   implements KichCoService
/*    */ {
/*    */   @Autowired
/*    */   KichCoRepository kichCoRepository;
/*    */   
/*    */   public List<KichCo> getAllKichCo() {
/* 24 */     return this.kichCoRepository.findAll();
/*    */   }
/*    */   
/*    */   public List<KichCo> getAllPaginationKichCo() {
/* 28 */     return this.kichCoRepository.findAll(Sort.by(new String[] { "tenKichCo" }).ascending());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<KichCo> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 34 */     Sort sort = Sort.by(new String[] { sortField });
/* 35 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 36 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/* 37 */     if (keyword != null) {
/* 38 */       return this.kichCoRepository.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/* 40 */     return this.kichCoRepository.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public KichCo save(KichCo kichCo) {
/* 46 */     return (KichCo)this.kichCoRepository.save(kichCo);
/*    */   }
/*    */ 
/*    */   
/*    */   public KichCo get(Integer id) throws KichCoNotFoundException, Exception {
/*    */     try {
/* 52 */       return (KichCo)this.kichCoRepository.findById(id)
/* 53 */         .orElseThrow(() -> new KichCoNotFoundException("Không tìm thấy Kích Cỡ nào theo ID: " + id));
/* 54 */     } catch (Exception ex) {
/* 55 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkUnique(Integer id, String ten) {
/* 61 */     KichCo KichCoTheoTen = this.kichCoRepository.findByTenKichCo(ten);
/* 62 */     if (KichCoTheoTen == null) return true; 
/* 63 */     boolean isCreatingNew = (id == null);
/*    */ 
/*    */     
/* 66 */     if (isCreatingNew) {
/* 67 */       if (KichCoTheoTen != null) {
/* 68 */         return false;
/*    */       }
/*    */     }
/* 71 */     else if (KichCoTheoTen.getIdKichCo() != id) {
/* 72 */       return false;
/*    */     } 
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateKichCoEnabledStatus(Integer id, boolean enabled) {
/* 80 */     this.kichCoRepository.updateEnabledStatus(id, enabled);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\KichCoServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */