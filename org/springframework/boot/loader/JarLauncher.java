/*    */ package org.springframework.boot.loader;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.jar.Attributes;
/*    */ import java.util.jar.Manifest;
/*    */ import org.springframework.boot.loader.archive.Archive;
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
/*    */ 
/*    */ 
/*    */ public class JarLauncher
/*    */   extends ExecutableArchiveLauncher
/*    */ {
/*    */   private static final String DEFAULT_CLASSPATH_INDEX_LOCATION = "BOOT-INF/classpath.idx";
/*    */   static final Archive.EntryFilter NESTED_ARCHIVE_ENTRY_FILTER;
/*    */   
/*    */   static {
/* 41 */     NESTED_ARCHIVE_ENTRY_FILTER = (entry -> entry.isDirectory() ? entry.getName().equals("BOOT-INF/classes/") : entry.getName().startsWith("BOOT-INF/lib/"));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JarLauncher() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected JarLauncher(Archive archive) {
/* 52 */     super(archive);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ClassPathIndexFile getClassPathIndex(Archive archive) throws IOException {
/* 58 */     if (archive instanceof org.springframework.boot.loader.archive.ExplodedArchive) {
/* 59 */       String location = getClassPathIndexFileLocation(archive);
/* 60 */       return ClassPathIndexFile.loadIfPossible(archive.getUrl(), location);
/*    */     } 
/* 62 */     return super.getClassPathIndex(archive);
/*    */   }
/*    */   
/*    */   private String getClassPathIndexFileLocation(Archive archive) throws IOException {
/* 66 */     Manifest manifest = archive.getManifest();
/* 67 */     Attributes attributes = (manifest != null) ? manifest.getMainAttributes() : null;
/* 68 */     String location = (attributes != null) ? attributes.getValue("Spring-Boot-Classpath-Index") : null;
/* 69 */     return (location != null) ? location : "BOOT-INF/classpath.idx";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isPostProcessingClassPathArchives() {
/* 74 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isSearchCandidate(Archive.Entry entry) {
/* 79 */     return entry.getName().startsWith("BOOT-INF/");
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isNestedArchive(Archive.Entry entry) {
/* 84 */     return NESTED_ARCHIVE_ENTRY_FILTER.matches(entry);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws Exception {
/* 88 */     (new JarLauncher()).launch(args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\JarLauncher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */