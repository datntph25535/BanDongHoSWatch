/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DanhMuc;
/*    */ import com.datn.dongho5s.Exception.DanhMucNotFoundException;
/*    */ import com.datn.dongho5s.Repository.DanhMucRepository;
/*    */ import com.datn.dongho5s.Service.DanhmucService;
/*    */ import java.util.List;
/*    */ import javax.transaction.Transactional;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.domain.PageRequest;
/*    */ import org.springframework.data.domain.Pageable;
/*    */ import org.springframework.data.domain.Sort;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ @Transactional
/*    */ public class DanhMucServiceImpl
/*    */   implements DanhmucService
/*    */ {
/*    */   public static final int CATEGORIES_PER_PAGE = 4;
/*    */   @Autowired
/*    */   private DanhMucRepository repo;
/*    */   
/*    */   public List<DanhMuc> listAll() {
/* 26 */     return this.repo.findAll(Sort.by(new String[] { "ten" }).ascending());
/*    */   }
/*    */ 
/*    */   
/*    */   public Page<DanhMuc> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 31 */     Sort sort = Sort.by(new String[] { sortField });
/*    */     
/* 33 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/*    */     
/* 35 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/*    */     
/* 37 */     if (keyword != null) {
/* 38 */       return this.repo.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/*    */     
/* 41 */     return this.repo.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDanhMucEnabledStatus(Integer id, boolean enabled) {
/* 46 */     this.repo.updateEnabledStatus(id, enabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public DanhMuc save(DanhMuc danhMuc) {
/* 51 */     return (DanhMuc)this.repo.save(danhMuc);
/*    */   }
/*    */ 
/*    */   
/*    */   public DanhMuc get(Integer id) throws DanhMucNotFoundException, Exception {
/*    */     try {
/* 57 */       return (DanhMuc)this.repo.findById(id)
/* 58 */         .orElseThrow(() -> new DanhMucNotFoundException("Không tìm thấy danh mục nào theo ID: " + id));
/* 59 */     } catch (Exception ex) {
/* 60 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkUnique(Integer id, String ten) {
/* 66 */     DanhMuc danhMucTheoTen = this.repo.findByTen(ten);
/* 67 */     if (danhMucTheoTen == null) return true; 
/* 68 */     boolean isCreatingNew = (id == null);
/* 69 */     if (isCreatingNew) {
/* 70 */       if (danhMucTheoTen != null) {
/* 71 */         return false;
/*    */       }
/*    */     }
/* 74 */     else if (danhMucTheoTen.getId() != id) {
/* 75 */       return false;
/*    */     } 
/*    */     
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\DanhMucServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */