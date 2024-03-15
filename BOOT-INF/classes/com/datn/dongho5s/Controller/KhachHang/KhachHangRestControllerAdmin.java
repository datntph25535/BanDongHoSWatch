/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KhachHang;
/*    */ 
/*    */ import com.datn.dongho5s.Service.KhachHangService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ public class KhachHangRestControllerAdmin
/*    */ {
/*    */   @Autowired
/*    */   private KhachHangService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/customers/check_name"})
/*    */   public String checkDuplicateTen(@Param("idKhachHang") Integer id, @Param("email") String email, @Param("soDienThoai") String soDT) {
/* 20 */     return this.service.checkUnique(id, email, soDT) ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KhachHang\KhachHangRestControllerAdmin.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */