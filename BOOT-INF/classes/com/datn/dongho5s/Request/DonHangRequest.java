/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ 
/*    */ public class DonHangRequest
/*    */ {
/*    */   private Integer idDonHang;
/*    */   private String lyDo;
/*    */   private Integer trangThaiDonHang;
/*    */   
/*    */   public void setIdDonHang(Integer idDonHang) {
/* 11 */     this.idDonHang = idDonHang; } public void setLyDo(String lyDo) { this.lyDo = lyDo; } public void setTrangThaiDonHang(Integer trangThaiDonHang) { this.trangThaiDonHang = trangThaiDonHang; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.DonHangRequest)) return false;  com.datn.dongho5s.Request.DonHangRequest other = (com.datn.dongho5s.Request.DonHangRequest)o; if (!other.canEqual(this)) return false;  Object this$idDonHang = getIdDonHang(), other$idDonHang = other.getIdDonHang(); if ((this$idDonHang == null) ? (other$idDonHang != null) : !this$idDonHang.equals(other$idDonHang)) return false;  Object this$trangThaiDonHang = getTrangThaiDonHang(), other$trangThaiDonHang = other.getTrangThaiDonHang(); if ((this$trangThaiDonHang == null) ? (other$trangThaiDonHang != null) : !this$trangThaiDonHang.equals(other$trangThaiDonHang)) return false;  Object this$lyDo = getLyDo(), other$lyDo = other.getLyDo(); return !((this$lyDo == null) ? (other$lyDo != null) : !this$lyDo.equals(other$lyDo)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.DonHangRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $idDonHang = getIdDonHang(); result = result * 59 + (($idDonHang == null) ? 43 : $idDonHang.hashCode()); Object $trangThaiDonHang = getTrangThaiDonHang(); result = result * 59 + (($trangThaiDonHang == null) ? 43 : $trangThaiDonHang.hashCode()); Object $lyDo = getLyDo(); return result * 59 + (($lyDo == null) ? 43 : $lyDo.hashCode()); } public String toString() { return "DonHangRequest(idDonHang=" + getIdDonHang() + ", lyDo=" + getLyDo() + ", trangThaiDonHang=" + getTrangThaiDonHang() + ")"; } public DonHangRequest(Integer idDonHang, String lyDo, Integer trangThaiDonHang) {
/* 12 */     this.idDonHang = idDonHang; this.lyDo = lyDo; this.trangThaiDonHang = trangThaiDonHang;
/*    */   } public DonHangRequest() {} public static DonHangRequestBuilder builder() {
/* 14 */     return new DonHangRequestBuilder();
/*    */   }
/* 16 */   public Integer getIdDonHang() { return this.idDonHang; }
/* 17 */   public String getLyDo() { return this.lyDo; } public Integer getTrangThaiDonHang() {
/* 18 */     return this.trangThaiDonHang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\DonHangRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */