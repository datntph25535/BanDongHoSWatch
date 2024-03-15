/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ChiTietSanPham;
/*    */ import com.datn.dongho5s.Entity.GioHang;
/*    */ 
/*    */ public class ChiTietGioHangRequest {
/*    */   private Integer idChiTietGioHang;
/*    */   private GioHang gioHang;
/*    */   private ChiTietSanPham chiTietSanPham;
/*    */   private Integer soLuongSanPham;
/*    */   private Double giaBan;
/*    */   private Date ngayTao;
/*    */   private String ghiChu;
/*    */   
/* 15 */   public void setIdChiTietGioHang(Integer idChiTietGioHang) { this.idChiTietGioHang = idChiTietGioHang; } public void setGioHang(GioHang gioHang) { this.gioHang = gioHang; } public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) { this.chiTietSanPham = chiTietSanPham; } public void setSoLuongSanPham(Integer soLuongSanPham) { this.soLuongSanPham = soLuongSanPham; } public void setGiaBan(Double giaBan) { this.giaBan = giaBan; } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.ChiTietGioHangRequest)) return false;  com.datn.dongho5s.Request.ChiTietGioHangRequest other = (com.datn.dongho5s.Request.ChiTietGioHangRequest)o; if (!other.canEqual(this)) return false;  Object this$idChiTietGioHang = getIdChiTietGioHang(), other$idChiTietGioHang = other.getIdChiTietGioHang(); if ((this$idChiTietGioHang == null) ? (other$idChiTietGioHang != null) : !this$idChiTietGioHang.equals(other$idChiTietGioHang)) return false;  Object this$soLuongSanPham = getSoLuongSanPham(), other$soLuongSanPham = other.getSoLuongSanPham(); if ((this$soLuongSanPham == null) ? (other$soLuongSanPham != null) : !this$soLuongSanPham.equals(other$soLuongSanPham)) return false;  Object this$giaBan = getGiaBan(), other$giaBan = other.getGiaBan(); if ((this$giaBan == null) ? (other$giaBan != null) : !this$giaBan.equals(other$giaBan)) return false;  Object this$gioHang = getGioHang(), other$gioHang = other.getGioHang(); if ((this$gioHang == null) ? (other$gioHang != null) : !this$gioHang.equals(other$gioHang)) return false;  Object this$chiTietSanPham = getChiTietSanPham(), other$chiTietSanPham = other.getChiTietSanPham(); if ((this$chiTietSanPham == null) ? (other$chiTietSanPham != null) : !this$chiTietSanPham.equals(other$chiTietSanPham)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); if ((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); return !((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.ChiTietGioHangRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idChiTietGioHang = getIdChiTietGioHang(); result = result * 59 + (($idChiTietGioHang == null) ? 43 : $idChiTietGioHang.hashCode()); Object $soLuongSanPham = getSoLuongSanPham(); result = result * 59 + (($soLuongSanPham == null) ? 43 : $soLuongSanPham.hashCode()); Object $giaBan = getGiaBan(); result = result * 59 + (($giaBan == null) ? 43 : $giaBan.hashCode()); Object $gioHang = getGioHang(); result = result * 59 + (($gioHang == null) ? 43 : $gioHang.hashCode()); Object $chiTietSanPham = getChiTietSanPham(); result = result * 59 + (($chiTietSanPham == null) ? 43 : $chiTietSanPham.hashCode()); Object $ngayTao = getNgayTao(); result = result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); Object $ghiChu = getGhiChu(); return result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); } public String toString() { return "ChiTietGioHangRequest(idChiTietGioHang=" + getIdChiTietGioHang() + ", gioHang=" + getGioHang() + ", chiTietSanPham=" + getChiTietSanPham() + ", soLuongSanPham=" + getSoLuongSanPham() + ", giaBan=" + getGiaBan() + ", ngayTao=" + getNgayTao() + ", ghiChu=" + getGhiChu() + ")"; } public ChiTietGioHangRequest(Integer idChiTietGioHang, GioHang gioHang, ChiTietSanPham chiTietSanPham, Integer soLuongSanPham, Double giaBan, Date ngayTao, String ghiChu) {
/* 16 */     this.idChiTietGioHang = idChiTietGioHang; this.gioHang = gioHang; this.chiTietSanPham = chiTietSanPham; this.soLuongSanPham = soLuongSanPham; this.giaBan = giaBan; this.ngayTao = ngayTao; this.ghiChu = ghiChu;
/*    */   } public ChiTietGioHangRequest() {}
/*    */   public Integer getIdChiTietGioHang() {
/* 19 */     return this.idChiTietGioHang;
/*    */   } public GioHang getGioHang() {
/* 21 */     return this.gioHang;
/*    */   } public ChiTietSanPham getChiTietSanPham() {
/* 23 */     return this.chiTietSanPham;
/*    */   } public Integer getSoLuongSanPham() {
/* 25 */     return this.soLuongSanPham;
/*    */   } public Double getGiaBan() {
/* 27 */     return this.giaBan;
/*    */   } public Date getNgayTao() {
/* 29 */     return this.ngayTao;
/*    */   } public String getGhiChu() {
/* 31 */     return this.ghiChu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\ChiTietGioHangRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */