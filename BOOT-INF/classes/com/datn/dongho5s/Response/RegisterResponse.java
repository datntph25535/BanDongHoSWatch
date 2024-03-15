/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RegisterResponse {
/*    */   private Integer idKhachHang;
/*    */   private String tenKhachHang;
/*    */   private String soDienThoai;
/*    */   
/*    */   public void setIdKhachHang(Integer idKhachHang) {
/* 11 */     this.idKhachHang = idKhachHang; } private String email; private Date ngaySinh; private Integer gioiTinh; private String matKhau; public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; } public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setEmail(String email) { this.email = email; } public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; } public void setGioiTinh(Integer gioiTinh) { this.gioiTinh = gioiTinh; } public void setMatKhau(String matKhau) { this.matKhau = matKhau; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.RegisterResponse)) return false;  com.datn.dongho5s.Response.RegisterResponse other = (com.datn.dongho5s.Response.RegisterResponse)o; if (!other.canEqual(this)) return false;  Object this$idKhachHang = getIdKhachHang(), other$idKhachHang = other.getIdKhachHang(); if ((this$idKhachHang == null) ? (other$idKhachHang != null) : !this$idKhachHang.equals(other$idKhachHang)) return false;  Object this$gioiTinh = getGioiTinh(), other$gioiTinh = other.getGioiTinh(); if ((this$gioiTinh == null) ? (other$gioiTinh != null) : !this$gioiTinh.equals(other$gioiTinh)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$ngaySinh = getNgaySinh(), other$ngaySinh = other.getNgaySinh(); if ((this$ngaySinh == null) ? (other$ngaySinh != null) : !this$ngaySinh.equals(other$ngaySinh)) return false;  Object this$matKhau = getMatKhau(), other$matKhau = other.getMatKhau(); return !((this$matKhau == null) ? (other$matKhau != null) : !this$matKhau.equals(other$matKhau)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.RegisterResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idKhachHang = getIdKhachHang(); result = result * 59 + (($idKhachHang == null) ? 43 : $idKhachHang.hashCode()); Object $gioiTinh = getGioiTinh(); result = result * 59 + (($gioiTinh == null) ? 43 : $gioiTinh.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $ngaySinh = getNgaySinh(); result = result * 59 + (($ngaySinh == null) ? 43 : $ngaySinh.hashCode()); Object $matKhau = getMatKhau(); return result * 59 + (($matKhau == null) ? 43 : $matKhau.hashCode()); } public String toString() { return "RegisterResponse(idKhachHang=" + getIdKhachHang() + ", tenKhachHang=" + getTenKhachHang() + ", soDienThoai=" + getSoDienThoai() + ", email=" + getEmail() + ", ngaySinh=" + getNgaySinh() + ", gioiTinh=" + getGioiTinh() + ", matKhau=" + getMatKhau() + ")"; } public RegisterResponse(Integer idKhachHang, String tenKhachHang, String soDienThoai, String email, Date ngaySinh, Integer gioiTinh, String matKhau) {
/* 12 */     this.idKhachHang = idKhachHang; this.tenKhachHang = tenKhachHang; this.soDienThoai = soDienThoai; this.email = email; this.ngaySinh = ngaySinh; this.gioiTinh = gioiTinh; this.matKhau = matKhau;
/*    */   } public RegisterResponse() {} public static RegisterResponseBuilder builder() {
/* 14 */     return new RegisterResponseBuilder();
/*    */   }
/*    */   public Integer getIdKhachHang() {
/* 17 */     return this.idKhachHang;
/*    */   } public String getTenKhachHang() {
/* 19 */     return this.tenKhachHang;
/*    */   } public String getSoDienThoai() {
/* 21 */     return this.soDienThoai;
/*    */   } public String getEmail() {
/* 23 */     return this.email;
/*    */   } public Date getNgaySinh() {
/* 25 */     return this.ngaySinh;
/*    */   } public Integer getGioiTinh() {
/* 27 */     return this.gioiTinh;
/*    */   } public String getMatKhau() {
/* 29 */     return this.matKhau;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\RegisterResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */