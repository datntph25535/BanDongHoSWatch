/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ThuongHieu;
/*    */ import com.datn.dongho5s.Exception.ThuongHieuNotFoundException;
/*    */ import com.datn.dongho5s.Repository.ThuongHieuRepository;
/*    */ import com.datn.dongho5s.Service.ThuongHieuService;
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
/*    */ 
/*    */ @Service
/*    */ @Transactional
/*    */ public class ThuongHieuServiceImpl
/*    */   implements ThuongHieuService
/*    */ {
/*    */   @Autowired
/*    */   ThuongHieuRepository thuongHieuRepository;
/*    */   
/*    */   public List<ThuongHieu> getAllThuongHieu() {
/* 28 */     return this.thuongHieuRepository.findAll(Sort.by(new String[] { "tenThuongHieu" }).ascending());
/*    */   }
/*    */ 
/*    */   
/*    */   public List<ThuongHieu> layDanhSachTenThuongHieu() {
/* 33 */     return this.thuongHieuRepository.findAll();
/*    */   }
/*    */ 
/*    */   
/*    */   public Page<ThuongHieu> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 38 */     Sort sort = Sort.by(new String[] { sortField });
/* 39 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 40 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/* 41 */     if (keyword != null) {
/* 42 */       return this.thuongHieuRepository.findAll(keyword, (Pageable)pageRequest);
/*    */     }
/* 44 */     return this.thuongHieuRepository.findAll((Pageable)pageRequest);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ThuongHieu save(ThuongHieu thuongHieu) {
/* 50 */     return (ThuongHieu)this.thuongHieuRepository.save(thuongHieu);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateThuongHieuEnabledStatus(Integer id, boolean enabled) {
/* 55 */     this.thuongHieuRepository.updateEnabledStatus(id, enabled);
/*    */   }
/*    */   
/*    */   public ThuongHieu get(Integer id) throws ThuongHieuNotFoundException, Exception {
/*    */     try {
/* 60 */       return (ThuongHieu)this.thuongHieuRepository.findById(id)
/* 61 */         .orElseThrow(() -> new ThuongHieuNotFoundException("Không tìm thấy thương hiệu nào theo ID: " + id));
/* 62 */     } catch (Exception ex) {
/* 63 */       throw new Exception(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkUnique(Integer id, String ten) {
/* 69 */     ThuongHieu thuongHieuTheoTen = this.thuongHieuRepository.findByTenThuongHieu(ten);
/* 70 */     if (thuongHieuTheoTen == null) return true; 
/* 71 */     boolean isCreatingNew = (id == null);
/*    */ 
/*    */     
/* 74 */     if (isCreatingNew) {
/* 75 */       if (thuongHieuTheoTen != null) {
/* 76 */         return false;
/*    */       }
/*    */     }
/* 79 */     else if (thuongHieuTheoTen.getIdThuongHieu() != id) {
/* 80 */       return false;
/*    */     } 
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\ThuongHieuServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */