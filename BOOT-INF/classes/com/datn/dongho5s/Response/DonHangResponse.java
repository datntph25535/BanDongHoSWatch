/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*    */ 
/*    */ public class DonHangResponse {
/*    */   private Integer idDonHang;
/*    */   private String maDonHang;
/*    */   private NhanVien nhanVien;
/*    */   private KhachHang khachHang;
/*    */   private Date ngayTao;
/*    */   private Date ngayGiaoHang;
/*    */   private Double tongTien;
/*    */   private Integer trangThaiDonHang;
/*    */   
/* 15 */   public void setIdDonHang(Integer idDonHang) { this.idDonHang = idDonHang; } private String TinhThanh; private String QuanHuyen; private String PhuongXa; private String diaChi; private Double phiVanChuyen; private String ngayCapNhap; private String ghiChu; private List<HoaDonChiTiet> hoaDonChiTiets; private String lyDo; public void setMaDonHang(String maDonHang) { this.maDonHang = maDonHang; } public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; } public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; } public void setNgayGiaoHang(Date ngayGiaoHang) { this.ngayGiaoHang = ngayGiaoHang; } public void setTongTien(Double tongTien) { this.tongTien = tongTien; } public void setTrangThaiDonHang(Integer trangThaiDonHang) { this.trangThaiDonHang = trangThaiDonHang; } public void setTinhThanh(String TinhThanh) { this.TinhThanh = TinhThanh; } public void setQuanHuyen(String QuanHuyen) { this.QuanHuyen = QuanHuyen; } public void setPhuongXa(String PhuongXa) { this.PhuongXa = PhuongXa; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setPhiVanChuyen(Double phiVanChuyen) { this.phiVanChuyen = phiVanChuyen; } public void setNgayCapNhap(String ngayCapNhap) { this.ngayCapNhap = ngayCapNhap; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) { this.hoaDonChiTiets = hoaDonChiTiets; } public void setLyDo(String lyDo) { this.lyDo = lyDo; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.DonHangResponse)) return false;  com.datn.dongho5s.Response.DonHangResponse other = (com.datn.dongho5s.Response.DonHangResponse)o; if (!other.canEqual(this)) return false;  Object this$idDonHang = getIdDonHang(), other$idDonHang = other.getIdDonHang(); if ((this$idDonHang == null) ? (other$idDonHang != null) : !this$idDonHang.equals(other$idDonHang)) return false;  Object this$tongTien = getTongTien(), other$tongTien = other.getTongTien(); if ((this$tongTien == null) ? (other$tongTien != null) : !this$tongTien.equals(other$tongTien)) return false;  Object this$trangThaiDonHang = getTrangThaiDonHang(), other$trangThaiDonHang = other.getTrangThaiDonHang(); if ((this$trangThaiDonHang == null) ? (other$trangThaiDonHang != null) : !this$trangThaiDonHang.equals(other$trangThaiDonHang)) return false;  Object this$phiVanChuyen = getPhiVanChuyen(), other$phiVanChuyen = other.getPhiVanChuyen(); if ((this$phiVanChuyen == null) ? (other$phiVanChuyen != null) : !this$phiVanChuyen.equals(other$phiVanChuyen)) return false;  Object this$maDonHang = getMaDonHang(), other$maDonHang = other.getMaDonHang(); if ((this$maDonHang == null) ? (other$maDonHang != null) : !this$maDonHang.equals(other$maDonHang)) return false;  Object this$nhanVien = getNhanVien(), other$nhanVien = other.getNhanVien(); if ((this$nhanVien == null) ? (other$nhanVien != null) : !this$nhanVien.equals(other$nhanVien)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); if ((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ngayGiaoHang = getNgayGiaoHang(), other$ngayGiaoHang = other.getNgayGiaoHang(); if ((this$ngayGiaoHang == null) ? (other$ngayGiaoHang != null) : !this$ngayGiaoHang.equals(other$ngayGiaoHang)) return false;  Object this$TinhThanh = getTinhThanh(), other$TinhThanh = other.getTinhThanh(); if ((this$TinhThanh == null) ? (other$TinhThanh != null) : !this$TinhThanh.equals(other$TinhThanh)) return false;  Object this$QuanHuyen = getQuanHuyen(), other$QuanHuyen = other.getQuanHuyen(); if ((this$QuanHuyen == null) ? (other$QuanHuyen != null) : !this$QuanHuyen.equals(other$QuanHuyen)) return false;  Object this$PhuongXa = getPhuongXa(), other$PhuongXa = other.getPhuongXa(); if ((this$PhuongXa == null) ? (other$PhuongXa != null) : !this$PhuongXa.equals(other$PhuongXa)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$ngayCapNhap = getNgayCapNhap(), other$ngayCapNhap = other.getNgayCapNhap(); if ((this$ngayCapNhap == null) ? (other$ngayCapNhap != null) : !this$ngayCapNhap.equals(other$ngayCapNhap)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object<HoaDonChiTiet> this$hoaDonChiTiets = (Object<HoaDonChiTiet>)getHoaDonChiTiets(), other$hoaDonChiTiets = (Object<HoaDonChiTiet>)other.getHoaDonChiTiets(); if ((this$hoaDonChiTiets == null) ? (other$hoaDonChiTiets != null) : !this$hoaDonChiTiets.equals(other$hoaDonChiTiets)) return false;  Object this$lyDo = getLyDo(), other$lyDo = other.getLyDo(); return !((this$lyDo == null) ? (other$lyDo != null) : !this$lyDo.equals(other$lyDo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.DonHangResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idDonHang = getIdDonHang(); result = result * 59 + (($idDonHang == null) ? 43 : $idDonHang.hashCode()); Object $tongTien = getTongTien(); result = result * 59 + (($tongTien == null) ? 43 : $tongTien.hashCode()); Object $trangThaiDonHang = getTrangThaiDonHang(); result = result * 59 + (($trangThaiDonHang == null) ? 43 : $trangThaiDonHang.hashCode()); Object $phiVanChuyen = getPhiVanChuyen(); result = result * 59 + (($phiVanChuyen == null) ? 43 : $phiVanChuyen.hashCode()); Object $maDonHang = getMaDonHang(); result = result * 59 + (($maDonHang == null) ? 43 : $maDonHang.hashCode()); Object $nhanVien = getNhanVien(); result = result * 59 + (($nhanVien == null) ? 43 : $nhanVien.hashCode()); Object $khachHang = getKhachHang(); result = result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ngayGiaoHang = getNgayGiaoHang(); result = result * 59 + (($ngayGiaoHang == null) ? 43 : $ngayGiaoHang.hashCode()); Object $TinhThanh = getTinhThanh(); result = result * 59 + (($TinhThanh == null) ? 43 : $TinhThanh.hashCode()); Object $QuanHuyen = getQuanHuyen(); result = result * 59 + (($QuanHuyen == null) ? 43 : $QuanHuyen.hashCode()); Object $PhuongXa = getPhuongXa(); result = result * 59 + (($PhuongXa == null) ? 43 : $PhuongXa.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $ngayCapNhap = getNgayCapNhap(); result = result * 59 + (($ngayCapNhap == null) ? 43 : $ngayCapNhap.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object<HoaDonChiTiet> $hoaDonChiTiets = (Object<HoaDonChiTiet>)getHoaDonChiTiets(); result = result * 59 + (($hoaDonChiTiets == null) ? 43 : $hoaDonChiTiets.hashCode()); Object $lyDo = getLyDo(); return result * 59 + (($lyDo == null) ? 43 : $lyDo.hashCode()); } public String toString() { return "DonHangResponse(idDonHang=" + getIdDonHang() + ", maDonHang=" + getMaDonHang() + ", nhanVien=" + getNhanVien() + ", khachHang=" + getKhachHang() + ", ngayTao=" + getNgayTao() + ", ngayGiaoHang=" + getNgayGiaoHang() + ", tongTien=" + getTongTien() + ", trangThaiDonHang=" + getTrangThaiDonHang() + ", TinhThanh=" + getTinhThanh() + ", QuanHuyen=" + getQuanHuyen() + ", PhuongXa=" + getPhuongXa() + ", diaChi=" + getDiaChi() + ", phiVanChuyen=" + getPhiVanChuyen() + ", ngayCapNhap=" + getNgayCapNhap() + ", ghiChu=" + getGhiChu() + ", hoaDonChiTiets=" + getHoaDonChiTiets() + ", lyDo=" + getLyDo() + ")"; } public DonHangResponse(Integer idDonHang, String maDonHang, NhanVien nhanVien, KhachHang khachHang, Date ngayTao, Date ngayGiaoHang, Double tongTien, Integer trangThaiDonHang, String TinhThanh, String QuanHuyen, String PhuongXa, String diaChi, Double phiVanChuyen, String ngayCapNhap, String ghiChu, List<HoaDonChiTiet> hoaDonChiTiets, String lyDo) {
/* 16 */     this.idDonHang = idDonHang; this.maDonHang = maDonHang; this.nhanVien = nhanVien; this.khachHang = khachHang; this.ngayTao = ngayTao; this.ngayGiaoHang = ngayGiaoHang; this.tongTien = tongTien; this.trangThaiDonHang = trangThaiDonHang; this.TinhThanh = TinhThanh; this.QuanHuyen = QuanHuyen; this.PhuongXa = PhuongXa; this.diaChi = diaChi; this.phiVanChuyen = phiVanChuyen; this.ngayCapNhap = ngayCapNhap; this.ghiChu = ghiChu; this.hoaDonChiTiets = hoaDonChiTiets; this.lyDo = lyDo;
/*    */   } public DonHangResponse() {} public static DonHangResponseBuilder builder() {
/* 18 */     return new DonHangResponseBuilder();
/*    */   } public Integer getIdDonHang() {
/* 20 */     return this.idDonHang;
/*    */   } public String getMaDonHang() {
/* 22 */     return this.maDonHang;
/*    */   } public NhanVien getNhanVien() {
/* 24 */     return this.nhanVien;
/*    */   } public KhachHang getKhachHang() {
/* 26 */     return this.khachHang;
/*    */   } public Date getNgayTao() {
/* 28 */     return this.ngayTao;
/*    */   } public Date getNgayGiaoHang() {
/* 30 */     return this.ngayGiaoHang;
/*    */   } public Double getTongTien() {
/* 32 */     return this.tongTien;
/*    */   } public Integer getTrangThaiDonHang() {
/* 34 */     return this.trangThaiDonHang;
/*    */   } public String getTinhThanh() {
/* 36 */     return this.TinhThanh;
/*    */   } public String getQuanHuyen() {
/* 38 */     return this.QuanHuyen;
/*    */   } public String getPhuongXa() {
/* 40 */     return this.PhuongXa;
/*    */   } public String getDiaChi() {
/* 42 */     return this.diaChi;
/*    */   } public Double getPhiVanChuyen() {
/* 44 */     return this.phiVanChuyen;
/*    */   } public String getNgayCapNhap() {
/* 46 */     return this.ngayCapNhap;
/*    */   }
/* 48 */   public String getGhiChu() { return this.ghiChu; }
/* 49 */   public List<HoaDonChiTiet> getHoaDonChiTiets() { return this.hoaDonChiTiets; } public String getLyDo() {
/* 50 */     return this.lyDo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\DonHangResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */