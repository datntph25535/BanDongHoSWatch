/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class ThemDonHangResponseGHN {
/*    */   @JsonProperty("order_code")
/*    */   private String orderCode;
/*    */   
/*    */   @JsonProperty("order_code")
/* 10 */   public void setOrderCode(String orderCode) { this.orderCode = orderCode; } @JsonProperty("expected_delivery_time") private String expectedDeliveryTime; @JsonProperty("expected_delivery_time") public void setExpectedDeliveryTime(String expectedDeliveryTime) { this.expectedDeliveryTime = expectedDeliveryTime; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.ThemDonHangResponseGHN)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.ThemDonHangResponseGHN other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.ThemDonHangResponseGHN)o; if (!other.canEqual(this)) return false;  Object this$orderCode = getOrderCode(), other$orderCode = other.getOrderCode(); if ((this$orderCode == null) ? (other$orderCode != null) : !this$orderCode.equals(other$orderCode)) return false;  Object this$expectedDeliveryTime = getExpectedDeliveryTime(), other$expectedDeliveryTime = other.getExpectedDeliveryTime(); return !((this$expectedDeliveryTime == null) ? (other$expectedDeliveryTime != null) : !this$expectedDeliveryTime.equals(other$expectedDeliveryTime)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.ThemDonHangResponseGHN; } public int hashCode() { int PRIME = 59; result = 1; Object $orderCode = getOrderCode(); result = result * 59 + (($orderCode == null) ? 43 : $orderCode.hashCode()); Object $expectedDeliveryTime = getExpectedDeliveryTime(); return result * 59 + (($expectedDeliveryTime == null) ? 43 : $expectedDeliveryTime.hashCode()); } public String toString() { return "ThemDonHangResponseGHN(orderCode=" + getOrderCode() + ", expectedDeliveryTime=" + getExpectedDeliveryTime() + ")"; } public ThemDonHangResponseGHN(String orderCode, String expectedDeliveryTime) {
/* 11 */     this.orderCode = orderCode; this.expectedDeliveryTime = expectedDeliveryTime;
/*    */   }
/*    */   public ThemDonHangResponseGHN() {}
/*    */   
/*    */   public String getOrderCode() {
/* 16 */     return this.orderCode;
/*    */   } public String getExpectedDeliveryTime() {
/* 18 */     return this.expectedDeliveryTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\ThemDonHangResponseGHN.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */