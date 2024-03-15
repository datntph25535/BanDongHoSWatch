/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ public class HoaDonAdminRequest {
/*    */   String maHoaDon;
/*    */   String sdt;
/*    */   String tenKhachHang;
/*    */   String ngayTao;
/*    */   Double tongTienDonHang;
/*    */   
/*    */   public HoaDonAdminRequest() {}
/*    */   
/* 11 */   public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; } public void setSdt(String sdt) { this.sdt = sdt; } public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; } public void setNgayTao(String ngayTao) { this.ngayTao = ngayTao; } public void setTongTienDonHang(Double tongTienDonHang) { this.tongTienDonHang = tongTienDonHang; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.HoaDonAdminRequest)) return false;  com.datn.dongho5s.Request.HoaDonAdminRequest other = (com.datn.dongho5s.Request.HoaDonAdminRequest)o; if (!other.canEqual(this)) return false;  Object this$tongTienDonHang = getTongTienDonHang(), other$tongTienDonHang = other.getTongTienDonHang(); if ((this$tongTienDonHang == null) ? (other$tongTienDonHang != null) : !this$tongTienDonHang.equals(other$tongTienDonHang)) return false;  Object this$maHoaDon = getMaHoaDon(), other$maHoaDon = other.getMaHoaDon(); if ((this$maHoaDon == null) ? (other$maHoaDon != null) : !this$maHoaDon.equals(other$maHoaDon)) return false;  Object this$sdt = getSdt(), other$sdt = other.getSdt(); if ((this$sdt == null) ? (other$sdt != null) : !this$sdt.equals(other$sdt)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); return !((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.HoaDonAdminRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $tongTienDonHang = getTongTienDonHang(); result = result * 59 + (($tongTienDonHang == null) ? 43 : $tongTienDonHang.hashCode()); Object $maHoaDon = getMaHoaDon(); result = result * 59 + (($maHoaDon == null) ? 43 : $maHoaDon.hashCode()); Object $sdt = getSdt(); result = result * 59 + (($sdt == null) ? 43 : $sdt.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $ngayTao = getNgayTao(); return result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); } public String toString() { return "HoaDonAdminRequest(maHoaDon=" + getMaHoaDon() + ", sdt=" + getSdt() + ", tenKhachHang=" + getTenKhachHang() + ", ngayTao=" + getNgayTao() + ", tongTienDonHang=" + getTongTienDonHang() + ")"; }
/* 12 */   public static HoaDonAdminRequestBuilder builder() { return new HoaDonAdminRequestBuilder(); } public HoaDonAdminRequest(String maHoaDon, String sdt, String tenKhachHang, String ngayTao, Double tongTienDonHang) {
/* 13 */     this.maHoaDon = maHoaDon; this.sdt = sdt; this.tenKhachHang = tenKhachHang; this.ngayTao = ngayTao; this.tongTienDonHang = tongTienDonHang;
/*    */   }
/* 15 */   public String getMaHoaDon() { return this.maHoaDon; }
/* 16 */   public String getSdt() { return this.sdt; }
/* 17 */   public String getTenKhachHang() { return this.tenKhachHang; } public String getNgayTao() {
/* 18 */     return this.ngayTao;
/*    */   }
/*    */   
/*    */   public Double getTongTienDonHang() {
/* 22 */     return this.tongTienDonHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\HoaDonAdminRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */