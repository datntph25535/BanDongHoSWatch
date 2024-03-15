/*     */ package org.springframework.boot.loader.jar;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.security.Permission;
/*     */ import java.util.Enumeration;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.jar.Manifest;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.zip.ZipEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class JarFileWrapper
/*     */   extends AbstractJarFile
/*     */ {
/*     */   private final JarFile parent;
/*     */   
/*     */   JarFileWrapper(JarFile parent) throws IOException {
/*  41 */     super(parent.getRootJarFile().getFile());
/*  42 */     this.parent = parent;
/*  43 */     close();
/*     */   }
/*     */ 
/*     */   
/*     */   URL getUrl() throws MalformedURLException {
/*  48 */     return this.parent.getUrl();
/*     */   }
/*     */ 
/*     */   
/*     */   AbstractJarFile.JarFileType getType() {
/*  53 */     return this.parent.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   Permission getPermission() {
/*  58 */     return this.parent.getPermission();
/*     */   }
/*     */ 
/*     */   
/*     */   public Manifest getManifest() throws IOException {
/*  63 */     return this.parent.getManifest();
/*     */   }
/*     */ 
/*     */   
/*     */   public Enumeration<JarEntry> entries() {
/*  68 */     return this.parent.entries();
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<JarEntry> stream() {
/*  73 */     return this.parent.stream();
/*     */   }
/*     */ 
/*     */   
/*     */   public JarEntry getJarEntry(String name) {
/*  78 */     return this.parent.getJarEntry(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public ZipEntry getEntry(String name) {
/*  83 */     return this.parent.getEntry(name);
/*     */   }
/*     */ 
/*     */   
/*     */   InputStream getInputStream() throws IOException {
/*  88 */     return this.parent.getInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized InputStream getInputStream(ZipEntry ze) throws IOException {
/*  93 */     return this.parent.getInputStream(ze);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComment() {
/*  98 */     return this.parent.getComment();
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 103 */     return this.parent.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     return this.parent.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 113 */     return this.parent.getName();
/*     */   }
/*     */   
/*     */   static JarFile unwrap(JarFile jarFile) {
/* 117 */     if (jarFile instanceof JarFile) {
/* 118 */       return (JarFile)jarFile;
/*     */     }
/* 120 */     if (jarFile instanceof JarFileWrapper) {
/* 121 */       return unwrap(((JarFileWrapper)jarFile).parent);
/*     */     }
/* 123 */     throw new IllegalStateException("Not a JarFile or Wrapper");
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\JarFileWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */