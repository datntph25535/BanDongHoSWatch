/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.DayDeo;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DayDeo;
/*     */ import com.datn.dongho5s.Exception.DayDeoNotFoundException;
/*     */ import com.datn.dongho5s.Service.DayDeoService;
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
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class DayDeoController
/*     */ {
/*     */   @Autowired
/*     */   private DayDeoService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/straps"})
/*     */   public String listFirstPage(Model model) {
/*  31 */     HttpSession session = this.request.getSession();
/*  32 */     if (session.getAttribute("admin") == null) {
/*  33 */       return "redirect:/login-admin";
/*     */     }
/*  35 */     return listByPage(1, model, "tenDayDeo", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/straps/page/{pageNum}"})
/*     */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  42 */     HttpSession session = this.request.getSession();
/*  43 */     if (session.getAttribute("admin") == null) {
/*  44 */       return "redirect:/login-admin";
/*     */     }
/*  46 */     Page<DayDeo> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  47 */     List<DayDeo> listDayDeo = page.getContent();
/*  48 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  49 */     long endCount = startCount + 4L - 1L;
/*  50 */     if (endCount > page.getTotalElements()) {
/*  51 */       endCount = page.getTotalElements();
/*     */     }
/*  53 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  54 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  55 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  56 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  57 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  58 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  59 */     model.addAttribute("listDayDeo", listDayDeo);
/*  60 */     model.addAttribute("sortField", sortField);
/*  61 */     model.addAttribute("sortDir", sortDir);
/*  62 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  63 */     model.addAttribute("keyword", keyword);
/*  64 */     return "admin/daydeo/straps";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/straps/{id}/enabled/{status}"})
/*     */   public String updateDayDeoEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
/*  71 */     HttpSession session = this.request.getSession();
/*  72 */     if (session.getAttribute("admin") == null) {
/*  73 */       return "redirect:/login-admin";
/*     */     }
/*  75 */     this.service.updateDayDeoEnabledStatus(id, enabled);
/*  76 */     String status = enabled ? "online" : "offline";
/*  77 */     String message = " Dây Đeo có id " + id + " Thay đổi trạng thái thành " + status;
/*  78 */     redirectAttributes.addFlashAttribute("message", message);
/*  79 */     return "redirect:/admin/straps";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/straps/new"})
/*     */   public String newDayDeo(Model model) {
/*  84 */     HttpSession session = this.request.getSession();
/*  85 */     if (session.getAttribute("admin") == null) {
/*  86 */       return "redirect:/login-admin";
/*     */     }
/*  88 */     model.addAttribute("dayDeo", new DayDeo());
/*  89 */     model.addAttribute("pageTitle", "Tạo Mới Dây Đeo");
/*  90 */     return "admin/daydeo/straps_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/straps/save"})
/*     */   public String saveDayDeo(DayDeo dayDeo, RedirectAttributes redirectAttributes) {
/*  95 */     HttpSession session = this.request.getSession();
/*  96 */     if (session.getAttribute("admin") == null) {
/*  97 */       return "redirect:/login-admin";
/*     */     }
/*  99 */     this.service.save(dayDeo);
/* 100 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/* 101 */     return "redirect:/admin/straps";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/straps/edit/{id}"})
/*     */   public String editDayDeo(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/* 110 */       HttpSession session = this.request.getSession();
/* 111 */       if (session.getAttribute("admin") == null) {
/* 112 */         return "redirect:/login-admin";
/*     */       }
/* 114 */       DayDeo dayDeo = this.service.get(id);
/* 115 */       model.addAttribute("dayDeo", dayDeo);
/* 116 */       model.addAttribute("pageTitle", "Update Dây Đeo (ID :" + id + ")");
/* 117 */       return "admin/dayDeo/straps_form";
/* 118 */     } catch (DayDeoNotFoundException ex) {
/* 119 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 120 */       return "redirect:/admin/straps";
/* 121 */     } catch (Exception ex) {
/* 122 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 123 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\DayDeo\DayDeoController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */