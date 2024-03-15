/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.KhuyenMai;
/*    */ 
/*    */ import com.datn.dongho5s.Service.KhuyenMaiService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class KhuyenMaiRestController
/*    */ {
/*    */   @Autowired
/*    */   KhuyenMaiService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/discounts/check_name"})
/*    */   public String checkDuplicateTenAndMa(@Param("id") Integer id, @Param("ten") String ten, @Param("ma") String ma) {
/* 23 */     boolean isUnique = this.service.checkUnique(id, ten, ma);
/* 24 */     return isUnique ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\KhuyenMai\KhuyenMaiRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */