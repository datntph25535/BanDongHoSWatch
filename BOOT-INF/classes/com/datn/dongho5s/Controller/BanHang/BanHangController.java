/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.BanHang;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.KhachHang;
/*     */ import com.datn.dongho5s.Entity.NhanVien;
/*     */ import com.datn.dongho5s.Request.HoaDonAdminRequest;
/*     */ import com.datn.dongho5s.Response.SanPhamAdminResponse;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*     */ import com.datn.dongho5s.Service.KhachHangService;
/*     */ import com.datn.dongho5s.Service.SanPhamService;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/admin/ban-hang"})
/*     */ public class BanHangController
/*     */ {
/*     */   @Autowired
/*     */   SanPhamService sanPhamService;
/*     */   @Autowired
/*     */   DonHangService donHangService;
/*     */   @Autowired
/*     */   HoaDonChiTietService hoaDonChiTietService;
/*     */   
/*     */   @GetMapping
/*     */   public String getFormBanHang(Model model, HttpSession httpSession) {
/*  53 */     HttpSession session = this.request.getSession();
/*  54 */     if (session.getAttribute("admin") == null) {
/*  55 */       return "redirect:/login-admin";
/*     */     }
/*  57 */     HoaDonAdminRequest hoaDonAdminRequest = new HoaDonAdminRequest();
/*  58 */     model.addAttribute("hoaDonAdminRequest", hoaDonAdminRequest);
/*     */     
/*  60 */     DonHang donHangByMa = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/*  62 */     if (httpSession.getAttribute("donHangHienTai") != null) {
/*  63 */       Double tongTien = Double.valueOf(0.0D);
/*  64 */       for (HoaDonChiTiet h : donHangByMa.getListHoaDonChiTiet()) {
/*  65 */         if (h.getChiTietSanPham().getKhuyenMai().isEnabled() == true) {
/*  66 */           tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue() * h.getChietKhau().intValue() / 100.0D); continue;
/*     */         } 
/*  68 */         tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue());
/*     */       } 
/*     */       
/*  71 */       model.addAttribute("hoaDonAdminRequest", 
/*  72 */           HoaDonAdminRequest.builder()
/*  73 */           .maHoaDon(donHangByMa.getMaDonHang())
/*  74 */           .sdt((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getSoDienThoai())
/*  75 */           .tongTienDonHang(tongTien)
/*  76 */           .ngayTao(dateParseToString(donHangByMa.getNgayTao(), "yyyy-MM-dd"))
/*  77 */           .tenKhachHang((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getTenKhachHang())
/*  78 */           .build());
/*     */     } 
/*  80 */     getListSanPham(model, 1, httpSession, hoaDonAdminRequest);
/*  81 */     getListHDCT(model, 1);
/*  82 */     return "admin/banhang/banhang";
/*     */   }
/*     */   @Autowired
/*     */   ChiTietSanPhamService chiTietSanPhamService; @Autowired
/*     */   KhachHangService khachHangService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/sanpham/page/{pageNum}"})
/*     */   public String getListSanPham(Model model, @PathVariable("pageNum") int pageNum, HttpSession httpSession, @ModelAttribute("hoaDonAdminRequest") HoaDonAdminRequest hoaDonAdminRequest) {
/*  92 */     HttpSession session = this.request.getSession();
/*  93 */     if (session.getAttribute("admin") == null) {
/*  94 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/*  97 */     List<SanPhamAdminResponse> sanPhamList = this.chiTietSanPhamService.getAllSanPhamAminResponse(pageNum);
/*     */     
/*  99 */     model.addAttribute("listSanPham", sanPhamList);
/*     */     
/* 101 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/* 102 */     model.addAttribute("totalPages", Integer.valueOf(this.chiTietSanPhamService.getALlChiTietSanPhamPage(pageNum).getTotalPages()));
/*     */ 
/*     */     
/* 105 */     DonHang donHangByMa = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 107 */     if (donHangByMa != null) {
/* 108 */       List<HoaDonChiTiet> lstHDCT = this.hoaDonChiTietService.getHDCTByMaDonHang(donHangByMa.getMaDonHang());
/*     */       
/* 110 */       model.addAttribute("lstHDCT", lstHDCT);
/*     */       
/* 112 */       Double tongTien = Double.valueOf(0.0D);
/*     */       
/* 114 */       for (HoaDonChiTiet h : donHangByMa.getListHoaDonChiTiet()) {
/* 115 */         if (h.getChiTietSanPham().getKhuyenMai() == null || !h.getChiTietSanPham().getKhuyenMai().isEnabled()) {
/* 116 */           tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue()); continue;
/*     */         } 
/* 118 */         tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue() * h.getChietKhau().intValue() / 100.0D);
/*     */       } 
/*     */       
/* 121 */       model.addAttribute("hoaDonAdminRequest", 
/* 122 */           HoaDonAdminRequest.builder()
/* 123 */           .maHoaDon(donHangByMa.getMaDonHang())
/* 124 */           .sdt((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getSoDienThoai())
/* 125 */           .tongTienDonHang(tongTien)
/* 126 */           .ngayTao(dateParseToString(donHangByMa.getNgayTao(), "yyyy-MM-dd"))
/* 127 */           .tenKhachHang((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getTenKhachHang())
/* 128 */           .build());
/*     */     } 
/*     */     
/* 131 */     return "admin/banhang/banhang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/hoa-don-chi-tiet/page/{pageNum}"})
/*     */   public String getListHDCT(Model model, @PathVariable("pageNum") int pageNum) {
/* 139 */     HttpSession session = this.request.getSession();
/* 140 */     if (session.getAttribute("admin") == null) {
/* 141 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/* 144 */     List<HoaDonChiTiet> lstHDCT = this.hoaDonChiTietService.getHDCTByMaDonHang(null);
/*     */     
/* 146 */     model.addAttribute("lstHDCT", lstHDCT);
/*     */     
/* 148 */     return "admin/banhang/banhang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don/tao-moi"})
/*     */   public String taoHoaDon(Model model, HttpSession httpSession, @ModelAttribute("hoaDonAdminRequest") HoaDonAdminRequest hoaDonAdminRequest) {
/* 158 */     model.addAttribute("currentPage", Integer.valueOf(1));
/* 159 */     model.addAttribute("totalPages", Integer.valueOf(this.chiTietSanPhamService.getALlChiTietSanPhamPage(1).getTotalPages()));
/*     */     
/* 161 */     HttpSession session = this.request.getSession();
/* 162 */     if (session.getAttribute("admin") == null) {
/* 163 */       return "redirect:/login-admin";
/*     */     }
/* 165 */     NhanVien nhanVien = (NhanVien)session.getAttribute("admin");
/* 166 */     model.addAttribute("currentPage", Integer.valueOf(1));
/* 167 */     model.addAttribute("totalPages", Integer.valueOf(this.chiTietSanPhamService.getALlChiTietSanPhamPage(1).getTotalPages()));
/*     */     
/* 169 */     String maDonHangCD = generateMaHD();
/* 170 */     KhachHang khachHang = (KhachHang)httpSession.getAttribute("khachHangExist");
/*     */     
/* 172 */     if (khachHang == null) {
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
/* 185 */       khachHang = KhachHang.builder().tenKhachHang(hoaDonAdminRequest.getTenKhachHang()).soDienThoai(hoaDonAdminRequest.getSdt()).enabled(true).listDiaChi(null).email(null).gioiTinh(null).password(null).ngaySinh(null).ngaySua(new Date()).thoiGianTaoTaiKhoan(null).build();
/*     */       
/* 187 */       this.khachHangService.saveKhachHang(khachHang);
/*     */     } 
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
/* 200 */     DonHang donHang = DonHang.builder().maDonHang(maDonHangCD).trangThaiDonHang(Integer.valueOf(0)).tongTien(Double.valueOf(0.0D)).nhanVien(nhanVien).ngayCapNhap(new Date()).ngayGiaoHang(new Date()).khachHang(khachHang).ngayTao(new Date()).build();
/*     */     
/* 202 */     this.donHangService.save(donHang);
/*     */     
/* 204 */     DonHang donHangByMa = this.donHangService.findByMaDonHang(maDonHangCD);
/*     */     
/* 206 */     httpSession.setAttribute("donHangHienTai", donHangByMa);
/*     */     
/* 208 */     return "redirect:/admin/ban-hang/hoa-don/" + maDonHangCD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/khach-hang/tim-kiem"})
/*     */   public String findKHByPfindhoneNumber(Model model, @RequestParam("phoneNumber") String phoneNumber, @ModelAttribute("hoaDonAdminRequest") HoaDonAdminRequest hoaDonAdminRequest, HttpSession httpSession) {
/* 218 */     HttpSession session = this.request.getSession();
/* 219 */     if (session.getAttribute("admin") == null) {
/* 220 */       return "redirect:/login-admin";
/*     */     }
/* 222 */     KhachHang khachHang = this.khachHangService.findByPhoneNumber(phoneNumber);
/*     */     
/* 224 */     if (khachHang != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       hoaDonAdminRequest = HoaDonAdminRequest.builder().maHoaDon("").sdt(khachHang.getSoDienThoai()).tongTienDonHang(Double.valueOf(0.0D)).ngayTao(dateParseToString(new Date(), "yyyy-MM-dd")).tenKhachHang(khachHang.getTenKhachHang()).build();
/* 233 */       model.addAttribute("hoaDonAdminRequest", hoaDonAdminRequest);
/*     */       
/* 235 */       httpSession.setAttribute("khachHangExist", khachHang);
/*     */     } 
/*     */ 
/*     */     
/* 239 */     List<SanPhamAdminResponse> sanPhamList = this.chiTietSanPhamService.getAllSanPhamAminResponse(1);
/*     */     
/* 241 */     model.addAttribute("listSanPham", sanPhamList);
/*     */     
/* 243 */     model.addAttribute("currentPage", Integer.valueOf(1));
/* 244 */     model.addAttribute("totalPages", Integer.valueOf(this.chiTietSanPhamService.getALlChiTietSanPhamPage(1).getTotalPages()));
/*     */     
/* 246 */     return "admin/banhang/banhang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/khach-hang/api/{phoneNumber}"})
/*     */   @ResponseBody
/*     */   public ResponseEntity<String> findKHByPfindhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
/* 255 */     KhachHang khachHang = this.khachHangService.findByPhoneNumber(phoneNumber);
/* 256 */     if (khachHang != null) {
/* 257 */       return ResponseEntity.status(HttpStatus.OK).body(khachHang.getSoDienThoai());
/*     */     }
/* 259 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/hoa-don/{maHoaDon}"})
/*     */   public String chonHoaDon(@PathVariable("maHoaDon") String maHoaDon, Model model, HttpSession httpSession, @ModelAttribute("hoaDonAdminRequest") HoaDonAdminRequest hoaDonAdminRequest) {
/* 270 */     HttpSession session = this.request.getSession();
/* 271 */     if (session.getAttribute("admin") == null) {
/* 272 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/* 275 */     model.addAttribute("currentPage", Integer.valueOf(1));
/* 276 */     model.addAttribute("totalPages", Integer.valueOf(this.chiTietSanPhamService.getALlChiTietSanPhamPage(1).getTotalPages()));
/*     */     
/* 278 */     DonHang donHangByMa = this.donHangService.findByMaDonHang(maHoaDon);
/*     */     
/* 280 */     httpSession.setAttribute("donHangHienTai", donHangByMa);
/* 281 */     Double tongTien = Double.valueOf(0.0D);
/* 282 */     for (HoaDonChiTiet h : donHangByMa.getListHoaDonChiTiet()) {
/* 283 */       if (h.getChiTietSanPham().getKhuyenMai() == null) {
/* 284 */         tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue()); continue;
/*     */       } 
/* 286 */       if (h.getChiTietSanPham().getKhuyenMai().isEnabled() == true) {
/* 287 */         tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue() * h.getChietKhau().intValue() / 100.0D); continue;
/*     */       } 
/* 289 */       tongTien = Double.valueOf(tongTien.doubleValue() + h.getGiaBan().doubleValue() * h.getSoLuong().intValue());
/*     */     } 
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
/* 301 */     hoaDonAdminRequest = HoaDonAdminRequest.builder().maHoaDon(donHangByMa.getMaDonHang()).sdt((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getSoDienThoai()).tongTienDonHang(tongTien).ngayTao(dateParseToString(donHangByMa.getNgayTao(), "yyyy-MM-dd")).tenKhachHang((donHangByMa.getKhachHang() == null) ? "" : donHangByMa.getKhachHang().getTenKhachHang()).build();
/* 302 */     model.addAttribute("hoaDonAdminRequest", hoaDonAdminRequest);
/*     */ 
/*     */     
/* 305 */     List<SanPhamAdminResponse> sanPhamList = this.chiTietSanPhamService.getAllSanPhamAminResponse(1);
/*     */     
/* 307 */     model.addAttribute("listSanPham", sanPhamList);
/*     */ 
/*     */ 
/*     */     
/* 311 */     List<HoaDonChiTiet> lstHDCT = this.hoaDonChiTietService.getHDCTByMaDonHang(donHangByMa.getMaDonHang());
/*     */     
/* 313 */     model.addAttribute("lstHDCT", lstHDCT);
/*     */ 
/*     */ 
/*     */     
/* 317 */     model.addAttribute("lstCTSP", this.chiTietSanPhamService.getAllSanPhamAminResponse(1));
/*     */     
/* 319 */     return "admin/banhang/banhang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/them/{maCTSP}/{soLuong}"})
/*     */   public String themSoLuongSanPham(@PathVariable("maCTSP") String maCTSP, @PathVariable("soLuong") int soLuong, HttpSession httpSession, Model model) {
/* 329 */     HttpSession session = this.request.getSession();
/* 330 */     if (session.getAttribute("admin") == null) {
/* 331 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/* 334 */     ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.findByMaChiTietSanPham(maCTSP);
/*     */     
/* 336 */     DonHang donHangByMa = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 338 */     this.hoaDonChiTietService.themSoLuongSanPham(soLuong, chiTietSanPham, donHangByMa);
/*     */     
/* 340 */     return "redirect:/admin/ban-hang/hoa-don/" + donHangByMa.getMaDonHang();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don-chi-tiet/{idHDCT}"})
/*     */   public String xoaHDCT(@PathVariable("idHDCT") int idHDCT, HttpSession httpSession, Model model) {
/* 349 */     HttpSession session = this.request.getSession();
/* 350 */     if (session.getAttribute("admin") == null) {
/* 351 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/* 354 */     HoaDonChiTiet hoaDonChiTiet = this.hoaDonChiTietService.findHoaDonChiTietById(idHDCT);
/* 355 */     this.hoaDonChiTietService.xoaHDCT(hoaDonChiTiet);
/*     */     
/* 357 */     DonHang donHangByMa = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 359 */     return "redirect:/admin/ban-hang/hoa-don/" + donHangByMa.getMaDonHang();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don-chi-tiet/sua/{idHD}/so-luong/{soLuong}"})
/*     */   public String updateHDCT(@PathVariable("idHD") int idHDCT, @PathVariable("soLuong") int soLuong, HttpSession httpSession, Model model) {
/* 369 */     HttpSession session = this.request.getSession();
/* 370 */     if (session.getAttribute("admin") == null) {
/* 371 */       return "redirect:/login-admin";
/*     */     }
/* 373 */     int soLuongCapNhat = soLuong;
/* 374 */     HoaDonChiTiet hoaDonChiTiet = this.hoaDonChiTietService.findHoaDonChiTietById(idHDCT);
/*     */     
/* 376 */     if (soLuongCapNhat <= 0) {
/*     */       
/* 378 */       this.hoaDonChiTietService.xoaHDCT(hoaDonChiTiet);
/*     */     }
/*     */     else {
/*     */       
/* 382 */       this.hoaDonChiTietService.updateSoLuongImeiThem(hoaDonChiTiet, soLuongCapNhat);
/*     */     } 
/*     */     
/* 385 */     DonHang donHangByMa = (DonHang)httpSession.getAttribute("donHangHienTai");
/* 386 */     return "redirect:/admin/ban-hang/hoa-don/" + donHangByMa.getMaDonHang();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don/thanh-toan"})
/*     */   public String thanhToan(HttpSession httpSession) {
/* 393 */     HttpSession session = this.request.getSession();
/* 394 */     if (session.getAttribute("admin") == null) {
/* 395 */       return "redirect:/login-admin";
/*     */     }
/* 397 */     DonHang donHang = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 399 */     donHang.setTrangThaiDonHang(Integer.valueOf(3));
/*     */     
/* 401 */     this.donHangService.thanhToanAdmin(donHang);
/*     */     
/* 403 */     httpSession.removeAttribute("donHangHienTai");
/* 404 */     return "redirect:/admin/ban-hang";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don/xuat-hoa-don"})
/*     */   public String xuatHoaDon(HttpSession httpSession, HttpServletResponse response) throws Exception {
/* 412 */     HttpSession session = this.request.getSession();
/* 413 */     if (session.getAttribute("admin") == null) {
/* 414 */       return "redirect:/login-admin";
/*     */     }
/* 416 */     DonHang donHang = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 418 */     donHang.setTrangThaiDonHang(Integer.valueOf(3));
/*     */     
/* 420 */     this.donHangService.thanhToanAdmin(donHang);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 427 */     httpSession.removeAttribute("donHangHienTai");
/* 428 */     return "redirect:/admin/ban-hang";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/hoa-don/huy"})
/*     */   public String huyHoaDon(HttpSession httpSession) {
/* 435 */     HttpSession session = this.request.getSession();
/* 436 */     if (session.getAttribute("admin") == null) {
/* 437 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/* 440 */     DonHang donHang = (DonHang)httpSession.getAttribute("donHangHienTai");
/*     */     
/* 442 */     this.donHangService.xoaDonHangAdmin(donHang);
/*     */     
/* 444 */     httpSession.removeAttribute("donHangHienTai");
/* 445 */     httpSession.removeAttribute("khachHangExist");
/*     */     
/* 447 */     return "redirect:/admin/ban-hang";
/*     */   }
/*     */   public String generateMaHD() {
/* 450 */     return "HD" + (new Date())
/* 451 */       .toString().toUpperCase().replaceAll("[^a-zA-Z0-9]", "") + 
/* 452 */       UUID.randomUUID().toString().toUpperCase().replaceAll("[^a-zA-Z0-9]", "");
/*     */   }
/*     */   
/*     */   public Date stringParseToDate(String dateString, String pattern) {
/* 456 */     SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
/*     */     try {
/* 458 */       return dateFormat.parse(dateString);
/* 459 */     } catch (ParseException e) {
/* 460 */       e.printStackTrace();
/* 461 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String dateParseToString(Date date, String pattern) {
/* 466 */     return (new SimpleDateFormat(pattern)).format(date);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\BanHang\BanHangController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */