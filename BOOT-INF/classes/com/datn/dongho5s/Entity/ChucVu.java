/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "chucvu")
/*    */ public class ChucVu {
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id_chuc_vu")
/*    */   private Integer idChucVu;
/*    */   
/* 11 */   public ChucVu(Integer idChucVu, String tenChucVu, String mota) { this.idChucVu = idChucVu; this.tenChucVu = tenChucVu; this.mota = mota; } @Column(name = "ten_chuc_vu", length = 40, nullable = false, unique = true)
/*    */   private String tenChucVu; @Column(name = "TrangThai", length = 150, nullable = false)
/* 13 */   private String mota; public static ChucVuBuilder builder() { return new ChucVuBuilder(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChucVu() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChucVu(Integer idChucVu) {
/* 31 */     this.idChucVu = idChucVu;
/*    */   }
/*    */   
/*    */   public ChucVu(String tenChucVu) {
/* 35 */     this.tenChucVu = tenChucVu;
/*    */   }
/*    */   
/*    */   public ChucVu(String tenChucVu, String mota) {
/* 39 */     this.tenChucVu = tenChucVu;
/* 40 */     this.mota = mota;
/*    */   }
/*    */   
/*    */   public Integer getIdChucVu() {
/* 44 */     return this.idChucVu;
/*    */   }
/*    */   
/*    */   public void setIdChucVu(Integer idChucVu) {
/* 48 */     this.idChucVu = idChucVu;
/*    */   }
/*    */   
/*    */   public String getTenChucVu() {
/* 52 */     return this.tenChucVu;
/*    */   }
/*    */   
/*    */   public void setTenChucVu(String tenChucVu) {
/* 56 */     this.tenChucVu = tenChucVu;
/*    */   }
/*    */   
/*    */   public String getMota() {
/* 60 */     return this.mota;
/*    */   }
/*    */   
/*    */   public void setMota(String mota) {
/* 64 */     this.mota = mota;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 69 */     if (this == o) return true; 
/* 70 */     if (o == null || getClass() != o.getClass()) return false; 
/* 71 */     com.datn.dongho5s.Entity.ChucVu chucVu = (com.datn.dongho5s.Entity.ChucVu)o;
/* 72 */     return Objects.equals(this.idChucVu, chucVu.idChucVu);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 77 */     return Objects.hash(new Object[] { this.idChucVu });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 82 */     return this.tenChucVu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\ChucVu.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */