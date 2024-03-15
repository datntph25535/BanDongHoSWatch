/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class LoginRequest
/*    */   implements Serializable
/*    */ {
/*    */   private String username;
/*    */   private String password;
/*    */   
/*    */   public void setUsername(String username) {
/* 12 */     this.username = username; } public void setPassword(String password) { this.password = password; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.LoginRequest)) return false;  com.datn.dongho5s.Request.LoginRequest other = (com.datn.dongho5s.Request.LoginRequest)o; if (!other.canEqual(this)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); return !((this$password == null) ? (other$password != null) : !this$password.equals(other$password)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.LoginRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $password = getPassword(); return result * 59 + (($password == null) ? 43 : $password.hashCode()); } public String toString() { return "LoginRequest(username=" + getUsername() + ", password=" + getPassword() + ")"; } public LoginRequest(String username, String password) {
/* 13 */     this.username = username; this.password = password;
/*    */   }
/*    */   public LoginRequest() {}
/*    */   public String getUsername() {
/* 17 */     return this.username;
/*    */   } public String getPassword() {
/* 19 */     return this.password;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\LoginRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */