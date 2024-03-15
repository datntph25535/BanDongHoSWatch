/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class TinhThanhResponse {
/*    */   @JsonProperty("ProvinceID")
/*    */   private Integer provinceID;
/*    */   
/*    */   @JsonProperty("ProvinceID")
/* 10 */   public void setProvinceID(Integer provinceID) { this.provinceID = provinceID; } @JsonProperty("ProvinceName") private String provinceName; @JsonProperty("ProvinceName") public void setProvinceName(String provinceName) { this.provinceName = provinceName; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.TinhThanhResponse)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.TinhThanhResponse other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.TinhThanhResponse)o; if (!other.canEqual(this)) return false;  Object this$provinceID = getProvinceID(), other$provinceID = other.getProvinceID(); if ((this$provinceID == null) ? (other$provinceID != null) : !this$provinceID.equals(other$provinceID)) return false;  Object this$provinceName = getProvinceName(), other$provinceName = other.getProvinceName(); return !((this$provinceName == null) ? (other$provinceName != null) : !this$provinceName.equals(other$provinceName)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.TinhThanhResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $provinceID = getProvinceID(); result = result * 59 + (($provinceID == null) ? 43 : $provinceID.hashCode()); Object $provinceName = getProvinceName(); return result * 59 + (($provinceName == null) ? 43 : $provinceName.hashCode()); } public String toString() { return "TinhThanhResponse(provinceID=" + getProvinceID() + ", provinceName=" + getProvinceName() + ")"; } public TinhThanhResponse(Integer provinceID, String provinceName) {
/* 11 */     this.provinceID = provinceID; this.provinceName = provinceName;
/*    */   }
/*    */   public TinhThanhResponse() {}
/*    */   public Integer getProvinceID() {
/* 15 */     return this.provinceID;
/*    */   } public String getProvinceName() {
/* 17 */     return this.provinceName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\TinhThanhResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */