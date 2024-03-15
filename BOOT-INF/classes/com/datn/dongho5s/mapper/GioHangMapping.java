/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.GioHang;
/*    */ import com.datn.dongho5s.Request.GioHangRequest;
/*    */ import com.datn.dongho5s.Response.GiohangResponse;
/*    */ 
/*    */ 
/*    */ public class GioHangMapping
/*    */ {
/*    */   public boolean equals(Object o) {
/* 11 */     if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.GioHangMapping)) return false;  com.datn.dongho5s.mapper.GioHangMapping other = (com.datn.dongho5s.mapper.GioHangMapping)o; return !!other.canEqual(this); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.GioHangMapping; } public int hashCode() { int result = 1; return 1; } public String toString() { return "GioHangMapping()"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GiohangResponse mapEntitytoResponse(GioHang gioHang) {
/* 22 */     GiohangResponse gioHangResponse = GiohangResponse.builder().idGioHang(gioHang.getIdGioHang()).khachHang(gioHang.getKhachHang()).ngayTaoGioHang(gioHang.getNgayTaoGioHang()).trangThaiGioHang(gioHang.getTrangThaiGioHang()).thoiGianCapNhapGioHang(gioHang.getThoiGianCapNhapGioHang()).ghiChu(gioHang.getGhiChu()).build();
/* 23 */     return gioHangResponse;
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
/*    */   public static GioHang mapRequestToEntity(GioHangRequest gioHangRequest) {
/* 35 */     GioHang gioHang = GioHang.builder().idGioHang(gioHangRequest.getIdGioHang()).khachHang(gioHangRequest.getKhachHang()).ngayTaoGioHang(gioHangRequest.getNgayTaoGioHang()).trangThaiGioHang(gioHangRequest.getTrangThaiGioHang()).thoiGianCapNhapGioHang(gioHangRequest.getThoiGianCapNhapGioHang()).ghiChu(gioHangRequest.getGhiChu()).build();
/* 36 */     return gioHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\GioHangMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */