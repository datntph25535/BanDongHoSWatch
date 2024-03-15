/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class RegisterRequest {
/*    */   private String tenKhachHang;
/*    */   private String soDienThoai;
/*    */   private String email;
/*    */   private Date ngaySinh;
/*    */   private Integer gioiTinh;
/*    */   
/* 10 */   public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; } private String password; private Integer idTinhThanh; private Integer idQuanHuyen; private String idPhuongXa; private String diaChi; public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setEmail(String email) { this.email = email; } public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; } public void setGioiTinh(Integer gioiTinh) { this.gioiTinh = gioiTinh; } public void setPassword(String password) { this.password = password; } public void setIdTinhThanh(Integer idTinhThanh) { this.idTinhThanh = idTinhThanh; } public void setIdQuanHuyen(Integer idQuanHuyen) { this.idQuanHuyen = idQuanHuyen; } public void setIdPhuongXa(String idPhuongXa) { this.idPhuongXa = idPhuongXa; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.RegisterRequest)) return false;  com.datn.dongho5s.Request.RegisterRequest other = (com.datn.dongho5s.Request.RegisterRequest)o; if (!other.canEqual(this)) return false;  Object this$gioiTinh = getGioiTinh(), other$gioiTinh = other.getGioiTinh(); if ((this$gioiTinh == null) ? (other$gioiTinh != null) : !this$gioiTinh.equals(other$gioiTinh)) return false;  Object this$idTinhThanh = getIdTinhThanh(), other$idTinhThanh = other.getIdTinhThanh(); if ((this$idTinhThanh == null) ? (other$idTinhThanh != null) : !this$idTinhThanh.equals(other$idTinhThanh)) return false;  Object this$idQuanHuyen = getIdQuanHuyen(), other$idQuanHuyen = other.getIdQuanHuyen(); if ((this$idQuanHuyen == null) ? (other$idQuanHuyen != null) : !this$idQuanHuyen.equals(other$idQuanHuyen)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$ngaySinh = getNgaySinh(), other$ngaySinh = other.getNgaySinh(); if ((this$ngaySinh == null) ? (other$ngaySinh != null) : !this$ngaySinh.equals(other$ngaySinh)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password)) return false;  Object this$idPhuongXa = getIdPhuongXa(), other$idPhuongXa = other.getIdPhuongXa(); if ((this$idPhuongXa == null) ? (other$idPhuongXa != null) : !this$idPhuongXa.equals(other$idPhuongXa)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); return !((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.RegisterRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $gioiTinh = getGioiTinh(); result = result * 59 + (($gioiTinh == null) ? 43 : $gioiTinh.hashCode()); Object $idTinhThanh = getIdTinhThanh(); result = result * 59 + (($idTinhThanh == null) ? 43 : $idTinhThanh.hashCode()); Object $idQuanHuyen = getIdQuanHuyen(); result = result * 59 + (($idQuanHuyen == null) ? 43 : $idQuanHuyen.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $ngaySinh = getNgaySinh(); result = result * 59 + (($ngaySinh == null) ? 43 : $ngaySinh.hashCode()); Object $password = getPassword(); result = result * 59 + (($password == null) ? 43 : $password.hashCode()); Object $idPhuongXa = getIdPhuongXa(); result = result * 59 + (($idPhuongXa == null) ? 43 : $idPhuongXa.hashCode()); Object $diaChi = getDiaChi(); return result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); } public String toString() { return "RegisterRequest(tenKhachHang=" + getTenKhachHang() + ", soDienThoai=" + getSoDienThoai() + ", email=" + getEmail() + ", ngaySinh=" + getNgaySinh() + ", gioiTinh=" + getGioiTinh() + ", password=" + getPassword() + ", idTinhThanh=" + getIdTinhThanh() + ", idQuanHuyen=" + getIdQuanHuyen() + ", idPhuongXa=" + getIdPhuongXa() + ", diaChi=" + getDiaChi() + ")"; } public RegisterRequest(String tenKhachHang, String soDienThoai, String email, Date ngaySinh, Integer gioiTinh, String password, Integer idTinhThanh, Integer idQuanHuyen, String idPhuongXa, String diaChi) {
/* 11 */     this.tenKhachHang = tenKhachHang; this.soDienThoai = soDienThoai; this.email = email; this.ngaySinh = ngaySinh; this.gioiTinh = gioiTinh; this.password = password; this.idTinhThanh = idTinhThanh; this.idQuanHuyen = idQuanHuyen; this.idPhuongXa = idPhuongXa; this.diaChi = diaChi;
/*    */   } public RegisterRequest() {} public static RegisterRequestBuilder builder() {
/* 13 */     return new RegisterRequestBuilder();
/*    */   }
/*    */   public String getTenKhachHang() {
/* 16 */     return this.tenKhachHang;
/*    */   } public String getSoDienThoai() {
/* 18 */     return this.soDienThoai;
/*    */   } public String getEmail() {
/* 20 */     return this.email;
/*    */   } public Date getNgaySinh() {
/* 22 */     return this.ngaySinh;
/*    */   } public Integer getGioiTinh() {
/* 24 */     return this.gioiTinh;
/*    */   } public String getPassword() {
/* 26 */     return this.password;
/*    */   } public Integer getIdTinhThanh() {
/* 28 */     return this.idTinhThanh;
/*    */   } public Integer getIdQuanHuyen() {
/* 30 */     return this.idQuanHuyen;
/*    */   } public String getIdPhuongXa() {
/* 32 */     return this.idPhuongXa;
/*    */   } public String getDiaChi() {
/* 34 */     return this.diaChi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\RegisterRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */