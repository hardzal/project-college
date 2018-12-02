#include<iostream>
#include<malloc.h> // malloc untuk bahasa c sedangkan new untuk bahasa c++
#include<fstream>
#include<stdlib.h>
using namespace std;
// pewoeder // inorder // postoreder
// implementasi binary search tree
typedef struct {
    int noMhs;
	char nama[100];
	float uts, uas, akhir;
} dataMahasiswa;

typedef struct mahasiswa *nilaiMahasiswa;
struct mahasiswa {
    dataMahasiswa mhs;
	nilaiMahasiswa kiri, kanan;
};

nilaiMahasiswa dataNilai, currentNilai, parentNilai;
ofstream dataMhsBaru;
ifstream dataMhsLama;
// bool cari = false;

void createBST() {
    dataNilai = NULL;
}

void insertData(dataMahasiswa tempMahasiswa) {
    dataMhsBaru.open("dataMahasiswa.txt", ios::binary|ios::app);
    if(dataMhsBaru.is_open()) {
        dataMhsBaru.write((char *) &tempMahasiswa, sizeof(tempMahasiswa));
        dataMhsBaru.close();
    } else {
        cout << "Gagal menyimpan kedalam file" << endl;
    }
}

void insertNode(nilaiMahasiswa nilaiMhs, dataMahasiswa info) {
    nilaiMahasiswa newNilai;
    //newNilai = (mahasiswa *) malloc(sizeof(mahasiswa));
    newNilai = new mahasiswa;
    newNilai->mhs = info;
    newNilai->kiri = NULL;
    newNilai->kanan = NULL;

    if(dataNilai == NULL) {
        dataNilai = newNilai;
    } else {
        parentNilai = nilaiMhs;
        currentNilai = nilaiMhs;
        while(currentNilai!=NULL && info.noMhs!=currentNilai->mhs.noMhs){
            parentNilai=currentNilai;
			 if (info.noMhs < currentNilai->mhs.noMhs)
				currentNilai=parentNilai->kiri;
			 else
				currentNilai=parentNilai->kanan;
        }
        if(info.noMhs == parentNilai->mhs.noMhs) {
            cout << "Node " << info.noMhs << " sudah ada " << endl;
        } else {
            if(info.noMhs < parentNilai->mhs.noMhs) {
                parentNilai->kiri = newNilai;
            } else {
                parentNilai->kanan = newNilai;
            }
        }
    }
}

void preorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
        preorder(nilai->kiri);
        preorder(nilai->kanan);
    }
}

void inorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        inorder(nilai->kiri);
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
        inorder(nilai->kanan);
    }
}

void postorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        postorder(nilai->kiri);
        postorder(nilai->kanan);
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
    }
}

void hapus() {
    nilaiMahasiswa temp;
// Bila PTB terdiri dari akar saja atau akar dengan 1 anak kiri/kanan
  if (currentNilai->kiri==NULL && currentNilai->kanan==NULL)
	  {
		 if (parentNilai==dataNilai && currentNilai==dataNilai)
			 dataNilai=NULL;
		 else
			 {
				if (currentNilai==parentNilai->kiri)
					parentNilai->kiri=NULL;
				else
					parentNilai->kanan=NULL;
			 }
			 // using free if use malloc
		delete currentNilai;
		}
// Bila PTB memiliki anak kiri dan anak kanan dgn banyak anak cabang
  else if (currentNilai->kiri!=NULL && currentNilai->kanan!=NULL)
	  {
		 temp=currentNilai->kiri;
		 parentNilai=currentNilai;
		 while (temp->kanan != NULL)
			{ parentNilai=temp;
			  temp=temp->kanan; }
		 currentNilai->mhs=temp->mhs;
		 if (parentNilai==currentNilai)
			 parentNilai->kiri = temp->kiri;
		 else
			 parentNilai->kanan = temp->kiri;
		 delete temp;
	  }
// Bila PTB memiliki anak kiri saja dgn banyak anak cabang
  else if (currentNilai->kiri!=NULL && currentNilai->kanan==NULL)
	  {
		 if (parentNilai==currentNilai)
			 dataNilai=currentNilai->kiri;
		 else
			{ if (currentNilai==parentNilai->kiri)
				  parentNilai->kiri=currentNilai->kiri;
			  else
				  parentNilai->kanan=currentNilai->kiri;
			}
		 delete currentNilai;
	  }
// Bila PTB memiliki anak kanan saja dgn banyak anak cabang
  else if (currentNilai->kiri==NULL && currentNilai->kanan!=NULL)
	  {
		 if (parentNilai==currentNilai)
			 dataNilai=currentNilai->kanan;
		 else
			{ if (currentNilai==parentNilai->kanan)
				  parentNilai->kanan=currentNilai->kanan;
			  else
				  parentNilai->kiri=currentNilai->kanan;
			}
		 delete currentNilai;
	  }
}

void hapusNode(nilaiMahasiswa mhsNilai, dataMahasiswa data)
{
  if (dataNilai == NULL)
	  cout << "PTB Kosong !\n\n";
  else
    {
        if(mhsNilai == NULL) {
            cout << "\nData tidak ditemukan!" << endl;
        } else if(data.noMhs < mhsNilai->mhs.noMhs) {
            hapusNode(mhsNilai->kiri, data);
        } else if(data.noMhs > mhsNilai->mhs.noMhs) {
            hapusNode(mhsNilai->kanan, data);
        } else if(data.noMhs == mhsNilai->mhs.noMhs) {
            parentNilai=dataNilai;
            currentNilai=dataNilai;
            // mencari tempat hapus node
            while(currentNilai!=NULL && data.noMhs!=currentNilai->mhs.noMhs)
            {
                parentNilai = currentNilai;
                if (data.noMhs < currentNilai->mhs.noMhs) {
                    currentNilai=parentNilai->kiri;
                } else {
                    currentNilai=parentNilai->kanan;
                }
            }
            hapus();
        }
    }
}

void updateNode(dataMahasiswa data) {}

void showSearch(dataMahasiswa data) {
    cout << "Mahasiswa dengan NIM " << data.noMhs << " ditemukan" << endl;
    cout << "\nNama\t\t: " << data.nama << endl;
    cout << "Nilai UTS\t: " << data.uts << endl;
    cout << "Nilai UAS\t: " << data.uas << endl;
    cout << "Nilai Akhir\t: " << data.akhir << endl;
}

void search(nilaiMahasiswa mhsNilai,dataMahasiswa data) {
    if(mhsNilai == NULL) {
        cout << "\nData tidak ditemukan!" << endl;
    } else if(data.noMhs < mhsNilai->mhs.noMhs) {
        search(mhsNilai->kiri, data);
    } else if(data.noMhs > mhsNilai->mhs.noMhs) {
        search(mhsNilai->kanan, data);
    } else if(data.noMhs == mhsNilai->mhs.noMhs) {
        data = mhsNilai->mhs;
        showSearch(data);
    }
}

int totalNode(nilaiMahasiswa nilaiMhs) {
 if(nilaiMhs != NULL) {
    return totalNode(nilaiMhs->kiri) + totalNode(nilaiMhs->kanan) + 1;
 }
 return 0;
}

int heightTree(nilaiMahasiswa nilaiMhs) {
    if(nilaiMhs == NULL) {
        return 0;
    } else {
        int left = heightTree(nilaiMhs->kiri);
        int right = heightTree(nilaiMhs->kanan);
        if(left > right) {
            return left+1;
        } else {
            return right+1;
        }
    }
}

void printNode() {
    char pilih;
    do {
        int
         total = totalNode(dataNilai);
        int tinggiPohon = heightTree(dataNilai);
        if(total) {
            cout << "Total Node\t: " << total << endl;
            cout << "Tinggi Pohon\t: " << tinggiPohon << endl;
            cout << "1. Pre-order\n2. In-order\n3. Post-order\nPilih\t: ";
            cin >> pilih;
            switch(pilih) {
                case '1':
                    cout << endl << "Pre-order : " << endl;
                    preorder(dataNilai);
                    break;
                case '2':
                    cout << endl << "In-order : " << endl;
                    inorder(dataNilai);
                    break;
                case '3':
                    cout << endl << "Post-order : " << endl;
                    postorder(dataNilai);
                    break;
                default:
                    cout << "Pilihanmu tidak ada dimenu" << endl;
            }
        } else {
            cout << "Belum ada node" << endl;
        }
        cout << "Ingin kembali ke menu (y/n) ?\t: "; cin >> pilih;
        if(pilih == 'n'|| pilih=='N') break;
     } while(true);
    return;
}

bool searchData(dataMahasiswa mhs) {
    bool find = false;
    dataMahasiswa dataMhs;
    ifstream readFile;
    readFile.open("dataMahasiswa.txt", ios::binary);
    while(readFile.read((char *) &dataMhs, sizeof(dataMhs))) {
        if(mhs.noMhs == dataMhs.noMhs) {
            readFile.close();
            return true;
        }
    }
    readFile.close();
    return false;
}

void readData() {
    dataMhsLama.open("dataMahasiswa.txt", ios::binary);
    dataMahasiswa mahasiswaLama;
    if(!dataMhsLama.fail()) {
        while(dataMhsLama.read((char *) &mahasiswaLama, sizeof(mahasiswaLama))) {
            insertNode(dataNilai, mahasiswaLama);
        }
        dataMhsLama.close();
    }
}

void deleteData(dataMahasiswa mhs) {
    dataMahasiswa mhsNilai;
    ifstream readFile;
    readFile.open("dataMahasiswa.txt", ios::binary);
    ofstream writeFile;
    writeFile.open("tmp.txt", ios::out|ios::binary);
    int find = 0;
    while(readFile.read((char *) &mhsNilai, sizeof(mhsNilai))) {
        if(mhsNilai.noMhs != mhs.noMhs) {
            writeFile.write((char *) &mhsNilai, sizeof(mhsNilai));
        } else {
            find = 1;
        }
    }
    readFile.close();
    writeFile.close();
    remove("dataMahasiswa.txt");
    rename("tmp.txt", "dataMahasiswa.txt");
    if(find) {
        cout << "\nMahasiswa dengan NIM " << mhs.noMhs << " telah dihapus" << endl;
    } else {
        cout << "\nMahasiwa dengan NIM " << mhs.noMhs << " tidak berhasil dihapus " << endl;
    }
}

void updateData(dataMahasiswa mhs) {}

int main() {
    char menu;
    dataMahasiswa mhsNilai;
    createBST();
    readData();
    do {
        cout << "---Implementasi Binary Search Tree dengan Struct---" << endl;
        cout << "-----------Data Mahasiswa-------------" << endl;

        cout << "MENU" << endl;
        cout << "1. INPUT DATA" << endl;
        cout << "2. OUTPUT DATA" << endl;
        cout << "3. DELETE DATA" << endl;
        cout << "4. SEARCH DATA" << endl;
        cout << "5. EXIT" << endl;
        cout << "Pilih\t: "; cin >> menu;
        switch(menu) {
            case '1':
                cout << "---INPUT DATA---" << endl;
                cout << "No Mahasiswa\t: "; cin >> mhsNilai.noMhs; cin.ignore();
                cout << "Nama\t\t: "; cin.getline(mhsNilai.nama, sizeof(mhsNilai.nama));//cin.getline(mhsNilai.nama, sizeof(mhsNilai.nama));
                cout << "Nilai UTS\t: "; cin >> mhsNilai.uts;
                cout << "Nilai UAS\t: "; cin >> mhsNilai.uas;
                mhsNilai.akhir = (0.4 *  mhsNilai.uts) + (0.6 * mhsNilai.uas);
                cout << "Nilai Akhir\t: " << mhsNilai.akhir << endl << endl;
                insertNode(dataNilai, mhsNilai);
                insertData(mhsNilai);
                cout << endl;
                break;
            case '2':
                printNode();
                break;
            case '3':
                if(totalNode(dataNilai)) {
                    cout << "Data yang ingin di hapus\t: "; cin >> mhsNilai.noMhs;
                    hapusNode(dataNilai, mhsNilai);
                    deleteData(mhsNilai);
                } else {
                    cout << "Data belum tersedia!" << endl;
                }
                break;
            case '4':
                cout << "Cari data mahasiswa\t: " << endl;
                cout << "Cari NIM\t: "; cin >> mhsNilai.noMhs;
                search(dataNilai, mhsNilai);
                break;
            case '5':
                exit(EXIT_SUCCESS);
                break;
            default:
                cout << "Salah pilih menu" << endl;
        }
        cout << endl << "Ingin kembali ke menu utama? (y/n)\t: "; cin >> menu;
        if(menu == 'n'||menu=='N') break;
        system("cls");
    } while(true);
    delete[] dataNilai;
    return 0;
}
