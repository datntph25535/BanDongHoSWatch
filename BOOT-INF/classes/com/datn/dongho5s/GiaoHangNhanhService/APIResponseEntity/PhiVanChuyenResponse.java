/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class PhiVanChuyenResponse {
/*    */   @JsonProperty("total")
/*    */   private Integer total;
/*    */   
/*    */   @JsonProperty("total")
/* 10 */   public void setTotal(Integer total) { this.total = total; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhiVanChuyenResponse)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhiVanChuyenResponse other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhiVanChuyenResponse)o; if (!other.canEqual(this)) return false;  Object this$total = getTotal(), other$total = other.getTotal(); return !((this$total == null) ? (other$total != null) : !this$total.equals(other$total)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhiVanChuyenResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $total = getTotal(); return result * 59 + (($total == null) ? 43 : $total.hashCode()); } public String toString() { return "PhiVanChuyenResponse(total=" + getTotal() + ")"; } public PhiVanChuyenResponse(Integer total) {
/* 11 */     this.total = total;
/*    */   }
/*    */   public PhiVanChuyenResponse() {}
/*    */   public Integer getTotal() {
/* 15 */     return this.total;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\PhiVanChuyenResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */