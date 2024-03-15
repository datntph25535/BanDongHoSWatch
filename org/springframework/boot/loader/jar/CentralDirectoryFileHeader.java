/*     */ package org.springframework.boot.loader.jar;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.time.ZoneId;
/*     */ import java.time.ZonedDateTime;
/*     */ import java.time.temporal.ChronoField;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.time.temporal.ValueRange;
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
/*     */ final class CentralDirectoryFileHeader
/*     */   implements FileHeader
/*     */ {
/*  39 */   private static final AsciiBytes SLASH = new AsciiBytes("/");
/*     */   
/*  41 */   private static final byte[] NO_EXTRA = new byte[0];
/*     */   
/*  43 */   private static final AsciiBytes NO_COMMENT = new AsciiBytes("");
/*     */   
/*     */   private byte[] header;
/*     */   
/*     */   private int headerOffset;
/*     */   
/*     */   private AsciiBytes name;
/*     */   
/*     */   private byte[] extra;
/*     */   
/*     */   private AsciiBytes comment;
/*     */   
/*     */   private long localHeaderOffset;
/*     */ 
/*     */   
/*     */   CentralDirectoryFileHeader() {}
/*     */ 
/*     */   
/*     */   CentralDirectoryFileHeader(byte[] header, int headerOffset, AsciiBytes name, byte[] extra, AsciiBytes comment, long localHeaderOffset) {
/*  62 */     this.header = header;
/*  63 */     this.headerOffset = headerOffset;
/*  64 */     this.name = name;
/*  65 */     this.extra = extra;
/*  66 */     this.comment = comment;
/*  67 */     this.localHeaderOffset = localHeaderOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void load(byte[] data, int dataOffset, RandomAccessData variableData, int variableOffset, JarEntryFilter filter) throws IOException {
/*  73 */     this.header = data;
/*  74 */     this.headerOffset = dataOffset;
/*  75 */     long nameLength = Bytes.littleEndianValue(data, dataOffset + 28, 2);
/*  76 */     long extraLength = Bytes.littleEndianValue(data, dataOffset + 30, 2);
/*  77 */     long commentLength = Bytes.littleEndianValue(data, dataOffset + 32, 2);
/*  78 */     this.localHeaderOffset = Bytes.littleEndianValue(data, dataOffset + 42, 4);
/*     */     
/*  80 */     dataOffset += 46;
/*  81 */     if (variableData != null) {
/*  82 */       data = variableData.read((variableOffset + 46), nameLength + extraLength + commentLength);
/*  83 */       dataOffset = 0;
/*     */     } 
/*  85 */     this.name = new AsciiBytes(data, dataOffset, (int)nameLength);
/*  86 */     if (filter != null) {
/*  87 */       this.name = filter.apply(this.name);
/*     */     }
/*  89 */     this.extra = NO_EXTRA;
/*  90 */     this.comment = NO_COMMENT;
/*  91 */     if (extraLength > 0L) {
/*  92 */       this.extra = new byte[(int)extraLength];
/*  93 */       System.arraycopy(data, (int)(dataOffset + nameLength), this.extra, 0, this.extra.length);
/*     */     } 
/*  95 */     if (commentLength > 0L) {
/*  96 */       this.comment = new AsciiBytes(data, (int)(dataOffset + nameLength + extraLength), (int)commentLength);
/*     */     }
/*     */   }
/*     */   
/*     */   AsciiBytes getName() {
/* 101 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasName(CharSequence name, char suffix) {
/* 106 */     return this.name.matches(name, suffix);
/*     */   }
/*     */   
/*     */   boolean isDirectory() {
/* 110 */     return this.name.endsWith(SLASH);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMethod() {
/* 115 */     return (int)Bytes.littleEndianValue(this.header, this.headerOffset + 10, 2);
/*     */   }
/*     */   
/*     */   long getTime() {
/* 119 */     long datetime = Bytes.littleEndianValue(this.header, this.headerOffset + 12, 4);
/* 120 */     return decodeMsDosFormatDateTime(datetime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long decodeMsDosFormatDateTime(long datetime) {
/* 131 */     int year = getChronoValue((datetime >> 25L & 0x7FL) + 1980L, ChronoField.YEAR);
/* 132 */     int month = getChronoValue(datetime >> 21L & 0xFL, ChronoField.MONTH_OF_YEAR);
/* 133 */     int day = getChronoValue(datetime >> 16L & 0x1FL, ChronoField.DAY_OF_MONTH);
/* 134 */     int hour = getChronoValue(datetime >> 11L & 0x1FL, ChronoField.HOUR_OF_DAY);
/* 135 */     int minute = getChronoValue(datetime >> 5L & 0x3FL, ChronoField.MINUTE_OF_HOUR);
/* 136 */     int second = getChronoValue(datetime << 1L & 0x3EL, ChronoField.SECOND_OF_MINUTE);
/* 137 */     return ZonedDateTime.of(year, month, day, hour, minute, second, 0, ZoneId.systemDefault()).toInstant()
/* 138 */       .truncatedTo(ChronoUnit.SECONDS).toEpochMilli();
/*     */   }
/*     */   
/*     */   long getCrc() {
/* 142 */     return Bytes.littleEndianValue(this.header, this.headerOffset + 16, 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCompressedSize() {
/* 147 */     return Bytes.littleEndianValue(this.header, this.headerOffset + 20, 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 152 */     return Bytes.littleEndianValue(this.header, this.headerOffset + 24, 4);
/*     */   }
/*     */   
/*     */   byte[] getExtra() {
/* 156 */     return this.extra;
/*     */   }
/*     */   
/*     */   boolean hasExtra() {
/* 160 */     return (this.extra.length > 0);
/*     */   }
/*     */   
/*     */   AsciiBytes getComment() {
/* 164 */     return this.comment;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLocalHeaderOffset() {
/* 169 */     return this.localHeaderOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public CentralDirectoryFileHeader clone() {
/* 174 */     byte[] header = new byte[46];
/* 175 */     System.arraycopy(this.header, this.headerOffset, header, 0, header.length);
/* 176 */     return new CentralDirectoryFileHeader(header, 0, this.name, header, this.comment, this.localHeaderOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   static CentralDirectoryFileHeader fromRandomAccessData(RandomAccessData data, int offset, JarEntryFilter filter) throws IOException {
/* 181 */     CentralDirectoryFileHeader fileHeader = new CentralDirectoryFileHeader();
/* 182 */     byte[] bytes = data.read(offset, 46L);
/* 183 */     fileHeader.load(bytes, 0, data, offset, filter);
/* 184 */     return fileHeader;
/*     */   }
/*     */   
/*     */   private static int getChronoValue(long value, ChronoField field) {
/* 188 */     ValueRange range = field.range();
/* 189 */     return Math.toIntExact(Math.min(Math.max(value, range.getMinimum()), range.getMaximum()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\org\springframework\boot\loader\jar\CentralDirectoryFileHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */