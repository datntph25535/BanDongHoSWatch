/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.MauSac;
/*    */ import com.datn.dongho5s.Exception.MauSacNotFoundException;
/*    */ import com.datn.dongho5s.Repository.MauSacRepository;
/*    */ import com.datn.dongho5s.Service.MauSacService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.data.domain.Sort;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class MauSacServiceImpl
/*    */   implements MauSacService
/*    */ {
/*    */   public static final int COLORS_PER_PAGE = 10;
/*    */   @Autowired
/*    */   MauSacRepository mauSacRepository;
/*    */   
/*    */   public List<MauSac> getAllMauSac() {
/* 26 */     return this.mauSacRepository.findAll();
/*    */   }
/*    */ 
/*    */   
/*    */   public Page<MauSac> listByPage(int pageNum, String sortField, String sortDir, String keyword) {
/* 31 */     Sort sort = Sort.by(new String[] { sortField });
/*    */     
/* 33 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/*    */     
/* 35 */     PageRequest pageRequest = PageRequest.of(pageNum - 1, 10, sort);
/*    */     
/* 37 */     if (keyword != null) {
/* 38 */       return this.mauSacRepository.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/*    */     
/* 41 */     return this.mauSacRepository.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateMauSacEnabledStatus(Integer id, boolean enabled) {
/* 46 */     this.mauSacRepository.updateEnabledStatus(id, enabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public MauSac save(MauSac mauSac) {
/* 51 */     return (MauSac)this.mauSacRepository.save(mauSac);
/*    */   }
/*    */ 
/*    */   
/*    */   public MauSac get(Integer id) throws Exception {
/*    */     try {
/* 57 */       return (MauSac)this.mauSacRepository.findById(id)
/* 58 */         .orElseThrow(() -> new MauSacNotFoundException("Không tìm thấy danh mục nào theo ID: " + id));
/* 59 */     } catch (Exception ex) {
/* 60 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\MauSacServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */