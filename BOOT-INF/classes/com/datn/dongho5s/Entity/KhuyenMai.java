/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ @Entity
/*     */ @Table(name = "khuyenmai")
/*     */ public class KhuyenMai { @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id_khuyen_mai")
/*     */   private Integer idKhuyenMai; @Column(name = "ma_khuyen_mai", unique = true)
/*     */   private String maKhuyenMai;
/*     */   @Column(name = "ten_khuyen_mai", unique = true)
/*     */   private String tenKhuyenMai;
/*     */   @Column(name = "mo_ta_khuyen_mai")
/*     */   private String moTaKhuyenMai;
/*     */   
/*  14 */   public void setChietKhau(Integer chietKhau) { this.chietKhau = chietKhau; } @Column(name = "ngay_bat_dau") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngayBatDau; @Column(name = "ngay_ket_thuc") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngayKetThuc; @Column(name = "ngay_sua") private Date ngaySua; @Column(name = "enabled", nullable = false) private boolean enabled; @Column(name = "chiet_khau") private Integer chietKhau; public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.KhuyenMai)) return false;  com.datn.dongho5s.Entity.KhuyenMai other = (com.datn.dongho5s.Entity.KhuyenMai)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idKhuyenMai = getIdKhuyenMai(), other$idKhuyenMai = other.getIdKhuyenMai(); if ((this$idKhuyenMai == null) ? (other$idKhuyenMai != null) : !this$idKhuyenMai.equals(other$idKhuyenMai)) return false;  Object this$chietKhau = getChietKhau(), other$chietKhau = other.getChietKhau(); if ((this$chietKhau == null) ? (other$chietKhau != null) : !this$chietKhau.equals(other$chietKhau)) return false;  Object this$maKhuyenMai = getMaKhuyenMai(), other$maKhuyenMai = other.getMaKhuyenMai(); if ((this$maKhuyenMai == null) ? (other$maKhuyenMai != null) : !this$maKhuyenMai.equals(other$maKhuyenMai)) return false;  Object this$tenKhuyenMai = getTenKhuyenMai(), other$tenKhuyenMai = other.getTenKhuyenMai(); if ((this$tenKhuyenMai == null) ? (other$tenKhuyenMai != null) : !this$tenKhuyenMai.equals(other$tenKhuyenMai)) return false;  Object this$moTaKhuyenMai = getMoTaKhuyenMai(), other$moTaKhuyenMai = other.getMoTaKhuyenMai(); if ((this$moTaKhuyenMai == null) ? (other$moTaKhuyenMai != null) : !this$moTaKhuyenMai.equals(other$moTaKhuyenMai)) return false;  Object this$ngayBatDau = getNgayBatDau(), other$ngayBatDau = other.getNgayBatDau(); if ((this$ngayBatDau == null) ? (other$ngayBatDau != null) : !this$ngayBatDau.equals(other$ngayBatDau)) return false;  Object this$ngayKetThuc = getNgayKetThuc(), other$ngayKetThuc = other.getNgayKetThuc(); if ((this$ngayKetThuc == null) ? (other$ngayKetThuc != null) : !this$ngayKetThuc.equals(other$ngayKetThuc)) return false;  Object this$ngaySua = getNgaySua(), other$ngaySua = other.getNgaySua(); return !((this$ngaySua == null) ? (other$ngaySua != null) : !this$ngaySua.equals(other$ngaySua)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.KhuyenMai; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idKhuyenMai = getIdKhuyenMai(); result = result * 59 + (($idKhuyenMai == null) ? 43 : $idKhuyenMai.hashCode()); Object $chietKhau = getChietKhau(); result = result * 59 + (($chietKhau == null) ? 43 : $chietKhau.hashCode()); Object $maKhuyenMai = getMaKhuyenMai(); result = result * 59 + (($maKhuyenMai == null) ? 43 : $maKhuyenMai.hashCode()); Object $tenKhuyenMai = getTenKhuyenMai(); result = result * 59 + (($tenKhuyenMai == null) ? 43 : $tenKhuyenMai.hashCode()); Object $moTaKhuyenMai = getMoTaKhuyenMai(); result = result * 59 + (($moTaKhuyenMai == null) ? 43 : $moTaKhuyenMai.hashCode()); Object $ngayBatDau = getNgayBatDau(); result = result * 59 + (($ngayBatDau == null) ? 43 : $ngayBatDau.hashCode()); Object $ngayKetThuc = getNgayKetThuc(); result = result * 59 + (($ngayKetThuc == null) ? 43 : $ngayKetThuc.hashCode()); Object $ngaySua = getNgaySua(); return result * 59 + (($ngaySua == null) ? 43 : $ngaySua.hashCode()); } public String toString() { return "KhuyenMai(idKhuyenMai=" + getIdKhuyenMai() + ", maKhuyenMai=" + getMaKhuyenMai() + ", tenKhuyenMai=" + getTenKhuyenMai() + ", moTaKhuyenMai=" + getMoTaKhuyenMai() + ", ngayBatDau=" + getNgayBatDau() + ", ngayKetThuc=" + getNgayKetThuc() + ", ngaySua=" + getNgaySua() + ", enabled=" + isEnabled() + ", chietKhau=" + getChietKhau() + ")"; } public KhuyenMai(Integer idKhuyenMai, String maKhuyenMai, String tenKhuyenMai, String moTaKhuyenMai, Date ngayBatDau, Date ngayKetThuc, Date ngaySua, boolean enabled, Integer chietKhau) {
/*  15 */     this.idKhuyenMai = idKhuyenMai; this.maKhuyenMai = maKhuyenMai; this.tenKhuyenMai = tenKhuyenMai; this.moTaKhuyenMai = moTaKhuyenMai; this.ngayBatDau = ngayBatDau; this.ngayKetThuc = ngayKetThuc; this.ngaySua = ngaySua; this.enabled = enabled; this.chietKhau = chietKhau;
/*     */   } public KhuyenMai() {} public static KhuyenMaiBuilder builder() {
/*  17 */     return new KhuyenMaiBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getChietKhau() {
/*  50 */     return this.chietKhau;
/*     */   }
/*     */   
/*     */   public Integer getIdKhuyenMai() {
/*  54 */     return this.idKhuyenMai;
/*     */   }
/*     */   
/*     */   public void setIdKhuyenMai(Integer idKhuyenMai) {
/*  58 */     this.idKhuyenMai = idKhuyenMai;
/*     */   }
/*     */   
/*     */   public String getMaKhuyenMai() {
/*  62 */     return this.maKhuyenMai;
/*     */   }
/*     */   
/*     */   public void setMaKhuyenMai(String maKhuyenMai) {
/*  66 */     this.maKhuyenMai = maKhuyenMai;
/*     */   }
/*     */   
/*     */   public String getTenKhuyenMai() {
/*  70 */     return this.tenKhuyenMai;
/*     */   }
/*     */   
/*     */   public void setTenKhuyenMai(String tenKhuyenMai) {
/*  74 */     this.tenKhuyenMai = tenKhuyenMai;
/*     */   }
/*     */   
/*     */   public String getMoTaKhuyenMai() {
/*  78 */     return this.moTaKhuyenMai;
/*     */   }
/*     */   
/*     */   public void setMoTaKhuyenMai(String moTaKhuyenMai) {
/*  82 */     this.moTaKhuyenMai = moTaKhuyenMai;
/*     */   }
/*     */   
/*     */   public Date getNgayBatDau() {
/*  86 */     return this.ngayBatDau;
/*     */   }
/*     */   
/*     */   public void setNgayBatDau(Date ngayBatDau) {
/*  90 */     this.ngayBatDau = ngayBatDau;
/*     */   }
/*     */   
/*     */   public Date getNgayKetThuc() {
/*  94 */     return this.ngayKetThuc;
/*     */   }
/*     */   
/*     */   public void setNgayKetThuc(Date ngayKetThuc) {
/*  98 */     this.ngayKetThuc = ngayKetThuc;
/*     */   }
/*     */   
/*     */   public Date getNgaySua() {
/* 102 */     return this.ngaySua;
/*     */   }
/*     */   
/*     */   public void setNgaySua(Date ngaySua) {
/* 106 */     this.ngaySua = ngaySua;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 110 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 114 */     this.enabled = enabled;
/*     */   } }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\KhuyenMai.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */