/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ public class AbstractExporter
/*    */ {
/*    */   public void setResponseHeader(HttpServletResponse response, String contentType, String extension, String prefix) throws IOException {
/* 13 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
/* 14 */     String timestamp = dateFormat.format(new Date());
/* 15 */     String fileName = prefix + prefix + timestamp;
/* 16 */     response.setContentType(contentType);
/* 17 */     String headerKey = "Content-Disposition";
/* 18 */     String headerValue = "attachment; fileName=" + fileName;
/* 19 */     response.setHeader(headerKey, headerValue);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\AbstractExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */