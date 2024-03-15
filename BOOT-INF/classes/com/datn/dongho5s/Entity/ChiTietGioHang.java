/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "chitietgiohang")
/*    */ public class ChiTietGioHang {
/*    */   @Id
/*    */   @Column(name = "id_chi_tiet_gio_hang")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idChiTietGioHang;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_gio_hang")
/*    */   private GioHang gioHang;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_chi_tiet_san_pham")
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   
/* 19 */   public void setIdChiTietGioHang(Integer idChiTietGioHang) { this.idChiTietGioHang = idChiTietGioHang; } @Column(name = "so_luong_san_pham") private Integer soLuongSanPham; @Column(name = "gia_ban") private Double giaBan; @Column(name = "ngay_tao") private Date ngayTao; @Column(name = "ghi_chu") private String ghiChu; public void setGioHang(GioHang gioHang) { this.gioHang = gioHang; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setSoLuongSanPham(Integer soLuongSanPham) { this.soLuongSanPham = soLuongSanPham; } public void setGiaBan(Double giaBan) { this.giaBan = giaBan; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.ChiTietGioHang)) return false;  com.datn.dongho5s.Entity.ChiTietGioHang other = (com.datn.dongho5s.Entity.ChiTietGioHang)o; if (!other.canEqual(this)) return false;  Object this$idChiTietGioHang = getIdChiTietGioHang(), other$idChiTietGioHang = other.getIdChiTietGioHang(); if ((this$idChiTietGioHang == null) ? (other$idChiTietGioHang != null) : !this$idChiTietGioHang.equals(other$idChiTietGioHang)) return false;  Object this$soLuongSanPham = getSoLuongSanPham(), other$soLuongSanPham = other.getSoLuongSanPham(); if ((this$soLuongSanPham == null) ? (other$soLuongSanPham != null) : !this$soLuongSanPham.equals(other$soLuongSanPham)) return false;  Object this$giaBan = getGiaBan(), other$giaBan = other.getGiaBan(); if ((this$giaBan == null) ? (other$giaBan != null) : !this$giaBan.equals(other$giaBan)) return false;  Object this$gioHang = getGioHang(), other$gioHang = other.getGioHang(); if ((this$gioHang == null) ? (other$gioHang != null) : !this$gioHang.equals(other$gioHang)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); if ((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); return !((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.ChiTietGioHang; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietGioHang = getIdChiTietGioHang(); result = result * 59 + (($idChiTietGioHang == null) ? 43 : $idChiTietGioHang.hashCode()); Object $soLuongSanPham = getSoLuongSanPham(); result = result * 59 + (($soLuongSanPham == null) ? 43 : $soLuongSanPham.hashCode()); Object $giaBan = getGiaBan(); result = result * 59 + (($giaBan == null) ? 43 : $giaBan.hashCode()); Object $gioHang = getGioHang(); result = result * 59 + (($gioHang == null) ? 43 : $gioHang.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); result = result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ghiChu = getGhiChu(); return result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); } public String toString() { return "ChiTietGioHang(idChiTietGioHang=" + getIdChiTietGioHang() + ", gioHang=" + getGioHang() + ", chiTietSanPham=" + getChiTietSanPham() + ", soLuongSanPham=" + getSoLuongSanPham() + ", giaBan=" + getGiaBan() + ", ngayTao=" + getNgayTao() + ", ghiChu=" + getGhiChu() + ")"; } public ChiTietGioHang(Integer idChiTietGioHang, GioHang gioHang, ChiTietSanPham chiTietSanPham, Integer soLuongSanPham, Double giaBan, Date ngayTao, String ghiChu) {
/* 20 */     this.idChiTietGioHang = idChiTietGioHang; this.gioHang = gioHang; this.chiTietSanPham = chiTietSanPham; this.soLuongSanPham = soLuongSanPham; this.giaBan = giaBan; this.ngayTao = ngayTao; this.ghiChu = ghiChu;
/*    */   } public ChiTietGioHang() {} public static ChiTietGioHangBuilder builder() {
/* 22 */     return new ChiTietGioHangBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdChiTietGioHang() {
/* 28 */     return this.idChiTietGioHang;
/*    */   }
/*    */   
/*    */   public GioHang getGioHang() {
/* 32 */     return this.gioHang;
/*    */   }
/*    */   
/*    */   public ChiTietSanPham getChiTietSanPham() {
/* 36 */     return this.chiTietSanPham;
/*    */   }
/*    */   public Integer getSoLuongSanPham() {
/* 39 */     return this.soLuongSanPham;
/*    */   }
/*    */   public Double getGiaBan() {
/* 42 */     return this.giaBan;
/*    */   }
/*    */   public Date getNgayTao() {
/* 45 */     return this.ngayTao;
/*    */   }
/*    */   public String getGhiChu() {
/* 48 */     return this.ghiChu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\ChiTietGioHang.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */