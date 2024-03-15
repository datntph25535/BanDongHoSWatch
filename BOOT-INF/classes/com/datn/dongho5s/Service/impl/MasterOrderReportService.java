/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.DonHang;
/*     */ import com.datn.dongho5s.Entity.ReportItem;
/*     */ import com.datn.dongho5s.Entity.ReportType;
/*     */ import com.datn.dongho5s.Repository.DonHangRepository;
/*     */ import com.datn.dongho5s.Service.impl.AbstractReportService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class MasterOrderReportService
/*     */   extends AbstractReportService
/*     */ {
/*     */   @Autowired
/*     */   private DonHangRepository repo;
/*     */   
/*     */   protected List<ReportItem> getReportDataByDateRangeInternal(Date startTime, Date endTime, ReportType reportType) {
/*  23 */     List<DonHang> listOrders = this.repo.findByOrderByStatusBetween(startTime, endTime, Integer.valueOf(3));
/*  24 */     printRawData(listOrders);
/*  25 */     System.out.println("Trạng thái: ");
/*  26 */     printRawDataStatus(listOrders);
/*  27 */     List<ReportItem> listReportItems = createReportData(startTime, endTime, reportType, Integer.valueOf(3));
/*     */ 
/*     */ 
/*     */     
/*  31 */     calculateSalesForReportData(listOrders, listReportItems);
/*     */     
/*  33 */     printReportData(listReportItems);
/*     */     
/*  35 */     return listReportItems;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculateSalesForReportData(List<DonHang> listOrders, List<ReportItem> listReportItems) {
/*  51 */     for (DonHang order : listOrders) {
/*  52 */       String orderDateString = this.dateFormatter.format(order.getNgayTao());
/*  53 */       ReportItem reportItem = new ReportItem(orderDateString);
/*  54 */       int itemIndex = listReportItems.indexOf(reportItem);
/*  55 */       for (ReportItem item : listReportItems) {
/*  56 */         if (item.getGrossSales() == null || item.getNetSales() == null) {
/*  57 */           item.setGrossSales(Double.valueOf(0.0D));
/*  58 */           item.setNetSales(Double.valueOf(0.0D));
/*     */         } 
/*     */       } 
/*  61 */       if (itemIndex >= 0) {
/*  62 */         reportItem = listReportItems.get(itemIndex);
/*  63 */         reportItem.addGrossSales(order.getTongTien());
/*  64 */         reportItem.addNetSales(Double.valueOf(order.getTongTien().doubleValue() - order.getPhiVanChuyen().doubleValue()));
/*  65 */         reportItem.increaseOrderCount();
/*  66 */         reportItem.addStatus(order.getTrangThaiDonHang().intValue());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void printReportData(List<ReportItem> listReportItems) {
/*  72 */     listReportItems.forEach(item -> System.out.printf("%s, %.3f, %.3f, %d \n", new Object[] { item.getIdentifier(), item.getGrossSales(), item.getNetSales(), Integer.valueOf(item.getOrdersCount()) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<ReportItem> createReportData(Date startTime, Date endTime, ReportType reportType, Integer statusList) {
/*  80 */     List<ReportItem> listReportItems = new ArrayList<>();
/*  81 */     Calendar startDate = Calendar.getInstance();
/*  82 */     startDate.setTime(startTime);
/*  83 */     Calendar endDate = Calendar.getInstance();
/*  84 */     endDate.setTime(endTime);
/*     */     
/*  86 */     List<DonHang> listOrders = this.repo.findByOrderByStatusBetween(startTime, endTime, Integer.valueOf(3));
/*     */     
/*     */     while (true) {
/*  89 */       String dateString = this.dateFormatter.format(startDate.getTime());
/*     */ 
/*     */       
/*  92 */       boolean hasMatchingStatus = false;
/*  93 */       for (DonHang order : listOrders) {
/*  94 */         if (statusList.intValue() == 3) {
/*  95 */           hasMatchingStatus = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 101 */       if (hasMatchingStatus) {
/* 102 */         listReportItems.add(new ReportItem(dateString));
/*     */       }
/* 104 */       if (reportType.equals(ReportType.DAY)) {
/* 105 */         startDate.add(5, 1);
/* 106 */       } else if (reportType.equals(ReportType.MONTH)) {
/* 107 */         startDate.add(2, 1);
/*     */       } 
/* 109 */       if (!startDate.before(endDate))
/* 110 */         return listReportItems; 
/*     */     } 
/*     */   }
/*     */   private void printRawData(List<DonHang> listOrders) {
/* 114 */     listOrders.forEach(order -> System.out.printf("%-3d | %s | %.3f | %.3f \n", new Object[] { order.getIdDonHang(), order.getNgayTao(), order.getTongTien(), order.getPhiVanChuyen() }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void printRawDataStatus(List<DonHang> listOrders) {
/* 124 */     listOrders.forEach(order -> System.out.printf("%-3d | %s | %.3f | %.3f | %-3d\n", new Object[] { order.getIdDonHang(), order.getNgayTao(), order.getTongTien(), order.getPhiVanChuyen(), order.getTrangThaiDonHang() }));
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\MasterOrderReportService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */