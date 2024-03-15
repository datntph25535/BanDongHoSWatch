/*    */ package BOOT-INF.classes.com.datn.dongho5s.Exception;
/*    */ 
/*    */ import com.datn.dongho5s.Exception.CustomException.BadRequestException;
/*    */ import com.datn.dongho5s.Exception.CustomException.InternalServerException;
/*    */ import com.datn.dongho5s.Exception.CustomException.NotFoundException;
/*    */ import com.datn.dongho5s.Exception.DanhMucNotFoundException;
/*    */ import com.datn.dongho5s.Exception.ErrorResponse;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.context.MessageSource;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.RestControllerAdvice;
/*    */ import org.springframework.web.context.request.WebRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestControllerAdvice
/*    */ public class CustomExceptionHandler
/*    */ {
/*    */   @Qualifier("messageSource")
/*    */   @Autowired
/*    */   private MessageSource msgSource;
/*    */   
/*    */   @ExceptionHandler({InternalServerException.class})
/*    */   public ResponseEntity<?> handlerInternalServerException(InternalServerException ex, WebRequest request) {
/* 32 */     ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
/* 33 */     return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
/*    */   }
/*    */ 
/*    */   
/*    */   @ExceptionHandler({NotFoundException.class})
/*    */   public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest request) {
/* 39 */     ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
/* 40 */     return new ResponseEntity(error, HttpStatus.NOT_FOUND);
/*    */   }
/*    */ 
/*    */   
/*    */   @ExceptionHandler({BadRequestException.class})
/*    */   public ResponseEntity<?> handlerBadRequestException(BadRequestException ex, WebRequest request) {
/* 46 */     ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
/* 47 */     return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
/*    */   }
/*    */ 
/*    */   
/*    */   @ExceptionHandler({DanhMucNotFoundException.class})
/*    */   public ResponseEntity<?> handlerException(DanhMucNotFoundException ex, WebRequest request) {
/* 53 */     ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
/* 54 */     return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Exception\CustomExceptionHandler.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */