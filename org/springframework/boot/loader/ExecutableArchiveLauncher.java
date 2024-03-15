/*     */ package org.springframework.boot.loader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.jar.Manifest;
/*     */ import org.springframework.boot.loader.archive.Archive;
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
/*     */ public abstract class ExecutableArchiveLauncher
/*     */   extends Launcher
/*     */ {
/*     */   private static final String START_CLASS_ATTRIBUTE = "Start-Class";
/*     */   protected static final String BOOT_CLASSPATH_INDEX_ATTRIBUTE = "Spring-Boot-Classpath-Index";
/*     */   private final Archive archive;
/*     */   private final ClassPathIndexFile classPathIndex;
/*     */   
/*     */   public ExecutableArchiveLauncher() {
/*     */     try {
/*  48 */       this.archive = createArchive();
/*  49 */       this.classPathIndex = getClassPathIndex(this.archive);
/*     */     }
/*  51 */     catch (Exception ex) {
/*  52 */       throw new IllegalStateException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ExecutableArchiveLauncher(Archive archive) {
/*     */     try {
/*  58 */       this.archive = archive;
/*  59 */       this.classPathIndex = getClassPathIndex(this.archive);
/*     */     }
/*  61 */     catch (Exception ex) {
/*  62 */       throw new IllegalStateException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ClassPathIndexFile getClassPathIndex(Archive archive) throws IOException {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getMainClass() throws Exception {
/*  72 */     Manifest manifest = this.archive.getManifest();
/*  73 */     String mainClass = null;
/*  74 */     if (manifest != null) {
/*  75 */       mainClass = manifest.getMainAttributes().getValue("Start-Class");
/*     */     }
/*  77 */     if (mainClass == null) {
/*  78 */       throw new IllegalStateException("No 'Start-Class' manifest entry specified in " + this);
/*     */     }
/*  80 */     return mainClass;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ClassLoader createClassLoader(Iterator<Archive> archives) throws Exception {
/*  85 */     List<URL> urls = new ArrayList<>(guessClassPathSize());
/*  86 */     while (archives.hasNext()) {
/*  87 */       urls.add(((Archive)archives.next()).getUrl());
/*     */     }
/*  89 */     if (this.classPathIndex != null) {
/*  90 */       urls.addAll(this.classPathIndex.getUrls());
/*     */     }
/*  92 */     return createClassLoader(urls.<URL>toArray(new URL[0]));
/*     */   }
/*     */   
/*     */   private int guessClassPathSize() {
/*  96 */     if (this.classPathIndex != null) {
/*  97 */       return this.classPathIndex.size() + 10;
/*     */     }
/*  99 */     return 50;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Iterator<Archive> getClassPathArchivesIterator() throws Exception {
/* 104 */     Archive.EntryFilter searchFilter = this::isSearchCandidate;
/* 105 */     Iterator<Archive> archives = this.archive.getNestedArchives(searchFilter, entry -> 
/* 106 */         (isNestedArchive(entry) && !isEntryIndexed(entry)));
/* 107 */     if (isPostProcessingClassPathArchives()) {
/* 108 */       archives = applyClassPathArchivePostProcessing(archives);
/*     */     }
/* 110 */     return archives;
/*     */   }
/*     */   
/*     */   private boolean isEntryIndexed(Archive.Entry entry) {
/* 114 */     if (this.classPathIndex != null) {
/* 115 */       return this.classPathIndex.containsEntry(entry.getName());
/*     */     }
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   private Iterator<Archive> applyClassPathArchivePostProcessing(Iterator<Archive> archives) throws Exception {
/* 121 */     List<Archive> list = new ArrayList<>();
/* 122 */     while (archives.hasNext()) {
/* 123 */       list.add(archives.next());
/*     */     }
/* 125 */     postProcessClassPathArchives(list);
/* 126 */     return list.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSearchCandidate(Archive.Entry entry) {
/* 136 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isPostProcessingClassPathArchives() {
/* 156 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void postProcessClassPathArchives(List<Archive> archives) throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isExploded() {
/* 171 */     return this.archive.isExploded();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Archive getArchive() {
/* 176 */     return this.archive;
/*     */   }
/*     */   
/*     */   protected abstract boolean isNestedArchive(Archive.Entry paramEntry);
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\ExecutableArchiveLauncher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */