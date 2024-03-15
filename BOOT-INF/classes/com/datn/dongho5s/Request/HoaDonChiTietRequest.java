/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class HoaDonChiTietRequest {
/*    */   Integer idChiTietSanPham;
/*    */   Integer soLuong;
/*    */   
/*  7 */   public void setIdChiTietSanPham(Integer idChiTietSanPham) { this.idChiTietSanPham = idChiTietSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.HoaDonChiTietRequest)) return false;  com.datn.dongho5s.Request.HoaDonChiTietRequest other = (com.datn.dongho5s.Request.HoaDonChiTietRequest)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); return !((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.HoaDonChiTietRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $soLuong = getSoLuong(); return result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); } public String toString() { return "HoaDonChiTietRequest(idChiTietSanPham=" + getIdChiTietSanPham() + ", soLuong=" + getSoLuong() + ")"; }
/*    */    public HoaDonChiTietRequest() {} public HoaDonChiTietRequest(Integer idChiTietSanPham, Integer soLuong) {
/*  9 */     this.idChiTietSanPham = idChiTietSanPham; this.soLuong = soLuong;
/*    */   }
/* 11 */   public Integer getIdChiTietSanPham() { return this.idChiTietSanPham; } public Integer getSoLuong() {
/* 12 */     return this.soLuong;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\HoaDonChiTietRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */