/*    */ package BOOT-INF.classes.com.datn.dongho5s.Utils;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Date;
/*    */ import org.springframework.core.convert.converter.Converter;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class DateToTimestampConverter
/*    */   implements Converter<Date, Timestamp> {
/*    */   public Timestamp convert(Date source) {
/* 12 */     return (source == null) ? null : new Timestamp(source.getTime());
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Utils\DateToTimestampConverter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */