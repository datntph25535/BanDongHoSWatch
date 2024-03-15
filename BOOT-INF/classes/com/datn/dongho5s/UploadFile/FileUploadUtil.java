/*    */ package BOOT-INF.classes.com.datn.dongho5s.UploadFile;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.file.CopyOption;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.nio.file.StandardCopyOption;
/*    */ import java.nio.file.attribute.FileAttribute;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class FileUploadUtil
/*    */ {
/*    */   public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) {
/* 16 */     Path uploadPath = Paths.get(uploadDir, new String[0]);
/*    */     
/*    */     try {
/* 19 */       InputStream inputStream = multipartFile.getInputStream();
/* 20 */       if (!Files.exists(uploadPath, new java.nio.file.LinkOption[0])) {
/* 21 */         Files.createDirectories(uploadPath, (FileAttribute<?>[])new FileAttribute[0]);
/*    */       }
/* 23 */       Path filePath = uploadPath.resolve(fileName);
/* 24 */       Files.copy(inputStream, filePath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/* 25 */     } catch (IOException ex) {
/* 26 */       System.out.println(ex);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void cleanDir(String dir) {
/* 32 */     Path dirPath = Paths.get(dir, new String[0]);
/*    */     
/*    */     try {
/* 35 */       Files.list(dirPath).forEach(file -> {
/*    */             if (!Files.isDirectory(file, new java.nio.file.LinkOption[0])) {
/*    */               try {
/*    */                 Files.delete(file);
/* 39 */               } catch (IOException ex) {
/*    */                 System.out.println("không thể xóa tệp: " + file);
/*    */               } 
/*    */             }
/*    */           });
/* 44 */     } catch (IOException ex) {
/* 45 */       System.out.println("không thể liệt kê thư mục: " + dirPath);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\UploadFile\FileUploadUtil.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */