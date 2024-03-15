/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ import com.datn.dongho5s.Response.SanPhamDetailResponse;
/*    */ 
/*    */ public class SanPhamMapping {
/*  7 */   public String toString() { return "SanPhamMapping()"; } public int hashCode() { int result = 1; return 1; } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.SanPhamMapping; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.SanPhamMapping)) return false;  com.datn.dongho5s.mapper.SanPhamMapping other = (com.datn.dongho5s.mapper.SanPhamMapping)o; return !!other.canEqual(this); }
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
/*    */   public static SanPhamDetailResponse mapEntitytoResponse(SanPham sp) {
/* 20 */     SanPhamDetailResponse sanPhamDetailResponse = SanPhamDetailResponse.builder().idSanPham(sp.getIdSanPham()).listAnhSanPham(sp.getListAnhSanPham()).moTaSanPham(sp.getMoTaSanPham()).danhMuc(sp.getDanhMuc()).listChiTietSanPham(sp.getListChiTietSanPham()).thuongHieu(sp.getThuongHieu()).trangThai(sp.getTrangThai()).tenSanPham(sp.getTenSanPham()).maSanPham(sp.getMaSanPham()).build();
/* 21 */     return sanPhamDetailResponse;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\SanPhamMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */