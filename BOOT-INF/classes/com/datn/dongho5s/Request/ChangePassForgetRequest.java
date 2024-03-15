/*    */ package BOOT-INF.classes.com.datn.dongho5s.Request;
/*    */ 
/*    */ public class ChangePassForgetRequest {
/*    */   private String newPass;
/*    */   private String confirmPass;
/*    */   
/*  7 */   public void setNewPass(String newPass) { this.newPass = newPass; } public void setConfirmPass(String confirmPass) { this.confirmPass = confirmPass; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Request.ChangePassForgetRequest)) return false;  com.datn.dongho5s.Request.ChangePassForgetRequest other = (com.datn.dongho5s.Request.ChangePassForgetRequest)o; if (!other.canEqual(this)) return false;  Object this$newPass = getNewPass(), other$newPass = other.getNewPass(); if ((this$newPass == null) ? (other$newPass != null) : !this$newPass.equals(other$newPass)) return false;  Object this$confirmPass = getConfirmPass(), other$confirmPass = other.getConfirmPass(); return !((this$confirmPass == null) ? (other$confirmPass != null) : !this$confirmPass.equals(other$confirmPass)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Request.ChangePassForgetRequest; } public int hashCode() { int PRIME = 59; result = 1; Object $newPass = getNewPass(); result = result * 59 + (($newPass == null) ? 43 : $newPass.hashCode()); Object $confirmPass = getConfirmPass(); return result * 59 + (($confirmPass == null) ? 43 : $confirmPass.hashCode()); } public String toString() { return "ChangePassForgetRequest(newPass=" + getNewPass() + ", confirmPass=" + getConfirmPass() + ")"; } public ChangePassForgetRequest(String newPass, String confirmPass) {
/*  8 */     this.newPass = newPass; this.confirmPass = confirmPass;
/*    */   }
/*    */   public ChangePassForgetRequest() {}
/* 11 */   public String getNewPass() { return this.newPass; } public String getConfirmPass() {
/* 12 */     return this.confirmPass;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Request\ChangePassForgetRequest.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */