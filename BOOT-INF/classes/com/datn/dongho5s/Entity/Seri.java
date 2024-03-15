/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*    */ import java.sql.Timestamp;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "seri")
/*    */ public class Seri {
/*    */   @Id
/*    */   @Column(name = "id_seri")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idSeri;
/*    */   @Column(name = "id_imei")
/*    */   private String idImei;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_chi_tiet_san_pham")
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   
/* 20 */   public void setIdSeri(Integer idSeri) { this.idSeri = idSeri; } @Column(name = "ngay_nhap") private Timestamp ngayNhap; @Column(name = "ngay_ban") private Timestamp ngayBan; @Column(name = "trang_thai") private Integer trangThai; @ManyToOne @JoinColumn(name = "id_hoa_don_chi_tiet") private HoaDonChiTiet hoaDonChiTiet; public void setIdImei(String idImei) { this.idImei = idImei; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setNgayNhap(Timestamp ngayNhap) { this.ngayNhap = ngayNhap; } public void setNgayBan(Timestamp ngayBan) { this.ngayBan = ngayBan; } public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; } public void setHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) { this.hoaDonChiTiet = hoaDonChiTiet; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.Seri)) return false;  com.datn.dongho5s.Entity.Seri other = (com.datn.dongho5s.Entity.Seri)o; if (!other.canEqual(this)) return false;  Object this$idSeri = getIdSeri(), other$idSeri = other.getIdSeri(); if ((this$idSeri == null) ? (other$idSeri != null) : !this$idSeri.equals(other$idSeri)) return false;  Object this$trangThai = getTrangThai(), other$trangThai = other.getTrangThai(); if ((this$trangThai == null) ? (other$trangThai != null) : !this$trangThai.equals(other$trangThai)) return false;  Object this$idImei = getIdImei(), other$idImei = other.getIdImei(); if ((this$idImei == null) ? (other$idImei != null) : !this$idImei.equals(other$idImei)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); if ((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)) return false;  Object this$ngayNhap = getNgayNhap(), other$ngayNhap = other.getNgayNhap(); if ((this$ngayNhap == null) ? (other$ngayNhap != null) : !this$ngayNhap.equals(other$ngayNhap)) return false;  Object this$ngayBan = getNgayBan(), other$ngayBan = other.getNgayBan(); if ((this$ngayBan == null) ? (other$ngayBan != null) : !this$ngayBan.equals(other$ngayBan)) return false;  Object this$hoaDonChiTiet = getHoaDonChiTiet(), other$hoaDonChiTiet = other.getHoaDonChiTiet(); return !((this$hoaDonChiTiet == null) ? (other$hoaDonChiTiet != null) : !this$hoaDonChiTiet.equals(other$hoaDonChiTiet)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.Seri; } public int hashCode() { int PRIME = 59; result = 1; Object $idSeri = getIdSeri(); result = result * 59 + (($idSeri == null) ? 43 : $idSeri.hashCode()); Object $trangThai = getTrangThai(); result = result * 59 + (($trangThai == null) ? 43 : $trangThai.hashCode()); Object $idImei = getIdImei(); result = result * 59 + (($idImei == null) ? 43 : $idImei.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); result = result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); Object $ngayNhap = getNgayNhap(); result = result * 59 + (($ngayNhap == null) ? 43 : $ngayNhap.hashCode()); Object $ngayBan = getNgayBan(); result = result * 59 + (($ngayBan == null) ? 43 : $ngayBan.hashCode()); Object $hoaDonChiTiet = getHoaDonChiTiet(); return result * 59 + (($hoaDonChiTiet == null) ? 43 : $hoaDonChiTiet.hashCode()); } public Seri(Integer idSeri, String idImei, ChiTietSanPham chiTietSanPham, Timestamp ngayNhap, Timestamp ngayBan, Integer trangThai, HoaDonChiTiet hoaDonChiTiet) {
/* 21 */     this.idSeri = idSeri; this.idImei = idImei; this.chiTietSanPham = chiTietSanPham; this.ngayNhap = ngayNhap; this.ngayBan = ngayBan; this.trangThai = trangThai; this.hoaDonChiTiet = hoaDonChiTiet;
/*    */   } public Seri() {}
/* 23 */   public static SeriBuilder builder() { return new SeriBuilder(); } public String toString() {
/* 24 */     return "Seri(idSeri=" + getIdSeri() + ", idImei=" + getIdImei() + ", chiTietSanPham=" + getChiTietSanPham() + ", ngayNhap=" + getNgayNhap() + ", ngayBan=" + getNgayBan() + ", trangThai=" + getTrangThai() + ", hoaDonChiTiet=" + getHoaDonChiTiet() + ")";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdSeri() {
/* 30 */     return this.idSeri;
/*    */   }
/*    */   public String getIdImei() {
/* 33 */     return this.idImei;
/*    */   }
/*    */   
/*    */   public ChiTietSanPham getChiTietSanPham() {
/* 37 */     return this.chiTietSanPham;
/*    */   }
/*    */   public Timestamp getNgayNhap() {
/* 40 */     return this.ngayNhap;
/*    */   }
/*    */   public Timestamp getNgayBan() {
/* 43 */     return this.ngayBan;
/*    */   }
/*    */   public Integer getTrangThai() {
/* 46 */     return this.trangThai;
/*    */   }
/*    */   
/*    */   public HoaDonChiTiet getHoaDonChiTiet() {
/* 50 */     return this.hoaDonChiTiet;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\Seri.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */