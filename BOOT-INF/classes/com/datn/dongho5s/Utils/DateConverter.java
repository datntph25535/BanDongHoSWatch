/*    */ package BOOT-INF.classes.com.datn.dongho5s.Utils;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DateConverter {
/*    */   private static final String DISPLAY_FORMAT = "dd-MM-yyyy";
/*    */   private static final String DATABASE_FORMAT = "yyyy-MM-dd";
/*    */   
/*    */   public static String formatDateForDisplay(Date date) {
/* 11 */     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
/* 12 */     return formatter.format(date);
/*    */   }
/*    */   
/*    */   public static Date parseDateFromDisplay(String dateString) {
/* 16 */     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
/*    */     try {
/* 18 */       return formatter.parse(dateString);
/* 19 */     } catch (Exception e) {
/* 20 */       throw new RuntimeException("Lỗi khi chuyển đổi ngày tháng từ chuỗi hiển thị.", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String formatDateForDatabase(Date date) {
/* 25 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/* 26 */     return formatter.format(date);
/*    */   }
/*    */   
/*    */   public static Date parseDateFromDatabase(String dateString) {
/* 30 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*    */     try {
/* 32 */       return formatter.parse(dateString);
/* 33 */     } catch (Exception e) {
/* 34 */       throw new RuntimeException("Lỗi khi chuyển đổi ngày tháng từ chuỗi cơ sở dữ liệu.", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Utils\DateConverter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */