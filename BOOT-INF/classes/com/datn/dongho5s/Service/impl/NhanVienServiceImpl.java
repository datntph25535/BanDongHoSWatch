/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChucVu;
/*     */ import com.datn.dongho5s.Entity.NhanVien;
/*     */ import com.datn.dongho5s.Exception.NhanVienNotFoundException;
/*     */ import com.datn.dongho5s.Repository.ChucVuRepository;
/*     */ import com.datn.dongho5s.Repository.NhanVienRepository;
/*     */ import com.datn.dongho5s.Service.NhanVienService;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import javax.transaction.Transactional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.security.crypto.password.PasswordEncoder;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class NhanVienServiceImpl
/*     */   implements NhanVienService
/*     */ {
/*     */   @Autowired
/*     */   private NhanVienRepository nhanVienrepo;
/*     */   @Autowired
/*     */   private ChucVuRepository chucVuRepo;
/*     */   @Autowired
/*     */   private PasswordEncoder passwordEncoder;
/*     */   
/*     */   public NhanVien findByEmail(String email) {
/*  37 */     return this.nhanVienrepo.findByEmail(email);
/*     */   }
/*     */ 
/*     */   
/*     */   public NhanVien findByUserName(String userName) {
/*  42 */     return this.nhanVienrepo.findByTen(userName);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean existsByUserName(String userName) {
/*  47 */     return this.nhanVienrepo.existsByTen(userName);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean existSByEmail(String email) {
/*  52 */     return this.nhanVienrepo.existsByEmail(email);
/*     */   }
/*     */   
/*     */   public NhanVien getByEmail(String email) {
/*  56 */     return this.nhanVienrepo.getNhanVienByEmail(email);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<NhanVien> listAll() {
/*  61 */     return (List<NhanVien>)this.nhanVienrepo.findAll(Sort.by(new String[] { "ten" }).ascending());
/*     */   }
/*     */   
/*     */   public Page<NhanVien> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/*  65 */     Sort sort = Sort.by(new String[] { sortField });
/*     */     
/*  67 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/*     */     
/*  69 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/*     */     
/*  71 */     if (keyword != null) {
/*  72 */       return this.nhanVienrepo.findAll(keyword, (Pageable)pageRequest);
/*     */     }
/*     */     
/*  75 */     return this.nhanVienrepo.findAll((Pageable)pageRequest);
/*     */   }
/*     */   
/*     */   public List<ChucVu> listChucVu() {
/*  79 */     return this.chucVuRepo.findAll();
/*     */   }
/*     */   
/*     */   public NhanVien save(NhanVien nhanVien) {
/*  83 */     boolean isUpdatingNhanVien = (nhanVien.getId() != null);
/*     */     
/*  85 */     if (isUpdatingNhanVien) {
/*  86 */       NhanVien existingNhanVien = this.nhanVienrepo.findById(nhanVien.getId()).get();
/*  87 */       if (nhanVien.getMatKhau() == null || nhanVien.getMatKhau().isEmpty()) {
/*  88 */         nhanVien.setMatKhau(existingNhanVien.getMatKhau());
/*     */       } else {
/*  90 */         encodePassword(nhanVien);
/*     */       } 
/*     */     } else {
/*  93 */       encodePassword(nhanVien);
/*     */     } 
/*     */     
/*  96 */     return (NhanVien)this.nhanVienrepo.save(nhanVien);
/*     */   }
/*     */   
/*     */   public NhanVien nhanVienUpdateAccount(NhanVien nhanVienInForm) {
/* 100 */     NhanVien nhanVienInDB = this.nhanVienrepo.findById(nhanVienInForm.getId()).get();
/* 101 */     if (nhanVienInForm.getMatKhau().isEmpty()) {
/* 102 */       nhanVienInDB.setMatKhau(nhanVienInForm.getMatKhau());
/* 103 */       encodePassword(nhanVienInDB);
/*     */     } 
/*     */     
/* 106 */     if (nhanVienInForm.getAnh() != null) {
/* 107 */       nhanVienInDB.setAnh(nhanVienInForm.getAnh());
/*     */     }
/* 109 */     nhanVienInDB.setHo(nhanVienInForm.getHo());
/* 110 */     nhanVienInDB.setTen(nhanVienInForm.getTen());
/* 111 */     nhanVienInDB.setDiaChi(nhanVienInForm.getDiaChi());
/* 112 */     nhanVienInDB.setSoDienThoai(nhanVienInForm.getSoDienThoai());
/* 113 */     return (NhanVien)this.nhanVienrepo.save(nhanVienInDB);
/*     */   }
/*     */ 
/*     */   
/*     */   public void encodePassword(NhanVien nhanVien) {
/* 118 */     String encodedPassword = this.passwordEncoder.encode(nhanVien.getMatKhau());
/* 119 */     nhanVien.setMatKhau(encodedPassword);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmailUnique(Integer id, String email) {
/* 124 */     NhanVien nhanVienTheoEmail = this.nhanVienrepo.getNhanVienByEmail(email);
/* 125 */     if (nhanVienTheoEmail == null) return true; 
/* 126 */     boolean isCreatingNew = (id == null);
/* 127 */     if (isCreatingNew) {
/* 128 */       if (nhanVienTheoEmail != null) {
/* 129 */         return false;
/*     */       }
/*     */     }
/* 132 */     else if (nhanVienTheoEmail.getId() != id) {
/* 133 */       return false;
/*     */     } 
/*     */     
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   public NhanVien get(Integer id) throws NhanVienNotFoundException {
/*     */     try {
/* 141 */       return this.nhanVienrepo.findById(id).get();
/* 142 */     } catch (NoSuchElementException ex) {
/* 143 */       throw new NhanVienNotFoundException("không tìm thấy nhân viên nào theo ID :" + id);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Integer id) throws NhanVienNotFoundException {
/* 149 */     Long countById = this.nhanVienrepo.countById(id);
/* 150 */     if (countById == null || countById.longValue() == 0L) {
/* 151 */       throw new NhanVienNotFoundException("không tìm thấy nhân viên nào theo ID :" + id);
/*     */     }
/* 153 */     this.nhanVienrepo.deleteById(id);
/*     */   }
/*     */   
/*     */   public void updateNhanVienEnabledStatus(Integer id, boolean enabled) {
/* 157 */     this.nhanVienrepo.updateEnabledStatus(id, enabled);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\NhanVienServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */