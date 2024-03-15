/*     */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*     */ 
/*     */ import java.util.Objects;
/*     */ 
/*     */ public class ReportItem {
/*     */   private String identifier;
/*     */   private Double grossSales;
/*     */   private Double netSales;
/*     */   
/*  10 */   public String toString() { return "ReportItem(identifier=" + getIdentifier() + ", grossSales=" + getGrossSales() + ", netSales=" + getNetSales() + ", ordersCount=" + getOrdersCount() + ", productsCount=" + getProductsCount() + ", status=" + getStatus() + ")"; } private int ordersCount; private int productsCount; private int status; public ReportItem(String identifier, Double grossSales, Double netSales, int ordersCount, int productsCount, int status) {
/*  11 */     this.identifier = identifier; this.grossSales = grossSales; this.netSales = netSales; this.ordersCount = ordersCount; this.productsCount = productsCount; this.status = status;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportItem() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ReportItem(String identifier, Double grossSales, Double netSales) {
/*  22 */     this.identifier = identifier;
/*  23 */     this.grossSales = grossSales;
/*  24 */     this.netSales = netSales;
/*     */   }
/*     */   
/*     */   public ReportItem(Integer status) {
/*  28 */     this.status = status.intValue();
/*     */   }
/*     */   
/*     */   public ReportItem(Double grossSales) {
/*  32 */     this.grossSales = grossSales;
/*     */   }
/*     */   
/*     */   public ReportItem(int ordersCount) {
/*  36 */     this.ordersCount = ordersCount;
/*     */   }
/*     */   
/*     */   public ReportItem(String identifier) {
/*  40 */     this.identifier = identifier;
/*     */   }
/*     */ 
/*     */   
/*     */   public ReportItem(String identifier, Double grossSales, Double netSales, int productsCount) {
/*  45 */     this.identifier = identifier;
/*  46 */     this.grossSales = grossSales;
/*  47 */     this.netSales = netSales;
/*  48 */     this.productsCount = productsCount;
/*     */   }
/*     */   
/*     */   public String getIdentifier() {
/*  52 */     return this.identifier;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/*  56 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(int status) {
/*  60 */     this.status = status;
/*     */   }
/*     */   
/*     */   public void setIdentifier(String identifier) {
/*  64 */     this.identifier = identifier;
/*     */   }
/*     */   
/*     */   public Double getGrossSales() {
/*  68 */     return this.grossSales;
/*     */   }
/*     */   
/*     */   public void setGrossSales(Double grossSales) {
/*  72 */     this.grossSales = grossSales;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGrossSales() {
/*  77 */     this.grossSales = this.grossSales;
/*     */   }
/*     */   public Double getNetSales() {
/*  80 */     return this.netSales;
/*     */   }
/*     */   
/*     */   public void setNetSales(Double netSales) {
/*  84 */     this.netSales = netSales;
/*     */   }
/*     */   
/*     */   public int getOrdersCount() {
/*  88 */     return this.ordersCount;
/*     */   }
/*     */   
/*     */   public void setOrdersCount(int ordersCount) {
/*  92 */     this.ordersCount = ordersCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  97 */     if (this == o) return true; 
/*  98 */     if (!(o instanceof com.datn.dongho5s.Entity.ReportItem)) return false; 
/*  99 */     com.datn.dongho5s.Entity.ReportItem that = (com.datn.dongho5s.Entity.ReportItem)o;
/* 100 */     return getIdentifier().equals(that.getIdentifier());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return Objects.hash(new Object[] { getIdentifier() });
/*     */   }
/*     */   
/*     */   public void addGrossSales(Double amount) {
/* 109 */     if (this.grossSales == null) {
/* 110 */       this.grossSales = Double.valueOf(0.0D);
/*     */     }
/* 112 */     this.grossSales = Double.valueOf(this.grossSales.doubleValue() + amount.doubleValue());
/*     */   }
/*     */   
/*     */   public void addStatus(int amount) {
/* 116 */     if (this.status == 0) {
/* 117 */       this.status = amount;
/*     */     } else {
/* 119 */       this.status += amount;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addNetSales(Double amount) {
/* 124 */     if (this.netSales == null) {
/* 125 */       this.netSales = Double.valueOf(0.0D);
/*     */     }
/* 127 */     this.netSales = Double.valueOf(this.netSales.doubleValue() + amount.doubleValue());
/*     */   }
/*     */   
/*     */   public void increaseOrderCount() {
/* 131 */     this.ordersCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProductsCount() {
/* 136 */     return this.productsCount;
/*     */   }
/*     */   
/*     */   public void setProductsCount(int productsCount) {
/* 140 */     this.productsCount = productsCount;
/*     */   }
/*     */   
/*     */   public void increaseProductsCount(int count) {
/* 144 */     this.productsCount += count;
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\ReportItem.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */