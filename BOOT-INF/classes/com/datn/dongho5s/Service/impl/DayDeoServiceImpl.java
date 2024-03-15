/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DayDeo;
/*    */ import com.datn.dongho5s.Exception.DayDeoNotFoundException;
/*    */ import com.datn.dongho5s.Repository.DayDeoRepository;
/*    */ import com.datn.dongho5s.Service.DayDeoService;
/*    */ import java.util.List;
/*    */ import javax.transaction.Transactional;
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
/*    */ @Transactional
/*    */ public class DayDeoServiceImpl
/*    */   implements DayDeoService
/*    */ {
/*    */   @Autowired
/*    */   DayDeoRepository dayDeoRepository;
/*    */   
/*    */   public List<DayDeo> getAllDayDeo() {
/* 27 */     return this.dayDeoRepository.findAll(Sort.by(new String[] { "tenDayDeo" }).ascending());
/*    */   }
/*    */ 
/*    */   
/*    */   public Page<DayDeo> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 32 */     Sort sort = Sort.by(new String[] { sortField });
/* 33 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 34 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/* 35 */     if (keyword != null) {
/* 36 */       return this.dayDeoRepository.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/* 38 */     return this.dayDeoRepository.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public DayDeo save(DayDeo dayDeo) {
/* 43 */     return (DayDeo)this.dayDeoRepository.save(dayDeo);
/*    */   }
/*    */ 
/*    */   
/*    */   public DayDeo get(Integer id) throws DayDeoNotFoundException, Exception {
/*    */     try {
/* 49 */       return (DayDeo)this.dayDeoRepository.findById(id)
/* 50 */         .orElseThrow(() -> new DayDeoNotFoundException("Không tìm thấy dây đeo nào theo ID: " + id));
/* 51 */     } catch (Exception ex) {
/* 52 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkUnique(Integer id, String ten) {
/* 58 */     DayDeo dayDeoTheoTen = this.dayDeoRepository.findByTenDayDeo(ten);
/* 59 */     if (dayDeoTheoTen == null) return true; 
/* 60 */     boolean isCreatingNew = (id == null);
/*    */     
/* 62 */     if (isCreatingNew) {
/* 63 */       if (dayDeoTheoTen != null) {
/* 64 */         return false;
/*    */       }
/*    */     }
/* 67 */     else if (dayDeoTheoTen.getIdDayDeo() != id) {
/* 68 */       return false;
/*    */     } 
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDayDeoEnabledStatus(Integer id, boolean enabled) {
/* 76 */     this.dayDeoRepository.updateEnabledStatus(id, enabled);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\DayDeoServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */