/*   */ package BOOT-INF.classes.com.datn.dongho5s.Exception.CustomException;
/*   */ 
/*   */ import org.springframework.http.HttpStatus;
/*   */ import org.springframework.web.bind.annotation.ResponseStatus;
/*   */ 
/*   */ @ResponseStatus(HttpStatus.BAD_REQUEST)
/*   */ public class BadRequestException extends RuntimeException {
/*   */   public BadRequestException(String message) {
/* 9 */     super(message);
/*   */   }
/*   */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Exception\CustomException\BadRequestException.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */