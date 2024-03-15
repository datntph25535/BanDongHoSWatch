/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.GioHang;
/*    */ import com.datn.dongho5s.Repository.GioHangRepository;
/*    */ import com.datn.dongho5s.Request.GioHangRequest;
/*    */ import com.datn.dongho5s.Response.GiohangResponse;
/*    */ import com.datn.dongho5s.Service.GioHangService;
/*    */ import com.datn.dongho5s.mapper.GioHangMapping;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class GioHangServiceImpl
/*    */   implements GioHangService
/*    */ {
/*    */   @Autowired
/*    */   GioHangRepository gioHangRepository;
/*    */   
/*    */   public GiohangResponse addGioHang(GioHangRequest gioHangRequest) {
/* 24 */     GioHang gioHang = GioHangMapping.mapRequestToEntity(gioHangRequest);
/* 25 */     GiohangResponse gioHangResponse = GioHangMapping.mapEntitytoResponse((GioHang)this.gioHangRepository.save(gioHang));
/* 26 */     return gioHangResponse;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public GiohangResponse findGioHang(Integer idKhachHang) {
/* 32 */     GioHang gioHang = this.gioHangRepository.findGioHang(Integer.valueOf(1));
/* 33 */     GiohangResponse gioHangResponse = GioHangMapping.mapEntitytoResponse(gioHang);
/* 34 */     return gioHangResponse;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\GioHangServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */