/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.KhachHang;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KhachHang;
/*    */ import com.datn.dongho5s.Request.DiaChiRequest;
/*    */ import com.datn.dongho5s.Response.ThongTinCaNhanResponse;
/*    */ import com.datn.dongho5s.Response.ThongTinToCheckoutResponse;
/*    */ import com.datn.dongho5s.Service.DiaChiService;
/*    */ import com.datn.dongho5s.Service.impl.KhachHangServiceImpl;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PutMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @RestController
/*    */ @RequestMapping({"/khach-hang"})
/*    */ public class KhachHangRestController {
/*    */   @Autowired
/*    */   KhachHangServiceImpl khachHangServiceImpl;
/*    */   @Autowired
/*    */   DiaChiService diaChiService;
/*    */   
/*    */   @GetMapping({"/thong-tin-ca-nhan/{id}"})
/*    */   public ResponseEntity<ThongTinCaNhanResponse> getThongTinCaNhanById(@PathVariable("id") Integer id) {
/*    */     try {
/* 32 */       return ResponseEntity.status(HttpStatus.OK).body(this.khachHangServiceImpl.getThongTinCaNhanById(id));
/* 33 */     } catch (Exception e) {
/* 34 */       return new ResponseEntity(HttpStatus.NOT_FOUND);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @PutMapping({"/thong-tin-ca-nhan/update/{idKhachHang}"})
/*    */   public ResponseEntity<KhachHang> updateThongTinCaNhan(@PathVariable("idKhachHang") Integer idKhachHnag, @RequestBody ThongTinCaNhanResponse thongTinCaNhanResponse) {
/* 41 */     return ResponseEntity.ok(this.khachHangServiceImpl.updateThongTinCaNhan(idKhachHnag, thongTinCaNhanResponse));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/thong-tin/{id}"})
/*    */   public ResponseEntity<ThongTinToCheckoutResponse> getThongTin(@PathVariable("id") Integer id) {
/*    */     try {
/* 49 */       return ResponseEntity.status(HttpStatus.OK).body(this.khachHangServiceImpl.getThongTinToCheckout(id));
/* 50 */     } catch (Exception e) {
/* 51 */       return new ResponseEntity(HttpStatus.NOT_FOUND);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/getDiaChi"})
/*    */   public ResponseEntity<?> getDiaCHi(@RequestBody DiaChiRequest diaChiRequest) {
/*    */     try {
/* 60 */       return ResponseEntity.status(HttpStatus.OK).body(this.diaChiService.getDiaChiCuThe(diaChiRequest));
/* 61 */     } catch (Exception e) {
/* 62 */       return new ResponseEntity(HttpStatus.NOT_FOUND);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\KhachHang\KhachHangRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */