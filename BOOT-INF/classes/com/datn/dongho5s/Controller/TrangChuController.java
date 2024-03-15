/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ 
/*    */ @Controller
/*    */ public class TrangChuController
/*    */ {
/*    */   @GetMapping({"/index"})
/*    */   public String home() {
/* 11 */     return "userIndex";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\TrangChuController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */