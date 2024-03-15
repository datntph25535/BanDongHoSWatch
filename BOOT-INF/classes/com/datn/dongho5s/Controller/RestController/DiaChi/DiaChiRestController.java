/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.DiaChi;
/*    */ import com.datn.dongho5s.Entity.DiaChi;
/*    */ import com.datn.dongho5s.Request.DiaChiRequest;
/*    */ import com.datn.dongho5s.Response.DiaChiResponse;
/*    */ import com.datn.dongho5s.Service.DiaChiService;
/*    */ import com.datn.dongho5s.Service.impl.DiaChiServiceImpl;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PutMapping;
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @RestController
/*    */ @RequestMapping({"/api/dia-chi"})
/*    */ public class DiaChiRestController {
/*    */   public DiaChiRestController(DiaChiServiceImpl diaChiServiceImpl, DiaChiService diaChiService) {
/* 20 */     this.diaChiServiceImpl = diaChiServiceImpl; this.diaChiService = diaChiService;
/*    */   }
/*    */ 
/*    */   
/*    */   private final DiaChiServiceImpl diaChiServiceImpl;
/*    */   
/*    */   private final DiaChiService diaChiService;
/*    */   
/*    */   @GetMapping({"/find-all/{idKhachHang}"})
/*    */   public ResponseEntity<?> getAllDiaChi(@PathVariable("idKhachHang") Integer idKhachHang) throws Exception {
/* 30 */     List<DiaChiResponse> lstDiaChiResponse = this.diaChiServiceImpl.getDiaChiByKhachHang(idKhachHang);
/* 31 */     return ResponseEntity.status(HttpStatus.OK).body(lstDiaChiResponse);
/*    */   }
/*    */ 
/*    */   
/*    */   @PostMapping({"/them-dia-chi/{idKhachHang}"})
/*    */   public ResponseEntity<DiaChiResponse> createDiaChi(@PathVariable("idKhachHang") Integer idKhachHang, @RequestBody DiaChiRequest diaChiRequest) throws Exception {
/* 37 */     DiaChiResponse result = this.diaChiServiceImpl.createDiaChi(idKhachHang, diaChiRequest);
/* 38 */     return ResponseEntity.status(HttpStatus.CREATED).body(result);
/*    */   }
/*    */   
/*    */   @GetMapping({"/get-default-dia-chi/khach-hang={idKhachHang}"})
/*    */   public ResponseEntity<List<DiaChi>> getDefaultDiaChi(@PathVariable("idKhachHang") KhachHang khachHang) {
/* 43 */     List<DiaChi> result = this.diaChiService.getAllDiaChiByKhachHang(khachHang);
/* 44 */     return ResponseEntity.ok(result);
/*    */   }
/*    */ 
/*    */   
/*    */   @GetMapping({"/get-tinh-thanh"})
/*    */   public ResponseEntity<HashMap<Integer, String>> getThanhPho() {
/* 50 */     return ResponseEntity.ok(DiaChiCache.hashMapTinhThanh);
/*    */   }
/*    */   
/*    */   @GetMapping({"/get-quan-huyen/{idThanhPho}"})
/*    */   public ResponseEntity<HashMap<Integer, String>> getQuanHuyen(@PathVariable("idThanhPho") Integer id) {
/*    */     try {
/* 56 */       return ResponseEntity.ok(DiaChiAPI.callGetQuanHuyenAPI(id));
/* 57 */     } catch (Exception e) {
/* 58 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/get-phuong-xa/{idQuanHuyen}"})
/*    */   public ResponseEntity<HashMap<String, String>> getPhuongXa(@PathVariable("idQuanHuyen") Integer id) {
/*    */     try {
/* 65 */       return ResponseEntity.ok(DiaChiAPI.callGetPhuongXaAPI(id));
/* 66 */     } catch (Exception e) {
/* 67 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   @PutMapping({"/update/{idDiaChi}"})
/*    */   public ResponseEntity<?> updateDC(@PathVariable("idDiaChi") Integer idDiaChi, @RequestBody DiaChiRequest diaChiRequest) throws Exception {
/* 73 */     DiaChiResponse diaChiResponse = this.diaChiServiceImpl.updateDC(idDiaChi, diaChiRequest);
/* 74 */     return ResponseEntity.status(HttpStatus.OK).body(diaChiResponse);
/*    */   }
/*    */   @PutMapping({"/updateDefault/{idKhachHang}/{idDiaChi}"})
/*    */   public ResponseEntity<?> updateDC(@PathVariable("idKhachHang") Integer idKhachHang, @PathVariable("idDiaChi") Integer idDiaCh) throws Exception {
/* 78 */     DiaChiResponse diaChiResponse = this.diaChiServiceImpl.updateDCDefault(idKhachHang, idDiaCh);
/* 79 */     return ResponseEntity.status(HttpStatus.OK).body(diaChiResponse);
/*    */   }
/*    */   @DeleteMapping({"/delete/{idDiaChi}"})
/*    */   public void delete(@PathVariable("idDiaChi") Integer idDiaCh) throws Exception {
/* 83 */     this.diaChiServiceImpl.delete(idDiaCh);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\DiaChi\DiaChiRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */