/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.VatLieu;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.VatLieu;
/*     */ import com.datn.dongho5s.Exception.VatLieuNotFoundException;
/*     */ import com.datn.dongho5s.Export.VatLieuCsvExporter;
/*     */ import com.datn.dongho5s.Export.VatLieuExcelExporter;
/*     */ import com.datn.dongho5s.Service.VatLieuService;
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
/*     */ @Controller
/*     */ public class VatLieuController
/*     */ {
/*     */   @Autowired
/*     */   private VatLieuService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/materials"})
/*     */   public String listFirstPage(Model model) {
/*  33 */     HttpSession session = this.request.getSession();
/*  34 */     if (session.getAttribute("admin") == null) {
/*  35 */       return "redirect:/login-admin";
/*     */     }
/*  37 */     return listByPage(1, model, "tenVatLieu", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/materials/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  44 */     HttpSession session = this.request.getSession();
/*  45 */     if (session.getAttribute("admin") == null) {
/*  46 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/*  49 */     Page<VatLieu> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  50 */     List<VatLieu> listVatLieu = page.getContent();
/*  51 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  52 */     long endCount = startCount + 4L - 1L;
/*  53 */     if (endCount > page.getTotalElements()) {
/*  54 */       endCount = page.getTotalElements();
/*     */     }
/*  56 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  57 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  58 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  59 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  60 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  61 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  62 */     model.addAttribute("listVatLieu", listVatLieu);
/*  63 */     model.addAttribute("sortField", sortField);
/*  64 */     model.addAttribute("sortDir", sortDir);
/*  65 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  66 */     model.addAttribute("keyword", keyword);
/*  67 */     return "admin/vatlieu/materials";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/materials/{id}/enabled/{status}"})
/*     */   public String updateVatLieuEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  75 */     HttpSession session = this.request.getSession();
/*  76 */     if (session.getAttribute("admin") == null) {
/*  77 */       return "redirect:/login-admin";
/*     */     }
/*  79 */     this.service.updateVatLieuEnabledStatus(id, enabled);
/*  80 */     String status = enabled ? "online" : "offline";
/*  81 */     String message = "Vật liệu có id " + id + " thay đổi trạng thái thành " + status;
/*  82 */     redirectAttributes.addFlashAttribute("message", message);
/*  83 */     return "redirect:/admin/materials";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/materials/new"})
/*     */   public String newVatLieu(Model model) {
/*  88 */     HttpSession session = this.request.getSession();
/*  89 */     if (session.getAttribute("admin") == null) {
/*  90 */       return "redirect:/login-admin";
/*     */     }
/*  92 */     model.addAttribute("vatLieu", new VatLieu());
/*  93 */     model.addAttribute("pageTitle", "Tạo Mới Vật Liệu");
/*  94 */     return "admin/vatlieu/material_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/materials/save"})
/*     */   public String saveVatLieu(VatLieu vatLieu, RedirectAttributes redirectAttributes) {
/*  99 */     HttpSession session = this.request.getSession();
/* 100 */     if (session.getAttribute("admin") == null) {
/* 101 */       return "redirect:/login-admin";
/*     */     }
/* 103 */     this.service.save(vatLieu);
/* 104 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 105 */     return "redirect:/admin/materials";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/materials/edit/{id}"})
/*     */   public String editVatLieu(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 114 */       HttpSession session = this.request.getSession();
/* 115 */       if (session.getAttribute("admin") == null) {
/* 116 */         return "redirect:/login-admin";
/*     */       }
/* 118 */       VatLieu vatLieu = this.service.get(id);
/* 119 */       model.addAttribute("vatLieu", vatLieu);
/* 120 */       model.addAttribute("pageTitle", "Update Vật Liệu (ID: " + id + ")");
/* 121 */       return "admin/vatlieu/material_form";
/* 122 */     } catch (VatLieuNotFoundException ex) {
/* 123 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 124 */       return "redirect:/admin/materials";
/* 125 */     } catch (Exception ex) {
/* 126 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 127 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/materials/export/csv"})
/*     */   public void exportToCSV(HttpServletResponse response) throws IOException {
/* 133 */     List<VatLieu> listVatLieu = this.service.getAllVatLieu();
/* 134 */     VatLieuCsvExporter exporter = new VatLieuCsvExporter();
/* 135 */     exporter.export(listVatLieu, response);
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/materials/export/excel"})
/*     */   public void exportToExcel(HttpServletResponse response) throws IOException {
/* 140 */     List<VatLieu> listVatLieu = this.service.getAllVatLieu();
/* 141 */     VatLieuExcelExporter exporter = new VatLieuExcelExporter();
/* 142 */     exporter.export(listVatLieu, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\VatLieu\VatLieuController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */