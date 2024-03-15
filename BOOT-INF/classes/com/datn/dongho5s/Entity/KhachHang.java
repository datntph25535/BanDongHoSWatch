/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DiaChi;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.security.core.GrantedAuthority;
/*     */ import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "khachhang")
/*     */ public class KhachHang implements UserDetails {
/*     */   @Id
/*     */   @Column(name = "id_khach_hang")
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Integer idKhachHang;
/*     */   @OneToMany(fetch = FetchType.EAGER, mappedBy = "khachHang", cascade = {CascadeType.ALL})
/*     */   @JsonIgnore
/*     */   private List<DiaChi> listDiaChi;
/*     */   @Column(name = "ten_khach_hang")
/*     */   private String tenKhachHang;
/*     */   @Column(name = "so_dien_thoai")
/*     */   private String soDienThoai;
/*     */   @Column(name = "email")
/*     */   private String email;
/*     */   
/*  34 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.KhachHang)) return false;  com.datn.dongho5s.Entity.KhachHang other = (com.datn.dongho5s.Entity.KhachHang)o; if (!other.canEqual(this)) return false;  if (isEnabled() != other.isEnabled()) return false;  Object this$idKhachHang = getIdKhachHang(), other$idKhachHang = other.getIdKhachHang(); if ((this$idKhachHang == null) ? (other$idKhachHang != null) : !this$idKhachHang.equals(other$idKhachHang)) return false;  Object this$gioiTinh = getGioiTinh(), other$gioiTinh = other.getGioiTinh(); if ((this$gioiTinh == null) ? (other$gioiTinh != null) : !this$gioiTinh.equals(other$gioiTinh)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$ngaySinh = getNgaySinh(), other$ngaySinh = other.getNgaySinh(); if ((this$ngaySinh == null) ? (other$ngaySinh != null) : !this$ngaySinh.equals(other$ngaySinh)) return false;  Object this$thoiGianTaoTaiKhoan = getThoiGianTaoTaiKhoan(), other$thoiGianTaoTaiKhoan = other.getThoiGianTaoTaiKhoan(); if ((this$thoiGianTaoTaiKhoan == null) ? (other$thoiGianTaoTaiKhoan != null) : !this$thoiGianTaoTaiKhoan.equals(other$thoiGianTaoTaiKhoan)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password)) return false;  Object this$ngaySua = getNgaySua(), other$ngaySua = other.getNgaySua(); return !((this$ngaySua == null) ? (other$ngaySua != null) : !this$ngaySua.equals(other$ngaySua)); } @Column(name = "ngay_sinh") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngaySinh; @Column(name = "gioi_tinh") private Integer gioiTinh; @Column(name = "thoi_gian_tao_tai_khoan") @DateTimeFormat(pattern = "yyyy-MM-dd") private Timestamp thoiGianTaoTaiKhoan; @JsonIgnore @Column(name = "password") private String password; @Column(name = "ngay_sua") @DateTimeFormat(pattern = "yyyy-MM-dd") private Date ngaySua; @Column(name = "enabled", nullable = false) private boolean enabled; protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.KhachHang; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + (isEnabled() ? 79 : 97); Object $idKhachHang = getIdKhachHang(); result = result * 59 + (($idKhachHang == null) ? 43 : $idKhachHang.hashCode()); Object $gioiTinh = getGioiTinh(); result = result * 59 + (($gioiTinh == null) ? 43 : $gioiTinh.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $ngaySinh = getNgaySinh(); result = result * 59 + (($ngaySinh == null) ? 43 : $ngaySinh.hashCode()); Object $thoiGianTaoTaiKhoan = getThoiGianTaoTaiKhoan(); result = result * 59 + (($thoiGianTaoTaiKhoan == null) ? 43 : $thoiGianTaoTaiKhoan.hashCode()); Object $password = getPassword(); result = result * 59 + (($password == null) ? 43 : $password.hashCode()); Object $ngaySua = getNgaySua(); return result * 59 + (($ngaySua == null) ? 43 : $ngaySua.hashCode()); } public String toString() { return "KhachHang(idKhachHang=" + getIdKhachHang() + ", tenKhachHang=" + getTenKhachHang() + ", soDienThoai=" + getSoDienThoai() + ", email=" + getEmail() + ", ngaySinh=" + getNgaySinh() + ", gioiTinh=" + getGioiTinh() + ", thoiGianTaoTaiKhoan=" + getThoiGianTaoTaiKhoan() + ", password=" + getPassword() + ", ngaySua=" + getNgaySua() + ", enabled=" + isEnabled() + ")"; } public KhachHang(Integer idKhachHang, List<DiaChi> listDiaChi, String tenKhachHang, String soDienThoai, String email, Date ngaySinh, Integer gioiTinh, Timestamp thoiGianTaoTaiKhoan, String password, Date ngaySua, boolean enabled) {
/*  35 */     this.idKhachHang = idKhachHang; this.listDiaChi = listDiaChi; this.tenKhachHang = tenKhachHang; this.soDienThoai = soDienThoai; this.email = email; this.ngaySinh = ngaySinh; this.gioiTinh = gioiTinh; this.thoiGianTaoTaiKhoan = thoiGianTaoTaiKhoan; this.password = password; this.ngaySua = ngaySua; this.enabled = enabled;
/*     */   } public KhachHang() {} public static KhachHangBuilder builder() {
/*  37 */     return new KhachHangBuilder();
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
/*     */   public Collection<? extends GrantedAuthority> getAuthorities() {
/*  84 */     List<SimpleGrantedAuthority> authorities = new ArrayList<>();
/*  85 */     authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
/*  86 */     return (Collection)authorities;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPassword() {
/*  91 */     return this.password;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUsername() {
/*  96 */     return this.email;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAccountNonExpired() {
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAccountNonLocked() {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCredentialsNonExpired() {
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   public Integer getIdKhachHang() {
/* 115 */     return this.idKhachHang;
/*     */   }
/*     */   
/*     */   public void setIdKhachHang(Integer idKhachHang) {
/* 119 */     this.idKhachHang = idKhachHang;
/*     */   }
/*     */   
/*     */   public List<DiaChi> getListDiaChi() {
/* 123 */     return this.listDiaChi;
/*     */   }
/*     */   
/*     */   public void setListDiaChi(List<DiaChi> listDiaChi) {
/* 127 */     this.listDiaChi = listDiaChi;
/*     */   }
/*     */   
/*     */   public String getTenKhachHang() {
/* 131 */     return this.tenKhachHang;
/*     */   }
/*     */   
/*     */   public void setTenKhachHang(String tenKhachHang) {
/* 135 */     this.tenKhachHang = tenKhachHang;
/*     */   }
/*     */   
/*     */   public String getSoDienThoai() {
/* 139 */     return this.soDienThoai;
/*     */   }
/*     */   
/*     */   public void setSoDienThoai(String soDienThoai) {
/* 143 */     this.soDienThoai = soDienThoai;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 147 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 151 */     this.email = email;
/*     */   }
/*     */   
/*     */   public Date getNgaySinh() {
/* 155 */     return this.ngaySinh;
/*     */   }
/*     */   
/*     */   public void setNgaySinh(Date ngaySinh) {
/* 159 */     this.ngaySinh = ngaySinh;
/*     */   }
/*     */   
/*     */   public Integer getGioiTinh() {
/* 163 */     return this.gioiTinh;
/*     */   }
/*     */   
/*     */   public void setGioiTinh(Integer gioiTinh) {
/* 167 */     this.gioiTinh = gioiTinh;
/*     */   }
/*     */   
/*     */   public Timestamp getThoiGianTaoTaiKhoan() {
/* 171 */     return this.thoiGianTaoTaiKhoan;
/*     */   }
/*     */   
/*     */   public void setThoiGianTaoTaiKhoan(Timestamp thoiGianTaoTaiKhoan) {
/* 175 */     this.thoiGianTaoTaiKhoan = thoiGianTaoTaiKhoan;
/*     */   }
/*     */   
/*     */   public Date getNgaySua() {
/* 179 */     return this.ngaySua;
/*     */   }
/*     */   
/*     */   public void setNgaySua(Date ngaySua) {
/* 183 */     this.ngaySua = ngaySua;
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/* 187 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean enabled) {
/* 191 */     this.enabled = enabled;
/*     */   }
/*     */   
/*     */   public com.datn.dongho5s.Entity.KhachHang get() {
/* 195 */     return this;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 199 */     this.password = password;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\KhachHang.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */