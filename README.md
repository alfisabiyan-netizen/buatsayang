# Aplikasi Restoran Sederhana

Aplikasi Java untuk mengelola pemesanan di restoran dengan fitur lengkap untuk pelanggan dan pemilik restoran.

## Fitur Utama

### 1. Menu Pelanggan
- **Lihat Menu & Pesan**: Menampilkan daftar menu makanan dan minuman dengan harga
- **Pemesanan Fleksibel**: Pelanggan dapat memesan beberapa item hingga mengetik 'selesai'
- **Validasi Input**: Sistem memvalidasi input dan meminta input ulang jika tidak valid
- **Perhitungan Otomatis**: 
  - Pajak 10% dari total pesanan
  - Biaya pelayanan Rp 20.000
  - Diskon 10% untuk pembelian > Rp 100.000
  - Promo beli 1 gratis 1 minuman untuk pembelian > Rp 50.000
- **Struk Pesanan**: Menampilkan detail lengkap pesanan dengan format yang rapi

### 2. Menu Pemilik (Pengelolaan Menu)
- **Lihat Daftar Menu**: Menampilkan semua menu yang tersedia
- **Tambah Menu Baru**: Menambahkan menu dengan nama, harga, dan kategori
- **Ubah Harga Menu**: Mengubah harga menu yang sudah ada dengan konfirmasi
- **Hapus Menu**: Menghapus menu dengan konfirmasi
- **Validasi Input**: Semua operasi memiliki validasi input yang ketat

## Struktur File

```
├── MenuItem.java       # Class untuk item menu (nama, harga, kategori)
├── OrderItem.java      # Class untuk item pesanan (menu + jumlah)
├── RestaurantApp.java  # Class utama aplikasi dengan semua logika
├── run.sh             # Script untuk menjalankan aplikasi
└── README.md          # Dokumentasi ini
```

## Cara Kompilasi

```bash
javac -encoding UTF-8 MenuItem.java OrderItem.java RestaurantApp.java
```

## Cara Menjalankan

### Opsi 1: Menggunakan script
```bash
chmod +x run.sh
./run.sh
```

### Opsi 2: Langsung dengan java
```bash
java -Dfile.encoding=UTF-8 RestaurantApp
```

## Menu Awal yang Tersedia

### Makanan:
1. Nasi Goreng - Rp 25.000
2. Mie Goreng - Rp 20.000
3. Ayam Bakar - Rp 35.000
4. Sate Ayam - Rp 30.000
5. Gado-Gado - Rp 22.000

### Minuman:
6. Es Teh - Rp 5.000
7. Es Jeruk - Rp 7.000
8. Jus Alpukat - Rp 12.000
9. Kopi - Rp 10.000
10. Air Mineral - Rp 3.000

## Contoh Penggunaan

### Skenario 1: Pemesanan Pelanggan
1. Pilih menu "1. Menu Pelanggan"
2. Pilih "1. Lihat Menu & Pesan"
3. Masukkan nomor menu yang ingin dipesan (contoh: 1)
4. Masukkan jumlah (contoh: 2)
5. Ulangi untuk menu lain atau ketik "selesai"
6. Sistem akan menampilkan struk dengan perhitungan lengkap

### Skenario 2: Mengelola Menu (Pemilik)
1. Pilih menu "2. Menu Pemilik"
2. Pilih operasi yang diinginkan:
   - Tambah menu baru
   - Ubah harga menu yang ada
   - Hapus menu
3. Ikuti instruksi dan konfirmasi perubahan

## Fitur Keamanan & Validasi

- ✅ Validasi input untuk semua operasi
- ✅ Konfirmasi sebelum mengubah/menghapus data
- ✅ Penanganan error untuk input yang tidak valid
- ✅ Loop validasi hingga input benar
- ✅ Tidak ada operasi yang bisa merusak data tanpa konfirmasi

## Perhitungan Biaya

```
Subtotal = Total harga semua item
Pajak = Subtotal × 10%
Biaya Pelayanan = Rp 20.000
Total Sebelum Diskon = Subtotal + Pajak + Biaya Pelayanan

Diskon:
- Jika Subtotal > Rp 100.000 → Diskon 10% dari Total Sebelum Diskon
- Jika Subtotal > Rp 50.000 → Gratis 1 minuman termurah

Total Akhir = Total Sebelum Diskon - Total Diskon
```

## Teknologi

- **Bahasa**: Java
- **JDK**: Java 17 (Amazon Corretto)
- **Struktur**: Object-Oriented Programming (OOP)
- **Input**: Scanner untuk input konsol

## Catatan Penting

- Aplikasi ini berjalan di terminal/console
- Semua input harus sesuai dengan pilihan yang tersedia
- Sistem akan terus meminta input ulang jika input tidak valid
- Encoding UTF-8 diperlukan untuk menampilkan karakter khusus dengan benar

## Lisensi

Aplikasi ini dibuat untuk keperluan pembelajaran dan dapat digunakan secara bebas.
