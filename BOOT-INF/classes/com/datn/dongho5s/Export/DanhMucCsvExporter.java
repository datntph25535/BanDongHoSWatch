/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.DanhMuc;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.supercsv.io.CsvBeanWriter;
/*    */ import org.supercsv.prefs.CsvPreference;
/*    */ 
/*    */ public class DanhMucCsvExporter
/*    */   extends AbstractExporter {
/*    */   public void export(List<DanhMuc> listDanhMuc, HttpServletResponse response) throws IOException {
/* 14 */     setResponseHeader(response, "text/csv", ".csv", "categories_");
/*    */     
/* 16 */     CsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
/*    */     
/* 18 */     String[] csvHeader = { "ID", "Name", "Enabled" };
/* 19 */     String[] filedMapping = { "id", "ten", "enabled" };
/*    */     
/* 21 */     csvBeanWriter.writeHeader(csvHeader);
/* 22 */     for (DanhMuc danhMuc : listDanhMuc) {
/* 23 */       csvBeanWriter.write(danhMuc, filedMapping);
/*    */     }
/* 25 */     csvBeanWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\DanhMucCsvExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */