/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.GioHang;
/*    */ 
/*    */ import com.datn.dongho5s.Request.CartRequest;
/*    */ import com.datn.dongho5s.Response.ChiTietGioHangResponse;
/*    */ import com.datn.dongho5s.Service.ChiTietGioHangService;
/*    */ import java.util.List;
/*    */ import javax.websocket.server.PathParam;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.DeleteMapping;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.PutMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @RestController
/*    */ @RequestMapping({"/api/giohang"})
/*    */ public class GioHangRestController
/*    */ {
/*    */   @Autowired
/*    */   ChiTietGioHangService chiTietGioHangService;
/*    */   
/*    */   @GetMapping({"/{idKhachHang}"})
/*    */   public ResponseEntity<?> getchiTiet(@PathVariable("idKhachHang") Integer idKhachHang) {
/* 34 */     System.out.println("" + idKhachHang + "id");
/* 35 */     List<ChiTietGioHangResponse> chiTietGioHangList = this.chiTietGioHangService.getChiTietGioHang(idKhachHang);
/* 36 */     return ResponseEntity.status(HttpStatus.OK).body(chiTietGioHangList);
/*    */   }
/*    */   
/*    */   @PutMapping({"/update/{id}"})
/*    */   public ResponseEntity<?> updateGioHang(@PathVariable("id") Integer idGioHangChiTiet, @PathParam("soLuong") Integer soLuong) throws Exception {
/* 41 */     return ResponseEntity.status(HttpStatus.OK).body(this.chiTietGioHangService.update(soLuong, idGioHangChiTiet));
/*    */   }
/*    */   
/*    */   @DeleteMapping({"/delete/{id}"})
/*    */   public void deleteGioHang(@PathVariable("id") Integer idGioHangChiTiet) {
/* 46 */     this.chiTietGioHangService.delete(idGioHangChiTiet);
/*    */   }
/*    */   
/*    */   @DeleteMapping({"/deleteAll"})
/*    */   public void deleteAllGioHang() {
/* 51 */     this.chiTietGioHangService.deleteAll();
/*    */   }
/*    */   
/*    */   @PostMapping({"/addToCart"})
/*    */   public ResponseEntity<?> addGioHang(@RequestBody CartRequest cartRequest) {
/* 56 */     return ResponseEntity.status(HttpStatus.OK).body(this.chiTietGioHangService.addToCart(cartRequest));
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\GioHang\GioHangRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */