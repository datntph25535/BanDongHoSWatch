/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.NhanVien;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.supercsv.io.CsvBeanWriter;
/*    */ import org.supercsv.prefs.CsvPreference;
/*    */ 
/*    */ public class NhanVienCsvExporter
/*    */   extends AbstractExporter
/*    */ {
/*    */   public void export(List<NhanVien> listNhanVien, HttpServletResponse response) throws IOException {
/* 15 */     setResponseHeader(response, "text/csv", ".csv", "users_");
/*    */     
/* 17 */     CsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
/*    */     
/* 19 */     String[] csvHeader = { "User ID", "Adress", "E-mail", "LastName", "FirstName", "Phone", "Roles", "Enabled" };
/* 20 */     String[] filedMapping = { "id", "diaChi", "email", "ho", "ten", "soDienThoai", "chucVu", "enabled" };
/*    */     
/* 22 */     csvBeanWriter.writeHeader(csvHeader);
/* 23 */     for (NhanVien nhanVien : listNhanVien) {
/* 24 */       csvBeanWriter.write(nhanVien, filedMapping);
/*    */     }
/* 26 */     csvBeanWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\NhanVienCsvExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */