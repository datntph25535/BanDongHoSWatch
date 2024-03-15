/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController;
/*    */ 
/*    */ import com.datn.dongho5s.Response.ChiTietSanPhamResponse;
/*    */ import com.datn.dongho5s.Response.SanPhamDetailResponse;
/*    */ import com.datn.dongho5s.Response.TrangChuResponse;
/*    */ import com.datn.dongho5s.Service.SanPhamService;
/*    */ import java.util.List;
/*    */ import javax.websocket.server.PathParam;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @Controller
/*    */ @RequestMapping({"/api/index"})
/*    */ public class TrangChuRestController
/*    */ {
/*    */   @Autowired
/*    */   SanPhamService sanPhamService;
/*    */   
/*    */   @ResponseBody
/*    */   @GetMapping({""})
/*    */   public ResponseEntity<?> home() {
/* 31 */     List<SanPhamDetailResponse> listSPbanChay = this.sanPhamService.getSPchay();
/* 32 */     List<SanPhamDetailResponse> listSPmoiNhat = this.sanPhamService.getSPnew();
/* 33 */     List<SanPhamDetailResponse> listSPnoiBat = this.sanPhamService.getSPFeature();
/* 34 */     TrangChuResponse trangChuResponse = new TrangChuResponse(listSPbanChay, listSPmoiNhat, listSPnoiBat);
/*    */     
/* 36 */     return ResponseEntity.status(HttpStatus.OK).body(trangChuResponse);
/*    */   }
/*    */   
/*    */   @ResponseBody
/*    */   @GetMapping({"/getSPKM"})
/*    */   public ResponseEntity<?> getSPKM(@PathParam("idCTSP") Integer idCTSP) {
/* 42 */     List<ChiTietSanPhamResponse> chiTietSanPhamResponseList = this.sanPhamService.getSPchayKM(idCTSP);
/* 43 */     return ResponseEntity.status(HttpStatus.OK).body(chiTietSanPhamResponseList);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\TrangChuRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */