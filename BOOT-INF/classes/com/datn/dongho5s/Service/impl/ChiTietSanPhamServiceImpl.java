/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Exception.ChiTietSanPhamNotFountException;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.SeriRepository;
/*     */ import com.datn.dongho5s.Response.SanPhamAdminResponse;
/*     */ import com.datn.dongho5s.Response.TimKiemSettingResponse;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.DanhmucService;
/*     */ import com.datn.dongho5s.Service.DayDeoService;
/*     */ import com.datn.dongho5s.Service.KichCoService;
/*     */ import com.datn.dongho5s.Service.MauSacService;
/*     */ import com.datn.dongho5s.Service.ThuongHieuService;
/*     */ import com.datn.dongho5s.Service.VatLieuService;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.domain.PageRequest;
/*     */ import org.springframework.data.domain.Pageable;
/*     */ import org.springframework.data.domain.Sort;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ChiTietSanPhamServiceImpl
/*     */   implements ChiTietSanPhamService
/*     */ {
/*     */   @Autowired
/*     */   DanhmucService danhmucService;
/*     */   @Autowired
/*     */   DayDeoService dayDeoService;
/*     */   @Autowired
/*     */   KichCoService kichCoService;
/*     */   @Autowired
/*     */   MauSacService mauSacService;
/*     */   @Autowired
/*     */   ThuongHieuService thuongHieuService;
/*     */   @Autowired
/*     */   VatLieuService vatLieuService;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @Autowired
/*     */   SeriRepository seriRepository;
/*     */   
/*     */   public TimKiemSettingResponse getTimKiemSetting() {
/*  50 */     TimKiemSettingResponse result = new TimKiemSettingResponse();
/*  51 */     result.setListDanhMuc(this.danhmucService.listAll());
/*  52 */     result.setListDayDeo(this.dayDeoService.getAllDayDeo());
/*  53 */     result.setListKichCo(this.kichCoService.getAllKichCo());
/*  54 */     result.setListMauSac(this.mauSacService.getAllMauSac());
/*  55 */     result.setListThuongHieu(this.thuongHieuService.getAllThuongHieu());
/*  56 */     result.setListVatLieu(this.vatLieuService.getAllVatLieu());
/*  57 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChiTietSanPham getChiTietSanPhamById(Integer id) {
/*  62 */     return this.chiTietSanPhamRepository.findById(id).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ChiTietSanPham update(ChiTietSanPham chiTietSanPham) {
/*  68 */     return (ChiTietSanPham)this.chiTietSanPhamRepository.save(chiTietSanPham);
/*     */   }
/*     */ 
/*     */   
/*     */   public Page<ChiTietSanPham> findByMaSP(String maSanPham, int pageNum) {
/*  73 */     return this.chiTietSanPhamRepository.findByMaSP(maSanPham, (Pageable)PageRequest.of(pageNum - 1, 5));
/*     */   }
/*     */   
/*     */   public Page<ChiTietSanPham> getALlChiTietSanPhamPage(int pageNum) {
/*  77 */     return this.chiTietSanPhamRepository.findAllHung((Pageable)PageRequest.of(pageNum - 1, 5));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SanPhamAdminResponse> getAllSanPhamAminResponse(int pageNum) {
/*  82 */     List<ChiTietSanPham> lstChiTietSanPhams = getALlChiTietSanPhamPage(pageNum).getContent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     List<SanPhamAdminResponse> lst = (List<SanPhamAdminResponse>)lstChiTietSanPhams.stream().map(lstSP -> SanPhamAdminResponse.builder().idChiTietSanPham(lstSP.getIdChiTietSanPham()).maChiTietSanPham(lstSP.getMaChiTietSanPham()).giaSanPham(lstSP.getGiaSanPham()).sanPham(lstSP.getSanPham()).vatLieu(lstSP.getVatLieu()).mauSac(lstSP.getMauSac()).khuyenMai(lstSP.getKhuyenMai()).soLuong(Integer.valueOf(this.seriRepository.countByIdCTSPEnabled(lstSP.getIdChiTietSanPham().intValue()))).build()).collect(Collectors.toList());
/*  97 */     return lst;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChiTietSanPham findByMaChiTietSanPham(String maChimaTietSanPham) {
/* 102 */     return this.chiTietSanPhamRepository.findByMaChiTietSanPham(maChimaTietSanPham);
/*     */   }
/*     */   
/*     */   public ChiTietSanPham getChiTietSanPhamByMa(String ma) {
/* 106 */     return this.chiTietSanPhamRepository.findByMaChiTietSanPham(ma);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ChiTietSanPham> listAll() {
/* 111 */     return this.chiTietSanPhamRepository.findAll(Sort.by(new String[] { "maChiTietSanPham" }).ascending());
/*     */   }
/*     */ 
/*     */   
/*     */   public Page<ChiTietSanPham> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
/* 116 */     Sort sort = Sort.by(new String[] { sortField });
/* 117 */     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
/* 118 */     PageRequest pageRequest = PageRequest.of(pageNumber - 1, 5, sort);
/* 119 */     if (keyword != null) {
/* 120 */       return this.chiTietSanPhamRepository.findAll(keyword, (Pageable)pageRequest);
/*     */     }
/* 122 */     return this.chiTietSanPhamRepository.findAll((Pageable)pageRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ChiTietSanPham save(ChiTietSanPham chiTietSanPham) {
/* 128 */     return (ChiTietSanPham)this.chiTietSanPhamRepository.save(chiTietSanPham);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChiTietSanPham get(Integer id) throws ChiTietSanPhamNotFountException {
/*     */     try {
/* 134 */       return this.chiTietSanPhamRepository.findById(id).get();
/* 135 */     } catch (NoSuchElementException ex) {
/* 136 */       throw new ChiTietSanPhamNotFountException("không tìm thấy sản phẩm có id" + id);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUniqueChiTietSanPham(String maChiTietSanPham, String tenSanPham, String tenDayDeo, String tenMauSac, String tenKichCo, String tenVatLieu) {
/* 149 */     ChiTietSanPham existingByMa = this.chiTietSanPhamRepository.findByMaChiTietSanPham(maChiTietSanPham);
/* 150 */     ChiTietSanPham existingByNames = this.chiTietSanPhamRepository.findBySanPham_TenSanPhamAndDayDeo_TenDayDeoAndMauSac_TenMauSacAndKichCo_TenKichCoAndVatLieu_TenVatLieu(tenSanPham, tenDayDeo, tenMauSac, tenKichCo, tenVatLieu);
/*     */ 
/*     */     
/* 153 */     return (existingByMa == null && existingByNames == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUniqueChiTietSanPhamUpdate(Integer idChiTietSanPham, String maChiTietSanPham, String tenSanPham, String tenDayDeo, String tenMauSac, String tenKichCo, String tenVatLieu) {
/* 167 */     ChiTietSanPham existingById = this.chiTietSanPhamRepository.findByIdChiTietSanPham(idChiTietSanPham);
/* 168 */     ChiTietSanPham existingByMa = this.chiTietSanPhamRepository.findByMaChiTietSanPham(maChiTietSanPham);
/* 169 */     ChiTietSanPham existingByNames = this.chiTietSanPhamRepository.findBySanPham_TenSanPhamAndDayDeo_TenDayDeoAndMauSac_TenMauSacAndKichCo_TenKichCoAndVatLieu_TenVatLieu(tenSanPham, tenDayDeo, tenMauSac, tenKichCo, tenVatLieu);
/*     */ 
/*     */     
/* 172 */     return (existingByMa == null && existingByNames == null && existingById == null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\ChiTietSanPhamServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */