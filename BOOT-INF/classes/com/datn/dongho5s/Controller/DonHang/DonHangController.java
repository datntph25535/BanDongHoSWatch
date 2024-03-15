/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.DonHang;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.Seri;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DonHangAPI;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.ChiTietItemRequestGHN;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.Request.TaoDonHangRequestGHN;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*     */ import com.datn.dongho5s.Service.KhachHangService;
/*     */ import com.datn.dongho5s.Service.SeriService;
/*     */ import com.datn.dongho5s.Utils.TrangThaiDonHang;
/*     */ import com.datn.dongho5s.Utils.TrangThaiImei;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ import org.springframework.web.servlet.view.RedirectView;
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
/*     */ @RequestMapping({""})
/*     */ @Controller
/*     */ public class DonHangController
/*     */ {
/*  57 */   private static final Logger log = LoggerFactory.getLogger(com.datn.dongho5s.Controller.DonHang.DonHangController.class);
/*     */   
/*     */   @Autowired
/*     */   KhachHangService khachHangService;
/*     */   
/*     */   @Autowired
/*     */   HoaDonChiTietService hdctService;
/*     */   
/*     */   @Autowired
/*     */   private DonHangService donHangService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   @Autowired
/*     */   ChiTietSanPhamService ctspService;
/*     */   @Autowired
/*     */   SeriService seriService;
/*     */   
/*     */   private List<ChiTietItemRequestGHN> toListChiTietItem(List<HoaDonChiTiet> listHDCT) {
/*  75 */     List<ChiTietItemRequestGHN> result = new ArrayList<>();
/*  76 */     listHDCT.forEach(hdct -> {
/*     */           ChiTietItemRequestGHN item = ChiTietItemRequestGHN.builder().giaBan(hdct.getGiaBan()).soLuong(hdct.getSoLuong()).ctsp(hdct.getChiTietSanPham()).name(hdct.getChiTietSanPham().getSanPham().getTenSanPham()).build();
/*     */ 
/*     */ 
/*     */           
/*     */           result.add(item);
/*     */         });
/*     */ 
/*     */     
/*  85 */     return result;
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
/*     */ 
/*     */   
/*     */   @GetMapping({"/don-hang/thong-tin-thanh-toan"})
/*     */   public RedirectView thongTinThanhToan() {
/*     */     try {
/* 103 */       Map<Object, Object> fields = new HashMap<>();
/* 104 */       for (Enumeration<String> params = this.request.getParameterNames(); params.hasMoreElements(); ) {
/* 105 */         String fieldName = params.nextElement();
/* 106 */         String fieldValue = this.request.getParameter(fieldName);
/* 107 */         if (fieldValue != null && fieldValue.length() > 0) {
/* 108 */           fields.put(fieldName, fieldValue);
/*     */         }
/*     */       } 
/* 111 */       String vnp_SecureHash = this.request.getParameter("vnp_SecureHash");
/* 112 */       if (fields.containsKey("vnp_SecureHash")) {
/* 113 */         fields.remove("vnp_SecureHash");
/*     */       }
/* 115 */       DonHang donhang = this.donHangService.getById(Integer.valueOf(this.request.getParameter("vnp_TxnRef")));
/* 116 */       if (donhang != null) {
/* 117 */         if ("00".equals(this.request.getParameter("vnp_ResponseCode"))) {
/* 118 */           System.out.println("Thanh toán thành công ");
/* 119 */           donhang.setTrangThaiDonHang(TrangThaiDonHang.CHO_XAC_NHAN);
/* 120 */           this.donHangService.save(donhang);
/* 121 */           return new RedirectView("http://localhost:8080/index#/success");
/*     */         } 
/* 123 */         this.hdctService.xoaHDCTByIdDonHang(donhang);
/* 124 */         this.donHangService.xoaDonHang(donhang);
/* 125 */         System.out.println("Không thành công");
/* 126 */         return new RedirectView("http://localhost:8080/index#/fail");
/*     */       } 
/*     */       
/* 129 */       System.out.println("Không tìm thấy order");
/* 130 */       return new RedirectView("http://localhost:8080/index#/fail");
/*     */     }
/* 132 */     catch (Exception e) {
/* 133 */       System.out.println("k xdc");
/* 134 */       return new RedirectView("http://localhost:8080/index#/fail");
/*     */     } 
/*     */   }
/*     */   
/*     */   private TaoDonHangRequestGHN createGHNRequest(DonHang donhang) {
/*     */     try {
/* 140 */       List<HoaDonChiTiet> listHDCT = this.hdctService.getByHoaDonId(donhang);
/* 141 */       Integer soLuong = Integer.valueOf(0);
/* 142 */       for (HoaDonChiTiet item : listHDCT) {
/* 143 */         soLuong = Integer.valueOf(soLuong.intValue() + item.getSoLuong().intValue());
/*     */       }
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
/* 156 */       TaoDonHangRequestGHN requestGHN = TaoDonHangRequestGHN.builder().note(donhang.getGhiChu()).toName(donhang.getKhachHang().getTenKhachHang()).toPhone(donhang.getKhachHang().getSoDienThoai()).toAddress(donhang.getDiaChi()).idQuanHuyen(donhang.getIdQuanHuyen()).idPhuongXa(donhang.getIdPhuongXa()).soLuongSanPham(soLuong).listItems(toListChiTietItem(listHDCT)).phuongThuc(donhang.getPhuongThuc()).thanhTien(donhang.getTongTien()).build();
/* 157 */       return requestGHN;
/* 158 */     } catch (Exception e) {
/* 159 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/don-hang"})
/*     */   public String getForm(Model model, HttpSession httpSession) {
/* 166 */     HttpSession session = this.request.getSession();
/* 167 */     if (session.getAttribute("admin") == null) {
/* 168 */       return "redirect:/login-admin";
/*     */     }
/* 170 */     return findAll(1, model, httpSession);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/don-hang/page/{pageNum}"})
/*     */   public String findAll(@PathVariable("pageNum") int pageNum, Model model, HttpSession httpSession) {
/* 179 */     HttpSession session = this.request.getSession();
/* 180 */     if (session.getAttribute("admin") == null) {
/* 181 */       return "redirect:/login-admin";
/*     */     }
/* 183 */     Page<DonHang> donHangs = this.donHangService.getAll(pageNum);
/*     */     
/* 185 */     model.addAttribute("list", donHangs.getContent());
/*     */     
/* 187 */     model.addAttribute("diaChiCache", new DiaChiCache());
/* 188 */     model.addAttribute("diaChiAPI", new DiaChiAPI());
/* 189 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/* 190 */     model.addAttribute("totalPages", Integer.valueOf(donHangs.getTotalPages()));
/*     */ 
/*     */ 
/*     */     
/* 194 */     return "admin/donhang/donhang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/don-hang/update/{id}/trang-thai/{trangThai}"})
/*     */   public String updateStatusDonHang(HttpSession session, @PathVariable("trangThai") int trangThai, @PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
/* 205 */     HttpSession sessionn = this.request.getSession();
/* 206 */     System.out.println("" + sessionn.getAttribute("admin") + "co sesion r");
/* 207 */     if (sessionn.getAttribute("admin") == null) {
/* 208 */       return "redirect:/login-admin";
/*     */     }
/* 210 */     DonHang donHang = this.donHangService.findById(id);
/* 211 */     if (trangThai == TrangThaiDonHang.DANG_CHUAN_BI.intValue()) {
/*     */       try {
/* 213 */         TaoDonHangRequestGHN donHangRequestGHN = createGHNRequest(donHang);
/* 214 */         Integer code = DonHangAPI.createOrder(donHangRequestGHN);
/* 215 */         if (code.intValue() != 200) {
/* 216 */           log.error("Lỗi gửi Giao Hàng nhanh code {}", code);
/* 217 */           redirectAttributes.addFlashAttribute("error", "Lỗi hệ thống giao hàng nhanh");
/* 218 */           return "redirect:/admin/don-hang";
/*     */         } 
/* 220 */         donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 221 */         donHang.setNgayCapNhap(new Date());
/*     */       }
/* 223 */       catch (Exception e) {
/* 224 */         log.error("Lỗi gửi Giao Hàng nhanh {}", e);
/* 225 */         redirectAttributes.addFlashAttribute("error", "Lỗi request giao hàng nhanh");
/* 226 */         return "redirect:/admin/don-hang";
/*     */       } 
/* 228 */     } else if (trangThai == TrangThaiDonHang.DANG_GIAO.intValue()) {
/* 229 */       donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 230 */       donHang.setNgayCapNhap(new Date());
/* 231 */       List<HoaDonChiTiet> listHDCT = donHang.getListHoaDonChiTiet();
/* 232 */       listHDCT.forEach(hdct -> {
/*     */             ChiTietSanPham ctsp = hdct.getChiTietSanPham();
/*     */             
/*     */             Integer soLuong = hdct.getSoLuong();
/*     */             
/*     */             List<Seri> listSeri = this.seriService.findByChiTietSanPham(ctsp, soLuong);
/*     */             
/*     */             listSeri.forEach(());
/*     */             this.seriService.saveMany(listSeri);
/*     */             hdct.setListSeri(listSeri);
/*     */           });
/* 243 */       this.hdctService.saveAll(listHDCT);
/* 244 */     } else if (trangThai == TrangThaiDonHang.HOAN_THANH.intValue()) {
/* 245 */       donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 246 */       donHang.setNgayCapNhap(new Date());
/* 247 */       List<HoaDonChiTiet> listHDCT = donHang.getListHoaDonChiTiet();
/* 248 */       listHDCT.forEach(hdct -> {
/*     */             ChiTietSanPham ctsp = hdct.getChiTietSanPham();
/*     */             
/*     */             Integer soLuong = hdct.getSoLuong();
/*     */             
/*     */             List<Seri> listSeri = this.seriService.findByChiTietSanPham(ctsp, soLuong);
/*     */             
/*     */             listSeri.forEach(());
/*     */             this.seriService.saveMany(listSeri);
/*     */           });
/* 258 */       this.hdctService.saveAll(listHDCT);
/* 259 */     } else if (trangThai == TrangThaiDonHang.DA_HUY.intValue()) {
/* 260 */       donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 261 */       donHang.setNgayCapNhap(new Date());
/* 262 */       List<HoaDonChiTiet> listHDCT = donHang.getListHoaDonChiTiet();
/* 263 */       listHDCT.forEach(hdct -> {
/*     */             ChiTietSanPham ctsp = hdct.getChiTietSanPham();
/*     */             
/*     */             Integer soLuong = hdct.getSoLuong();
/*     */             
/*     */             List<Seri> listSeri = this.seriService.findByChiTietSanPham(ctsp, soLuong);
/*     */             
/*     */             listSeri.forEach(());
/*     */             
/*     */             this.seriService.saveMany(listSeri);
/*     */           });
/* 274 */       this.hdctService.saveAll(listHDCT);
/* 275 */     } else if (trangThai == TrangThaiDonHang.YEU_CAU_HOAN_TRA.intValue()) {
/* 276 */       donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 277 */       donHang.setNgayCapNhap(new Date());
/* 278 */     } else if (trangThai == TrangThaiDonHang.DA_HOAN_TRA.intValue()) {
/* 279 */       donHang.setTrangThaiDonHang(Integer.valueOf(trangThai));
/* 280 */       donHang.setNgayCapNhap(new Date());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     this.donHangService.updateTrangThaiDonHang(donHang);
/*     */     
/* 289 */     Page<DonHang> donHangs = this.donHangService.getAll(1);
/*     */     
/* 291 */     model.addAttribute("list", donHangs.getContent());
/* 292 */     return "redirect:/admin/don-hang";
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\DonHang\DonHangController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */