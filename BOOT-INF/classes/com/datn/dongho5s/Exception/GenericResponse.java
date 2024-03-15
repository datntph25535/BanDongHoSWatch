/*    */ package BOOT-INF.classes.com.datn.dongho5s.Exception;
/*    */ public class GenericResponse { private String message;
/*    */   private String token;
/*    */   private String error;
/*    */   
/*  6 */   public void setMessage(String message) { this.message = message; } public void setToken(String token) { this.token = token; } public void setError(String error) { this.error = error; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Exception.GenericResponse)) return false;  com.datn.dongho5s.Exception.GenericResponse other = (com.datn.dongho5s.Exception.GenericResponse)o; if (!other.canEqual(this)) return false;  Object this$message = getMessage(), other$message = other.getMessage(); if ((this$message == null) ? (other$message != null) : !this$message.equals(other$message)) return false;  Object this$token = getToken(), other$token = other.getToken(); if ((this$token == null) ? (other$token != null) : !this$token.equals(other$token)) return false;  Object this$error = getError(), other$error = other.getError(); return !((this$error == null) ? (other$error != null) : !this$error.equals(other$error)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Exception.GenericResponse; } public int hashCode() { int PRIME = 59; result = 1; Object $message = getMessage(); result = result * 59 + (($message == null) ? 43 : $message.hashCode()); Object $token = getToken(); result = result * 59 + (($token == null) ? 43 : $token.hashCode()); Object $error = getError(); return result * 59 + (($error == null) ? 43 : $error.hashCode()); } public String toString() { return "GenericResponse(message=" + getMessage() + ", token=" + getToken() + ", error=" + getError() + ")"; }
/*    */   
/*    */   public GenericResponse() {}
/*  9 */   public String getMessage() { return this.message; }
/* 10 */   public String getToken() { return this.token; } public String getError() {
/* 11 */     return this.error;
/*    */   }
/*    */   
/*    */   public GenericResponse(String message, String token) {
/* 15 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public GenericResponse(String message, String token, String error) {
/* 20 */     this.message = message;
/* 21 */     this.token = token;
/* 22 */     this.error = error;
/*    */   } }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Exception\GenericResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */