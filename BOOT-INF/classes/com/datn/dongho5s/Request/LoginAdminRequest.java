/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;public class LoginAdminRequest {
/*    */   private String email;
/*    */   private String password;
/*    */   
/*    */   public LoginAdminRequest() {}
/*    */   
/*    */   public LoginAdminRequest(String email, String password) {
/*  8 */     this.email = email; this.password = password;
/*    */   } public void setEmail(String email) {
/* 10 */     this.email = email; } public void setPassword(String password) { this.password = password; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.LoginAdminRequest)) return false;  com.datn.dongho5s.Request.LoginAdminRequest other = (com.datn.dongho5s.Request.LoginAdminRequest)o; if (!other.canEqual(this)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); return !((this$password == null) ? (other$password != null) : !this$password.equals(other$password)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.LoginAdminRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $password = getPassword(); return result * 59 + (($password == null) ? 43 : $password.hashCode()); } public String toString() { return "LoginAdminRequest(email=" + getEmail() + ", password=" + getPassword() + ")"; }
/*    */   
/* 12 */   public String getEmail() { return this.email; } public String getPassword() {
/* 13 */     return this.password;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\LoginAdminRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */