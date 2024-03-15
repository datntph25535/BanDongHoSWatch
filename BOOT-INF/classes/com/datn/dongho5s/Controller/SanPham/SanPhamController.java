/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.SanPham;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.AnhSanPham;
/*     */ import com.datn.dongho5s.Entity.DanhMuc;
/*     */ import com.datn.dongho5s.Entity.SanPham;
/*     */ import com.datn.dongho5s.Entity.ThuongHieu;
/*     */ import com.datn.dongho5s.Exception.SanPhamNotFountException;
/*     */ import com.datn.dongho5s.Service.AnhSanPhamService;
/*     */ import com.datn.dongho5s.Service.DanhmucService;
/*     */ import com.datn.dongho5s.Service.SanPhamService;
/*     */ import com.datn.dongho5s.Service.ThuongHieuService;
/*     */ import com.datn.dongho5s.UploadFile.FileUploadUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.domain.Page;
/*     */ import org.springframework.data.repository.query.Param;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.util.StringUtils;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class SanPhamController
/*     */ {
/*     */   @Autowired
/*     */   private SanPhamService sanPhamService;
/*     */   @Autowired
/*     */   private ThuongHieuService thuongHieuService;
/*     */   @Autowired
/*     */   private DanhmucService danhmucService;
/*     */   @Autowired
/*     */   private AnhSanPhamService anhSanPhamService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/products"})
/*     */   public String listFirstPage(Model model) {
/*  48 */     HttpSession session = this.request.getSession();
/*  49 */     if (session.getAttribute("admin") == null) {
/*  50 */       return "redirect:/login-admin";
/*     */     }
/*  52 */     return listByPage(1, model, "tenSanPham", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/products/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  59 */     HttpSession session = this.request.getSession();
/*  60 */     if (session.getAttribute("admin") == null) {
/*  61 */       return "redirect:/login-admin";
/*     */     }
/*     */ 
/*     */     
/*  65 */     Page<SanPham> page = this.sanPhamService.listByPage(pageNum, sortField, sortDir, keyword);
/*  66 */     List<SanPham> listSanPham = page.getContent();
/*     */ 
/*     */     
/*  69 */     long startCount = ((pageNum - 1) * 5 + 1);
/*  70 */     long endCount = startCount + 5L - 1L;
/*  71 */     if (endCount > page.getTotalElements()) {
/*  72 */       endCount = page.getTotalElements();
/*     */     }
/*  74 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  75 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  76 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  77 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  78 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  79 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  80 */     model.addAttribute("listSanPham", listSanPham);
/*  81 */     model.addAttribute("sortField", sortField);
/*  82 */     model.addAttribute("sortDir", sortDir);
/*  83 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  84 */     model.addAttribute("keyword", keyword);
/*  85 */     return "admin/sanpham/products";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/products/new"})
/*     */   public String newProduct(Model model) {
/*  92 */     HttpSession session = this.request.getSession();
/*  93 */     if (session.getAttribute("admin") == null) {
/*  94 */       return "redirect:/login-admin";
/*     */     }
/*  96 */     List<ThuongHieu> listThuongHieu = this.thuongHieuService.getAllThuongHieu();
/*  97 */     List<DanhMuc> listDanhMuc = this.danhmucService.listAll();
/*  98 */     SanPham sanPham = new SanPham();
/*  99 */     sanPham.setTrangThai(Integer.valueOf(1));
/* 100 */     model.addAttribute("sanPham", sanPham);
/* 101 */     model.addAttribute("listThuongHieu", listThuongHieu);
/* 102 */     model.addAttribute("listDanhMuc", listDanhMuc);
/* 103 */     return "admin/sanpham/product_create";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/admin/products/save"})
/*     */   public String saveProduct(SanPham sanPham, RedirectAttributes ra, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
/* 110 */     HttpSession session = this.request.getSession();
/* 111 */     if (session.getAttribute("admin") == null) {
/* 112 */       return "redirect:/login-admin";
/*     */     }
/* 114 */     System.out.println(multipartFile.getOriginalFilename());
/* 115 */     if (!multipartFile.isEmpty()) {
/* 116 */       String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
/* 117 */       sanPham.setMainImage(fileName);
/* 118 */       AnhSanPham anhSanPham = new AnhSanPham();
/* 119 */       SanPham savedSanPham = this.sanPhamService.save(sanPham);
/* 120 */       anhSanPham.setSanPham(savedSanPham);
/* 121 */       anhSanPham.setLink(multipartFile.getOriginalFilename());
/* 122 */       this.anhSanPhamService.save(anhSanPham);
/*     */       
/* 124 */       String uploadDir = "src/main/resources/static/assets/images/";
/* 125 */       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
/*     */     } else {
/* 127 */       this.sanPhamService.save(sanPham);
/*     */     } 
/*     */     
/* 130 */     ra.addFlashAttribute("message", "Thay Đổi Thành Công.");
/* 131 */     return "redirect:/admin/products";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/products/edit/{id}"})
/*     */   public String editProduct(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
/*     */     try {
/* 139 */       HttpSession session = this.request.getSession();
/* 140 */       if (session.getAttribute("admin") == null) {
/* 141 */         return "redirect:/login-admin";
/*     */       }
/* 143 */       SanPham sanPham = this.sanPhamService.get(id);
/* 144 */       List<ThuongHieu> listThuongHieu = this.thuongHieuService.getAllThuongHieu();
/* 145 */       List<DanhMuc> listDanhMuc = this.danhmucService.listAll();
/*     */       
/* 147 */       model.addAttribute("listThuongHieu", listThuongHieu);
/* 148 */       model.addAttribute("listDanhMuc", listDanhMuc);
/* 149 */       model.addAttribute("sanPham", sanPham);
/*     */       
/* 151 */       return "admin/sanpham/product_edit";
/* 152 */     } catch (SanPhamNotFountException e) {
/* 153 */       ra.addFlashAttribute("message", e.getMessage());
/* 154 */       return "redirect:/admin/products";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/admin/products/update"})
/*     */   public String updateProduct(SanPham sanPham, RedirectAttributes ra, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
/* 161 */     HttpSession session = this.request.getSession();
/* 162 */     if (session.getAttribute("admin") == null) {
/* 163 */       return "redirect:/login-admin";
/*     */     }
/* 165 */     if (!multipartFile.isEmpty()) {
/* 166 */       String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
/* 167 */       sanPham.setMainImage(fileName);
/* 168 */       AnhSanPham anhSanPham = new AnhSanPham();
/* 169 */       SanPham savedSanPham = this.sanPhamService.save(sanPham);
/* 170 */       anhSanPham.setSanPham(savedSanPham);
/* 171 */       anhSanPham.setLink(multipartFile.getOriginalFilename());
/* 172 */       this.anhSanPhamService.save(anhSanPham);
/*     */       
/* 174 */       String uploadDir = "src/main/resources/static/assets/images/";
/*     */       
/* 176 */       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
/*     */     } else {
/*     */       
/* 179 */       sanPham.setMainImage(sanPham.getCurrentMainImage());
/* 180 */       this.sanPhamService.save(sanPham);
/*     */     } 
/*     */     
/* 183 */     ra.addFlashAttribute("message", "Thay Đổi Thành Công.");
/* 184 */     return "redirect:/admin/products";
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\SanPham\SanPhamController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */