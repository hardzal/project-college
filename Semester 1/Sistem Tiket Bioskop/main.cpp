#include<iostream>
#include<conio.h>
#include<iomanip>
#include<windows.h>
using namespace std;
/*===================================
 // Tugas Kelompok Algoritma dan Pemrograman I
 // Kelompok 8 => Sistem Tiket Bioskop
 // Anggota :
 // - Shafna Aulia (123170012)
 // - Novridha Dwitia P (123170019)
 // - M Rizal (123170036)
 // (DEMO PROJECT: 29 November 2017)
 // (FINAL RESULT: 30 November 2017)
 // Masih banyak yang kurang.
===================================*/
bool log, logform, settle[100][100];
int row, column, baris, kolom;
char t[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
char isi[3], kosong[3];
string message, titles(int pages);
string noTiket[100][100], nameBuyer[100][100];
void header(string pageTitle, int size);
void login(string username, string password);
void inputSettlePlace(int row, int column);
void menuPrimary(), menuInputSettle(), tiketBuy(), tiketList(), errorPage();

int main(){
	string username, password = "";
	int options, opt;
	do{
		login(username, password);
		Sleep(400);
		do{
			if(log){
				cout << endl << setfill('-') << setw(35) << message << setfill('-') << setw(15) << "\n";
				Sleep(600);
				system("cls||clear");
				do{
					menuPrimary();
					cout << "Pilih Menu : "; cin >> options;
					system("cls||clear");
					switch(options){
						case 1:
							menuInputSettle();
							inputSettlePlace(row, column);
						break;
						case 2:
							tiketBuy();
						break;
						case 3:
							tiketList();
						break;
						case 4:
							exit(0);
						break;
						default:
							errorPage();
					}
					cout << "\nPILIHAN MENU :\n1. MENU UTAMA\n2. EXIT" << endl;
					cout << "Pilih\t: "; cin >> opt;
					system("cls");
					if(opt == 1){
						continue;
					}else{
						exit(0);
					}
				}while(opt==1);
			}
		}while(log);
		if(log==0){
			cout << endl << setfill('-') << setw(35) << message << setfill('-') << setw(15) << "\n";
			Sleep(600);
			cout << setfill('-') << setw(35) << "BACK TO LOGIN FORM" << setfill('-') << setw(15) << "\n";
			Sleep(1200);
			system("cls||clear");
			logform = true;
		}else{
			logform = false;
			exit(0);
		}
	}while(logform);
	return 0;
}

string titles(int pages){
	string title;
	if(pages == 1){
		title = "LOGIN";
	}else if(pages == 2){
		title = "MENU";
	}else if(pages == 3){
		title = "INPUT TEMPAT DUDUK";
	}else if(pages == 4){
		title = "BELI TIKET";
	}else if(pages == 5){
		title = "DAFTAR TIKET";
	}else{
		title = "ERROR PAGE";
	}
	return title;
}

void header(string pageTitle, int size){
	string pageTitles = pageTitle;
	cout << setfill('-') << setw(40) << "Program Tiket Bioskop" << setfill('-') << setw(20) << "\n";
	cout << setfill('=') << setw(60) << "\n";
	cout << setfill('-') << setw(30+size) << pageTitles << setfill('-') << setw(30-size) << "\n";
	cout << setfill('=') << setw(60) << "\n";
	cout << endl << endl;
}

void login(string username, string password){
	int pages = 1;
	int size = 0;
	int limit = 0;
	char pass;
	header(titles(pages), size);
	cout << setfill(' ') << setw(17) << "USERNAME\t: "; getline(cin, username);
	cout << endl;
	cout << setfill(' ') << setw(17) << "PASSWORD\t: "; //getline(cin, password);

	while(pass != '\r'){ // selama bukan menekan enter
		pass = _getch();
		if(pass == '\b'){ // jika tombol 'Backspace' ditekan
			if(password.size() != 0){ // jika string password sudah mengandung nilai maka hapus karakter terakhir
				cout << "\b \b";
           		password.erase(password.size() - 1, 1); // parameter pertama adalah posisi karakter yang akan dihapus parameter kedua panjang karakter yang akan dihapus
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
	if((username=="admin")&&(password=="password")){
		message = "LOGIN BERHASIL!!";
		log = 1;
	}else{
		message = "LOGIN SALAH!!";
		log = 0;
	}
}

void menuPrimary(){
	int pages = 2;
	int size = 0;
	header(titles(pages), size);
	cout << "1. INPUT TEMPAT DUDUK" << endl;
	cout << "2. BELI TIKET" << endl;
	cout << "3. DAFTAR TIKET" << endl;
	cout << "4. EXIT" << endl;
}

void menuInputSettle(){
	int pages = 3;
	int size = 10;
	int ops;
	bool check = (row!=0)&&(column!=0);
	header(titles(pages), size);

	while(check){
		cout << "Apa Kamu Yakin Ingin Mengganti Data Tempat Duduk Bioskop?\n";
		cout << "1. Ya\n2. Tidak\nPilih\t: ";
		cin >> ops;
		switch(ops){
			case 1:
				check = 0;
				break;
			case 2:
				check = 1;
				break;
			default:
				errorPage();
		}
		cout << endl;
		if(check) break;
	}
	if(!check){
		cout << "Jumlah Baris\t : "; cin >> row;
		cout << "Jumlah Kolom\t : "; cin >> column; cin.ignore();
		cout << "Tanda Kosong\t : "; cin.getline(kosong, sizeof(kosong));
		cout << "Tanda Isi\t : "; cin.getline(isi, sizeof(isi));
		cout << "\nTerima kasih telah mengisi data!\n";
	}
}

void inputSettlePlace(int row, int column){
	if(sizeof(kosong)!=0){
		for(int i=1; i<=row; i++){
			for(int j=1; j<=column; j++){
				settle[i][j] = 0;
			}
		}
	}
}

void tiketBuy(){
	int pages = 4;
	int size = 7;
	bool status;
	int tiketMany;
	char tiket[5];
	string warn = "";
	string name;
	header(titles(pages), size);

	if((row!=0)&&(column!=0)){
		cout << "Jumlah Pesanan Tiket:\t"; cin >> tiketMany;
		cin.ignore();

		for(int x = 1; x <= tiketMany; x++){
			cout << setfill('-') << setw(50) << "\n" << endl;
			cout << "Pemesan ke-" << x << endl;
			cout << "Lihat Tempat Duduk :\n" << row << " x "  << column << " (Harap Memasukkan Baris dan Kolom Sesuai Yang Tersedia)";
			cout << "\n\n";
			cout << setfill(' ') << setw(10);
			for(int i=1; i<=row; i++){
				cout << "[" << i << "]"<< setfill(' ') << setw(6);
			}
			cout << "\n\n";
			for(int i=1; i<=row; i++){
				cout << "[" << i << "]"<< setfill(' ') << setw(4);
				for(int j=1; j<=column; j++){
					cout << "[" << t[i-1] << j << "](";
					if(settle[i][j]==1){
						cout <<  isi;
					}else{
						cout << kosong;
					}
					cout << ")" << setfill(' ') << setw(3);
				}
				cout << "\n\n";
			}

			do{
				if(warn!="") cout << "\n" << warn << "\n\n";
				cout << "Pilih\t (No Tiket Sesuai Baris dan Kolom) :\n";
				cout << "  Baris ke-"; cin >> baris;
				cout << "  Kolom ke-"; cin >> kolom;

				if((baris>row)||(kolom>column)||(settle[baris][kolom]==1)){
					warn = "Maaf, baris dan kolom telah dipesan atau tidak tersedia";
					status = true;
				}else{
					status = false;
				}
			}while(status);
			cin.ignore();
			cout << "Input Data\n";
			cout << "  No.Tiket\t: "; cin.getline(tiket, sizeof(tiket));
			cout << "  Nama\t\t: ";  getline(cin, name);
			settle[baris][kolom] = 1;
			noTiket[baris][kolom] = tiket;
			nameBuyer[baris][kolom] = name;

		}
		cout << "\nTerima kasih telah membeli tiket! :D" << endl;
	}else {
		cout << "Maaf, input data tempat duduk belum dijalankan\n";
	}
}

void tiketList(){
	int pages = 5;
	int size = 8;
	header(titles(pages), size);
	if((row!=0)&&(column!=0)){
		if((baris!=0)&&(kolom!=0)){
			cout << "|\tNO. Tiket\t|\tNama\t|   No. Tempat Duduk\t|\n";
			cout << setfill('-') << setw(70) << "\n";

			for(int i=1; i<=row; i++){
				for(int j=1; j<=column; j++){
					if(settle[i][j]==1){
						cout << "|\t" << noTiket[i][j] << "\t\t|\t" << nameBuyer[i][j] << "\t|\t["<< i << ", " << j << "]\t\t|" << endl;
					}
				}
			}
		}else{
			cout << "Data pemesan belum tersedia!\n";
		}
		cout << endl << "Tempat Duduk\t: " << endl << endl;

		cout << setfill(' ') << setw(10);
		for(int i=1; i<=row; i++){
			cout << "[" << i << "]"<< setfill(' ') << setw(6);
		}
		cout << "\n\n";
		for(int i=1; i<=row; i++){
			cout << "[" << i << "]"<< setfill(' ') << setw(4);
			for(int j=1; j<=column; j++){
				cout << "[" << t[i-1] << j << "](";
				if(settle[i][j]==1){
					cout <<  isi;
				}else{
					cout << kosong;
				}
				cout << ")" << setfill(' ') << setw(3);
			}
			cout << "\n\n";
		}
	}else{
		cout << "Data pemesan tempat duduk belum tersedia\n";
	}
}

void errorPage(){
	int pages = 99;
	int size = 0;
	header(titles(pages), size);
}

