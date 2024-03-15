/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class CartRequest {
/*    */   Integer idChiTietSanPham;
/*    */   Integer soLuong;
/*    */   Integer idKhachHang;
/*    */   Double giaSanPham;
/*    */   
/*  9 */   public void setIdChiTietSanPham(Integer idChiTietSanPham) { this.idChiTietSanPham = idChiTietSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setIdKhachHang(Integer idKhachHang) { this.idKhachHang = idKhachHang; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.CartRequest)) return false;  com.datn.dongho5s.Request.CartRequest other = (com.datn.dongho5s.Request.CartRequest)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$idKhachHang = getIdKhachHang(), other$idKhachHang = other.getIdKhachHang(); if ((this$idKhachHang == null) ? (other$idKhachHang != null) : !this$idKhachHang.equals(other$idKhachHang)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); return !((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.CartRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $idKhachHang = getIdKhachHang(); result = result * 59 + (($idKhachHang == null) ? 43 : $idKhachHang.hashCode()); Object $giaSanPham = getGiaSanPham(); return result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); } public String toString() { return "CartRequest(idChiTietSanPham=" + getIdChiTietSanPham() + ", soLuong=" + getSoLuong() + ", idKhachHang=" + getIdKhachHang() + ", giaSanPham=" + getGiaSanPham() + ")"; } public CartRequest(Integer idChiTietSanPham, Integer soLuong, Integer idKhachHang, Double giaSanPham) {
/* 10 */     this.idChiTietSanPham = idChiTietSanPham; this.soLuong = soLuong; this.idKhachHang = idKhachHang; this.giaSanPham = giaSanPham;
/*    */   } public CartRequest() {} public static CartRequestBuilder builder() {
/* 12 */     return new CartRequestBuilder();
/*    */   }
/* 14 */   public Integer getIdChiTietSanPham() { return this.idChiTietSanPham; }
/* 15 */   public Integer getSoLuong() { return this.soLuong; }
/* 16 */   public Integer getIdKhachHang() { return this.idKhachHang; } public Double getGiaSanPham() {
/* 17 */     return this.giaSanPham;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\CartRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */