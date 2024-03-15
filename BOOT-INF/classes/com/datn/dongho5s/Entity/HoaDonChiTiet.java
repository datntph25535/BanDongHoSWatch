/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Entity.DonHang;
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ import com.datn.dongho5s.Entity.Seri;
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.ManyToOne;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "hoadonchitiet")
/*    */ public class HoaDonChiTiet {
/*    */   @Id
/*    */   @Column(name = "id_hoa_don_chi_tiet")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idHoaDonChiTiet;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_don_hang")
/*    */   @JsonIgnore
/*    */   private DonHang donHang;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_chi_tiet_san_pham")
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   
/* 27 */   public void setIdHoaDonChiTiet(Integer idHoaDonChiTiet) { this.idHoaDonChiTiet = idHoaDonChiTiet; } @Column(name = "so_luong") private Integer soLuong; @Column(name = "gia_ban") private Double giaBan; @Column(name = "chiet_khau") private Integer chietKhau; @OneToMany(mappedBy = "hoaDonChiTiet", cascade = {CascadeType.ALL}) @LazyCollection(LazyCollectionOption.FALSE) @JsonIgnore private List<Seri> listSeri; @JsonIgnore public void setDonHang(DonHang donHang) { this.donHang = donHang; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setGiaBan(Double giaBan) { this.giaBan = giaBan; } public void setChietKhau(Integer chietKhau) { this.chietKhau = chietKhau; } @JsonIgnore public void setListSeri(List<Seri> listSeri) { this.listSeri = listSeri; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.HoaDonChiTiet)) return false;  com.datn.dongho5s.Entity.HoaDonChiTiet other = (com.datn.dongho5s.Entity.HoaDonChiTiet)o; if (!other.canEqual(this)) return false;  Object this$idHoaDonChiTiet = getIdHoaDonChiTiet(), other$idHoaDonChiTiet = other.getIdHoaDonChiTiet(); if ((this$idHoaDonChiTiet == null) ? (other$idHoaDonChiTiet != null) : !this$idHoaDonChiTiet.equals(other$idHoaDonChiTiet)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$giaBan = getGiaBan(), other$giaBan = other.getGiaBan(); if ((this$giaBan == null) ? (other$giaBan != null) : !this$giaBan.equals(other$giaBan)) return false;  Object this$chietKhau = getChietKhau(), other$chietKhau = other.getChietKhau(); if ((this$chietKhau == null) ? (other$chietKhau != null) : !this$chietKhau.equals(other$chietKhau)) return false;  Object this$donHang = getDonHang(), other$donHang = other.getDonHang(); if ((this$donHang == null) ? (other$donHang != null) : !this$donHang.equals(other$donHang)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); return !((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.HoaDonChiTiet; } public int hashCode() { int PRIME = 59; result = 1; Object $idHoaDonChiTiet = getIdHoaDonChiTiet(); result = result * 59 + (($idHoaDonChiTiet == null) ? 43 : $idHoaDonChiTiet.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $giaBan = getGiaBan(); result = result * 59 + (($giaBan == null) ? 43 : $giaBan.hashCode()); Object $chietKhau = getChietKhau(); result = result * 59 + (($chietKhau == null) ? 43 : $chietKhau.hashCode()); Object $donHang = getDonHang(); result = result * 59 + (($donHang == null) ? 43 : $donHang.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); return result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); } public String toString() { return "HoaDonChiTiet(idHoaDonChiTiet=" + getIdHoaDonChiTiet() + ", donHang=" + getDonHang() + ", chiTietSanPham=" + getChiTietSanPham() + ", soLuong=" + getSoLuong() + ", giaBan=" + getGiaBan() + ", chietKhau=" + getChietKhau() + ")"; } public HoaDonChiTiet(Integer idHoaDonChiTiet, DonHang donHang, ChiTietSanPham chiTietSanPham, Integer soLuong, Double giaBan, Integer chietKhau, List<Seri> listSeri) {
/* 28 */     this.idHoaDonChiTiet = idHoaDonChiTiet; this.donHang = donHang; this.chiTietSanPham = chiTietSanPham; this.soLuong = soLuong; this.giaBan = giaBan; this.chietKhau = chietKhau; this.listSeri = listSeri;
/*    */   } public HoaDonChiTiet() {} public static HoaDonChiTietBuilder builder() {
/* 30 */     return new HoaDonChiTietBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdHoaDonChiTiet() {
/* 36 */     return this.idHoaDonChiTiet;
/*    */   }
/*    */ 
/*    */   
/*    */   public DonHang getDonHang() {
/* 41 */     return this.donHang;
/*    */   }
/*    */   
/*    */   public ChiTietSanPham getChiTietSanPham() {
/* 45 */     return this.chiTietSanPham;
/*    */   }
/*    */   public Integer getSoLuong() {
/* 48 */     return this.soLuong;
/*    */   }
/*    */   public Double getGiaBan() {
/* 51 */     return this.giaBan;
/*    */   }
/*    */   public HoaDonChiTiet(Integer idHoaDonChiTiet) {
/* 54 */     this.idHoaDonChiTiet = idHoaDonChiTiet;
/*    */   }
/*    */   public Integer getChietKhau() {
/* 57 */     return this.chietKhau;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Seri> getListSeri() {
/* 64 */     return this.listSeri;
/*    */   }
/*    */   public HoaDonChiTiet(String tenDanhMuc, Integer soLuong, Double giaBan, Double phiVanChuyen) {
/* 67 */     this.chiTietSanPham = new ChiTietSanPham();
/* 68 */     this.chiTietSanPham.setSanPham(new SanPham());
/* 69 */     this.chiTietSanPham.getSanPham().setDanhMuc(new DanhMuc(tenDanhMuc));
/* 70 */     this.soLuong = soLuong;
/* 71 */     this.giaBan = giaBan;
/* 72 */     setDonHang(new DonHang(phiVanChuyen));
/*    */   }
/*    */   
/*    */   public HoaDonChiTiet(Integer soLuong, String tenSanPham, Double giaBan, Double phiVanChuyen) {
/* 76 */     this.soLuong = soLuong;
/* 77 */     this.chiTietSanPham = new ChiTietSanPham();
/* 78 */     this.chiTietSanPham.setSanPham(new SanPham(tenSanPham));
/* 79 */     this.giaBan = giaBan;
/* 80 */     setDonHang(new DonHang(phiVanChuyen));
/*    */   }
/*    */   
/*    */   public HoaDonChiTiet(Integer idHoaDonChiTiet, Integer soLuong, Double giaBan, Double phiVanChuyen) {
/* 84 */     this.idHoaDonChiTiet = idHoaDonChiTiet;
/* 85 */     this.soLuong = soLuong;
/* 86 */     this.giaBan = giaBan;
/* 87 */     setDonHang(new DonHang(phiVanChuyen));
/*    */   }
/*    */   
/*    */   public HoaDonChiTiet(ChiTietSanPham chiTietSanPham) {
/* 91 */     this.chiTietSanPham = chiTietSanPham;
/*    */   }
/*    */   
/*    */   public HoaDonChiTiet(DonHang donHang) {
/* 95 */     this.donHang = donHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\HoaDonChiTiet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */