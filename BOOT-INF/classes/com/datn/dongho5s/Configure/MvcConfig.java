/*    */ package BOOT-INF.classes.com.datn.dongho5s.Configure;
/*    */ 
/*    */ import com.datn.dongho5s.Utils.DateToTimestampConverter;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.core.convert.converter.Converter;
/*    */ import org.springframework.format.FormatterRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class MvcConfig
/*    */   implements WebMvcConfigurer
/*    */ {
/*    */   public void addResourceHandlers(ResourceHandlerRegistry registry) {
/* 19 */     String dirName = "user-photos";
/* 20 */     Path nhanVienPhotosDir = Paths.get(dirName, new String[0]);
/* 21 */     String nhanVienPhotosPath = nhanVienPhotosDir.toFile().getAbsolutePath();
/*    */     
/* 23 */     registry.addResourceHandler(new String[] { "/" + dirName + "/**"
/* 24 */         }).addResourceLocations(new String[] { "file:/" + nhanVienPhotosPath + "/" });
/*    */     
/* 26 */     String productDirName = "static/assets/products-images";
/* 27 */     Path productImagesDir = Paths.get(productDirName, new String[0]);
/* 28 */     String productImagesPath = productImagesDir.toFile().getAbsolutePath();
/*    */     
/* 30 */     registry.addResourceHandler(new String[] { "/static/assets/images/**"
/* 31 */         }).addResourceLocations(new String[] { "/static/assets/images/" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void addFormatters(FormatterRegistry registry) {
/* 36 */     registry.addConverter((Converter)new DateToTimestampConverter());
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Configure\MvcConfig.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */