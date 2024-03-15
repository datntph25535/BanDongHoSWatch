/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ public class VNPayUrlResponse {
/*    */   private String url;
/*    */   
/*    */   public void setUrl(String url) {
/*  7 */     this.url = url; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.VNPayUrlResponse)) return false;  com.datn.dongho5s.Response.VNPayUrlResponse other = (com.datn.dongho5s.Response.VNPayUrlResponse)o; if (!other.canEqual(this)) return false;  Object this$url = getUrl(), other$url = other.getUrl(); return !((this$url == null) ? (other$url != null) : !this$url.equals(other$url)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.VNPayUrlResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $url = getUrl(); return result * 59 + (($url == null) ? 43 : $url.hashCode()); } public String toString() { return "VNPayUrlResponse(url=" + getUrl() + ")"; }
/*    */    public VNPayUrlResponse() {} public VNPayUrlResponse(String url) {
/*  9 */     this.url = url;
/*    */   } public String getUrl() {
/* 11 */     return this.url;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\VNPayUrlResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */