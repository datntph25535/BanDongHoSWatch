/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DiaChi;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Exception.KhachHangNotFoundException;
/*     */ import com.datn.dongho5s.Repository.DiaChiRepository;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Response.ThongTinCaNhanResponse;
/*     */ import com.datn.dongho5s.Response.ThongTinToCheckoutResponse;
/*     */ import com.datn.dongho5s.Service.KhachHangService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class KhachHangServiceImpl
/*     */   implements KhachHangService {
/*     */   public KhachHangServiceImpl(KhachHangRepository khachHangRepository, DiaChiRepository diaChiRepository, KhachHangRepository khachHangRepo) {
/*  23 */     this.khachHangRepository = khachHangRepository; this.diaChiRepository = diaChiRepository; this.khachHangRepo = khachHangRepo;
/*     */   }
/*     */ 
/*     */   
/*     */   private final KhachHangRepository khachHangRepository;
/*     */   private final DiaChiRepository diaChiRepository;
/*     */   @Autowired
/*     */   private KhachHangRepository khachHangRepo;
/*     */   
/*     */   public KhachHang findKhachHangById(Integer id) {
/*  33 */     if (id == null) return null; 
/*  34 */     return this.khachHangRepository.findById(id).get();
/*     */   }
/*     */   
/*     */   public KhachHang get(Integer id) throws KhachHangNotFoundException, Exception {
/*     */     try {
/*  39 */       return (KhachHang)this.khachHangRepository.findById(id)
/*  40 */         .orElseThrow(() -> new KhachHangNotFoundException("Không tìm thấy khách hàng nào theo ID: " + id));
/*  41 */     } catch (Exception ex) {
/*  42 */       throw new Exception(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public KhachHang updateThongTinCaNhan(Integer idKhachHang, ThongTinCaNhanResponse thongTinCaNhanResponse) {
/*  47 */     KhachHang khachHangExist = findKhachHangById(idKhachHang);
/*  48 */     if (khachHangExist == null) {
/*  49 */       return null;
/*     */     }
/*  51 */     khachHangExist.setTenKhachHang(thongTinCaNhanResponse.getTenKhachHang());
/*  52 */     khachHangExist.setGioiTinh(thongTinCaNhanResponse.getGioiTinh());
/*  53 */     khachHangExist.setNgaySinh(thongTinCaNhanResponse.getNgaySinh());
/*  54 */     khachHangExist.setSoDienThoai(thongTinCaNhanResponse.getSoDienThoai());
/*     */     
/*  56 */     return (KhachHang)this.khachHangRepository.save(khachHangExist);
/*     */   }
/*     */ 
/*     */   
/*     */   public ThongTinCaNhanResponse getThongTinCaNhanById(Integer id) {
/*  61 */     KhachHang khachHangExist = findKhachHangById(id);
/*  62 */     DiaChi diaChi = this.diaChiRepository.getDiaChiDefault(id);
/*  63 */     if (diaChi == null) return null; 
/*  64 */     if (khachHangExist == null) return null;
/*     */     
/*  66 */     return ThongTinCaNhanResponse.builder()
/*  67 */       .id(khachHangExist.getIdKhachHang())
/*  68 */       .gioiTinh(khachHangExist.getGioiTinh())
/*  69 */       .diaChi(diaChi.getDiaChi())
/*  70 */       .ngaySinh(khachHangExist.getNgaySinh())
/*  71 */       .soDienThoai(khachHangExist.getSoDienThoai())
/*  72 */       .email(khachHangExist.getEmail())
/*  73 */       .tenKhachHang(khachHangExist.getTenKhachHang())
/*  74 */       .build();
/*     */   }
/*     */ 
/*     */   
/*     */   public ThongTinToCheckoutResponse getThongTinToCheckout(Integer id) {
/*  79 */     System.out.println(id);
/*  80 */     KhachHang khachHangExist = this.khachHangRepo.findById(id).get();
/*     */     
/*  82 */     if (khachHangExist == null) return null;
/*     */     
/*  84 */     return ThongTinToCheckoutResponse.builder()
/*  85 */       .id(khachHangExist.getIdKhachHang())
/*  86 */       .listDiaChi(khachHangExist.getListDiaChi())
/*  87 */       .soDienThoai(khachHangExist.getSoDienThoai())
/*  88 */       .tenKhachHang(khachHangExist.getTenKhachHang())
/*  89 */       .build();
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveKhachHang(KhachHang khachHang) {
/*  94 */     this.khachHangRepo.save(khachHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<KhachHang> getAllKhachHang() {
/*  99 */     return this.khachHangRepo.findAll();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<KhachHang> getAllPaginationVatLieu() {
/* 104 */     return this.khachHangRepo.findAll(Sort.by(new String[] { "tenKhachHang" }).ascending());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Page<KhachHang> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 110 */     Sort sort = Sort.by(new String[] { sortField });
/* 111 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 112 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 4, sort);
/* 113 */     if (keyword != null) {
/* 114 */       return this.khachHangRepo.findAll(keyword, (Pageable)pageRequest);
/*     */     }
/* 116 */     return this.khachHangRepo.findAll((Pageable)pageRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   public KhachHang findByPhoneNumber(String phoneNumber) {
/* 121 */     return this.khachHangRepo.findBySoDienThoai(phoneNumber);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkUnique(Integer id, String email, String soDienThoai) {
/* 126 */     KhachHang khachHangTheoEmailSDT = this.khachHangRepository.findByEmailAndSoDienThoai(email, soDienThoai);
/* 127 */     if (khachHangTheoEmailSDT == null) return true; 
/* 128 */     boolean isCreatingNew = (id == null);
/* 129 */     if (isCreatingNew) {
/* 130 */       if (khachHangTheoEmailSDT != null) {
/* 131 */         return false;
/*     */       }
/*     */     }
/* 134 */     else if (khachHangTheoEmailSDT.getIdKhachHang() != id) {
/* 135 */       return false;
/*     */     } 
/*     */     
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\KhachHangServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */