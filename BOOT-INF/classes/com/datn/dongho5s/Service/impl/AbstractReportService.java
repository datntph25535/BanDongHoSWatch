/*    */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ReportItem;
/*    */ import com.datn.dongho5s.Entity.ReportType;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractReportService
/*    */ {
/*    */   public DateFormat dateFormatter;
/*    */   public static final int ORDERS_PER_PAGE = 4;
/*    */   
/*    */   public List<ReportItem> getReportDataLast7Days(ReportType reportType) {
/* 20 */     return getReportDataLastXDays(7, reportType);
/*    */   }
/*    */   
/*    */   public List<ReportItem> getReportDataLast28Days(ReportType reportType) {
/* 24 */     return getReportDataLastXDays(28, reportType);
/*    */   }
/*    */   
/*    */   protected List<ReportItem> getReportDataLastXDays(int days, ReportType reportType) {
/* 28 */     Date endTime = new Date();
/* 29 */     Calendar cal = Calendar.getInstance();
/* 30 */     cal.add(5, -(days - 1));
/* 31 */     Date startTime = cal.getTime();
/*    */     
/* 33 */     System.out.println("Start time: " + startTime);
/* 34 */     System.out.println("End time: " + endTime);
/*    */     
/* 36 */     this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
/*    */     
/* 38 */     return getReportDataByDateRangeInternal(startTime, endTime, reportType);
/*    */   }
/*    */   
/*    */   public List<ReportItem> getReportDataLast6Months(ReportType reportType) {
/* 42 */     return getReportDataLastXMonths(6, reportType);
/*    */   }
/*    */   
/*    */   public List<ReportItem> getReportDataLastYear(ReportType reportType) {
/* 46 */     return getReportDataLastXMonths(12, reportType);
/*    */   }
/*    */   
/*    */   protected List<ReportItem> getReportDataLastXMonths(int months, ReportType reportType) {
/* 50 */     Date endTime = new Date();
/* 51 */     Calendar cal = Calendar.getInstance();
/* 52 */     cal.add(2, -(months - 1));
/* 53 */     Date startTime = cal.getTime();
/*    */     
/* 55 */     System.out.println("Start time: " + startTime);
/* 56 */     System.out.println("End time: " + endTime);
/*    */     
/* 58 */     this.dateFormatter = new SimpleDateFormat("yyyy-MM");
/*    */     
/* 60 */     return getReportDataByDateRangeInternal(startTime, endTime, reportType);
/*    */   }
/*    */   
/*    */   public List<ReportItem> getReportDataByDateRange(Date startTime, Date endTime, ReportType reportType) {
/* 64 */     this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
/* 65 */     return getReportDataByDateRangeInternal(startTime, endTime, reportType);
/*    */   }
/*    */   
/*    */   protected abstract List<ReportItem> getReportDataByDateRangeInternal(Date paramDate1, Date paramDate2, ReportType paramReportType);
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\AbstractReportService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */