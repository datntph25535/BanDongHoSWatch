/*    */ package BOOT-INF.classes.com.datn.dongho5s.mapper;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Request.ChiTietSanPhamRequest;
/*    */ import com.datn.dongho5s.Response.ChiTietSanPhamResponse;
/*    */ 
/*    */ public class ChiTietSanPhamMapping {
/*  8 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.mapper.ChiTietSanPhamMapping)) return false;  com.datn.dongho5s.mapper.ChiTietSanPhamMapping other = (com.datn.dongho5s.mapper.ChiTietSanPhamMapping)o; return !!other.canEqual(this); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.mapper.ChiTietSanPhamMapping; } public int hashCode() { int result = 1; return 1; } public String toString() { return "ChiTietSanPhamMapping()"; }
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
/*    */ 
/*    */ 
/*    */   
/*    */   public static ChiTietSanPhamResponse mapEntitytoResponse(ChiTietSanPham sp) {
/* 27 */     ChiTietSanPhamResponse chiTietSanPhamResponse = ChiTietSanPhamResponse.builder().idChiTietSanPham(sp.getIdChiTietSanPham()).sanPham(sp.getSanPham()).dayDeo(sp.getDayDeo()).khuyenMai(sp.getKhuyenMai()).mauSac(sp.getMauSac()).vatLieu(sp.getVatLieu()).kichCo(sp.getKichCo()).chieuDaiDayDeo(sp.getChieuDaiDayDeo()).duongKinhMatDongHo(sp.getDuongKinhMatDongHo()).doDayMatDongHo(sp.getDoDayMatDongHo()).doChiuNuoc(sp.getDoChiuNuoc()).trangThai(sp.getTrangThai()).giaSanPham(sp.getGiaSanPham()).listPhanHoi(sp.getListPhanHoi()).build();
/* 28 */     return chiTietSanPhamResponse;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ChiTietSanPham mapRequestToEntity(ChiTietSanPhamRequest sp) {
/* 47 */     ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder().idChiTietSanPham(sp.getIdChiTietSanPham()).sanPham(sp.getSanPham()).dayDeo(sp.getDayDeo()).khuyenMai(sp.getKhuyenMai()).mauSac(sp.getMauSac()).vatLieu(sp.getVatLieu()).kichCo(sp.getKichCo()).chieuDaiDayDeo(sp.getChieuDaiDayDeo()).duongKinhMatDongHo(sp.getDuongKinhMatDongHo()).doDayMatDongHo(sp.getDoDayMatDongHo()).doChiuNuoc(sp.getDoChiuNuoc()).trangThai(sp.getTrangThai()).giaSanPham(sp.getGiaSanPham()).build();
/* 48 */     return chiTietSanPham;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\mapper\ChiTietSanPhamMapping.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */