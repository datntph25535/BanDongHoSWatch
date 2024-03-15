/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KhachHang;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KhachHang;
/*    */ import com.datn.dongho5s.Service.KhachHangService;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.domain.Page;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class KhachHangController
/*    */ {
/*    */   @Autowired
/*    */   private KhachHangService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @GetMapping({"/admin/customers"})
/*    */   public String listFirstPage(Model model) {
/* 30 */     HttpSession session = this.request.getSession();
/* 31 */     if (session.getAttribute("admin") == null) {
/* 32 */       return "redirect:/login-admin";
/*    */     }
/* 34 */     return listByPage(1, model, "tenKhachHang", "asc", null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/admin/customers/page/{pageNum}"})
/*    */   private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
/* 41 */     HttpSession session = this.request.getSession();
/* 42 */     if (session.getAttribute("admin") == null) {
/* 43 */       return "redirect:/login-admin";
/*    */     }
/* 45 */     Page<KhachHang> page = this.service.listByPage(pageNum, sortField, sortDir, keyword);
/* 46 */     List<KhachHang> listKhachHang = page.getContent();
/* 47 */     long startCount = ((pageNum - 1) * 4 + 1);
/* 48 */     long endCount = startCount + 4L - 1L;
/* 49 */     if (endCount > page.getTotalElements()) {
/* 50 */       endCount = page.getTotalElements();
/*    */     }
/* 52 */     String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
/* 53 */     model.addAttribute("currentPage", Integer.valueOf(pageNum));
/* 54 */     model.addAttribute("totalPages", Integer.valueOf(page.getTotalPages()));
/* 55 */     model.addAttribute("startCount", Long.valueOf(startCount));
/* 56 */     model.addAttribute("endCount", Long.valueOf(endCount));
/* 57 */     model.addAttribute("totalItem", Long.valueOf(page.getTotalElements()));
/* 58 */     model.addAttribute("listKhachHang", listKhachHang);
/* 59 */     model.addAttribute("sortField", sortField);
/* 60 */     model.addAttribute("sortDir", sortDir);
/* 61 */     model.addAttribute("reverseSortDir", reverseSortDir);
/* 62 */     model.addAttribute("keyword", keyword);
/* 63 */     return "admin/khachhang/customers";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KhachHang\KhachHangController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */