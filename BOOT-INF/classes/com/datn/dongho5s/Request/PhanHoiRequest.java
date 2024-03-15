/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class PhanHoiRequest {
/*    */   private String noiDungPhanHoi;
/*    */   private Integer danhGia;
/*    */   private Integer idChiTietSanPham;
/*    */   private Integer idKhachHang;
/*    */   
/*    */   public void setNoiDungPhanHoi(String noiDungPhanHoi) {
/* 10 */     this.noiDungPhanHoi = noiDungPhanHoi; } public void setDanhGia(Integer danhGia) { this.danhGia = danhGia; } public void setIdChiTietSanPham(Integer idChiTietSanPham) { this.idChiTietSanPham = idChiTietSanPham; } public void setIdKhachHang(Integer idKhachHang) { this.idKhachHang = idKhachHang; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.PhanHoiRequest)) return false;  com.datn.dongho5s.Request.PhanHoiRequest other = (com.datn.dongho5s.Request.PhanHoiRequest)o; if (!other.canEqual(this)) return false;  Object this$danhGia = getDanhGia(), other$danhGia = other.getDanhGia(); if ((this$danhGia == null) ? (other$danhGia != null) : !this$danhGia.equals(other$danhGia)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$idKhachHang = getIdKhachHang(), other$idKhachHang = other.getIdKhachHang(); if ((this$idKhachHang == null) ? (other$idKhachHang != null) : !this$idKhachHang.equals(other$idKhachHang)) return false;  Object this$noiDungPhanHoi = getNoiDungPhanHoi(), other$noiDungPhanHoi = other.getNoiDungPhanHoi(); return !((this$noiDungPhanHoi == null) ? (other$noiDungPhanHoi != null) : !this$noiDungPhanHoi.equals(other$noiDungPhanHoi)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.PhanHoiRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $danhGia = getDanhGia(); result = result * 59 + (($danhGia == null) ? 43 : $danhGia.hashCode()); Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $idKhachHang = getIdKhachHang(); result = result * 59 + (($idKhachHang == null) ? 43 : $idKhachHang.hashCode()); Object $noiDungPhanHoi = getNoiDungPhanHoi(); return result * 59 + (($noiDungPhanHoi == null) ? 43 : $noiDungPhanHoi.hashCode()); } public String toString() { return "PhanHoiRequest(noiDungPhanHoi=" + getNoiDungPhanHoi() + ", danhGia=" + getDanhGia() + ", idChiTietSanPham=" + getIdChiTietSanPham() + ", idKhachHang=" + getIdKhachHang() + ")"; } public PhanHoiRequest(String noiDungPhanHoi, Integer danhGia, Integer idChiTietSanPham, Integer idKhachHang) {
/* 11 */     this.noiDungPhanHoi = noiDungPhanHoi; this.danhGia = danhGia; this.idChiTietSanPham = idChiTietSanPham; this.idKhachHang = idKhachHang;
/*    */   } public PhanHoiRequest() {} public static PhanHoiRequestBuilder builder() {
/* 13 */     return new PhanHoiRequestBuilder();
/*    */   }
/* 15 */   public String getNoiDungPhanHoi() { return this.noiDungPhanHoi; }
/* 16 */   public Integer getDanhGia() { return this.danhGia; }
/* 17 */   public Integer getIdChiTietSanPham() { return this.idChiTietSanPham; } public Integer getIdKhachHang() {
/* 18 */     return this.idKhachHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\PhanHoiRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */