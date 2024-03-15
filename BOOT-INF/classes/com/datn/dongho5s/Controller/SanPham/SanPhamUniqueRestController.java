/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.SanPham;
/*    */ 
/*    */ import com.datn.dongho5s.Service.SanPhamService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class SanPhamUniqueRestController
/*    */ {
/*    */   @Autowired
/*    */   private SanPhamService service;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/products/check_name_and_code"})
/*    */   public String checkDuplicateTenAndMa(@Param("ten") String ten, @Param("ma") String ma) {
/* 21 */     return this.service.checkUniqueTenAndMa(ten, ma) ? "OK" : "Duplicated";
/*    */   }
/*    */   
/*    */   @PostMapping({"/admin/products/check_name_code_id"})
/*    */   public String checkDuplicateTenMaId(@Param("ten") String ten, @Param("ma") String ma, @Param("id") Integer id) {
/* 26 */     return this.service.checkUniqueTenMaId(ten, ma, id) ? "OK" : "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\SanPham\SanPhamUniqueRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */