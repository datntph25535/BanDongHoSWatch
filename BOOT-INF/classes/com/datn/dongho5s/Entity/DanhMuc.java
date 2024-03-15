/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "danhmuc")
/*    */ public class DanhMuc {
/*    */   public static DanhMucBuilder builder() {
/* 12 */     return new DanhMucBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   @Id
/*    */   @Column(name = "id")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer id;
/*    */   
/*    */   @Column(name = "ten", length = 128, nullable = false, unique = true)
/*    */   private String ten;
/*    */   
/*    */   @Column(name = "enabled", nullable = false)
/*    */   private boolean enabled;
/*    */   
/*    */   public DanhMuc() {}
/*    */   
/*    */   public DanhMuc(Integer id, String ten) {
/* 30 */     this.id = id;
/* 31 */     this.ten = ten;
/*    */   }
/*    */   
/*    */   public DanhMuc(Integer id, String ten, boolean enabled) {
/* 35 */     this.id = id;
/* 36 */     this.ten = ten;
/* 37 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 41 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 45 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getTen() {
/* 49 */     return this.ten;
/*    */   }
/*    */   
/*    */   public void setTen(String ten) {
/* 53 */     this.ten = ten;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 57 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 61 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public DanhMuc(String ten) {
/* 65 */     this.ten = ten;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\DanhMuc.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */