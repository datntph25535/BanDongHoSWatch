/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.PhanHoi;
/*    */ 
/*    */ import com.datn.dongho5s.Request.PhanHoiRequest;
/*    */ import com.datn.dongho5s.Response.PhanHoiResponse;
/*    */ import com.datn.dongho5s.Service.PhanHoiService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.data.repository.query.Param;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @RestController
/*    */ public class PhanHoiRestController
/*    */ {
/*    */   @Autowired
/*    */   PhanHoiService phanHoiService;
/*    */   
/*    */   @GetMapping({"/phan-hoi/get/{idSanPham}"})
/*    */   public ResponseEntity<?> findAll(@PathVariable("idSanPham") Integer idSanPham) {
/* 32 */     List<PhanHoiResponse> phanHoiResponses = this.phanHoiService.findAll(idSanPham);
/* 33 */     return ResponseEntity.status(HttpStatus.OK).body(phanHoiResponses);
/*    */   }
/*    */   
/*    */   @GetMapping({"/phan-hoi/checkPhanHoi"})
/*    */   public ResponseEntity<?> checkPhanHoi(@Param("idKhachHang") Integer idKhachHang, @Param("idSanPham") Integer idSanPham) {
/* 38 */     boolean checkPhanHoi = this.phanHoiService.checkPhanHoi(idKhachHang, idSanPham);
/* 39 */     return ResponseEntity.status(HttpStatus.OK).body(Boolean.valueOf(checkPhanHoi));
/*    */   }
/*    */   
/*    */   @PostMapping({"/api/phan-hoi/add"})
/*    */   public ResponseEntity<?> add(@RequestBody PhanHoiRequest phanHoiRequest) {
/* 44 */     PhanHoiResponse phanHoiResponse = this.phanHoiService.addPhanHoi(phanHoiRequest);
/* 45 */     return ResponseEntity.status(HttpStatus.OK).body(phanHoiResponse);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\PhanHoi\PhanHoiRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */