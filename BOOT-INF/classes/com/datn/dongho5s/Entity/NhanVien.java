/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ @Entity
/*     */ @Table(name = "NhanVien")
/*     */ public class NhanVien { @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Integer id; @Column(name = "ho", length = 45, nullable = false)
/*     */   private String ho; @Column(name = "ten", length = 45, nullable = false)
/*     */   private String ten; @Column(name = "gioi_tinh")
/*     */   private Integer gioiTinh;
/*     */   @Column(name = "ngay_sinh")
/*     */   private String ngaySinh;
/*     */   @Column(name = "dia_chi")
/*     */   private String diaChi;
/*     */   
/*  15 */   public NhanVien(Integer id, String ho, String ten, Integer gioiTinh, String ngaySinh, String diaChi, String soDienThoai, String email, String password, boolean enabled, String moTa, String anh, Set<ChucVu> chucVu) { this.id = id; this.ho = ho; this.ten = ten; this.gioiTinh = gioiTinh; this.ngaySinh = ngaySinh; this.diaChi = diaChi; this.soDienThoai = soDienThoai; this.email = email; this.password = password; this.enabled = enabled; this.moTa = moTa; this.anh = anh; this.chucVu = chucVu; } @Column(name = "so_dien_thoai") private String soDienThoai; @Column(name = "email", length = 128, nullable = false, unique = true) private String email; @Column(name = "mat_khau") private String password; @Column(nullable = false) private boolean enabled; @Column(name = "moTa") private String moTa; @Column(name = "anh", length = 64)
/*  16 */   private String anh; public static NhanVienBuilder builder() { return new NhanVienBuilder(); }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ManyToMany(fetch = FetchType.EAGER)
/*     */   @JoinTable(name = "nhanvien_chucvu", joinColumns = {@JoinColumn(name = "nhanvien_id")}, inverseJoinColumns = {@JoinColumn(name = "chucvu_id")})
/*  56 */   private Set<ChucVu> chucVu = new HashSet<>();
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
/*     */   public NhanVien(String ho, String ten, String email, String matKhau) {
/*  69 */     this.ho = ho;
/*  70 */     this.ten = ten;
/*  71 */     this.email = email;
/*  72 */     this.password = matKhau;
/*     */   }
/*     */   
/*     */   public Integer getId() {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getHo() {
/*  84 */     return this.ho;
/*     */   }
/*     */   
/*     */   public void setHo(String ho) {
/*  88 */     this.ho = ho;
/*     */   }
/*     */   
/*     */   public String getTen() {
/*  92 */     return this.ten;
/*     */   }
/*     */   
/*     */   public void setTen(String ten) {
/*  96 */     this.ten = ten;
/*     */   }
/*     */   
/*     */   public Integer getGioiTinh() {
/* 100 */     return this.gioiTinh;
/*     */   }
/*     */   
/*     */   public void setGioiTinh(Integer gioiTinh) {
/* 104 */     this.gioiTinh = gioiTinh;
/*     */   }
/*     */   
/*     */   public String getNgaySinh() {
/* 108 */     return this.ngaySinh;
/*     */   }
/*     */   
/*     */   public void setNgaySinh(String ngaySinh) {
/* 112 */     this.ngaySinh = ngaySinh;
/*     */   }
/*     */   
/*     */   public String getDiaChi() {
/* 116 */     return this.diaChi;
/*     */   }
/*     */   
/*     */   public void setDiaChi(String diaChi) {
/* 120 */     this.diaChi = diaChi;
/*     */   }
/*     */   
/*     */   public String getSoDienThoai() {
/* 124 */     return this.soDienThoai;
/*     */   }
/*     */   
/*     */   public void setSoDienThoai(String soDienThoai) {
/* 128 */     this.soDienThoai = soDienThoai;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 132 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 136 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getMatKhau() {
/* 140 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setMatKhau(String matKhau) {
/* 144 */     this.password = matKhau;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 181 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 185 */     this.enabled = enabled;
/*     */   }
/*     */   
/*     */   public String getMoTa() {
/* 189 */     return this.moTa;
/*     */   }
/*     */   
/*     */   public void setMoTa(String moTa) {
/* 193 */     this.moTa = moTa;
/*     */   }
/*     */   
/*     */   public String getAnh() {
/* 197 */     return this.anh;
/*     */   }
/*     */   
/*     */   public void setAnh(String anh) {
/* 201 */     this.anh = anh;
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
/*     */   public void addChucVu(ChucVu chucVu) {
/* 213 */     this.chucVu.add(chucVu);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     return "NhanVien{id=" + this.id + ", ho='" + this.ho + "', ten='" + this.ten + "', email='" + this.email + "'}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transient
/*     */   public String getPhotoImagesPath() {
/* 229 */     if (this.id == null || this.anh == null) return "/images/default-user.png";
/*     */     
/* 231 */     return "/user-photos/" + this.id + "/" + this.anh;
/*     */   }
/*     */   
/*     */   public com.datn.dongho5s.Entity.NhanVien get() {
/* 235 */     return this;
/*     */   }
/*     */   
/*     */   public NhanVien() {} }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\NhanVien.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */