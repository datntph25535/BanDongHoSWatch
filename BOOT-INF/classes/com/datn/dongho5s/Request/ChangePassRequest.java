/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ public class ChangePassRequest {
/*    */   private String oldPass;
/*    */   private String newPass;
/*    */   private String confirmPass;
/*    */   
/*  7 */   public void setOldPass(String oldPass) { this.oldPass = oldPass; } public void setNewPass(String newPass) { this.newPass = newPass; } public void setConfirmPass(String confirmPass) { this.confirmPass = confirmPass; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.ChangePassRequest)) return false;  com.datn.dongho5s.Request.ChangePassRequest other = (com.datn.dongho5s.Request.ChangePassRequest)o; if (!other.canEqual(this)) return false;  Object this$oldPass = getOldPass(), other$oldPass = other.getOldPass(); if ((this$oldPass == null) ? (other$oldPass != null) : !this$oldPass.equals(other$oldPass)) return false;  Object this$newPass = getNewPass(), other$newPass = other.getNewPass(); if ((this$newPass == null) ? (other$newPass != null) : !this$newPass.equals(other$newPass)) return false;  Object this$confirmPass = getConfirmPass(), other$confirmPass = other.getConfirmPass(); return !((this$confirmPass == null) ? (other$confirmPass != null) : !this$confirmPass.equals(other$confirmPass)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.ChangePassRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $oldPass = getOldPass(); result = result * 59 + (($oldPass == null) ? 43 : $oldPass.hashCode()); Object $newPass = getNewPass(); result = result * 59 + (($newPass == null) ? 43 : $newPass.hashCode()); Object $confirmPass = getConfirmPass(); return result * 59 + (($confirmPass == null) ? 43 : $confirmPass.hashCode()); } public String toString() { return "ChangePassRequest(oldPass=" + getOldPass() + ", newPass=" + getNewPass() + ", confirmPass=" + getConfirmPass() + ")"; } public ChangePassRequest(String oldPass, String newPass, String confirmPass) {
/*  8 */     this.oldPass = oldPass; this.newPass = newPass; this.confirmPass = confirmPass;
/*    */   }
/*    */   public ChangePassRequest() {}
/* 11 */   public String getOldPass() { return this.oldPass; }
/* 12 */   public String getNewPass() { return this.newPass; } public String getConfirmPass() {
/* 13 */     return this.confirmPass;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\ChangePassRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */