/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "donhang")
/*     */ public class DonHang {
/*     */   @Id
/*     */   @Column(name = "id_don_hang")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Integer idDonHang;
/*     */   @JoinColumn(name = "ma_don_hang")
/*     */   private String maDonHang;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_nhan_vien")
/*     */   private NhanVien nhanVien;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_khach_hang")
/*     */   private KhachHang khachHang;
/*     */   @Column(name = "ngay_tao")
/*     */   private Date ngayTao;
/*     */   @Column(name = "ngay_giao_hang")
/*     */   private Date ngayGiaoHang;
/*     */   @Column(name = "tong_tien")
/*     */   private Double tongTien;
/*     */   @Column(name = "trang_thai_don_hang")
/*     */   private Integer trangThaiDonHang;
/*     */   @Column(name = "id_tinh_thanh")
/*     */   private Integer idTinhThanh;
/*     */   
/*  30 */   public void setIdDonHang(Integer idDonHang) { this.idDonHang = idDonHang; } @Column(name = "id_quan_huyen") private Integer idQuanHuyen; @Column(name = "id_phuong_xa") private String idPhuongXa; @Column(name = "dia_chi") private String diaChi; @Column(name = "phi_van_chuyen") private Double phiVanChuyen; @Column(name = "ghi_chu") private String ghiChu; @Column(name = "ly_do") private String lyDo; @Column(name = "ngay_cap_nhap") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngayCapNhap; @Column(name = "phuong_thuc") private Integer phuongThuc; @OneToMany(mappedBy = "donHang", cascade = {CascadeType.ALL}) @LazyCollection(LazyCollectionOption.FALSE) @JsonIgnore private List<HoaDonChiTiet> listHoaDonChiTiet; public void setMaDonHang(String maDonHang) { this.maDonHang = maDonHang; } public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; } public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; } public void setNgayGiaoHang(Date ngayGiaoHang) { this.ngayGiaoHang = ngayGiaoHang; } public void setTongTien(Double tongTien) { this.tongTien = tongTien; } public void setTrangThaiDonHang(Integer trangThaiDonHang) { this.trangThaiDonHang = trangThaiDonHang; } public void setIdTinhThanh(Integer idTinhThanh) { this.idTinhThanh = idTinhThanh; } public void setIdQuanHuyen(Integer idQuanHuyen) { this.idQuanHuyen = idQuanHuyen; } public void setIdPhuongXa(String idPhuongXa) { this.idPhuongXa = idPhuongXa; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setPhiVanChuyen(Double phiVanChuyen) { this.phiVanChuyen = phiVanChuyen; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setLyDo(String lyDo) { this.lyDo = lyDo; } public void setNgayCapNhap(Date ngayCapNhap) { this.ngayCapNhap = ngayCapNhap; } public void setPhuongThuc(Integer phuongThuc) { this.phuongThuc = phuongThuc; } @JsonIgnore public void setListHoaDonChiTiet(List<HoaDonChiTiet> listHoaDonChiTiet) { this.listHoaDonChiTiet = listHoaDonChiTiet; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.DonHang)) return false;  com.datn.dongho5s.Entity.DonHang other = (com.datn.dongho5s.Entity.DonHang)o; if (!other.canEqual(this)) return false;  Object this$idDonHang = getIdDonHang(), other$idDonHang = other.getIdDonHang(); if ((this$idDonHang == null) ? (other$idDonHang != null) : !this$idDonHang.equals(other$idDonHang)) return false;  Object this$tongTien = getTongTien(), other$tongTien = other.getTongTien(); if ((this$tongTien == null) ? (other$tongTien != null) : !this$tongTien.equals(other$tongTien)) return false;  Object this$trangThaiDonHang = getTrangThaiDonHang(), other$trangThaiDonHang = other.getTrangThaiDonHang(); if ((this$trangThaiDonHang == null) ? (other$trangThaiDonHang != null) : !this$trangThaiDonHang.equals(other$trangThaiDonHang)) return false;  Object this$idTinhThanh = getIdTinhThanh(), other$idTinhThanh = other.getIdTinhThanh(); if ((this$idTinhThanh == null) ? (other$idTinhThanh != null) : !this$idTinhThanh.equals(other$idTinhThanh)) return false;  Object this$idQuanHuyen = getIdQuanHuyen(), other$idQuanHuyen = other.getIdQuanHuyen(); if ((this$idQuanHuyen == null) ? (other$idQuanHuyen != null) : !this$idQuanHuyen.equals(other$idQuanHuyen)) return false;  Object this$phiVanChuyen = getPhiVanChuyen(), other$phiVanChuyen = other.getPhiVanChuyen(); if ((this$phiVanChuyen == null) ? (other$phiVanChuyen != null) : !this$phiVanChuyen.equals(other$phiVanChuyen)) return false;  Object this$phuongThuc = getPhuongThuc(), other$phuongThuc = other.getPhuongThuc(); if ((this$phuongThuc == null) ? (other$phuongThuc != null) : !this$phuongThuc.equals(other$phuongThuc)) return false;  Object this$maDonHang = getMaDonHang(), other$maDonHang = other.getMaDonHang(); if ((this$maDonHang == null) ? (other$maDonHang != null) : !this$maDonHang.equals(other$maDonHang)) return false;  Object this$nhanVien = getNhanVien(), other$nhanVien = other.getNhanVien(); if ((this$nhanVien == null) ? (other$nhanVien != null) : !this$nhanVien.equals(other$nhanVien)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); if ((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ngayGiaoHang = getNgayGiaoHang(), other$ngayGiaoHang = other.getNgayGiaoHang(); if ((this$ngayGiaoHang == null) ? (other$ngayGiaoHang != null) : !this$ngayGiaoHang.equals(other$ngayGiaoHang)) return false;  Object this$idPhuongXa = getIdPhuongXa(), other$idPhuongXa = other.getIdPhuongXa(); if ((this$idPhuongXa == null) ? (other$idPhuongXa != null) : !this$idPhuongXa.equals(other$idPhuongXa)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object this$lyDo = getLyDo(), other$lyDo = other.getLyDo(); if ((this$lyDo == null) ? (other$lyDo != null) : !this$lyDo.equals(other$lyDo)) return false;  Object this$ngayCapNhap = getNgayCapNhap(), other$ngayCapNhap = other.getNgayCapNhap(); return !((this$ngayCapNhap == null) ? (other$ngayCapNhap != null) : !this$ngayCapNhap.equals(other$ngayCapNhap)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.DonHang; } public int hashCode() { int PRIME = 59; result = 1; Object $idDonHang = getIdDonHang(); result = result * 59 + (($idDonHang == null) ? 43 : $idDonHang.hashCode()); Object $tongTien = getTongTien(); result = result * 59 + (($tongTien == null) ? 43 : $tongTien.hashCode()); Object $trangThaiDonHang = getTrangThaiDonHang(); result = result * 59 + (($trangThaiDonHang == null) ? 43 : $trangThaiDonHang.hashCode()); Object $idTinhThanh = getIdTinhThanh(); result = result * 59 + (($idTinhThanh == null) ? 43 : $idTinhThanh.hashCode()); Object $idQuanHuyen = getIdQuanHuyen(); result = result * 59 + (($idQuanHuyen == null) ? 43 : $idQuanHuyen.hashCode()); Object $phiVanChuyen = getPhiVanChuyen(); result = result * 59 + (($phiVanChuyen == null) ? 43 : $phiVanChuyen.hashCode()); Object $phuongThuc = getPhuongThuc(); result = result * 59 + (($phuongThuc == null) ? 43 : $phuongThuc.hashCode()); Object $maDonHang = getMaDonHang(); result = result * 59 + (($maDonHang == null) ? 43 : $maDonHang.hashCode()); Object $nhanVien = getNhanVien(); result = result * 59 + (($nhanVien == null) ? 43 : $nhanVien.hashCode()); Object $khachHang = getKhachHang(); result = result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ngayGiaoHang = getNgayGiaoHang(); result = result * 59 + (($ngayGiaoHang == null) ? 43 : $ngayGiaoHang.hashCode()); Object $idPhuongXa = getIdPhuongXa(); result = result * 59 + (($idPhuongXa == null) ? 43 : $idPhuongXa.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object $lyDo = getLyDo(); result = result * 59 + (($lyDo == null) ? 43 : $lyDo.hashCode()); Object $ngayCapNhap = getNgayCapNhap(); return result * 59 + (($ngayCapNhap == null) ? 43 : $ngayCapNhap.hashCode()); } public String toString() { return "DonHang(idDonHang=" + getIdDonHang() + ", maDonHang=" + getMaDonHang() + ", nhanVien=" + getNhanVien() + ", khachHang=" + getKhachHang() + ", ngayTao=" + getNgayTao() + ", ngayGiaoHang=" + getNgayGiaoHang() + ", tongTien=" + getTongTien() + ", trangThaiDonHang=" + getTrangThaiDonHang() + ", idTinhThanh=" + getIdTinhThanh() + ", idQuanHuyen=" + getIdQuanHuyen() + ", idPhuongXa=" + getIdPhuongXa() + ", diaChi=" + getDiaChi() + ", phiVanChuyen=" + getPhiVanChuyen() + ", ghiChu=" + getGhiChu() + ", lyDo=" + getLyDo() + ", ngayCapNhap=" + getNgayCapNhap() + ", phuongThuc=" + getPhuongThuc() + ")"; } public DonHang(Integer idDonHang, String maDonHang, NhanVien nhanVien, KhachHang khachHang, Date ngayTao, Date ngayGiaoHang, Double tongTien, Integer trangThaiDonHang, Integer idTinhThanh, Integer idQuanHuyen, String idPhuongXa, String diaChi, Double phiVanChuyen, String ghiChu, String lyDo, Date ngayCapNhap, Integer phuongThuc, List<HoaDonChiTiet> listHoaDonChiTiet) {
/*  31 */     this.idDonHang = idDonHang; this.maDonHang = maDonHang; this.nhanVien = nhanVien; this.khachHang = khachHang; this.ngayTao = ngayTao; this.ngayGiaoHang = ngayGiaoHang; this.tongTien = tongTien; this.trangThaiDonHang = trangThaiDonHang; this.idTinhThanh = idTinhThanh; this.idQuanHuyen = idQuanHuyen; this.idPhuongXa = idPhuongXa; this.diaChi = diaChi; this.phiVanChuyen = phiVanChuyen; this.ghiChu = ghiChu; this.lyDo = lyDo; this.ngayCapNhap = ngayCapNhap; this.phuongThuc = phuongThuc; this.listHoaDonChiTiet = listHoaDonChiTiet;
/*     */   } public DonHang() {} public static DonHangBuilder builder() {
/*  33 */     return new DonHangBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getIdDonHang() {
/*  39 */     return this.idDonHang;
/*     */   }
/*     */   public String getMaDonHang() {
/*  42 */     return this.maDonHang;
/*     */   }
/*     */   
/*     */   public NhanVien getNhanVien() {
/*  46 */     return this.nhanVien;
/*     */   }
/*     */   
/*     */   public KhachHang getKhachHang() {
/*  50 */     return this.khachHang;
/*     */   }
/*     */   public Date getNgayTao() {
/*  53 */     return this.ngayTao;
/*     */   }
/*     */   public Date getNgayGiaoHang() {
/*  56 */     return this.ngayGiaoHang;
/*     */   }
/*     */   public Double getTongTien() {
/*  59 */     return this.tongTien;
/*     */   }
/*     */   public Integer getTrangThaiDonHang() {
/*  62 */     return this.trangThaiDonHang;
/*     */   }
/*     */   public Integer getIdTinhThanh() {
/*  65 */     return this.idTinhThanh;
/*     */   }
/*     */   public Integer getIdQuanHuyen() {
/*  68 */     return this.idQuanHuyen;
/*     */   }
/*     */   public String getIdPhuongXa() {
/*  71 */     return this.idPhuongXa;
/*     */   }
/*     */   public String getDiaChi() {
/*  74 */     return this.diaChi;
/*     */   }
/*     */   public Double getPhiVanChuyen() {
/*  77 */     return this.phiVanChuyen;
/*     */   }
/*     */   public String getGhiChu() {
/*  80 */     return this.ghiChu;
/*     */   }
/*     */   public String getLyDo() {
/*  83 */     return this.lyDo;
/*     */   }
/*     */   
/*     */   public Date getNgayCapNhap() {
/*  87 */     return this.ngayCapNhap;
/*     */   }
/*     */   public Integer getPhuongThuc() {
/*  90 */     return this.phuongThuc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<HoaDonChiTiet> getListHoaDonChiTiet() {
/*  98 */     return this.listHoaDonChiTiet;
/*     */   }
/*     */   public DonHang(Integer idDonHang, Date ngayTao, Double tongTien, Double phiVanChuyen) {
/* 101 */     this.idDonHang = idDonHang;
/* 102 */     this.ngayTao = ngayTao;
/*     */     
/* 104 */     this.tongTien = tongTien;
/* 105 */     this.phiVanChuyen = phiVanChuyen;
/*     */   }
/*     */   
/*     */   public DonHang(Integer idDonHang, Date ngayTao, Double tongTien, Double phiVanChuyen, Integer trangThaiDonHang) {
/* 109 */     this.idDonHang = idDonHang;
/* 110 */     this.ngayTao = ngayTao;
/*     */     
/* 112 */     this.tongTien = tongTien;
/* 113 */     this.phiVanChuyen = phiVanChuyen;
/* 114 */     this.trangThaiDonHang = trangThaiDonHang;
/*     */   }
/*     */ 
/*     */   
/*     */   public DonHang(Double phiVanChuyen) {
/* 119 */     this.phiVanChuyen = phiVanChuyen;
/*     */   }
/*     */   
/*     */   public DonHang(Integer trangThaiDonHang) {
/* 123 */     this.trangThaiDonHang = trangThaiDonHang;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\DonHang.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */