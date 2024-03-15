/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.ChiTietSanPham;
/*    */ 
/*    */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class ChiTietSanPhamUniqueRestController
/*    */ {
/*    */   @Autowired
/*    */   private ChiTietSanPhamService chiTietSanPhamService;
/*    */   @Autowired
/*    */   HttpServletRequest request;
/*    */   
/*    */   @PostMapping({"/admin/productDetails/check_details_unique"})
/*    */   public String checkUniqueDetails(@RequestParam String maChiTietSanPham, @RequestParam String tenSanPham, @RequestParam String tenDayDeo, @RequestParam String tenMauSac, @RequestParam String tenKichCo, @RequestParam String tenVatLieu) {
/* 28 */     boolean isUnique = this.chiTietSanPhamService.isUniqueChiTietSanPham(maChiTietSanPham, tenSanPham, tenDayDeo, tenMauSac, tenKichCo, tenVatLieu);
/*    */ 
/*    */     
/* 31 */     if (isUnique) {
/* 32 */       return "OK";
/*    */     }
/* 34 */     return "Duplicated";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"/admin/productDetails/check_details_unique_update"})
/*    */   public String checkUniqueDetailsUpdate(@RequestParam Integer idChiTietSanPham, @RequestParam String maChiTietSanPham, @RequestParam String tenSanPham, @RequestParam String tenDayDeo, @RequestParam String tenMauSac, @RequestParam String tenKichCo, @RequestParam String tenVatLieu) {
/* 49 */     boolean isUnique = this.chiTietSanPhamService.isUniqueChiTietSanPhamUpdate(idChiTietSanPham, maChiTietSanPham, tenSanPham, tenDayDeo, tenMauSac, tenKichCo, tenVatLieu);
/*    */ 
/*    */     
/* 52 */     if (isUnique) {
/* 53 */       return "OK";
/*    */     }
/* 55 */     return "Duplicated";
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\ChiTietSanPham\ChiTietSanPhamUniqueRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */