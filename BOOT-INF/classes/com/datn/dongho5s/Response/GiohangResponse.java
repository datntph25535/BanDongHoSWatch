/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KhachHang;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class GiohangResponse {
/*    */   private Integer idGioHang;
/*    */   private KhachHang khachHang;
/*    */   private Date ngayTaoGioHang;
/*    */   
/* 12 */   public void setIdGioHang(Integer idGioHang) { this.idGioHang = idGioHang; } private Integer trangThaiGioHang; private String ghiChu; private Timestamp thoiGianCapNhapGioHang; public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; } public void setNgayTaoGioHang(Date ngayTaoGioHang) { this.ngayTaoGioHang = ngayTaoGioHang; } public void setTrangThaiGioHang(Integer trangThaiGioHang) { this.trangThaiGioHang = trangThaiGioHang; } public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; } public void setThoiGianCapNhapGioHang(Timestamp thoiGianCapNhapGioHang) { this.thoiGianCapNhapGioHang = thoiGianCapNhapGioHang; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.GiohangResponse)) return false;  com.datn.dongho5s.Response.GiohangResponse other = (com.datn.dongho5s.Response.GiohangResponse)o; if (!other.canEqual(this)) return false;  Object this$idGioHang = getIdGioHang(), other$idGioHang = other.getIdGioHang(); if ((this$idGioHang == null) ? (other$idGioHang != null) : !this$idGioHang.equals(other$idGioHang)) return false;  Object this$trangThaiGioHang = getTrangThaiGioHang(), other$trangThaiGioHang = other.getTrangThaiGioHang(); if ((this$trangThaiGioHang == null) ? (other$trangThaiGioHang != null) : !this$trangThaiGioHang.equals(other$trangThaiGioHang)) return false;  Object this$khachHang = getKhachHang(), other$khachHang = other.getKhachHang(); if ((this$khachHang == null) ? (other$khachHang != null) : !this$khachHang.equals(other$khachHang)) return false;  Object this$ngayTaoGioHang = getNgayTaoGioHang(), other$ngayTaoGioHang = other.getNgayTaoGioHang(); if ((this$ngayTaoGioHang == null) ? (other$ngayTaoGioHang != null) : !this$ngayTaoGioHang.equals(other$ngayTaoGioHang)) return false;  Object this$ghiChu = getGhiChu(), other$ghiChu = other.getGhiChu(); if ((this$ghiChu == null) ? (other$ghiChu != null) : !this$ghiChu.equals(other$ghiChu)) return false;  Object this$thoiGianCapNhapGioHang = getThoiGianCapNhapGioHang(), other$thoiGianCapNhapGioHang = other.getThoiGianCapNhapGioHang(); return !((this$thoiGianCapNhapGioHang == null) ? (other$thoiGianCapNhapGioHang != null) : !this$thoiGianCapNhapGioHang.equals(other$thoiGianCapNhapGioHang)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.GiohangResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $idGioHang = getIdGioHang(); result = result * 59 + (($idGioHang == null) ? 43 : $idGioHang.hashCode()); Object $trangThaiGioHang = getTrangThaiGioHang(); result = result * 59 + (($trangThaiGioHang == null) ? 43 : $trangThaiGioHang.hashCode()); Object $khachHang = getKhachHang(); result = result * 59 + (($khachHang == null) ? 43 : $khachHang.hashCode()); Object $ngayTaoGioHang = getNgayTaoGioHang(); result = result * 59 + (($ngayTaoGioHang == null) ? 43 : $ngayTaoGioHang.hashCode()); Object $ghiChu = getGhiChu(); result = result * 59 + (($ghiChu == null) ? 43 : $ghiChu.hashCode()); Object $thoiGianCapNhapGioHang = getThoiGianCapNhapGioHang(); return result * 59 + (($thoiGianCapNhapGioHang == null) ? 43 : $thoiGianCapNhapGioHang.hashCode()); } public String toString() { return "GiohangResponse(idGioHang=" + getIdGioHang() + ", khachHang=" + getKhachHang() + ", ngayTaoGioHang=" + getNgayTaoGioHang() + ", trangThaiGioHang=" + getTrangThaiGioHang() + ", ghiChu=" + getGhiChu() + ", thoiGianCapNhapGioHang=" + getThoiGianCapNhapGioHang() + ")"; } public GiohangResponse(Integer idGioHang, KhachHang khachHang, Date ngayTaoGioHang, Integer trangThaiGioHang, String ghiChu, Timestamp thoiGianCapNhapGioHang) {
/* 13 */     this.idGioHang = idGioHang; this.khachHang = khachHang; this.ngayTaoGioHang = ngayTaoGioHang; this.trangThaiGioHang = trangThaiGioHang; this.ghiChu = ghiChu; this.thoiGianCapNhapGioHang = thoiGianCapNhapGioHang;
/*    */   } public GiohangResponse() {} public static GiohangResponseBuilder builder() {
/* 15 */     return new GiohangResponseBuilder();
/*    */   } public Integer getIdGioHang() {
/* 17 */     return this.idGioHang;
/*    */   } public KhachHang getKhachHang() {
/* 19 */     return this.khachHang;
/*    */   } public Date getNgayTaoGioHang() {
/* 21 */     return this.ngayTaoGioHang;
/*    */   } public Integer getTrangThaiGioHang() {
/* 23 */     return this.trangThaiGioHang;
/*    */   } public String getGhiChu() {
/* 25 */     return this.ghiChu;
/*    */   } public Timestamp getThoiGianCapNhapGioHang() {
/* 27 */     return this.thoiGianCapNhapGioHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\GiohangResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */