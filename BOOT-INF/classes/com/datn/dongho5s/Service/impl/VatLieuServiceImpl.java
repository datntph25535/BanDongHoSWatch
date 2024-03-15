/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.VatLieu;
/*    */ import com.datn.dongho5s.Exception.VatLieuNotFoundException;
/*    */ import com.datn.dongho5s.Repository.VatLieuRepository;
/*    */ import com.datn.dongho5s.Service.VatLieuService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.data.domain.Sort;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class VatLieuServiceImpl
/*    */   implements VatLieuService
/*    */ {
/*    */   @Autowired
/*    */   VatLieuRepository vatLieuRepository;
/*    */   
/*    */   public List<VatLieu> getAllVatLieu() {
/* 23 */     return this.vatLieuRepository.findAll();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<VatLieu> getAllPaginationVatLieu() {
/* 28 */     return this.vatLieuRepository.findAll(Sort.by(new String[] { "tenVatLieu" }).ascending());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Page<VatLieu> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 34 */     Sort sort = Sort.by(new String[] { sortField });
/* 35 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 36 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/* 37 */     if (keyword != null) {
/* 38 */       return this.vatLieuRepository.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/* 40 */     return this.vatLieuRepository.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public VatLieu save(VatLieu vatLieu) {
/* 46 */     return (VatLieu)this.vatLieuRepository.save(vatLieu);
/*    */   }
/*    */ 
/*    */   
/*    */   public VatLieu get(Integer id) throws VatLieuNotFoundException, Exception {
/*    */     try {
/* 52 */       return (VatLieu)this.vatLieuRepository.findById(id)
/* 53 */         .orElseThrow(() -> new VatLieuNotFoundException("Không tìm thấy vật liệu nào theo ID: " + id));
/* 54 */     } catch (Exception ex) {
/* 55 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkUnique(Integer id, String ten) {
/* 61 */     VatLieu vatLieuTheoTen = this.vatLieuRepository.findByTenVatLieu(ten);
/* 62 */     if (vatLieuTheoTen == null) return true; 
/* 63 */     boolean isCreatingNew = (id == null);
/*    */ 
/*    */     
/* 66 */     if (isCreatingNew) {
/* 67 */       if (vatLieuTheoTen != null) {
/* 68 */         return false;
/*    */       }
/*    */     }
/* 71 */     else if (vatLieuTheoTen.getIdVatLieu() != id) {
/* 72 */       return false;
/*    */     } 
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateVatLieuEnabledStatus(Integer id, boolean enabled) {
/* 80 */     this.vatLieuRepository.updateEnabledStatus(id, enabled);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\VatLieuServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */