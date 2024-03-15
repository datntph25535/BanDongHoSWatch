/*    */ package org.springframework.boot.loader.jar;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.security.Permission;
/*    */ import java.util.jar.JarFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class AbstractJarFile
/*    */   extends JarFile
/*    */ {
/*    */   AbstractJarFile(File file) throws IOException {
/* 39 */     super(file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   abstract URL getUrl() throws MalformedURLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   abstract JarFileType getType();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   abstract Permission getPermission();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   abstract InputStream getInputStream() throws IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   enum JarFileType
/*    */   {
/* 74 */     DIRECT, NESTED_DIRECTORY, NESTED_JAR;
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\AbstractJarFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */