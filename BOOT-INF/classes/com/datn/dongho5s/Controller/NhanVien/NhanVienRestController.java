/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.NhanVien;
/*    */ 
/*    */ import com.datn.dongho5s.Service.NhanVienService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ public class NhanVienRestController
/*    */ {
/*    */   @Autowired
/*    */   private NhanVienService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/users/check_email"})
/*    */   public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
/* 20 */     return this.service.isEmailUnique(id, email) ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\NhanVien\NhanVienRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */