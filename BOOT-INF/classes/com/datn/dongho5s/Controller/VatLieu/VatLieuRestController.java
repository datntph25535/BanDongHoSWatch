/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.VatLieu;
/*    */ 
/*    */ import com.datn.dongho5s.Service.VatLieuService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ public class VatLieuRestController
/*    */ {
/*    */   @Autowired
/*    */   private VatLieuService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/materials/check_name"})
/*    */   public String checkDuplicateTen(@Param("id") Integer id, @Param("ten") String ten) {
/* 20 */     return this.service.checkUnique(id, ten) ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\VatLieu\VatLieuRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */