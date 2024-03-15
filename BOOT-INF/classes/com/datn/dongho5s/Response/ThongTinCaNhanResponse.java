/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ThongTinCaNhanResponse {
/*    */   private Integer id;
/*    */   private String tenKhachHang;
/*    */   private String soDienThoai;
/*    */   
/* 10 */   public ThongTinCaNhanResponse(Integer id, String tenKhachHang, String soDienThoai, String email, Integer gioiTinh, String diaChi, Date ngaySinh) { this.id = id; this.tenKhachHang = tenKhachHang; this.soDienThoai = soDienThoai; this.email = email; this.gioiTinh = gioiTinh; this.diaChi = diaChi; this.ngaySinh = ngaySinh; } private String email; private Integer gioiTinh; private String diaChi; private Date ngaySinh; public void setId(Integer id) {
/* 11 */     this.id = id; } public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; } public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setEmail(String email) { this.email = email; } public void setGioiTinh(Integer gioiTinh) { this.gioiTinh = gioiTinh; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; } public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.ThongTinCaNhanResponse)) return false;  com.datn.dongho5s.Response.ThongTinCaNhanResponse other = (com.datn.dongho5s.Response.ThongTinCaNhanResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$gioiTinh = getGioiTinh(), other$gioiTinh = other.getGioiTinh(); if ((this$gioiTinh == null) ? (other$gioiTinh != null) : !this$gioiTinh.equals(other$gioiTinh)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$diaChi = getDiaChi(), other$diaChi = other.getDiaChi(); if ((this$diaChi == null) ? (other$diaChi != null) : !this$diaChi.equals(other$diaChi)) return false;  Object this$ngaySinh = getNgaySinh(), other$ngaySinh = other.getNgaySinh(); return !((this$ngaySinh == null) ? (other$ngaySinh != null) : !this$ngaySinh.equals(other$ngaySinh)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.ThongTinCaNhanResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $gioiTinh = getGioiTinh(); result = result * 59 + (($gioiTinh == null) ? 43 : $gioiTinh.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $diaChi = getDiaChi(); result = result * 59 + (($diaChi == null) ? 43 : $diaChi.hashCode()); Object $ngaySinh = getNgaySinh(); return result * 59 + (($ngaySinh == null) ? 43 : $ngaySinh.hashCode()); } public String toString() { return "ThongTinCaNhanResponse(id=" + getId() + ", tenKhachHang=" + getTenKhachHang() + ", soDienThoai=" + getSoDienThoai() + ", email=" + getEmail() + ", gioiTinh=" + getGioiTinh() + ", diaChi=" + getDiaChi() + ", ngaySinh=" + getNgaySinh() + ")"; } public static ThongTinCaNhanResponseBuilder builder() {
/* 12 */     return new ThongTinCaNhanResponseBuilder();
/*    */   }
/*    */   public ThongTinCaNhanResponse() {}
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public String getTenKhachHang() { return this.tenKhachHang; }
/* 17 */   public String getSoDienThoai() { return this.soDienThoai; }
/* 18 */   public String getEmail() { return this.email; }
/* 19 */   public Integer getGioiTinh() { return this.gioiTinh; }
/* 20 */   public String getDiaChi() { return this.diaChi; } public Date getNgaySinh() {
/* 21 */     return this.ngaySinh;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\ThongTinCaNhanResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */