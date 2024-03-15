/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ 
/*    */ public class DonHangAdminResponse {
/*    */   private Integer idDonHang;
/*    */   private String maDonHang;
/*    */   private Integer idNhanVien;
/*    */   private KhachHang khachHang;
/*    */   private String ngayTao;
/*    */   private String ngayCapNhap;
/*    */   
/* 12 */   public void setIdDonHang(Integer idDonHang) { this.idDonHang = idDonHang; } private Integer trangThaiDonHang; private String diaChi; private Double tongTien; private Double phiVanChuyen; private String ghiChu; private String lyDo; public void setMaDonHang(String maDonHang) { this.maDonHang = maDonHang; } public void setIdNhanVien(Integer idNhanVien) { this.idNhanVien = idNhanVien; } public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public void setNgayTao(String ngayTao) { this.ngayTao = ngayTao; } public void setNgayCapNhap(String ngayCapNhap) { this.ngayCapNhap = ngayCapNhap; } public void setTrangThaiDonHang(Integer trangThaiDonHang) { this.trangThaiDonHang = trangThaiDonHang; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setTongTien(Double tongTien) { this.tongTien = tongTien; } public void setPhiVanChuyen(Double phiVanChuyen) { this.phiVanChuyen = phiVanChuyen; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setLyDo(String lyDo) { this.lyDo = lyDo; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.DonHangAdminResponse)) return false;  com.datn.dongho5s.Response.DonHangAdminResponse other = (com.datn.dongho5s.Response.DonHangAdminResponse)o; if (!other.canEqual(this)) return false;  Object this$idDonHang = getIdDonHang(), other$idDonHang = other.getIdDonHang(); if ((this$idDonHang == null) ? (other$idDonHang != null) : !this$idDonHang.equals(other$idDonHang)) return false;  Object this$idNhanVien = getIdNhanVien(), other$idNhanVien = other.getIdNhanVien(); if ((this$idNhanVien == null) ? (other$idNhanVien != null) : !this$idNhanVien.equals(other$idNhanVien)) return false;  Object this$trangThaiDonHang = getTrangThaiDonHang(), other$trangThaiDonHang = other.getTrangThaiDonHang(); if ((this$trangThaiDonHang == null) ? (other$trangThaiDonHang != null) : !this$trangThaiDonHang.equals(other$trangThaiDonHang)) return false;  Object this$tongTien = getTongTien(), other$tongTien = other.getTongTien(); if ((this$tongTien == null) ? (other$tongTien != null) : !this$tongTien.equals(other$tongTien)) return false;  Object this$phiVanChuyen = getPhiVanChuyen(), other$phiVanChuyen = other.getPhiVanChuyen(); if ((this$phiVanChuyen == null) ? (other$phiVanChuyen != null) : !this$phiVanChuyen.equals(other$phiVanChuyen)) return false;  Object this$maDonHang = getMaDonHang(), other$maDonHang = other.getMaDonHang(); if ((this$maDonHang == null) ? (other$maDonHang != null) : !this$maDonHang.equals(other$maDonHang)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); if ((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ngayCapNhap = getNgayCapNhap(), other$ngayCapNhap = other.getNgayCapNhap(); if ((this$ngayCapNhap == null) ? (other$ngayCapNhap != null) : !this$ngayCapNhap.equals(other$ngayCapNhap)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object this$lyDo = getLyDo(), other$lyDo = other.getLyDo(); return !((this$lyDo == null) ? (other$lyDo != null) : !this$lyDo.equals(other$lyDo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.DonHangAdminResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idDonHang = getIdDonHang(); result = result * 59 + (($idDonHang == null) ? 43 : $idDonHang.hashCode()); Object $idNhanVien = getIdNhanVien(); result = result * 59 + (($idNhanVien == null) ? 43 : $idNhanVien.hashCode()); Object $trangThaiDonHang = getTrangThaiDonHang(); result = result * 59 + (($trangThaiDonHang == null) ? 43 : $trangThaiDonHang.hashCode()); Object $tongTien = getTongTien(); result = result * 59 + (($tongTien == null) ? 43 : $tongTien.hashCode()); Object $phiVanChuyen = getPhiVanChuyen(); result = result * 59 + (($phiVanChuyen == null) ? 43 : $phiVanChuyen.hashCode()); Object $maDonHang = getMaDonHang(); result = result * 59 + (($maDonHang == null) ? 43 : $maDonHang.hashCode()); Object $khachHang = getKhachHang(); result = result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ngayCapNhap = getNgayCapNhap(); result = result * 59 + (($ngayCapNhap == null) ? 43 : $ngayCapNhap.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object $lyDo = getLyDo(); return result * 59 + (($lyDo == null) ? 43 : $lyDo.hashCode()); } public String toString() { return "DonHangAdminResponse(idDonHang=" + getIdDonHang() + ", maDonHang=" + getMaDonHang() + ", idNhanVien=" + getIdNhanVien() + ", khachHang=" + getKhachHang() + ", ngayTao=" + getNgayTao() + ", ngayCapNhap=" + getNgayCapNhap() + ", trangThaiDonHang=" + getTrangThaiDonHang() + ", diaChi=" + getDiaChi() + ", tongTien=" + getTongTien() + ", phiVanChuyen=" + getPhiVanChuyen() + ", ghiChu=" + getGhiChu() + ", lyDo=" + getLyDo() + ")"; } public DonHangAdminResponse(Integer idDonHang, String maDonHang, Integer idNhanVien, KhachHang khachHang, String ngayTao, String ngayCapNhap, Integer trangThaiDonHang, String diaChi, Double tongTien, Double phiVanChuyen, String ghiChu, String lyDo) {
/* 13 */     this.idDonHang = idDonHang; this.maDonHang = maDonHang; this.idNhanVien = idNhanVien; this.khachHang = khachHang; this.ngayTao = ngayTao; this.ngayCapNhap = ngayCapNhap; this.trangThaiDonHang = trangThaiDonHang; this.diaChi = diaChi; this.tongTien = tongTien; this.phiVanChuyen = phiVanChuyen; this.ghiChu = ghiChu; this.lyDo = lyDo;
/*    */   } public DonHangAdminResponse() {} public static DonHangAdminResponseBuilder builder() {
/* 15 */     return new DonHangAdminResponseBuilder();
/*    */   }
/*    */   
/* 18 */   public Integer getIdDonHang() { return this.idDonHang; }
/* 19 */   public String getMaDonHang() { return this.maDonHang; }
/* 20 */   public Integer getIdNhanVien() { return this.idNhanVien; }
/* 21 */   public KhachHang getKhachHang() { return this.khachHang; }
/* 22 */   public String getNgayTao() { return this.ngayTao; }
/* 23 */   public String getNgayCapNhap() { return this.ngayCapNhap; }
/* 24 */   public Integer getTrangThaiDonHang() { return this.trangThaiDonHang; }
/* 25 */   public String getDiaChi() { return this.diaChi; }
/* 26 */   public Double getTongTien() { return this.tongTien; }
/* 27 */   public Double getPhiVanChuyen() { return this.phiVanChuyen; }
/* 28 */   public String getGhiChu() { return this.ghiChu; } public String getLyDo() {
/* 29 */     return this.lyDo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\DonHangAdminResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */