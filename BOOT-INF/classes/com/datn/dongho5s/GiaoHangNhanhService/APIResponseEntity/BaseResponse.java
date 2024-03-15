/*    */ package BOOT-INF.classes.com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ 
/*    */ @JsonIgnoreProperties(ignoreUnknown = true)
/*    */ public class BaseResponse<T> {
/*    */   @JsonProperty("code")
/*    */   private String code;
/*    */   
/*    */   @JsonProperty("code")
/* 11 */   public void setCode(String code) { this.code = code; } @JsonProperty("message") private String message; @JsonProperty("data") private T data; @JsonProperty("message") public void setMessage(String message) { this.message = message; } @JsonProperty("data") public void setData(T data) { this.data = data; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseResponse)) return false;  com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseResponse<?> other = (com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseResponse)o; if (!other.canEqual(this)) return false;  Object this$code = getCode(), other$code = other.getCode(); if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code)) return false;  Object this$message = getMessage(), other$message = other.getMessage(); if ((this$message == null) ? (other$message != null) : !this$message.equals(other$message)) return false;  Object this$data = getData(), other$data = other.getData(); return !((this$data == null) ? (other$data != null) : !this$data.equals(other$data)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.GiaoHangNhanhService.APIResponseEntity.BaseResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $code = getCode(); result = result * 59 + (($code == null) ? 43 : $code.hashCode()); Object $message = getMessage(); result = result * 59 + (($message == null) ? 43 : $message.hashCode()); Object $data = getData(); return result * 59 + (($data == null) ? 43 : $data.hashCode()); } public String toString() { return "BaseResponse(code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ")"; } public BaseResponse(String code, String message, T data) {
/* 12 */     this.code = code; this.message = message; this.data = data;
/*    */   }
/*    */   public BaseResponse() {}
/*    */   public String getCode() {
/* 16 */     return this.code;
/*    */   } public String getMessage() {
/* 18 */     return this.message;
/*    */   } public T getData() {
/* 20 */     return this.data;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\GiaoHangNhanhService\APIResponseEntity\BaseResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */