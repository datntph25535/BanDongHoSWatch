/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.KhuyenMai;
/*     */ import com.datn.dongho5s.Exception.KhuyenMaiNotFoundException;
/*     */ import com.datn.dongho5s.Repository.KhuyenMaiRepository;
/*     */ import com.datn.dongho5s.Service.KhuyenMaiService;
/*     */ import com.datn.dongho5s.Utils.DateConverter;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.transaction.Transactional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class KhuyenMaiServiceImpl
/*     */   implements KhuyenMaiService
/*     */ {
/*     */   @Autowired
/*     */   private KhuyenMaiRepository repo;
/*     */   
/*     */   public List<KhuyenMai> listAll() {
/*  31 */     return this.repo.findAll(Sort.by(new String[] { "tenKhuyenMai" }).ascending());
/*     */   }
/*     */ 
/*     */   
/*     */   public Page<KhuyenMai> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/*  36 */     Sort sort = Sort.by(new String[] { sortField });
/*  37 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/*  38 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/*  39 */     if (keyword != null) {
/*  40 */       return this.repo.findAll(keyword, (Pageable)pageRequest);
/*     */     }
/*  42 */     return this.repo.findAll((Pageable)pageRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public KhuyenMai save(KhuyenMai khuyenMai) {
/*  48 */     String ngayBatDauString = DateConverter.formatDateForDatabase(khuyenMai.getNgayBatDau());
/*  49 */     khuyenMai.setNgayBatDau(DateConverter.parseDateFromDatabase(ngayBatDauString));
/*     */     
/*  51 */     String ngayKetThucString = DateConverter.formatDateForDatabase(khuyenMai.getNgayKetThuc());
/*  52 */     khuyenMai.setNgayKetThuc(DateConverter.parseDateFromDatabase(ngayKetThucString));
/*     */ 
/*     */     
/*  55 */     return (KhuyenMai)this.repo.save(khuyenMai);
/*     */   }
/*     */ 
/*     */   
/*     */   public KhuyenMai get(Integer id) throws KhuyenMaiNotFoundException, Exception {
/*     */     try {
/*  61 */       return (KhuyenMai)this.repo.findById(id).orElseThrow(() -> new KhuyenMaiNotFoundException("Không tìm thấy Khuyến Mãi nào theo ID:" + id));
/*  62 */     } catch (Exception ex) {
/*  63 */       throw new Exception(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkUnique(Integer id, String ten, String ma) {
/*  70 */     KhuyenMai khuyenMaiTheoTen = this.repo.findByTenKhuyenMai(ten);
/*  71 */     KhuyenMai khuyenMaiTheoMa = this.repo.findByMaKhuyenMai(ma);
/*     */     
/*  73 */     if (khuyenMaiTheoTen != null) {
/*     */       
/*  75 */       boolean isCreatingNew = (id == null);
/*  76 */       if (isCreatingNew || !khuyenMaiTheoTen.getIdKhuyenMai().equals(id)) {
/*  77 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  81 */     if (khuyenMaiTheoMa != null) {
/*     */       
/*  83 */       boolean isCreatingNew = (id == null);
/*  84 */       if (isCreatingNew || !khuyenMaiTheoMa.getIdKhuyenMai().equals(id)) {
/*  85 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<KhuyenMai> getExpiredKhuyenMai() {
/*  94 */     Date today = getStartOfDate(new Date());
/*  95 */     return this.repo.findByNgayKetThucLessThanAndEnabled(today, true);
/*     */   }
/*     */   
/*     */   public Date getStartOfDate(Date date) {
/*  99 */     Calendar calendar = Calendar.getInstance();
/* 100 */     calendar.setTime(date);
/* 101 */     calendar.set(14, 0);
/* 102 */     calendar.set(13, 0);
/* 103 */     calendar.set(12, 0);
/* 104 */     calendar.set(11, 0);
/*     */     
/* 106 */     return calendar.getTime();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\KhuyenMaiServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */