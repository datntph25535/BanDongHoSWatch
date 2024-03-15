/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ public class LoginAdminResponse {
/*    */   private Integer id;
/*    */   private String name;
/*    */   
/*  7 */   public void setId(Integer id) { this.id = id; } private int status; private String description; private String token; public void setName(String name) { this.name = name; } public void setStatus(int status) { this.status = status; } public void setDescription(String description) { this.description = description; } public void setToken(String token) { this.token = token; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.LoginAdminResponse)) return false;  com.datn.dongho5s.Response.LoginAdminResponse other = (com.datn.dongho5s.Response.LoginAdminResponse)o; if (!other.canEqual(this)) return false;  if (getStatus() != other.getStatus()) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$description = getDescription(), other$description = other.getDescription(); if ((this$description == null) ? (other$description != null) : !this$description.equals(other$description)) return false;  Object this$token = getToken(), other$token = other.getToken(); return !((this$token == null) ? (other$token != null) : !this$token.equals(other$token)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.LoginAdminResponse; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getStatus(); Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $description = getDescription(); result = result * 59 + (($description == null) ? 43 : $description.hashCode()); Object $token = getToken(); return result * 59 + (($token == null) ? 43 : $token.hashCode()); } public String toString() { return "LoginAdminResponse(id=" + getId() + ", name=" + getName() + ", status=" + getStatus() + ", description=" + getDescription() + ", token=" + getToken() + ")"; } public LoginAdminResponse(Integer id, String name, int status, String description, String token) {
/*  8 */     this.id = id; this.name = name; this.status = status; this.description = description; this.token = token;
/*    */   }
/*    */   public LoginAdminResponse() {}
/* 11 */   public Integer getId() { return this.id; }
/* 12 */   public String getName() { return this.name; }
/* 13 */   public int getStatus() { return this.status; }
/* 14 */   public String getDescription() { return this.description; } public String getToken() {
/* 15 */     return this.token;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\LoginAdminResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */