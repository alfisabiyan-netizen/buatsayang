public class OrderItem {
    private MenuItem menuItem;
    private int jumlah;

    public OrderItem(MenuItem menuItem, int jumlah) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return menuItem.getHarga() * jumlah;
    }
}
