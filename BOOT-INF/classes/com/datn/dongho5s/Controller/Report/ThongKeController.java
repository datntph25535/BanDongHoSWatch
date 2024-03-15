/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.Report;
/*     */ 
/*     */ import com.datn.dongho5s.Cache.DiaChiCache;
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.StatusValue;
/*     */ import com.datn.dongho5s.Export.HoaDonPdf;
/*     */ import com.datn.dongho5s.GiaoHangNhanhService.DiaChiAPI;
/*     */ import com.datn.dongho5s.Service.DonHangService;
/*     */ import com.datn.dongho5s.Service.HoaDonChiTietService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.repository.query.Param;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class ThongKeController
/*     */ {
/*     */   @Autowired
/*     */   private DonHangService service;
/*     */   @Autowired
/*     */   private HoaDonChiTietService hoaDonChiTietService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/statisticals"})
/*     */   public String listFirstPage(@RequestParam(name = "status", required = false) Integer status, Model model) {
/*  39 */     HttpSession session = this.request.getSession();
/*  40 */     if (session.getAttribute("admin") == null) {
/*  41 */       return "redirect:/login-admin";
/*     */     }
/*  43 */     if (status != null) {
/*  44 */       return listByPageStatus(1, status.intValue(), model, "ngayTao", "desc", null);
/*     */     }
/*  46 */     return listByPage(1, model, "ngayTao", "desc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/statisticals/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  54 */     HttpSession session = this.request.getSession();
/*  55 */     if (session.getAttribute("admin") == null) {
/*  56 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/*  59 */     Page<DonHang> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  60 */     List<DonHang> listDonHang = page.getContent();
/*  61 */     long startCount = ((pageNum - 1) * 10 + 1);
/*  62 */     long endCount = startCount + 10L - 1L;
/*  63 */     if (endCount > page.getTotalElements()) {
/*  64 */       endCount = page.getTotalElements();
/*     */     }
/*  66 */     List<StatusValue> statusValues = Arrays.asList(new StatusValue[] { new StatusValue(0, "Chờ giao hàng"), new StatusValue(1, "Đang chuẩn bị"), new StatusValue(2, "Đang giao hàng"), new StatusValue(3, "Hoàn thành"), new StatusValue(4, "Đã hủy"), new StatusValue(5, "Yêu cầu hoàn trả"), new StatusValue(6, "Đã hoàn trả") });
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
/*  77 */     model.addAttribute("statusValues", statusValues);
/*     */     
/*  79 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  80 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  81 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  82 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  83 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  84 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  85 */     model.addAttribute("listDonHang", listDonHang);
/*  86 */     model.addAttribute("sortField", sortField);
/*  87 */     model.addAttribute("sortDir", sortDir);
/*  88 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  89 */     model.addAttribute("keyword", keyword);
/*  90 */     model.addAttribute("sumAll", this.service.countDHAll());
/*  91 */     model.addAttribute("sumDHShipping", this.service.countDHbyStatus(Integer.valueOf(2)));
/*  92 */     model.addAttribute("sumDHDone", this.service.countDHbyStatus(Integer.valueOf(3)));
/*  93 */     model.addAttribute("sumDHCancel", this.service.countDHbyStatus(Integer.valueOf(4)));
/*  94 */     model.addAttribute("sumDHReturn", this.service.countDHbyStatus(Integer.valueOf(6)));
/*  95 */     return "admin/thongke/statisticals";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/statisticals/page/{status}/{pageNum}"})
/*     */   private String listByPageStatus(@PathVariable(name = "pageNum") int pageNum, @PathVariable(name = "status") int status, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*     */     Page<DonHang> page;
/* 103 */     HttpSession session = this.request.getSession();
/* 104 */     if (session.getAttribute("admin") == null) {
/* 105 */       return "redirect:/login-admin";
/*     */     }
/* 107 */     List<DonHang> listDonHang = new ArrayList<>();
/*     */     
/* 109 */     if (status == 10) {
/* 110 */       page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/* 111 */       listDonHang = page.getContent();
/*     */     } else {
/* 113 */       page = this.service.listByPageStatus(pageNum, sortField, sortDir, keyword, status);
/* 114 */       listDonHang = page.getContent();
/*     */     } 
/* 116 */     long startCount = ((pageNum - 1) * 10 + 1);
/* 117 */     long endCount = Math.min(startCount + 10L - 1L, page.getTotalElements());
/* 118 */     List<StatusValue> statusValues = Arrays.asList(new StatusValue[] { new StatusValue(0, "Chờ giao hàng"), new StatusValue(1, "Đang chuẩn bị"), new StatusValue(2, "Đang giao hàng"), new StatusValue(3, "Hoàn thành"), new StatusValue(4, "Đã hủy"), new StatusValue(5, "Yêu cầu hoàn trả"), new StatusValue(6, "Đã hoàn trả") });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/* 129 */     model.addAttribute("statusValues", statusValues);
/* 130 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/* 131 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/* 132 */     model.addAttribute("startCount", Long.valueOf(startCount));
/* 133 */     model.addAttribute("endCount", Long.valueOf(endCount));
/* 134 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/* 135 */     model.addAttribute("listDonHang", listDonHang);
/* 136 */     model.addAttribute("sortField", sortField);
/* 137 */     model.addAttribute("sortDir", sortDir);
/* 138 */     model.addAttribute("reverseSortDir", reverseSortDir);
/* 139 */     model.addAttribute("keyword", keyword);
/* 140 */     model.addAttribute("sumAll", this.service.countDHAll());
/* 141 */     model.addAttribute("sumDHShipping", this.service.countDHbyStatus(Integer.valueOf(2)));
/* 142 */     model.addAttribute("sumDHDone", this.service.countDHbyStatus(Integer.valueOf(3)));
/* 143 */     model.addAttribute("sumDHCancel", this.service.countDHbyStatus(Integer.valueOf(4)));
/* 144 */     model.addAttribute("sumDHReturn", this.service.countDHbyStatus(Integer.valueOf(6)));
/* 145 */     model.addAttribute("selectedStatus", Integer.valueOf(status));
/*     */     
/* 147 */     return "admin/thongke/statisticals";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/hoa-don-chi-tiet/search/{id}"})
/*     */   public String getByIdDonHang(@PathVariable("id") int id, Model model, HttpSession session) {
/* 156 */     session = this.request.getSession();
/* 157 */     if (session.getAttribute("admin") == null) {
/* 158 */       return "redirect:/login-admin";
/*     */     }
/* 160 */     List<HoaDonChiTiet> lst = this.hoaDonChiTietService.getByIdDonHang(id);
/* 161 */     Double tongTien = this.service.tongTien(id);
/*     */     
/* 163 */     DonHang donHang = this.service.findById(id);
/*     */     
/* 165 */     model.addAttribute("donHang", donHang);
/* 166 */     model.addAttribute("diaChiCache", new DiaChiCache());
/* 167 */     model.addAttribute("diaChiAPI", new DiaChiAPI());
/*     */     
/* 169 */     model.addAttribute("lstHDCT", lst);
/* 170 */     model.addAttribute("tongTien", donHang.getTongTien());
/*     */     
/* 172 */     session.setAttribute("donHang", donHang);
/*     */     
/* 174 */     return "admin/hoadonchitiet/hoadonchitiet";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/hoa-don-chi-tiet/export"})
/*     */   public void exportHoaDon(HttpServletResponse response, Model model, HttpSession session) throws Exception {
/* 185 */     DonHang donHang = (DonHang)session.getAttribute("donHang");
/*     */     
/* 187 */     List<HoaDonChiTiet> lst = this.hoaDonChiTietService.getByIdDonHang(donHang.getIdDonHang().intValue());
/*     */     
/* 189 */     HoaDonPdf hoaDonPdf = new HoaDonPdf();
/* 190 */     hoaDonPdf.exportToPDF(response, lst, donHang);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\Report\ThongKeController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */