/*     */ package BOOT-INF.classes.com.datn.dongho5s.Service.impl;
/*     */ 
/*     */ import com.datn.dongho5s.Entity.HoaDonChiTiet;
/*     */ import com.datn.dongho5s.Entity.ReportItem;
/*     */ import com.datn.dongho5s.Entity.ReportType;
/*     */ import com.datn.dongho5s.Repository.HoaDonChiTietRepository;
/*     */ import com.datn.dongho5s.Service.impl.AbstractReportService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class HoaDonChiTietReportServiceImpl
/*     */   extends AbstractReportService
/*     */ {
/*     */   @Autowired
/*     */   private HoaDonChiTietRepository repo;
/*     */   
/*     */   protected List<ReportItem> getReportDataByDateRangeInternal(Date startDate, Date endDate, ReportType reportType) {
/*  27 */     List<HoaDonChiTiet> listHoaDonChiTiets = null;
/*     */     
/*  29 */     if (reportType.equals(ReportType.CATEGORY)) {
/*  30 */       listHoaDonChiTiets = this.repo.findWithCategoryAndTimeBetween(startDate, endDate);
/*  31 */     } else if (reportType.equals(ReportType.PRODUCT)) {
/*  32 */       listHoaDonChiTiets = this.repo.findWithProductAndTimeBetween(startDate, endDate);
/*  33 */     } else if (reportType.equals(ReportType.ORDERDETAIL)) {
/*  34 */       listHoaDonChiTiets = this.repo.findWithOrderDetailAndTimeBetween(startDate, endDate);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  39 */     Set<String> identifiers = new HashSet<>();
/*  40 */     List<ReportItem> listReportItems = new ArrayList<>();
/*  41 */     for (HoaDonChiTiet detail : listHoaDonChiTiets) {
/*  42 */       String identifier = "";
/*     */       
/*  44 */       if (reportType.equals(ReportType.CATEGORY)) {
/*  45 */         identifier = detail.getChiTietSanPham().getSanPham().getDanhMuc().getTen();
/*  46 */       } else if (reportType.equals(ReportType.PRODUCT)) {
/*  47 */         identifier = detail.getChiTietSanPham().getSanPham().getTenSanPham();
/*  48 */       } else if (reportType.equals(ReportType.ORDERDETAIL)) {
/*  49 */         identifier = String.valueOf(detail.getIdHoaDonChiTiet());
/*     */       } 
/*     */       
/*  52 */       if (!identifiers.contains(identifier)) {
/*     */         
/*  54 */         listReportItems.add(new ReportItem(identifier));
/*  55 */         identifiers.add(identifier);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  60 */     for (HoaDonChiTiet detail : listHoaDonChiTiets) {
/*  61 */       String identifier = "";
/*     */       
/*  63 */       if (reportType.equals(ReportType.CATEGORY)) {
/*  64 */         identifier = detail.getChiTietSanPham().getSanPham().getDanhMuc().getTen();
/*  65 */       } else if (reportType.equals(ReportType.PRODUCT)) {
/*  66 */         identifier = detail.getChiTietSanPham().getSanPham().getTenSanPham();
/*  67 */       } else if (reportType.equals(ReportType.ORDERDETAIL)) {
/*  68 */         identifier = String.valueOf(detail.getIdHoaDonChiTiet());
/*     */       } 
/*     */       
/*  71 */       ReportItem reportItem = new ReportItem(identifier);
/*  72 */       double netSales = detail.getGiaBan().doubleValue() * detail.getSoLuong().intValue();
/*  73 */       double grossSales = netSales + detail.getDonHang().getPhiVanChuyen().doubleValue();
/*     */ 
/*     */       
/*  76 */       int itemIndex = listReportItems.indexOf(reportItem);
/*     */       
/*  78 */       if (itemIndex >= 0) {
/*  79 */         reportItem = listReportItems.get(itemIndex);
/*  80 */         reportItem.addGrossSales(Double.valueOf(grossSales));
/*  81 */         reportItem.addNetSales(Double.valueOf(netSales));
/*  82 */         reportItem.increaseProductsCount(detail.getSoLuong().intValue()); continue;
/*     */       } 
/*  84 */       listReportItems.add(new ReportItem(identifier, Double.valueOf(grossSales), Double.valueOf(netSales), detail.getSoLuong().intValue()));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     return listReportItems;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private void printReportData(List<ReportItem> listReportItems) {
/* 112 */     for (ReportItem item : listReportItems) {
/* 113 */       System.out.printf("%-20s, %.3f, %.3f, %d \n", new Object[] { item
/* 114 */             .getIdentifier(), item.getGrossSales(), item.getNetSales(), Integer.valueOf(item.getOrdersCount()) });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void printRawData(List<HoaDonChiTiet> listHoaDonChiTiets) {
/* 119 */     for (HoaDonChiTiet detail : listHoaDonChiTiets) {
/* 120 */       System.out.printf("%d, %-20s, %.3f, %.3f \n", new Object[] { detail
/* 121 */             .getSoLuong(), detail.getChiTietSanPham().getSanPham().getTenSanPham().substring(0, 20), 
/* 122 */             Double.valueOf(detail.getGiaBan().doubleValue() * detail.getSoLuong().intValue()), detail.getDonHang().getPhiVanChuyen() });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Service\impl\HoaDonChiTietReportServiceImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */