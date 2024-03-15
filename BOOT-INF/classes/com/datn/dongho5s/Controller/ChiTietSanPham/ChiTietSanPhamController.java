/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.ChiTietSanPham;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*     */ import com.datn.dongho5s.Entity.DayDeo;
/*     */ import com.datn.dongho5s.Entity.KhuyenMai;
/*     */ import com.datn.dongho5s.Entity.KichCo;
/*     */ import com.datn.dongho5s.Entity.MauSac;
/*     */ import com.datn.dongho5s.Entity.SanPham;
/*     */ import com.datn.dongho5s.Entity.VatLieu;
/*     */ import com.datn.dongho5s.Exception.ChiTietSanPhamNotFountException;
/*     */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*     */ import com.datn.dongho5s.Service.DayDeoService;
/*     */ import com.datn.dongho5s.Service.KhuyenMaiService;
/*     */ import com.datn.dongho5s.Service.KichCoService;
/*     */ import com.datn.dongho5s.Service.MauSacService;
/*     */ import com.datn.dongho5s.Service.SanPhamService;
/*     */ import com.datn.dongho5s.Service.VatLieuService;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.repository.query.Param;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ @Controller
/*     */ public class ChiTietSanPhamController
/*     */ {
/*     */   @Autowired
/*     */   private ChiTietSanPhamService chiTietSanPhamService;
/*     */   @Autowired
/*     */   private SanPhamService sanPhamService;
/*     */   @Autowired
/*     */   private DayDeoService dayDeoService;
/*     */   @Autowired
/*     */   private KhuyenMaiService khuyenMaiService;
/*     */   @Autowired
/*     */   private MauSacService mauSacService;
/*     */   @Autowired
/*     */   private VatLieuService vatLieuService;
/*     */   @Autowired
/*     */   private KichCoService kichCoService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/productDetails"})
/*     */   public String listFirstPage(Model model) {
/*  54 */     HttpSession session = this.request.getSession();
/*  55 */     if (session.getAttribute("admin") == null) {
/*  56 */       return "redirect:/login-admin";
/*     */     }
/*  58 */     return listByPage(1, model, "maChiTietSanPham", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/productDetails/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  66 */     HttpSession session = this.request.getSession();
/*  67 */     if (session.getAttribute("admin") == null) {
/*  68 */       return "redirect:/login-admin";
/*     */     }
/*  70 */     Page<ChiTietSanPham> page = this.chiTietSanPhamService.listByPage(pageNum, sortField, sortDir, keyword);
/*  71 */     List<ChiTietSanPham> listChiTietSanPham = page.getContent();
/*     */ 
/*     */     
/*  74 */     long startCount = ((pageNum - 1) * 5 + 1);
/*  75 */     long endCount = startCount + 5L - 1L;
/*  76 */     if (endCount > page.getTotalElements()) {
/*  77 */       endCount = page.getTotalElements();
/*     */     }
/*  79 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  80 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  81 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  82 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  83 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  84 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  85 */     model.addAttribute("listChiTietSanPham", listChiTietSanPham);
/*  86 */     model.addAttribute("sortField", sortField);
/*  87 */     model.addAttribute("sortDir", sortDir);
/*  88 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  89 */     model.addAttribute("keyword", keyword);
/*  90 */     return "admin/chitietsanpham/product_detail";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/productDetails/new"})
/*     */   public String newProduct(Model model) {
/*  96 */     HttpSession session = this.request.getSession();
/*  97 */     if (session.getAttribute("admin") == null) {
/*  98 */       return "redirect:/login-admin";
/*     */     }
/* 100 */     List<SanPham> listSanPham = this.sanPhamService.listAll();
/* 101 */     List<DayDeo> listDayDeo = this.dayDeoService.getAllDayDeo();
/* 102 */     List<KhuyenMai> listKhuyenMai = this.khuyenMaiService.listAll();
/* 103 */     List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
/* 104 */     List<VatLieu> listVatLieu = this.vatLieuService.getAllVatLieu();
/* 105 */     List<KichCo> listKichCo = this.kichCoService.getAllKichCo();
/* 106 */     ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
/* 107 */     chiTietSanPham.setTrangThai(Integer.valueOf(1));
/* 108 */     model.addAttribute("chiTietSanPham", chiTietSanPham);
/* 109 */     model.addAttribute("listSanPham", listSanPham);
/* 110 */     model.addAttribute("listDayDeo", listDayDeo);
/* 111 */     model.addAttribute("listKhuyenMai", listKhuyenMai);
/* 112 */     model.addAttribute("listMauSac", listMauSac);
/* 113 */     model.addAttribute("listVatLieu", listVatLieu);
/* 114 */     model.addAttribute("listKichCo", listKichCo);
/* 115 */     return "admin/chitietsanpham/product_detail_create";
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/admin/productDetails/save"})
/*     */   public String saveProductDetails(ChiTietSanPham chiTietSanPham, RedirectAttributes ra) throws IOException {
/* 121 */     HttpSession session = this.request.getSession();
/* 122 */     if (session.getAttribute("admin") == null) {
/* 123 */       return "redirect:/login-admin";
/*     */     }
/* 125 */     this.chiTietSanPhamService.save(chiTietSanPham);
/* 126 */     ra.addFlashAttribute("message", "Thay Đổi Thành Công.");
/* 127 */     return "redirect:/admin/productDetails";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/productDetails/edit/{id}"})
/*     */   public String editProduct(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
/*     */     try {
/* 135 */       HttpSession session = this.request.getSession();
/* 136 */       if (session.getAttribute("admin") == null) {
/* 137 */         return "redirect:/login-admin";
/*     */       }
/* 139 */       ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.get(id);
/* 140 */       List<SanPham> listSanPham = this.sanPhamService.listAll();
/* 141 */       List<DayDeo> listDayDeo = this.dayDeoService.getAllDayDeo();
/* 142 */       List<KhuyenMai> listKhuyenMai = this.khuyenMaiService.listAll();
/* 143 */       List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
/* 144 */       List<VatLieu> listVatLieu = this.vatLieuService.getAllVatLieu();
/* 145 */       List<KichCo> listKichCo = this.kichCoService.getAllKichCo();
/*     */       
/* 147 */       model.addAttribute("chiTietSanPham", chiTietSanPham);
/* 148 */       model.addAttribute("listSanPham", listSanPham);
/* 149 */       model.addAttribute("listDayDeo", listDayDeo);
/* 150 */       model.addAttribute("listKhuyenMai", listKhuyenMai);
/* 151 */       model.addAttribute("listMauSac", listMauSac);
/* 152 */       model.addAttribute("listVatLieu", listVatLieu);
/* 153 */       model.addAttribute("listKichCo", listKichCo);
/*     */       
/* 155 */       return "admin/chitietsanpham/product_detail_edit";
/* 156 */     } catch (ChiTietSanPhamNotFountException e) {
/* 157 */       ra.addFlashAttribute("message", e.getMessage());
/* 158 */       return "redirect:/admin/productDetails";
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/productDetails/update"})
/*     */   public String updateProductDetails(ChiTietSanPham chiTietSanPham, RedirectAttributes ra) throws IOException {
/* 164 */     HttpSession session = this.request.getSession();
/* 165 */     if (session.getAttribute("admin") == null) {
/* 166 */       return "redirect:/login-admin";
/*     */     }
/* 168 */     this.chiTietSanPhamService.save(chiTietSanPham);
/* 169 */     ra.addFlashAttribute("message", "Thay Đổi Thành Công.");
/* 170 */     return "redirect:/admin/productDetails";
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\ChiTietSanPham\ChiTietSanPhamController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */