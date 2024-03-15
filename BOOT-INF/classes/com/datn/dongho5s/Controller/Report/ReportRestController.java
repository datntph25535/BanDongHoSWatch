/*    */ package BOOT-INF.classes.com.datn.dongho5s.Controller.Report;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.ReportItem;
/*    */ import com.datn.dongho5s.Entity.ReportType;
/*    */ import com.datn.dongho5s.Service.impl.HoaDonChiTietReportServiceImpl;
/*    */ import com.datn.dongho5s.Service.impl.MasterOrderReportService;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class ReportRestController
/*    */ {
/*    */   @Autowired
/*    */   private MasterOrderReportService masterOrderReportService;
/*    */   
/*    */   @GetMapping({"/statisticals/sales_report_by_date/{period}"})
/*    */   public List<ReportItem> getReportDataByDatePeriod(@PathVariable("period") String period) {
/* 28 */     System.out.println("Report peroid: " + period);
/* 29 */     switch (period) {
/*    */       case "last_7_days":
/* 31 */         return this.masterOrderReportService.getReportDataLast7Days(ReportType.DAY);
/*    */       case "last_28_days":
/* 33 */         return this.masterOrderReportService.getReportDataLast28Days(ReportType.DAY);
/*    */       case "last_6_months":
/* 35 */         return this.masterOrderReportService.getReportDataLast6Months(ReportType.MONTH);
/*    */       case "last_year":
/* 37 */         return this.masterOrderReportService.getReportDataLastYear(ReportType.MONTH);
/*    */     } 
/* 39 */     return this.masterOrderReportService.getReportDataLast7Days(ReportType.DAY);
/*    */   }
/*    */   @Autowired
/*    */   private HoaDonChiTietReportServiceImpl orderDetailReportService; @Autowired
/*    */   HttpServletRequest request;
/*    */   @GetMapping({"/statisticals/sales_report_by_date/{startDate}/{endDate}"})
/*    */   public List<ReportItem> getReportDataByDatePeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws ParseException {
/* 46 */     DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
/* 47 */     Date startTime = dateFormater.parse(startDate);
/* 48 */     Date endTime = dateFormater.parse(endDate);
/* 49 */     return this.masterOrderReportService.getReportDataByDateRange(startTime, endTime, ReportType.DAY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/statisticals/{groupBy}/{startDate}/{endDate}"})
/*    */   public List<ReportItem> getReportDataByCategoryOrProductDateRange(@PathVariable("groupBy") String groupBy, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws ParseException {
/* 56 */     ReportType reportType = ReportType.valueOf(groupBy.toUpperCase());
/* 57 */     DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
/* 58 */     Date startTime = dateFormatter.parse(startDate);
/* 59 */     Date endTime = dateFormatter.parse(endDate);
/*    */     
/* 61 */     return this.orderDetailReportService.getReportDataByDateRange(startTime, endTime, reportType);
/*    */   }
/*    */ 
/*    */   
/*    */   @GetMapping({"/statisticals/{groupBy}/{period}"})
/*    */   public List<ReportItem> getReportDataByCategoryOrProduct(@PathVariable("groupBy") String groupBy, @PathVariable("period") String period) {
/* 67 */     ReportType reportType = ReportType.valueOf(groupBy.toUpperCase());
/*    */     
/* 69 */     switch (period) {
/*    */       case "last_7_days":
/* 71 */         return this.orderDetailReportService.getReportDataLast7Days(reportType);
/*    */       
/*    */       case "last_28_days":
/* 74 */         return this.orderDetailReportService.getReportDataLast28Days(reportType);
/*    */       
/*    */       case "last_6_months":
/* 77 */         return this.orderDetailReportService.getReportDataLast6Months(reportType);
/*    */       
/*    */       case "last_year":
/* 80 */         return this.orderDetailReportService.getReportDataLastYear(reportType);
/*    */     } 
/*    */     
/* 83 */     return this.orderDetailReportService.getReportDataLast7Days(reportType);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Controller\Report\ReportRestController.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */