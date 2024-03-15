/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "diachi")
/*    */ public class DiaChi {
/*    */   @Id
/*    */   @Column(name = "id_dia_chi")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idDiaChi;
/*    */   @Column(name = "id_tinh_thanh")
/*    */   private Integer idTinhThanh;
/*    */   @Column(name = "id_quan_huyen")
/*    */   private Integer idQuanHuyen;
/*    */   @Column(name = "id_phuong_xa")
/*    */   private String idPhuongXa;
/*    */   @Column(name = "dia_chi")
/*    */   private String diaChi;
/*    */   
/* 19 */   public void setIdDiaChi(Integer idDiaChi) { this.idDiaChi = idDiaChi; } @Column(name = "ma_buu_chinh") private Integer maBuuChinh; @Column(name = "so_dien_thoai") private String soDienThoai; @Column(name = "ghi_chu") private String ghiChu; @Column(name = "trang_thai_mac_dinh") private Integer trangThaiMacDinh; @JsonIgnore @ManyToOne @JoinColumn(name = "id_khach_hang") private KhachHang khachHang; public void setIdTinhThanh(Integer idTinhThanh) { this.idTinhThanh = idTinhThanh; } public void setIdQuanHuyen(Integer idQuanHuyen) { this.idQuanHuyen = idQuanHuyen; } public void setIdPhuongXa(String idPhuongXa) { this.idPhuongXa = idPhuongXa; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setMaBuuChinh(Integer maBuuChinh) { this.maBuuChinh = maBuuChinh; } public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setTrangThaiMacDinh(Integer trangThaiMacDinh) { this.trangThaiMacDinh = trangThaiMacDinh; } @JsonIgnore public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.DiaChi)) return false;  com.datn.dongho5s.Entity.DiaChi other = (com.datn.dongho5s.Entity.DiaChi)o; if (!other.canEqual(this)) return false;  Object this$idDiaChi = getIdDiaChi(), other$idDiaChi = other.getIdDiaChi(); if ((this$idDiaChi == null) ? (other$idDiaChi != null) : !this$idDiaChi.equals(other$idDiaChi)) return false;  Object this$idTinhThanh = getIdTinhThanh(), other$idTinhThanh = other.getIdTinhThanh(); if ((this$idTinhThanh == null) ? (other$idTinhThanh != null) : !this$idTinhThanh.equals(other$idTinhThanh)) return false;  Object this$idQuanHuyen = getIdQuanHuyen(), other$idQuanHuyen = other.getIdQuanHuyen(); if ((this$idQuanHuyen == null) ? (other$idQuanHuyen != null) : !this$idQuanHuyen.equals(other$idQuanHuyen)) return false;  Object this$maBuuChinh = getMaBuuChinh(), other$maBuuChinh = other.getMaBuuChinh(); if ((this$maBuuChinh == null) ? (other$maBuuChinh != null) : !this$maBuuChinh.equals(other$maBuuChinh)) return false;  Object this$trangThaiMacDinh = getTrangThaiMacDinh(), other$trangThaiMacDinh = other.getTrangThaiMacDinh(); if ((this$trangThaiMacDinh == null) ? (other$trangThaiMacDinh != null) : !this$trangThaiMacDinh.equals(other$trangThaiMacDinh)) return false;  Object this$idPhuongXa = getIdPhuongXa(), other$idPhuongXa = other.getIdPhuongXa(); if ((this$idPhuongXa == null) ? (other$idPhuongXa != null) : !this$idPhuongXa.equals(other$idPhuongXa)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); return !((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.DiaChi; } public int hashCode() { int PRIME = 59; result = 1; Object $idDiaChi = getIdDiaChi(); result = result * 59 + (($idDiaChi == null) ? 43 : $idDiaChi.hashCode()); Object $idTinhThanh = getIdTinhThanh(); result = result * 59 + (($idTinhThanh == null) ? 43 : $idTinhThanh.hashCode()); Object $idQuanHuyen = getIdQuanHuyen(); result = result * 59 + (($idQuanHuyen == null) ? 43 : $idQuanHuyen.hashCode()); Object $maBuuChinh = getMaBuuChinh(); result = result * 59 + (($maBuuChinh == null) ? 43 : $maBuuChinh.hashCode()); Object $trangThaiMacDinh = getTrangThaiMacDinh(); result = result * 59 + (($trangThaiMacDinh == null) ? 43 : $trangThaiMacDinh.hashCode()); Object $idPhuongXa = getIdPhuongXa(); result = result * 59 + (($idPhuongXa == null) ? 43 : $idPhuongXa.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object $khachHang = getKhachHang(); return result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); } public String toString() { return "DiaChi(idDiaChi=" + getIdDiaChi() + ", idTinhThanh=" + getIdTinhThanh() + ", idQuanHuyen=" + getIdQuanHuyen() + ", idPhuongXa=" + getIdPhuongXa() + ", diaChi=" + getDiaChi() + ", maBuuChinh=" + getMaBuuChinh() + ", soDienThoai=" + getSoDienThoai() + ", ghiChu=" + getGhiChu() + ", trangThaiMacDinh=" + getTrangThaiMacDinh() + ", khachHang=" + getKhachHang() + ")"; }
/* 20 */   public static DiaChiBuilder builder() { return new DiaChiBuilder(); } public DiaChi(Integer idDiaChi, Integer idTinhThanh, Integer idQuanHuyen, String idPhuongXa, String diaChi, Integer maBuuChinh, String soDienThoai, String ghiChu, Integer trangThaiMacDinh, KhachHang khachHang) {
/* 21 */     this.idDiaChi = idDiaChi; this.idTinhThanh = idTinhThanh; this.idQuanHuyen = idQuanHuyen; this.idPhuongXa = idPhuongXa; this.diaChi = diaChi; this.maBuuChinh = maBuuChinh; this.soDienThoai = soDienThoai; this.ghiChu = ghiChu; this.trangThaiMacDinh = trangThaiMacDinh; this.khachHang = khachHang;
/*    */   }
/*    */ 
/*    */   
/*    */   public DiaChi() {}
/*    */   
/*    */   public Integer getIdDiaChi() {
/* 28 */     return this.idDiaChi;
/*    */   }
/*    */   public Integer getIdTinhThanh() {
/* 31 */     return this.idTinhThanh;
/*    */   }
/*    */   public Integer getIdQuanHuyen() {
/* 34 */     return this.idQuanHuyen;
/*    */   }
/*    */   public String getIdPhuongXa() {
/* 37 */     return this.idPhuongXa;
/*    */   }
/*    */   public String getDiaChi() {
/* 40 */     return this.diaChi;
/*    */   }
/*    */   public Integer getMaBuuChinh() {
/* 43 */     return this.maBuuChinh;
/*    */   }
/*    */   public String getSoDienThoai() {
/* 46 */     return this.soDienThoai;
/*    */   }
/*    */   public String getGhiChu() {
/* 49 */     return this.ghiChu;
/*    */   }
/*    */   public Integer getTrangThaiMacDinh() {
/* 52 */     return this.trangThaiMacDinh;
/*    */   }
/*    */ 
/*    */   
/*    */   public KhachHang getKhachHang() {
/* 57 */     return this.khachHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\DiaChi.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */