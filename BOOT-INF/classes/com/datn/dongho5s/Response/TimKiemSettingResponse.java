/*    */ package BOOT-INF.classes.com.datn.dongho5s.Response;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DanhMuc;
/*    */ import com.datn.dongho5s.Entity.DayDeo;
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Entity.MauSac;
/*    */ import com.datn.dongho5s.Entity.ThuongHieu;
/*    */ import com.datn.dongho5s.Entity.VatLieu;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TimKiemSettingResponse {
/*    */   private List<DanhMuc> listDanhMuc;
/*    */   private List<DayDeo> listDayDeo;
/*    */   private List<KichCo> listKichCo;
/*    */   
/* 16 */   public TimKiemSettingResponse(List<DanhMuc> listDanhMuc, List<DayDeo> listDayDeo, List<KichCo> listKichCo, List<MauSac> listMauSac, List<ThuongHieu> listThuongHieu, List<VatLieu> listVatLieu) { this.listDanhMuc = listDanhMuc; this.listDayDeo = listDayDeo; this.listKichCo = listKichCo; this.listMauSac = listMauSac; this.listThuongHieu = listThuongHieu; this.listVatLieu = listVatLieu; } private List<MauSac> listMauSac; private List<ThuongHieu> listThuongHieu; private List<VatLieu> listVatLieu; public void setListDanhMuc(List<DanhMuc> listDanhMuc) {
/* 17 */     this.listDanhMuc = listDanhMuc; } public void setListDayDeo(List<DayDeo> listDayDeo) { this.listDayDeo = listDayDeo; } public void setListKichCo(List<KichCo> listKichCo) { this.listKichCo = listKichCo; } public void setListMauSac(List<MauSac> listMauSac) { this.listMauSac = listMauSac; } public void setListThuongHieu(List<ThuongHieu> listThuongHieu) { this.listThuongHieu = listThuongHieu; } public void setListVatLieu(List<VatLieu> listVatLieu) { this.listVatLieu = listVatLieu; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.datn.dongho5s.Response.TimKiemSettingResponse)) return false;  com.datn.dongho5s.Response.TimKiemSettingResponse other = (com.datn.dongho5s.Response.TimKiemSettingResponse)o; if (!other.canEqual(this)) return false;  Object<DanhMuc> this$listDanhMuc = (Object<DanhMuc>)getListDanhMuc(), other$listDanhMuc = (Object<DanhMuc>)other.getListDanhMuc(); if ((this$listDanhMuc == null) ? (other$listDanhMuc != null) : !this$listDanhMuc.equals(other$listDanhMuc)) return false;  Object<DayDeo> this$listDayDeo = (Object<DayDeo>)getListDayDeo(), other$listDayDeo = (Object<DayDeo>)other.getListDayDeo(); if ((this$listDayDeo == null) ? (other$listDayDeo != null) : !this$listDayDeo.equals(other$listDayDeo)) return false;  Object<KichCo> this$listKichCo = (Object<KichCo>)getListKichCo(), other$listKichCo = (Object<KichCo>)other.getListKichCo(); if ((this$listKichCo == null) ? (other$listKichCo != null) : !this$listKichCo.equals(other$listKichCo)) return false;  Object<MauSac> this$listMauSac = (Object<MauSac>)getListMauSac(), other$listMauSac = (Object<MauSac>)other.getListMauSac(); if ((this$listMauSac == null) ? (other$listMauSac != null) : !this$listMauSac.equals(other$listMauSac)) return false;  Object<ThuongHieu> this$listThuongHieu = (Object<ThuongHieu>)getListThuongHieu(), other$listThuongHieu = (Object<ThuongHieu>)other.getListThuongHieu(); if ((this$listThuongHieu == null) ? (other$listThuongHieu != null) : !this$listThuongHieu.equals(other$listThuongHieu)) return false;  Object<VatLieu> this$listVatLieu = (Object<VatLieu>)getListVatLieu(), other$listVatLieu = (Object<VatLieu>)other.getListVatLieu(); return !((this$listVatLieu == null) ? (other$listVatLieu != null) : !this$listVatLieu.equals(other$listVatLieu)); } protected boolean canEqual(Object other) { return other instanceof com.datn.dongho5s.Response.TimKiemSettingResponse; } public int hashCode() { int PRIME = 59; result = 1; Object<DanhMuc> $listDanhMuc = (Object<DanhMuc>)getListDanhMuc(); result = result * 59 + (($listDanhMuc == null) ? 43 : $listDanhMuc.hashCode()); Object<DayDeo> $listDayDeo = (Object<DayDeo>)getListDayDeo(); result = result * 59 + (($listDayDeo == null) ? 43 : $listDayDeo.hashCode()); Object<KichCo> $listKichCo = (Object<KichCo>)getListKichCo(); result = result * 59 + (($listKichCo == null) ? 43 : $listKichCo.hashCode()); Object<MauSac> $listMauSac = (Object<MauSac>)getListMauSac(); result = result * 59 + (($listMauSac == null) ? 43 : $listMauSac.hashCode()); Object<ThuongHieu> $listThuongHieu = (Object<ThuongHieu>)getListThuongHieu(); result = result * 59 + (($listThuongHieu == null) ? 43 : $listThuongHieu.hashCode()); Object<VatLieu> $listVatLieu = (Object<VatLieu>)getListVatLieu(); return result * 59 + (($listVatLieu == null) ? 43 : $listVatLieu.hashCode()); } public String toString() { return "TimKiemSettingResponse(listDanhMuc=" + getListDanhMuc() + ", listDayDeo=" + getListDayDeo() + ", listKichCo=" + getListKichCo() + ", listMauSac=" + getListMauSac() + ", listThuongHieu=" + getListThuongHieu() + ", listVatLieu=" + getListVatLieu() + ")"; }
/*    */    public TimKiemSettingResponse() {} public static TimKiemSettingResponseBuilder builder() {
/* 19 */     return new TimKiemSettingResponseBuilder();
/*    */   }
/* 21 */   public List<DanhMuc> getListDanhMuc() { return this.listDanhMuc; }
/* 22 */   public List<DayDeo> getListDayDeo() { return this.listDayDeo; }
/* 23 */   public List<KichCo> getListKichCo() { return this.listKichCo; }
/* 24 */   public List<MauSac> getListMauSac() { return this.listMauSac; }
/* 25 */   public List<ThuongHieu> getListThuongHieu() { return this.listThuongHieu; } public List<VatLieu> getListVatLieu() {
/* 26 */     return this.listVatLieu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Response\TimKiemSettingResponse.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */