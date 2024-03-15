/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*    */ import com.datn.dongho5s.Response.HoaDonChiTietResponse;
/*    */ 
/*    */ 
/*    */ public class HoaDonChiTietMapping
/*    */ {
/*    */   public String toString() {
/* 10 */     return "HoaDonChiTietMapping()"; } public int hashCode() { int result = 1; return 1; } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.HoaDonChiTietMapping; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.HoaDonChiTietMapping)) return false;  com.datn.dongho5s.mapper.HoaDonChiTietMapping other = (com.datn.dongho5s.mapper.HoaDonChiTietMapping)o; return !!other.canEqual(this); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static HoaDonChiTietResponse mapEntitytoResponse(HoaDonChiTiet hoaDonChiTiet) {
/* 21 */     HoaDonChiTietResponse hoaDonChiTietResponse = HoaDonChiTietResponse.builder().idHoaDonChiTiet(hoaDonChiTiet.getIdHoaDonChiTiet()).chiTietSanPham(hoaDonChiTiet.getChiTietSanPham()).donHang(hoaDonChiTiet.getDonHang()).giaBan(hoaDonChiTiet.getGiaBan()).soLuong(hoaDonChiTiet.getSoLuong()).build();
/* 22 */     return hoaDonChiTietResponse;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\HoaDonChiTietMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */