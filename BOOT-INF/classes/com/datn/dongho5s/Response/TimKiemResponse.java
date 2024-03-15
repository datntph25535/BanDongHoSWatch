/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.AnhSanPham;
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TimKiemResponse {
/*    */   private Integer sanPhamID;
/*    */   private String tenSanPham;
/*    */   
/* 11 */   public TimKiemResponse(Integer sanPhamID, String tenSanPham, Double giaSanPham, List<AnhSanPham> listAnhSanPham, List<ChiTietSanPham> listChiTietSanPham) { this.sanPhamID = sanPhamID; this.tenSanPham = tenSanPham; this.giaSanPham = giaSanPham; this.listAnhSanPham = listAnhSanPham; this.listChiTietSanPham = listChiTietSanPham; } private Double giaSanPham; private List<AnhSanPham> listAnhSanPham; private List<ChiTietSanPham> listChiTietSanPham; public void setSanPhamID(Integer sanPhamID) {
/* 12 */     this.sanPhamID = sanPhamID; } public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; } public void setGiaSanPham(Double giaSanPham) { this.giaSanPham = giaSanPham; } public void setListAnhSanPham(List<AnhSanPham> listAnhSanPham) { this.listAnhSanPham = listAnhSanPham; } public void setListChiTietSanPham(List<ChiTietSanPham> listChiTietSanPham) { this.listChiTietSanPham = listChiTietSanPham; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.TimKiemResponse)) return false;  com.datn.dongho5s.Response.TimKiemResponse other = (com.datn.dongho5s.Response.TimKiemResponse)o; if (!other.canEqual(this)) return false;  Object this$sanPhamID = getSanPhamID(), other$sanPhamID = other.getSanPhamID(); if ((this$sanPhamID == null) ? (other$sanPhamID != null) : !this$sanPhamID.equals(other$sanPhamID)) return false;  Object this$giaSanPham = getGiaSanPham(), other$giaSanPham = other.getGiaSanPham(); if ((this$giaSanPham == null) ? (other$giaSanPham != null) : !this$giaSanPham.equals(other$giaSanPham)) return false;  Object this$tenSanPham = getTenSanPham(), other$tenSanPham = other.getTenSanPham(); if ((this$tenSanPham == null) ? (other$tenSanPham != null) : !this$tenSanPham.equals(other$tenSanPham)) return false;  Object<AnhSanPham> this$listAnhSanPham = (Object<AnhSanPham>)getListAnhSanPham(), other$listAnhSanPham = (Object<AnhSanPham>)other.getListAnhSanPham(); if ((this$listAnhSanPham == null) ? (other$listAnhSanPham != null) : !this$listAnhSanPham.equals(other$listAnhSanPham)) return false;  Object<ChiTietSanPham> this$listChiTietSanPham = (Object<ChiTietSanPham>)getListChiTietSanPham(), other$listChiTietSanPham = (Object<ChiTietSanPham>)other.getListChiTietSanPham(); return !((this$listChiTietSanPham == null) ? (other$listChiTietSanPham != null) : !this$listChiTietSanPham.equals(other$listChiTietSanPham)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.TimKiemResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $sanPhamID = getSanPhamID(); result = result * 59 + (($sanPhamID == null) ? 43 : $sanPhamID.hashCode()); Object $giaSanPham = getGiaSanPham(); result = result * 59 + (($giaSanPham == null) ? 43 : $giaSanPham.hashCode()); Object $tenSanPham = getTenSanPham(); result = result * 59 + (($tenSanPham == null) ? 43 : $tenSanPham.hashCode()); Object<AnhSanPham> $listAnhSanPham = (Object<AnhSanPham>)getListAnhSanPham(); result = result * 59 + (($listAnhSanPham == null) ? 43 : $listAnhSanPham.hashCode()); Object<ChiTietSanPham> $listChiTietSanPham = (Object<ChiTietSanPham>)getListChiTietSanPham(); return result * 59 + (($listChiTietSanPham == null) ? 43 : $listChiTietSanPham.hashCode()); } public String toString() { return "TimKiemResponse(sanPhamID=" + getSanPhamID() + ", tenSanPham=" + getTenSanPham() + ", giaSanPham=" + getGiaSanPham() + ", listAnhSanPham=" + getListAnhSanPham() + ", listChiTietSanPham=" + getListChiTietSanPham() + ")"; }
/*    */   
/*    */   public TimKiemResponse() {}
/* 15 */   public Integer getSanPhamID() { return this.sanPhamID; }
/* 16 */   public String getTenSanPham() { return this.tenSanPham; }
/* 17 */   public Double getGiaSanPham() { return this.giaSanPham; }
/* 18 */   public List<AnhSanPham> getListAnhSanPham() { return this.listAnhSanPham; } public List<ChiTietSanPham> getListChiTietSanPham() {
/* 19 */     return this.listChiTietSanPham;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\TimKiemResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */