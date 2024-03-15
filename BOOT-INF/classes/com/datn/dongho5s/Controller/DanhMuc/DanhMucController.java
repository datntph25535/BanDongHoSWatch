/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.DanhMuc;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DanhMuc;
/*     */ import com.datn.dongho5s.Exception.DanhMucNotFoundException;
/*     */ import com.datn.dongho5s.Export.DanhMucCsvExporter;
/*     */ import com.datn.dongho5s.Export.DanhMucExcelExporter;
/*     */ import com.datn.dongho5s.Service.DanhmucService;
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
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class DanhMucController
/*     */ {
/*     */   @Autowired
/*     */   private DanhmucService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/categories"})
/*     */   public String listFirstPage(Model model) {
/*  38 */     HttpSession session = this.request.getSession();
/*  39 */     if (session.getAttribute("admin") == null) {
/*  40 */       return "redirect:/login-admin";
/*     */     }
/*  42 */     return listByPage(1, model, "ten", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/categories/page/{pageNum}"})
/*     */   public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  50 */     HttpSession session = this.request.getSession();
/*  51 */     if (session.getAttribute("admin") == null) {
/*  52 */       return "redirect:/login-admin";
/*     */     }
/*  54 */     System.out.println("SortField: " + sortField);
/*  55 */     System.out.println("sortOrder: " + sortDir);
/*  56 */     Page<DanhMuc> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  57 */     List<DanhMuc> listDanhMuc = page.getContent();
/*     */     
/*  59 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  60 */     long endCount = startCount + 4L - 1L;
/*     */     
/*  62 */     if (endCount > page.getTotalElements()) {
/*  63 */       endCount = page.getTotalElements();
/*     */     }
/*     */     
/*  66 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*     */     
/*  68 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  69 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  70 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  71 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  72 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  73 */     model.addAttribute("listDanhMuc", listDanhMuc);
/*  74 */     model.addAttribute("sortField", sortField);
/*  75 */     model.addAttribute("sortDir", sortDir);
/*  76 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  77 */     model.addAttribute("keyword", keyword);
/*  78 */     return "admin/danhmuc/categories";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/categories/{id}/enabled/{status}"})
/*     */   public String updateDanhMucEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  86 */     HttpSession session = this.request.getSession();
/*  87 */     if (session.getAttribute("admin") == null) {
/*  88 */       return "redirect:/login-admin";
/*     */     }
/*  90 */     this.service.updateDanhMucEnabledStatus(id, enabled);
/*  91 */     String status = enabled ? "online" : "offline";
/*  92 */     String message = "Danh Mục có id " + id + " thay đổi trạng thái thành " + status;
/*  93 */     redirectAttributes.addFlashAttribute("message", message);
/*  94 */     return "redirect:/categories";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/categories/new"})
/*     */   public String newDanhMuc(Model model) {
/*  99 */     HttpSession session = this.request.getSession();
/* 100 */     if (session.getAttribute("admin") == null) {
/* 101 */       return "redirect:/login-admin";
/*     */     }
/* 103 */     model.addAttribute("danhMuc", new DanhMuc());
/* 104 */     model.addAttribute("pageTitle", "Tạo Mới Danh Mục");
/* 105 */     return "admin/danhmuc/categories_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/categories/save"})
/*     */   public String saveDanhMuc(DanhMuc danhMuc, RedirectAttributes redirectAttributes) {
/* 110 */     HttpSession session = this.request.getSession();
/* 111 */     if (session.getAttribute("admin") == null) {
/* 112 */       return "redirect:/login-admin";
/*     */     }
/* 114 */     this.service.save(danhMuc);
/* 115 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 116 */     return "redirect:/admin/categories";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/categories/edit/{id}"})
/*     */   public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 124 */       HttpSession session = this.request.getSession();
/* 125 */       if (session.getAttribute("admin") == null) {
/* 126 */         return "redirect:/login-admin";
/*     */       }
/* 128 */       DanhMuc danhMuc = this.service.get(id);
/* 129 */       model.addAttribute("danhMuc", danhMuc);
/* 130 */       model.addAttribute("pageTitle", "Update Danh Mục (ID : " + id + ")");
/* 131 */       return "admin/danhmuc/categories_form";
/* 132 */     } catch (DanhMucNotFoundException ex) {
/* 133 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 134 */       return "redirect:/admin/categories";
/* 135 */     } catch (Exception ex) {
/* 136 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 137 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/categories/export/csv"})
/*     */   public void exportToCSV(HttpServletResponse response) throws IOException {
/* 145 */     List<DanhMuc> listDanhMuc = this.service.listAll();
/* 146 */     DanhMucCsvExporter exporter = new DanhMucCsvExporter();
/* 147 */     exporter.export(listDanhMuc, response);
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/categories/export/excel"})
/*     */   public void exportToExcel(HttpServletResponse response) throws IOException {
/* 152 */     List<DanhMuc> listDanhMuc = this.service.listAll();
/* 153 */     DanhMucExcelExporter exporter = new DanhMucExcelExporter();
/* 154 */     exporter.export(listDanhMuc, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\DanhMuc\DanhMucController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */