# Panduan Penggunaan Aplikasi Restoran

## Cara Menjalankan Aplikasi

### 1. Kompilasi (jika belum dikompilasi)
```bash
javac -encoding UTF-8 MenuItem.java OrderItem.java RestaurantApp.java
```

### 2. Jalankan Aplikasi
```bash
java -Dfile.encoding=UTF-8 RestaurantApp
```

Atau gunakan script:
```bash
./run.sh
```

## Panduan Menu Utama

Saat aplikasi dijalankan, Anda akan melihat menu utama:

```
╔════════════════════════════════════════╗
║   APLIKASI RESTORAN - MENU UTAMA      ║
╚════════════════════════════════════════╝
1. Menu Pelanggan (Pemesanan)
2. Menu Pemilik (Pengelolaan Menu)
3. Keluar
```

## 📱 MENU PELANGGAN - Cara Memesan

### Langkah-langkah Pemesanan:

1. **Pilih Menu Pelanggan**
   - Ketik `1` pada menu utama
   - Tekan Enter

2. **Lihat Menu & Pesan**
   - Ketik `1` untuk mulai memesan
   - Daftar menu akan ditampilkan

3. **Masukkan Pesanan**
   - Ketik nomor menu (contoh: `1` untuk Nasi Goreng)
   - Tekan Enter
   - Ketik jumlah yang ingin dipesan (contoh: `2`)
   - Tekan Enter

4. **Tambah Pesanan Lain (Opsional)**
   - Ulangi langkah 3 untuk menu lain
   - Atau ketik `selesai` untuk mengakhiri pesanan

5. **Lihat Struk**
   - Setelah mengetik `selesai`, struk akan ditampilkan
   - Struk menampilkan:
     - Detail pesanan
     - Subtotal
     - Pajak 10%
     - Biaya pelayanan Rp 20.000
     - Diskon (jika ada)
     - Total pembayaran

### Contoh Sesi Pemesanan:

```
Nomor menu: 1
Jumlah: 2
✓ Nasi Goreng x2 ditambahkan ke pesanan

Nomor menu: 6
Jumlah: 1
✓ Es Teh x1 ditambahkan ke pesanan

Nomor menu: selesai
```

### Sistem Diskon Otomatis:

#### 🎁 Diskon 10% 
- **Syarat**: Total pembelian > Rp 100.000
- **Berlaku untuk**: Total keseluruhan (setelah pajak dan biaya pelayanan)

#### 🎁 Promo Beli 1 Gratis 1 Minuman
- **Syarat**: Total pembelian > Rp 50.000
- **Gratis**: 1 minuman termurah dari pesanan Anda

**Catatan**: Kedua promo dapat digabungkan!

## 👨‍💼 MENU PEMILIK - Pengelolaan Menu

### 1. Lihat Daftar Menu
- Menampilkan semua menu yang tersedia
- Format: Nomor, Nama, Harga, Kategori

### 2. Tambah Menu Baru

**Langkah-langkah:**
1. Pilih opsi `2` (Tambah Menu Baru)
2. Masukkan nama menu (contoh: `Rendang`)
3. Masukkan harga (contoh: `45000`)
4. Masukkan kategori: `Makanan` atau `Minuman`

**Contoh:**
```
Nama Menu: Rendang
Harga: Rp 45000
Kategori (Makanan/Minuman): Makanan
✓ Menu berhasil ditambahkan!
```

### 3. Ubah Harga Menu

**Langkah-langkah:**
1. Pilih opsi `3` (Ubah Harga Menu)
2. Daftar menu akan ditampilkan
3. Masukkan nomor menu yang ingin diubah
4. Masukkan harga baru
5. Konfirmasi dengan mengetik `Ya`

**Contoh:**
```
Masukkan nomor menu yang ingin diubah harganya: 1

Menu yang dipilih: Nasi Goreng
Harga saat ini: Rp 25,000
Harga baru: Rp 28000
Apakah Anda yakin ingin mengubah harga? (Ya/Tidak): Ya
✓ Harga menu berhasil diubah!
```

### 4. Hapus Menu

**Langkah-langkah:**
1. Pilih opsi `4` (Hapus Menu)
2. Daftar menu akan ditampilkan
3. Masukkan nomor menu yang ingin dihapus
4. Konfirmasi dengan mengetik `Ya`

**Contoh:**
```
Masukkan nomor menu yang ingin dihapus: 10

Menu yang akan dihapus: Air Mineral
Apakah Anda yakin ingin menghapus menu ini? (Ya/Tidak): Ya
✓ Menu berhasil dihapus!
```

## ⚠️ Validasi Input

### Input yang Valid:
- **Nomor menu**: Harus angka dalam rentang menu yang tersedia
- **Jumlah**: Harus angka positif (> 0)
- **Harga**: Harus angka positif (> 0)
- **Kategori**: Hanya `Makanan` atau `Minuman`
- **Konfirmasi**: `Ya` atau `Tidak`

### Jika Input Tidak Valid:
- Sistem akan menampilkan pesan error
- Sistem akan meminta input ulang
- Proses akan terus berulang hingga input valid

## 💡 Tips Penggunaan

1. **Untuk Pelanggan:**
   - Periksa menu terlebih dahulu sebelum memesan
   - Manfaatkan diskon dengan memesan lebih dari Rp 100.000
   - Pesan minuman untuk mendapat promo gratis 1 minuman

2. **Untuk Pemilik:**
   - Selalu konfirmasi sebelum mengubah/menghapus menu
   - Pastikan harga yang dimasukkan sudah benar
   - Gunakan kategori yang tepat (Makanan/Minuman)

3. **Navigasi:**
   - Gunakan angka untuk memilih menu
   - Ketik `selesai` untuk mengakhiri pesanan
   - Pilih opsi kembali untuk kembali ke menu sebelumnya

## 🧮 Contoh Perhitungan

### Contoh 1: Pembelian Sederhana (< Rp 50.000)
```
Pesanan:
- Nasi Goreng x2 = Rp 50.000

Subtotal:           Rp  50.000
Pajak (10%):        Rp   5.000
Biaya Pelayanan:    Rp  20.000
─────────────────────────────────
TOTAL:              Rp  75.000
```

### Contoh 2: Dengan Promo Minuman (> Rp 50.000)
```
Pesanan:
- Ayam Bakar x2 = Rp 70.000
- Es Teh x1     = Rp  5.000

Subtotal:           Rp  75.000
Pajak (10%):        Rp   7.500
Biaya Pelayanan:    Rp  20.000
─────────────────────────────────
Total Sebelum Diskon: Rp 102.500

Promo Minuman:      Rp  -5.000
─────────────────────────────────
TOTAL:              Rp  97.500
```

### Contoh 3: Dengan Semua Diskon (> Rp 100.000)
```
Pesanan:
- Ayam Bakar x3 = Rp 105.000
- Sate Ayam x2  = Rp  60.000
- Es Teh x3     = Rp  15.000

Subtotal:           Rp 180.000
Pajak (10%):        Rp  18.000
Biaya Pelayanan:    Rp  20.000
─────────────────────────────────
Total Sebelum Diskon: Rp 218.000

Promo Minuman:      Rp  -5.000
Diskon 10%:         Rp -21.800
─────────────────────────────────
Total Diskon:       Rp -26.800
═════════════════════════════════
TOTAL:              Rp 191.200
```

## 🐛 Troubleshooting

### Masalah: Karakter tidak tampil dengan benar
**Solusi**: Pastikan menggunakan encoding UTF-8
```bash
java -Dfile.encoding=UTF-8 RestaurantApp
```

### Masalah: Aplikasi tidak bisa dikompilasi
**Solusi**: Pastikan Java JDK sudah terinstall
```bash
java -version
javac -version
```

### Masalah: Input tidak diterima
**Solusi**: 
- Pastikan mengetik input yang valid
- Tekan Enter setelah mengetik
- Ikuti format yang diminta

## 📞 Bantuan

Jika mengalami masalah atau memiliki pertanyaan:
1. Baca dokumentasi ini dengan teliti
2. Periksa format input yang Anda masukkan
3. Pastikan Java terinstall dengan benar
4. Coba restart aplikasi

---

**Selamat menggunakan Aplikasi Restoran! 🍽️**
