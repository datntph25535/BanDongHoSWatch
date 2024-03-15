/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class QuanHuyenResponse {
/*    */   @JsonProperty("ProvinceID")
/*    */   private Integer provinceID;
/*    */   
/*    */   @JsonProperty("ProvinceID")
/* 10 */   public void setProvinceID(Integer provinceID) { this.provinceID = provinceID; } @JsonProperty("DistrictID") private Integer districtID; @JsonProperty("DistrictName") private String districtName; @JsonProperty("DistrictID") public void setDistrictID(Integer districtID) { this.districtID = districtID; } @JsonProperty("DistrictName") public void setDistrictName(String districtName) { this.districtName = districtName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.QuanHuyenResponse)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.QuanHuyenResponse other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.QuanHuyenResponse)o; if (!other.canEqual(this)) return false;  Object this$provinceID = getProvinceID(), other$provinceID = other.getProvinceID(); if ((this$provinceID == null) ? (other$provinceID != null) : !this$provinceID.equals(other$provinceID)) return false;  Object this$districtID = getDistrictID(), other$districtID = other.getDistrictID(); if ((this$districtID == null) ? (other$districtID != null) : !this$districtID.equals(other$districtID)) return false;  Object this$districtName = getDistrictName(), other$districtName = other.getDistrictName(); return !((this$districtName == null) ? (other$districtName != null) : !this$districtName.equals(other$districtName)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.QuanHuyenResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $provinceID = getProvinceID(); result = result * 59 + (($provinceID == null) ? 43 : $provinceID.hashCode()); Object $districtID = getDistrictID(); result = result * 59 + (($districtID == null) ? 43 : $districtID.hashCode()); Object $districtName = getDistrictName(); return result * 59 + (($districtName == null) ? 43 : $districtName.hashCode()); } public String toString() { return "QuanHuyenResponse(provinceID=" + getProvinceID() + ", districtID=" + getDistrictID() + ", districtName=" + getDistrictName() + ")"; } public QuanHuyenResponse(Integer provinceID, Integer districtID, String districtName) {
/* 11 */     this.provinceID = provinceID; this.districtID = districtID; this.districtName = districtName;
/*    */   }
/*    */   public QuanHuyenResponse() {}
/*    */   public Integer getProvinceID() {
/* 15 */     return this.provinceID;
/*    */   } public Integer getDistrictID() {
/* 17 */     return this.districtID;
/*    */   } public String getDistrictName() {
/* 19 */     return this.districtName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\QuanHuyenResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */