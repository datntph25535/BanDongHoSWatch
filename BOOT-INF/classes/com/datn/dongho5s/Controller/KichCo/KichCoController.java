/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KichCo;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.KichCo;
/*     */ import com.datn.dongho5s.Exception.KichCoNotFoundException;
/*     */ import com.datn.dongho5s.Export.KichCoCsvExporter;
/*     */ import com.datn.dongho5s.Export.KichCoExcelExporter;
/*     */ import com.datn.dongho5s.Service.KichCoService;
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
/*     */ public class KichCoController
/*     */ {
/*     */   @Autowired
/*     */   private KichCoService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/sizes"})
/*     */   public String listFirstPage(Model model) {
/*  33 */     HttpSession session = this.request.getSession();
/*  34 */     if (session.getAttribute("admin") == null) {
/*  35 */       return "redirect:/login-admin";
/*     */     }
/*  37 */     return listByPage(1, model, "tenKichCo", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/sizes/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  44 */     HttpSession session = this.request.getSession();
/*  45 */     if (session.getAttribute("admin") == null) {
/*  46 */       return "redirect:/login-admin";
/*     */     }
/*     */     
/*  49 */     Page<KichCo> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  50 */     List<KichCo> listKichCo = page.getContent();
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
/*  62 */     model.addAttribute("listKichCo", listKichCo);
/*  63 */     model.addAttribute("sortField", sortField);
/*  64 */     model.addAttribute("sortDir", sortDir);
/*  65 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  66 */     model.addAttribute("keyword", keyword);
/*  67 */     return "admin/kichco/sizes";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/sizes/{id}/enabled/{status}"})
/*     */   public String updateKichCoEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  75 */     HttpSession session = this.request.getSession();
/*  76 */     if (session.getAttribute("admin") == null) {
/*  77 */       return "redirect:/login-admin";
/*     */     }
/*  79 */     this.service.updateKichCoEnabledStatus(id, enabled);
/*  80 */     String status = enabled ? "online" : "offline";
/*  81 */     String message = "Kích Cỡ có id " + id + " thay đổi trạng thái thành " + status;
/*  82 */     redirectAttributes.addFlashAttribute("message", message);
/*  83 */     return "redirect:/sizes";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/sizes/new"})
/*     */   public String newKichCo(Model model) {
/*  88 */     HttpSession session = this.request.getSession();
/*  89 */     if (session.getAttribute("admin") == null) {
/*  90 */       return "redirect:/login-admin";
/*     */     }
/*  92 */     model.addAttribute("KichCo", new KichCo());
/*  93 */     model.addAttribute("pageTitle", "Tạo Mới Kích Cỡ");
/*  94 */     return "admin/kichco/size_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/sizes/save"})
/*     */   public String saveKichCo(KichCo kichCo, RedirectAttributes redirectAttributes) {
/*  99 */     HttpSession session = this.request.getSession();
/* 100 */     if (session.getAttribute("admin") == null) {
/* 101 */       return "redirect:/login-admin";
/*     */     }
/* 103 */     this.service.save(kichCo);
/* 104 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 105 */     return "redirect:/admin/sizes";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/sizes/edit/{id}"})
/*     */   public String editKichCo(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 113 */       HttpSession session = this.request.getSession();
/* 114 */       if (session.getAttribute("admin") == null) {
/* 115 */         return "redirect:/login-admin";
/*     */       }
/* 117 */       KichCo KichCo = this.service.get(id);
/* 118 */       model.addAttribute("KichCo", KichCo);
/* 119 */       model.addAttribute("pageTitle", "Update Kích Cỡ (ID: " + id + ")");
/* 120 */       return "admin/kichco/size_form";
/* 121 */     } catch (KichCoNotFoundException ex) {
/* 122 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 123 */       return "redirect:/admin/sizes";
/* 124 */     } catch (Exception ex) {
/* 125 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 126 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/sizes/export/csv"})
/*     */   public void exportToCSV(HttpServletResponse response) throws IOException {
/* 132 */     List<KichCo> listKichCo = this.service.getAllKichCo();
/* 133 */     KichCoCsvExporter exporter = new KichCoCsvExporter();
/* 134 */     exporter.export(listKichCo, response);
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/sizes/export/excel"})
/*     */   public void exportToExcel(HttpServletResponse response) throws IOException {
/* 139 */     List<KichCo> listKichCo = this.service.getAllKichCo();
/* 140 */     KichCoExcelExporter exporter = new KichCoExcelExporter();
/* 141 */     exporter.export(listKichCo, response);
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KichCo\KichCoController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */