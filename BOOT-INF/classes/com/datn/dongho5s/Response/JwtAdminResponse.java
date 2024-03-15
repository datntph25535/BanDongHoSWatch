/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class JwtAdminResponse {
/*    */   private String token;
/*  7 */   private String type = "Bearer";
/*    */   
/*    */   private Integer id;
/*    */   private String ten;
/*    */   private String email;
/*    */   private List<String> listChucVu;
/*    */   
/*    */   public JwtAdminResponse(String token, Integer id, String ten, String email, List<String> listChucVu) {
/* 15 */     this.token = token;
/* 16 */     this.id = id;
/* 17 */     this.ten = ten;
/* 18 */     this.email = email;
/* 19 */     this.listChucVu = listChucVu;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 23 */     return this.token;
/*    */   }
/*    */   
/*    */   public void setToken(String token) {
/* 27 */     this.token = token;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 31 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 35 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 39 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 43 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getTen() {
/* 47 */     return this.ten;
/*    */   }
/*    */   
/*    */   public void setTen(String ten) {
/* 51 */     this.ten = ten;
/*    */   }
/*    */   
/*    */   public String getEmail() {
/* 55 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 59 */     this.email = email;
/*    */   }
/*    */   
/*    */   public List<String> getListChucVu() {
/* 63 */     return this.listChucVu;
/*    */   }
/*    */   
/*    */   public void setListChucVu(List<String> listChucVu) {
/* 67 */     this.listChucVu = listChucVu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\JwtAdminResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */