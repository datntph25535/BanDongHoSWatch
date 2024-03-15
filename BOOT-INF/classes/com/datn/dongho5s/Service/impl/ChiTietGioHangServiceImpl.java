/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietGioHang;
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.GioHang;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Repository.ChiTietGioHangRepository;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.GioHangRepository;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Request.CartRequest;
/*     */ import com.datn.dongho5s.Response.ChiTietGioHangResponse;
/*     */ import com.datn.dongho5s.Service.ChiTietGioHangService;
/*     */ import com.datn.dongho5s.Service.SeriService;
/*     */ import com.datn.dongho5s.mapper.ChiTietGioHangMapping;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ChiTietGioHangServiceImpl
/*     */   implements ChiTietGioHangService
/*     */ {
/*     */   @Autowired
/*     */   ChiTietGioHangRepository chiTietGioHangRepository;
/*     */   @Autowired
/*     */   SeriService seriService;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @Autowired
/*     */   GioHangRepository gioHangRepository;
/*     */   @Autowired
/*     */   KhachHangRepository khachHangRepository;
/*     */   
/*     */   public List<ChiTietGioHangResponse> getChiTietGioHang(Integer idKhachHang) {
/*  48 */     List<ChiTietGioHang> chiTietGioHangList = this.chiTietGioHangRepository.giohangChiTiet(idKhachHang);
/*  49 */     for (ChiTietGioHang chiTietGioHang : chiTietGioHangList) {
/*  50 */       Integer countSeri = this.seriService.countSeri(chiTietGioHang.getChiTietSanPham().getIdChiTietSanPham());
/*  51 */       if (chiTietGioHang.getSoLuongSanPham().intValue() > countSeri.intValue()) {
/*  52 */         chiTietGioHang.setSoLuongSanPham(countSeri);
/*     */       }
/*     */     } 
/*  55 */     List<ChiTietGioHangResponse> responseList = (List<ChiTietGioHangResponse>)chiTietGioHangList.stream().map(ChiTietGioHangMapping::mapEntitytoResponse).collect(Collectors.toList());
/*  56 */     return responseList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChiTietGioHangResponse update(Integer soLuong, Integer idChiTietGioHang) throws Exception {
/*     */     try {
/*  64 */       ChiTietGioHang chiTietGioHang = this.chiTietGioHangRepository.findById(idChiTietGioHang).get();
/*  65 */       chiTietGioHang.setSoLuongSanPham(soLuong);
/*  66 */       ChiTietGioHangResponse chiTietGioHangResponse = ChiTietGioHangMapping.mapEntitytoResponse((ChiTietGioHang)this.chiTietGioHangRepository.save(chiTietGioHang));
/*     */ 
/*     */ 
/*     */       
/*  70 */       return chiTietGioHangResponse;
/*  71 */     } catch (Exception e) {
/*  72 */       System.out.println(e);
/*  73 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ChiTietGioHangResponse add(CartRequest cartRequest) {
/*  79 */     KhachHang khachHang = this.khachHangRepository.findById(cartRequest.getIdKhachHang()).get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     GioHang gioHang = GioHang.builder().idGioHang(null).ngayTaoGioHang(new Date()).trangThaiGioHang(Integer.valueOf(1)).khachHang(khachHang).thoiGianCapNhapGioHang(new Timestamp((new Date()).getTime())).build();
/*  87 */     this.gioHangRepository.save(gioHang);
/*  88 */     ChiTietSanPham chiTietSanPham = this.chiTietSanPhamRepository.findById(cartRequest.getIdChiTietSanPham()).get();
/*  89 */     if (this.seriService.countSeri(cartRequest.getIdChiTietSanPham()).intValue() < cartRequest.getSoLuong().intValue()) {
/*  90 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     ChiTietGioHang chiTietGioHang = ChiTietGioHang.builder().idChiTietGioHang(Integer.valueOf(1)).chiTietSanPham(chiTietSanPham).gioHang(gioHang).ghiChu("").giaBan(chiTietSanPham.getGiaSanPham()).ngayTao(new Date()).soLuongSanPham(cartRequest.getSoLuong()).build();
/* 101 */     ChiTietGioHangResponse chiTietGioHangResponse = ChiTietGioHangMapping.mapEntitytoResponse((ChiTietGioHang)this.chiTietGioHangRepository.save(chiTietGioHang));
/* 102 */     return chiTietGioHangResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChiTietGioHangResponse addToCart(CartRequest cartRequest) {
/*     */     try {
/* 108 */       GioHang gioHang = this.gioHangRepository.findGioHang(cartRequest.getIdKhachHang());
/* 109 */       if (gioHang == null) {
/* 110 */         return add(cartRequest);
/*     */       }
/* 112 */       ChiTietSanPham chiTietSanPham = this.chiTietSanPhamRepository.findById(cartRequest.getIdChiTietSanPham()).get();
/* 113 */       ChiTietGioHang chiTietGioHang = this.chiTietGioHangRepository.findChiTietGioHangByCTSP(cartRequest.getIdChiTietSanPham(), cartRequest.getIdKhachHang());
/* 114 */       if (chiTietGioHang == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 124 */         ChiTietGioHang chiTietGioHang1 = ChiTietGioHang.builder().idChiTietGioHang(null).chiTietSanPham(chiTietSanPham).gioHang(gioHang).ghiChu("").giaBan(cartRequest.getGiaSanPham()).ngayTao(new Date()).soLuongSanPham(cartRequest.getSoLuong()).build();
/* 125 */         if (this.seriService.countSeri(cartRequest.getIdChiTietSanPham()).intValue() < cartRequest.getSoLuong().intValue()) {
/* 126 */           return null;
/*     */         }
/* 128 */         ChiTietGioHangResponse chiTietGioHangResponse1 = ChiTietGioHangMapping.mapEntitytoResponse((ChiTietGioHang)this.chiTietGioHangRepository.save(chiTietGioHang1));
/* 129 */         return chiTietGioHangResponse1;
/*     */       } 
/* 131 */       if (this.seriService.countSeri(cartRequest.getIdChiTietSanPham()).intValue() < chiTietGioHang.getSoLuongSanPham().intValue() + cartRequest.getSoLuong().intValue()) {
/* 132 */         return null;
/*     */       }
/* 134 */       chiTietGioHang.setSoLuongSanPham(Integer.valueOf(chiTietGioHang.getSoLuongSanPham().intValue() + cartRequest.getSoLuong().intValue()));
/*     */       
/* 136 */       chiTietGioHang.setGiaBan(cartRequest.getGiaSanPham());
/* 137 */       chiTietGioHang.setChiTietSanPham(chiTietSanPham);
/* 138 */       ChiTietGioHangResponse chiTietGioHangResponse = ChiTietGioHangMapping.mapEntitytoResponse((ChiTietGioHang)this.chiTietGioHangRepository.save(chiTietGioHang));
/* 139 */       return chiTietGioHangResponse;
/*     */     
/*     */     }
/* 142 */     catch (Exception e) {
/* 143 */       e.printStackTrace();
/* 144 */       System.out.println("lỗi");
/* 145 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeByCTSPAndKhachHang(Integer idKhachHang, List<Integer> idChiTietSanPhams) {
/* 151 */     List<ChiTietGioHang> listChiTietGioHang = new ArrayList<>();
/* 152 */     idChiTietSanPhams.forEach(item -> {
/*     */           ChiTietGioHang ctgh = this.chiTietGioHangRepository.findChiTietGioHangByCTSPVaKhachHang(item, idKhachHang);
/*     */           listChiTietGioHang.add(ctgh);
/*     */         });
/* 156 */     this.chiTietGioHangRepository.deleteAll(listChiTietGioHang);
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete(Integer id) {
/* 161 */     this.chiTietGioHangRepository.deleteById(id);
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteAll() {
/* 166 */     this.chiTietGioHangRepository.deleteAll();
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\ChiTietGioHangServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */