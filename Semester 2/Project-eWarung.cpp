// 	123170032->Rifky Izha Salasta (Supports)
//  123170036->M Rizal (Creator)
// Sistem e-Warung
#include<iostream>
#include<iomanip>
#include<conio.h>
#include<string.h>
#include<windows.h>
#include<fstream>
#define DATA_USER "DATA-USER.dat"
#define DATA_BARANG "DATA-BARANG.dat"
#define DATA_HISTORY "DATA-HISTORY.dat"
using namespace std;

typedef struct {
	char username[32], password[32], nama[100], email[32], alamat[255], noHp[13];
	char jKelamin, level;
	long double saldo;
} data;

typedef struct {
	char namaBarang[100], kategoriBarang[100];
	int stok;
	int idBarang;
	long double hargaBarang;
} inventory;

typedef struct {
	char namaBarang[100], kategoriBarang[100], username[32], nama[100], alamat[255];
	int stok;
	int idBarang;
	long double totalHargaBarang;
}activity;

/* meta data */
bool log;
string message;
char level;
char levelUser[12], usernameG[32];
void headerPage(string pTitle);
string titlePage(int pNumber);

/* Main Menu */
void showMenu();
void showMenu(char);
void indexPage();
void login();
void registrasi();
void pesanBarang();
void pesanBarang(int);
void tampilBarang();
void tampilBarang(inventory);
void searchBarang();
void qSortBarang(inventory barang, int first, int last);

/* Menu Admin */
void tambahBarang();
void hapusBarang();
void editBarang();
void showAkun();
void editAkun();
void sortAkun();
void reportCase();
void logActivity();
void errorPage();
void akunInfo(data*);

int main() {
	int choose, p;
	char c;
	do {
		indexPage();
		do {
			if(log) {
				cout << endl << setfill('-') << setw(35) << message << setfill('-') << setw(15) << "\n";
				Sleep(600);
				system("cls");
				showMenu();
				cout << "Pilih\t : ";  cin >> choose;
				switch(choose) {
					case 1:
						int idB;
						tampilBarang();
						cout << "\nPilih Barang\t: "; cin >> idB; cin.ignore();
						pesanBarang(idB);
						break;
					case 2:
						pesanBarang();
						break;
					case 3:
						searchBarang();
						break;
					case 4:
					//	sortBarang();
						break;
					case 5:
						logActivity();
						break;
					case 6:
						do {
                            system("cls");
							showMenu(level);
							level == 'a' ? strcpy(levelUser, "admin") : strcpy(levelUser, "member");
							cout << "---Menu " << levelUser << "---" << endl;
							switch(level) {
								case 'a':
								    cout << "Pilih Menu\t: "; cin >> p;
									switch(p) {
										case 1:
											tampilBarang();
											break;
										case 2:
											tambahBarang();
											break;
										case 3:
											editBarang();
											break;
										case 4:
											hapusBarang();
											break;
										case 5:
											showAkun();
											break;
										case 6:
											reportCase();
											break;
										case 97:
											logActivity();
											break;
										default:
											if(p==98) break;
											errorPage();
									}
									break;
								case 'u':
                                    cout << "Pilih Menu\t: "; cin >> p;
									switch(p) {
										case 1:
											editAkun();
											break;
										case 97:
											logActivity();
											break;
										default:
											if(p==98) break;
											errorPage();
									}
									break;
									default:
										exit(0);
							}
							cout << "Kembali ke menu ? (y/n)\t: "; cin >> c;
							if(c=='Y' || c=='y'){ message = "INDEX"; }
							else break;
						} while(true);
						break;
					case 7:
						exit(0);
						break;
					default:
						errorPage();
				}
			}
			if(log==0) break;
            cout << "Kembali ke menu awal ? (y/n)\t: "; cin >> c;
            if(c=='Y' || c=='y'){ message = "INDEX";  }
            else if(c=='n' || c=='N'){ exit(0); }
		}while(log);
		if(!log) {
			cout << endl << setfill('-') << setw(35) << message << setfill('-') << setw(15) << "\n";
			Sleep(600);
			cout << setfill('-') << setw(35) << "BACK TO LOGIN FORM" << setfill('-') << setw(15) << "\n";
			Sleep(1200);
			system("cls");
		} else {
			exit(0);
		}
	} while(true);
}

void headerPage(string pTitle) {
	string pageTitle = pTitle;
	cout << setfill('=') << setw(60) << "\n";
	cout << setfill('-') << setw(40) << " ~eWarung Console App~" << setfill('-') << setw(20) << "\n";
	cout << setfill('-') << setw(35) << " Version 1.0 " << setfill('-') << setw(25) << "\n";
	cout << setfill('-') << setw(30) << pageTitle << setfill('-') << setw(30) << "\n";
	cout << setfill('=') << setw(60) << "\n";
	cout << endl;
}

string titlePage(int pNumber) {
	string title[] = {"INDEX", "LOGIN", "REGISTER", "DASHBOARD", "PEMESANAN", "PEMBELIAN", "PEMBAYARAN", "INPUT BARANG", "UPDATE BARANG", "HAPUS BARANG", "STOK BARANG",  "SEARCHING BARANG", "SORTING BARANG", "LAPORAN KEUANGAN", "DATA MEMBER", "HISTORY PEMBELIAN", "INFO BARANG", "UPDATE ACCOUNT", "ERROR 404"};
	return title[pNumber];
}

void showMenu() {
	headerPage(titlePage(0));
	int batas = 0;
	inventory barangTampil;
	ifstream outputBarang(DATA_BARANG);
	//outputBarang.open(DATA_BARANG, ios::app|ios::binary);
	level == 'a' ? strcpy(levelUser, "admin") : strcpy(levelUser, "member");
	cout << "Selamat Datang " << levelUser << "!\n" << endl;
	if(outputBarang) {
		cout << "---Tampil Barang Terakhir yang diMasukkan---\n";
	    while(outputBarang.read((char*)&barangTampil, sizeof(barangTampil))) {
	        batas++;
	    }
	    cout << "Total Barang Saat Ini\t: " << batas << " barang" << endl;
	} else
		cout << "Tidak ada barang!\n\n";

	cout << "1. PILIH BARANG\n";
	cout << "2. PESAN BARANG\n";
	cout << "3. SEARCHING BARANG\n";
	cout << "4. SORTING BARANG\n";
	cout << "5. HISTORY TRANSAKSI\n";
	cout << "6. DASHBOARD\n";
	cout << "7. EXIT\n";
}

void showMenu(char lvl) {
	headerPage(titlePage(3));
	level == 'a' ? strcpy(levelUser, "admin") : strcpy(levelUser, "member");
	cout << "Selamat Datang " << levelUser << "!\n" << endl;
	switch(lvl) {
		case 'a':
			cout << "1. TAMPIL BARANG\n";
			cout << "2. TAMBAH BARANG\n";
			cout << "3. EDIT BARANG\n";
			cout << "4. HAPUS BARANG\n";
			cout << "5. DAFTAR PEMBELI\n";
			cout << "6. LAPORAN TRANSAKSI\n";
			break;
		case 'u':
			cout << "1. EDIT AKUN\n";
			break;
		default:
			cout << "Salah Arah!\n";
	}
	cout << "97. ACTIVITY LOG\n";
	cout << "98. INDEX\n";
}

void indexPage() {
	int choose;
	headerPage(titlePage(0));
	cout << setw(30) << "Sudah Punya Akun ? (1) LOGIN / (2) REGISTER\n";
	cout << "Pilih\t: "; cin >> choose;
	cin.ignore();
	system("cls||clear");
	switch(choose) {
		case 1:
			login();
			break;
		case 2:
			registrasi();
			break;
		default:
			errorPage();
	}
}

void login() {
	string password;
	char pass, username[32];
	log = 0;
	data user;
	ifstream dataUser;
	dataUser.open(DATA_USER, ios::binary|ios::app);
	headerPage(titlePage(1));
	cout << setfill(' ') << setw(17) << "USERNAME\t: "; cin.getline(username, sizeof(username));
	cout << endl;
	cout << setfill(' ') << setw(17) << "PASSWORD\t: "; //getline(cin, password);
	while(pass != '\r'){
		pass = getch();
		if(pass == '\b'){
			if(password.size() != 0){
				cout << "\b \b";
           		password.erase(password.size() - 1, 1);
			}
			continue;
		}else if(pass <= '9' && pass >= '0' || pass >= 'a' && pass <= 'z' || pass >= 'A' && pass <= 'Z')
        {
	        password += pass;
	        cout << "*";
        }
	    else{
	        continue;
		}
	}
	cout << endl;
	char pw[32];
	strcpy(pw, password.c_str());
	while(dataUser.read((char*)&user, sizeof(user))) {
		if(!(strcmp(username, user.username)) && !(strcmp(pw, user.password))) {
            level = user.level;
            strcpy(usernameG, user.username);
			log = 1;
			message = "LOGIN BERHASIL!";
		}
	}

	if(!log) {
		message = "LOGIN SALAH!!";
	}

	dataUser.close();
}

void registrasi() {
	bool cari;
	string password;
	ofstream dataUserW;
	ifstream dataUserR;
	dataUserW.open(DATA_USER, ios::binary|ios::app);
	dataUserR.open(DATA_USER, ios::binary);
	data userAkunCheck, userAkunSave;
	char pass;
	headerPage(titlePage(2));
	do {
        cari = 0;
        cout << setfill(' ') << setw(17) << "EMAIL\t\t: "; cin.getline(userAkunSave.email, sizeof(userAkunSave.email));
        cout << endl;
        cout << setfill(' ') << setw(17) << "USERNAME\t\t: "; cin.getline(userAkunSave.username, sizeof(userAkunSave.username));
        cout << endl;
		while(dataUserR.read((char*)&userAkunCheck, sizeof(userAkunCheck))) {
			if(!(strcmp(userAkunCheck.username, userAkunSave.username))&&!(strcmp(userAkunCheck.email, userAkunSave.email))) {
				cari = 1;
				break;
			}
		}
		if(cari) cout << "\nMaaf Username atau Password telah terdaftar!\n";
	} while(cari);

	cout << setfill(' ') << setw(17) << "PASSWORD\t\t: "; //getline(cin, password);
	while(pass != '\r'){
		pass = getch();
		if(pass == '\b'){
			if(password.size() != 0){
				cout << "\b \b";
           		password.erase(password.size() - 1, 1);
			}
			continue;
		}else if(pass <= '9' && pass >= '0' || pass >= 'a' && pass <= 'z' || pass >= 'A' && pass <= 'Z')
        {
	        password += pass;
	        cout << "*";
        }
	    else{
	        continue;
		}
	}
	strcpy(userAkunSave.password, password.c_str());
	cout << endl << endl;
	cout << setfill(' ') << setw(20) << "NAMA LENGKAP\t: "; cin.getline(userAkunSave.nama, sizeof(userAkunSave.nama));
	cout << endl;
	cout << setfill(' ') << setw(26) << "JENIS KELAMIN (P/L)\t: "; cin >> userAkunSave.jKelamin;
	cout << endl;
	cout << setfill(' ') << setw(17) << "NO HP\t\t: "; cin >> userAkunSave.noHp; cin.ignore();
	cout << endl;
	cout << setfill(' ') << setw(17) << "ALAMAT\t\t: "; cin.getline(userAkunSave.alamat, sizeof(userAkunSave.alamat));
	cout << endl;
	cout << setfill(' ') << setw(17) << "SALDO\t\t: "; cin >> userAkunSave.saldo; // cin.ignore();
	cout << endl;
	// set level sebagai admin
	userAkunSave.level = 'a';
	//serAkunSave.level = 'u';
	dataUserW.write((char*)&userAkunSave, sizeof(userAkunSave));
	dataUserR.close();
	dataUserW.close();
	message = "Registrasi Berhasil!";
}

void errorPage() {
	headerPage(titlePage(18));
	cout << "404 Page!";
}

void tampilBarang() {
	inventory barangTampil;
	ifstream outputBarang(DATA_BARANG);
	//outputBarang.open(DATA_BARANG, ios::app|ios::binary);
	if(outputBarang) {
		cout << "---Tampil Barang Keseluruhan---\n";
	    while(outputBarang.read((char*)&barangTampil, sizeof(barangTampil))) {
	        cout << "ID Barang\t: " << barangTampil.idBarang << endl;
	        cout << "Nama Barang\t: " << barangTampil.namaBarang << endl;
	        cout << "Harga Barang\t: " << barangTampil.hargaBarang << endl;
	        cout << "Stok Barang\t: " << barangTampil.stok << " buah" << endl << endl;
	    }
	    outputBarang.close();
	} else cout << "\nTidak ada barang\n";
}

void tampilBarang(inventory barang) {
	cout << "\n---INFO BARANG LENGKAP " << barang.idBarang << " ---\n";
	cout << "ID Barang\t: " << barang.idBarang << endl;
    cout << "Nama Barang\t: " << barang.namaBarang << endl;
    cout << "Harga Barang\t: " << barang.hargaBarang << endl;
    cout << "Stok Barang\t: " << barang.stok << " buah" << endl;
    cout << "Kategori Barang\t: " << barang.kategoriBarang << endl << endl;
}

void pesanBarang(int idB) {
    fstream f;
    ifstream f_s;
    ofstream i_f;
    f.open(DATA_BARANG, ios::in|ios::out);
	inventory barang, barangUpdate;
	data user;
	activity transaksi;
	cout << "\n-==INPUT DATA PEMESAN==-\n";
	cout << "\tNama Pemesan\t: "; cin.getline(transaksi.nama, sizeof(transaksi.nama));
	cout << "\tJumlah Barang Yang di Pesan\t:  ";  cin >> transaksi.stok; cin.ignore();
	cout << "\tAlamat Yang Di Tuju\t: "; cin.getline(transaksi.alamat, sizeof(transaksi.alamat));

	while(f.read((char*)&barang, sizeof(barang))) {
		if(barang.idBarang == idB) {
			// Update Activity Transaksi
			transaksi.idBarang = barang.idBarang;
			transaksi.totalHargaBarang = barang.hargaBarang * transaksi.stok;
			strcpy(transaksi.namaBarang, barang.namaBarang);
			strcpy(transaksi.kategoriBarang, barang.kategoriBarang);
			strcpy(transaksi.username, usernameG);

			// Update Data Barang
			strcpy(barangUpdate.namaBarang, barang.namaBarang);
			strcpy(barangUpdate.kategoriBarang, barang.kategoriBarang);
			barangUpdate.idBarang = barang.idBarang;
            barangUpdate.hargaBarang = barang.hargaBarang;
            barangUpdate.stok = barang.stok - transaksi.stok;
			break;
		}
	}
    f.write((char*)&barangUpdate, sizeof(barangUpdate));
	i_f.open(DATA_HISTORY, ios::app|ios::binary);
	i_f.write((char*)&transaksi, sizeof(transaksi));
    f.close();
    i_f.close();
}

void searchBarang() {
	int p, idB;
	char namaBarang[100], kategoriBarang[100];
	bool ketemu;
	cout << "1. ID Barang\n";
	cout << "2. Nama Barang\n";
	cout << "3. Kategori Barang\n";
	cout << "Cari Berdasarkan\t: ";  cin >> p; cin.ignore();
	ifstream f;
	inventory barang, bKetemu;
	f.open(DATA_BARANG, ios::binary);
	switch(p) {
		case 1:
			cout << "Masukkan ID Barang\t: "; cin >> idB;
			cout << "\nMencari ID Barang " << idB << " ...\n\n";
			ketemu = 0;
			while(f.read((char*)&barang, sizeof(barang))) {
				if(barang.idBarang == idB) {
					tampilBarang(barang);
					ketemu = 1;
				}
			}
			if(ketemu != 1) {
				cout << "\nID Barang " << idB << " tidak ditemukan\n";
			}
			break;
		case 2:
			cout << "Masukkan Nama Barang\t: "; cin.getline(namaBarang, sizeof(namaBarang));
			cout << "\nMencari Nama Barang " << namaBarang << " ...\n\n";
			ketemu = 0;
			while(f.read((char*)&barang, sizeof(barang))) {
				if(strstr(barang.namaBarang, namaBarang)) {
					tampilBarang(barang);
					ketemu = 1;
				}
			}
			if(ketemu != 1) {
				cout << "\nNama Barang " << idB << " tidak ditemukan\n";
			}
			break;
		case 3:
			cout << "Masukkan Kategori Barang\t: "; cin.getline(kategoriBarang, sizeof(kategoriBarang));
			cout << "\nMencari Kategori Barang " << kategoriBarang << " ...\n\n";
			ketemu = 0;
			while(f.read((char*)&barang, sizeof(barang))) {
				if(strstr(barang.kategoriBarang, kategoriBarang)) {
					tampilBarang(barang);
					ketemu = 1;
				}
			}
			if(ketemu != 1) {
				cout << "\nKategori Barang " << idB << " tidak ditemukan\n";
			}
			break;
		default:
			errorPage();

	}
	f.close();
}

void tambahBarang() {
    headerPage(titlePage(7));
	int total;
	cout << "Total Barang Input\t: "; cin >> total;
	inventory barang[total]; cin.ignore();
	for(int i = 0; i < total; i++) {
        cout << "\nBarang ke-" << i+1 << endl;
		cout << "Nama Barang\t: "; cin.getline(barang[i].namaBarang, sizeof(barang[i].namaBarang));
		cout << "Harga Barang\t: "; cin >> barang[i].hargaBarang; cin.ignore();
		cout << "Stok Barang\t: "; cin >> barang[i].stok; cin.ignore();
		cout << "Kategori Barang\t: "; cin.getline(barang[i].kategoriBarang, sizeof(barang[i].kategoriBarang));
		barang[i].idBarang = i + (rand() % 1000);
	}
	ofstream inputBarang;
	inputBarang.open(DATA_BARANG, ios::app|ios::binary);
	inputBarang.write((char*)&barang, sizeof(barang));
	inputBarang.close();
	message = "INPUT BARANG BERHASIL!";
}

void editBarang() {
	system("cls");
    headerPage(titlePage(8));
    int idBarang, stokBarang, p;
    long double hargaBarang;
    char namaBarang[100], kategoriBarang[100];
	inventory barangUpdate, barangGanti;
	fstream updateBarang;
	updateBarang.open(DATA_BARANG, ios::in|ios::out );
    tampilBarang();
    cout << "Pilih Barang\t: "; cin >> idBarang;
    cout << "\n--Menu Edit Data Barang--\n\n";
    cout << "1. Nama Barang\n2. Harga Barang\n3. Stok Barang\n4. Kategori Barang\n5. Ubah Seluruhnya\n6. Kembali\n";
    cout << "Ubah Data Barang berdasarkan\t="; cin>>p; cin.ignore();
    while(updateBarang.read((char*)&barangUpdate, sizeof(barangUpdate))) {
    	if(barangUpdate.idBarang == idBarang) {
    		switch(p) {
    			case 1:
    				cout << "\nNama Barang\t: "; cin.getline(namaBarang, sizeof(namaBarang));
    				strcpy(barangGanti.namaBarang, namaBarang);
    				barangGanti.idBarang = idBarang;
    				barangGanti.hargaBarang = barangUpdate.hargaBarang;
    				barangGanti.stok = barangUpdate.stok;
    				strcpy(barangGanti.kategoriBarang, barangUpdate.kategoriBarang);
    				break;

    			case 2:
    				cout << "\nHarga Barang\t: "; cin >> hargaBarang;
    				barangGanti.hargaBarang = hargaBarang;
    				barangGanti.idBarang = idBarang;
    				strcpy(barangGanti.namaBarang, namaBarang);
    				barangGanti.stok = barangUpdate.stok;
    				strcpy(barangGanti.kategoriBarang, barangUpdate.kategoriBarang);
    				break;
    			case 3:
    				cout << "\nStok Barang\t: "; cin >> stokBarang;
    				barangGanti.stok = stokBarang;
    				barangGanti.hargaBarang = hargaBarang;
    				barangGanti.idBarang = idBarang;
    				strcpy(barangGanti.namaBarang, namaBarang);
    				strcpy(barangGanti.kategoriBarang, barangUpdate.kategoriBarang);
    				break;
    			case 4:
    				cout << "\nKategori Barang\t: "; cin.getline(kategoriBarang, sizeof(kategoriBarang));
    				strcpy(barangGanti.kategoriBarang, kategoriBarang);
    				barangGanti.hargaBarang = hargaBarang;
    				barangGanti.idBarang = idBarang;
    				strcpy(barangGanti.namaBarang, namaBarang);
    				barangGanti.stok = barangUpdate.stok;
    				break;
    			case 5:
    				cout << "\nNama Barang\t: "; cin.getline(barangGanti.namaBarang, sizeof(barangGanti.namaBarang));
    				cout << "\nHarga Barang\t: "; cin >> barangGanti.hargaBarang;
    				cout << "\nStok Barang\t: "; cin >> barangGanti.stok; cin.ignore();
    				cout << "\nKategori Barang\t: "; cin.getline(barangGanti.kategoriBarang, sizeof(barangGanti.kategoriBarang));
    				barangGanti.idBarang = idBarang;
    				break;
    			default:
    			    if(p==6) break;
    				errorPage();
			}
			int pos = - 1 * sizeof(barangGanti);
			updateBarang.seekp(pos, ios::cur);
			updateBarang.write((char*) &barangGanti, sizeof(barangGanti));
			updateBarang.close();
			break;
		}
	}
}

void hapusBarang() {
	system("cls");
    headerPage(titlePage(9));
    bool ketemu = 0;
    int idBarang, stokBarang, p;
    long double hargaBarang;
    char namaBarang[100], kategoriBarang[100];
    inventory barang, barangGanti;
	ifstream bacaBarang;
	bacaBarang.open(DATA_BARANG, ios::in|ios::out);
	ofstream tempBarang;
	tempBarang.open("TEMP-BARANG.dat", ios::out|ios::binary);
    tampilBarang();
    cout << "\n--Menu Hapus Data Barang--\n\n";
    cout << "1. ID Barang\n2. Harga Barang\n3. Kategori Barang\n4. Hapus Seluruhnya\n";
    cout << "Hapus Data Barang berdasarkan\t="; cin>>p;
	switch(p) {
		case 1:
			cout << "Pilih Barang\t: "; cin >> idBarang;
			while(bacaBarang.read((char*) &barang, sizeof(barang))) {
				if(barang.idBarang != idBarang) {
					tempBarang.write((char*)&barang, sizeof(barang));
				} else {
					ketemu = 1;
				}
			}
			if(ketemu == 1) cout << "Data Barang dengan ID Barang" << idBarang << " telah dihapus\n";
			break;
		case 2:
			cout << "Pilih Barang\t: "; cin >> hargaBarang;
			while(bacaBarang.read((char*) &barang, sizeof(barang))) {
				if(barang.idBarang != hargaBarang) {
					tempBarang.write((char*)&barang, sizeof(barang));
				} else {
					ketemu = 1;
				}
			}
			if(ketemu == 1) cout << "Data Barang dengan Harga Barang" << hargaBarang << " telah dihapus\n";
			break;
		case 3:
			cin.ignore();
			cout << "Pilih Barang\t: "; cin.getline(kategoriBarang, sizeof(kategoriBarang));
			while(bacaBarang.read((char*) &barang, sizeof(barang))) {
				if(strcmp(barang.kategoriBarang, kategoriBarang)) {
					tempBarang.write((char*)&barang, sizeof(barang));
				} else {
					ketemu = 1;
				}
			}
			if(ketemu == 1) cout << "Data Barang dengan Kategori Barang " << kategoriBarang << " telah dihapus\n";
			break;
		case 4:
			ketemu = 1;
			if(ketemu == 1) cout << "Keseluruhan Data Barang Berhasil di Hapus\n";
			break;
		default:
			errorPage();
	}
	if(ketemu!=1) cout << "Gagal Menghapus Barang!\n";
    bacaBarang.close();
	tempBarang.close();
	remove(DATA_BARANG);
	rename("TEMP-BARANG.dat", DATA_BARANG);
}

void sortBarang(inventory barang) {

}

void showAkun() {
	data user;
	ifstream userTampil;
	userTampil.open(DATA_USER, ios::binary|ios::app);
	if(userTampil) {
		cout << "---Tampil Data User Keseluruhan---\n";
	    while(userTampil.read((char*)&user, sizeof(user))) {
	    	if(user.level == 'u') {
				cout << "Username\t: " << user.username << endl;
		        cout << "Nama User\t: " << user.nama << endl;
		        cout << "Email Barang\t: " << user.email << endl;
		        cout << "Alamat\t\t: " << user.alamat << endl << endl;
		    }
	    }
	    userTampil.close();
	} else cout << "\nTidak ada pembeli\n";
}

void editAkun() {

}

void pesanBarang() {

}

void logActivity() {
 	activity user;
	ifstream userLog;
	int i=0;
	userLog.open(DATA_HISTORY, ios::binary|ios::app);
	if(userLog) {
		cout << "---Tampil Data User Keseluruhan---\n";
	    while(userLog.read((char*)&user, sizeof(user))) {
            if(level =='a') {
                cout << "Username\t: " << user.username << endl;
                cout << "Nama Pembeli\t: " << user.nama << endl;
                cout << "Nama Barang\t: " << user.namaBarang << endl;
                cout << "Jumlah Pesanan\t: " << user.stok << endl;
                cout << "Total Harga\t: " << user.totalHargaBarang << endl;
                cout << "Alamat\t\t: " << user.alamat << endl << endl;
            }
            if (!strcmp(user.username, usernameG)) {
                cout << "Nama Barang\t: " << user.namaBarang << endl;
                cout << "Jumlah Pesanan\t: " << user.stok << endl;
                cout << "Total Harga\t: " << user.totalHargaBarang << endl;
                cout << "Alamat\t\t: " << user.alamat << endl << endl;
            }
            i++;
	    }
	    if(i==0) cout << "\nTidak Ada Data Transaksi\n";
	    else cout << "\nTerdapat " << i << " Data Transaksi\n";
	    userLog.close();
	} else cout << "\nTidak ada pembeli\n";
}


void reportCase() {

}

