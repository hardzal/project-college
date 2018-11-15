#include<iostream>
#include<stack>
#include<queue>
#include<iomanip>
#include<stdlib.h>
#include<conio.h>
#include<fstream>
#include<windows.h>

using namespace std;

typedef struct {
    string nama;
    int lapisan;
    string toping;
    double harga;
    int total;
} kue;

typedef struct {
    string namaPembeli;
    string namaKue;
    int totalKue;
    double totalHarga;
} pesanan;

typedef struct {
    string username;
    string password;
    string level[2] = {"ADMIN", "MEMBER"};
    queue<pesanan> kueRiwayat;
    double point;
    double saldo;
} user;

queue<kue> kueSimpan;
queue<pesanan> daftarPesanan;
queue<pesanan> daftarKirim;
queue<pesanan> daftarKonfirmasi;
queue<user> pelangganKue;

stack<kue> kueInven;
stack<pesanan> kueHistory;
stack<pesanan> pelangganToko;
stack<user> daftarPelanggan;

unsigned long long int pendapatan = 0;

void menuBuatKue() {
    cin.ignore();
    kue buatKue;
    cout << "--INPUT DATA KUE--" << endl << endl;
    cout << "Nama Kue\t: "; getline(cin, buatKue.nama);
    cout << "Lapisan Kue\t: "; cin >> buatKue.lapisan; cin.ignore();
    cout << "Toping Kue\t: "; getline(cin, buatKue.toping);
    cout << "Harga Kue\t: "; cin >> buatKue.harga;
    cout << "Total Kue\t: "; cin >> buatKue.total;
    kueSimpan.push(buatKue);
    kueInven.push(buatKue);
}

void menuStockKue() {
    queue<kue> stockKue;
    stockKue = kueSimpan;
    if(!kueSimpan.size()) {
        cout << "Belum ada kue yang dibuat" << endl;
    } else {
        cout << "---Stock Kue saat ini---" << endl << endl;
        cout << "Total stock saat ini\t: " << kueSimpan.size() << endl << endl;
        while(stockKue.size()) {
            cout << "Nama Kue\t: " << stockKue.front().nama << endl;
            cout << "Lapisan Kue\t: " << stockKue.front().lapisan << endl;
            cout << "Toping Kue\t: " << stockKue.front().toping << endl;
            cout << "Harga Kue\t: " << stockKue.front().harga << endl;
            cout << "Total Kue\t: " << stockKue.front().total << endl << endl;
            stockKue.pop();
        }
    }
    cout << endl;
}

void menuLihatPesanan() {
    queue<pesanan> kueList;
    kueList = daftarPesanan;
    cout << "--Daftar Pesanan---" << endl;
    if(!daftarPesanan.size()) {
        cout << "Belum ada kue yang dipesan" << endl;
    } else {
        cout << "---Daftar Kue yang dipesan---" << endl;
        cout << "Total yang dipesan\t: " << daftarPesanan.size() << endl << endl;
        while(kueList.size()) {
            cout << "Nama Pemesan\t: " << kueList.front().namaPembeli << endl;
            cout << "Nama Kue\t: " << kueList.front().namaKue << endl;
            cout << "Total Pesanan\t: " << kueList.front().totalKue << endl;
            cout << "Total Harga\t: " << kueList.front().totalHarga << endl << endl;
            kueList.pop();
        }
        cout << endl;
    }
}

void menuKirimPesanan() {
    char kirim;
    queue<pesanan> kirimPesanan;
    kirimPesanan = daftarKonfirmasi;
    cout << "---Kirim Pesanan---" << endl << endl;
    if(daftarKonfirmasi.size() > 0) {
        if(daftarKonfirmasi.front().totalKue <= 0) {
            cout << "Stock masih kurang!" << endl;
        } else {
            while(kirimPesanan.size()) {
                cout << "Nama Pemesan\t: " << kirimPesanan.front().namaPembeli << endl;
                cout << "Nama Kue\t: " << kirimPesanan.front().namaKue << endl;
                cout << "Total Kue\t: " << kirimPesanan.front().totalKue << endl;
                cout << "Total Harga\t: " << kirimPesanan.front().totalHarga << endl;
                cout << endl;
                cout << "Kirim ke pelanggan (y/n) ? "; cin >> kirim;
                if(kirim == 'y' || kirim == 'Y') {
                    kueHistory.push(daftarKonfirmasi.front());
                    pelangganToko.push(daftarKonfirmasi.front());
                    daftarKonfirmasi.pop();
                    daftarPesanan.pop();
                    cout << "...Kue masuk proses kirim..." << endl; Sleep(500);
                }
                kirimPesanan.pop();
            }
            cout << "Seluruh kue sedang di kirim..." << endl;// Sleep(500);
        }
    } else {
        cout << "Belum ada kue yang dikonfirmasi" << endl;
    }
}

void menuRiwayatPelanggan() {
    int i = 1;
    stack<pesanan> kueRiwayat;
    kueRiwayat = kueHistory;
    cout << "--RIWAYAT PEMESANAN PELANGGAN--" << endl << endl;
    if(kueRiwayat.size() > 0) {
        while(kueRiwayat.size()) {
            cout << "Pelanggan ke-" << i << endl;
            cout << "Nama\t\t: " << kueRiwayat.top().namaPembeli << endl;
            cout << "Kue\t\t: " << kueRiwayat.top().totalKue << " " << kueRiwayat.top().namaKue << endl;
            cout << "Total Biaya\t: " << kueRiwayat.top().totalHarga << endl;
            cout << endl; pendapatan += kueRiwayat.top().totalHarga;
            ++i; kueRiwayat.pop();
        }
        cout << "Total Pendapatan terakhir\t: " << pendapatan << endl;
    } else {
        cout << "Belum ada riwayat transaksi pemesanan kue" << endl;
    }
}

void menuPesanKue() {
    bool stat = false;
    char pilih;
    int i = 1, jumlah,pilih1;
    do {
        stack<kue> kueBaru;
        stack<kue> kueSisa;
        queue<kue> kueSave;
        pesanan kuePesanan;
        kueBaru = kueInven;
        cout << "---PEMESANAN KUE---" << endl << endl;
        if(kueBaru.size() > 0) {
            while(kueBaru.size()) {
                cout << "Kue ke-" << i << endl;
                cout << "Nama Kue\t: " << kueBaru.top().nama << endl;
                cout << "Lapisan Kue\t: " << kueBaru.top().lapisan << endl;
                cout << "Toping Kue\t: " << kueBaru.top().toping << endl;
                cout << "Harga Kue\t: " << kueBaru.top().harga << endl;
                cout << "Stock\t\t: " << kueBaru.top().total << endl << endl;
                kueBaru.pop(); ++i;
            }
            kueBaru = kueInven;
            cout << "Pilih kue ke\t: "; cin >> pilih1;
            if(pilih1 > 0 && pilih1 <= kueInven.size()) {
                for(i = 0; i < kueInven.size(); i++) {
                    if(i==pilih1-1) {
                        if(kueBaru.top().total > 0) {
                            kuePesanan.namaPembeli = "member";
                            kuePesanan.namaKue = kueBaru.top().nama;
                            do {
                                cout << "Jumlah yang dipesan\t: "; cin >> jumlah;
                                if(jumlah > 0 && jumlah <= kueBaru.top().total) {
                                    kueBaru.top().total = kueBaru.top().total - jumlah;
                                    kuePesanan.totalHarga = kueBaru.top().harga * jumlah;
                                    kuePesanan.totalKue = jumlah;
                                    daftarPesanan.push(kuePesanan);
                                    stat = true;
                                    break;
                                }
                                cout << "Jumlah pesanan melebihi stock" << endl << endl; Sleep(500);
                            } while(true);
                        } else {
                            cout << "Stock kue sedang tidak ada" << endl;
                        }
                    }
                    kueSisa.push(kueBaru.top());
                    kueSave.push(kueBaru.top());
                    kueBaru.pop();
                }
                kueInven = kueSisa;
                kueSimpan = kueSave;
                if(stat) {
                    cout << "Berhasil memesan kue " << kuePesanan.namaKue << endl;
                }
                stat = false;
            } else {
                cout << "Pilihanmu tidak ada dimenu" << endl;
            }
        } else {
            cout << "Belum ada kue" << endl;
        }
        cout << "Ingin memesan lagi (y/n) ? "; cin >> pilih;
        if(pilih == 'n' || pilih == 'N') break;
    } while(true);
}

void menuKonfirmasiKue() {
    char beli;
    queue<pesanan> kueKonfirmasi;
    kueKonfirmasi = daftarPesanan;
    cout << "---KONFIRMASI PEMESANAN KUE---" << endl << endl;
    cout << "Daftar Pesanan yang belum di bayar" << endl << endl;
    while(kueKonfirmasi.size()) {
        cout << "Nama Kue\t: " << kueKonfirmasi.front().namaKue << endl;
        cout << "Total Pembelian\t: " << kueKonfirmasi.front().totalKue << " @ " << kueKonfirmasi.front().totalHarga / kueKonfirmasi.front().totalKue << endl;
        cout << "Harga Kue Total\t: " << kueKonfirmasi.front().totalHarga << endl << endl;
        cout << "Konfirmasi Pembayaran\t (y/n) : "; cin >> beli;
        if(beli == 'y' || beli == 'Y') {
            daftarKonfirmasi.push(kueKonfirmasi.front());
            cout << "....Sedang di proses...." << endl; Sleep(500);
            daftarPesanan.pop();
        }
        kueKonfirmasi.pop();
        cout << "Ingin lanjut\t(y/n) : "; cin >> beli;
        if(beli == 'n' || beli == 'N') break;
    }
}

void menuRiwayatPesanan() {
    int i = 1;
    unsigned long long int total = 0;
    stack<pesanan> pelanggan;
    pelanggan = pelangganToko;
    cout << "---Riwayat Pemesanan---" << endl;
    if(pelanggan.size() > 0) {
        while(pelanggan.size()) {
            cout << "Pelanggan ke-" << i << endl;
            cout << "Kue\t\t: " << pelanggan.top().totalKue << " " << pelanggan.top().namaKue << endl;
            cout << "Total Biaya\t: " << pelanggan.top().totalHarga << endl;
            cout << endl; total += pelanggan.top().totalHarga;
            ++i; pelanggan.pop();
        }
        cout << "Total Belanja terakhir\t: " << total << endl;
    } else {
        cout << "Belum ada riwayat transaksi pemesanan kue" << endl;
    }
}

void menuIsiSaldo() {
    cout << "ISI SALDO USER" << endl;
    cout << "nothing here" << endl;
}

void logout() {
    system(0);
}

void homeMenu() {
    cout << "\t\t=========================" << endl;
    cout << "\t\t----Toko MoHCAKe V0.1----" << endl;
    cout << "\t\t=========================" << endl << endl;
}

void menuUtama(string level = "") {
    if(level != "" ){
        if(level=="ADMIN") {
            cout << "1. Membuat Kue" << endl;
            cout << "2. Stock Kue" << endl;
            cout << "3. Pesanan Kue" << endl;
            cout << "4. Kirim Kue" << endl;
            cout << "5. Riwayat Pelanggan" << endl;
            cout << "6. Keluar" << endl << endl;
        } else if(level=="MEMBER") {
            cout << "1. Memesan Kue" << endl;
            cout << "2. Konfirmasi Kue" << endl;
            cout << "3. Riwayat Pemesanan" << endl;
            cout << "4. Isi Ulang Saldo" << endl;
            cout << "5. Keluar" << endl << endl;
        } else {
            cout << "Who are you?";
        }
    } else {
        cout << "You don't have access!" << endl;
    }
}

void pilihMenu(string level, int menu) {
    if(level == "ADMIN") {
        switch(menu) {
            case 1:
                menuBuatKue();
                break;
            case 2:
                menuStockKue();
                break;
            case 3:
                menuLihatPesanan();
                break;
            case 4:
                menuKirimPesanan();
                break;
            case 5:
                menuRiwayatPelanggan();
                break;
            case 6:
                logout();
                break;
            default:
                cout << "Salah pilih menu!" << endl;
        }
    } else if(level == "MEMBER") {
        switch(menu) {
            case  1:
                menuPesanKue();
                break;
            case 2:
                menuKonfirmasiKue();
                break;
            case 3:
                menuRiwayatPesanan();
                break;
            case 4:
                menuIsiSaldo();
                break;
            case 5:
                logout();
                break;
            default:
                cout << "Salah pilih menu!" << endl;
        }
    } else {
        cout << "You don't have access!" << endl;
    }
}

int main()
{
    string username, password;
    int pilih;
    char menu;
    bool state = true;
    do {
        user member;
        homeMenu();
        cout << "\t\t" << "USERNAME\t: "; cin >> username;
        cout << "\t\t" << "PASSWORD\t: "; cin >> password;
        system("cls||clear");
        if(username == "admin" && password == "123456") {
            do {
                homeMenu();
                cout << "Selamat datang, Pemilik!" << endl << endl;
                menuUtama("ADMIN");
                cout << "Pilih Menu\t: "; cin >> pilih;
                pilihMenu("ADMIN", pilih);
                cout << "\n\t\tKembali (y/n)? ";cin >> menu;
                system("cls"); Sleep(200);
                if(menu == 'n' || menu == 'N') state = false;
            } while(state);
        } else if(username == "member" && password == "654321") {
            do {
                homeMenu();
                cout << "Selamat datang, Pelanggan!" << endl << endl;
//                cout << "Saldo saat ini\t: " << 5000000 << endl;
                menuUtama("MEMBER");
                cout << "Pilih Menu\t: "; cin >> pilih;
                pilihMenu("MEMBER", pilih);
                cout << "\t\tKembali (y/n)? "; cin >> menu;
                system("cls"); Sleep(500);
                if(menu == 'n' || menu == 'N') state = false;
            } while(state);
        } else {
            homeMenu();
            cout << "\t\tGagal Login!" << endl;
            cout << "\n\t\tKembali (y/n)? ";cin >> menu;
            if(menu =='n' || menu == 'N') break;
        }
        system("cls||clear");
        state = true;
    } while(true);
    return 0;
}
