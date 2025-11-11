import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantApp {
    private static ArrayList<MenuItem> menuList = new ArrayList<>();
    private static ArrayList<OrderItem> pesanan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final double PAJAK = 0.10;
    private static final double BIAYA_PELAYANAN = 20000;
    private static final double DISKON_THRESHOLD = 100000;
    private static final double PROMO_THRESHOLD = 50000;
    private static final double DISKON_RATE = 0.10;

    public static void main(String[] args) {
        initializeMenu();
        menuUtama();
    }

    private static void initializeMenu() {
        menuList.add(new MenuItem("Nasi Goreng", 25000, "Makanan"));
        menuList.add(new MenuItem("Mie Goreng", 20000, "Makanan"));
        menuList.add(new MenuItem("Ayam Bakar", 35000, "Makanan"));
        menuList.add(new MenuItem("Sate Ayam", 30000, "Makanan"));
        menuList.add(new MenuItem("Gado-Gado", 22000, "Makanan"));
        menuList.add(new MenuItem("Es Teh", 5000, "Minuman"));
        menuList.add(new MenuItem("Es Jeruk", 7000, "Minuman"));
        menuList.add(new MenuItem("Jus Alpukat", 12000, "Minuman"));
        menuList.add(new MenuItem("Kopi", 10000, "Minuman"));
        menuList.add(new MenuItem("Air Mineral", 3000, "Minuman"));
    }

    private static void menuUtama() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   APLIKASI RESTORAN - MENU UTAMA      ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Menu Pelanggan (Pemesanan)");
            System.out.println("2. Menu Pemilik (Pengelolaan Menu)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            
            String pilihan = scanner.nextLine().trim();
            
            switch (pilihan) {
                case "1":
                    menuPelanggan();
                    break;
                case "2":
                    menuPemilik();
                    break;
                case "3":
                    System.out.println("\nTerima kasih telah menggunakan aplikasi restoran!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-3.");
            }
        }
    }

    private static void menuPelanggan() {
        pesanan.clear();
        
        while (true) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║        MENU PELANGGAN                 ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Lihat Menu & Pesan");
            System.out.println("2. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            
            String pilihan = scanner.nextLine().trim();
            
            switch (pilihan) {
                case "1":
                    prosesPermesanan();
                    break;
                case "2":
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-2.");
            }
        }
    }

    private static void prosesPermesanan() {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    DAFTAR MENU RESTORAN");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        for (int i = 0; i < menuList.size(); i++) {
            System.out.printf("%2d. %s\n", (i + 1), menuList.get(i));
        }
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        System.out.println("\nMasukkan nomor menu yang ingin dipesan (ketik 'selesai' untuk mengakhiri):");
        
        while (true) {
            System.out.print("Nomor menu: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("selesai")) {
                if (pesanan.isEmpty()) {
                    System.out.println("Anda belum memesan apapun!");
                    return;
                }
                hitungDanCetakStruk();
                pesanan.clear();
                return;
            }
            
            try {
                int nomorMenu = Integer.parseInt(input);
                
                if (nomorMenu < 1 || nomorMenu > menuList.size()) {
                    System.out.println("Nomor menu tidak valid! Silakan pilih nomor 1-" + menuList.size());
                    continue;
                }
                
                MenuItem menuDipilih = menuList.get(nomorMenu - 1);
                
                System.out.print("Jumlah: ");
                String jumlahInput = scanner.nextLine().trim();
                
                try {
                    int jumlah = Integer.parseInt(jumlahInput);
                    
                    if (jumlah <= 0) {
                        System.out.println("Jumlah harus lebih dari 0!");
                        continue;
                    }
                    
                    boolean sudahAda = false;
                    for (OrderItem item : pesanan) {
                        if (item.getMenuItem().getNama().equals(menuDipilih.getNama())) {
                            item.setJumlah(item.getJumlah() + jumlah);
                            sudahAda = true;
                            break;
                        }
                    }
                    
                    if (!sudahAda) {
                        pesanan.add(new OrderItem(menuDipilih, jumlah));
                    }
                    
                    System.out.println("✓ " + menuDipilih.getNama() + " x" + jumlah + " ditambahkan ke pesanan");
                    
                } catch (NumberFormatException e) {
                    System.out.println("Jumlah tidak valid! Masukkan angka.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan nomor menu atau 'selesai'.");
            }
        }
    }

    private static void hitungDanCetakStruk() {
        double subtotal = 0;
        int jumlahMinuman = 0;
        
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      STRUK PESANAN                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("\nItem Pesanan:");
        System.out.println("─────────────────────────────────────────────────────────────────");
        
        for (OrderItem item : pesanan) {
            MenuItem menu = item.getMenuItem();
            int jumlah = item.getJumlah();
            double totalItem = item.getTotalHarga();
            
            System.out.printf("%-25s x%-3d @ Rp %,10.0f = Rp %,12.0f\n", 
                menu.getNama(), jumlah, menu.getHarga(), totalItem);
            
            subtotal += totalItem;
            
            if (menu.getKategori().equalsIgnoreCase("Minuman")) {
                jumlahMinuman += jumlah;
            }
        }
        
        System.out.println("─────────────────────────────────────────────────────────────────");
        System.out.printf("Subtotal:                                      Rp %,12.0f\n", subtotal);
        
        double biayaPajak = subtotal * PAJAK;
        System.out.printf("Pajak (10%%):                                   Rp %,12.0f\n", biayaPajak);
        System.out.printf("Biaya Pelayanan:                               Rp %,12.0f\n", BIAYA_PELAYANAN);
        
        double totalSebelumDiskon = subtotal + biayaPajak + BIAYA_PELAYANAN;
        System.out.println("─────────────────────────────────────────────────────────────────");
        System.out.printf("Total Sebelum Diskon:                          Rp %,12.0f\n", totalSebelumDiskon);
        
        double totalDiskon = 0;
        boolean adaPromoMinuman = false;
        
        if (subtotal > PROMO_THRESHOLD && jumlahMinuman > 0) {
            adaPromoMinuman = true;
            double hargaMinumanTermurah = Double.MAX_VALUE;
            
            for (OrderItem item : pesanan) {
                if (item.getMenuItem().getKategori().equalsIgnoreCase("Minuman")) {
                    if (item.getMenuItem().getHarga() < hargaMinumanTermurah) {
                        hargaMinumanTermurah = item.getMenuItem().getHarga();
                    }
                }
            }
            
            totalDiskon += hargaMinumanTermurah;
            System.out.println("\n★ PROMO: Beli 1 Gratis 1 Minuman (Total > Rp 50.000)");
            System.out.printf("  Diskon Minuman Termurah:                     Rp %,12.0f\n", hargaMinumanTermurah);
        }
        
        if (subtotal > DISKON_THRESHOLD) {
            double diskonPersen = totalSebelumDiskon * DISKON_RATE;
            totalDiskon += diskonPersen;
            System.out.println("\n★ DISKON: 10%% untuk pembelian > Rp 100.000");
            System.out.printf("  Diskon 10%%:                                  Rp %,12.0f\n", diskonPersen);
        }
        
        if (totalDiskon > 0) {
            System.out.println("─────────────────────────────────────────────────────────────────");
            System.out.printf("Total Diskon:                                  Rp %,12.0f\n", totalDiskon);
        }
        
        double totalAkhir = totalSebelumDiskon - totalDiskon;
        System.out.println("═════════════════════════════════════════════════════════════════");
        System.out.printf("TOTAL PEMBAYARAN:                              Rp %,12.0f\n", totalAkhir);
        System.out.println("═════════════════════════════════════════════════════════════════");
        System.out.println("\nTerima kasih atas pesanan Anda!");
        System.out.println("Selamat menikmati hidangan Anda! 😊\n");
    }

    private static void menuPemilik() {
        while (true) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║    MENU PEMILIK - PENGELOLAAN MENU    ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Lihat Daftar Menu");
            System.out.println("2. Tambah Menu Baru");
            System.out.println("3. Ubah Harga Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            
            String pilihan = scanner.nextLine().trim();
            
            switch (pilihan) {
                case "1":
                    lihatDaftarMenu();
                    break;
                case "2":
                    tambahMenu();
                    break;
                case "3":
                    ubahHargaMenu();
                    break;
                case "4":
                    hapusMenu();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
            }
        }
    }

    private static void lihatDaftarMenu() {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    DAFTAR MENU RESTORAN");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        if (menuList.isEmpty()) {
            System.out.println("Belum ada menu yang tersedia.");
        } else {
            for (int i = 0; i < menuList.size(); i++) {
                System.out.printf("%2d. %s\n", (i + 1), menuList.get(i));
            }
        }
        System.out.println("═══════════════════════════════════════════════════════════════");
    }

    private static void tambahMenu() {
        System.out.println("\n--- TAMBAH MENU BARU ---");
        
        System.out.print("Nama Menu: ");
        String nama = scanner.nextLine().trim();
        
        if (nama.isEmpty()) {
            System.out.println("Nama menu tidak boleh kosong!");
            return;
        }
        
        System.out.print("Harga: Rp ");
        String hargaInput = scanner.nextLine().trim();
        
        try {
            double harga = Double.parseDouble(hargaInput);
            
            if (harga <= 0) {
                System.out.println("Harga harus lebih dari 0!");
                return;
            }
            
            System.out.print("Kategori (Makanan/Minuman): ");
            String kategori = scanner.nextLine().trim();
            
            if (!kategori.equalsIgnoreCase("Makanan") && !kategori.equalsIgnoreCase("Minuman")) {
                System.out.println("Kategori harus 'Makanan' atau 'Minuman'!");
                return;
            }
            
            menuList.add(new MenuItem(nama, harga, kategori));
            System.out.println("✓ Menu berhasil ditambahkan!");
            
        } catch (NumberFormatException e) {
            System.out.println("Harga tidak valid! Masukkan angka.");
        }
    }

    private static void ubahHargaMenu() {
        if (menuList.isEmpty()) {
            System.out.println("Belum ada menu yang tersedia.");
            return;
        }
        
        lihatDaftarMenu();
        
        while (true) {
            System.out.print("\nMasukkan nomor menu yang ingin diubah harganya: ");
            String input = scanner.nextLine().trim();
            
            try {
                int nomor = Integer.parseInt(input);
                
                if (nomor < 1 || nomor > menuList.size()) {
                    System.out.println("Nomor menu tidak valid! Silakan pilih nomor 1-" + menuList.size());
                    continue;
                }
                
                MenuItem menu = menuList.get(nomor - 1);
                System.out.println("\nMenu yang dipilih: " + menu.getNama());
                System.out.println("Harga saat ini: Rp " + String.format("%,.0f", menu.getHarga()));
                
                System.out.print("Harga baru: Rp ");
                String hargaInput = scanner.nextLine().trim();
                
                try {
                    double hargaBaru = Double.parseDouble(hargaInput);
                    
                    if (hargaBaru <= 0) {
                        System.out.println("Harga harus lebih dari 0!");
                        continue;
                    }
                    
                    System.out.print("Apakah Anda yakin ingin mengubah harga? (Ya/Tidak): ");
                    String konfirmasi = scanner.nextLine().trim();
                    
                    if (konfirmasi.equalsIgnoreCase("Ya")) {
                        menu.setHarga(hargaBaru);
                        System.out.println("✓ Harga menu berhasil diubah!");
                    } else {
                        System.out.println("Perubahan dibatalkan.");
                    }
                    
                    return;
                    
                } catch (NumberFormatException e) {
                    System.out.println("Harga tidak valid! Masukkan angka.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan nomor menu.");
            }
        }
    }

    private static void hapusMenu() {
        if (menuList.isEmpty()) {
            System.out.println("Belum ada menu yang tersedia.");
            return;
        }
        
        lihatDaftarMenu();
        
        while (true) {
            System.out.print("\nMasukkan nomor menu yang ingin dihapus: ");
            String input = scanner.nextLine().trim();
            
            try {
                int nomor = Integer.parseInt(input);
                
                if (nomor < 1 || nomor > menuList.size()) {
                    System.out.println("Nomor menu tidak valid! Silakan pilih nomor 1-" + menuList.size());
                    continue;
                }
                
                MenuItem menu = menuList.get(nomor - 1);
                System.out.println("\nMenu yang akan dihapus: " + menu.getNama());
                
                System.out.print("Apakah Anda yakin ingin menghapus menu ini? (Ya/Tidak): ");
                String konfirmasi = scanner.nextLine().trim();
                
                if (konfirmasi.equalsIgnoreCase("Ya")) {
                    menuList.remove(nomor - 1);
                    System.out.println("✓ Menu berhasil dihapus!");
                } else {
                    System.out.println("Penghapusan dibatalkan.");
                }
                
                return;
                
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan nomor menu.");
            }
        }
    }
}
