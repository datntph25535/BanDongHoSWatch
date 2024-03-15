/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.PhanHoi;
/*    */ import com.datn.dongho5s.Response.PhanHoiResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PhanHoiMapping
/*    */ {
/*    */   public String toString() {
/* 12 */     return "PhanHoiMapping()"; } public int hashCode() { int result = 1; return 1; } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.PhanHoiMapping; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.PhanHoiMapping)) return false;  com.datn.dongho5s.mapper.PhanHoiMapping other = (com.datn.dongho5s.mapper.PhanHoiMapping)o; return !!other.canEqual(this); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static PhanHoiResponse mapEntitytoResponse(PhanHoi phanHoi) {
/* 28 */     PhanHoiResponse phanHoiResponse = PhanHoiResponse.builder().idPhanHoi(phanHoi.getIdPhanHoi()).chiTietSanPham(phanHoi.getChiTietSanPham()).danhGia(phanHoi.getDanhGia()).ghiChu(phanHoi.getGhiChu()).noiDungPhanHoi(phanHoi.getNoiDungPhanHoi()).khachHang(phanHoi.getKhachHang()).ngaySua(phanHoi.getNgaySua()).thoiGianPhanHoi(phanHoi.getThoiGianPhanHoi()).trangThaiPhanHoi(phanHoi.getTrangThaiPhanHoi()).ngayTao(phanHoi.getNgayTao()).build();
/* 29 */     return phanHoiResponse;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\PhanHoiMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */