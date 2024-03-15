/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class PhuongXaResponse {
/*    */   @JsonProperty("DistrictID")
/*    */   private Integer districtID;
/*    */   
/*    */   @JsonProperty("DistrictID")
/* 10 */   public void setDistrictID(Integer districtID) { this.districtID = districtID; } @JsonProperty("WardCode") private String wardCode; @JsonProperty("WardName") private String wardName; @JsonProperty("WardCode") public void setWardCode(String wardCode) { this.wardCode = wardCode; } @JsonProperty("WardName") public void setWardName(String wardName) { this.wardName = wardName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhuongXaResponse)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhuongXaResponse other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhuongXaResponse)o; if (!other.canEqual(this)) return false;  Object this$districtID = getDistrictID(), other$districtID = other.getDistrictID(); if ((this$districtID == null) ? (other$districtID != null) : !this$districtID.equals(other$districtID)) return false;  Object this$wardCode = getWardCode(), other$wardCode = other.getWardCode(); if ((this$wardCode == null) ? (other$wardCode != null) : !this$wardCode.equals(other$wardCode)) return false;  Object this$wardName = getWardName(), other$wardName = other.getWardName(); return !((this$wardName == null) ? (other$wardName != null) : !this$wardName.equals(other$wardName)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.PhuongXaResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $districtID = getDistrictID(); result = result * 59 + (($districtID == null) ? 43 : $districtID.hashCode()); Object $wardCode = getWardCode(); result = result * 59 + (($wardCode == null) ? 43 : $wardCode.hashCode()); Object $wardName = getWardName(); return result * 59 + (($wardName == null) ? 43 : $wardName.hashCode()); } public String toString() { return "PhuongXaResponse(districtID=" + getDistrictID() + ", wardCode=" + getWardCode() + ", wardName=" + getWardName() + ")"; } public PhuongXaResponse(Integer districtID, String wardCode, String wardName) {
/* 11 */     this.districtID = districtID; this.wardCode = wardCode; this.wardName = wardName;
/*    */   }
/*    */   public PhuongXaResponse() {}
/*    */   public Integer getDistrictID() {
/* 15 */     return this.districtID;
/*    */   } public String getWardCode() {
/* 17 */     return this.wardCode;
/*    */   } public String getWardName() {
/* 19 */     return this.wardName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\PhuongXaResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */