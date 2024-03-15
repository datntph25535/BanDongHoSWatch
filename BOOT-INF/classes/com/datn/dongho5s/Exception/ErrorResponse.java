/*    */ package BOOT-INF.classes.com.datn.dongho5s.Exception;
/*    */ 
/*    */ import org.springframework.http.HttpStatus;
/*    */ 
/*    */ 
/*    */ public class ErrorResponse
/*    */ {
/*    */   private HttpStatus status;
/*    */   private String message;
/*    */   
/*    */   public void setStatus(HttpStatus status) {
/* 12 */     this.status = status; } public void setMessage(String message) { this.message = message; } public ErrorResponse(HttpStatus status, String message) {
/* 13 */     this.status = status; this.message = message;
/*    */   }
/*    */   public ErrorResponse() {}
/* 16 */   public HttpStatus getStatus() { return this.status; } public String getMessage() {
/* 17 */     return this.message;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Exception\ErrorResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */