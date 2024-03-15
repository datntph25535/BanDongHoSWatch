/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Entity.DonHang;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HoaDonChiTietResponse
/*    */ {
/*    */   private Integer idHoaDonChiTiet;
/*    */   private DonHang donHang;
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   private Integer soLuong;
/*    */   private Double giaBan;
/*    */   
/*    */   public void setIdHoaDonChiTiet(Integer idHoaDonChiTiet) {
/* 17 */     this.idHoaDonChiTiet = idHoaDonChiTiet; } public void setDonHang(DonHang donHang) { this.donHang = donHang; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; } public void setGiaBan(Double giaBan) { this.giaBan = giaBan; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.HoaDonChiTietResponse)) return false;  com.datn.dongho5s.Response.HoaDonChiTietResponse other = (com.datn.dongho5s.Response.HoaDonChiTietResponse)o; if (!other.canEqual(this)) return false;  Object this$idHoaDonChiTiet = getIdHoaDonChiTiet(), other$idHoaDonChiTiet = other.getIdHoaDonChiTiet(); if ((this$idHoaDonChiTiet == null) ? (other$idHoaDonChiTiet != null) : !this$idHoaDonChiTiet.equals(other$idHoaDonChiTiet)) return false;  Object this$soLuong = getSoLuong(), other$soLuong = other.getSoLuong(); if ((this$soLuong == null) ? (other$soLuong != null) : !this$soLuong.equals(other$soLuong)) return false;  Object this$giaBan = getGiaBan(), other$giaBan = other.getGiaBan(); if ((this$giaBan == null) ? (other$giaBan != null) : !this$giaBan.equals(other$giaBan)) return false;  Object this$donHang = getDonHang(), other$donHang = other.getDonHang(); if ((this$donHang == null) ? (other$donHang != null) : !this$donHang.equals(other$donHang)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); return !((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.HoaDonChiTietResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idHoaDonChiTiet = getIdHoaDonChiTiet(); result = result * 59 + (($idHoaDonChiTiet == null) ? 43 : $idHoaDonChiTiet.hashCode()); Object $soLuong = getSoLuong(); result = result * 59 + (($soLuong == null) ? 43 : $soLuong.hashCode()); Object $giaBan = getGiaBan(); result = result * 59 + (($giaBan == null) ? 43 : $giaBan.hashCode()); Object $donHang = getDonHang(); result = result * 59 + (($donHang == null) ? 43 : $donHang.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); return result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); } public String toString() { return "HoaDonChiTietResponse(idHoaDonChiTiet=" + getIdHoaDonChiTiet() + ", donHang=" + getDonHang() + ", chiTietSanPham=" + getChiTietSanPham() + ", soLuong=" + getSoLuong() + ", giaBan=" + getGiaBan() + ")"; } public HoaDonChiTietResponse(Integer idHoaDonChiTiet, DonHang donHang, ChiTietSanPham chiTietSanPham, Integer soLuong, Double giaBan) {
/* 18 */     this.idHoaDonChiTiet = idHoaDonChiTiet; this.donHang = donHang; this.chiTietSanPham = chiTietSanPham; this.soLuong = soLuong; this.giaBan = giaBan;
/*    */   } public HoaDonChiTietResponse() {} public static HoaDonChiTietResponseBuilder builder() {
/* 20 */     return new HoaDonChiTietResponseBuilder();
/*    */   } public Integer getIdHoaDonChiTiet() {
/* 22 */     return this.idHoaDonChiTiet;
/*    */   } public DonHang getDonHang() {
/* 24 */     return this.donHang;
/*    */   } public ChiTietSanPham getChiTietSanPham() {
/* 26 */     return this.chiTietSanPham;
/*    */   } public Integer getSoLuong() {
/* 28 */     return this.soLuong;
/*    */   } public Double getGiaBan() {
/* 30 */     return this.giaBan;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\HoaDonChiTietResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */