/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ @Entity
/*    */ @Table(name = "chitietsanpham")
/*    */ public class ChiTietSanPham {
/*    */   @Id
/*    */   @Column(name = "id_chi_tiet_san_pham")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idChiTietSanPham;
/*    */   @JoinColumn(name = "ma_chi_tiet_san_pham")
/*    */   private String maChiTietSanPham;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_san_pham")
/*    */   private SanPham sanPham;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_day_deo")
/*    */   private DayDeo dayDeo;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_khuyen_mai")
/*    */   private KhuyenMai khuyenMai;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_mau_sac")
/*    */   private MauSac mauSac;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_vat_lieu")
/*    */   private VatLieu vatLieu;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_kich_co")
/*    */   private KichCo kichCo;
/*    */   
/* 30 */   public void setIdChiTietSanPham(Integer idChiTietSanPham) { this.idChiTietSanPham = idChiTietSanPham; } @Column(name = "chieu_dai_day_deo") private Double chieuDaiDayDeo; @Column(name = "duong_kinh_mat_dong_ho") private Double duongKinhMatDongHo; @Column(name = "do_day_mat_dong_ho") private Double doDayMatDongHo; @Column(name = "do_chiu_nuoc") private Integer doChiuNuoc; @Column(name = "trang_thai") private Integer trangThai; @Column(name = "gia_san_pham") private Double giaSanPham; @Column(name = "so_luong") private Integer soLuong; @OneToMany(mappedBy = "chiTietSanPham", cascade = {CascadeType.ALL}) @LazyCollection(LazyCollectionOption.FALSE) @JsonIgnore private List<PhanHoi> listPhanHoi; public void setMaChiTietSanPham(String maChiTietSanPham) { this.maChiTietSanPham = maChiTietSanPham; } public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; } public void setDayDeo(DayDeo dayDeo) { this.dayDeo = dayDeo; } public void setKhuyenMai(KhuyenMai khuyenMai) { this.khuyenMai = khuyenMai; } public void setMauSac(MauSac mauSac) { this.mauSac = mauSac; } public void setVatLieu(VatLieu vatLieu) { this.vatLieu = vatLieu; } public void setKichCo(KichCo kichCo) { this.kichCo = kichCo; } public void setChieuDaiDayDeo(Double chieuDaiDayDeo) { this.chieuDaiDayDeo = chieuDaiDayDeo; } public void setDuongKinhMatDongHo(Double duongKinhMatDongHo) { this.duongKinhMatDongHo = duongKinhMatDongHo; } public void setDoDayMatDongHo(Double doDayMatDongHo) { this.doDayMatDongHo = doDayMatDongHo; } public void setDoChiuNuoc(Integer doChiuNuoc) { this.doChiuNuoc = doChiuNuoc; } public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } @JsonIgnore public void setListPhanHoi(List<PhanHoi> listPhanHoi) { this.listPhanHoi = listPhanHoi; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.ChiTietSanPham)) return false;  com.datn.dongho5s.Entity.ChiTietSanPham other = (com.datn.dongho5s.Entity.ChiTietSanPham)o; if (!other.canEqual(this)) return false;  Object this$idChiTietSanPham = getIdChiTietSanPham(), other$idChiTietSanPham = other.getIdChiTietSanPham(); if ((this$idChiTietSanPham == null) ? (other$idChiTietSanPham != null) : !this$idChiTietSanPham.equals(other$idChiTietSanPham)) return false;  Object this$chieuDaiDayDeo = getChieuDaiDayDeo(), other$chieuDaiDayDeo = other.getChieuDaiDayDeo(); if ((this$chieuDaiDayDeo == null) ? (other$chieuDaiDayDeo != null) : !this$chieuDaiDayDeo.equals(other$chieuDaiDayDeo)) return false;  Object this$duongKinhMatDongHo = getDuongKinhMatDongHo(), other$duongKinhMatDongHo = other.getDuongKinhMatDongHo(); if ((this$duongKinhMatDongHo == null) ? (other$duongKinhMatDongHo != null) : !this$duongKinhMatDongHo.equals(other$duongKinhMatDongHo)) return false;  Object this$doDayMatDongHo = getDoDayMatDongHo(), other$doDayMatDongHo = other.getDoDayMatDongHo(); if ((this$doDayMatDongHo == null) ? (other$doDayMatDongHo != null) : !this$doDayMatDongHo.equals(other$doDayMatDongHo)) return false;  Object this$doChiuNuoc = getDoChiuNuoc(), other$doChiuNuoc = other.getDoChiuNuoc(); if ((this$doChiuNuoc == null) ? (other$doChiuNuoc != null) : !this$doChiuNuoc.equals(other$doChiuNuoc)) return false;  Object this$trangThai = getTrangThai(), other$trangThai = other.getTrangThai(); if ((this$trangThai == null) ? (other$trangThai != null) : !this$trangThai.equals(other$trangThai)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); if ((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$maChiTietSanPham = getMaChiTietSanPham(), other$maChiTietSanPham = other.getMaChiTietSanPham(); if ((this$maChiTietSanPham == null) ? (other$maChiTietSanPham != null) : !this$maChiTietSanPham.equals(other$maChiTietSanPham)) return false;  Object this$sanPham = getSanPham(), other$sanPham = other.getSanPham(); if ((this$sanPham == null) ? (other$sanPham != null) : !this$sanPham.equals(other$sanPham)) return false;  Object this$dayDeo = getDayDeo(), other$dayDeo = other.getDayDeo(); if ((this$dayDeo == null) ? (other$dayDeo != null) : !this$dayDeo.equals(other$dayDeo)) return false;  Object this$khuyenMai = getKhuyenMai(), other$khuyenMai = other.getKhuyenMai(); if ((this$khuyenMai == null) ? (other$khuyenMai != null) : !this$khuyenMai.equals(other$khuyenMai)) return false;  Object this$mauSac = getMauSac(), other$mauSac = other.getMauSac(); if ((this$mauSac == null) ? (other$mauSac != null) : !this$mauSac.equals(other$mauSac)) return false;  Object this$vatLieu = getVatLieu(), other$vatLieu = other.getVatLieu(); if ((this$vatLieu == null) ? (other$vatLieu != null) : !this$vatLieu.equals(other$vatLieu)) return false;  Object this$kichCo = getKichCo(), other$kichCo = other.getKichCo(); return !((this$kichCo == null) ? (other$kichCo != null) : !this$kichCo.equals(other$kichCo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.ChiTietSanPham; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietSanPham = getIdChiTietSanPham(); result = result * 59 + (($idChiTietSanPham == null) ? 43 : $idChiTietSanPham.hashCode()); Object $chieuDaiDayDeo = getChieuDaiDayDeo(); result = result * 59 + (($chieuDaiDayDeo == null) ? 43 : $chieuDaiDayDeo.hashCode()); Object $duongKinhMatDongHo = getDuongKinhMatDongHo(); result = result * 59 + (($duongKinhMatDongHo == null) ? 43 : $duongKinhMatDongHo.hashCode()); Object $doDayMatDongHo = getDoDayMatDongHo(); result = result * 59 + (($doDayMatDongHo == null) ? 43 : $doDayMatDongHo.hashCode()); Object $doChiuNuoc = getDoChiuNuoc(); result = result * 59 + (($doChiuNuoc == null) ? 43 : $doChiuNuoc.hashCode()); Object $trangThai = getTrangThai(); result = result * 59 + (($trangThai == null) ? 43 : $trangThai.hashCode()); Object $giaSanPham = getGiaSanPham(); result = result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $maChiTietSanPham = getMaChiTietSanPham(); result = result * 59 + (($maChiTietSanPham == null) ? 43 : $maChiTietSanPham.hashCode()); Object $sanPham = getSanPham(); result = result * 59 + (($sanPham == null) ? 43 : $sanPham.hashCode()); Object $dayDeo = getDayDeo(); result = result * 59 + (($dayDeo == null) ? 43 : $dayDeo.hashCode()); Object $khuyenMai = getKhuyenMai(); result = result * 59 + (($khuyenMai == null) ? 43 : $khuyenMai.hashCode()); Object $mauSac = getMauSac(); result = result * 59 + (($mauSac == null) ? 43 : $mauSac.hashCode()); Object $vatLieu = getVatLieu(); result = result * 59 + (($vatLieu == null) ? 43 : $vatLieu.hashCode()); Object $kichCo = getKichCo(); return result * 59 + (($kichCo == null) ? 43 : $kichCo.hashCode()); }
/* 31 */   public static ChiTietSanPhamBuilder builder() { return new ChiTietSanPhamBuilder(); } public ChiTietSanPham(Integer idChiTietSanPham, String maChiTietSanPham, SanPham sanPham, DayDeo dayDeo, KhuyenMai khuyenMai, MauSac mauSac, VatLieu vatLieu, KichCo kichCo, Double chieuDaiDayDeo, Double duongKinhMatDongHo, Double doDayMatDongHo, Integer doChiuNuoc, Integer trangThai, Double giaSanPham, Integer soLuong, List<PhanHoi> listPhanHoi) {
/* 32 */     this.idChiTietSanPham = idChiTietSanPham; this.maChiTietSanPham = maChiTietSanPham; this.sanPham = sanPham; this.dayDeo = dayDeo; this.khuyenMai = khuyenMai; this.mauSac = mauSac; this.vatLieu = vatLieu; this.kichCo = kichCo; this.chieuDaiDayDeo = chieuDaiDayDeo; this.duongKinhMatDongHo = duongKinhMatDongHo; this.doDayMatDongHo = doDayMatDongHo; this.doChiuNuoc = doChiuNuoc; this.trangThai = trangThai; this.giaSanPham = giaSanPham; this.soLuong = soLuong; this.listPhanHoi = listPhanHoi;
/*    */   } public ChiTietSanPham() {} public String toString() {
/* 34 */     return "ChiTietSanPham(idChiTietSanPham=" + getIdChiTietSanPham() + ", maChiTietSanPham=" + getMaChiTietSanPham() + ", sanPham=" + getSanPham() + ", dayDeo=" + getDayDeo() + ", khuyenMai=" + getKhuyenMai() + ", mauSac=" + getMauSac() + ", vatLieu=" + getVatLieu() + ", kichCo=" + getKichCo() + ", chieuDaiDayDeo=" + getChieuDaiDayDeo() + ", duongKinhMatDongHo=" + getDuongKinhMatDongHo() + ", doDayMatDongHo=" + getDoDayMatDongHo() + ", doChiuNuoc=" + getDoChiuNuoc() + ", trangThai=" + getTrangThai() + ", giaSanPham=" + getGiaSanPham() + ", soLuong=" + getSoLuong() + ")";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdChiTietSanPham() {
/* 40 */     return this.idChiTietSanPham;
/*    */   }
/*    */   public String getMaChiTietSanPham() {
/* 43 */     return this.maChiTietSanPham;
/*    */   }
/*    */   
/*    */   public SanPham getSanPham() {
/* 47 */     return this.sanPham;
/*    */   }
/*    */   
/*    */   public DayDeo getDayDeo() {
/* 51 */     return this.dayDeo;
/*    */   }
/*    */   
/*    */   public KhuyenMai getKhuyenMai() {
/* 55 */     return this.khuyenMai;
/*    */   }
/*    */   
/*    */   public MauSac getMauSac() {
/* 59 */     return this.mauSac;
/*    */   }
/*    */   
/*    */   public VatLieu getVatLieu() {
/* 63 */     return this.vatLieu;
/*    */   }
/*    */   
/*    */   public KichCo getKichCo() {
/* 67 */     return this.kichCo;
/*    */   }
/*    */   public Double getChieuDaiDayDeo() {
/* 70 */     return this.chieuDaiDayDeo;
/*    */   }
/*    */   public Double getDuongKinhMatDongHo() {
/* 73 */     return this.duongKinhMatDongHo;
/*    */   }
/*    */   public Double getDoDayMatDongHo() {
/* 76 */     return this.doDayMatDongHo;
/*    */   }
/*    */   public Integer getDoChiuNuoc() {
/* 79 */     return this.doChiuNuoc;
/*    */   }
/*    */   public Integer getTrangThai() {
/* 82 */     return this.trangThai;
/*    */   }
/*    */   public Double getGiaSanPham() {
/* 85 */     return this.giaSanPham;
/*    */   }
/*    */   public Integer getSoLuong() {
/* 88 */     return this.soLuong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<PhanHoi> getListPhanHoi() {
/* 95 */     return this.listPhanHoi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\ChiTietSanPham.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */