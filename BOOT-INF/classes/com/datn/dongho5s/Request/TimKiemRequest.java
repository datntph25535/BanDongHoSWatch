/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ public class TimKiemRequest {
/*    */   @JsonProperty("thuongHieuId")
/*    */   private List<Integer> thuongHieuId;
/*    */   @JsonProperty("danhMucId")
/*    */   private List<Integer> danhMucId;
/*    */   @JsonProperty("sizeId")
/*    */   private List<Integer> sizeId;
/*    */   
/*    */   @JsonProperty("thuongHieuId")
/* 11 */   public void setThuongHieuId(List<Integer> thuongHieuId) { this.thuongHieuId = thuongHieuId; } @JsonProperty("mauSacId") private List<Integer> mauSacId; @JsonProperty("vatLieuId") private List<Integer> vatLieuId; @JsonProperty("dayDeoId") private List<Integer> dayDeoId; @JsonProperty("tenSanPham") private String tenSanPham; @JsonProperty("danhMucId") public void setDanhMucId(List<Integer> danhMucId) { this.danhMucId = danhMucId; } @JsonProperty("sizeId") public void setSizeId(List<Integer> sizeId) { this.sizeId = sizeId; } @JsonProperty("mauSacId") public void setMauSacId(List<Integer> mauSacId) { this.mauSacId = mauSacId; } @JsonProperty("vatLieuId") public void setVatLieuId(List<Integer> vatLieuId) { this.vatLieuId = vatLieuId; } @JsonProperty("dayDeoId") public void setDayDeoId(List<Integer> dayDeoId) { this.dayDeoId = dayDeoId; } @JsonProperty("tenSanPham") public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.TimKiemRequest)) return false;  com.datn.dongho5s.Request.TimKiemRequest other = (com.datn.dongho5s.Request.TimKiemRequest)o; if (!other.canEqual(this)) return false;  Object<Integer> this$thuongHieuId = (Object<Integer>)getThuongHieuId(), other$thuongHieuId = (Object<Integer>)other.getThuongHieuId(); if ((this$thuongHieuId == null) ? (other$thuongHieuId != null) : !this$thuongHieuId.equals(other$thuongHieuId)) return false;  Object<Integer> this$danhMucId = (Object<Integer>)getDanhMucId(), other$danhMucId = (Object<Integer>)other.getDanhMucId(); if ((this$danhMucId == null) ? (other$danhMucId != null) : !this$danhMucId.equals(other$danhMucId)) return false;  Object<Integer> this$sizeId = (Object<Integer>)getSizeId(), other$sizeId = (Object<Integer>)other.getSizeId(); if ((this$sizeId == null) ? (other$sizeId != null) : !this$sizeId.equals(other$sizeId)) return false;  Object<Integer> this$mauSacId = (Object<Integer>)getMauSacId(), other$mauSacId = (Object<Integer>)other.getMauSacId(); if ((this$mauSacId == null) ? (other$mauSacId != null) : !this$mauSacId.equals(other$mauSacId)) return false;  Object<Integer> this$vatLieuId = (Object<Integer>)getVatLieuId(), other$vatLieuId = (Object<Integer>)other.getVatLieuId(); if ((this$vatLieuId == null) ? (other$vatLieuId != null) : !this$vatLieuId.equals(other$vatLieuId)) return false;  Object<Integer> this$dayDeoId = (Object<Integer>)getDayDeoId(), other$dayDeoId = (Object<Integer>)other.getDayDeoId(); if ((this$dayDeoId == null) ? (other$dayDeoId != null) : !this$dayDeoId.equals(other$dayDeoId)) return false;  Object this$tenSanPham = getTenSanPham(), other$tenSanPham = other.getTenSanPham(); return !((this$tenSanPham == null) ? (other$tenSanPham != null) : !this$tenSanPham.equals(other$tenSanPham)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.TimKiemRequest; } public int hashCode() { int PRIME = 59; result = 1; Object<Integer> $thuongHieuId = (Object<Integer>)getThuongHieuId(); result = result * 59 + (($thuongHieuId == null) ? 43 : $thuongHieuId.hashCode()); Object<Integer> $danhMucId = (Object<Integer>)getDanhMucId(); result = result * 59 + (($danhMucId == null) ? 43 : $danhMucId.hashCode()); Object<Integer> $sizeId = (Object<Integer>)getSizeId(); result = result * 59 + (($sizeId == null) ? 43 : $sizeId.hashCode()); Object<Integer> $mauSacId = (Object<Integer>)getMauSacId(); result = result * 59 + (($mauSacId == null) ? 43 : $mauSacId.hashCode()); Object<Integer> $vatLieuId = (Object<Integer>)getVatLieuId(); result = result * 59 + (($vatLieuId == null) ? 43 : $vatLieuId.hashCode()); Object<Integer> $dayDeoId = (Object<Integer>)getDayDeoId(); result = result * 59 + (($dayDeoId == null) ? 43 : $dayDeoId.hashCode()); Object $tenSanPham = getTenSanPham(); return result * 59 + (($tenSanPham == null) ? 43 : $tenSanPham.hashCode()); } public TimKiemRequest(List<Integer> thuongHieuId, List<Integer> danhMucId, List<Integer> sizeId, List<Integer> mauSacId, List<Integer> vatLieuId, List<Integer> dayDeoId, String tenSanPham) {
/* 12 */     this.thuongHieuId = thuongHieuId; this.danhMucId = danhMucId; this.sizeId = sizeId; this.mauSacId = mauSacId; this.vatLieuId = vatLieuId; this.dayDeoId = dayDeoId; this.tenSanPham = tenSanPham;
/*    */   } public TimKiemRequest() {} public String toString() {
/* 14 */     return "TimKiemRequest(thuongHieuId=" + getThuongHieuId() + ", danhMucId=" + getDanhMucId() + ", sizeId=" + getSizeId() + ", mauSacId=" + getMauSacId() + ", vatLieuId=" + getVatLieuId() + ", dayDeoId=" + getDayDeoId() + ", tenSanPham=" + getTenSanPham() + ")";
/*    */   }
/*    */   public List<Integer> getThuongHieuId() {
/* 17 */     return this.thuongHieuId;
/*    */   } public List<Integer> getDanhMucId() {
/* 19 */     return this.danhMucId;
/*    */   } public List<Integer> getSizeId() {
/* 21 */     return this.sizeId;
/*    */   } public List<Integer> getMauSacId() {
/* 23 */     return this.mauSacId;
/*    */   } public List<Integer> getVatLieuId() {
/* 25 */     return this.vatLieuId;
/*    */   } public List<Integer> getDayDeoId() {
/* 27 */     return this.dayDeoId;
/*    */   } public String getTenSanPham() {
/* 29 */     return this.tenSanPham;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\TimKiemRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */