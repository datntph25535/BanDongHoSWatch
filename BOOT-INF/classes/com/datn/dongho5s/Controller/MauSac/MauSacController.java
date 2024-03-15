/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.MauSac;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.MauSac;
/*     */ import com.datn.dongho5s.Exception.MauSacNotFoundException;
/*     */ import com.datn.dongho5s.Service.MauSacService;
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
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/admin/colors"})
/*     */ public class MauSacController
/*     */ {
/*     */   @Autowired
/*     */   MauSacService mauSacService;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping
/*     */   public String listFirstPage(Model model) {
/*  33 */     HttpSession session = this.request.getSession();
/*  34 */     if (session.getAttribute("admin") == null) {
/*  35 */       return "redirect:/login-admin";
/*     */     }
/*  37 */     return listByPage(1, model, "tenMauSac", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/page/{pageNum}"})
/*     */   public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  45 */     HttpSession session = this.request.getSession();
/*  46 */     if (session.getAttribute("admin") == null) {
/*  47 */       return "redirect:/login-admin";
/*     */     }
/*  49 */     Page<MauSac> page = this.mauSacService.listByPage(pageNum, sortField, sortDir, keyword);
/*  50 */     List<MauSac> listMauSac = page.getContent();
/*     */     
/*  52 */     long startCount = ((pageNum - 1) * 10 + 1);
/*  53 */     long endCount = startCount + 10L - 1L;
/*     */     
/*  55 */     if (endCount > page.getTotalElements()) {
/*  56 */       endCount = page.getTotalElements();
/*     */     }
/*     */     
/*  59 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*     */     
/*  61 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  62 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  63 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  64 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  65 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  66 */     model.addAttribute("listMauSac", listMauSac);
/*  67 */     model.addAttribute("sortField", "tenMauSac");
/*  68 */     model.addAttribute("sortDir", sortDir);
/*  69 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  70 */     model.addAttribute("keyword", keyword);
/*  71 */     return "admin/mausac/colors";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/{id}/enabled/{status}"})
/*     */   public String updateMauSacEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  78 */     HttpSession session = this.request.getSession();
/*  79 */     if (session.getAttribute("admin") == null) {
/*  80 */       return "redirect:/login-admin";
/*     */     }
/*  82 */     this.mauSacService.updateMauSacEnabledStatus(id, enabled);
/*  83 */     String status = enabled ? "online" : "offline";
/*  84 */     String message = "Màu sắc có id " + id + " thay đổi trạng thái thành " + status;
/*  85 */     redirectAttributes.addFlashAttribute("message", message);
/*  86 */     return "redirect:/colors";
/*     */   }
/*     */   
/*     */   @GetMapping({"/new"})
/*     */   public String newDanhMuc(Model model) {
/*  91 */     HttpSession session = this.request.getSession();
/*  92 */     if (session.getAttribute("admin") == null) {
/*  93 */       return "redirect:/login-admin";
/*     */     }
/*  95 */     model.addAttribute("mauSac", new MauSac());
/*  96 */     model.addAttribute("pageTitle", "Tạo mới");
/*  97 */     return "admin/mausac/colors_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/save"})
/*     */   public String saveDanhMuc(MauSac mauSac, RedirectAttributes redirectAttributes) {
/* 102 */     HttpSession session = this.request.getSession();
/* 103 */     if (session.getAttribute("admin") == null) {
/* 104 */       return "redirect:/login-admin";
/*     */     }
/* 106 */     this.mauSacService.save(mauSac);
/* 107 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 108 */     return "redirect:/admin/colors";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/edit/{id}"})
/*     */   public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 117 */       HttpSession session = this.request.getSession();
/* 118 */       if (session.getAttribute("admin") == null) {
/* 119 */         return "redirect:/login-admin";
/*     */       }
/* 121 */       MauSac mauSac = this.mauSacService.get(id);
/* 122 */       model.addAttribute("mauSac", mauSac);
/* 123 */       model.addAttribute("pageTitle", "Cập nhật");
/* 124 */       return "admin/mausac/colors_form";
/* 125 */     } catch (MauSacNotFoundException ex) {
/* 126 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 127 */       return "redirect:/admin/colors";
/* 128 */     } catch (Exception ex) {
/* 129 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 130 */       return "redirect:/admin/error";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\MauSac\MauSacController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */