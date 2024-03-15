/*    */ package BOOT-INF.classes.com.datn.dongho5s.Entity;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.SanPham;
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.ManyToOne;
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "anhsanpham")
/*    */ public class AnhSanPham {
/*    */   @Id
/*    */   @Column(name = "id_anh_san_pham")
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Integer idAnhSanPham;
/*    */   @Column(name = "link")
/*    */   private String link;
/*    */   
/* 21 */   public void setIdAnhSanPham(Integer idAnhSanPham) { this.idAnhSanPham = idAnhSanPham; } @Column(name = "ten_anh") private String tenAnh; @JsonIgnore @ManyToOne @JoinColumn(name = "id_san_pham") private SanPham sanPham; public void setLink(String link) { this.link = link; } public void setTenAnh(String tenAnh) { this.tenAnh = tenAnh; } @JsonIgnore public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Entity.AnhSanPham)) return false;  com.datn.dongho5s.Entity.AnhSanPham other = (com.datn.dongho5s.Entity.AnhSanPham)o; if (!other.canEqual(this)) return false;  Object this$idAnhSanPham = getIdAnhSanPham(), other$idAnhSanPham = other.getIdAnhSanPham(); if ((this$idAnhSanPham == null) ? (other$idAnhSanPham != null) : !this$idAnhSanPham.equals(other$idAnhSanPham)) return false;  Object this$link = getLink(), other$link = other.getLink(); if ((this$link == null) ? (other$link != null) : !this$link.equals(other$link)) return false;  Object this$tenAnh = getTenAnh(), other$tenAnh = other.getTenAnh(); return !((this$tenAnh == null) ? (other$tenAnh != null) : !this$tenAnh.equals(other$tenAnh)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Entity.AnhSanPham; } public int hashCode() { int PRIME = 59; result = 1; Object $idAnhSanPham = getIdAnhSanPham(); result = result * 59 + (($idAnhSanPham == null) ? 43 : $idAnhSanPham.hashCode()); Object $link = getLink(); result = result * 59 + (($link == null) ? 43 : $link.hashCode()); Object $tenAnh = getTenAnh(); return result * 59 + (($tenAnh == null) ? 43 : $tenAnh.hashCode()); } public String toString() { return "AnhSanPham(idAnhSanPham=" + getIdAnhSanPham() + ", link=" + getLink() + ", tenAnh=" + getTenAnh() + ")"; } public AnhSanPham(Integer idAnhSanPham, String link, String tenAnh, SanPham sanPham) {
/* 22 */     this.idAnhSanPham = idAnhSanPham; this.link = link; this.tenAnh = tenAnh; this.sanPham = sanPham;
/*    */   } public AnhSanPham() {} public static AnhSanPhamBuilder builder() {
/* 24 */     return new AnhSanPhamBuilder();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getIdAnhSanPham() {
/* 30 */     return this.idAnhSanPham;
/*    */   }
/*    */   public String getLink() {
/* 33 */     return this.link;
/*    */   }
/*    */   public String getTenAnh() {
/* 36 */     return this.tenAnh;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SanPham getSanPham() {
/* 43 */     return this.sanPham;
/*    */   }
/*    */   public AnhSanPham(String tenAnh, SanPham sanPham) {
/* 46 */     this.tenAnh = tenAnh;
/* 47 */     this.sanPham = sanPham;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Entity\AnhSanPham.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */