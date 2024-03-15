/*     */ package org.springframework.boot.loader.jar;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.Manifest;
/*     */ import org.springframework.boot.loader.data.RandomAccessData;
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
/*     */ class JarFileEntries
/*     */   implements CentralDirectoryVisitor, Iterable<JarEntry>
/*     */ {
/*     */   static {
/*     */     int version;
/*     */   }
/*     */   
/*     */   private static final Runnable NO_VALIDATION = () -> {
/*     */     
/*     */     };
/*     */   private static final String META_INF_PREFIX = "META-INF/";
/*  56 */   private static final Attributes.Name MULTI_RELEASE = new Attributes.Name("Multi-Release");
/*     */   
/*     */   private static final int BASE_VERSION = 8;
/*     */   
/*     */   private static final int RUNTIME_VERSION;
/*     */   private static final long LOCAL_FILE_HEADER_SIZE = 30L;
/*     */   
/*     */   static {
/*     */     try {
/*  65 */       Object runtimeVersion = Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]);
/*  66 */       version = ((Integer)runtimeVersion.getClass().getMethod("major", new Class[0]).invoke(runtimeVersion, new Object[0])).intValue();
/*     */     }
/*  68 */     catch (Throwable ex) {
/*  69 */       version = 8;
/*     */     } 
/*  71 */     RUNTIME_VERSION = version;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char SLASH = '/';
/*     */   
/*     */   private static final char NO_SUFFIX = '\000';
/*     */   
/*     */   protected static final int ENTRY_CACHE_SIZE = 25;
/*     */   
/*     */   private final JarFile jarFile;
/*     */   
/*     */   private final JarEntryFilter filter;
/*     */   
/*     */   private RandomAccessData centralDirectoryData;
/*     */   
/*     */   private int size;
/*     */   
/*     */   private int[] hashCodes;
/*     */   
/*     */   private int[] centralDirectoryOffsets;
/*     */   
/*     */   private int[] positions;
/*     */   
/*     */   private Boolean multiReleaseJar;
/*     */   
/*     */   private JarEntryCertification[] certifications;
/*     */ 
/*     */   
/* 101 */   private final Map<Integer, FileHeader> entriesCache = Collections.synchronizedMap(new LinkedHashMap<Integer, FileHeader>(16, 0.75F, true)
/*     */       {
/*     */         protected boolean removeEldestEntry(Map.Entry<Integer, FileHeader> eldest)
/*     */         {
/* 105 */           return (size() >= 25);
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*     */   JarFileEntries(JarFile jarFile, JarEntryFilter filter) {
/* 111 */     this.jarFile = jarFile;
/* 112 */     this.filter = filter;
/* 113 */     if (RUNTIME_VERSION == 8) {
/* 114 */       this.multiReleaseJar = Boolean.valueOf(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitStart(CentralDirectoryEndRecord endRecord, RandomAccessData centralDirectoryData) {
/* 120 */     int maxSize = endRecord.getNumberOfRecords();
/* 121 */     this.centralDirectoryData = centralDirectoryData;
/* 122 */     this.hashCodes = new int[maxSize];
/* 123 */     this.centralDirectoryOffsets = new int[maxSize];
/* 124 */     this.positions = new int[maxSize];
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitFileHeader(CentralDirectoryFileHeader fileHeader, int dataOffset) {
/* 129 */     AsciiBytes name = applyFilter(fileHeader.getName());
/* 130 */     if (name != null) {
/* 131 */       add(name, dataOffset);
/*     */     }
/*     */   }
/*     */   
/*     */   private void add(AsciiBytes name, int dataOffset) {
/* 136 */     this.hashCodes[this.size] = name.hashCode();
/* 137 */     this.centralDirectoryOffsets[this.size] = dataOffset;
/* 138 */     this.positions[this.size] = this.size;
/* 139 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 144 */     sort(0, this.size - 1);
/* 145 */     int[] positions = this.positions;
/* 146 */     this.positions = new int[positions.length];
/* 147 */     for (int i = 0; i < this.size; i++) {
/* 148 */       this.positions[positions[i]] = i;
/*     */     }
/*     */   }
/*     */   
/*     */   int getSize() {
/* 153 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   private void sort(int left, int right) {
/* 158 */     if (left < right) {
/* 159 */       int pivot = this.hashCodes[left + (right - left) / 2];
/* 160 */       int i = left;
/* 161 */       int j = right;
/* 162 */       while (i <= j) {
/* 163 */         while (this.hashCodes[i] < pivot) {
/* 164 */           i++;
/*     */         }
/* 166 */         while (this.hashCodes[j] > pivot) {
/* 167 */           j--;
/*     */         }
/* 169 */         if (i <= j) {
/* 170 */           swap(i, j);
/* 171 */           i++;
/* 172 */           j--;
/*     */         } 
/*     */       } 
/* 175 */       if (left < j) {
/* 176 */         sort(left, j);
/*     */       }
/* 178 */       if (right > i) {
/* 179 */         sort(i, right);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void swap(int i, int j) {
/* 185 */     swap(this.hashCodes, i, j);
/* 186 */     swap(this.centralDirectoryOffsets, i, j);
/* 187 */     swap(this.positions, i, j);
/*     */   }
/*     */   
/*     */   private void swap(int[] array, int i, int j) {
/* 191 */     int temp = array[i];
/* 192 */     array[i] = array[j];
/* 193 */     array[j] = temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<JarEntry> iterator() {
/* 198 */     return new EntryIterator(NO_VALIDATION);
/*     */   }
/*     */   
/*     */   Iterator<JarEntry> iterator(Runnable validator) {
/* 202 */     return new EntryIterator(validator);
/*     */   }
/*     */   
/*     */   boolean containsEntry(CharSequence name) {
/* 206 */     return (getEntry(name, FileHeader.class, true) != null);
/*     */   }
/*     */   
/*     */   JarEntry getEntry(CharSequence name) {
/* 210 */     return getEntry(name, JarEntry.class, true);
/*     */   }
/*     */   
/*     */   InputStream getInputStream(String name) throws IOException {
/* 214 */     FileHeader entry = getEntry(name, FileHeader.class, false);
/* 215 */     return getInputStream(entry);
/*     */   }
/*     */   
/*     */   InputStream getInputStream(FileHeader entry) throws IOException {
/* 219 */     if (entry == null) {
/* 220 */       return null;
/*     */     }
/* 222 */     InputStream inputStream = getEntryData(entry).getInputStream();
/* 223 */     if (entry.getMethod() == 8) {
/* 224 */       inputStream = new ZipInflaterInputStream(inputStream, (int)entry.getSize());
/*     */     }
/* 226 */     return inputStream;
/*     */   }
/*     */   
/*     */   RandomAccessData getEntryData(String name) throws IOException {
/* 230 */     FileHeader entry = getEntry(name, FileHeader.class, false);
/* 231 */     if (entry == null) {
/* 232 */       return null;
/*     */     }
/* 234 */     return getEntryData(entry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RandomAccessData getEntryData(FileHeader entry) throws IOException {
/* 241 */     RandomAccessData data = this.jarFile.getData();
/* 242 */     byte[] localHeader = data.read(entry.getLocalHeaderOffset(), 30L);
/* 243 */     long nameLength = Bytes.littleEndianValue(localHeader, 26, 2);
/* 244 */     long extraLength = Bytes.littleEndianValue(localHeader, 28, 2);
/* 245 */     return data.getSubsection(entry.getLocalHeaderOffset() + 30L + nameLength + extraLength, entry
/* 246 */         .getCompressedSize());
/*     */   }
/*     */   
/*     */   private <T extends FileHeader> T getEntry(CharSequence name, Class<T> type, boolean cacheEntry) {
/* 250 */     T entry = doGetEntry(name, type, cacheEntry, null);
/* 251 */     if (!isMetaInfEntry(name) && isMultiReleaseJar()) {
/* 252 */       int version = RUNTIME_VERSION;
/*     */       
/* 254 */       AsciiBytes nameAlias = (entry instanceof JarEntry) ? ((JarEntry)entry).getAsciiBytesName() : new AsciiBytes(name.toString());
/* 255 */       while (version > 8) {
/* 256 */         T versionedEntry = doGetEntry("META-INF/versions/" + version + "/" + name, type, cacheEntry, nameAlias);
/* 257 */         if (versionedEntry != null) {
/* 258 */           return versionedEntry;
/*     */         }
/* 260 */         version--;
/*     */       } 
/*     */     } 
/* 263 */     return entry;
/*     */   }
/*     */   
/*     */   private boolean isMetaInfEntry(CharSequence name) {
/* 267 */     return name.toString().startsWith("META-INF/");
/*     */   }
/*     */   
/*     */   private boolean isMultiReleaseJar() {
/* 271 */     Boolean multiRelease = this.multiReleaseJar;
/* 272 */     if (multiRelease != null) {
/* 273 */       return multiRelease.booleanValue();
/*     */     }
/*     */     try {
/* 276 */       Manifest manifest = this.jarFile.getManifest();
/* 277 */       if (manifest == null) {
/* 278 */         multiRelease = Boolean.valueOf(false);
/*     */       } else {
/*     */         
/* 281 */         Attributes attributes = manifest.getMainAttributes();
/* 282 */         multiRelease = Boolean.valueOf(attributes.containsKey(MULTI_RELEASE));
/*     */       }
/*     */     
/* 285 */     } catch (IOException ex) {
/* 286 */       multiRelease = Boolean.valueOf(false);
/*     */     } 
/* 288 */     this.multiReleaseJar = multiRelease;
/* 289 */     return multiRelease.booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends FileHeader> T doGetEntry(CharSequence name, Class<T> type, boolean cacheEntry, AsciiBytes nameAlias) {
/* 294 */     int hashCode = AsciiBytes.hashCode(name);
/* 295 */     T entry = getEntry(hashCode, name, false, type, cacheEntry, nameAlias);
/* 296 */     if (entry == null) {
/* 297 */       hashCode = AsciiBytes.hashCode(hashCode, '/');
/* 298 */       entry = getEntry(hashCode, name, '/', type, cacheEntry, nameAlias);
/*     */     } 
/* 300 */     return entry;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends FileHeader> T getEntry(int hashCode, CharSequence name, char suffix, Class<T> type, boolean cacheEntry, AsciiBytes nameAlias) {
/* 305 */     int index = getFirstIndex(hashCode);
/* 306 */     while (index >= 0 && index < this.size && this.hashCodes[index] == hashCode) {
/* 307 */       T entry = getEntry(index, type, cacheEntry, nameAlias);
/* 308 */       if (entry.hasName(name, suffix)) {
/* 309 */         return entry;
/*     */       }
/* 311 */       index++;
/*     */     } 
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends FileHeader> T getEntry(int index, Class<T> type, boolean cacheEntry, AsciiBytes nameAlias) {
/*     */     try {
/* 319 */       FileHeader cached = this.entriesCache.get(Integer.valueOf(index));
/*     */       
/* 321 */       FileHeader entry = (cached != null) ? cached : CentralDirectoryFileHeader.fromRandomAccessData(this.centralDirectoryData, this.centralDirectoryOffsets[index], this.filter);
/* 322 */       if (CentralDirectoryFileHeader.class.equals(entry.getClass()) && type.equals(JarEntry.class)) {
/* 323 */         entry = new JarEntry(this.jarFile, index, (CentralDirectoryFileHeader)entry, nameAlias);
/*     */       }
/* 325 */       if (cacheEntry && cached != entry) {
/* 326 */         this.entriesCache.put(Integer.valueOf(index), entry);
/*     */       }
/* 328 */       return (T)entry;
/*     */     }
/* 330 */     catch (IOException ex) {
/* 331 */       throw new IllegalStateException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getFirstIndex(int hashCode) {
/* 336 */     int index = Arrays.binarySearch(this.hashCodes, 0, this.size, hashCode);
/* 337 */     if (index < 0) {
/* 338 */       return -1;
/*     */     }
/* 340 */     while (index > 0 && this.hashCodes[index - 1] == hashCode) {
/* 341 */       index--;
/*     */     }
/* 343 */     return index;
/*     */   }
/*     */   
/*     */   void clearCache() {
/* 347 */     this.entriesCache.clear();
/*     */   }
/*     */   
/*     */   private AsciiBytes applyFilter(AsciiBytes name) {
/* 351 */     return (this.filter != null) ? this.filter.apply(name) : name;
/*     */   }
/*     */   
/*     */   JarEntryCertification getCertification(JarEntry entry) throws IOException {
/* 355 */     JarEntryCertification[] certifications = this.certifications;
/* 356 */     if (certifications == null) {
/* 357 */       certifications = new JarEntryCertification[this.size];
/*     */ 
/*     */       
/* 360 */       try (JarInputStream certifiedJarStream = new JarInputStream(this.jarFile.getData().getInputStream())) {
/* 361 */         JarEntry certifiedEntry = null;
/* 362 */         while ((certifiedEntry = certifiedJarStream.getNextJarEntry()) != null) {
/*     */           
/* 364 */           certifiedJarStream.closeEntry();
/* 365 */           int index = getEntryIndex(certifiedEntry.getName());
/* 366 */           if (index != -1) {
/* 367 */             certifications[index] = JarEntryCertification.from(certifiedEntry);
/*     */           }
/*     */         } 
/*     */       } 
/* 371 */       this.certifications = certifications;
/*     */     } 
/* 373 */     JarEntryCertification certification = certifications[entry.getIndex()];
/* 374 */     return (certification != null) ? certification : JarEntryCertification.NONE;
/*     */   }
/*     */   
/*     */   private int getEntryIndex(CharSequence name) {
/* 378 */     int hashCode = AsciiBytes.hashCode(name);
/* 379 */     int index = getFirstIndex(hashCode);
/* 380 */     while (index >= 0 && index < this.size && this.hashCodes[index] == hashCode) {
/* 381 */       FileHeader candidate = getEntry(index, FileHeader.class, false, null);
/* 382 */       if (candidate.hasName(name, false)) {
/* 383 */         return index;
/*     */       }
/* 385 */       index++;
/*     */     } 
/* 387 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final class EntryIterator
/*     */     implements Iterator<JarEntry>
/*     */   {
/*     */     private final Runnable validator;
/*     */     
/* 397 */     private int index = 0;
/*     */     
/*     */     private EntryIterator(Runnable validator) {
/* 400 */       this.validator = validator;
/* 401 */       validator.run();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 406 */       this.validator.run();
/* 407 */       return (this.index < JarFileEntries.this.size);
/*     */     }
/*     */ 
/*     */     
/*     */     public JarEntry next() {
/* 412 */       this.validator.run();
/* 413 */       if (!hasNext()) {
/* 414 */         throw new NoSuchElementException();
/*     */       }
/* 416 */       int entryIndex = JarFileEntries.this.positions[this.index];
/* 417 */       this.index++;
/* 418 */       return (JarEntry)JarFileEntries.this.getEntry(entryIndex, (Class)JarEntry.class, false, null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\JarFileEntries.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */