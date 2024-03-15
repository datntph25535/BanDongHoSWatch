/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DiaChi;
/*    */ 
/*    */ public class ThongTinToCheckoutResponse {
/*    */   private Integer id;
/*    */   private String tenKhachHang;
/*    */   private String soDienThoai;
/*    */   private List<DiaChi> listDiaChi;
/*    */   
/* 11 */   public ThongTinToCheckoutResponse(Integer id, String tenKhachHang, String soDienThoai, List<DiaChi> listDiaChi) { this.id = id; this.tenKhachHang = tenKhachHang; this.soDienThoai = soDienThoai; this.listDiaChi = listDiaChi; }
/* 12 */   public void setId(Integer id) { this.id = id; } public void setTenKhachHang(String tenKhachHang) { this.tenKhachHang = tenKhachHang; } public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; } public void setListDiaChi(List<DiaChi> listDiaChi) { this.listDiaChi = listDiaChi; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.ThongTinToCheckoutResponse)) return false;  com.datn.dongho5s.Response.ThongTinToCheckoutResponse other = (com.datn.dongho5s.Response.ThongTinToCheckoutResponse)o; if (!other.canEqual(this)) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$tenKhachHang = getTenKhachHang(), other$tenKhachHang = other.getTenKhachHang(); if ((this$tenKhachHang == null) ? (other$tenKhachHang != null) : !this$tenKhachHang.equals(other$tenKhachHang)) return false;  Object this$soDienThoai = getSoDienThoai(), other$soDienThoai = other.getSoDienThoai(); if ((this$soDienThoai == null) ? (other$soDienThoai != null) : !this$soDienThoai.equals(other$soDienThoai)) return false;  Object<DiaChi> this$listDiaChi = (Object<DiaChi>)getListDiaChi(), other$listDiaChi = (Object<DiaChi>)other.getListDiaChi(); return !((this$listDiaChi == null) ? (other$listDiaChi != null) : !this$listDiaChi.equals(other$listDiaChi)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.ThongTinToCheckoutResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $tenKhachHang = getTenKhachHang(); result = result * 59 + (($tenKhachHang == null) ? 43 : $tenKhachHang.hashCode()); Object $soDienThoai = getSoDienThoai(); result = result * 59 + (($soDienThoai == null) ? 43 : $soDienThoai.hashCode()); Object<DiaChi> $listDiaChi = (Object<DiaChi>)getListDiaChi(); return result * 59 + (($listDiaChi == null) ? 43 : $listDiaChi.hashCode()); } public String toString() { return "ThongTinToCheckoutResponse(id=" + getId() + ", tenKhachHang=" + getTenKhachHang() + ", soDienThoai=" + getSoDienThoai() + ", listDiaChi=" + getListDiaChi() + ")"; } public static ThongTinToCheckoutResponseBuilder builder() {
/* 13 */     return new ThongTinToCheckoutResponseBuilder();
/*    */   }
/*    */   public ThongTinToCheckoutResponse() {}
/* 16 */   public Integer getId() { return this.id; }
/* 17 */   public String getTenKhachHang() { return this.tenKhachHang; }
/* 18 */   public String getSoDienThoai() { return this.soDienThoai; } public List<DiaChi> getListDiaChi() {
/* 19 */     return this.listDiaChi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\ThongTinToCheckoutResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */