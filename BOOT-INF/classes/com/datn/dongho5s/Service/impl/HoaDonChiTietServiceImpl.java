/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.HoaDonChiTietRepository;
/*     */ import com.datn.dongho5s.Repository.SeriRepository;
/*     */ import com.datn.dongho5s.Request.HoaDonChiTietRequest;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class HoaDonChiTietServiceImpl
/*     */   implements HoaDonChiTietService
/*     */ {
/*     */   @Autowired
/*     */   HoaDonChiTietRepository hoaDonChiTietRepository;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @Autowired
/*     */   DonHangService donHangService;
/*     */   @Autowired
/*     */   ChiTietSanPhamService chiTietSanPhamService;
/*     */   @Autowired
/*     */   SeriRepository seriRepository;
/*     */   
/*     */   public HoaDonChiTiet save(HoaDonChiTiet hdct) {
/*  35 */     return (HoaDonChiTiet)this.hoaDonChiTietRepository.save(hdct);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> convertToListHoaDonChiTiet(List<HoaDonChiTietRequest> list, Integer idDonHang) {
/*  40 */     List<HoaDonChiTiet> result = new ArrayList<>();
/*     */     
/*  42 */     list.forEach(item -> {
/*     */           Integer chietKhau = null;
/*     */ 
/*     */           
/*     */           ChiTietSanPham ctsp = this.chiTietSanPhamService.getChiTietSanPhamById(item.getIdChiTietSanPham());
/*     */ 
/*     */           
/*     */           if (ctsp.getKhuyenMai() == null || !ctsp.getKhuyenMai().isEnabled()) {
/*     */             chietKhau = null;
/*     */           } else {
/*     */             chietKhau = ctsp.getKhuyenMai().getChietKhau();
/*     */           } 
/*     */           
/*     */           HoaDonChiTiet hdct = HoaDonChiTiet.builder().donHang(this.donHangService.getById(idDonHang)).chiTietSanPham(ctsp).soLuong(item.getSoLuong()).giaBan(ctsp.getGiaSanPham()).chietKhau(chietKhau).build();
/*     */           
/*     */           result.add(hdct);
/*     */         });
/*     */     
/*  60 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> listHDCT) {
/*  65 */     this.hoaDonChiTietRepository.saveAll(listHDCT);
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Double getTongGia(List<HoaDonChiTietRequest> list) {
/*  71 */     Double result = Double.valueOf(0.0D);
/*  72 */     for (int i = 0; i < list.size(); i++) {
/*  73 */       Double giaBan = this.chiTietSanPhamService.getChiTietSanPhamById(((HoaDonChiTietRequest)list.get(i)).getIdChiTietSanPham()).getGiaSanPham();
/*  74 */       result = Double.valueOf(result.doubleValue() + ((HoaDonChiTietRequest)list.get(i)).getSoLuong().intValue() * giaBan.doubleValue());
/*     */     } 
/*  76 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> getByIdDonHang(int id) {
/*  81 */     return this.hoaDonChiTietRepository.findHDCTBYIdDonHang(id);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> getByHoaDonId(DonHang donHang) {
/*  86 */     return this.hoaDonChiTietRepository.findByDonHang(donHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> getHDCTByMaDonHang(String maDonHang) {
/*  91 */     List<HoaDonChiTiet> hoaDonChiTietPage = this.hoaDonChiTietRepository.findByMaDonHang(maDonHang);
/*  92 */     return hoaDonChiTietPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void themSoLuongSanPham(int soLuong, ChiTietSanPham chiTietSanPham, DonHang donHang) {
/* 101 */     int existIdHCT = -1;
/* 102 */     for (HoaDonChiTiet hoaDonChiTiet : donHang.getListHoaDonChiTiet()) {
/* 103 */       if (hoaDonChiTiet.getChiTietSanPham().getIdChiTietSanPham() == chiTietSanPham.getIdChiTietSanPham()) {
/* 104 */         existIdHCT = hoaDonChiTiet.getIdHoaDonChiTiet().intValue();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     if (existIdHCT == -1) {
/*     */       
/* 112 */       HoaDonChiTiet hoaDonChiTiet = (HoaDonChiTiet)this.hoaDonChiTietRepository.save(
/* 113 */           HoaDonChiTiet.builder()
/* 114 */           .chiTietSanPham(chiTietSanPham)
/* 115 */           .donHang(donHang)
/* 116 */           .giaBan(chiTietSanPham.getGiaSanPham())
/* 117 */           .soLuong(Integer.valueOf(soLuong))
/* 118 */           .chietKhau((chiTietSanPham.getKhuyenMai() == null || !chiTietSanPham.getKhuyenMai().isEnabled()) ? null : chiTietSanPham.getKhuyenMai().getChietKhau())
/* 119 */           .build());
/* 120 */       List<Integer> listSeri = this.seriRepository.getListSeri(soLuong, chiTietSanPham.getIdChiTietSanPham().intValue());
/*     */       
/* 122 */       this.seriRepository.themSoLuongAdmin(hoaDonChiTiet.getIdHoaDonChiTiet().intValue(), listSeri);
/*     */     } else {
/*     */       
/* 125 */       this.hoaDonChiTietRepository.updateSoLuongSanPham(soLuong, existIdHCT);
/* 126 */       List<Integer> listSeri = this.seriRepository.getListSeri(soLuong, chiTietSanPham.getIdChiTietSanPham().intValue());
/*     */       
/* 128 */       this.seriRepository.themSoLuongAdmin(existIdHCT, listSeri);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xoaHDCT(HoaDonChiTiet hoaDonChiTiet) {
/* 136 */     this.seriRepository.xoaSoLuongSanPham(hoaDonChiTiet.getIdHoaDonChiTiet().intValue());
/*     */     
/* 138 */     this.hoaDonChiTietRepository.xoaHDCT(hoaDonChiTiet.getIdHoaDonChiTiet().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HoaDonChiTiet findHoaDonChiTietById(int id) {
/* 145 */     return this.hoaDonChiTietRepository.findByIdHoaDonChiTiet(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSoLuongImeiThem(HoaDonChiTiet hoaDonChiTiet, int soLuongThayDoi) {
/* 153 */     this.hoaDonChiTietRepository.updateSoLuongSanPhamWithEdit(soLuongThayDoi, hoaDonChiTiet.getIdHoaDonChiTiet().intValue());
/*     */     
/* 155 */     int soLuongMax = this.seriRepository.soLuongImeiCoTheCapNhat(hoaDonChiTiet.getIdHoaDonChiTiet().intValue());
/*     */     
/* 157 */     if (soLuongThayDoi <= soLuongMax);
/*     */ 
/*     */     
/* 160 */     int slHienTai = hoaDonChiTiet.getSoLuong().intValue();
/* 161 */     this.chiTietSanPhamRepository.updateSoLuongFromHDCT(slHienTai - soLuongThayDoi, hoaDonChiTiet.getChiTietSanPham().getIdChiTietSanPham().intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public void xoaHDCTByIdDonHang(DonHang donHang) {
/* 166 */     List<HoaDonChiTiet> listHDCT = this.hoaDonChiTietRepository.findByDonHang(donHang);
/* 167 */     this.hoaDonChiTietRepository.deleteAll(listHDCT);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\HoaDonChiTietServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */