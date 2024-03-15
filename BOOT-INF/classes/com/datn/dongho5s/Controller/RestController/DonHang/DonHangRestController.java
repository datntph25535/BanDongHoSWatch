/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.DonHang;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Configure.VNPayConfig;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DonHangAPI;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest;
/*     */ import com.datn.dongho5s.Request.DonHangRequest;
/*     */ import com.datn.dongho5s.Request.HoaDonChiTietRequest;
/*     */ import com.datn.dongho5s.Request.ThemDonHangRequest;
/*     */ import com.datn.dongho5s.Response.DonHangResponse;
/*     */ import com.datn.dongho5s.Response.HoaDonChiTietResponse;
/*     */ import com.datn.dongho5s.Response.VNPayUrlResponse;
/*     */ import com.datn.dongho5s.Service.ChiTietGioHangService;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.Service.GioHangService;
/*     */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*     */ import com.datn.dongho5s.Service.KhachHangService;
/*     */ import com.datn.dongho5s.Utils.PhuongThucThanhToan;
/*     */ import java.io.IOException;
/*     */ import java.net.URLEncoder;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.websocket.server.PathParam;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
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
/*     */ @RestController
/*     */ @RequestMapping({"/api/don-hang"})
/*     */ public class DonHangRestController
/*     */ {
/*     */   @Autowired
/*     */   KhachHangService khachHangService;
/*     */   @Autowired
/*     */   DonHangService donHangService;
/*     */   @Autowired
/*     */   HoaDonChiTietService hdctService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   @Autowired
/*     */   GioHangService gioHangService;
/*     */   @Autowired
/*     */   ChiTietGioHangService chiTietGioHangService;
/*     */   
/*     */   @PostMapping({"/tinh-phi-van-chuyen"})
/*     */   public ResponseEntity<?> getPhiVanChuyen(@RequestBody PhiVanChuyenRequest phiVanChuyenRequest) {
/*     */     try {
/*  79 */       Integer fee = DonHangAPI.getFee(phiVanChuyenRequest);
/*  80 */       return ResponseEntity.status(HttpStatus.OK).body(fee);
/*  81 */     } catch (Exception e) {
/*  82 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping({"/them-don-hang"})
/*     */   public ResponseEntity<?> taoDonHang(@RequestBody ThemDonHangRequest themDonHangRequest) {
/*     */     try {
/*  89 */       KhachHang khachHang = this.khachHangService.findKhachHangById(themDonHangRequest.getKhachHangId());
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
/*     */       
/* 104 */       DonHang donHang = DonHang.builder().khachHang(khachHang).ngayTao(new Date()).trangThaiDonHang(Integer.valueOf(0)).idTinhThanh(themDonHangRequest.getIdTinhThanh()).idQuanHuyen(themDonHangRequest.getIdQuanHuyen()).idPhuongXa(themDonHangRequest.getIdPhuongXa()).diaChi(themDonHangRequest.getDiaChi()).phiVanChuyen(themDonHangRequest.getPhiVanChuyen()).ghiChu(themDonHangRequest.getGhiChu()).ngayCapNhap(new Date()).maDonHang("DH" + System.currentTimeMillis()).phuongThuc(PhuongThucThanhToan.TRA_SAU).tongTien(this.hdctService.getTongGia(themDonHangRequest.getListHoaDonChiTietRequest())).build();
/* 105 */       DonHang savedDonHang = this.donHangService.save(donHang);
/* 106 */       List<HoaDonChiTiet> listHoaDonChiTiet = this.hdctService.convertToListHoaDonChiTiet(themDonHangRequest.getListHoaDonChiTietRequest(), savedDonHang.getIdDonHang());
/* 107 */       this.hdctService.saveAll(listHoaDonChiTiet);
/*     */       
/* 109 */       List<Integer> listCTSPId = new ArrayList<>();
/* 110 */       themDonHangRequest.getListHoaDonChiTietRequest().forEach(item -> listCTSPId.add(item.getIdChiTietSanPham()));
/*     */ 
/*     */       
/* 113 */       this.chiTietGioHangService.removeByCTSPAndKhachHang(khachHang.getIdKhachHang(), listCTSPId);
/* 114 */       return ResponseEntity.status(HttpStatus.OK).body(savedDonHang);
/* 115 */     } catch (Exception e) {
/* 116 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<ChiTietItemRequestGHN> toListChiTietItem(List<HoaDonChiTiet> listHDCT) {
/* 121 */     List<ChiTietItemRequestGHN> result = new ArrayList<>();
/* 122 */     listHDCT.forEach(hdct -> {
/*     */           ChiTietItemRequestGHN item = ChiTietItemRequestGHN.builder().giaBan(hdct.getGiaBan()).soLuong(hdct.getSoLuong()).ctsp(hdct.getChiTietSanPham()).name(hdct.getChiTietSanPham().getSanPham().getTenSanPham()).build();
/*     */ 
/*     */ 
/*     */           
/*     */           result.add(item);
/*     */         });
/*     */ 
/*     */     
/* 131 */     return result;
/*     */   }
/*     */   
/*     */   private HashMap<Integer, String> getListTP() {
/* 135 */     return DiaChiCache.hashMapTinhThanh;
/*     */   }
/*     */   
/*     */   private HashMap<String, String> getListPX(Integer idTP) throws Exception {
/* 139 */     return DiaChiAPI.callGetPhuongXaAPI(idTP);
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/thanh-toan-vnpay"})
/*     */   public ResponseEntity<VNPayUrlResponse> thanhToanVNPAY(@RequestBody ThemDonHangRequest themDonHangRequest) throws IOException {
/* 145 */     KhachHang khachHang = this.khachHangService.findKhachHangById(themDonHangRequest.getKhachHangId());
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
/*     */     
/* 160 */     DonHang donHang = DonHang.builder().khachHang(khachHang).ngayTao(new Date()).trangThaiDonHang(Integer.valueOf(0)).idTinhThanh(themDonHangRequest.getIdTinhThanh()).idQuanHuyen(themDonHangRequest.getIdQuanHuyen()).idPhuongXa(themDonHangRequest.getIdPhuongXa()).diaChi(themDonHangRequest.getDiaChi()).phiVanChuyen(themDonHangRequest.getPhiVanChuyen()).ghiChu(themDonHangRequest.getGhiChu()).ngayCapNhap(new Date()).maDonHang("DH" + System.currentTimeMillis()).tongTien(this.hdctService.getTongGia(themDonHangRequest.getListHoaDonChiTietRequest())).phuongThuc(PhuongThucThanhToan.VNPAY).build();
/* 161 */     DonHang savedDonHang = this.donHangService.save(donHang);
/* 162 */     List<HoaDonChiTiet> listHoaDonChiTiet = this.hdctService.convertToListHoaDonChiTiet(themDonHangRequest.getListHoaDonChiTietRequest(), savedDonHang.getIdDonHang());
/* 163 */     this.hdctService.saveAll(listHoaDonChiTiet);
/* 164 */     List<Integer> listCTSPId = new ArrayList<>();
/* 165 */     themDonHangRequest.getListHoaDonChiTietRequest().forEach(item -> listCTSPId.add(item.getIdChiTietSanPham()));
/*     */ 
/*     */     
/* 168 */     this.chiTietGioHangService.removeByCTSPAndKhachHang(khachHang.getIdKhachHang(), listCTSPId);
/* 169 */     Double amount = Double.valueOf((this.hdctService.getTongGia(themDonHangRequest.getListHoaDonChiTietRequest()).doubleValue() + themDonHangRequest.getPhiVanChuyen().doubleValue()) * 100.0D);
/* 170 */     String vnp_Version = "2.1.0";
/* 171 */     String vnp_Command = "pay";
/* 172 */     String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
/* 173 */     String currCode = "VND";
/* 174 */     String bank_code = "NCB";
/* 175 */     String vnp_TxnRef = String.valueOf(savedDonHang.getIdDonHang());
/*     */ 
/*     */     
/* 178 */     String location = "vn";
/* 179 */     String vnp_IpAddr = VNPayConfig.getIpAddress(this.request);
/* 180 */     String vnp_ReturnUrl = VNPayConfig.vnp_Returnurl;
/*     */     
/* 182 */     Map<String, String> vnp_Params = new HashMap<>();
/* 183 */     vnp_Params.put("vnp_Version", vnp_Version);
/* 184 */     vnp_Params.put("vnp_Command", vnp_Command);
/* 185 */     vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
/* 186 */     vnp_Params.put("vnp_Amount", String.valueOf(amount.intValue()));
/* 187 */     vnp_Params.put("vnp_CurrCode", currCode);
/* 188 */     vnp_Params.put("vnp_BankCode", bank_code);
/* 189 */     vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
/* 190 */     vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang: " + vnp_TxnRef);
/* 191 */     vnp_Params.put("vnp_OrderType", "other");
/* 192 */     vnp_Params.put("vnp_Locale", location);
/* 193 */     vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
/* 194 */     vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
/*     */     
/* 196 */     Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
/* 197 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
/* 198 */     String vnp_CreateDate = formatter.format(cld.getTime());
/* 199 */     vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
/*     */ 
/*     */ 
/*     */     
/* 203 */     List<Comparable> fieldNames = new ArrayList(vnp_Params.keySet());
/* 204 */     Collections.sort(fieldNames);
/* 205 */     StringBuilder hashData = new StringBuilder();
/* 206 */     StringBuilder query = new StringBuilder();
/* 207 */     Iterator<Comparable> itr = fieldNames.iterator();
/* 208 */     while (itr.hasNext()) {
/* 209 */       String fieldName = (String)itr.next();
/* 210 */       String fieldValue = vnp_Params.get(fieldName);
/* 211 */       if (fieldValue != null && fieldValue.length() > 0) {
/* 212 */         hashData.append(fieldName);
/* 213 */         hashData.append('=');
/* 214 */         hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
/* 215 */         query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
/* 216 */         query.append('=');
/* 217 */         query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
/* 218 */         if (itr.hasNext()) {
/* 219 */           query.append('&');
/* 220 */           hashData.append('&');
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     String queryUrl = query.toString();
/* 226 */     String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
/* 227 */     queryUrl = queryUrl + "&vnp_SecureHash=" + queryUrl;
/* 228 */     String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + VNPayConfig.vnp_PayUrl;
/* 229 */     return ResponseEntity.status(HttpStatus.OK).body(new VNPayUrlResponse(paymentUrl));
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/findAll/{idKhachHang}"})
/*     */   public ResponseEntity<?> getAllDH(@PathVariable("idKhachHang") Integer idKhachHang) {
/*     */     try {
/* 236 */       List<DonHangResponse> responseList = this.donHangService.findAllHD(idKhachHang);
/* 237 */       return ResponseEntity.status(HttpStatus.OK).body(responseList);
/* 238 */     } catch (Exception e) {
/* 239 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   @GetMapping({"/findByStatus/{idKhachHang}"})
/*     */   public ResponseEntity<?> getDHbyStatus(@PathVariable("idKhachHang") Integer idKhachHang, @PathParam("status") Integer status) {
/*     */     try {
/* 245 */       List<DonHangResponse> responseList = this.donHangService.findHDByStatus(idKhachHang, status);
/* 246 */       return ResponseEntity.status(HttpStatus.OK).body(responseList);
/* 247 */     } catch (Exception e) {
/* 248 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   @GetMapping({"/findHDCT/{idDonHang}"})
/*     */   public ResponseEntity<?> findHDCT(@PathVariable("idDonHang") Integer idDonHang) {
/*     */     try {
/* 254 */       List<HoaDonChiTietResponse> responseList = this.donHangService.findHDCTbyDH(idDonHang);
/* 255 */       return ResponseEntity.status(HttpStatus.OK).body(responseList);
/* 256 */     } catch (Exception e) {
/* 257 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   @PutMapping({"/update"})
/*     */   public ResponseEntity<?> updateDH(@RequestBody DonHangRequest donHangRequest) {
/* 263 */     return ResponseEntity.status(HttpStatus.OK).body(this.donHangService.updateDH(donHangRequest));
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\DonHang\DonHangRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */