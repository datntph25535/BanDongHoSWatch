/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class DiaChiRequest {
/*    */   private Integer idDiaChi;
/*    */   private Integer idTinhThanh;
/*    */   private Integer idQuanHuyen;
/*    */   
/*  8 */   public void setIdDiaChi(Integer idDiaChi) { this.idDiaChi = idDiaChi; } private String idPhuongXa; private String diaChi; private String soDienThoai; private String ghiChu; public void setIdTinhThanh(Integer idTinhThanh) { this.idTinhThanh = idTinhThanh; } public void setIdQuanHuyen(Integer idQuanHuyen) { this.idQuanHuyen = idQuanHuyen; } public void setIdPhuongXa(String idPhuongXa) { this.idPhuongXa = idPhuongXa; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.DiaChiRequest)) return false;  com.datn.dongho5s.Request.DiaChiRequest other = (com.datn.dongho5s.Request.DiaChiRequest)o; if (!other.canEqual(this)) return false;  Object this$idDiaChi = getIdDiaChi(), other$idDiaChi = other.getIdDiaChi(); if ((this$idDiaChi == null) ? (other$idDiaChi != null) : !this$idDiaChi.equals(other$idDiaChi)) return false;  Object this$idTinhThanh = getIdTinhThanh(), other$idTinhThanh = other.getIdTinhThanh(); if ((this$idTinhThanh == null) ? (other$idTinhThanh != null) : !this$idTinhThanh.equals(other$idTinhThanh)) return false;  Object this$idQuanHuyen = getIdQuanHuyen(), other$idQuanHuyen = other.getIdQuanHuyen(); if ((this$idQuanHuyen == null) ? (other$idQuanHuyen != null) : !this$idQuanHuyen.equals(other$idQuanHuyen)) return false;  Object this$idPhuongXa = getIdPhuongXa(), other$idPhuongXa = other.getIdPhuongXa(); if ((this$idPhuongXa == null) ? (other$idPhuongXa != null) : !this$idPhuongXa.equals(other$idPhuongXa)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); return !((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.DiaChiRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idDiaChi = getIdDiaChi(); result = result * 59 + (($idDiaChi == null) ? 43 : $idDiaChi.hashCode()); Object $idTinhThanh = getIdTinhThanh(); result = result * 59 + (($idTinhThanh == null) ? 43 : $idTinhThanh.hashCode()); Object $idQuanHuyen = getIdQuanHuyen(); result = result * 59 + (($idQuanHuyen == null) ? 43 : $idQuanHuyen.hashCode()); Object $idPhuongXa = getIdPhuongXa(); result = result * 59 + (($idPhuongXa == null) ? 43 : $idPhuongXa.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $ghiChu = getGhiChu(); return result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); } public String toString() { return "DiaChiRequest(idDiaChi=" + getIdDiaChi() + ", idTinhThanh=" + getIdTinhThanh() + ", idQuanHuyen=" + getIdQuanHuyen() + ", idPhuongXa=" + getIdPhuongXa() + ", diaChi=" + getDiaChi() + ", soDienThoai=" + getSoDienThoai() + ", ghiChu=" + getGhiChu() + ")"; } public DiaChiRequest(Integer idDiaChi, Integer idTinhThanh, Integer idQuanHuyen, String idPhuongXa, String diaChi, String soDienThoai, String ghiChu) {
/*  9 */     this.idDiaChi = idDiaChi; this.idTinhThanh = idTinhThanh; this.idQuanHuyen = idQuanHuyen; this.idPhuongXa = idPhuongXa; this.diaChi = diaChi; this.soDienThoai = soDienThoai; this.ghiChu = ghiChu;
/*    */   } public DiaChiRequest() {} public static DiaChiRequestBuilder builder() {
/* 11 */     return new DiaChiRequestBuilder();
/*    */   }
/* 13 */   public Integer getIdDiaChi() { return this.idDiaChi; }
/* 14 */   public Integer getIdTinhThanh() { return this.idTinhThanh; }
/* 15 */   public Integer getIdQuanHuyen() { return this.idQuanHuyen; }
/* 16 */   public String getIdPhuongXa() { return this.idPhuongXa; }
/* 17 */   public String getDiaChi() { return this.diaChi; }
/* 18 */   public String getSoDienThoai() { return this.soDienThoai; } public String getGhiChu() {
/* 19 */     return this.ghiChu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\DiaChiRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */