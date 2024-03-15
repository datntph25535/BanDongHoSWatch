/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietGioHang;
/*    */ import com.datn.dongho5s.Request.ChiTietGioHangRequest;
/*    */ import com.datn.dongho5s.Response.ChiTietGioHangResponse;
/*    */ 
/*    */ public class ChiTietGioHangMapping {
/*  8 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.ChiTietGioHangMapping)) return false;  com.datn.dongho5s.mapper.ChiTietGioHangMapping other = (com.datn.dongho5s.mapper.ChiTietGioHangMapping)o; return !!other.canEqual(this); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.ChiTietGioHangMapping; } public int hashCode() { int result = 1; return 1; } public String toString() { return "ChiTietGioHangMapping()"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ChiTietGioHangResponse mapEntitytoResponse(ChiTietGioHang chiTietGioHang) {
/* 19 */     ChiTietGioHangResponse chiTietGioHangResponse = ChiTietGioHangResponse.builder().idChiTietGioHang(chiTietGioHang.getIdChiTietGioHang()).chiTietSanPham(chiTietGioHang.getChiTietSanPham()).gioHang(chiTietGioHang.getGioHang()).ghiChu(chiTietGioHang.getGhiChu()).giaBan(chiTietGioHang.getGiaBan()).ngayTao(chiTietGioHang.getNgayTao()).soLuongSanPham(chiTietGioHang.getSoLuongSanPham()).build();
/* 20 */     return chiTietGioHangResponse;
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
/*    */   public static ChiTietGioHang mapRequesttoEntity(ChiTietGioHangRequest chiTietGioHangRequest) {
/* 32 */     ChiTietGioHang chiTietGioHang = ChiTietGioHang.builder().idChiTietGioHang(chiTietGioHangRequest.getIdChiTietGioHang()).chiTietSanPham(chiTietGioHangRequest.getChiTietSanPham()).gioHang(chiTietGioHangRequest.getGioHang()).ghiChu(chiTietGioHangRequest.getGhiChu()).giaBan(chiTietGioHangRequest.getGiaBan()).ngayTao(chiTietGioHangRequest.getNgayTao()).soLuongSanPham(chiTietGioHangRequest.getSoLuongSanPham()).build();
/* 33 */     return chiTietGioHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\ChiTietGioHangMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */