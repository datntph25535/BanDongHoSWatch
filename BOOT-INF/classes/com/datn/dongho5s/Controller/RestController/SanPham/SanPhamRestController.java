/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.RestController.SanPham;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ import com.datn.dongho5s.Request.TimKiemRequest;
/*    */ import com.datn.dongho5s.Response.SanPhamDetailResponse;
/*    */ import com.datn.dongho5s.Response.TimKiemResponse;
/*    */ import com.datn.dongho5s.Response.TimKiemSettingResponse;
/*    */ import com.datn.dongho5s.Service.ChiTietSanPhamService;
/*    */ import com.datn.dongho5s.Service.SanPhamService;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin({"*"})
/*    */ @RestController
/*    */ @RequestMapping({"/san-pham"})
/*    */ public class SanPhamRestController
/*    */ {
/*    */   @Autowired
/*    */   SanPhamService sanPhamService;
/*    */   @Autowired
/*    */   ChiTietSanPhamService chiTietSanPhamService;
/*    */   
/*    */   @PostMapping({"/tim-kiem"})
/*    */   public ResponseEntity<?> TimKiemSanPham(@RequestBody TimKiemRequest timKiemRequest) {
/* 40 */     System.out.println(timKiemRequest.toString());
/* 41 */     Set<TimKiemResponse> result = this.sanPhamService.getSanPhamByCondition(timKiemRequest);
/* 42 */     return ResponseEntity.status(HttpStatus.OK).body(result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/get-setting"})
/*    */   public ResponseEntity<?> GetSettingTimKiem() {
/* 50 */     TimKiemSettingResponse result = this.chiTietSanPhamService.getTimKiemSetting();
/* 51 */     return ResponseEntity.status(HttpStatus.OK).body(result);
/*    */   }
/*    */   
/*    */   @GetMapping({"/san-pham-detail/id-san-pham={idSP}"})
/*    */   public ResponseEntity<?> GetSanPhamById(@PathVariable("idSP") Integer idSP) {
/* 56 */     SanPhamDetailResponse result = this.sanPhamService.getDetailSanPhamById(idSP);
/* 57 */     return ResponseEntity.status(HttpStatus.OK).body(result);
/*    */   }
/*    */   
/*    */   @GetMapping({"/cung-thuong-hieu={idTH}"})
/*    */   public ResponseEntity<?> GetSanPhamCungTH(@PathVariable("idTH") SanPham sanPham) {
/* 62 */     List<SanPham> result = this.sanPhamService.getSPCungTH(sanPham.getThuongHieu());
/* 63 */     return ResponseEntity.status(HttpStatus.OK).body(result);
/*    */   }
/*    */   
/*    */   void validDataTimKiem(TimKiemRequest req) {
/* 67 */     if (req.getDayDeoId().size() == 0)
/* 68 */       req.setDayDeoId(null); 
/* 69 */     if (req.getDanhMucId().size() == 0)
/* 70 */       req.setDanhMucId(null); 
/* 71 */     if (req.getMauSacId().size() == 0)
/* 72 */       req.setMauSacId(null); 
/* 73 */     if (req.getThuongHieuId().size() == 0)
/* 74 */       req.setThuongHieuId(null); 
/* 75 */     if (req.getVatLieuId().size() == 0)
/* 76 */       req.setVatLieuId(null); 
/* 77 */     if (req.getSizeId().size() == 0)
/* 78 */       req.setSizeId(null); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\RestController\SanPham\SanPhamRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */