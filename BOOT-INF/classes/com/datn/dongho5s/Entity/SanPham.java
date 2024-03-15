/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ @Entity
/*    */ @Table(name = "sanpham")
/*    */ public class SanPham { public static final int HOAT_DONG = 1; public static final int KHONG_HOAT_DONG = 0; @Id
/*    */   @Column(name = "id_san_pham")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idSanPham;
/*    */   @JoinColumn(name = "ma_san_pham")
/*    */   private String maSanPham;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_thuong_hieu")
/*    */   private ThuongHieu thuongHieu;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_danh_muc")
/*    */   private DanhMuc danhMuc;
/*    */   
/* 17 */   public void setIdSanPham(Integer idSanPham) { this.idSanPham = idSanPham; } @Column(name = "ten_san_pham") private String tenSanPham; @Column(name = "mo_ta_san_pham") private String moTaSanPham; @Column(name = "trang_thai") private Integer trangThai; @OneToMany(fetch = FetchType.EAGER, mappedBy = "sanPham", cascade = {CascadeType.ALL}) @JsonIgnore private List<ChiTietSanPham> listChiTietSanPham; @OneToMany(mappedBy = "sanPham", cascade = {CascadeType.ALL}) private List<AnhSanPham> listAnhSanPham; @Column(name = "main_image", nullable = false) private String mainImage; @Transient private String currentMainImage; public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; } public void setThuongHieu(ThuongHieu thuongHieu) { this.thuongHieu = thuongHieu; } public void setDanhMuc(DanhMuc danhMuc) { this.danhMuc = danhMuc; } public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; } public void setMoTaSanPham(String moTaSanPham) { this.moTaSanPham = moTaSanPham; } public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; } @JsonIgnore public void setListChiTietSanPham(List<ChiTietSanPham> listChiTietSanPham) { this.listChiTietSanPham = listChiTietSanPham; } public void setListAnhSanPham(List<AnhSanPham> listAnhSanPham) { this.listAnhSanPham = listAnhSanPham; } public void setMainImage(String mainImage) { this.mainImage = mainImage; } public void setCurrentMainImage(String currentMainImage) { this.currentMainImage = currentMainImage; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.SanPham)) return false;  com.datn.dongho5s.Entity.SanPham other = (com.datn.dongho5s.Entity.SanPham)o; if (!other.canEqual(this)) return false;  Object this$idSanPham = getIdSanPham(), other$idSanPham = other.getIdSanPham(); if ((this$idSanPham == null) ? (other$idSanPham != null) : !this$idSanPham.equals(other$idSanPham)) return false;  Object this$trangThai = getTrangThai(), other$trangThai = other.getTrangThai(); if ((this$trangThai == null) ? (other$trangThai != null) : !this$trangThai.equals(other$trangThai)) return false;  Object this$maSanPham = getMaSanPham(), other$maSanPham = other.getMaSanPham(); if ((this$maSanPham == null) ? (other$maSanPham != null) : !this$maSanPham.equals(other$maSanPham)) return false;  Object this$thuongHieu = getThuongHieu(), other$thuongHieu = other.getThuongHieu(); if ((this$thuongHieu == null) ? (other$thuongHieu != null) : !this$thuongHieu.equals(other$thuongHieu)) return false;  Object this$danhMuc = getDanhMuc(), other$danhMuc = other.getDanhMuc(); if ((this$danhMuc == null) ? (other$danhMuc != null) : !this$danhMuc.equals(other$danhMuc)) return false;  Object this$tenSanPham = getTenSanPham(), other$tenSanPham = other.getTenSanPham(); if ((this$tenSanPham == null) ? (other$tenSanPham != null) : !this$tenSanPham.equals(other$tenSanPham)) return false;  Object this$moTaSanPham = getMoTaSanPham(), other$moTaSanPham = other.getMoTaSanPham(); if ((this$moTaSanPham == null) ? (other$moTaSanPham != null) : !this$moTaSanPham.equals(other$moTaSanPham)) return false;  Object<AnhSanPham> this$listAnhSanPham = (Object<AnhSanPham>)getListAnhSanPham(), other$listAnhSanPham = (Object<AnhSanPham>)other.getListAnhSanPham(); if ((this$listAnhSanPham == null) ? (other$listAnhSanPham != null) : !this$listAnhSanPham.equals(other$listAnhSanPham)) return false;  Object this$mainImage = getMainImage(), other$mainImage = other.getMainImage(); if ((this$mainImage == null) ? (other$mainImage != null) : !this$mainImage.equals(other$mainImage)) return false;  Object this$currentMainImage = getCurrentMainImage(), other$currentMainImage = other.getCurrentMainImage(); return !((this$currentMainImage == null) ? (other$currentMainImage != null) : !this$currentMainImage.equals(other$currentMainImage)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.SanPham; } public int hashCode() { int PRIME = 59; result = 1; Object $idSanPham = getIdSanPham(); result = result * 59 + (($idSanPham == null) ? 43 : $idSanPham.hashCode()); Object $trangThai = getTrangThai(); result = result * 59 + (($trangThai == null) ? 43 : $trangThai.hashCode()); Object $maSanPham = getMaSanPham(); result = result * 59 + (($maSanPham == null) ? 43 : $maSanPham.hashCode()); Object $thuongHieu = getThuongHieu(); result = result * 59 + (($thuongHieu == null) ? 43 : $thuongHieu.hashCode()); Object $danhMuc = getDanhMuc(); result = result * 59 + (($danhMuc == null) ? 43 : $danhMuc.hashCode()); Object $tenSanPham = getTenSanPham(); result = result * 59 + (($tenSanPham == null) ? 43 : $tenSanPham.hashCode()); Object $moTaSanPham = getMoTaSanPham(); result = result * 59 + (($moTaSanPham == null) ? 43 : $moTaSanPham.hashCode()); Object<AnhSanPham> $listAnhSanPham = (Object<AnhSanPham>)getListAnhSanPham(); result = result * 59 + (($listAnhSanPham == null) ? 43 : $listAnhSanPham.hashCode()); Object $mainImage = getMainImage(); result = result * 59 + (($mainImage == null) ? 43 : $mainImage.hashCode()); Object $currentMainImage = getCurrentMainImage(); return result * 59 + (($currentMainImage == null) ? 43 : $currentMainImage.hashCode()); } public String toString() { return "SanPham(idSanPham=" + getIdSanPham() + ", maSanPham=" + getMaSanPham() + ", thuongHieu=" + getThuongHieu() + ", danhMuc=" + getDanhMuc() + ", tenSanPham=" + getTenSanPham() + ", moTaSanPham=" + getMoTaSanPham() + ", trangThai=" + getTrangThai() + ", listAnhSanPham=" + getListAnhSanPham() + ", mainImage=" + getMainImage() + ", currentMainImage=" + getCurrentMainImage() + ")"; } public SanPham(Integer idSanPham, String maSanPham, ThuongHieu thuongHieu, DanhMuc danhMuc, String tenSanPham, String moTaSanPham, Integer trangThai, List<ChiTietSanPham> listChiTietSanPham, List<AnhSanPham> listAnhSanPham, String mainImage, String currentMainImage) {
/* 18 */     this.idSanPham = idSanPham; this.maSanPham = maSanPham; this.thuongHieu = thuongHieu; this.danhMuc = danhMuc; this.tenSanPham = tenSanPham; this.moTaSanPham = moTaSanPham; this.trangThai = trangThai; this.listChiTietSanPham = listChiTietSanPham; this.listAnhSanPham = listAnhSanPham; this.mainImage = mainImage; this.currentMainImage = currentMainImage;
/*    */   } public SanPham() {} public static SanPhamBuilder builder() {
/* 20 */     return new SanPhamBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdSanPham() {
/* 28 */     return this.idSanPham;
/*    */   }
/*    */   public String getMaSanPham() {
/* 31 */     return this.maSanPham;
/*    */   }
/*    */   
/*    */   public ThuongHieu getThuongHieu() {
/* 35 */     return this.thuongHieu;
/*    */   }
/*    */   
/*    */   public DanhMuc getDanhMuc() {
/* 39 */     return this.danhMuc;
/*    */   }
/*    */   public String getTenSanPham() {
/* 42 */     return this.tenSanPham;
/*    */   }
/*    */   public String getMoTaSanPham() {
/* 45 */     return this.moTaSanPham;
/*    */   }
/*    */   public Integer getTrangThai() {
/* 48 */     return this.trangThai;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<ChiTietSanPham> getListChiTietSanPham() {
/* 54 */     return this.listChiTietSanPham;
/*    */   }
/*    */   
/*    */   public List<AnhSanPham> getListAnhSanPham() {
/* 58 */     return this.listAnhSanPham;
/*    */   }
/*    */   
/*    */   public String getMainImage() {
/* 62 */     return this.mainImage;
/*    */   }
/*    */   
/*    */   public void addExtraImage(String imageName) {
/* 66 */     this.listAnhSanPham.add(new AnhSanPham(imageName, this));
/*    */   }
/*    */   
/*    */   @Transient
/*    */   public String getMainImagePath() {
/* 71 */     if (this.idSanPham == null || this.mainImage == null) return "/assets/images/image-thumbnail.png"; 
/* 72 */     return "/assets/images/" + ((AnhSanPham)this.listAnhSanPham.get(0)).getLink();
/*    */   }
/*    */   
/*    */   public String getCurrentMainImage() {
/* 76 */     return this.currentMainImage;
/*    */   }
/*    */   public SanPham(String tenSanPham) {
/* 79 */     this.tenSanPham = tenSanPham;
/*    */   } }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\SanPham.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */