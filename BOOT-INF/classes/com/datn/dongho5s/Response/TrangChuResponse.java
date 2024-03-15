/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Response.SanPhamDetailResponse;
/*    */ 
/*    */ public class TrangChuResponse {
/*    */   private List<SanPhamDetailResponse> listSPbanChay;
/*    */   private List<SanPhamDetailResponse> listSPmoiNhat;
/*    */   private List<SanPhamDetailResponse> listSPNoiBat;
/*    */   
/*    */   public TrangChuResponse() {}
/*    */   
/* 12 */   public TrangChuResponse(List<SanPhamDetailResponse> listSPbanChay, List<SanPhamDetailResponse> listSPmoiNhat, List<SanPhamDetailResponse> listSPNoiBat) { this.listSPbanChay = listSPbanChay; this.listSPmoiNhat = listSPmoiNhat; this.listSPNoiBat = listSPNoiBat; }
/* 13 */   public void setListSPbanChay(List<SanPhamDetailResponse> listSPbanChay) { this.listSPbanChay = listSPbanChay; } public void setListSPmoiNhat(List<SanPhamDetailResponse> listSPmoiNhat) { this.listSPmoiNhat = listSPmoiNhat; } public void setListSPNoiBat(List<SanPhamDetailResponse> listSPNoiBat) { this.listSPNoiBat = listSPNoiBat; }
/*    */ 
/*    */   
/* 16 */   public List<SanPhamDetailResponse> getListSPbanChay() { return this.listSPbanChay; }
/* 17 */   public List<SanPhamDetailResponse> getListSPmoiNhat() { return this.listSPmoiNhat; } public List<SanPhamDetailResponse> getListSPNoiBat() {
/* 18 */     return this.listSPNoiBat;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\TrangChuResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */