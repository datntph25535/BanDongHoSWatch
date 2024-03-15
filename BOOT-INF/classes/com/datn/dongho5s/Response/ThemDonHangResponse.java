/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class ThemDonHangResponse
/*    */ {
/*    */   private Date ngayTao;
/*    */   
/*    */   public String toString() {
/* 11 */     return "ThemDonHangResponse(ngayTao=" + getNgayTao() + ")"; } public int hashCode() { int PRIME = 59; result = 1; Object $ngayTao = getNgayTao(); return result * 59 + (($ngayTao == null) ? 43 : $ngayTao.hashCode()); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.ThemDonHangResponse; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.ThemDonHangResponse)) return false;  com.datn.dongho5s.Response.ThemDonHangResponse other = (com.datn.dongho5s.Response.ThemDonHangResponse)o; if (!other.canEqual(this)) return false;  Object this$ngayTao = getNgayTao(), other$ngayTao = other.getNgayTao(); return !((this$ngayTao == null) ? (other$ngayTao != null) : !this$ngayTao.equals(other$ngayTao)); } public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
/*    */    public Date getNgayTao() {
/* 13 */     return this.ngayTao;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\ThemDonHangResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */