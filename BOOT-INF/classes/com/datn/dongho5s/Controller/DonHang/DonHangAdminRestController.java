/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.DonHang;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.Response.DonHangAdminResponse;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/admin/don-hang"})
/*     */ public class DonHangAdminRestController
/*     */ {
/*     */   @Autowired
/*     */   private DonHangService donHangService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/findByTrangThai/{trangThai}"})
/*     */   public ResponseEntity<?> findByTrangThaiDonHang(@PathVariable("trangThai") int trangThai) {
/*  39 */     List<DonHangAdminResponse> result = new ArrayList<>();
/*  40 */     if (trangThai == 7) {
/*  41 */       List<DonHang> listDH = this.donHangService.getAll(1).getContent();
/*  42 */       listDH.forEach(item -> {
/*     */             try {
/*     */               result.add(toDonHangAdminResponse(item));
/*  45 */             } catch (Exception e) {
/*     */               throw new RuntimeException(e);
/*     */             } 
/*     */           });
/*     */     } else {
/*  50 */       List<DonHang> listDH = this.donHangService.findByTrangThaiDonHang(trangThai);
/*  51 */       listDH.forEach(item -> {
/*     */             try {
/*     */               result.add(toDonHangAdminResponse(item));
/*  54 */             } catch (Exception e) {
/*     */               throw new RuntimeException(e);
/*     */             } 
/*     */           });
/*     */     } 
/*  59 */     Collections.reverse(result);
/*  60 */     return ResponseEntity.status(HttpStatus.OK).body(result);
/*     */   }
/*     */   
/*     */   private DonHangAdminResponse toDonHangAdminResponse(DonHang donHang) throws Exception {
/*  64 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/*  65 */     String tinhThanh = (String)DiaChiCache.hashMapTinhThanh.get(donHang.getIdTinhThanh());
/*  66 */     String quanHuyen = (String)DiaChiAPI.callGetQuanHuyenAPI(donHang.getIdTinhThanh()).get(donHang.getIdQuanHuyen());
/*  67 */     String phuongXa = (String)DiaChiAPI.callGetPhuongXaAPI(donHang.getIdQuanHuyen()).get(donHang.getIdPhuongXa());
/*  68 */     String detailDiaChi = tinhThanh + "-" + tinhThanh + "-" + quanHuyen + "-" + phuongXa;
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
/*  81 */     DonHangAdminResponse result = DonHangAdminResponse.builder().idDonHang(donHang.getIdDonHang()).maDonHang(donHang.getMaDonHang()).khachHang(donHang.getKhachHang()).ngayTao(formatter.format(donHang.getNgayTao())).ngayCapNhap(formatter.format(donHang.getNgayCapNhap())).trangThaiDonHang(donHang.getTrangThaiDonHang()).diaChi(detailDiaChi).tongTien(donHang.getTongTien()).phiVanChuyen(donHang.getPhiVanChuyen()).ghiChu(donHang.getGhiChu()).lyDo(donHang.getLyDo()).build();
/*  82 */     if (donHang.getNhanVien() != null) {
/*  83 */       result.setIdNhanVien(donHang.getNhanVien().getId());
/*     */     }
/*  85 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/search/date"})
/*     */   public ResponseEntity<?> searchByDateStartanDateEnd(HttpSession httpSession, Model model, HttpServletRequest httpServletRequest) {
/*  94 */     String dateStart = httpServletRequest.getParameter("dateStart");
/*  95 */     String dateEnd = httpServletRequest.getParameter("dateEnd");
/*  96 */     Integer status = Integer.valueOf(httpServletRequest.getParameter("status"));
/*     */     
/*  98 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/*  99 */     Date dateStartParse = null;
/* 100 */     Date dateEndParse = null;
/*     */     
/*     */     try {
/* 103 */       dateStartParse = format.parse(dateStart);
/* 104 */       dateEndParse = format.parse(dateEnd);
/* 105 */     } catch (ParseException e) {
/* 106 */       e.printStackTrace();
/*     */     } 
/* 108 */     status = (status.intValue() == 7) ? null : status;
/* 109 */     List<DonHang> lst = this.donHangService.findByNgayTao(dateStartParse, dateEndParse, status);
/* 110 */     return ResponseEntity.status(HttpStatus.OK).body(lst);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\DonHang\DonHangAdminRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */