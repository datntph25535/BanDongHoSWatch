/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KichCo;
/*    */ 
/*    */ import com.datn.dongho5s.Service.KichCoService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ public class KichCoRestController
/*    */ {
/*    */   @Autowired
/*    */   private KichCoService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/sizes/check_name"})
/*    */   public String checkDuplicateTen(@Param("id") Integer id, @Param("ten") String ten) {
/* 20 */     return this.service.checkUnique(id, ten) ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KichCo\KichCoRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */