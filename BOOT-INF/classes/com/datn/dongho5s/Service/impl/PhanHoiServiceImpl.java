/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Entity.PhanHoi;
/*     */ import com.datn.dongho5s.Repository.ChiTietSanPhamRepository;
/*     */ import com.datn.dongho5s.Repository.DonHangRepository;
/*     */ import com.datn.dongho5s.Repository.KhachHangRepository;
/*     */ import com.datn.dongho5s.Repository.PhanHoiRepository;
/*     */ import com.datn.dongho5s.Request.PhanHoiRequest;
/*     */ import com.datn.dongho5s.Response.PhanHoiResponse;
/*     */ import com.datn.dongho5s.Service.PhanHoiService;
/*     */ import com.datn.dongho5s.mapper.PhanHoiMapping;
/*     */ import java.sql.Timestamp;
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
/*     */ 
/*     */ @Service
/*     */ public class PhanHoiServiceImpl
/*     */   implements PhanHoiService
/*     */ {
/*     */   @Autowired
/*     */   PhanHoiRepository phanHoiRepository;
/*     */   @Autowired
/*     */   ChiTietSanPhamRepository chiTietSanPhamRepository;
/*     */   @Autowired
/*     */   DonHangRepository donHangRepository;
/*     */   @Autowired
/*     */   KhachHangRepository khachHangRepository;
/*     */   
/*     */   public List<PhanHoiResponse> findAll(Integer idChiTietSanPham) {
/*  45 */     List<PhanHoi> phanHoiList = this.phanHoiRepository.findAll(idChiTietSanPham);
/*  46 */     List<PhanHoiResponse> responseList = (List<PhanHoiResponse>)phanHoiList.stream().map(PhanHoiMapping::mapEntitytoResponse).collect(Collectors.toList());
/*  47 */     responseList.sort((o1, o2) -> o2.getNgayTao().compareTo(o1.getNgayTao()));
/*  48 */     return responseList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkPhanHoi(Integer idKhachHang, Integer idChiTietSanPham) {
/*  53 */     List<HoaDonChiTiet> donHangList = this.donHangRepository.findHDDonHang(idKhachHang, idChiTietSanPham);
/*  54 */     System.out.println(donHangList);
/*  55 */     if (donHangList.isEmpty()) {
/*  56 */       System.out.println("rỗng rồi");
/*  57 */       return true;
/*     */     } 
/*  59 */     Long countPH = this.phanHoiRepository.countPhanHoi(idKhachHang, idChiTietSanPham);
/*  60 */     Long countHDCT = this.phanHoiRepository.countHDCT(idKhachHang, idChiTietSanPham);
/*  61 */     if (donHangList != null) {
/*  62 */       if (countPH.longValue() < countHDCT.longValue()) {
/*  63 */         return false;
/*     */       }
/*  65 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PhanHoiResponse addPhanHoi(PhanHoiRequest phanHoiRequest) {
/*  81 */     KhachHang khachHang = this.khachHangRepository.findById(phanHoiRequest.getIdKhachHang()).get();
/*  82 */     ChiTietSanPham chiTietSanPham = this.chiTietSanPhamRepository.findById(phanHoiRequest.getIdChiTietSanPham()).get();
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
/*  94 */     PhanHoi phanHoi = PhanHoi.builder().idPhanHoi(null).chiTietSanPham(chiTietSanPham).danhGia(phanHoiRequest.getDanhGia()).ghiChu(null).noiDungPhanHoi(phanHoiRequest.getNoiDungPhanHoi()).khachHang(khachHang).ngaySua(null).thoiGianPhanHoi(new Timestamp((new Date()).getTime())).trangThaiPhanHoi(Integer.valueOf(0)).ngayTao(new Date()).build();
/*     */     
/*  96 */     PhanHoiResponse phanHoiResponse = PhanHoiMapping.mapEntitytoResponse((PhanHoi)this.phanHoiRepository.save(phanHoi));
/*  97 */     return phanHoiResponse;
/*     */   }
/*     */ 
/*     */   
/*     */   public Long countPH(Integer idKhachHang, Integer idChiTietSanPham) {
/* 102 */     System.out.println(this.phanHoiRepository.countPhanHoi(idKhachHang, idChiTietSanPham));
/* 103 */     return this.phanHoiRepository.countPhanHoi(idKhachHang, idChiTietSanPham);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long countHDCT(Integer idKhachHang, Integer idChiTietSanPham) {
/* 108 */     return this.phanHoiRepository.countHDCT(idKhachHang, idChiTietSanPham);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\PhanHoiServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */