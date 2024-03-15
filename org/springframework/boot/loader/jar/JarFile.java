/*     */ package org.springframework.boot.loader.jar;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FilePermission;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.security.Permission;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.Manifest;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.stream.StreamSupport;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.springframework.boot.loader.data.RandomAccessData;
/*     */ import org.springframework.boot.loader.data.RandomAccessDataFile;
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
/*     */ public class JarFile
/*     */   extends AbstractJarFile
/*     */   implements Iterable<JarEntry>
/*     */ {
/*     */   private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
/*     */   private static final String PROTOCOL_HANDLER = "java.protocol.handler.pkgs";
/*     */   private static final String HANDLERS_PACKAGE = "org.springframework.boot.loader";
/*  64 */   private static final AsciiBytes META_INF = new AsciiBytes("META-INF/");
/*     */   
/*  66 */   private static final AsciiBytes SIGNATURE_FILE_EXTENSION = new AsciiBytes(".SF");
/*     */ 
/*     */   
/*     */   private static final String READ_ACTION = "read";
/*     */ 
/*     */   
/*     */   private final RandomAccessDataFile rootFile;
/*     */ 
/*     */   
/*     */   private final String pathFromRoot;
/*     */ 
/*     */   
/*     */   private final RandomAccessData data;
/*     */   
/*     */   private final AbstractJarFile.JarFileType type;
/*     */   
/*     */   private URL url;
/*     */   
/*     */   private String urlString;
/*     */   
/*     */   private JarFileEntries entries;
/*     */   
/*     */   private Supplier<Manifest> manifestSupplier;
/*     */   
/*     */   private SoftReference<Manifest> manifest;
/*     */   
/*     */   private boolean signed;
/*     */   
/*     */   private String comment;
/*     */   
/*     */   private volatile boolean closed;
/*     */ 
/*     */   
/*     */   public JarFile(File file) throws IOException {
/* 100 */     this(new RandomAccessDataFile(file));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JarFile(RandomAccessDataFile file) throws IOException {
/* 109 */     this(file, "", (RandomAccessData)file, AbstractJarFile.JarFileType.DIRECT);
/*     */   }
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
/*     */   private JarFile(RandomAccessDataFile rootFile, String pathFromRoot, RandomAccessData data, AbstractJarFile.JarFileType type) throws IOException {
/* 123 */     this(rootFile, pathFromRoot, data, null, type, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private JarFile(RandomAccessDataFile rootFile, String pathFromRoot, RandomAccessData data, JarEntryFilter filter, AbstractJarFile.JarFileType type, Supplier<Manifest> manifestSupplier) throws IOException {
/* 128 */     super(rootFile.getFile());
/* 129 */     super.close();
/* 130 */     this.rootFile = rootFile;
/* 131 */     this.pathFromRoot = pathFromRoot;
/* 132 */     CentralDirectoryParser parser = new CentralDirectoryParser();
/* 133 */     this.entries = parser.<JarFileEntries>addVisitor(new JarFileEntries(this, filter));
/* 134 */     this.type = type;
/* 135 */     parser.addVisitor(centralDirectoryVisitor());
/*     */     try {
/* 137 */       this.data = parser.parse(data, (filter == null));
/*     */     }
/* 139 */     catch (RuntimeException ex) {
/* 140 */       close();
/* 141 */       throw ex;
/*     */     } 
/* 143 */     this.manifestSupplier = (manifestSupplier != null) ? manifestSupplier : (() -> {
/*     */         try (InputStream inputStream = getInputStream("META-INF/MANIFEST.MF")) {
/*     */           if (inputStream == null) {
/*     */             return null;
/*     */           }
/*     */           
/*     */           return new Manifest(inputStream);
/* 150 */         } catch (IOException ex) {
/*     */           throw new RuntimeException(ex);
/*     */         } 
/*     */       });
/*     */   }
/*     */   
/*     */   private CentralDirectoryVisitor centralDirectoryVisitor() {
/* 157 */     return new CentralDirectoryVisitor()
/*     */       {
/*     */         public void visitStart(CentralDirectoryEndRecord endRecord, RandomAccessData centralDirectoryData)
/*     */         {
/* 161 */           JarFile.this.comment = endRecord.getComment();
/*     */         }
/*     */ 
/*     */         
/*     */         public void visitFileHeader(CentralDirectoryFileHeader fileHeader, int dataOffset) {
/* 166 */           AsciiBytes name = fileHeader.getName();
/* 167 */           if (name.startsWith(JarFile.META_INF) && name.endsWith(JarFile.SIGNATURE_FILE_EXTENSION)) {
/* 168 */             JarFile.this.signed = true;
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void visitEnd() {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Permission getPermission() {
/* 181 */     return new FilePermission(this.rootFile.getFile().getPath(), "read");
/*     */   }
/*     */   
/*     */   protected final RandomAccessDataFile getRootJarFile() {
/* 185 */     return this.rootFile;
/*     */   }
/*     */   
/*     */   RandomAccessData getData() {
/* 189 */     return this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   public Manifest getManifest() throws IOException {
/* 194 */     Manifest manifest = (this.manifest != null) ? this.manifest.get() : null;
/* 195 */     if (manifest == null) {
/*     */       try {
/* 197 */         manifest = this.manifestSupplier.get();
/*     */       }
/* 199 */       catch (RuntimeException ex) {
/* 200 */         throw new IOException(ex);
/*     */       } 
/* 202 */       this.manifest = new SoftReference<>(manifest);
/*     */     } 
/* 204 */     return manifest;
/*     */   }
/*     */ 
/*     */   
/*     */   public Enumeration<JarEntry> entries() {
/* 209 */     return new JarEntryEnumeration(this.entries.iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<JarEntry> stream() {
/* 214 */     Spliterator<JarEntry> spliterator = Spliterators.spliterator(iterator(), size(), 1297);
/*     */     
/* 216 */     return StreamSupport.stream(spliterator, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<JarEntry> iterator() {
/* 227 */     return (Iterator)this.entries.iterator(this::ensureOpen);
/*     */   }
/*     */   
/*     */   public JarEntry getJarEntry(CharSequence name) {
/* 231 */     return this.entries.getEntry(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public JarEntry getJarEntry(String name) {
/* 236 */     return (JarEntry)getEntry(name);
/*     */   }
/*     */   
/*     */   public boolean containsEntry(String name) {
/* 240 */     return this.entries.containsEntry(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public ZipEntry getEntry(String name) {
/* 245 */     ensureOpen();
/* 246 */     return this.entries.getEntry(name);
/*     */   }
/*     */ 
/*     */   
/*     */   InputStream getInputStream() throws IOException {
/* 251 */     return this.data.getInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized InputStream getInputStream(ZipEntry entry) throws IOException {
/* 256 */     ensureOpen();
/* 257 */     if (entry instanceof JarEntry) {
/* 258 */       return this.entries.getInputStream((JarEntry)entry);
/*     */     }
/* 260 */     return getInputStream((entry != null) ? entry.getName() : null);
/*     */   }
/*     */   
/*     */   InputStream getInputStream(String name) throws IOException {
/* 264 */     return this.entries.getInputStream(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized JarFile getNestedJarFile(ZipEntry entry) throws IOException {
/* 274 */     return getNestedJarFile((JarEntry)entry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized JarFile getNestedJarFile(JarEntry entry) throws IOException {
/*     */     try {
/* 285 */       return createJarFileFromEntry(entry);
/*     */     }
/* 287 */     catch (Exception ex) {
/* 288 */       throw new IOException("Unable to open nested jar file '" + entry.getName() + "'", ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private JarFile createJarFileFromEntry(JarEntry entry) throws IOException {
/* 293 */     if (entry.isDirectory()) {
/* 294 */       return createJarFileFromDirectoryEntry(entry);
/*     */     }
/* 296 */     return createJarFileFromFileEntry(entry);
/*     */   }
/*     */   
/*     */   private JarFile createJarFileFromDirectoryEntry(JarEntry entry) throws IOException {
/* 300 */     AsciiBytes name = entry.getAsciiBytesName();
/* 301 */     JarEntryFilter filter = candidate -> 
/* 302 */       (candidate.startsWith(name) && !candidate.equals(name)) ? candidate.substring(name.length()) : null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     return new JarFile(this.rootFile, this.pathFromRoot + "!/" + entry.getName().substring(0, name.length() - 1), this.data, filter, AbstractJarFile.JarFileType.NESTED_DIRECTORY, this.manifestSupplier);
/*     */   }
/*     */ 
/*     */   
/*     */   private JarFile createJarFileFromFileEntry(JarEntry entry) throws IOException {
/* 312 */     if (entry.getMethod() != 0) {
/* 313 */       throw new IllegalStateException("Unable to open nested entry '" + entry
/* 314 */           .getName() + "'. It has been compressed and nested jar files must be stored without compression. Please check the mechanism used to create your executable jar file");
/*     */     }
/*     */ 
/*     */     
/* 318 */     RandomAccessData entryData = this.entries.getEntryData(entry.getName());
/* 319 */     return new JarFile(this.rootFile, this.pathFromRoot + "!/" + entry.getName(), entryData, AbstractJarFile.JarFileType.NESTED_JAR);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 325 */     ensureOpen();
/* 326 */     return this.comment;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 331 */     ensureOpen();
/* 332 */     return this.entries.getSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 337 */     if (this.closed) {
/*     */       return;
/*     */     }
/* 340 */     this.closed = true;
/* 341 */     if (this.type == AbstractJarFile.JarFileType.DIRECT) {
/* 342 */       this.rootFile.close();
/*     */     }
/*     */   }
/*     */   
/*     */   private void ensureOpen() {
/* 347 */     if (this.closed) {
/* 348 */       throw new IllegalStateException("zip file closed");
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isClosed() {
/* 353 */     return this.closed;
/*     */   }
/*     */   
/*     */   String getUrlString() throws MalformedURLException {
/* 357 */     if (this.urlString == null) {
/* 358 */       this.urlString = getUrl().toString();
/*     */     }
/* 360 */     return this.urlString;
/*     */   }
/*     */ 
/*     */   
/*     */   public URL getUrl() throws MalformedURLException {
/* 365 */     if (this.url == null) {
/* 366 */       String file = this.rootFile.getFile().toURI() + this.pathFromRoot + "!/";
/* 367 */       file = file.replace("file:////", "file://");
/* 368 */       this.url = new URL("jar", "", -1, file, new Handler(this));
/*     */     } 
/* 370 */     return this.url;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 375 */     return getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 380 */     return this.rootFile.getFile() + this.pathFromRoot;
/*     */   }
/*     */   
/*     */   boolean isSigned() {
/* 384 */     return this.signed;
/*     */   }
/*     */   
/*     */   JarEntryCertification getCertification(JarEntry entry) {
/*     */     try {
/* 389 */       return this.entries.getCertification(entry);
/*     */     }
/* 391 */     catch (IOException ex) {
/* 392 */       throw new IllegalStateException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearCache() {
/* 397 */     this.entries.clearCache();
/*     */   }
/*     */   
/*     */   protected String getPathFromRoot() {
/* 401 */     return this.pathFromRoot;
/*     */   }
/*     */ 
/*     */   
/*     */   AbstractJarFile.JarFileType getType() {
/* 406 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerUrlProtocolHandler() {
/* 414 */     Handler.captureJarContextUrl();
/* 415 */     String handlers = System.getProperty("java.protocol.handler.pkgs", "");
/* 416 */     System.setProperty("java.protocol.handler.pkgs", (handlers == null || handlers
/* 417 */         .isEmpty()) ? "org.springframework.boot.loader" : (handlers + "|" + "org.springframework.boot.loader"));
/* 418 */     resetCachedUrlHandlers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void resetCachedUrlHandlers() {
/*     */     try {
/* 428 */       URL.setURLStreamHandlerFactory(null);
/*     */     }
/* 430 */     catch (Error error) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class JarEntryEnumeration
/*     */     implements Enumeration<JarEntry>
/*     */   {
/*     */     private final Iterator<JarEntry> iterator;
/*     */ 
/*     */ 
/*     */     
/*     */     JarEntryEnumeration(Iterator<JarEntry> iterator) {
/* 443 */       this.iterator = iterator;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasMoreElements() {
/* 448 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public JarEntry nextElement() {
/* 453 */       return this.iterator.next();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\JarFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */