/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ public class LoginResponse {
/*    */   private Integer idKhachHang;
/*    */   private String username;
/*    */   
/*  7 */   public void setIdKhachHang(Integer idKhachHang) { this.idKhachHang = idKhachHang; } private int status; private String message; private String token; public void setUsername(String username) { this.username = username; } public void setStatus(int status) { this.status = status; } public void setMessage(String message) { this.message = message; } public void setToken(String token) { this.token = token; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.LoginResponse)) return false;  com.datn.dongho5s.Response.LoginResponse other = (com.datn.dongho5s.Response.LoginResponse)o; if (!other.canEqual(this)) return false;  if (getStatus() != other.getStatus()) return false;  Object this$idKhachHang = getIdKhachHang(), other$idKhachHang = other.getIdKhachHang(); if ((this$idKhachHang == null) ? (other$idKhachHang != null) : !this$idKhachHang.equals(other$idKhachHang)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$message = getMessage(), other$message = other.getMessage(); if ((this$message == null) ? (other$message != null) : !this$message.equals(other$message)) return false;  Object this$token = getToken(), other$token = other.getToken(); return !((this$token == null) ? (other$token != null) : !this$token.equals(other$token)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.LoginResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getStatus(); Object $idKhachHang = getIdKhachHang(); result = result * 59 + (($idKhachHang == null) ? 43 : $idKhachHang.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $message = getMessage(); result = result * 59 + (($message == null) ? 43 : $message.hashCode()); Object $token = getToken(); return result * 59 + (($token == null) ? 43 : $token.hashCode()); } public String toString() { return "LoginResponse(idKhachHang=" + getIdKhachHang() + ", username=" + getUsername() + ", status=" + getStatus() + ", message=" + getMessage() + ", token=" + getToken() + ")"; } public LoginResponse(Integer idKhachHang, String username, int status, String message, String token) {
/*  8 */     this.idKhachHang = idKhachHang; this.username = username; this.status = status; this.message = message; this.token = token;
/*    */   }
/*    */   public LoginResponse() {}
/* 11 */   public Integer getIdKhachHang() { return this.idKhachHang; }
/* 12 */   public String getUsername() { return this.username; }
/* 13 */   public int getStatus() { return this.status; }
/* 14 */   public String getMessage() { return this.message; } public String getToken() {
/* 15 */     return this.token;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\LoginResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */