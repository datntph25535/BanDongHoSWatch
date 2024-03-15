/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.ThuongHieu;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.ThuongHieu;
/*     */ import com.datn.dongho5s.Exception.ThuongHieuNotFoundException;
/*     */ import com.datn.dongho5s.Export.ThuongHieuCsvExporter;
/*     */ import com.datn.dongho5s.Export.ThuongHieuExcelExporter;
/*     */ import com.datn.dongho5s.Service.ThuongHieuService;
/*     */ import java.io.IOException;
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
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class ThuongHieuController
/*     */ {
/*     */   @Autowired
/*     */   private ThuongHieuService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/brands"})
/*     */   public String listFirstPage(Model model) {
/*  36 */     HttpSession session = this.request.getSession();
/*  37 */     if (session.getAttribute("admin") == null) {
/*  38 */       return "redirect:/login-admin";
/*     */     }
/*  40 */     return listByPage(1, model, "tenThuongHieu", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/brands/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  47 */     HttpSession session = this.request.getSession();
/*  48 */     if (session.getAttribute("admin") == null) {
/*  49 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/*  52 */     Page<ThuongHieu> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  53 */     List<ThuongHieu> listThuongHieu = page.getContent();
/*     */     
/*  55 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  56 */     long endCount = startCount + 4L - 1L;
/*  57 */     if (endCount > page.getTotalElements()) {
/*  58 */       endCount = page.getTotalElements();
/*     */     }
/*  60 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  61 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  62 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  63 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  64 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  65 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  66 */     model.addAttribute("listThuongHieu", listThuongHieu);
/*  67 */     model.addAttribute("sortField", sortField);
/*  68 */     model.addAttribute("sortDir", sortDir);
/*  69 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  70 */     model.addAttribute("keyword", keyword);
/*  71 */     return "admin/thuonghieu/brands";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/brands/{id}/enabled/{status}"})
/*     */   public String updateThuongHieuEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  79 */     HttpSession session = this.request.getSession();
/*  80 */     if (session.getAttribute("admin") == null) {
/*  81 */       return "redirect:/login-admin";
/*     */     }
/*  83 */     this.service.updateThuongHieuEnabledStatus(id, enabled);
/*  84 */     String status = enabled ? "online" : "offline";
/*  85 */     String message = "Thương Hiệu có id " + id + " thay đổi trạng thái thành " + status;
/*  86 */     redirectAttributes.addFlashAttribute("message", message);
/*  87 */     return "redirect:/brands";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/brands/new"})
/*     */   public String newThuongHieu(Model model) {
/*  92 */     HttpSession session = this.request.getSession();
/*  93 */     if (session.getAttribute("admin") == null) {
/*  94 */       return "redirect:/login-admin";
/*     */     }
/*  96 */     model.addAttribute("thuongHieu", new ThuongHieu());
/*  97 */     model.addAttribute("pageTitle", "Tạo Mới Thương Hiệu");
/*  98 */     return "admin/thuonghieu/brands_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/brands/save"})
/*     */   public String saveThuongHieu(ThuongHieu thuongHieu, RedirectAttributes redirectAttributes) {
/* 103 */     HttpSession session = this.request.getSession();
/* 104 */     if (session.getAttribute("admin") == null) {
/* 105 */       return "redirect:/login-admin";
/*     */     }
/* 107 */     this.service.save(thuongHieu);
/* 108 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 109 */     return "redirect:/admin/brands";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/brands/edit/{id}"})
/*     */   public String editThuongHieu(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 117 */       HttpSession session = this.request.getSession();
/* 118 */       if (session.getAttribute("admin") == null) {
/* 119 */         return "redirect:/login-admin";
/*     */       }
/* 121 */       ThuongHieu thuongHieu = this.service.get(id);
/* 122 */       model.addAttribute("thuongHieu", thuongHieu);
/* 123 */       model.addAttribute("pageTitle", "Update Thương Hiệu (ID: " + id + ")");
/* 124 */       return "admin/thuonghieu/brands_form";
/* 125 */     } catch (ThuongHieuNotFoundException ex) {
/* 126 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 127 */       return "redirect:/admin/brands";
/* 128 */     } catch (Exception ex) {
/* 129 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 130 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/brands/export/csv"})
/*     */   public void exportToCSV(HttpServletResponse response) throws IOException {
/* 136 */     List<ThuongHieu> listThuongHieu = this.service.getAllThuongHieu();
/* 137 */     ThuongHieuCsvExporter exporter = new ThuongHieuCsvExporter();
/* 138 */     exporter.export(listThuongHieu, response);
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/brands/export/excel"})
/*     */   public void exportToExcel(HttpServletResponse response) throws IOException {
/* 143 */     List<ThuongHieu> listThuongHieu = this.service.getAllThuongHieu();
/* 144 */     ThuongHieuExcelExporter exporter = new ThuongHieuExcelExporter();
/* 145 */     exporter.export(listThuongHieu, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\ThuongHieu\ThuongHieuController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */