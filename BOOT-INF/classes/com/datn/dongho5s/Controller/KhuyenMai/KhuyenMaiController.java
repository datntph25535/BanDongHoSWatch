/*     */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KhuyenMai;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.KhuyenMai;
/*     */ import com.datn.dongho5s.Exception.KhuyenMaiNotFoundException;
/*     */ import com.datn.dongho5s.Service.KhuyenMaiService;
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
/*     */ @Controller
/*     */ public class KhuyenMaiController
/*     */ {
/*     */   @Autowired
/*     */   KhuyenMaiService service;
/*     */   @Autowired
/*     */   HttpServletRequest request;
/*     */   
/*     */   @GetMapping({"/admin/discounts"})
/*     */   public String listFirstPage(Model model) {
/*  30 */     HttpSession session = this.request.getSession();
/*  31 */     if (session.getAttribute("admin") == null) {
/*  32 */       return "redirect:/login-admin";
/*     */     }
/*  34 */     return listByPage(1, model, "tenKhuyenMai", "asc", null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/discounts/page/{pageNum}"})
/*     */   public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/*  41 */     HttpSession session = this.request.getSession();
/*  42 */     if (session.getAttribute("admin") == null) {
/*  43 */       return "redirect:/login-admin";
/*     */     }
/*  45 */     Page<KhuyenMai> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/*  46 */     List<KhuyenMai> listKhuyenMai = page.getContent();
/*  47 */     long startCount = ((pageNum - 1) * 4 + 1);
/*  48 */     long endCount = startCount + 4L - 1L;
/*  49 */     if (endCount > page.getTotalElements()) {
/*  50 */       endCount = page.getTotalElements();
/*     */     }
/*  52 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/*  53 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/*  54 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/*  55 */     model.addAttribute("startCount", Long.valueOf(startCount));
/*  56 */     model.addAttribute("endCount", Long.valueOf(endCount));
/*  57 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/*  58 */     model.addAttribute("listKhuyenMai", listKhuyenMai);
/*  59 */     model.addAttribute("sortField", sortField);
/*  60 */     model.addAttribute("sortDir", sortDir);
/*  61 */     model.addAttribute("reverseSortDir", reverseSortDir);
/*  62 */     model.addAttribute("keyword", keyword);
/*  63 */     return "admin/khuyenmai/discounts";
/*     */   }
/*     */   
/*     */   @GetMapping({"/admin/discounts/new"})
/*     */   public String newKhuyenMai(Model model) {
/*  68 */     HttpSession session = this.request.getSession();
/*  69 */     if (session.getAttribute("admin") == null) {
/*  70 */       return "redirect:/login-admin";
/*     */     }
/*  72 */     model.addAttribute("khuyenMai", new KhuyenMai());
/*  73 */     model.addAttribute("pageTitle", "Tạo Mới Khuyến Mãi");
/*  74 */     return "admin/khuyenmai/discounts_form";
/*     */   }
/*     */   
/*     */   @PostMapping({"/admin/discounts/save"})
/*     */   public String saveKhuyenMai(KhuyenMai khuyenMai, RedirectAttributes redirectAttributes) {
/*  79 */     HttpSession session = this.request.getSession();
/*  80 */     if (session.getAttribute("admin") == null) {
/*  81 */       return "redirect:/login-admin";
/*     */     }
/*  83 */     System.out.println(khuyenMai);
/*  84 */     System.out.println("controller");
/*  85 */     this.service.save(khuyenMai);
/*  86 */     redirectAttributes.addFlashAttribute("message", "Thay Đổi Thành Công");
/*  87 */     return "redirect:/admin/discounts";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/admin/discounts/edit/{id}"})
/*     */   public String editKhuyenMai(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
/*     */     try {
/*  96 */       HttpSession session = this.request.getSession();
/*  97 */       if (session.getAttribute("admin") == null) {
/*  98 */         return "redirect:/login-admin";
/*     */       }
/* 100 */       KhuyenMai khuyenMai = this.service.get(id);
/* 101 */       model.addAttribute("khuyenMai", khuyenMai);
/* 102 */       model.addAttribute("pageTitle", "Update Khuyến Mãi (ID : " + id + ")");
/* 103 */       return "admin/khuyenmai/discounts_form";
/* 104 */     } catch (KhuyenMaiNotFoundException ex) {
/* 105 */       redirectAttributes.addFlashAttribute("message", ex.getMessage());
/* 106 */       return "redirect:/admin/discounts";
/* 107 */     } catch (Exception ex) {
/* 108 */       redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
/* 109 */       return "redirect:/error";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KhuyenMai\KhuyenMaiController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */