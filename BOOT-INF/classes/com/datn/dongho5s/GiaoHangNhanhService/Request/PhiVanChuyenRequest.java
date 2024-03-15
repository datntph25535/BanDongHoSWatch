/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.Request;
/*    */ 
/*    */ public class PhiVanChuyenRequest {
/*    */   private Integer idQuanHuyen;
/*    */   private String idPhuongXa;
/*    */   
/*    */   public PhiVanChuyenRequest(Integer idQuanHuyen, String idPhuongXa, Integer soLuongSanPham, Double trungBinhTheTich) {
/*  8 */     this.idQuanHuyen = idQuanHuyen; this.idPhuongXa = idPhuongXa; this.soLuongSanPham = soLuongSanPham; this.trungBinhTheTich = trungBinhTheTich;
/*    */   } private Integer soLuongSanPham; private Double trungBinhTheTich; public PhiVanChuyenRequest() {} public void setIdQuanHuyen(Integer idQuanHuyen) {
/* 10 */     this.idQuanHuyen = idQuanHuyen; } public void setIdPhuongXa(String idPhuongXa) { this.idPhuongXa = idPhuongXa; } public void setSoLuongSanPham(Integer soLuongSanPham) { this.soLuongSanPham = soLuongSanPham; } public void setTrungBinhTheTich(Double trungBinhTheTich) { this.trungBinhTheTich = trungBinhTheTich; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest)) return false;  com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest other = (com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest)o; if (!other.canEqual(this)) return false;  Object this$idQuanHuyen = getIdQuanHuyen(), other$idQuanHuyen = other.getIdQuanHuyen(); if ((this$idQuanHuyen == null) ? (other$idQuanHuyen != null) : !this$idQuanHuyen.equals(other$idQuanHuyen)) return false;  Object this$soLuongSanPham = getSoLuongSanPham(), other$soLuongSanPham = other.getSoLuongSanPham(); if ((this$soLuongSanPham == null) ? (other$soLuongSanPham != null) : !this$soLuongSanPham.equals(other$soLuongSanPham)) return false;  Object this$trungBinhTheTich = getTrungBinhTheTich(), other$trungBinhTheTich = other.getTrungBinhTheTich(); if ((this$trungBinhTheTich == null) ? (other$trungBinhTheTich != null) : !this$trungBinhTheTich.equals(other$trungBinhTheTich)) return false;  Object this$idPhuongXa = getIdPhuongXa(), other$idPhuongXa = other.getIdPhuongXa(); return !((this$idPhuongXa == null) ? (other$idPhuongXa != null) : !this$idPhuongXa.equals(other$idPhuongXa)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.Request.PhiVanChuyenRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idQuanHuyen = getIdQuanHuyen(); result = result * 59 + (($idQuanHuyen == null) ? 43 : $idQuanHuyen.hashCode()); Object $soLuongSanPham = getSoLuongSanPham(); result = result * 59 + (($soLuongSanPham == null) ? 43 : $soLuongSanPham.hashCode()); Object $trungBinhTheTich = getTrungBinhTheTich(); result = result * 59 + (($trungBinhTheTich == null) ? 43 : $trungBinhTheTich.hashCode()); Object $idPhuongXa = getIdPhuongXa(); return result * 59 + (($idPhuongXa == null) ? 43 : $idPhuongXa.hashCode()); } public String toString() { return "PhiVanChuyenRequest(idQuanHuyen=" + getIdQuanHuyen() + ", idPhuongXa=" + getIdPhuongXa() + ", soLuongSanPham=" + getSoLuongSanPham() + ", trungBinhTheTich=" + getTrungBinhTheTich() + ")"; }
/*    */ 
/*    */   
/* 13 */   public Integer getIdQuanHuyen() { return this.idQuanHuyen; }
/* 14 */   public String getIdPhuongXa() { return this.idPhuongXa; }
/* 15 */   public Integer getSoLuongSanPham() { return this.soLuongSanPham; } public Double getTrungBinhTheTich() {
/* 16 */     return this.trungBinhTheTich;
/*    */   }
/*    */   public Integer getTrungBinhCacCanh() {
/* 19 */     Double theTichToanBoSanPham = Double.valueOf(Math.pow(Constant.DO_DAI_CANH_HOP_HANG.intValue(), 3.0D) * this.soLuongSanPham.intValue());
/* 20 */     return Integer.valueOf((int)Math.cbrt(theTichToanBoSanPham.doubleValue()));
/*    */   }
/*    */   public String getStringPhuongXa() {
/* 23 */     return String.valueOf(this.idPhuongXa);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\Request\PhiVanChuyenRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */