/*   */ package BOOT-INF.classes.com.datn.dongho5s.Exception.CustomException;
/*   */ 
/*   */ import org.springframework.http.HttpStatus;
/*   */ import org.springframework.web.bind.annotation.ResponseStatus;
/*   */ 
/*   */ @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
/*   */ public class InternalServerException extends RuntimeException {
/*   */   public InternalServerException(String message) {
/* 9 */     super(message);
/*   */   }
/*   */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Exception\CustomException\InternalServerException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */